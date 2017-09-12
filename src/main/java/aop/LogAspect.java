package aop;

/**
 * @author zhailz
 * @Date 2017年9月12日 - 上午11:40:09
 * @Doc: 切面-配合xml的定义
 */

public class LogAspect {
  public void doBefore() {
    System.out.println("前置通知....");
  }

  public void doAfter(Object result) {
    System.out.println("后置通知： " + result);
  }
}
