package daily0403_ppt2;

public class PrintEx1 {

	public static void main(String[] args) {

		byte k27_b = 1;// ���� ���� �� �ʱ�ȭ
		short k27_s = 2;// ���� ���� �� �ʱ�ȭ
		char k27_c = 'A';// ���� ���� �� �ʱ�ȭ

		int k27_finger = 10;// ���� ���� �� �ʱ�ȭ
		long k27_big = 100000000000000L;// ���� ���� �� �ʱ�ȭ
		long k27_hex = 0xFFFFFFFFFFFFFFFFL;// ���� ���� �� �ʱ�ȭ long hex = 0xFFFFFFFFFFFFFFFFL;

		int k27_octNum = 010; // 8���� 10, 10�����δ� 8
		int k27_hexNum = 0x10; // 16���� 10, 10�����δ� 16
		int k27_binNum = 0b10; // 2���� 10, 10�����δ� 2

		System.out.printf("b=%d\n", k27_b);// ���������� ���
		System.out.printf("s=%d\n", k27_s);// ���������� ���
		System.out.printf("c=%c, %d \n", k27_c, (int) k27_c);// ������, ���������� ���
		System.out.printf("finger = [%5d]\n", k27_finger);// ������ ����
		System.out.printf("finger = [%-5d]\n", k27_finger);// ���� ����
		System.out.printf("finger = [%05d]\n", k27_finger);// �����ڸ��� 0���� ����ϰ� ������ ����
		System.out.printf("big = %d\n", k27_big);// ���������� ���
		System.out.printf("hex = %#x\n", k27_hex); // '#'�� ���λ�(16���� 0x, 8���� 0)
		System.out.printf("octNum = %o, %d\n", k27_octNum, k27_octNum);// 8����, ���������� ���
		System.out.printf("hexNum = %x, %d\n", k27_hexNum, k27_hexNum);// 16����, ���������� ���
		System.out.printf("binNum = %s, %d\n", Integer.bitCount(k27_binNum), k27_binNum);// Integer.bitCountsms num���ڸ�
																							// binary�� ��ȯ ��, 1�� ���� ��ȯ
																							// ������, ���������� ���

	}

}
