package daily0516;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Advantage_2 {// csv ���� �о stock ���̺� ������ ����ֱ�
	public static void main(String[] args) throws Exception {
		// JDBC ����̹��� �����Ѵ�.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// getConnection() �޼ҵ带 ���ؼ� �����ͺ��̽��� �ڹٸ� �����Ѵ�.
		Connection k27_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

		// stock ���̺� �ְ� �����͸� �Է��ϴ� ������ �ۼ��Ѵ�.
		// PreparedStatement�� ����ϹǷ� values���� ?�� ǥ���Ѵ�.
		String k27_QueryTxt = String.format("insert into stock ("
				+ " stnd_iscd, bsop_date, stck_prpr, stck_oprc, stck_hgpr, stck_lwpr, acml_vol, acml_tr_pbmn)"
				+ "values (?,?,?,?,?,?,?,?)");

		// ��뷮 �����͸� ������ Insert �ϱ� ���� PreparedStatement�� �̿��Ѵ�.
		// PreparedStatement�� ĳ�ÿ� SQL ������ ��� �ѹ��� ó���ϱ� ������ Statement���� ó���ӵ��� ������.
		PreparedStatement pstmt = k27_conn.prepareStatement(k27_QueryTxt);

		// ���� �Է��� ���� File ��ü�� �����ϸ鼭 ���� ��θ� �Է��Ѵ�.
		File k27_f = new File("C:\\test\\day_data\\A005930.csv");// �ش� ��ο� csv ���� ã�ƿ���
		//�����Է¼ӵ� �⼧�� ���� BufferedReader ��ü�� �����Ѵ�.
		BufferedReader k27_br = new BufferedReader(new FileReader(k27_f));

		//�о�� ������ ���پ� �����ϱ� ���� ���ڿ� ������ �����Ѵ�.
		String k27_readtxt;

		if ((k27_readtxt = k27_br.readLine()) == null) {// ù���� null�̸� �� �����̱� ������
			System.out.printf("�� ���� �Դϴ�\n");// ���������� ����Ѵ�.
			return;// ȣ���Ѱ����� ���ư���
		}

		int k27_LineCnt = 0;// �о���� ���μ��� �����ϱ� ���� ������ �����Ѵ�.
		k27_conn.setAutoCommit(false);//insert �ӵ� ����� ���� AutoCommit�� false�� �����Ѵ�.
		long startTime = System.currentTimeMillis();//���� �ð��� ms ������ �����Ѵ�. 

		String error = "";//�����޽����� ����ϱ� ���� ���ڿ� ���� ����
		while ((k27_readtxt = k27_br.readLine()) != null) {// �о�� ������ null�� �ƴϸ� ��� �о���δ�.
			String[] k27_field = k27_readtxt.split(",");//split()�޼ҵ�� ��ǥ�� �����ڷ� �ʵ尪�� ������ �����Ѵ�.

			pstmt.setString(1, k27_field[0]);//ù��° ?�� 0��° �ʵ��� ���� ���� ���� �����ڵ带 �Է��Ѵ�.
			pstmt.setString(2, k27_field[1]);//�ι�° ?�� 1��° �ʵ��� �ֽ� ���� ���ڸ� �Է��Ѵ�.
			pstmt.setString(3, k27_field[2]);//����° ?�� 2��° �ʵ��� �ֽ� ������ �Է��Ѵ�.
			pstmt.setString(4, k27_field[3]);//�׹�° ?�� 3��° �ʵ��� �ֽ� �ð��� �Է��Ѵ�.
			pstmt.setString(5, k27_field[4]);//�ټ���° ?�� 4��° �ʵ��� �ֽ� �ְ��� �Է��Ѵ�.
			pstmt.setString(6, k27_field[5]);//������° ?�� 5��° �ʵ��� �ֽ� �������� �Է��Ѵ�.
			pstmt.setString(7, k27_field[6]);//�ϰ���° ?�� 6��° �ʵ��� ���� �ŷ����� �Է��Ѵ�.
			pstmt.setString(8, k27_field[7]);//������° ?�� 7��° �ʵ��� ���� �ŷ� ����� �Է��Ѵ�.
			pstmt.addBatch();//addBatch() �޼ҵ带 ȣ���� ĳ�ÿ� SQL ������ ��´�.
			
			// addBatch�� ���������� ����Ѵ�.
			System.out.printf("%d��° �׸� addBatch OK\n", k27_LineCnt);
			pstmt.clearParameters();//PreparedStatement�� �Ķ���͸� ����.

			k27_LineCnt++;//�����͸� ���� ó�������Ƿ� k27_LineCnt�� ������Ų��.

			try {
				if (k27_LineCnt % 10000 == 0) {//�޸� ������ ���� 10000�پ� ������ ����
					pstmt.executeBatch();//executeBatch()�� ȣ���Ͽ� ĳ�ÿ� ��� SQL ������ �����Ѵ�.
					k27_conn.commit();//commit()�� ȣ���ؼ� �����͸� ������ �����Ѵ�.
				}
			} catch (Exception e) {//executeBatch()�ÿ� Exception�� �߻��ϸ�
				e.printStackTrace();//���ܸ޽����� ����Ѵ�.
				//���� �޽����� ����ϱ� ���� ���ڿ��� �����޼����� ��´�.
				error = error + e.toString() + "���� �� : " + String.valueOf(k27_LineCnt);
			}
		}
		try {//while ������ ���� �� ĳ�ÿ� ���� SQL ������ �����ؾ��Ѵ�.
			pstmt.executeBatch();//executeBatch()�� ȣ���Ͽ� ������ SQL ������ �����Ѵ�.
		} catch (Exception e) {//executeBatch()�ÿ� Exception�� �߻��ϸ�
			e.printStackTrace();//���ܸ޽����� ����Ѵ�.
			//���� �޽����� ����ϱ� ���� ���ڿ��� �����޼����� ��´�.
			error = error + e.toString() + "���� �� : " + String.valueOf(k27_LineCnt);
		}

		k27_conn.commit();//��� insert�� �Ϸ�Ǿ����Ƿ� commit�� �Ѵ�.
		k27_conn.setAutoCommit(true);//AutoCommit�� �ٽ� true�� �����Ѵ�.
		long endTime = System.currentTimeMillis();//������ �ð��� ms ������ �����Ѵ�.
		
		System.out.println("Insert End");//Insert�� �������� �˸��� �޽����� ����Ѵ�.
		System.out.printf("total : %d\n", k27_LineCnt);//�о�� ������ ����Ѵ�.
		System.out.printf("time : %dms\n", endTime - startTime);//endTime���� startTime�� �� ����ð��� ����Ѵ�.
		System.out.println(error);//�����޽����� ��� ������ ����Ѵ�.

		k27_br.close();// BufferedReader�� �ݴ´�.
		pstmt.close();// PreParedStatment�� �ݴ´�.
		k27_conn.close();// Connection�� �ݴ´�.
	}
}
