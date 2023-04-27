package daily0404;

public class for2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k27_sum = 0;
		for (int k27_i = 0; k27_i < 10; k27_i++) {// 0부터 9까지 반복해라
			k27_sum = k27_sum + k27_i;// 누적합 구하기
		}
		System.out.printf("k27_sum %d\n", k27_sum);// 누적합 구한 거 출력

		for (int k27_i = 1; k27_i < 10; k27_i++) {// 1부터 9까지 바복해라
			System.out.printf("**********************\n", k27_i);
			System.out.printf("     구구단 %d 단\n", k27_i);// for문 돌면서 단 수 증가
			System.out.printf("**********************\n", k27_i);

			for (int k27_j = 1; k27_j < 10; k27_j++) {// 1부터 9까지 반복해라
				System.out.printf(" %d * %d = %d \n", k27_i, k27_j, k27_i * k27_j);
				// i가 한번 돌때 j가 9번 돌면서 곱한값 출력
			}

		}

	}

}
