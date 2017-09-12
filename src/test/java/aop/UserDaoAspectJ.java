package aop;

import aop.annotion.BusinessExcution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:spring-aspectj.xml")
public class UserDaoAspectJ {

    @Autowired
    BusinessExcution businessExcution;

    @Test
    public void aspectJTest(){
        businessExcution.doAnnotion ();
    }
}