package daily0403_ppt2;

public class VarEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k_31_x = 10;// ���� �����ϰ� 10���� �ʱ�ȭ
		int k_31_y = 20;// ���� �����ϰ� 20���� �ʱ�ȭ
		int k_31_tmp = 0;// ���� �����ϰ� 0���� �ʱ�ȭ

		System.out.println("k_31_x:" + k_31_x + " k_31_y:" + k_31_y);// ���

		// �� ��ȯ�� tmp ���
		k_31_tmp = k_31_x;// ���� ����
		k_31_x = k_31_y;// ���� ����
		k_31_y = k_31_tmp;// ���� ����

		System.out.println("k_31_x:" + k_31_x + " k_31_y:" + k_31_y);// ���

	}

}
