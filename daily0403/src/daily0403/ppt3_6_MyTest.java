package daily0403;

public class ppt3_6_MyTest {

	// ��ǰ���ݰ� ������ ���ڷ� ������ ���������� ����ϴ� �޼ҵ�
	private static int kopo_27_netprice(int kopo_27_price, double kopo_27_tax_rate) {
		return (int) (kopo_27_price / (1 + kopo_27_tax_rate));
	}

	public static void main(String[] args) {
		int kopo_27_price = 1234; // ��ǰ����
		double kopo_27_tax_rate = 0.1;// ����

		// ���������� ����ϴ� �޼ҵ� ȣ���Ͽ� ����� ���� kopo_27_netprice�� ����
		int kopo_27_netprice = kopo_27_netprice(kopo_27_price, kopo_27_tax_rate);
		// ���� = ��ǰ���� - ��������
		int kopo_27_tax = kopo_27_price - kopo_27_netprice;

		System.out.printf("************************************************\n");
		System.out.printf("*         �Һ��ڰ�, ��������, ���� ���        *\n");
		System.out.printf("�Һ��ڰ� : %d �������� : %d ���� : %d\n ", kopo_27_price, kopo_27_netprice, kopo_27_tax);
	}
}
