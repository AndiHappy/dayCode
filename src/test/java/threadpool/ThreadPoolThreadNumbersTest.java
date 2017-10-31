package threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhailz
 * @Date 2017年10月25日 - 下午8:40:50
 * @Doc:
 */
public class ThreadPoolThreadNumbersTest {

  static ThreadPoolExecutor e = new ThreadPoolExecutor(2, 10, 0L, TimeUnit.SECONDS,
      new LinkedBlockingQueue<Runnable>(8), new CustomRejectedExecutionHandler());

  /**
   * @param args
   */
  public static void main(String[] args) {
    for (int i = 0; i < 10000; i++) {
      e.execute(new  ThreadExample(900000,"thread-"+i));
      e.submit(new  ThreadExample(900000,"thread-"+i));
    }
    
  }

}

class ThreadExample extends Thread {
  int sleep;

  public ThreadExample(int sleep,String name) {
    this.sleep = sleep;
    super.setName(name);
  }

  @Override
  public void run() {
    try {
      System.out.println(Thread.currentThread().getName() + "开始");
      Thread.sleep(this.sleep);
      System.out.println(Thread.currentThread().getName() + "结束");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}