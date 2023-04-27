package ClassTest;

public class Elevator2 {
	//Elevator2 �ȿ����� ����ϴ� private ���� ���� 
	private int limit_up_floor = 10;
	private int limit_down_floor = 0;
	private int floor = 1;
	public String help;
	
	//�⺻ ������ ����
	Elevator2() {//������ ���ڰ��� ��� ������ �ȿ��� ���� �־��ش�.
		limit_up_floor = 10;
		limit_down_floor = 1;
		floor = 1;
		help = "���������� �⺻ �ذ��Ϸ�";
	}

	//���ڸ� ������ ������ ���� -> �ִ���.�ּ���.�����ִ����� �������� �������ش�
	Elevator2(int up_floor, int d_floor, int in_floor) {
		limit_up_floor = up_floor;
		limit_down_floor = d_floor;
		floor = d_floor;
		help = "���������� ���� �ذ��Ϸ�";
	}

	//���� �ö󰡴� �޼ҵ�
	void up() {
		if (floor == limit_up_floor) {
			help = "���������Դϴ�.";
		} else {
			floor++;
			help = String.format("[%d] ���Դϴ�", floor);
		}
	}

	//���� �������� �޼ҵ�
	void down() {
		if (floor == limit_down_floor) {
			help = "ó�����Դϴ�.";
		} else {
			floor--;
			help = String.format("[%d] ���Դϴ�", floor);
		}
	}

	//up�޼ҵ�� �̸��� ������ ���ڰ��� �ٸ��� ������ �޼ҵ� -> �����ε�
	void up(int u) {//������ ���ڷ� ������
		for (int i = 0; i < u; i++) {
			this.up();//�ش� �������� �ö󰡴� �޼ҵ� ȣ��
		}
	}

	//down�޼ҵ�� �̸��� ������ ���ڰ��� �ٸ��� ������ �޼ҵ� -> �����ε�
	void down(int u) {//������ ���ڷ� ������
		for (int i = 0; i < u; i++) {
			down();//�ش� �������� �ö󰡴� �޼ҵ� ȣ��
		}
	}

	void msg(String id) {//���̵� ���� �޾����� Elevator2 Ŭ���� �ȿ� ���� ������ ����ϴ� �޼ҵ�
		System.out.printf("%s=>[%s]  �ִ���[%d] �ּ���[%d] ������[%d]\n", id, help, limit_up_floor, limit_down_floor, floor);
	}

}
