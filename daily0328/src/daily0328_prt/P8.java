package daily0328_prt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P8 {
	public static void main(String[] args) {

//사용자는 숫자를 입력하고 숫자는 배열의 크기를 정의합니다.
//사용자가 정의된 크기보다 큰 숫자를 입력함
//이 경우, 이 프로그램은 “error”를 출력하고 처음부터 다시 시작하며,
//그렇지 않으면 숫자를 배열에 할당하고 정렬하고 인쇄합니다.

//		5
//		1 3 4 5 7 8
//		error
//		4
//		1 22 6 12
//		1 6 12 22

		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("배열의 크기 : ");
				int num = sc.nextInt();
				sc.nextLine();
				Integer[] array = new Integer[num];

				System.out.println("배열에 입력할 숫자 입력:");
				String str = sc.nextLine();
				String[] splitStr = str.split(" ");// 공백제거후 담을 배열

				if (num != splitStr.length) {
					throw new Exception();
				}
				for (int i = 0; i < num; i++) {
					array[i] = Integer.parseInt(splitStr[i]);
				}
				List<Integer> list = Arrays.asList(array);
				Collections.sort(list);
				System.out.println(list);
				break;

			} catch (Exception e) {
				System.out.println("error");
				System.out.println();
			}
		}
	}
}
