package daily0328_prt;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//현재 시간을 화면에 출력
//사용자가 시간을 초 단위로 입력
//프로그램은 입력된 시간 후에 "time is over"를 출력합니다.

//12:34:45
//30
//time is over(12:35:15)

public class P6 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdformat = new SimpleDateFormat("HH:mm:ss");
		Date time = new Date();
		String dateTime = sdformat.format(time);

		Calendar cal = Calendar.getInstance();
		cal.setTime(time);

		System.out.println("현재 시간: " + dateTime);
		System.out.println("추가하실 시간 입력");
		int sec = sc.nextInt();
		cal.add(Calendar.SECOND, sec);

		try {
			Thread.sleep(1000 * sec); // 1000이 1초
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		dateTime = sdformat.format(cal.getTime());
		System.out.println("time is over" + "(" + dateTime + ")");
	}
}
