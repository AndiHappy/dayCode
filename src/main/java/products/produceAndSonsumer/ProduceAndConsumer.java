package products.produceAndSonsumer;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zhailz
 *
 * 时间：2016年6月27日 ### 下午8:03:17
 */
public class ProduceAndConsumer {

  private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(100);
  public  void begine(String[] args) {
    Produce producer = new Produce(queue);
    Consumer consumer = new Consumer(queue);
    consumer.start();
    producer.start();
   
  }
  
  public static void main(String[] args){
    ProduceAndConsumer test = new ProduceAndConsumer();
    test.begine(args);
  }

}
