package daily0403_ppt2;

public class CastingEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int k27_i = 91234567;// 8�ڸ��� 10����
		float k27_f = (float) k27_i;// int�� float�� ����ȯ
		int k27_i2 = (int) k27_f;// float�� �ٽ� int�� ����ȯ

		double k27_d = (double) k27_i;// int�� double�� ����ȯ
		int k27_i3 = (int) k27_d;// double�� �ٽ� int�� ����ȯ

		float k27_f2 = 1.666f;// float������ ����
		int k27_i4 = (int) k27_f2;// float�� int�� ����ȯ

		System.out.printf("i = %d\n", k27_i);// ���������� ���
		System.out.printf("f= %f i2 = %d\n", k27_f, k27_i2);// float��, ���������� ���
		System.out.printf("d=%f i3=%d\n", k27_d, k27_i3);// float��, ���������� ���
		System.out.printf("(int)%f = %d\n", k27_f2, k27_i4);// float��, ���������� ���

	}

}
