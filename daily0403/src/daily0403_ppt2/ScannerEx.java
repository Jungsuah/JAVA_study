package daily0403_ppt2;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);// Scanner ��ü ����

		System.out.print("���ڸ� ������ �ϳ� �Է����ּ���.>");

		String k27_input = scanner.nextLine();// scanner�� ���ڿ� ���� �Է� �ޱ�
		int k27_num = Integer.parseInt(k27_input);// Integer.parseInt�� �̿��ؼ� int�� ����ȯ

		System.out.println("�Է³��� : " + k27_input);
		System.out.printf("k27_num = %d\n", k27_num);// ���������� ���
	}

}
