package products.produceAndSonsumer;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zhailz
 *
 * 时间：2016年6月27日 ### 下午8:04:29
 */
public class Produce extends Thread {

  LinkedBlockingQueue<String> queue = null;
  public Produce(LinkedBlockingQueue<String> queue) {
    this.queue = queue;
  }
  @Override
  public void run() {
    try {
      while (true) {
        if(queue.size() < 10){
          String value = "value" + Math.random();
          queue.put(value);
          System.out.println("生产者: "+value);
        }else{
          sleep(10);
        }
       
      }
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
