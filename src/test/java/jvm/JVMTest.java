package jvm;

import java.lang.management.ManagementFactory;


public class JVMTest {
	private static final int _1m = 1024 * 1024;
	
	public static void main(String[] args) throws Exception {
		
		String name = ManagementFactory.getRuntimeMXBean().getName();
    //System.out.println(name);
		// get pid
		String pid = name.split("@")[0];
		System.out.println("Pid is:" + pid);
		Thread.sleep(80000);
		byte[] alloc1, alloc2, alloc3, alloc4;
		alloc1 = new byte[2 * _1m];
		Thread.sleep(2000);
		alloc2 = new byte[2 * _1m];
		Thread.sleep(2000);
		alloc3 = new byte[2 * _1m];
		Thread.sleep(2000);
		alloc4 = new byte[4 * _1m];
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		
		alloc4 = null; alloc3 = null; alloc2=null;alloc1=null;
	}
}
