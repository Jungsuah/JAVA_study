package ClassTest;

public class TvRemocon2Main {

	static TvRemocon2_k27 tvRe_k27;

	public static void main(String[] args) {
		// ��ä ä�ΰ� ���� �Է�
		tvRe_k27 = new TvRemocon2_k27(); //���ο� ��ü ����
		System.out.println();

		for (int i_k27 = 0; i_k27 < 10; i_k27++) {//10�� ä�� ����
			tvRe_k27.ChannelUp_k27();//������ ȣ��
			tvRe_k27.msg2("ä�� 10�� �ø���");//���
		}
		System.out.println();

		for (int i_k27 = 0; i_k27 < 10; i_k27++) {//10�� ä�� ����
			tvRe_k27.ChannelDn_k27();//������ ȣ��
			tvRe_k27.msg2("ä�� 10�� ������");//���
		}
		System.out.println();

		for (int i_k27 = 0; i_k27 < 5; i_k27++) {//5�� ä�� ����
			tvRe_k27.VolUp_k27();//������ ȣ��
			tvRe_k27.msg1("���� 5�� �ø���");//���
		}
		System.out.println();

		for (int i_k27 = 0; i_k27 < 5; i_k27++) {//5�� ä�� ����
			tvRe_k27.VolDn_k27();//������ ȣ��
			tvRe_k27.msg1("���� 5�� ������");//���
		}
	}
}
