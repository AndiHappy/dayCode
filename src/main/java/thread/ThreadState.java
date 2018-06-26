package thread;

import java.util.concurrent.locks.LockSupport;

public class ThreadState {

	public static void main(String[] agrs) throws InterruptedException {
		Object threadwait = new Object();
		Object mainwait = new Object();
		ThreadStateTestThread t1 = new ThreadStateTestThread(threadwait,mainwait);
		ThreadStateTestThread1 t2 = new ThreadStateTestThread1(threadwait,mainwait);
		System.out.println(t2.getState().toString());
		t1.start();
		t2.start();
		System.out.println(t2.getState().toString());
		Thread.sleep(1000);
		System.out.println(t2.getState().toString());
		System.out.println(t1.getState().toString());
		t1.join();
		System.out.println(t1.getState().toString());
	}
}


class ThreadStateTestThread1 extends Thread {
	Object threadwait = null;
	Object mainwait = null;

	public ThreadStateTestThread1(Object threadwait, Object mainwait) {
		this.threadwait = threadwait;
		this.mainwait = mainwait;
	}

	public void run(){
		try {
			synchronized (this.threadwait) {
				sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


class ThreadStateTestThread extends Thread {
	Object threadwait = null;
	Object mainwait = null;

	public ThreadStateTestThread(Object threadwait, Object mainwait) {
		this.threadwait = threadwait;
		this.mainwait = mainwait;
	}

	public void run(){
		try {
			sleep(1000);
			synchronized (this.threadwait) {
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

enum ThreadStateTest {
    /**
     * Thread state for a thread which has not yet started.
     */
    NEW,

    /**
     * Thread state for a runnable thread.  A thread in the runnable
     * state is executing in the Java virtual machine but it may
     * be waiting for other resources from the operating system
     * such as processor.
     */
    RUNNABLE,

    /**
     * Thread state for a thread blocked waiting for a monitor lock.
     * A thread in the blocked state is waiting for a monitor lock
     * to enter a synchronized block/method or
     * reenter a synchronized block/method after calling
     * {@link Object#wait() Object.wait}.
     */
    BLOCKED,

    /**
     * Thread state for a waiting thread.
     * A thread is in the waiting state due to calling one of the
     * following methods:
     * <ul>
     *   <li>{@link Object#wait() Object.wait} with no timeout</li>
     *   <li>{@link #join() Thread.join} with no timeout</li>
     *   <li>{@link LockSupport#park() LockSupport.park}</li>
     * </ul>
     *
     * <p>A thread in the waiting state is waiting for another thread to
     * perform a particular action.
     *
     * For example, a thread that has called <tt>Object.wait()</tt>
     * on an object is waiting for another thread to call
     * <tt>Object.notify()</tt> or <tt>Object.notifyAll()</tt> on
     * that object. A thread that has called <tt>Thread.join()</tt>
     * is waiting for a specified thread to terminate.
     */
    WAITING,

    /**
     * Thread state for a waiting thread with a specified waiting time.
     * A thread is in the timed waiting state due to calling one of
     * the following methods with a specified positive waiting time:
     * <ul>
     *   <li>{@link #sleep Thread.sleep}</li>
     *   <li>{@link Object#wait(long) Object.wait} with timeout</li>
     *   <li>{@link #join(long) Thread.join} with timeout</li>
     *   <li>{@link LockSupport#parkNanos LockSupport.parkNanos}</li>
     *   <li>{@link LockSupport#parkUntil LockSupport.parkUntil}</li>
     * </ul>
     */
    TIMED_WAITING,

    /**
     * Thread state for a terminated thread.
     * The thread has completed execution.
     */
    TERMINATED;
}
