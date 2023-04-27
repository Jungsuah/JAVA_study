package daily0403;

public class ppt3_2 {
	public static void main(String[] args) {
		int kopo_27_ii = 1000 / 3; // 1000 / 3을 연산한 값을 int형 변수에 대입
		System.out.printf(" #3-1 : %d\n", kopo_27_ii);// printf로 변수 출력

		kopo_27_ii = 1000 % 3; // 1000 / 3을 연산한 나머지를 int형 변수에 대입
		System.out.printf(" #3-2 : %d\n", kopo_27_ii);// printf로 변수 출력

		// i - 초기값 - 0이고 i가 20보다 작아지기전까지 반복
		for (int kopo_27_i = 0; kopo_27_i < 20; kopo_27_i++) {
			System.out.printf(" #3-3 : %d", kopo_27_i);// printf로 변수 출력

			if ((kopo_27_i + 1) % 5 == 0) {// 0 나누기 0은 무조건 0임으로 i가 0부터 시작하면 무조건 줄바꿈을 하기 때문에 i+1을 해서 1부터 시작하게 만든다.
				System.out.printf("\n");// 5개 마다 줄바꿈
			}
		}
	}
}
