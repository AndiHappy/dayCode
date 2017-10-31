package threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author zhailz
 * @Date 2017年10月25日 - 下午8:42:02
 * @Doc: 
 */
public class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

  private static final Logger logger = LoggerFactory.getLogger(
      CustomRejectedExecutionHandler.class);

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see java.util.concurrent.RejectedExecutionHandler#rejectedExecution(java.lang.Runnable, java.util.concurrent.ThreadPoolExecutor)
   */
  @Override
  public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
    
    System.out.println("========================================================================");

    System.out.println("coreSize: "+ e.getCorePoolSize());
    System.out.println("LargestPoolSize: "+e.getLargestPoolSize());
    System.out.println("MaximumPoolSize: "+e.getMaximumPoolSize());
    System.out.println("Queue().size: "+e.getQueue().size());
    System.out.println("ActiveCount: "+e.getActiveCount());
    System.out.println("TaskCount: "+e.getTaskCount());
    
    System.out.println("========================================================================");

  }

}
