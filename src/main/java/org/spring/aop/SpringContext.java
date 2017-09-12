package org.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.Business;

/**
 * @author zhailz
 *
 * @time: 2017年9月12日 -- 上午9:40:45
 */
public class SpringContext {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // 创建 Spring 容器
    @SuppressWarnings("resource")
    ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
    Business p = ctx.getBean(Business.class);
    p.doSomeThing();
    ctx.toString();
  }

}
