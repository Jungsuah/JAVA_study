package daily0403_ppt2;

public class CastingEx3 {

	public static void main(String[] args) {
		float k27_f = 9.1234567f;// ���� ���� �� �ʱ�ȭ
		double k27_d = 9.1234567;// ���� ���� �� �ʱ�ȭ
		double k27_d2 = (double) k27_f;// double�� ����ȯ �� ����

		System.out.printf(" f = %20.18f\n", k27_f);// float������ ���
		System.out.printf(" d = %20.18f\n", k27_d);// float������ ���
		System.out.printf(" d2 = %20.18f\n", k27_d2);// float������ ���
	}

}
