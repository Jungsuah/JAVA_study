package daily0403_ppt2;

public class Overflow {

	public static void main(String[] args) {
		short k27_sMin = -32768;// ���� ���� �� �ʱ�ȭ
		short k27_sMax = 32767;// ���� ���� �� �ʱ�ȭ
		char k27_cMin = 0;// ���� ���� �� �ʱ�ȭ
		char k27_cMax = 65535;// ���� ���� �� �ʱ�ȭ

		System.out.println(" sMin = " + k27_sMin);// ���
		System.out.println(" k27_sMin -1 = " + (short) (k27_sMin - 1));// ���� �� ���
		System.out.println(" sMax = " + k27_sMax);// ���
		System.out.println(" k27_sMax +1 = " + (short) (k27_sMax + 1));// ������ ���
		System.out.println(" cMin = " + (int) k27_cMin);// ���
		System.out.println(" cMin-1 = " + (int) --k27_cMin);// ���� �� ���
		System.out.println(" cMax = " + (int) k27_cMax);// ���
		System.out.println(" cMax +1 = " + (int) ++k27_cMax);// ���� �� ���
	}

}
