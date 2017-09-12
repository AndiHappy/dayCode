package timethread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhailz
 *
 * 时间：2016年8月15日 ### 下午4:33:52
 */
public class ReeThreadTest {

  public ReentrantLock lock = new ReentrantLock();

  private ThreadClass1 thread1 = new ThreadClass1(lock);
  
  private ThreadClass2 thread2 = new ThreadClass2(lock);
  
  private ThreadClass3 thread3 = new ThreadClass3(lock);
  
  public static void main(String[] args) throws InterruptedException{
    
    ReeThreadTest test = new ReeThreadTest();
    test.lock.lock();
    test.thread1.start();
    test.thread2.start();
    test.thread3.start();
    Thread.sleep(1000000);
    test.lock.unlock();
  }
}

class ThreadClass1 extends Thread{
  ReentrantLock lock = null;

  public ThreadClass1(ReentrantLock lock) {
    this.lock = lock;
  }

  @Override
  public void run() {
    System.out.println("抢占锁开始.....");
    lock.lock();
    System.out.println("抢占成功");
    try {
      sleep(10000000);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      lock.unlock();
      System.out.println("释放锁完成");
    }
  }
}



class ThreadClass2 extends Thread{
  ReentrantLock lock = null;

  public ThreadClass2(ReentrantLock lock) {
    this.lock = lock;
  }

  @Override
  public void run() {
    System.out.println("抢占锁开始.....");
    lock.lock();
    System.out.println("抢占成功");
    try {
      sleep(10000000);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      lock.unlock();
      System.out.println("释放锁完成");
    }
  }
}



class ThreadClass3 extends Thread{
  ReentrantLock lock = null;

  public ThreadClass3(ReentrantLock lock) {
    this.lock = lock;
  }

  @Override
  public void run() {
    System.out.println("抢占锁开始.....");
    lock.lock();
    System.out.println("抢占成功");
    try {
      sleep(10000000);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      lock.unlock();
      System.out.println("释放锁完成");
    }
  }
}