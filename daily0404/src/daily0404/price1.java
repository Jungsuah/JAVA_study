package daily0404;

import java.text.DecimalFormat;

public class price1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String k27_item = "사과";// 품목 변수 선언
		int k27_unit_price = 5000;// 단가 변수 선언
		int k27_num = 500;// 수량 변수 선언
		int total = 0;// 합계 변수 선언 및 초기화

		DecimalFormat k27_df = new DecimalFormat("###,###,###,###,###");// 세자리 마다 콤마 찍기

		System.out.printf("====================================================\n");// 출력
		System.out.printf("%20.20s%8.8s%8.8s%8.8s\n", "품목", "단가", "수량", "합계");
		// 너비가 20자이고, 최대 문자수가 20자로 품목 출력, 너비가 8자이고, 최대 문자 수가 8자로 단가,수량, 합계 출력
		System.out.printf("====================================================\n");// 출력

		System.out.printf("%20.20s%10.10s%10.10s%10.10s\n", k27_item, k27_df.format(k27_unit_price),
				k27_df.format(k27_num), k27_df.format(k27_unit_price * k27_num));// format한 형식으로 출력
		System.out.printf("=====================================================\n");// 출력

	}

}
