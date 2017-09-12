package aop;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebResponseResultLogAop implements MethodInterceptor {
  public static final Logger logger = LoggerFactory.getLogger(WebResponseResultLogAop.class);

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    Object[] arguments = invocation.getArguments();
    String methodName = invocation.getMethod().getName();
    long s = System.currentTimeMillis();
    Object result = invocation.proceed();
    logger.info("\n 请求函数:{}, \n 参数是:{}, \n 结果是:{} \n 耗时:{}", methodName, Arrays.toString(arguments),
        String.valueOf(result), System.currentTimeMillis() - s);
    return result;
  }

}
