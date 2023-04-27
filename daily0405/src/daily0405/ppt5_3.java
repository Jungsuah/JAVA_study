package daily0405;

public class ppt5_3 {
	public static void main(String[] args) {
		int k27_iWeekday = 5;// 요일 초기화
		int[] k27_iEnd = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };// 달의 끝날짜 배열 선언
		boolean k27_yd_flag = true;// 윤년 검사

		for (int k27_iMon = 0; k27_iMon < 12; k27_iMon++) {// 0부터 11까지 반복
			System.out.printf("\n\n        %d월\n", k27_iMon + 1);// 몇 월달인지 출력
			System.out.printf("=====================\n");// 출력
			System.out.printf(" 일 월 화 수 목 금 토\n");// 출력

			if (k27_yd_flag == true) {// 윤년이 true면
				k27_iEnd[1] = 29;// 끝날짜가 29일이고
			} else {
				k27_iEnd[1] = 28;// 아니면 끝날짜가 28일이다.
			}

			int k27_dayOfWeek = k27_iWeekday;// k27_iWeekday를 k27_dayOfWeek에 대입

			for (int k27_i = 1; k27_i <= k27_iEnd[k27_iMon]; k27_i++) {
				// 1부터 k27_End[k27_iMon]의 배열의 인덱스 값만큼 반복히면서 1씩 증가시킨다.(일 출력)
				if (k27_i == 1) {// 1일일 때
					for (int k27_j = 0; k27_j < k27_dayOfWeek; k27_j++) {
						// 0부터 k27_dayOfWeek 값 전까지 반복해라.
						System.out.printf("%3s", "");
					} // k27_dayOfWeek만큼 빈칸 출력
				}
				System.out.printf("%3d", k27_i);// 칸수 맞춰서 오른쪽 정렬로 출력
				k27_iWeekday++;// 요일 증가

				if (k27_iWeekday == 7) {// 요일일 일요일이면
					k27_iWeekday = 0;// 0으로 바꿔줌
					System.out.printf("\n");// 다음 줄로
				}
			}

		}
	}
}
