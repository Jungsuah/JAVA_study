package daily0403_ppt2;

public class Overflow {

	public static void main(String[] args) {
		short k27_sMin = -32768;// 변수 선언 및 초기화
		short k27_sMax = 32767;// 변수 선언 및 초기화
		char k27_cMin = 0;// 변수 선언 및 초기화
		char k27_cMax = 65535;// 변수 선언 및 초기화

		System.out.println(" sMin = " + k27_sMin);// 출력
		System.out.println(" k27_sMin -1 = " + (short) (k27_sMin - 1));// 연산 후 출력
		System.out.println(" sMax = " + k27_sMax);// 출력
		System.out.println(" k27_sMax +1 = " + (short) (k27_sMax + 1));// 연산후 출력
		System.out.println(" cMin = " + (int) k27_cMin);// 출력
		System.out.println(" cMin-1 = " + (int) --k27_cMin);// 연산 후 출력
		System.out.println(" cMax = " + (int) k27_cMax);// 출력
		System.out.println(" cMax +1 = " + (int) ++k27_cMax);// 연산 후 출력
	}

}
