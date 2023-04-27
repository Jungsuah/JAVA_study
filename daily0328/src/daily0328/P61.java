package daily0328;

import java.time.LocalTime;
import java.util.Scanner;

public class P61 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalTime now = LocalTime.now();
		System.out.println(now);

		// 입력 시간 받기
		Scanner scanner = new Scanner(System.in);
		int timeInSeconds = scanner.nextInt();

		// 일정 시간 대기 후 "time is over" 출력
		try {
			Thread.sleep(timeInSeconds * 1000);
			System.out.println("time is over(" + LocalTime.now() + ")");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
