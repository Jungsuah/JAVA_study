package daily0404;

public class calendar2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int k27_i = 1; k27_i < 13; k27_i++) {// 1부터 12까지 반복(월)
			System.out.printf(" %d월 =>", k27_i);

			for (int k27_j = 1; k27_j < 32; k27_j++) {// 1부터 31까지 반복(일)
				System.out.printf("%d,", k27_j);

				if (k27_i == 4 || k27_i == 6 || k27_i == 9 || k27_i == 7 || k27_i == 1) {
					// 월이 4월이거나 6월이거나 9월이거나 7월이거나 1월일 경우
						
					if (k27_j == 30)// 일이 30일일 때
						break;
				}
				if (k27_i == 2) {// 월이 2월일 때
					if (k27_j == 28)// 일이 28일일 때
						break;
				}
			}
			System.out.printf("\n");// 한 줄 띄기
		}
	}

}
