package timethread;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * @author zha
 */
public class TraditionalTimer {
	public static void main(String[] args) {
		//1:
//		test1();
		
		//2:
//		test2();
		
		//3:
		test3();
		while (true) {
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	//1:̶ʱִһ1000ִ(ִֻһ)
	public static void test1() {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("bombing!");
			}
		}, 1000);
	}

	// 2:5000ִԺÿ1000ִһ(ִ)
	public static void test2() {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("bombing!");
			}
		}, 5000, 1000);
	}

	
	//3:24뽻ִ(ִ)
	static int count = 0;
	public static void test3() {

		class MyTimerTask extends TimerTask {
			@Override
			public void run() {
				count = (count + 1) % 2;
				System.out.println("bombing!");
				new Timer().schedule(new MyTimerTask(), 2000 + count * 2000);
			}
		}
		new Timer().schedule(new MyTimerTask(), 2000);
	}

}