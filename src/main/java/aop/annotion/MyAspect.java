package aop.annotion;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 切面
 * 方法是 通知或者称之为增强
 * 切点是 annotation中的Execution对应的内容
 * */
@Aspect
public class MyAspect {

  /**
   * 前置通知
   */
  @Before (value = "execution(* aop.annotion.BusinessExcution.doAnnotion()))")
  public void before() {
    System.out.println("前置通知....");
  }

  /**
   * 后置通知
   * returnVal,切点方法执行后的返回值
   */
  @AfterReturning(value = "execution(* aop.annotion.BusinessExcution.doAnnotion(..))", returning = "returnVal")
  public void AfterReturning(Object returnVal) {
    System.out.println("后置通知...." + returnVal);
  }

  /**
   * 环绕通知
   *
   * @param joinPoint
   *          可用于执行切点的类
   * @return
   * @throws Throwable
   */
  @Around("execution(* aop.annotion.BusinessExcution.doAnnotion(..))")
  public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("环绕通知前....");
    Object obj = (Object) joinPoint.proceed();
    System.out.println("环绕通知后.... 执行的结果是: " + String.valueOf (obj));
    return obj;
  }

  /**
   * 抛出通知
   *
   * @param e
   */
  @AfterThrowing(value = "execution(* aop.annotion.BusinessExcution.doSomeThingThrowException(..))", throwing = "e")
  public void afterThrowable(Throwable e) {

    System.out.println("出现异常:msg=" + e.getMessage());
  }

  /**
   * 无论什么情况下都会执行的方法
   */
  @After(value = "execution(* aop.annotion.BusinessExcution.doAnnotion(..))")
  public void after() {
    System.out.println("最终通知....");
  }
}