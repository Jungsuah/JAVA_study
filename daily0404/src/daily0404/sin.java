package daily0404;

public class sin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 360도: 2pi = 1도:x

		double k27_fSin;// 변수 선언
		for (int k27_i = 0; k27_i < 360; k27_i++) {// 0도부터 359도까지 반복
			k27_fSin = Math.sin(k27_i * 3.141592 / 180);// 1도씩 증가 하면서 각도에 대해서 해당하는 사인 값 계산
			System.out.printf("%d sin ==> %f\n", k27_i, k27_fSin);// 360도까지 값이 어떻게 나오나 출력
		}
		for (int k27_i = 0; k27_i < 360; k27_i++) {// 0도부터 359도까지 반복
			k27_fSin = Math.sin(k27_i * 3.141592 / 180);// 1도씩 증가 하면서 각도에 대해서 해당하는 사인 값 계산

			int k27_iSpace = (int) ((1.0 + k27_fSin) * 50);// int형으로 형변환
			// 1을 더하는 이유는 -1~1범위에서 -1을 양수로 만들어주기 위해서 그리고 *50을 함으로써 공백 개수 계산
			for (int k27_j = 0; k27_j < k27_iSpace; k27_j++)// k27_iSpace만큼 빈칸을 출력
				System.out.printf(" ");// 공백 출력
			System.out.printf("*[%f][%d]\n", k27_fSin, k27_iSpace);// 실수형 정수형으로 출력

		}
	}

}
