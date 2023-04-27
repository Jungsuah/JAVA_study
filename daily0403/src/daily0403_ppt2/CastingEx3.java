package daily0403_ppt2;

public class CastingEx3 {

	public static void main(String[] args) {
		float k27_f = 9.1234567f;// 변수 선언 및 초기화
		double k27_d = 9.1234567;// 변수 선언 및 초기화
		double k27_d2 = (double) k27_f;// double로 형변환 후 대입

		System.out.printf(" f = %20.18f\n", k27_f);// float형으로 출력
		System.out.printf(" d = %20.18f\n", k27_d);// float형으로 출력
		System.out.printf(" d2 = %20.18f\n", k27_d2);// float형으로 출력
	}

}
