package thread;

/**
 * 可重入锁，改成不可重入锁
 * */
public class ThreadLockExample {

	public static void main(String[] agrs) throws InterruptedException {
		Object threadwait = new Object();
		Object mainwait = new Object();
		TestThread t1 = new TestThread(threadwait,mainwait);
		t1.start();
	}
}

class TestThread extends Thread {
	Object threadwait = null;
	Object mainwait = null;

	public TestThread(Object threadwait, Object mainwait) {
		this.threadwait = threadwait;
		this.mainwait = mainwait;
	}

	public void run(){
		try {
			synchronized (this.threadwait) {
				System.out.println("1");
				synchronized (this.threadwait) {
					System.out.println("2");
					this.setName("thread");
					synchronized (threadwait) {
						System.out.println("3");
					}
				}
			}
			sleep(1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

