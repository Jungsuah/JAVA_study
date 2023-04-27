package daily0329;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//목록 사용
//사용자가 숫자를 입력합니다.
//피보나치 수의 요소 수 인쇄
//예외문 추가

public class A7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("숫자 입력");
				int num = sc.nextInt();
				if (num == 0) {
					throw new Exception();
				}
				List<Integer> list1 = new ArrayList<Integer>();

				int num1 = 0;
				for (int i = 0; i < num; i++) {
					if (i == 0) {
						list1.add(0);
					} else if (i == 1) {
						list1.add(1);
					} else {
						num1 = list1.get(i - 1) + list1.get(i - 2);
						list1.add(num1);
					}
				}
				System.out.println(list1);
			} catch (Exception e) {
				System.out.println("출력할 피보나치 수가 없습니다.");
			}
		}
	}
}
