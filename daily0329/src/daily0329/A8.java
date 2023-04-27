package daily0329;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//사용자가 두 단어를 입력하고 목록에 할당
//다음 정보를 인쇄하십시오
// 1. 첫 번째 단어의 크기
// 2. 두 번째 단어의 크기
// 3. 같은 문자의 수
//*예외문 추가

//school
//scholar
//1 : 6
//2 : 7
//3 : 5

public class A8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String str1 = " ";
			String str2 = " ";
			Set<String> set1 = null;
			Set<String> set2 = null;
			int count = 0;
			try {
				System.out.print("첫번째 단어 : ");
				str1 = sc.nextLine();

				System.out.print("두번째 단어 : ");
				str2 = sc.nextLine();

				System.out.println("1 : " + str1.length());
				System.out.println("2 : " + str2.length());

				String[] list1 = str1.split("");// scholar
				List<String> list = Arrays.asList(list1);
				 set1 = new HashSet<>(list);// 중복 제거

				String[] list2 = str2.split("");// school
				List<String> listt = Arrays.asList(list2);
				 set2 = new HashSet<>(listt);// 중복 제거
				
				
				if (set1.size() > set2.size()) {
					int first = set1.size();
					set1.removeAll(set2);
					count = set1.size();
					System.out.println("3 : " + (first - count));
					System.out.println();
				} else {
					throw new Exception();
				}

			} catch (Exception e) {
				int first = set2.size();
				set2.removeAll(set1);
				count = set2.size();
				System.out.println("3 : " + (first - count));
				System.out.println();
			}
		}
	}
}
