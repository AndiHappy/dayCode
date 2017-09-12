package products.produceAndSonsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhailzh
 * 
 */
public class SimplyBlockingQueue {
  final Lock lock = new ReentrantLock();
  final Condition notFull = lock.newCondition();
  final Condition notEmpty = lock.newCondition();

  final Object[] items = new Object[10];
  int putptr, takeptr, count;

  public void put(Object x) throws InterruptedException {
    lock.lock();
    try {
      while (count == items.length) {
        System.out.println("buffer full, please wait");
        notFull.await();
      }

      items[putptr] = x;
      if (++putptr == items.length) {
        putptr = 0;
      }

      ++count;
      notEmpty.signal();
    }
    finally {
      lock.unlock();
    }
  }

  public Object take() throws InterruptedException {
    lock.lock();
    try {
      while (count == 0) {
        System.out.println("no elements, please wait");
        notEmpty.await();
      }

      Object x = items[takeptr];
      if (++takeptr == items.length) {
        takeptr = 0;
      }
      --count;
      notFull.signal();
      return x;
    }
    finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    final SimplyBlockingQueue boundedBuffer = new SimplyBlockingQueue();

    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("t1 run");
        for (int i = 0; i < 1000; i++) {
          try {
            System.out.println("putting value ：" + i);
            boundedBuffer.put(Integer.valueOf(i));
            Thread.sleep(1000);
          }
          catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }

    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 1000; i++) {
          try {
            Object val = boundedBuffer.take();
            System.out.println("t2：take Value：" + val);

            Thread.sleep(5000);
          }
          catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }

    });

    Thread t3 = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 1000; i++) {
          try {
            Object val = boundedBuffer.take();
            System.out.println("t3 take value：" + val);
            Thread.sleep(5000);
          }
          catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }

    });

    t1.start();
    t2.start();
    t3.start();
  }
}