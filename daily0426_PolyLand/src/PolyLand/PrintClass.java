package PolyLand;

import java.util.List;

public class PrintClass {
	public static void printTotalList(MakeTotalList makeTotalList) {
		List<OrderList> aa = makeTotalList.getData();
		int sum = 0;
		System.out.print("==================== 에버랜드 ====================\n");

		for (int i = 0; i < aa.size(); i++) {
			switch (aa.get(i).getTicket()) {
			case 1:
				System.out.print("주간권 ");
				break;
			case 2:
				System.out.print("야간권 ");
				break;
			}
			switch (aa.get(i).getTicket()) {
			case 1:
				System.out.print("주간권 ");
				break;
			case 2:
				System.out.print("야간권 ");
				break;
			}

			switch (aa.get(i).getAge()) {
			case 1:
				System.out.print("대인 X ");
				break;
			case 2:
				System.out.print("청소년 X");
				break;
			case 3:
				System.out.print("소인 X");
				break;
			case 4:
				System.out.print("경로 X");
				break;
			case 5:
				System.out.print("유아 X");
				break;
			}

			System.out.printf("%d", aa.get(i).getCount());
			System.out.printf(" %d", aa.get(i).getPrice());

			switch (aa.get(i).getFirst()) {
			case 1:
				System.out.print(" * 우대적용 없음\n");
				break;
			case 2:
				System.out.print(" * 장애인 우대적용\n");
				break;
			case 3:
				System.out.print(" * 국가유공자 우대적용\n");
				break;
			case 4:
				System.out.print(" * 다자녀 우대적용\n");
				break;
			case 5:
				System.out.print(" * 임산부 우대적용\n");
				break;
			}
			sum += aa.get(i).getTotal();
		}
		System.out.printf("입장료의 총액은 %d입니다.\n", sum);

	}
}
