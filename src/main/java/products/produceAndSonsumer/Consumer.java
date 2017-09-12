package products.produceAndSonsumer;

import java.util.concurrent.LinkedBlockingQueue;

public class Consumer extends Thread {
  
  LinkedBlockingQueue<String> queue = null;

  public Consumer(LinkedBlockingQueue<String> queue) {
    this.queue = queue;
  }
  @Override
  public void run() {
    try {
      while (true) {
        if(queue.isEmpty()){
          System.out.println("队列为空");
          sleep(20);
        }else{
          String value = queue.take();
          System.out.println("消费: " + value);
        }
      }
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
