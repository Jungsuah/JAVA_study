package daily0403_ppt2;

public class CastingEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int k27_i = 10;// ���� ���� �� �ʱ�ȭ
		byte k27_b = (byte) k27_i;// byte�� ����ȭ �� ����
		System.out.printf("[int -> byte] i = %d -> b = %d%n", k27_i, k27_b);// ���

		k27_i = 300;// ���� ���� �� �ʱ�ȭ
		k27_b = (byte) k27_i;// byte�� ����ȭ �� ����
		System.out.printf("[int -> byte] i = %d -> b = %d%n", k27_i, k27_b);// ���

		k27_b = 10;// ���� ���� �� �ʱ�ȭ
		k27_i = (byte) k27_b;// byte�� ����ȭ �� ����
		System.out.printf("[byte -> int] b = %d -> i = %d%n", k27_b, k27_i);// ���

		k27_b = -2;// ���� ���� �� �ʱ�ȭ
		k27_i = (byte) k27_i;// byte�� ����ȭ �� ����
		System.out.printf("[byte -> int] b = %d -> i = %d%n", k27_b, k27_i);// ���

		System.out.println("i=" + Integer.toBinaryString(k27_i));// 2������ ��ȯ �� ���������� ���
	}

}
