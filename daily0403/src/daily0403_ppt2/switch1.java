package daily0403_ppt2;

public class switch1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String k27_jumin = "123456-1234567";// ���� ����
		switch (k27_jumin.charAt(7)) {
		case '1':
			System.out.printf("20������ �¾ ���� ���\n");// 7��° �ڸ� ���� 1�� ��
		case '2':
			System.out.printf("20������ �¾ ���� ���\n");// 7��° �ڸ� ���� 2�� ��
			break;// switch ���� ������.
		case '3':
			System.out.printf("20������ �¾ ���� ���\n");// 7��° �ڸ� ���� 3�� ��
			break;// switch ���� ������.
		case '4':
			System.out.printf("20������ �¾ ���� ���\n");// 7��° �ڸ� ���� 4�� ��
			break;// switch ���� ������.
		default:
			System.out.printf("���\n");// �� �ƴ� ��
			break;// switch ���� ������.

		// case '1'�� break���� �����Ƿ� case2���� ����ϰ� ������.
		}
	}

}
