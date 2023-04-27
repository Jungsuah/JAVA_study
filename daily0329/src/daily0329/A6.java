package daily0329;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//사용자가 숫자 N과 M을 입력합니다.
//1을 N으로, 1을 M으로 조합하여 만든 경우를 모두 출력
//예외문 추가

//->
//2
//3
//1,1
//1,2
//1,3
//2,1
//2,2
//2,3

public class A6 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("첫번째 숫자 : ");
				String num1 = sc.nextLine();
				List<Integer> num1Array = new ArrayList<>();

				System.out.print("두번째 숫자 : ");
				String num2 = sc.nextLine();
				List<Integer> num2Array = new ArrayList<>();

				if (num1.equals(null) || num2.equals(null)) {
					throw new Exception();
				}

				for (int i = 1; i <= Integer.parseInt(num1); i++) {
					num1Array.add(i);
				}
				for (int i = 1; i <= Integer.parseInt(num2); i++) {
					num2Array.add(i);
				}

				System.out.println(num1Array);
				System.out.println(num2Array);

				for (int i = 1; i <= num1Array.size(); i++) {
					for (int j = 1; j <= num2Array.size(); j++) {
						System.out.println(i + "," + j);
					}
				}

			} catch (Exception e) {
				System.out.println("공백을 입력할 수 없습니다");
			}

		}

	}
}
