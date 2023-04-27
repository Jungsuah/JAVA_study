package daily0403_ppt2;

public class CastingEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int k27_i = 91234567;// 8자리의 10진수
		float k27_f = (float) k27_i;// int를 float로 형변환
		int k27_i2 = (int) k27_f;// float를 다시 int로 형변환

		double k27_d = (double) k27_i;// int를 double로 형변환
		int k27_i3 = (int) k27_d;// double을 다시 int로 형변환

		float k27_f2 = 1.666f;// float형으로 선언
		int k27_i4 = (int) k27_f2;// float를 int로 형변환

		System.out.printf("i = %d\n", k27_i);// 정수형으로 출력
		System.out.printf("f= %f i2 = %d\n", k27_f, k27_i2);// float형, 정수형으로 출력
		System.out.printf("d=%f i3=%d\n", k27_d, k27_i3);// float형, 정수형으로 출력
		System.out.printf("(int)%f = %d\n", k27_f2, k27_i4);// float형, 정수형으로 출력

	}

}
