package daily0403_ppt2;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);// Scanner 객체 생성

		System.out.print("두자리 정수를 하나 입력해주세요.>");

		String k27_input = scanner.nextLine();// scanner로 문자열 한줄 입력 받기
		int k27_num = Integer.parseInt(k27_input);// Integer.parseInt를 이용해서 int로 형변환

		System.out.println("입력내용 : " + k27_input);
		System.out.printf("k27_num = %d\n", k27_num);// 정수형으로 출력
	}

}
