package ClassTest;

public class TvRemoconX extends TvRemocon2_k27 {
	int battery;//���ں�������
	int maxBattery = 100;//�ִ���͸���������
	int warnBattery = 50;//�ּҹ��͸���������
	String warn;//�������� ���ڿ� ����

	public TvRemoconX() {
	}//�⺻������
	
	public TvRemoconX(int battery) {// ���͸��� �޾Ƽ� ���� �����ϱ�
		this.battery = battery;//���͸����� �޾Ƽ� Ŭ�������� ������ �ֱ�
		System.out.println("���� ���õ� ���͸��� : " + this.battery);//������ ���͸� ���
	}

	void checkBattery() {//���͸� üũ�ϴ� �޼ҵ� ����
		if (battery <= 100 && battery >= 50) {//50���� 100���̿� ���͸��� �����ϸ�
			warn = String.format("������ ��ü�� �ʿ����� �ʽ��ϴ�.");//��� ��º����� �ֱ�
		} else {
			warn = String.format("������ ��ü�� �ʿ��մϴ�.");//��� ��º����� �ֱ�
		}
		System.out.println(warn);//��� ���
	}
}
