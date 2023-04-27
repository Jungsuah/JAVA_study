package daily0403_ppt2;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String k_31_s = "12345";// 문자형 변수 선언
		int k_31_i = Integer.parseInt(k_31_s);// 문자형 변수를 정수형으로 형변환

		System.out.printf("문자를 숫자로 %d  (%d)  \n", k_31_i, k_31_i + 10);// 정수형으로 출력

		String k_31_a;// 문자형 변수 선언
		k_31_a = String.format("%d", k_31_i);// 정수형 형식으로 설정
		System.out.printf("숫자를 문자로 %s  (%s)  \n", k_31_a, k_31_a + "abcde");// 문자형으로 출력

	}

}