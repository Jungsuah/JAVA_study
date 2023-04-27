package daily0404;

public class case1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int k27_i = 1; k27_i < 13; k27_i++) {// 1부터 12까지 반복
			System.out.printf(" %d월 =>", k27_i);
			LOOP: for (int k27_j = 1; k27_j < 32; k27_j++) {// 1부터 31일 까지 반복
				System.out.printf("%d,", k27_j);

				switch (k27_i) {
				case 4:
				case 6:
				case 9:
				case 7:
				case 11: // 4월, 6월, 9월, 7월, 11월일 경우
					if (k27_j == 30)// 일이 30일이면 LOOP를 빠져나간다.
						break LOOP;//LOOP문 탈출
					// 거의 이런 표현 안 함
					// LOOP라는 표시자가 없으면 엉뚱한 결과
					break;//case문 탈출
				case 2: if(k27_j==28) break LOOP;//LOOP문 탈출
					break;//case문 탈출
				}
			}
			System.out.printf("\n");// 한 줄 띄기
		}

	}

}
