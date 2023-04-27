package daily0404;

public class if1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int k27_iI;// 변수 선언
		double k27_iD;// 변수 선언

		k27_iI = 10 / 3;// 초기화
		k27_iD = 10 / 3.0;// 초기화

		// int 와 double 은 정수형연산과 실수형연산이므로 같지 않다.
		if (k27_iI == k27_iD)
			System.out.printf("equla\n");// k27_iI 와 k27_iD가 같을 경우 equal을 출력
		else
			System.out.printf("Not equal[%f][%f]\n", (double) k27_iI, k27_iD);// 같지 않을 경우 출력

		// 단지 유효숫자까지 표시된 것 뿐이지 다르다.
		if (k27_iD == 3.333333)
			System.out.printf("equal\n");// k27_iD가 3.333333과 같은면 추력
		else
			System.out.printf("Not equal[3.333333][%f]\n", k27_iD);// 다를 경우 출력

		k27_iD = (int) k27_iD;// k27_iD를 int로 형변환했으므로 같다
		if (k27_iI == k27_iD)
			System.out.printf("equal\n");// k27_iI 와 k27_iD가 같을 경우 equal을 출력
		else
			System.out.printf("Not equal[%f][%f]\n", (double) k27_iI, k27_iD);// 같지 않을 경우 출력

		System.out.printf("int로 인쇄[%d][%f]\n", k27_iI, k27_iD);// k27_iI를 int로 인쇄하면 3
		System.out.printf("double로 인쇄 [%f][%f]\n", (double) k27_iI, k27_iD);// k27_iI를 double로 인쇄하면 3.333333

		char k27_a = 'c';// 변수 선언
		if (k27_a == 'b')// k27_a와 b가 같으면
			System.out.printf("a는 b이다\n");// 출력
		if (k27_a == 'c')// k27_a와 c가 같으면
			System.out.printf("a는 c이다\n");// 출력
		if (k27_a == 'd')// k27_a와 d가 같으면
			System.out.printf("a는 d이다\n");// 출력

		String k27_aa = "abcd";// 변수 선언

		if (k27_aa.equals("abcd"))// 문자와 비교할 때는 == 대신에 equals를 쓴다.
			System.out.printf("aa는 abcd이다\n");// k27_aadhk abcd가 같으면 출력
		else
			System.out.printf("aa는 abcd이 아니다\n");// 아니면 출력

		boolean k27_bb = true;// k27_bb을 기본적으로 true로 선언
		if (!!k27_bb)// 만약 k27_bb이(!가 not인데 !!이므로 true) true이면
			System.out.printf("bb가 아니면 참이다.\n");// 출력
		else
			System.out.printf("bb가 아니면 거짓이다\n");// 아니면 출력

	}

}
