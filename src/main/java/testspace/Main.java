package testspace;

import java.lang.management.ManagementFactory;

/**
 * @author zhailzh
 * 
 */
public class Main {

  private static final int _1m = 1024 * 1024;

  @SuppressWarnings("unused")
  public static void main(String[] args) throws Exception {
    String name = ManagementFactory.getRuntimeMXBean().getName();
    System.out.println(name);
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
    alloc4 = new byte[(int) (4 * _1m)];
    Thread.sleep(6000);
  }
}