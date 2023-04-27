package daily0403_ppt2;

public class VarEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k_31_x = 10;// 변수 선언하고 10으로 초기화
		int k_31_y = 20;// 변수 선언하고 20으로 초기화
		int k_31_tmp = 0;// 변수 선언하고 0으로 초기화

		System.out.println("k_31_x:" + k_31_x + " k_31_y:" + k_31_y);// 출력

		// 값 교환시 tmp 사용
		k_31_tmp = k_31_x;// 변수 선언
		k_31_x = k_31_y;// 변수 선언
		k_31_y = k_31_tmp;// 변수 선언

		System.out.println("k_31_x:" + k_31_x + " k_31_y:" + k_31_y);// 출력

	}

}
