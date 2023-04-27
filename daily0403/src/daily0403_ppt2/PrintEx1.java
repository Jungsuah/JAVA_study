package daily0403_ppt2;

public class PrintEx1 {

	public static void main(String[] args) {

		byte k27_b = 1;// 변수 선언 및 초기화
		short k27_s = 2;// 변수 선언 및 초기화
		char k27_c = 'A';// 변수 선언 및 초기화

		int k27_finger = 10;// 변수 선언 및 초기화
		long k27_big = 100000000000000L;// 변수 선언 및 초기화
		long k27_hex = 0xFFFFFFFFFFFFFFFFL;// 변수 선언 및 초기화 long hex = 0xFFFFFFFFFFFFFFFFL;

		int k27_octNum = 010; // 8진수 10, 10진수로는 8
		int k27_hexNum = 0x10; // 16진수 10, 10진수로는 16
		int k27_binNum = 0b10; // 2진수 10, 10진수로는 2

		System.out.printf("b=%d\n", k27_b);// 정수형으로 출력
		System.out.printf("s=%d\n", k27_s);// 정수형으로 출력
		System.out.printf("c=%c, %d \n", k27_c, (int) k27_c);// 문자형, 정수형으로 출력
		System.out.printf("finger = [%5d]\n", k27_finger);// 오른쪽 정렬
		System.out.printf("finger = [%-5d]\n", k27_finger);// 왼쪽 정렬
		System.out.printf("finger = [%05d]\n", k27_finger);// 남은자리를 0으로 출력하고 오른쪽 정렬
		System.out.printf("big = %d\n", k27_big);// 정수형으로 출력
		System.out.printf("hex = %#x\n", k27_hex); // '#'은 접두사(16진수 0x, 8진수 0)
		System.out.printf("octNum = %o, %d\n", k27_octNum, k27_octNum);// 8진수, 정수형으로 출력
		System.out.printf("hexNum = %x, %d\n", k27_hexNum, k27_hexNum);// 16진수, 정수형으로 출력
		System.out.printf("binNum = %s, %d\n", Integer.bitCount(k27_binNum), k27_binNum);// Integer.bitCountsms num숫자를
																							// binary로 변환 후, 1의 수를 반환
																							// 문자형, 정수형으로 출력

	}

}
