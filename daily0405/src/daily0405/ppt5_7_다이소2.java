package daily0405;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ppt5_7_다이소2 {// 굴림체 10
	public static void main(String[] args) {

		DecimalFormat k27_df = new DecimalFormat("###,###,###,###,###");// 세자리 마다 콤마 찍기

		LocalDateTime k27_now = LocalDateTime.now(); // 현재시간 불러오기
		String k27_formatTime = k27_now.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));// 날짜 출력 형식 포맷팅
		LocalDateTime k27_k = k27_now.plusDays(14);// 현재날짜에 14일 더하기
		String k27_tk = k27_k.format(DateTimeFormatter.ofPattern("MM월dd일"));// 날짜 출력 형식 포맷팅
		// 이름배열 선언 및 초기화
		String[] k27_itemname = { "제주 삼다수 그린물20L", "이맛살 10kg상등급", "파머스픽 성주 참외" };
		// 가격배열 선언 및 초기화
		int[] k27_price = { 10, 10000, 100 };
		// 코드배열 선언 및 초기화
		String[] k27_itemcode = { "1031725", "11088152", "1021800" };
		// 갯수배열 선언 및 초기화
		int[] k27_num = { 99, 10, 1 };
		// 과세 합계 선언 및 초기화
		int k27_val_total = 0;

		System.out.printf("%23s", "\"국민가게, 다이소\"\n");// 오른쪽 정렬 출력
		System.out.printf("%-34s", "(주)아성다이소_분당서현점");// 왼쪽 정렬 출력
		System.out.printf("\n%-34s", "전화:031-702-6016");// 왼쪽 정렬 출력
		System.out.printf("\n%-33s", "본사:서울 강남구 남부순환로 2748 (도곡동) \n대표자:박정수 , 신호섭 213-81-52063");// 왼쪽 정렬 출력
		System.out.printf("\n대표자:박정수 , 신호섭 213-81-52063");
		System.out.println("\n매장:경기도 성남시 분당구 분당로53번길 11 (서현동)");
		System.out.println("========================================");
		System.out.printf("%22s", "소비자중심경영(CCM) 인증기업");// 오른쪽 정렬 출력
		System.out.printf("\n%24s", "ISO 9001 품질경영시스템 인증기업");// 오른쪽 정렬 출력
		System.out.printf("\n========================================\n");
		System.out.printf("%26s", "교환/환불 14일(" + k27_tk + ")이내.");// 오른쪽 정렬 출력 + 현재 시간에 14일 더한 시간 출력
		System.out.printf("\n%25s", "(전자)영수증, 결제카드 지참 후 구입매장에서 가능");// 오른쪽 정렬 출력
		System.out.printf("\n%24s", "포장/가격 택 훼손시 교환/환불 불가");// 오른쪽 정렬 출력
		System.out.printf("\n%24s", "체크카드 취소 시 최대 7일 소요");// 오른쪽 정렬 출력
		System.out.printf("\n========================================");
		System.out.printf("\n%-15s", "[POS 1058231]");// 왼쪽 정렬 출력
		System.out.printf("%25s", k27_formatTime);// 오른쪽 정렬 출력 후 현재시간 출력
		System.out.println("\n========================================");// 줄넘김
		for (int i = 0; i < k27_itemname.length; i++) {// 이름배열의 길이만큼 for문 돌기
			String cc = k27_cutString2(k27_itemname[i], 21); // 배열의 i번째 값을 자르는 메소드로 넘기기 -> 13글자로 잘라오기

			if (i % 5 == 0 && i != 0) {// 5개씩 출력될때마다 구분자 출력 후 줄넘김
				System.out.printf("---------------------------------------- \n");
			}
			// i번째 가격 , 갯수 , 가격*갯수 출력
			System.out.printf("%s%8s%3d%8s\n", cc, k27_df.format(k27_price[i]), k27_num[i],
					k27_df.format(k27_price[i] * k27_num[i]));
			k27_val_total += k27_price[i] * k27_num[i];
			// i번째 코드번호 출력
			System.out.printf("[%s]\n", k27_itemcode[i]);
		}
		System.out.println(k27_val_total);

		// 세금 10 퍼센트
		double k27_rate = 0.1;
		int kopo_27_rate = 10;
		// 과세합계
		double k27_calTax = k27_val_total / (k27_rate + 1.0);
		// 부가세
		double kopo_27_netprice = k27_calTax * kopo_27_rate / 100;
		int kopo_27_inetprice = (int) Math.ceil(kopo_27_netprice);
		// 최종 과세합계
		int kk = k27_val_total - kopo_27_inetprice;

		System.out.printf("%17s %18s", "과세합계", k27_df.format(kk));// 공간 지정 후 과세합계 출력
		System.out.printf("\n%18s %18s", "부가세", k27_df.format(kopo_27_inetprice));// 공간 지정 후 부가세 출력
		System.out.printf("\n----------------------------------------");
		System.out.printf("\n%-17s %18s", "판매합계", k27_df.format(k27_val_total));// 공간 지정 후 판매합계 출력
		System.out.printf("\n========================================");
		System.out.printf("\n%-17s %18s", "신용카드", k27_df.format(k27_val_total));// 공간 지정 후 신용카드 출력
		System.out.printf("\n----------------------------------------");
		System.out.printf("\n%-16s", "우리카드");// 왼쪽 정렬 후 출력
		System.out.printf("%20s", "538720**********");// 오른쪽 정렬 후 출력
		System.out.printf("\n%-17s", "승인번호 70404427(0)");// 왼쪽 정렬 후 출력
		System.out.printf("%4s", "승인금액");
		System.out.printf("%11s", k27_df.format(k27_val_total));// 오른쪽 정렬 후 판매합계 출력
		System.out.printf("\n========================================");
		System.out.printf("\n%24s %s", k27_formatTime, "분당서현점");// 현재시간 출력
		System.out.printf("\n%-17s", "상품 및 기타 문의 : 1522- 4400\n");// 왼쪽 정렬 후 출력
		System.out.printf("%s", "멤버십 및 샵다이소 관련 문의 : 1599- 2211\n");// 왼쪽 정렬 후 출력
		System.out.printf("%29s", "21128206101588231\n");// 오른쪽 정렬 후 출력
		System.out.printf("----------------------------------------\n");
		System.out.printf("%-30s", "◈ 다이소 멤버십 앱 또는 홈페이지에 접속하셔서 회원가입 후 다양한 혜택을 누려보세요! ◈\n");// 왼쪽 정렬 후 출력

	}

	public static String k27_cutString2(String k27_str, int k27_len) {// 들어오는 문자열을 잘라주는 메소드
		// itemname의 i번째 문자를 str에 담아서 가져오고 바이트로 변환
		byte[] k27_by = k27_str.getBytes();
		if (k27_by.length <= 21) {// 만일 문자바이트가 14가 되기 전일때까지
			k27_str = new String(k27_by, 0, k27_by.length);
			for (int i = k27_by.length; i < 21; i++) {// -> 14를 맞춰주기위해 뒤에 모자라는 칸수만큼 공백을 채워준후 리턴
				k27_str = k27_str + " ";
			}
			return k27_str;
		} else {
			int count = 0;
			try {
				for (int i = 0; i < k27_len; i++) {// 14가 되기전까지 문자의 한칸이 2바이트면
					if ((k27_by[i] & 0x80) == 0x80)// by[i]가 한글이면
						count++; // count+1
				}
				if ((k27_by[k27_len - 1] & 0x80) == 0x80 && (count % 2) == 1) {// 14가 되기전까지 문자의 한칸이 1바이트면
					k27_len--; // 한칸 줄이고
					String str1 = new String(k27_by, 0, k27_len) + " ";// 뒤에 공백을 추가해서
					return str1;// 리턴한다
				}
			} catch (java.lang.ArrayIndexOutOfBoundsException e) {// 배열의 인덱스가 범위를 넘으면
				System.out.println(e);
				return "";// 공백을 리턴
			}
			String str2 = new String(k27_by, 0, k27_len);// 14이상이면 그만큼 문자를 자른후
			return str2;// 잘려진 문자를 리턴한다
		}
	}

}