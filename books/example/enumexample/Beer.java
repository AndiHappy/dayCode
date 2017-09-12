package enumexample;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Beer {

  public static void main(String[] args) throws InterruptedException, ExecutionException {

    for (int ii = 0; ii < 10; ii++) {

      Callable<ConcurrentLinkedQueue<String>> callable = new Callable<ConcurrentLinkedQueue<String>>() {

        public ConcurrentLinkedQueue<String> call() throws Exception {

          final ConcurrentLinkedQueue<String> result = new ConcurrentLinkedQueue<String>();
          final int count = 5;
          final CyclicBarrier barrier = new CyclicBarrier(count, new Runnable() {
            public void run() {
              result.add("drink beer!");
            }
          });

          // they do not have to start at the same time...
          for (int i = 0; i < count; i++) {
            new Thread(new Worker(i, barrier)).start();
          }
          return result;
        }
      };
      FutureTask<ConcurrentLinkedQueue<String>> task = new FutureTask<ConcurrentLinkedQueue<String>>(
          callable);
      task.run();
      task.get();
    }

  }

}

class Worker implements Runnable {
  final int id;
  final CyclicBarrier barrier;

  public Worker(final int id, final CyclicBarrier barrier) {
    this.id = id;
    this.barrier = barrier;
  }

  public void run() {
    try {
      System.out.println(this.id + "starts to run !");
      Thread.sleep((long) (Math.random() * 10000));
      System.out.println(this.id + "arrived !");
      this.barrier.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (BrokenBarrierException e) {
      e.printStackTrace();
    }
  }
}