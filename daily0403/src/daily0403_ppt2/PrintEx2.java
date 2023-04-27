package daily0403_ppt2;

public class PrintEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String k27_url = "www.codechobo.com";

		float k27_f1 = .10f;// 0.10,1.0e-1
		float k27_f2 = 1e1f;// 10.0,1.031,1.0e+1
		float k27_f3 = 3.14e3f;// 변수 선언
		double k27_d = 1.23456789;// 변수 선언

		System.out.printf("f1= %f, %e, %g%n", k27_f1, k27_f1, k27_f1);// float형, 부동소수점 실수,소수점 이하 자리수가 고정 또는 부동소수점으로 출력
		System.out.printf("f2= %f, %e, %g%n", k27_f2, k27_f2, k27_f2);// float형, 부동소수점 실수,소수점 이하 자리수가 고정 또는 부동소수점으로 출력
		System.out.printf("f3= %f, %e, %g%n", k27_f3, k27_f3, k27_f3);// float형, 부동소수점 실수,소수점 이하 자리수가 고정 또는 부동소수점으로 출력

		System.out.printf("d = %f%n", k27_d);// float형 실수형으로 출력
		System.out.printf("d = %14.10f%n", k27_d);// 전체 14자리 중 소수점 10자리

		System.out.printf("[12345678901234567890]%n");
		System.out.printf("[%s]%n", k27_url);// 문자열로 출력
		System.out.printf("[%20s]%n", k27_url);// 20자리 문자열 출력
		System.out.printf("[%-20s]%n", k27_url);// 오른쪽 정렬
		System.out.printf("[%.8s]%n", k27_url);// 왼쪽에서 8글자만 출력

	}

}
