package spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBean {

  public static final Logger logger = LoggerFactory.getLogger(SpringBean.class);
  public static void main(String[] args) {
    // 创建 Spring 容器
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springTest1.xml");
    Role p = (Role) ctx.getBean("role");
    String name = p.getActorname().getName();
    System.out.println(name);
    ctx.close();
  }
}