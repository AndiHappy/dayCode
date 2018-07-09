package thread;

public class JoinTest {
	public static void main(String[] args) {
		Thread t = new Thread(new RunnableImpl());
		new ThreadTest1(t).start();
		t.start();
		try {
			t.join(1000); // t.join 需要锁， new ThreadTest(t).start(); 运行的过程中也需要锁，谁先拿到，另一个需要等待。
			System.out.println("joinFinish");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadTest1 extends Thread {

	Thread thread;

	public ThreadTest1(Thread thread) {
		this.thread = thread;
	}

	@Override
	public void run() {
		synchronized (thread) {
			System.out.println("getObjectLock");
			try {
				Thread.sleep(9000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			System.out.println("ReleaseObjectLock");
		}
	}
}

class RunnableImpl implements Runnable {

	public void run() {
		try {
			System.out.println("Begin sleep");
			Thread.sleep(2000);
			System.out.println("End sleep");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}