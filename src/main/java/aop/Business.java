package aop;

import org.springframework.stereotype.Component;

@Component
public class Business implements IBusiness, IBusiness2 {

  public void doSomeThing2() {
    System.out.println("Business doString2");

  }

  @Override
  public void doSomeThing() {
    System.out.println("Business doString1");
  }

}
