package ClassTest;

public class TvRemocon1 {

	static TvRemocon tvRe_k27;// ������ static���� �����ؼ� �ٷ� �����ְ� �����

	public static void main(String[] args) {
		tvRe_k27 = new TvRemocon(); // ���ο� ��ü ����

		for (int i_k27 = 0; i_k27 < 10; i_k27++) {//10�� �ݺ�
			tvRe_k27.ChannelUp_k27();//ä�� 10�� ����
		}
		System.out.println();//�ٳѱ�

		for (int i_k27 = 0; i_k27 < 10; i_k27++) {//10�� �ݺ�
			tvRe_k27.ChannelDn_k27();//ä�� 10�� ����
		}
		System.out.println();//�ٳѱ�

		for (int i_k27 = 0; i_k27 < 5; i_k27++) {//5�� �ݺ�
			tvRe_k27.VolUp_k27();//���� 5�� ����
		}
		System.out.println();//�ٳѱ�

		for (int i_k27 = 0; i_k27 < 5; i_k27++) {//5�� �ݺ�
			tvRe_k27.VolDn_k27();//���� 5�� ����
		}
	}
}
