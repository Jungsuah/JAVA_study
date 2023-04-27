package ClassTest;

public class TvRemocon2_k27 {
	private int limit_up_channel_k27 = 100;//�ִ�ä�κ��� ����
	private int limit_down_channel_k27 = 1;//�ּ�ä�κ��� ����
	private int  channel_k27= 1;//���� ä��
	
	private int limit_up_volum_k27 = 100;//�ִ�ä�κ��� ����
	private int limit_down_volum_k27 = 0;//�ּ�ä�κ��� ����
	private int  volum_k27= 0;//���� ����
	
	public String help_k27;//�������� ���ڿ����� ����
	
	public TvRemocon2_k27() {//�⺻������ ����
		super();
	}

	//ä�ΰ� ������ ���ڷ� �޴� �޼ҵ� ����
	public TvRemocon2_k27(int wchannel_k27, int wvolum_k27) {
		this.channel_k27 = wchannel_k27;//�Է¹��� ä�ΰ��� Ŭ���� �ȿ��ִ� channel�� �־��ش�
		this.volum_k27 = wvolum_k27;//�Է¹��� �������� Ŭ���� �ȿ��ִ� channel�� �־��ش�
		System.out.println("���ϴ� ���ڰ� �ޱ� �Ϸ�!");
		System.out.println("���� ���õ� ä�� : " + channel_k27);//���õ� ä�� Ȯ��
		System.out.println("���� ���õ� ���� : " + volum_k27);//���õ� ���� Ȯ��
	}

	public void VolUp_k27() {//���� �ø��� �޼ҵ� �����
		if (volum_k27 == limit_up_volum_k27) {//���࿡ �ִ� �����̶� ���纼���� ���ٸ�
			help_k27 = "�ִ뺼���Դϴ�.";//�ִ뺼���ΰ��� �˷��ֱ�
		}else {
			volum_k27++;//�׷��� ������ ��� ���� ����
			help_k27 = String.format("������ %d�Դϴ�", volum_k27);//help ������ ������ ���� volum_k27�� �ֱ�
		}
	}

	public void VolDn_k27() {//���� ������ �޼ҵ� �����
		if (volum_k27 == limit_down_channel_k27) {//���࿡ �ּ� �����̶� ���纼���� ���ٸ�
			help_k27 = "�ּҺ����Դϴ�.";//�ּҺ����ΰ��� �˷��ֱ�
		}else {
			volum_k27--;//�׷��� ������ ��� ���� ����
			help_k27 = String.format("������ %d�Դϴ�", volum_k27);//help ������ ������ ���� volum_k27�� �ֱ�
		}
	}

	public void ChannelUp_k27() {//ä�� �ø��� �޼ҵ� �����
		if (channel_k27 == limit_up_channel_k27) {//���࿡ �ִ�ä���̶� ����ä���� ���ٸ�
			help_k27 = "�ִ�ä���Դϴ�.";//�ִ�ä���ΰ��� �˷��ֱ�
		}else {
			channel_k27++;//�׷��� ������ ��� ä�� ����
			help_k27 = String.format("ä���� %d�Դϴ�", channel_k27);//help ������ ������ ���� channel_k27�� �ֱ�
		}
	}

	public void ChannelDn_k27() {//ä�� ������ �޼ҵ� �����
		if (channel_k27 == limit_down_volum_k27) {//���࿡ �ּ�ä���̶� ����ä���� ���ٸ�
			help_k27 = "�ּ�ä���Դϴ�.";//�ּ�ä���ΰ��� �˷��ֱ�
		}else {
			channel_k27--;//�׷��� ������ ��� ä�� ����
			help_k27 = String.format("ä���� %d�Դϴ�", channel_k27);//help ������ ������ ���� channel_k27�� �ֱ�
		}
	}
	
	void msg1(String vid) {//���̵� ���� �޾����� Elevator2 Ŭ���� �ȿ� ���� ������ ����ϴ� �޼ҵ�
		System.out.printf("�ִ뺼��[%d] �ּҺ���[%d] ���纼��[%d]\n",  limit_up_volum_k27, limit_down_volum_k27, volum_k27);
	}
	
	void msg2(String cid) {//���̵� ���� �޾����� Elevator2 Ŭ���� �ȿ� ���� ������ ����ϴ� �޼ҵ�
		System.out.printf("�ִ�ä��[%d] �ּ�ä��[%d] ����ä��[%d]\n", limit_up_channel_k27, limit_down_channel_k27, channel_k27);
	}
	
	//------------------------------------------------------------------
	//up�޼ҵ�� �̸��� ������ ���ڰ��� �ٸ��� ������ �޼ҵ� -> �����ε�
//		void ChannelUp(int wchannel) {//ä�� ���ڷ� ������
//			for (int i = 0; i < wchannel; i++) {
//				this.ChannelUp();//�ش� ä�α��� �ö󰡴� �޼ҵ� ȣ��
//			}
//		}
//		
//		//up�޼ҵ�� �̸��� ������ ���ڰ��� �ٸ��� ������ �޼ҵ� -> �����ε�
//		void VolUp(int wvolum) {//���� ���ڷ� ������
//			for (int i = 0; i < wvolum; i++) {
//				this.VolUp();//�ش� �������� �ö󰡴� �޼ҵ� ȣ��
//			}
//		}
//
//		//down�޼ҵ�� �̸��� ������ ���ڰ��� �ٸ��� ������ �޼ҵ� -> �����ε�
//		void ChannelDn(int wchannel) {//ä���� ���ڷ� ������
//			for (int i = 0; i < wchannel; i++) {
//				this.ChannelDn();//�ش� ä�α��� �ö󰡴� �޼ҵ� ȣ��
//			}
//		}
//		
//		//down�޼ҵ�� �̸��� ������ ���ڰ��� �ٸ��� ������ �޼ҵ� -> �����ε�
//		void VolDn(int wvolum) {//������ ���ڷ� ������
//			for (int i = 0; i < wvolum; i++) {
//				this.VolDn();//�ش� �������� �ö󰡴� �޼ҵ� ȣ��
//			}
//		}
	//------------------------------------------------------------------
		
}
