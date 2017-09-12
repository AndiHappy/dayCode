package com.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 打印日志的切面
 */
public class AOPIntroductionLog implements InvocationHandler {

	private Object target; // 目标对象

	AOPIntroductionLog(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 执行原有逻辑
		Object rev = method.invoke(target, args);
		// 执行织入的日志，你可以控制哪些方法执行切入逻辑
		/*
		 * 第二性能影响，因为动态代理使用反射的机制实现的，首先反射肯定比直接调用要慢，经过测试大概每个代理类比静态代理多出10几毫秒的消耗。
		 * 其次使用反射大量生成类文件可能引起Full GC造成性能影响，因为字节码文件加载后会存放在JVM运行时区的方法区
		 * （或者叫持久代）中，当方法区满的时候，会引起Full GC，所以当你大量使用动态代理时，可以将持久代设置大一些，减少Full GC次数
		 */
		// 切点的控制逻辑
		if (method.getName().equals("doSomeThing2")) {
			System.out.println("记录日志");
		}
		return rev;
	}

	// 动态代理实现AOP原理
	public static void main1(String[] args) {
		// 需要代理的接口，被代理类实现的多个接口都必须在这里定义
		Class[] proxyInterface = new Class[] { IBusiness.class, IBusiness2.class };
		// 构建AOP的Advice，这里需要传入业务类的实例
		AOPIntroductionLog handler = new AOPIntroductionLog(new Business());
		// 生成代理类的字节码加载器
		ClassLoader classLoader = AOPIntroductionLog.class.getClassLoader();
		// 织入器，织入代码并生成代理类
		/**
		 * 这个织入器输入的参数：类加载器，代理的接口，代理的处理类（切面） 第一个缺点就是：必须实现一个接口
		 */
		IBusiness2 proxyBusiness = (IBusiness2) Proxy.newProxyInstance(classLoader, proxyInterface, handler);
		// 使用代理类的实例来调用方法。
		proxyBusiness.doSomeThing2();
		((IBusiness) proxyBusiness).doSomeThing();
	}

	// 采用Cglib实现AOP
	public static void main(String[] args) {
		HashSet<String> value = new HashSet<String>();
		value.add("1");
		value.add("2");
		value.add("1");
		System.out.println(value);
		// byteCodeGe();
	}

	public static void byteCodeGe() {
		// 创建一个织入器
		Enhancer enhancer = new Enhancer();
		// 设置父类
		enhancer.setSuperclass(Business.class);
		// 设置需要织入的逻辑
		enhancer.setCallback(new LogIntercept());
		// 使用织入器创建子类
		IBusiness2 newBusiness = (IBusiness2) enhancer.create();
		newBusiness.doSomeThing2();
	}

	/*
	 * Spring的AOP
	 * Spring默认采取的动态代理机制实现AOP，当动态代理不可用时（代理类无接口）会使用CGlib机制。但Spring的AOP有一定的缺点，
	 * 第一个只能对方法进行切入，不能对接口，字段，静态代码块进行切入（切入接口的某个方法，则该接口下所有实现类的该方法将被切入）。
	 * 第二个同类中的互相调用方法将不会使用代理类。因为要使用代理类必须从Spring容器中获取Bean。第三个性能不是最好的自定义类加载器，
	 * 性能要优于动态代理和CGlib
	 */
}

class LogIntercept implements MethodInterceptor {

	@Override
	public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// 执行原有逻辑，注意这里是invokeSuper
		Object rev = proxy.invokeSuper(target, args);
		// 执行织入的日志
		if (method.getName().equals("doSomeThing2")) {
			System.out.println("记录日志");
		}
		return rev;
	}
}

interface IBusiness {
	public boolean doSomeThing();
}

interface IBusiness2 {
	public void doSomeThing2();
}

class Business implements IBusiness, IBusiness2 {

	@Override
	public boolean doSomeThing() {
		System.out.println("执行业务逻辑");
		return true;
	}

	@Override
	public void doSomeThing2() {
		System.out.println("执行业务逻辑2");
	}

}
