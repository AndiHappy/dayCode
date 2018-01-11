package scheduledtask;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务的执行，依赖于Timer，可以特定的时间执行或者按照某种规律循环的执行
 * A facility for threads to schedule tasks for future execution in a background thread. 
 * Tasks may be scheduled for one-time execution, or for repeated execution at regular intervals.
 * 
 * 弊端：
 * 1. 不能针对某一个定时任务进行取消
 * 2. Timer 的设计核心是一个 TaskList 和一个 TaskThread。Timer 将接收到的任务丢到自己的 TaskList 中，
 * TaskList 按照 Task 的最初执行时间进行排序。TimerThread 在创建 Timer 时会启动成为一个守护线程。
 * 这个线程会轮询所有任务，找到一个最近要执行的任务，然后休眠，当到达最近要执行任务的开始时间点，TimerThread 被唤醒并执行该任务。
 * 之后 TimerThread 更新最近一个要执行的任务，继续休眠。但由于所有任务都是由同一个线程来调度，因此所有任务都是串行执行的，
 * 同一时间只能有一个任务在执行，前一个任务的延迟或异常都将会影响到之后的任务。
 * */
public class TimerTest extends TimerTask {

	private String jobName = "";

	public TimerTest(String jobName) {
		super();
		this.jobName = jobName;
	}

	@Override
	public void run() {
		try {
			//如果一个线程执行的过程中休眠会影响其他的线程的执行
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("execute " + jobName);
	}

	public static void main(String[] args) {
		Timer timer = new Timer();
		long delay1 = 1 * 1000;
		long period1 = 1000;
		// 从现在开始 1 秒钟之后，每隔 1 秒钟执行一次 job1
		timer.schedule(new TimerTest("job1"), delay1, period1);
		
		long delay2 = 2 * 1000;
		long period2 = 2000;
		// 从现在开始 2 秒钟之后，每隔 2 秒钟执行一次 job2
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("第二个线程的执行完毕！");
			}
		}, delay2, period2);
		
		//取消任务,则会取消全部的任务
//		timer.cancel();
	}
}