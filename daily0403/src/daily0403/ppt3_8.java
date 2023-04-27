package daily0403;

public class ppt3_8 {
	public static void main(String[] args) {

		int kopo_27_MyWon = 1000000;// 내가 환전하고 싶은 원화
		double kopo_27_MoneyEX = 1238.21; // 달러 환율
		double kopo_27_commission = 0.003; // 환전시 발생하는 수수료
		double kopo_27_ComPerOne = kopo_27_MoneyEX * kopo_27_commission; // 1달러당 환전 수수료
		int kopo_27_usd = (int) (kopo_27_MyWon / (kopo_27_MoneyEX + kopo_27_ComPerOne)); // 환전 달러 = 환전하려는 원화 / (달러환율 + 1달러당 환전수수료)
		double kopo_27_totalcom = kopo_27_usd * kopo_27_ComPerOne;// 총 수수료 = 달러 * 1달러당 환전 수수료
		int kopo_27_i_totalcom = 0;// 올림 처리된 총 수수료

		// 수수료 올림처리
		//만약 총 수수료의 소수점을 버린 연산이 소수점을 버리기 전과 같지 않다면 +1한 값을 변수에 대입
		if (kopo_27_totalcom != (double) ((int) kopo_27_totalcom)) {
			kopo_27_i_totalcom = (int) kopo_27_totalcom + 1;
		} else {
			//만약 총 수수료의 소수점을 버린 연산이 소수점을 버리기 전과 같다면 그대로 변수에 대입
			kopo_27_i_totalcom = (int) kopo_27_totalcom;
		}

		System.out.printf("******************************************************************************\n");
		System.out.printf("*                          (정확한)수수료 적용환전                           *\n");

		System.out.printf("총 수수료 : %d원 => 미화 : %d달러, 달러당 수수료: %f원\n", kopo_27_i_totalcom, kopo_27_usd, kopo_27_ComPerOne);

		//나머지 잔돈 = 환전하고싶은 원화 - (달러 * 달러환율) - 1달러당 환전 수수료
		int kopo_27_remain = (int) (kopo_27_MyWon - kopo_27_usd * kopo_27_MoneyEX - kopo_27_i_totalcom);
		System.out.printf("총 한화환전금액 : %d원 => 미화 : %d달러, 수수료청구:%d원 잔돈: %d원\n", kopo_27_MyWon, kopo_27_usd, kopo_27_i_totalcom, kopo_27_remain);
		System.out.printf("******************************************************************************\n");
	}
}
