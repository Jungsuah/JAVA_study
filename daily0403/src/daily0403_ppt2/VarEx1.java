package daily0403_ppt2;

public class VarEx1 {// 클래스 선언

	public static void main(String[] args) {// 메인으로부터 프로그램 시작
		// TODO Auto-generated method stub
		int k27_year = 0;// year라는 숫자형 변수를 정의하고 0으로 초기화
		int k27_age = 14;// age라는 숫자형 변수를 정의하고 14로 초기화

		System.out.println("결과1 :" + k27_year);// year변수를 화면에 출력
		System.out.println("결과2 :" + k27_age);// age변수를 화면에 출력

		k27_year = k27_age + 2000;// 변수 age의 값에 2000을 더해서 변수 year에 저장
		k27_age = k27_age + 1;// 변수 age에 저장된 값을 1 증가시킨다.

		System.out.println("결과3 :" + k27_year);// 다시 year 변수를 화면에 출력
		System.out.println("결과3 :" + k27_age);// 다시 age 변수를 화면에 출력

	}

}
