package com.spring.aop;

/**
 * @author zhailzh
 * 
 * @Date 2016年2月18日——上午11:04:51 业务代码，处理具体的逻辑
 */
public class BusinessCode {

	public boolean isLogin() {
		System.out.println("登录完成");
		return true;
	}

	public boolean isLogin2(String value) {
		System.out.println("登录:" + value);
		return true;
	}

	public static void main(String[] args) {
		BusinessCode code = new BusinessCode();
		code.isLogin();
	}

}
