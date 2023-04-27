package java_intensive;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ppt8_1 {
	public static void main(String[] args) {
		try {
			File k27_f = new File("C:\\Users\\������\\test.txt"); // �ش� ��ο� test.txt��� ���� ����
			FileWriter k27_fw = new FileWriter(k27_f);// ���Ͽ� ������ �����ִ� ��ü ����

			k27_fw.write("�ȳ� ����\n");// ��ü�� ���� �޼ҵ� write�� ����Ͽ� ���Ͽ� �� �ۼ�
			k27_fw.write("hello ���\n");// ��ü�� ���� �޼ҵ� write�� ����Ͽ� ���Ͽ� �� �ۼ�

			k27_fw.close();// close() �޼ҵ�� FileWriter�� ��� ������ �˸��� GC�� �޸𸮸� �����ϰ� �Ѵ�.

			FileReader k27_fr = new FileReader(k27_f);// ������ ������ �о�ü��ִ� ��ü ����

			int k27_n = -1;// ���Ͽ��� �о�� ������ ������ ����ϱ� ���� ���� ����
			char[] k27_ch;// ���Ͽ��� �о�� ���ڸ� ������� �迭�� ����

			while (true) {// ������ true ���� �ݺ��ϱ�
				k27_ch = new char[100];// �迭�� ũ�⸦ 100���� �ݺ����� �������� �ʱ�ȭ
				k27_n = k27_fr.read(k27_ch);// FileReader�� ���� �޼ҵ� read�� ȣ���Ͽ� ���ϰ��� ch�迭�� length�� n�� �����Ѵ�.

				if (k27_n == -1) {// n = -1�̸� break�� �����ϰ� �ݺ����� �������´� -> ���̻� �о�� ������ ������ -1�� ��ȯ�Ǳ⶧����
					break;
				}

				for (int k27_i = 0; k27_i < k27_n; k27_i++) {// �о�� ������ �ִٸ� �迭�� ���̸�ŭ for���� ����
					System.out.printf("%c", k27_ch[k27_i]);// �ݺ����� ���鼭 �ѱ��ھ� ����Ѵ�
				}
			}

			k27_fr.close();// close() �޼ҵ�� FileReader�� ��� ������ �˸��� GC�� �޸𸮸� �����ϰ� �Ѵ�.

			System.out.println("\n FILE READ END");// ����� ������ �˷��ֱ� ���� ���
		} catch (Exception k27_e) {// ���� ������ �����Ǿ����� ������� try �������� ������ �߻��ϰ� catch���� ��Ƽ� ������ �߻������ÿ� �����޽����� ������ش�.
			System.out.printf("�� ����[%s]\n", k27_e);// �����޽��� ���
		}
	}
}
