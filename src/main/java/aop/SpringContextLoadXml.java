package aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhailz
 *
 * @time: 2017年9月12日 -- 上午9:40:45
 */
public class SpringContextLoadXml {
  public static final Logger logger = LoggerFactory.getLogger(SpringContextLoadXml.class);


  /**
   * @param args
   */
  public static void main(String[] args) {
    // 创建 Spring 容器
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
    Business p = (Business) ctx.getBean(null, Business.class);
    p.doSomeThing();
    ctx.close();
  }

}
