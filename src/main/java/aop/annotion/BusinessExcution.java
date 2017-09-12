package aop.annotion;

import org.springframework.stereotype.Service;

/**
 * @author zhailz
 * @date 17/9/12 - 下午4:05.
 */

@Service
public class BusinessExcution {

  public String doAnnotion(){
    System.out.println ("do Annotion");

    return "aop.annotion.BusinessExcution.doAnnotion";
  }

  public void doSomeThingThrowException() {
    throw new IllegalArgumentException ("抛出异常");
  }

}
