package daily0403_ppt2;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String k_31_s = "12345";// ������ ���� ����
		int k_31_i = Integer.parseInt(k_31_s);// ������ ������ ���������� ����ȯ

		System.out.printf("���ڸ� ���ڷ� %d  (%d)  \n", k_31_i, k_31_i + 10);// ���������� ���

		String k_31_a;// ������ ���� ����
		k_31_a = String.format("%d", k_31_i);// ������ �������� ����
		System.out.printf("���ڸ� ���ڷ� %s  (%s)  \n", k_31_a, k_31_a + "abcde");// ���������� ���

	}

}