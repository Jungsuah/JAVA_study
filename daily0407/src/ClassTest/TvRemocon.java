package ClassTest;

public class TvRemocon {
	int channel_k27 = 0;//������ ���� ����
	int volum_k27 = 0;//������ ���� ����
	int limit_up_channel = 10;//�ִ�ä�� ���� ������ ���� ����
	int limit_down_channel = 0;//�ּ�ä�� ���� ������ ���� ����
	int limit_up_volum = 5;//�ִ뺼�� ���� ������ ���� ����
	int limit_down_volum = 0;//�ּҺ��� ���� ������ ���� ����
	String help_k27;//������ ���� ����

	public void VolUp_k27() {//���� �ø��� �޼ҵ� �����
		if (volum_k27 == limit_up_volum) {//���࿡ �ִ� �����̶� ���纼���� ���ٸ�
			help_k27 = "�ִ뺼���Դϴ�.";//�ִ뺼���ΰ��� �˷��ֱ�
		}else {
			volum_k27++;//�׷��� ������ ��� ���� ����
			help_k27 = String.format("������ %d�Դϴ�", volum_k27);//help ������ ������ ���� volum_k27�� �ֱ�
		}
		System.out.println(help_k27);//���
	}

	public void VolDn_k27() {//���� ������ �޼ҵ� �����
		if (volum_k27 == limit_down_channel) {//���࿡ �ּ� �����̶� ���纼���� ���ٸ�
			help_k27 = "�ּҺ����Դϴ�.";//�ּҺ����ΰ��� �˷��ֱ�
		}else {
			volum_k27--;//�׷��� ������ ��� ���� ����
			help_k27 = String.format("������ %d�Դϴ�", volum_k27);//help ������ ������ ���� volum_k27�� �ֱ�
		}
		System.out.println(help_k27);//���
	}

	public void ChannelUp_k27() {//ä�� �ø��� �޼ҵ� �����
		if (channel_k27 == limit_up_channel) {//���࿡ �ִ�ä���̶� ����ä���� ���ٸ�
			help_k27 = "�ִ�ä���Դϴ�.";//�ִ�ä���ΰ��� �˷��ֱ�
		}else {
			channel_k27++;//�׷��� ������ ��� ä�� ����
			help_k27 = String.format("ä���� %d�Դϴ�", channel_k27);//help ������ ������ ���� channel_k27�� �ֱ�
		}
		System.out.println(help_k27);//���
	}

	public void ChannelDn_k27() {//ä�� ������ �޼ҵ� �����
		if (channel_k27 == limit_down_volum) {//���࿡ �ּ�ä���̶� ����ä���� ���ٸ�
			help_k27 = "�ּ�ä���Դϴ�.";//�ּ�ä���ΰ��� �˷��ֱ�
		}else {
			channel_k27--;//�׷��� ������ ��� ä�� ����
			help_k27 = String.format("ä���� %d�Դϴ�", channel_k27);//help ������ ������ ���� channel_k27�� �ֱ�
		}
		System.out.println(help_k27);//���
	}
}
