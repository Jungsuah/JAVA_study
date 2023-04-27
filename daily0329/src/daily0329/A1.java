package daily0329;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//사용자가 일련의 숫자를 입력하고 큐에 할당합니다.
//사용자가 일련의 숫자에서 숫자를 입력했습니다.
//출력 순서대로 숫자 출력
//예외문 추가
//1 21 13 34 15 16
//13
//3
public class A1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] splitArray;
		while (true) {
			System.out.printf("숫자 입력: ");
			String number = sc.nextLine();
			splitArray = number.split(" ");
			try {
				Queue<Integer> queue = new LinkedList<>();
				for (int i = 0; i < splitArray.length; i++) {
					queue.add(Integer.parseInt(splitArray[i]));
				}
				System.out.println("탐색 숫자 입력:");
				int number1 = Integer.parseInt(sc.nextLine());
				int key = 0;
				int cnt = 0;
				if (queue.contains(number1)) {
					for (int i = 0; i <= queue.size();) {
						key = queue.poll();
						cnt++;
						if (key == number1) {
							break;
						}
					}
					System.out.println(cnt + "번째 위치중");
					break;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("queue에 찾는 숫자가 없습니다.");
			}
		}
	}
}
