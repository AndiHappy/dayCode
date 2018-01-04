package work.current.turnsStart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhailzh
 * 
 * @Date 20151223:41:08
 * 
 */
public class ThreadClassA extends Thread {
	private Logger logger = LoggerFactory.getLogger(this.getName());
	
	private Thread after ;
	
	@Override
	public void run() {
		logger.info("߳A С");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!after.isAlive()){
			after.start();
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public Thread getAfter() {
		return after;
	}


	public void setAfter(Thread after) {
		this.after = after;
	}

}
