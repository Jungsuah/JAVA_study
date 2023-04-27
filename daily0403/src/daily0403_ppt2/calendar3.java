package daily0403_ppt2;

public class calendar3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int k27_i = 1; k27_i < 13; k27_i++) {// 1부터 12까지 반복(월)
			System.out.printf(" %d월 =>", k27_i);

			for (int k27_j = 1; k27_j < 32; k27_j++) {// 1부터 31까지 반복(일)
				System.out.printf("%d,", k27_j);

				if ((k27_i == 4 || k27_i == 6 || k27_i == 9 || k27_i == 7 || k27_i == 1) && (k27_j == 30)) {
					// 월이 4월이거나 6월이거나 9월이거나 7월이거나 1일이고, 일이 30일일 때
					break;// 나간다.
				}
				if (k27_i == 2 && k27_j == 28) {// 월이 2월이고, 일이 28일일 때
					break;
				}
			}
			System.out.printf("\n");// 한 줄 띄기
		}
		// 2중 for문으로 k27_i가 1번 돌 때 k27_j가 31번 돈다.
	}

}
