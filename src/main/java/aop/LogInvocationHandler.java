package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
* 打印日志的切面
*/
public class LogInvocationHandler implements InvocationHandler {

  private Object target; //目标对象

  LogInvocationHandler(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    //执行原有逻辑
    Object rev = method.invoke(target, args);
    //执行织入的日志，你可以控制哪些方法执行切入逻辑
    if (method.getName().equals("doSomeThing2")) {
      System.out.println("记录日志");
    }
    return rev;
  }

  public static void main1(String[] args) {
    //需要代理的接口，被代理类实现的多个接口都必须在这里定义
    Class[] proxyInterface = new Class[] { IBusiness.class, IBusiness2.class };
    //构建AOP的Advice，这里需要传入业务类的实例
    LogInvocationHandler handler = new LogInvocationHandler(new Business());
    //生成代理类的字节码加载器
    ClassLoader classLoader = LogInvocationHandler.class.getClassLoader();
    //织入器，织入代码并生成代理类
    IBusiness2 proxyBusiness = (IBusiness2) Proxy.newProxyInstance(classLoader, proxyInterface,
        handler);
    //使用代理类的实例来调用方法。
    proxyBusiness.doSomeThing2();
    ((IBusiness) proxyBusiness).doSomeThing();
  }

  public static void main(String[] args) {
    //显示Cglib生成的内部类，设置生成的位置
    System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/zhailz/Documents/workspace/idle-workspace/dayWork/target");
    byteCodeGe();
  }

  public static void byteCodeGe() {
    //创建一个织入器
    Enhancer enhancer = new Enhancer();
    //设置父类
    enhancer.setSuperclass(Business.class);
    //设置需要织入的逻辑
    enhancer.setCallback(new LogIntercept());
    //使用织入器创建子类
    IBusiness2 newBusiness = (IBusiness2) enhancer.create();
    newBusiness.doSomeThing2();
  }
}

class LogIntercept implements MethodInterceptor {

  @Override
  public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy)
      throws Throwable {
    //执行原有逻辑，注意这里是invokeSuper
    Object rev = proxy.invokeSuper(target, args);
    //执行织入的日志
    if (method.getName().equals("doSomeThing2")) {
      System.out.println("记录日志");
    }
    return rev;
  }
}