package daily0407;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ppt6_emart_method {//이마트 영수증 분리
	// 문자열 아이템 항목 배열 30개 선언 및 초기화
	static String[] k27_itemname = { "a", "aaa", "파머스픽 성주 참외", "꿈꾸는콩 촌두부 마을", "철원 오대쌀10kg", "크리넥스 울트라 클린 아쿠아더블롱 30m30롤",
			"시원한 목 마사지기", "리바트키친 리얼 ＆ 트루 주방수납가구 11종 모음", "욕실 리모델링 패키지 빈티지카페 (공용/거실욕실)", "더블린 슬림도어 중문(1,050~1,400)",
			"피지 바이럭스 액체세제 2.7L(오리지널)", "노브랜드 도톰한 물티슈 100매", "신라면 5개입 1개입", "콩순이 라면가게", "대추 방울토마토 750g/팩",
			"한우 채끝 구이용 1등급", "피코크 정통 꿔바로우500g", "베로베로 선글라스", "몽블랑 스타워커 고급 레진 볼펜", "보이스캐디 T9",
			"조말론 런던 잉글리쉬 페어 앤 프리지아 코롱 컬렉션", "에스티 로더 갈색병 나이트 리페어 에센스", "몽블랑 레더 스트랩 벨트", "로베르타 피에리 토트백",
			"정관장 홍삼정 로얄 240g", "덴마크 유산균 이야기", "네추라넥타 GREEN프로폴리스", "길리안 템테이션 초콜릿", "시세이도", "아떼 어벤티" };

	// 숫자형 아이템별 가격 항목 30개 선언 및 초기화
	static int[] k27_price = { 3000, 2990000, 12890000, 1950000, 29120, 33700, 4900, 900, 159030, 34110, 15040, 1500,
			4500, 980, 4100, 19900, 10980, 11880, 6784, 70400, 434280, 444808, 125020, 201348, 373744, 252672, 235564,
			93436, 9080400, 42112000 };

	// 아이템별 수량 30개 선언 및 초기화
	static int[] k27_num = { 6, 3, 5, 6, 2, 1, 2, 8, 4, 3, 8, 7, 5, 1, 6, 8, 2, 1, 4, 5, 2, 1, 5, 3, 1, 1, 3, 4, 1, 2 };

	// 면세항목 타입 30개 선언 및 초기화
	static boolean[] k27_taxFree = { true, true, true, false, false, false, false, false, true, false, false, false,
			true, false, false, false, false, false, true, false, false, false, false, false, false, true, true, true,
			false, false, false, false };

	static DecimalFormat k27_df = new DecimalFormat("###,###,###,###,###");// 세자리 마다 콤마 찍기

	static int k27_val_taxFreeTotal = 0;// 면세물품
	static int k27_val_taxAmountTotal = 0;// 과세물품

	public static void main(String[] args) {//메인부
		int k27_itemCount = k27_itemname.length; // 항목이 몇개인지
		k27_TitlePrint();// 영수증 맨위 타이틀
		k27_TimeStamp();// 출력시간 인쇄
		k27_HeaderPrint();// 헤더 (상품명,단가,수량,금액)인쇄

		for (int i = 0; i < k27_itemCount; i++) {// 항목갯수만큼 항목 인쇄
			k27_itemPrint(i);
		}
		k27_TotalPrint();// 합계 , 세액등을 인쇄
	}

	private static void k27_TitlePrint() {// 영수증 맨위 타이틀 출력
		System.out.printf("%s", "emart");
		System.out.printf("%29s", "이마트 죽전점 (031)888-1234");// 오른쪽 정렬 출력
		System.out.printf("\n%29s", "206-86-50913 강희석");// 오른쪽 정렬 출력
		System.out.printf("\n%28s", "용인 수지구 포온대로 552");// 오른쪽 정렬 출력
		System.out.println();// 줄넘김
		System.out.printf("\n영수증 미지참시 교환/환불 불가");
		System.out.println("\n정상상품에 한함, 30일 이내(신선 7일)");
		System.out.println("※일부 브랜드매장 제외(매장 고지물참조)");
		System.out.println("교환/환불 구매점에서 가능(결제카드 지참)");
		System.out.println();// 줄넘김
		String k27_formatTime = k27_TimeStamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		System.out.printf("%s%s%17s", "[구 매]", k27_formatTime, "POS:011-9861");// 오른쪽 정렬 출력
		System.out.printf("\n----------------------------------------\n");// 줄넘김
	}

	private static LocalDateTime k27_TimeStamp() {// 현재시간 불러오기
		LocalDateTime k27_now = LocalDateTime.now();
		return k27_now;
	}

	private static void k27_HeaderPrint() {// 헤더 (상품명,단가,수량,금액)인쇄
		System.out.printf("%8s%12s%3s%8s\n", "상 품 명", "단  가", "수량", "합  계");// 칸수를 지정해서 칸에 맞게 출력
	}

	private static void k27_itemPrint(int i) {
		String cc = k27_cutString2(k27_itemname[i], 14);// 배열의 i번째 값을 자르는 메소드로 넘기기 -> 14글자로 잘라오기
		if (i % 5 == 0) {// 5개씩 출력될때마다 구분자 출력 후 줄넘김
			System.out.printf("---------------------------------------- \n");
		}
		if (k27_taxFree[i] == true) {// 면세가 true 일때
			// 상 품 명,단 가,수량,합계 -> 칸수맞춰서 출력하고 *과 공백 출력
			System.out.printf("* %s%10s%3d%11s\n", cc, k27_df.format(k27_price[i]), k27_num[i],
					k27_df.format(k27_price[i] * k27_num[i]));
			k27_val_taxFreeTotal += k27_price[i] * k27_num[i];

		} else {// 면세가 false 일때
			// 상 품 명,단 가,수량,합계 -> 칸수맞춰서 출력하고 앞에는 공백 2칸 출력
			System.out.printf("  %s%10s%3d%11s\n", cc, k27_df.format(k27_price[i]), k27_num[i],
					k27_df.format(k27_price[i] * k27_num[i]));
			k27_val_taxAmountTotal += (k27_price[i] * k27_num[i]);
		}
	}

	private static void k27_TotalPrint() {// 합계 , 세액등을 인쇄
		// 세율 10퍼센트
		double k27_rate = 0.1;
		// 과세합계를 구하는 메소드로 전체 물건 가격 합계와 세율을 넘긴다
		int kopo_27_netprice = kopo_27_netprice(k27_val_taxAmountTotal, k27_rate);
		// 부가세 = 전체 물건 가격 합계 - 과세합계
		int kopo_27_tax = k27_val_taxAmountTotal - kopo_27_netprice;
		// 내야하는 금액
		int kopo_27_totalprice = kopo_27_netprice + kopo_27_tax + k27_val_taxFreeTotal;

		// 소비자 포인트는 낸 금액의 0.001 퍼센트
		int k27_point = kopo_27_totalprice / 1000;
		// 원래 가지고 있던 포인트
		int k27_beforePoint = 5473;
		// 최종적으로 만들어지는 포인트
		int k27_afterPoint = k27_point + k27_beforePoint;

		System.out.printf("\n%22s %12s", "총 품목 수량", k27_itemname.length);// 품목이 총 몇개인지 이름의 갯수를 센다
		System.out.printf("\n%23s %12s", "(*)면 세  물 품", k27_df.format(k27_val_taxFreeTotal));// 누적된 비과세 금액 출력
		System.out.printf("\n%23s %12s", "과 세  물 품", k27_df.format(kopo_27_netprice));// 과세합계 금액 출력
		System.out.printf("\n%24s %12s", "부   가   세", k27_df.format(kopo_27_tax));// 비과세 출력
		System.out.printf("\n%25s %12s", "합        계", k27_df.format(kopo_27_totalprice));// 내야하는 금액 출력
		System.out.printf("\n%-23s", "결 제 대 상 금 액");
		System.out.printf("%11s", k27_df.format(kopo_27_totalprice));// 내야하는 금액 출력
		System.out.printf("\n----------------------------------------");
		System.out.printf("\n%-17s", "0012 KEB 하나");// 왼쪽 정렬 후 출력
		System.out.printf("%20s", "541707**0484/35860658");
		System.out.printf("\n%-16s", "카드결제(IC)");// 왼쪽 정렬 후 출력
		System.out.printf("%s", "일시불 / ");
		System.out.printf("%11s", k27_df.format(kopo_27_totalprice));// 내야하는 금액 출력
		System.out.printf("\n----------------------------------------");
		System.out.printf("\n%22s", "[신세계포인트 적립]");
		System.out.printf("\n%-17s", "홍*두 고객님의 포인트 현황입니다.");// 왼쪽 정렬 후 출력
		System.out.printf("\n%-11s %s%10s", "금회발생포인트", " 9350**9995", k27_df.format(k27_point));// 발생하는 포인트 계산된 값을 출력
		System.out.printf("\n%-14s", "누계(가용)포인트");// 왼쪽 정렬 후 출력
		System.out.printf("%7s(", k27_df.format(k27_afterPoint));// 이전포인트에 발생한 포인트 더한 값 출력
		System.out.printf("%10s)", k27_df.format(k27_beforePoint));// 이전포인트 출력
		System.out.printf("\n%s", "*신세계포인트 유효기간은 2년입니다.");
		System.out.printf("\n----------------------------------------");
		System.out.printf("\n%21s", "구매금액기준 무료주차시간 자동부여");
		System.out.printf("\n%-4s", "차량번호 : ");// 왼쪽 정렬 후 출력
		System.out.printf("%28s", "34저****");// 오른쪽 정렬 후 출력
		System.out.printf("\n%-4s", "입차시간 : ");// 왼쪽 정렬 후 출력
		LocalDateTime k27_k = k27_TimeStamp().minusHours(2);// 현재시간에 2시간 빼기
		String k27_tk = k27_k.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));// 날짜 출력 형식 포맷팅
		System.out.printf("%29s", k27_tk);// 오른쪽 정렬 후 시간 출력
		System.out.printf("\n----------------------------------------");
		System.out.printf("\n%-10s", "캐셔:084599 양00");// 오른쪽 정렬 후 출력
		System.out.printf("%25s", "1150\n");// 왼쪽 정렬 후 출력
		String k27_formatTime1 = k27_TimeStamp().format(DateTimeFormatter.ofPattern("yyyyMMdd"));// 날짜 출력 형식 포맷팅
		System.out.printf("%15s/00119861/00164980/31", k27_formatTime1);// 왼쪽 정렬 후 출력

	}

	// 상품가격과 세율을 인자로 가지고 세전가격을 계산하는 메소드
	private static int kopo_27_netprice(int k27_val_total, double kopo_27_tax_rate) {
		// 세전가격은 전체 총합계 가격에서 1.1을 나눠주면 나오는 값 -> double로 계산하고 int로 변환해서 소수점을 내린다.
		return (int) (k27_val_total / (1 + kopo_27_tax_rate));
	}

	public static String k27_cutString2(String k27_str, int k27_len) {// 들어오는 문자열을 잘라주는 메소드
		// itemname의 i번째 문자를 str에 담아서 가져오고 바이트로 변환
		byte[] k27_by = k27_str.getBytes();
		if (k27_by.length <= 14) {// 만일 문자바이트가 14가 되기 전일때까지
			k27_str = new String(k27_by, 0, k27_by.length);
			for (int i = k27_by.length; i < 14; i++) {// -> 14를 맞춰주기위해 뒤에 모자라는 칸수만큼 공백을 채워준후 리턴
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
