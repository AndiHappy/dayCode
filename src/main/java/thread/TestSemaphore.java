/**
 * 
 */
package thread;

import java.util.concurrent.Semaphore;

/**
 * @author zhailz
 *
 */
public class TestSemaphore {

private static Semaphore value = new Semaphore(3);

/**
 * @param args
 */
public static void main(String[] args) {
	new ThreadTestSemaphore(value).start();
	new ThreadTestSemaphore(value).start();

}

}

class ThreadTestSemaphore extends Thread {

private Semaphore value = null;

public ThreadTestSemaphore(Semaphore value) {
	this.value = value;
}

@Override
public void run() {
	System.out.println("thread excute" + Thread.currentThread().getName());
	try {
		value.acquire(2);
		System.out.println("thread  acquire" + Thread.currentThread().getName());
		sleep(3000);
		value.release();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}