package aop;

import org.springframework.stereotype.Component;

@Component
public class Business implements IBusiness, IBusiness2 {

  public String doSomeThing2() {
    System.out.println("Business doString2");
    return "value";
  }

  @Override
  public void doSomeThing() {
    System.out.println("Business doString1");
  }

  public void doSomeThingThrowException() {
    throw new IllegalArgumentException ("抛出异常");
  }

}
