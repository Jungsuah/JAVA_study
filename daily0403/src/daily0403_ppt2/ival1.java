package daily0403_ppt2;

public class ival1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k27_iVal;// ���� ����
		for (int k27_i = 0; k27_i < 300; k27_i++) {// 0���� 299���� �ݺ�
			k27_iVal = 5 * k27_i;// 5�� ���Ѵ�.
			if (k27_iVal >= 0 && k27_iVal < 10)
				System.out.printf("�� %d\n", k27_iVal);
			// k27_iVal�� 0���� ũ�ų� �۰� 10���� ���� ��� ���(�� ������ ��� �����ؾ��ϱ� ������ &&�� ����.)
			else if (k27_iVal >= 10 && k27_iVal < 100)
				System.out.printf("�� %d\n", k27_iVal);
			// k27_iVal�� 10���� ũ�ų� �۰� 100���� ���� ��� ���
			else if (k27_iVal >= 100 && k27_iVal < 1000)
				System.out.printf("�� %d\n", k27_iVal);
			// k27_iVal�� 100���� ũ�ų� �۰� 1000���� ���� ��� ���
			else
				System.out.printf("õ %d\n", k27_iVal);
			// ���� ������ �ƹ��͵� ���� ���� ���ϸ� ���
		}

	}

}
