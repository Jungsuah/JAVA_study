package daily0516;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class stock {
    public static void main(String[] args) throws IOException {
    	// �Է� ���� ��� ����
    	File k27_f = new File("C:\\test\\day_data\\THTSKS010H00.dat");
    	//BufferedReader ��ü�� �����ϰ� �Է� ������ �Ķ���ͷ� �Ѱ��ش�.
        BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));
        
        //���� ��ο� �ش� ������ �������� -> ������ ���� ����
        File k27_f1 = new File("C:\\test\\day_data\\A005930.csv");
        //BufferedWriter ��ü�� �����ϰ� ������ �Ķ���ͷ� �Ѱ� ���Ͼȿ� ���� �ۼ��ϰ� �Ѵ�.
        BufferedWriter k27_bw1 = new BufferedWriter(new FileWriter(k27_f1));
        
        String k27_readtxt;//������ �޾ƿ� ���ڿ� ��ü ����
        int k27_cnt = 0;//������ ���� Ƚ��
        int k27_wcnt = 0;//StringBuffer�� �����͸� ���� Ƚ��

        while ((k27_readtxt = k27_br.readLine()) != null) {// �о�� ������ null�� �ƴϸ� ��� �о���δ�.
            StringBuffer k27_s = new StringBuffer();//StringBuffer ��ü�� �����ϰ� �ʱ�ȭ�Ѵ�.
            String[] k27_field = k27_readtxt.split("%_%");//split()�޼ҵ�� _�� �����ڷ� �ʵ尪�� ������ �����Ѵ�.

            if (k27_field.length > 2 && k27_field[2].replace("^", "").trim().substring(0, 1).equals("A")) {
            	//k27_field�� ���̰� 2�̻��̰� �ι�° �ʵ� ���� 1��° ���ڰ� A�̸�
                k27_s.append(k27_field[2].replace("^", "").trim());//�������� ���� �����ڵ带 StringBuffer�� ���
                k27_s.append("," + k27_field[1].replace("^", "").trim());//�ֽ� ���� ���ڸ� StringBuffer�� ���
                k27_s.append("," + k27_field[4].replace("^", "").trim());//�ֽ� ������ StringBuffer�� ���
                k27_s.append("," + k27_field[5].replace("^", "").trim());//�ֽ� �ð��� StringBuffer�� ���
                k27_s.append("," + k27_field[6].replace("^", "").trim());//�ֽ� �ְ��� StringBuffer�� ���
                k27_s.append("," + k27_field[3].replace("^", "").trim());//�ֽ� �������� StringBuffer�� ���
                k27_s.append("," + k27_field[11].replace("^", "").trim());//���� �ŷ����� StringBuffer�� ��� 
                k27_s.append("," + k27_field[12].replace("^", "").trim());//���� �ŷ� ����� StringBuffer�� ���

                k27_bw1.write(k27_s.toString());//append�� ���� ���ڿ��� write �޼ҵ�� ���Ͽ� �ۼ�
                k27_bw1.newLine();//���پ��� �ٳѱ��ϱ�

                k27_wcnt++;//�ѹ� ������ ��������� +1�ϱ�
                System.out.printf("write [%d] [%d] [%s]\n", k27_cnt, k27_wcnt, k27_s.toString());
            }
            k27_cnt++;//������ ������ �о������� +1�ϱ�
        }
        k27_br.close();//BufferedReader ��ü �ݱ�
        k27_bw1.close();//BufferedWriter ��ü �ݱ�

        //���� ������ ���������� ����ϱ�
        System.out.printf("Program End [%d] [%d] records\n", k27_cnt, k27_wcnt);
    }
}