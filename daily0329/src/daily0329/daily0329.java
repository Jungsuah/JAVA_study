package daily0329;

import java.text.SimpleDateFormat;
import java.util.Date;


public class daily0329 extends Thread{
	public static void main(String[] args) {
		daily0329 thread = new daily0329();
		thread.start();
		System.out.println("Check 1 :" + getCurrentTime() + "-" + thread.isAlive());
		try {
			Thread.sleep(500);//0.5초
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("check 2 :" + getCurrentTime() + "-" + thread.isAlive());
		System.out.println(thread.isAlive());
	}
	
	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		String dateAndTime = sdf.format(time);
		return dateAndTime;
	}
	
	public void run() {
		int cnt = 0;
		while(true) {
			if(cnt == 4) {
				break;
			}
			try {
				System.out.println(getCurrentTime() + "-" + cnt);
				Thread.sleep(100);
				cnt++;
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
