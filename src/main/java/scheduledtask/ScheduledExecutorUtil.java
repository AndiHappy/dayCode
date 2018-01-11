package scheduledtask;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 1. 可以针对特定的任务进行取消，推迟
 * 
 * */
public class ScheduledExecutorUtil {
	
	public static ScheduledExecutorUtil getInstance(){
		return ScheduledExecutorUtilHoler.instance;
	}
	
	private static class ScheduledExecutorUtilHoler{
		private static  ScheduledExecutorUtil instance = new ScheduledExecutorUtil();
	}
	private ScheduledThreadPoolExecutor scheduExec = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);;
	private ConcurrentHashMap<String, ScheduledFuture<?>> result  = new ConcurrentHashMap<String, ScheduledFuture<?>>();
	public boolean putScheduledTask(Runnable task,int time,TimeUnit timeunit,String taskName){
		ScheduledFuture<?> value = scheduExec.schedule(task,time,timeunit);
		result.put(taskName, value);
		return result.containsKey(taskName);
	}
	
	private ScheduledExecutorUtil(){
		//定时清理result中已经执行完毕的定时任务
		scheduExec.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				if(result.size() > 0){
					for (String taskname : result.keySet()) {
						ScheduledFuture<?> task = result.get(taskname);
						if(task.isCancelled() || task.isDone()){
							result.remove(taskname);
						}
					}
				}
				
			}
		}, 1, 24*60, TimeUnit.MINUTES);
	}
	
	private boolean cancelScheduledTask(String taskName){
		if(!result.containsKey(taskName)){
			return true;
		}else{
			ScheduledFuture<?> task = result.get(taskName);
			if(task.isCancelled()){
				result.remove(taskName);
				return true;
			}
			if(task.isDone()){
				result.remove(taskName);
				throw new IllegalArgumentException(taskName + " have been cancelled !");
			}
			boolean isCancel =  task.cancel(true);
			if(isCancel){
				result.remove(taskName);
			}
			return isCancel;
			
		}
	}
	
	public void shutDownScheduedTaskPool(){
		scheduExec.shutdown();
	}

	public static void main(String[] args) {
		final long start = System.currentTimeMillis();
		ScheduledExecutorUtil test = new ScheduledExecutorUtil();
		test.putScheduledTask(new Runnable() {
			public void run() {
				System.out.println("timerOne,the time:" + (System.currentTimeMillis() - start));
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, 20000, TimeUnit.MILLISECONDS,"test1");
		System.out.println(test.cancelScheduledTask("test1"));
		test.putScheduledTask(new Runnable() {
			public void run() {
				System.out.println("timerTwo,the time:" + (System.currentTimeMillis() - start));
			}
		}, 10000, TimeUnit.MILLISECONDS,"test2");
		System.out.println(test.cancelScheduledTask("test1"));
	}
}