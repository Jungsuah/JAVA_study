package daily0329;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Scanner;

//정수 배열 초기화
//각 숫자에 N이 있는 숫자를 인쇄하십시오.
//예외문 추가

//[Code]
//int[] numbers = {123, 32, 356, 53, 2, 67, 31, 78, 41, 9, 29};
//
//[Example]
//5
//356 53
//
//2
//123 32 2 29

public class A5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numbers = { 123, 32, 356, 53, 2, 67, 31, 78, 1, 9, 29 };

		while (true) {
			List<Integer> containNumber = new ArrayList<>();
			try {
				System.out.print("찾을 숫자 입력 : ");
				String find = sc.nextLine();
				for (int i = 0; i < numbers.length; i++) {
					int number = numbers[i];
					String num = String.valueOf(number);
					if (num.contains(find)) {
						containNumber.add(number);
					}
				}

				if (containNumber.size() == 0) {
					throw new Exception();
				}
				System.out.println(containNumber);
			} catch (Exception e) {
				System.out.println("배열에 찾는 숫자가 없습니다");
			}
		}
	}
}
