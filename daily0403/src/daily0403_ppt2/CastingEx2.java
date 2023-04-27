package daily0403_ppt2;

public class CastingEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int k27_i = 10;// 변수 선언 및 초기화
		byte k27_b = (byte) k27_i;// byte로 형변화 후 대입
		System.out.printf("[int -> byte] i = %d -> b = %d%n", k27_i, k27_b);// 출력

		k27_i = 300;// 변수 선언 및 초기화
		k27_b = (byte) k27_i;// byte로 형변화 후 대입
		System.out.printf("[int -> byte] i = %d -> b = %d%n", k27_i, k27_b);// 출력

		k27_b = 10;// 변수 선언 및 초기화
		k27_i = (byte) k27_b;// byte로 형변화 후 대입
		System.out.printf("[byte -> int] b = %d -> i = %d%n", k27_b, k27_i);// 출력

		k27_b = -2;// 변수 선언 및 초기화
		k27_i = (byte) k27_i;// byte로 형변화 후 대입
		System.out.printf("[byte -> int] b = %d -> i = %d%n", k27_b, k27_i);// 출력

		System.out.println("i=" + Integer.toBinaryString(k27_i));// 2진수로 변환 후 문자형으로 출력
	}

}
