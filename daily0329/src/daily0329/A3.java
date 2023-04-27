package daily0329;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//사용자가 10세트 이상의 이름 및 점수 입력
//오름차순으로 이름별로 목록 인쇄
//내림차순으로 이름별로 목록 인쇄
//오름차순으로 점수별로 목록 인쇄
//내림차순으로 점수별로 목록을 인쇄하십시오.
//예외문 추가

public class A3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> name = new ArrayList<>();
		List<Integer> score = new ArrayList<>();

		while (true) {
			try {
				System.out.printf("이름 입력 : ");
				String iname = sc.nextLine();
				String[] splitArray = iname.split(" ");
				for (int i = 0; i < splitArray.length; i++) {
					name.add(splitArray[i]);
				}

				System.out.printf("점수 입력 : ");
				String iscore = sc.nextLine();
				String[] splitIntArray = iscore.split(" ");
				for (int i = 0; i < splitIntArray.length; i++) {
					score.add(Integer.parseInt(splitIntArray[i]));
				}

				if (name.size() < 10 || score.size() < 10) {
					throw new Exception();
				} else {
					Collections.sort(name);// 오름차순
					System.out.println("오름차순 이름 배열 : " + name);

					Collections.sort(name, Collections.reverseOrder());// 내림차순
					System.out.println("내림차순 이름 배열 : " + name);

					Collections.sort(score);// 오름차순
					System.out.println("오름차순 점수 배열 : " + score);

					Collections.sort(score, Collections.reverseOrder());// 내림차순
					System.out.println("내림차순 이름 배열 : " + score);
				}
			} catch (Exception e) {
				System.out.println("10세트 이상 입력하세요!");
				break;
			}
		}
	}
}
