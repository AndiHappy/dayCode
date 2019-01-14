package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhailz
 *
 * @version 2018年8月13日 上午11:05:13
 */
public class ThreadPool_CountDownLatch {

	public static ExecutorService pool = Executors.newFixedThreadPool(10);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			long time = System.currentTimeMillis();
			//想知道一组线程的执行完毕的时间，可以使用的就是CyclicBarrier了
			int num = 10000;
			CountDownLatch down = new CountDownLatch(num);
			for (int i = 0; i < num; i++) {
				Thread.sleep(1);
				pool.submit(new ThreadEntity(down,i));
			}
			down.await();
			System.out.println("执行完毕,耗时: " + (System.currentTimeMillis() - time));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pool.shutdown();
		return;

	}

}

class ThreadEntity implements Runnable {

	CountDownLatch down;
	int i = 0;

	public ThreadEntity(CountDownLatch down, int i) {
		this.down = down;
		this.i = i;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(i%9);
			System.out.println(Thread.currentThread().getName() + " over!!");
			this.down.countDown();
			return;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
