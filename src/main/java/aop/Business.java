package aop;

import java.lang.reflect.Method;

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
  
  protected Method getMethod(String name) {
    // assumes no overloading of test methods...
    Method[] candidates = this.getClass().getMethods();
    for (Method candidate : candidates) {
      if (candidate.getName().equals(name)) {
        return candidate;
      }
    }
    return null;
  }
  
  protected Method[] getAllMethod() {
    // assumes no overloading of test methods...
    Method[] candidates = this.getClass().getMethods();
    return candidates;
  }

}
