package java_intense;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class L08_4 {
    // ���� ����....
    public static void main(String[] args) throws IOException {
        // �Է� ���� ��� ����
        File k27_f = new File("C:\\test\\day_data\\THTSKS010H00.dat");
        // �Է� ���۵� ���� ����
        BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));
        // ��� ���� ��� ����
        File k27_f1 = new File("C:\\test\\day_data\\Stock2015.csv");
        // ��� ���۵� ������ ����
        BufferedWriter k27_bw1 = new BufferedWriter(new FileWriter(k27_f1));
        // �� �پ� �б� ���� ���� ����
        String k27_readtxt;
        // ��ü ���� ��
        int k27_cnt = 0;
        // ��� ���� ��
        int k27_wcnt = 0;

        // �Է� ������ �� �پ� �о����
        while ((k27_readtxt = k27_br.readLine()) != null) {
            // StringBuffer ����
            StringBuffer k27_s = new StringBuffer();
            // %_% �������� �ʵ� ����
            String[] k27_field = k27_readtxt.split("%_%");
            // �ʵ尡 2�� �̻��̸鼭 �ι�° ��ҿ� �ش��ϴ� ���� 2015�� �����ϰ� �ִ� ���
            if (k27_field.length > 2 && k27_field[1].contains("2015")) {
                // StringBuffer�� String���� ��ȯ�Ͽ� ��� ���Ͽ� ����
                k27_bw1.write(k27_readtxt);
                // ���ο� �������� �̵�
                k27_bw1.newLine();
                // ��� ���� �� ����
                k27_wcnt++;
                // ��� Ȯ���� ���� ��¹�
                System.out.printf("write [%d] [%d] [%s]\n", k27_cnt, k27_wcnt, k27_s.toString());
            }
        }
        // �Է� ���۵� ���� ����
        k27_br.close();
        // ��� ���۵� ������ ����
        k27_bw1.close();
    }
}

