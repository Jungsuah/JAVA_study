package daily0324;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//사용자가 문자열을 입력합니다.
//검정(" ")으로 구분하여 출력
//내림차순으로 정렬하고 다시 인쇄
public class A5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String[] str1 = str.split(" ");
		System.out.println(Arrays.asList(str1));
		
		Collections.sort(Arrays.asList(str1), Collections.reverseOrder());
		System.out.println(Arrays.asList(str1));
	}
}
