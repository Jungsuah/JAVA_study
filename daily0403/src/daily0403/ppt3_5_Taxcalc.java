package daily0403;

public class ppt3_5_Taxcalc {
	public static void main(String[] args) {
		int kopo_27_val = 271; // ���� ���ǰ�
		int kopo_27_rate = 3; // ���� 3�ۼ�Ʈ

		// �츮���� = ������ ������ �Һ��ڰ��� ����
		// �Ϻ� = ���������� �Һ��ڰ��� ����
		// ex) ������ 100�� -> 112���� �����Ѵ�.

		int kopo_27_tax = taxcal(kopo_27_val, kopo_27_rate);//�����ݾװ� �����ۼ�Ʈ�� ���ڷ� ���� ������ ���Ե� ������ ����ϴ� �޼ҵ� ����

		System.out.printf("**********************************\n");
		System.out.printf("*         �ܼ� ���� ���         *\n");
		System.out.printf("���� ���� ��� : %f\n", kopo_27_val * kopo_27_rate / 100.0);//���� ����� double�� ����ؼ� �Ҽ������� ������ ����
		System.out.printf("�������� : %d ���� : %d �����԰��� : %d\n ", kopo_27_val, kopo_27_tax, kopo_27_val + kopo_27_tax);

	}

	private static int taxcal(int kopo_27_val, int kopo_27_rate) {//�����ݾװ� �����ۼ�Ʈ�� ���ڷ� ���� ������ ���Ե� ������ ����ϴ� �޼ҵ�
		int kopo_27_ret;// ��ȯ�ϴ� ���� ����

		//���� �Ҽ����� ������ �ʰ� ��������� ���� �Ҽ����� ������ ����� ������ ���� ���ٸ� -> �״�� �Ҽ��� ������ ��� ����
		if ((double) kopo_27_val * (double) kopo_27_rate / 100.0 == kopo_27_val * kopo_27_rate / 100) {
			kopo_27_ret = kopo_27_val * kopo_27_rate / 100;
		} else { // �׷��� �ʴٸ� + 1�� ���������μ� �������� �Ҽ����� ���� ���� ì���ش�
			kopo_27_ret = kopo_27_val * kopo_27_rate / 100 + 1;
		}
		return kopo_27_ret;//����� ���� �Լ��� ȣ���� ���� �����ش�
	}
}
