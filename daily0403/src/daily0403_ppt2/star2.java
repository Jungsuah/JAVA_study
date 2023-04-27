package daily0403_ppt2;

public class star2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k27_n, k27_m;
		k27_m = 20;// 층
		k27_n = 1;// 별개수

		while (true) {
			for (int k27_i = 0; k27_i < k27_m; k27_i++)// 층보다 별 개수가 작을 때까지 반복
				System.out.printf(" ");// 공백 출력
			for (int k27_i = 0; k27_i < k27_n; k27_i++)// 별 개수가 층보다 작을 때까지 반복
				System.out.printf("★");// 별 출력
			System.out.printf("\n");// 한 줄 띄기

			k27_m = k27_m - 1;// 층이 하나씩 준다.
			k27_n = k27_n + 2;// 별이 2개씩 늘어나고

			if (k27_m < 0)// 층이 0보다 작으면 break
				break;

		}

	}

}
