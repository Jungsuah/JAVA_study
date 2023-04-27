package daily0410;

public class ppt7_1 {
	public static void main(String[] args) {
		System.out.printf("HanBlackForeword[%s]\n", HanBlackForeword("�ѱ�abcd", 15));
		System.out.printf("HanBlackForeword[%s]\n", HanBlackForeword("�ѱ�abcd", 15));
		System.out.printf("HanBlackBackword[%s]\n", HanBlackBackword("�ѱ�abcd", 15));
		System.out.printf("HanBlackBackword[%s]\n", HanBlackBackword("�ѱ�abcd", 15));
		System.out.printf("�ѱ��� [%d]��\n", HanCount("�ѱ���a"));
	}

	private static int HanCount(String string) {
		int count = 0;// ����Ʈ��
		byte[] k27_by = string.getBytes();
		for (int i = 0; i < k27_by.length; i++) {//������ ��ĭ�� 2����Ʈ��
			if ((k27_by[i] & 0x80) == 0x80) { // by[i]�� �ѱ��̸�
				count++;
			}
		}
		return count / 2;
	}

	private static String HanBlackBackword(String string, int i) {
		for (int j = 0; j < i; j++) {
			string = " " + string;
		}
		return string;
	}

	private static Object HanBlackForeword(String string, int i) {
		for (int j = 0; j < i; j++) {
			string = string + " ";
		}
		return string;
	}
}
