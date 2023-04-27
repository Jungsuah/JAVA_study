package daily0329;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//사용자가 숫자를 입력하고 목록에 할당
//숫자의 수, 평균, 최대, 최소를 인쇄합니다.
//이것은 무기한으로 수행됩니다.
//예외문 추가

//5
//Result : 1 - Mean 5, Max 5, Min 5
//
//3
//Result : 2 – Mean 4, Max 5, Min 3
//
//1
//Result : 3 – Mean 3, Max 5, Min 1

public class A9 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			int min = 0;
			int max = 0;
			int mean = 0;

			int realMean = 0;
			try {
				System.out.println("숫자 입력 : ");
				String str = sc.nextLine();

				list.add(Integer.parseInt(str));

				for (int i = 0; i < list.size(); i++) {
					if (list.size() == 1) {
						min = Collections.min(list);
						max = Collections.max(list);
						mean = min;
						throw new Exception();
					} else {
						min = Collections.min(list);
						max = Collections.max(list);
						mean += list.get(i);
						realMean = mean / list.size();
					}
				}
				System.out.println("Result : " + list.size() + " - " + "Mean " + realMean + "," + " Max " + max + ","
						+ " Min " + min);

			} catch (Exception e) {
				System.out.println(
						"Result : " + (1) + " - " + "Mean " + mean + "," + " Max " + max + "," + " Min " + min);
			}

		}
	}
}
