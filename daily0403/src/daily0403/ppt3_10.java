package daily0403;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ppt3_10 {
	public static void main(String[] args) {
		int kopo_27_MyWon = 1000000;// 내가 환전하고 싶은 원화
		double kopo_27_MoneyEX = 1238.21; // 달러 환율
		double kopo_27_commission = 0.003; // 환전시 발생하는 수수료
		double kopo_27_ComPerOne = kopo_27_MoneyEX * kopo_27_commission; // 1달러당 환전 수수료
		int kopo_27_usd = (int) (kopo_27_MyWon / (kopo_27_MoneyEX + kopo_27_ComPerOne)); // 환전 달러 = 환전하려는 원화 / (달러환율 + 1달러당 환전수수료)
		double kopo_27_totalcom = kopo_27_usd * kopo_27_ComPerOne;// 총 수수료 = 달러 * 1달러당 환전 수수료
		int kopo_27_i_totalcom = 0;// 올림 처리된 총 수수료

		// 수수료 올림처리
		// 만약 총 수수료의 소수점을 버린 연산이 소수점을 버리기 전과 같지 않다면 +1한 값을 변수에 대입
		if (kopo_27_totalcom != (double) ((int) kopo_27_totalcom)) {
			kopo_27_i_totalcom = (int) kopo_27_totalcom + 1;
		} else {
			// 만약 총 수수료의 소수점을 버린 연산이 소수점을 버리기 전과 같다면 그대로 변수에 대입
			kopo_27_i_totalcom = (int) kopo_27_totalcom;
		}

		System.out.printf("******************************************************************************\n");
		System.out.printf("*                          (정확한)수수료 적용환전                           *\n");

		System.out.printf("총 수수료 : %d원 => 미화 : %d달러, 달러당 수수료: %f원\n", kopo_27_i_totalcom, kopo_27_usd,
				kopo_27_ComPerOne);//형에 맞춰서 출력

		// 나머지 잔돈 = 환전하고싶은 원화 - (달러 * 달러환율) - 1달러당 환전 수수료
		int kopo_27_remain = (int) (kopo_27_MyWon - kopo_27_usd * kopo_27_MoneyEX - kopo_27_i_totalcom);
		System.out.printf("총 한화환전금액 : %d원 => 미화 : %d달러, 수수료청구:%d원 잔돈: %d원\n", kopo_27_MyWon, kopo_27_usd,
				kopo_27_i_totalcom, kopo_27_remain);//형에 맞춰서 출력
		System.out.printf("******************************************************************************\n");

		DecimalFormat df = new DecimalFormat("###,###,###,###,###");//천자리 마다 ',' 찍기 -> String으로 변환되어 결과 반영

		System.out.println();//줄넘기기
		System.out.printf("******************************************************************************\n");
//		System.out.println("*                            콤마찍기, 날짜 적용                            *\n");
		System.out.printf("*                                                                           *\n");

		System.out.printf("총 수수료 : %s원 => 미화 : %s달러, 달러당 수수료: %f원\n", df.format(kopo_27_i_totalcom), df.format(kopo_27_usd),
				kopo_27_ComPerOne);//문자열형에 맞춰서 출력
		
		// 나머지 잔돈 = 환전하고싶은 원화 - (달러 * 달러환율) - 1달러당 환전 수수료
		kopo_27_remain = (int) (kopo_27_MyWon - kopo_27_usd * kopo_27_MoneyEX - kopo_27_i_totalcom);
		System.out.printf("총 한화환전금액 : %s원 => 미화 : %s달러, 수수료청구:%s원 잔돈: %s원\n", df.format(kopo_27_MyWon),
				df.format(kopo_27_usd), df.format(kopo_27_i_totalcom), df.format(kopo_27_remain));//문자열형에 맞춰서 출력

		
		//달력객체는 new라는 연산자 사용하지 않고 get으로 인스턴스를 생성해서 가져온다
		Calendar k27_clat = Calendar.getInstance(); //달력 인스턴스 생성
		
		//년도/월/일 시간/분/초 형식으로 포맷팅
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
		//달력에서 시간을 가져오고 포맷팅 한 후 문자열 형태로 출력
		System.out.printf("최종실행시간 : %s\n", sdf.format(k27_clat.getTime()));
		
		System.out.printf("******************************************************************************\n");
	}
}
