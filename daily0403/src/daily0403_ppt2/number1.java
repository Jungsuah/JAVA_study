package daily0403_ppt2;

public class number1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] k27_units = { "영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" };// 배열 선언
		for (int k27_i = 0; k27_i < 101; k27_i++) {// 0부터 100까지 반복
			if (k27_i >= 0 && k27_i < 10) {// k27_i가 0보다 크거나 같고 10보다 작을 때
				System.out.printf("일의 자리 : %s\n", k27_units[k27_i]);// 출력
			} else if (k27_i >= 10 && k27_i < 100) {// k27_i가 10보다 크거나 같고,100보다 작을 떄
				int k27_i10, k27_i0;// 변수 선언
				k27_i10 = k27_i / 10;// 십의자리
				k27_i0 = k27_i % 10;// 일의 자리
				if (k27_i0 == 0) {// 일의자리가 0일 떄
					System.out.printf("십의자리 : %s십\n", k27_units[k27_i10]);// 출력
				} else {
					System.out.printf("십의자리 : %s십%s\n", k27_units[k27_i10], k27_units[k27_i0]);// 아니면 이거출력

				}
			} else
				System.out.printf("==> %d\n", k27_i);// 반복한 횟수 출력
		}

	}

}
