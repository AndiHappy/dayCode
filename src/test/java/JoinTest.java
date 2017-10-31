
/**
 * @author zhailz
 * @Date 2017年10月25日 - 下午2:09:41
 * @Doc: 
 */
public class JoinTest {
  
  public static void main(String[] args) throws InterruptedException {
    ThreadExample va = new ThreadExample(null,"thread-0",1000);
    va.start();
    ThreadExample valie = new ThreadExample(va,"thread-2",5);
    valie.start();
    valie.join();
    System.out.println(Thread.currentThread().getName() + "结束");
  }

}

class ThreadExample extends Thread {
  Thread before;
  int sleep;
  public ThreadExample( Thread a,String name,int sleep) {
    before = a;
    super.setName(name);
    this.sleep = sleep;
  }
  @Override
  public void run() {
    try {
      if(before != null) {
        before.join();
      }
      System.out.println(Thread.currentThread().getName() + "开始");
      Thread.sleep(this.sleep);
      System.out.println(Thread.currentThread().getName() + "结束");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
}