package testspace;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author zhailzh
 * 
 */
public class TestCyclicBarrier {
  public static void main(String[] args) {
    CyclicBarrier cyc = new CyclicBarrier(3);
    ThreadTest thread1 = new ThreadTest(cyc);
    ThreadTest thread2 = new ThreadTest(cyc);
    thread1.start();
    thread2.start();
    try {
      cyc.await();
      System.out.println("总的任务完成了");
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
    catch (BrokenBarrierException e) {
      e.printStackTrace();
    }
  }

}

class ThreadTest extends Thread {

  private String name = this.getName();
  private CyclicBarrier cyc = null;

  public ThreadTest(CyclicBarrier cyc) {
    this.cyc = cyc;
  }

  @Override
  public void run() {
    System.out.println(name + " begine");
    try {
      Thread.sleep(5000);
      System.out.println(name + " end");
      cyc.await();
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
    catch (BrokenBarrierException e) {
      e.printStackTrace();
    }

  }
}