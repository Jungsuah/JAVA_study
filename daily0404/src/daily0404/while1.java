package daily0404;

public class while1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int k27_i = 2; k27_i <= 9; k27_i++) {
			for (int k27_j = 1; k27_j <= 9; k27_j++) {
				System.out.println(k27_i + " * " + k27_j + " = " + k27_i * k27_j);
			}
		}
		int k27_i = 2;// 변수 선언 및 초기화
		while (k27_i <= 9) {// i가 9보다 작거나 같을 때까지 반복
			int k27_j = 1;// 변수 선언 및 초기화
			while (k27_j <= 9) {// j가 9보다 작거나 같을 때까지 반복
				System.out.println(k27_i + " * " + k27_j + " = " + k27_i * k27_j);// 출력
				k27_j++;// j를 +1 해준다.

			}
			k27_i++;// i를 +1 해준다.
		}

	}

}
