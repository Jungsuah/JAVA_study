package daily0403_ppt2;

public class PrintEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String k27_url = "www.codechobo.com";

		float k27_f1 = .10f;// 0.10,1.0e-1
		float k27_f2 = 1e1f;// 10.0,1.031,1.0e+1
		float k27_f3 = 3.14e3f;// ���� ����
		double k27_d = 1.23456789;// ���� ����

		System.out.printf("f1= %f, %e, %g%n", k27_f1, k27_f1, k27_f1);// float��, �ε��Ҽ��� �Ǽ�,�Ҽ��� ���� �ڸ����� ���� �Ǵ� �ε��Ҽ������� ���
		System.out.printf("f2= %f, %e, %g%n", k27_f2, k27_f2, k27_f2);// float��, �ε��Ҽ��� �Ǽ�,�Ҽ��� ���� �ڸ����� ���� �Ǵ� �ε��Ҽ������� ���
		System.out.printf("f3= %f, %e, %g%n", k27_f3, k27_f3, k27_f3);// float��, �ε��Ҽ��� �Ǽ�,�Ҽ��� ���� �ڸ����� ���� �Ǵ� �ε��Ҽ������� ���

		System.out.printf("d = %f%n", k27_d);// float�� �Ǽ������� ���
		System.out.printf("d = %14.10f%n", k27_d);// ��ü 14�ڸ� �� �Ҽ��� 10�ڸ�

		System.out.printf("[12345678901234567890]%n");
		System.out.printf("[%s]%n", k27_url);// ���ڿ��� ���
		System.out.printf("[%20s]%n", k27_url);// 20�ڸ� ���ڿ� ���
		System.out.printf("[%-20s]%n", k27_url);// ������ ����
		System.out.printf("[%.8s]%n", k27_url);// ���ʿ��� 8���ڸ� ���

	}

}
