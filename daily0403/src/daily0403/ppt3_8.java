package daily0403;

public class ppt3_8 {
	public static void main(String[] args) {

		int kopo_27_MyWon = 1000000;// ���� ȯ���ϰ� ���� ��ȭ
		double kopo_27_MoneyEX = 1238.21; // �޷� ȯ��
		double kopo_27_commission = 0.003; // ȯ���� �߻��ϴ� ������
		double kopo_27_ComPerOne = kopo_27_MoneyEX * kopo_27_commission; // 1�޷��� ȯ�� ������
		int kopo_27_usd = (int) (kopo_27_MyWon / (kopo_27_MoneyEX + kopo_27_ComPerOne)); // ȯ�� �޷� = ȯ���Ϸ��� ��ȭ / (�޷�ȯ�� + 1�޷��� ȯ��������)
		double kopo_27_totalcom = kopo_27_usd * kopo_27_ComPerOne;// �� ������ = �޷� * 1�޷��� ȯ�� ������
		int kopo_27_i_totalcom = 0;// �ø� ó���� �� ������

		// ������ �ø�ó��
		//���� �� �������� �Ҽ����� ���� ������ �Ҽ����� ������ ���� ���� �ʴٸ� +1�� ���� ������ ����
		if (kopo_27_totalcom != (double) ((int) kopo_27_totalcom)) {
			kopo_27_i_totalcom = (int) kopo_27_totalcom + 1;
		} else {
			//���� �� �������� �Ҽ����� ���� ������ �Ҽ����� ������ ���� ���ٸ� �״�� ������ ����
			kopo_27_i_totalcom = (int) kopo_27_totalcom;
		}

		System.out.printf("******************************************************************************\n");
		System.out.printf("*                          (��Ȯ��)������ ����ȯ��                           *\n");

		System.out.printf("�� ������ : %d�� => ��ȭ : %d�޷�, �޷��� ������: %f��\n", kopo_27_i_totalcom, kopo_27_usd, kopo_27_ComPerOne);

		//������ �ܵ� = ȯ���ϰ���� ��ȭ - (�޷� * �޷�ȯ��) - 1�޷��� ȯ�� ������
		int kopo_27_remain = (int) (kopo_27_MyWon - kopo_27_usd * kopo_27_MoneyEX - kopo_27_i_totalcom);
		System.out.printf("�� ��ȭȯ���ݾ� : %d�� => ��ȭ : %d�޷�, ������û��:%d�� �ܵ�: %d��\n", kopo_27_MyWon, kopo_27_usd, kopo_27_i_totalcom, kopo_27_remain);
		System.out.printf("******************************************************************************\n");
	}
}
