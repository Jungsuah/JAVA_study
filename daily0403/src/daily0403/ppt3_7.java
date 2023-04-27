package daily0403;

public class ppt3_7 {
	public static void main(String[] args) {

		// 배열 선언과 동시에 초기화
		String[] kopo_27_item = { "맛동산", "웨하스", "롯데샌드", "오땅", "사브레" };
		int[] kopo_27_price = { 1000, 2000, 3000, 2500, 1450 };
		int[] kopo_27_amount = { 10, 2, 1, 3, 5 };

		// 변수 선언 및 초기화
		double kopo_27_tax_rate = 0.1;// 세율
		int kopo_27_total_sum = 0;// 전체 상품 가격

		System.out.printf("*************************************************\n");
		System.out.printf("               내가 지른 과자들                  \n");
		System.out.printf("  항목       단가         수량           합계    \n");

		// kopo_27_item의 길이 만큼 반복하면서 배열을 읽기
		for (int i = 0; i < kopo_27_item.length; i++) {
			// 소비자가 고른 상품가격 = 상품가격 * 갯수
			int kopo_27_sum = kopo_27_price[i] * kopo_27_amount[i]; 
			 // 소비자가 고른 상품의 갯수에 따른 상품 가격 합계를 전체 상품 가격 변수에 누적
			kopo_27_total_sum = kopo_27_total_sum + kopo_27_sum;

			// 줄을 맞춰주기 위해 배열의 길이에 따른 출력 포맷팅 적용
			if (kopo_27_item[i].length() >= 4) {
				System.out.printf(" %.5s    %4d    %8d    %12d\n", kopo_27_item[i], kopo_27_price[i], kopo_27_amount[i],
						kopo_27_sum);
			} else {
				System.out.printf(" %.5s\t    %5d\t    %d\t    %9d\n", kopo_27_item[i], kopo_27_price[i],
						kopo_27_amount[i], kopo_27_sum);
			}
		}
		System.out.printf("*************************************************\n");
		System.out.printf(" 지불 금액 :     %28d\n", kopo_27_total_sum);// 해당칸수 맞춰서 출력

		int kopo_27_total_net_price = (int) (kopo_27_total_sum / (1 + kopo_27_tax_rate));// 과세 금액 = 지불해야할 총 금액 / (1+세율)
		System.out.printf(" 과세 금액 :     %28d\n", kopo_27_total_net_price);// 해당칸수 맞춰서 출력
		int kopo_27_tax = kopo_27_total_sum - kopo_27_total_net_price;// 세금 = 지불해야할 총 금액 - 과세 금액
		System.out.printf(" 세     금 :     %28d\n", kopo_27_tax);// 해당칸수 맞춰서 출력
	}
}
