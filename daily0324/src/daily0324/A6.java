package daily0324;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//The formula for this is as below
//F0 = 0, F1 = 1
//Fn = Fn-1 + Fn-2
//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 …
//
//사용자가 숫자를 입력합니다.
//피보나치 수의 요소 수 인쇄

public class A6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력");
		int num = sc.nextInt();
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
	}
}
