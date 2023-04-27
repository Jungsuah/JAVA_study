package java_intense;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite {

	public static void k27_FileWrite() throws IOException {//���Ͽ� �� �����ִ� �޼ҵ� ���� => ������ ����� throws ������ ���� �ش� ���ܸ� ���� �޼ҵ�� ����
		File k27_f = new File("C:\\Users\\������\\test.txt");//�ش� ��ο� ���ο� ���� �����
		BufferedWriter k27_bw = new BufferedWriter(new FileWriter(k27_f));//BufferedWriter�� FileWriter ��ü ����
		k27_bw.write("�ȳ� ����");//BufferedWriter�� write �޼ҵ带 ���� ���Ͽ� ���� �ۼ�
		k27_bw.newLine();//BufferedWriter�� newLine �޼ҵ带 ���� �ٳѱ�
		k27_bw.write("hello ���");//BufferedWriter�� write �޼ҵ带 ���� ���Ͽ� ���� �ۼ�
		k27_bw.newLine();//BufferedWriter�� newLine �޼ҵ带 ���� �ٳѱ�
		k27_bw.close();// close() �޼ҵ�� BufferedWriter�� ��� ������ �˸��� GC�� �޸𸮸� ����
	}

	public static void k27_FileRead() throws IOException {//���Ͽ� �ִ� ���� �������ִ� �޼ҵ� ���� => ������ ����� throws ������ ���� �ش� ���ܸ� ���� �޼ҵ�� ����
		File k27_f = new File("C:\\Users\\������\\test.txt");//�ش� ��ο� ���� ã�ƿ���
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));//BufferedReader�� FileReader�� ���� ���� ��ü ����
		String k27_readtxt;//����� ���ڿ��� ���� ���� ����
		while ((k27_readtxt = k27_br.readLine()) != null) {//�о�� ������ ������ ���� ������
			System.out.printf("%s\n", k27_readtxt);//����ϱ�
		}
		k27_br.close();// close() �޼ҵ�� BufferedWriter�� ��� ������ �˸��� GC�� �޸𸮸� ����
	}

	public static void main(String[] args) throws IOException {//main �޼ҵ忡�� IOException�� throws�ϸ�, �ش� ���ܴ� JVM���� ���޵Ǿ� ��µǰ� ���α׷��� ����
		k27_FileWrite();//���Ͽ� �۾��� �޼ҵ� ȣ��
		k27_FileRead();//������ �о���� �޼ҵ� ȣ��
	}
}
