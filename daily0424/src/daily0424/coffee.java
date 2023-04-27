package daily0424;

import java.util.Scanner;

public class coffee {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("안녕하세요, 고래 커피입니다. 몇잔드릴까요?");
	int coffeeNum = sc.nextInt();
	System.out.println("혹시 쿠폰은 갯수는 몇개 입니까?");
	Integer stamp = sc.nextInt();
	while(stamp != null) {
		if (stamp + coffeeNum > 9) {
			System.out.println("10잔 드셔서 오늘은 1잔 무료입니다~");
			break;
		}else if(stamp + coffeeNum == 9) {
			System.out.println("오늘것도 찍으시면 쿠폰 갯수는 " + (stamp + coffeeNum) +"개 입니다. 다음번에 음료 한잔 무료로 드세요");
			break;
		}else {
			System.out.println("쿠폰 찍어드릴게요. 오늘까지 쿠폰 갯수는 " + (stamp + coffeeNum) +"개 입니다.");
			break;
		}
	}
	
	int hpay = 2000 * coffeeNum;
	int time = coffeeNum * 3;
	System.out.println(hpay + "원 입니다. 소요시간은 "+time+"분 입니다." );
	
	int workpay = 500 * coffeeNum; //60분에 10000원 시급이니까 3분에 500원 벌기 -> 커피한잔당 알바는 500원 줘야함
	System.out.println("알바 지급 비용 : " + workpay + "원 입니다.");
			
	int income = (int) ((hpay - workpay) * 0.4);
	System.out.println("순수익 : " + income + "원 입니다.");
}
}
