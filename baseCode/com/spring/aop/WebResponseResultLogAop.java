package com.spring.aop;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import util.CookiesUtil;
import util.RequestUtils;

public class WebResponseResultLogAop implements MethodInterceptor {
	public static final Logger logger = LoggerFactory.getLogger(WebResponseResultLogAop.class);
	public static String staticOssUrl = "http://staticoss.inte.chanapp.com";// GlobalConfigHelper.getInstance().getSysUrlDomain()
	// .getStaticOssUrl();
	public static String http_staticOssUrl = staticOssUrl;
	public static boolean isReplace = false;

	static {
		if (staticOssUrl.startsWith("https://")) {
			http_staticOssUrl = staticOssUrl.replaceFirst("https", "http");
			isReplace = true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] arguments = invocation.getArguments();
		String requestURI = "";
		String responseResult = "";
		String requestParams = "";
		String headers = "";
		boolean isHttps = true;
		long userId = 0;
		if (arguments != null && arguments.length > 0)
			for (Object argument : arguments) {
				if (argument instanceof HttpServletRequest) {
					HttpServletRequest request = (HttpServletRequest) argument;
					CookiesUtil cookiesUtil = CookiesUtil.getInstance();
					requestURI = request.getRequestURI();
					requestParams = RequestUtils.getParams(request);
					headers = RequestUtils.getHeaders(request);
					userId = cookiesUtil.getUserId(request);
					if (isReplace) {
						String requestURL = request.getRequestURL().toString();
						logger.info("appVersion={}", cookiesUtil.getCurVersion(request));
						if (!cookiesUtil.isHttps(request) && requestURL.contains("/rest/")) {
							isHttps = false;
						}
						logger.info("isHttps={}", isHttps);
					}
					break;
				}
			}
		long s = System.currentTimeMillis();
		Object result = invocation.proceed();
		long e = System.currentTimeMillis();
		try {
			if (result instanceof HttpEntity) {
				ResponseEntity<String> entity = (ResponseEntity<String>) result;
				logger.info("isReplace={},isHttps={}", isReplace, isHttps);
				if (isReplace && !isHttps) {
					entity = new ResponseEntity<String>(entity.getBody().replaceAll(staticOssUrl, http_staticOssUrl),
							entity.getHeaders(), entity.getStatusCode());
					result = entity;
				}
				responseResult = entity.getBody();
			}
		} catch (Exception e2) {
			logger.error("error", e2);
		}
		logger.info("requestURI= {},userId={}, {}, responseResult= {}, {}, use time = {}ms", requestURI, userId,
				requestParams, responseResult, headers, e - s);
		return result;
	}

	public static void main(String[] args) {
		String ddString = "/quan/rest/topic/getteamtopics";
		System.out.println(ddString.contains("/rest/"));
	}

	public void doBefore(JoinPoint jp) {
		System.out.println("DoBefore");
	}

	public void doAfter(JoinPoint jp) {
		System.out.println("doAfter");
	}
}
