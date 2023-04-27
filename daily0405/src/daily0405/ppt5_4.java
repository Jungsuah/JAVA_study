package daily0405;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ppt5_4 {// 굴림 11
	public static void main(String[] args) {
		int kopo_27_val = 10000; // 세전 물건값
		// 세금 10 퍼센트
		double k27_rate = 0.1;
		int kopo_27_rate = 10;
		// 과세합계 = 세전 물건가 %/ 1.1
		double k27_calTax = kopo_27_val / (k27_rate + 1.0);
		// 부가세 = 과세합계 * 0.1
		double kopo_27_netprice = k27_calTax * kopo_27_rate / 100;
		int kopo_27_inetprice = (int) Math.ceil(kopo_27_netprice);
		// 최종 과세합계 = 세전물건가 - 부가세
		int k27_kk = kopo_27_val - kopo_27_inetprice;

		DecimalFormat k27_df = new DecimalFormat("###,###,###,###,###");// 세자리 마다 콤마 찍기

		// 현재 날짜
		LocalDateTime k27_now = LocalDateTime.now();//현재시간출력
		String k27_formatTime = k27_now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));//날짜 포멧팅 후 출력

		System.out.println("신용승인");//출력
		System.out.printf("%-16s %17s", "단말기 : 2N68665898", "전표번호 : 041218\n");//자리에 맞춰서 출력
		System.out.println("가맹점 : 한양참치찌개");
		System.out.println("주  소 : 경기 성남시 분당구 황새울로351번길 10 , 1층");
		System.out.println("대표자 : 유창신");
		System.out.printf("%-16s %19s", "사업자 : 752-53-00558", "TEL : 7055695\n");//자리에 맞춰서 출력
		System.out.println("- - -  - - - - - - - - - - - - - - - - - - ");
		System.out.printf("%-18s", "금  액");//자리에 맞춰서 왼쪽 정렬 후 출력
		System.out.printf("%18s 원\n", k27_df.format(k27_kk));//자리에 맞춰서 오른쪽 정렬 후 출력
		System.out.printf("%-17s", "부가세");//자리에 맞춰서 왼쪽 정렬 후 출력
		System.out.printf("%18s 원\n", k27_df.format(kopo_27_inetprice));
		System.out.printf("%-18s", "합  계");//자리에 맞춰서 왼쪽 정렬 후 출력
		System.out.printf("%18s 원\n", k27_df.format(kopo_27_val));//자리에 맞춰서 오른쪽 정렬 후 출력
		System.out.println("- - -  - - - - - - - - - - - - - - - - - - ");
		System.out.println("우리카드");
		System.out.println("카드번호 : 5387-20**-****-4613(S)  일시불");
		System.out.println("거래일시 : " + k27_formatTime);
		System.out.println("승인번호 : 70404427");
		System.out.println("거래번호 : 357734873739");
		System.out.printf("%-17s", "매입 : 비씨카드사");//자리에 맞춰서 왼쪽 정렬 후 출력
		System.out.printf("%16s", "가맹 : 720068568\n");//자리에 맞춰서 오른쪽 정렬 후 출력
		System.out.println("알림 : EDC매출표");
		System.out.println("문의 : TEL)1544-4700");
		System.out.println("- - -  - - - - - - - - - - - - - - - - - - ");
		System.out.printf("%23s", "* 감사합니다 *\n");//자리에 맞춰서 오른쪽 정렬 후 출력
		System.out.printf("%39s", "표준v2.08_20200212");//자리에 맞춰서 오른쪽 정렬 후 출력

	}
}
