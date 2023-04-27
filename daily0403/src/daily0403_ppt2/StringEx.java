package daily0403_ppt2;

public class StringEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String k_31_name = "Ja" + "va";// 문자형으로 변수선언
		String k_31_str = k_31_name + 8.0;// 문자형으로 변수 선언

		System.out.println(k_31_name);// java출력
		System.out.println(k_31_str);// 문자형이니까 java8.0으로 출력
		System.out.println(7 + " ");// 7이랑 뒤에 공백 출력
		System.out.println(" " + 7);// 공백 출력한 뒤 7 출력
		System.out.println(7 + " ");// 7이랑 뒤에 공백 출력
		System.out.println(" " + 7);// 공백 출력한 뒤 7 출력
		System.out.println(" " + " ");// 공백 출력
		System.out.println(7 + 7 + " ");// 7+7인 14를 출력한 다음 공백 출력
		System.out.println(" " + 7 + 7);// 공백더하기 7을 하면 7도 문자가 되고 그다음 7도 문자와
										// 더함으로써 문자가 되서 공백 77이 출력됨

	}

}
