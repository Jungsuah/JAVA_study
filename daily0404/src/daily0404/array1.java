package daily0404;

public class array1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] k27_iLMD = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };// 배열 선언
		// 단 배열은 0부터 시작한다는 것에 유의
		// iLMD[0] ~ iLMD[11]이다.

		for (int k27_i = 1; k27_i < 13; k27_i++) {// 1부터 12까지 반복
			System.out.printf(" %d월 =>", k27_i);
			for (int k27_j = 1; k27_j < 32; k27_j++) {// 1부터 31까지 반복
				System.out.printf("%d", k27_j);

				if (k27_iLMD[k27_i - 1] == k27_j)
					break;
				System.out.print(",");// 마지막일 콤마 안 찍기

			}
			System.out.printf("\n");
		}
	}

}
