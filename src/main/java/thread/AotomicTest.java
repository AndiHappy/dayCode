package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;import com.alibaba.dubbo.common.utils.Pool;

public class AotomicTest {
	
	public volatile AtomicInteger num = new AtomicInteger(0);
	public ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(50);
	
	public void sum(){
		for (int i = 0; i < 5000; i++) {
			ThreadV thread = new ThreadV(this);
			pool.execute(thread);
		}
	}
	public static void main(String[] args) throws Exception{
		AotomicTest test = new AotomicTest();
		test.sum();
		while(true){
			if(test.pool.getActiveCount() == 0){
				System.out.println(test.num.get());
				test.pool.shutdown();
				break;
			}else{
				Thread.sleep(100);
			}
		}
		System.exit(0);
	}
}


class ThreadV extends Thread  {
	AotomicTest test;
	 public ThreadV(AotomicTest test) {
		this.test = test;
	}

	@Override
	    public void run() {
		for (int i = 0; i < 50; i++) {
			test.num.incrementAndGet();
			try {
				Thread.sleep(Math.round(100)%100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 }
}