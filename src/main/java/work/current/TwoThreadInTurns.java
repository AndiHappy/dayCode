package work.current;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.sql.rowset.FilteredRowSet;

/**
 * @author zhailzh
 * 
 * @Date 20151222:09:58
 * 
 */
public class TwoThreadInTurns {

	public static Lock lock = new ReentrantLock();

	public static Condition first = lock.newCondition();
	public static Condition second = lock.newCondition();
	public static boolean isMyturn = true;
	

	public static void main(String[] args) {

		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				while (!isMyturn) {
					try {
						first.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
					for (int i = 0; i < 3; i++) {
						System.out.println(Thread.currentThread().getName() +" :"+i);
					}
				
					isMyturn = false;
					second.signal();
				lock.unlock();
			}
		});
		
		
		Thread b = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				while (isMyturn) {
					try {
						second.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
					for (int i = 3; i < 6; i++) {
						System.out.println(Thread.currentThread().getName() +" :"+i);
					}
				
					isMyturn = true;
					first.signal();
					lock.unlock();
			}
		});
		
		b.start();
		a.start();
	}
}

class BoundedBuffer {
	final Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();

	final Object[] items = new Object[100];
	int putptr, takeptr, count;

	public void put(Object x) throws InterruptedException {
		lock.lock();
		try {
			while (count == items.length)
				notFull.await();
			items[putptr] = x;
			if (++putptr == items.length)
				putptr = 0;
			++count;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public Object take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0)
				notEmpty.await();
			Object x = items[takeptr];
			if (++takeptr == items.length)
				takeptr = 0;
			--count;
			notFull.signal();
			return x;
		} finally {
			lock.unlock();
		}
	}
}
