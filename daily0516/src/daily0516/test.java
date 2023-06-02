package daily0516;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC ����̹��� �����Ѵ�
		Connection k27_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
		// getConnection() �޼ҵ带 ���ؼ� �����ͺ��̽��� �ڹٸ� �����Ѵ�

		// stocktest���̺� �ְ������͸� �Է��ϴ� ������ �ۼ��Ѵ�
		String k27_QueryTxt = String.format("insert into stocktest ("
				+ " stnd_iscd, bsop_date, stck_prpr, stck_oprc, stck_hgpr, stck_lwpr, acml_vol, acml_tr_pbmn)"
				+ "values (?,?,?,?,?,?,?,?)");
		
		PreparedStatement pstmt_k27 = k27_conn.prepareStatement(k27_QueryTxt);
		// ��뷮 �����͸� ������ Insert�ϱ� ���� PreparedStatement�� �̿��Ѵ�
		// PreparedStatement�� ĳ�ÿ� sql ������ ��� �ѹ��� ó���ϱ� ������ Statement���� ó�� �ӵ��� ������

		File k27_f = new File("C:\\test\\day_data\\A005930.csv");// �ش� ��ο� csv ���� ã�ƿ���
		// �Է��Ѵ�
		BufferedReader br_k27 = new BufferedReader(new FileReader(k27_f));
		// �����Է¼ӵ� ����� ���� BufferedReader��ü�� �����Ѵ�

		String readtxt_k27; // �о�� ������ ���پ� �����ϱ� ���� ���ڿ� ������ �����Ѵ�
		int LineCnt_k27 = 0; // �о���� ���� ���� �����ϱ� ���� ������ �����Ѵ�
		k27_conn.setAutoCommit(false); // insert�ӵ� ����� ���ؼ� AutoCommit�� false�� �����Ѵ�
		long startTime_k27 = System.currentTimeMillis(); // ���� �ð��� ms������ �����Ѵ�
		LocalDateTime currentTime = LocalDateTime.now(); // LocalDateTimeŬ������ �̿��Ͽ� ����ð��� �޾ƿ´�
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); // �ð��� ���ϴ� �������� ���������ش�
		String startTime = currentTime.format(formatter); // �����õ� ����ð��� startTime ���ڿ��� �޾Ƶд�
		String error_k27 = ""; // �����޽����� ����ϱ� ���� �޽����� �����ص� ���ڿ� ����

		while ((readtxt_k27 = br_k27.readLine()) != null) { // �о�� ������ null�� �ƴϸ� ��� �о���δ�
			LineCnt_k27++; // �����͸� ���� ó�������Ƿ� LineCnt�� 1 ������Ų��

			if (LineCnt_k27 < 3970000 || LineCnt_k27 > 3980000 && LineCnt_k27 < 8724000 || LineCnt_k27 > 8726000) {
				continue;
			}

			String[] field_k27 = readtxt_k27.split(","); // split()�޼ҵ�� ��ǥ�� �����ڷ� �ʵ尪�� ������ �����Ѵ�

			pstmt_k27.setString(1, field_k27[0]); // �������� ù��° �ʵ忡 1�� �ʵ��� �������� ���� �����ڵ带 �Է��Ѵ�
			pstmt_k27.setString(2, field_k27[1]); // �������� �ι�° �ʵ忡 0�� �ʵ��� �ֽ� ���� ���ڸ� �Է��Ѵ�
			pstmt_k27.setString(3, field_k27[2]); // �������� ����° �ʵ忡 3�� �ʵ��� �ֽ� �ð��� �Է��Ѵ�
			pstmt_k27.setString(4, field_k27[3]); // �������� �׹�° �ʵ忡 4�� �ʵ��� �ֽ� �ְ��� �Է��Ѵ�
			pstmt_k27.setString(5, field_k27[4]); // �������� �ټ���° �ʵ忡 5�� �ʵ��� �ֽ� �������� �Է��Ѵ�
			pstmt_k27.setString(6, field_k27[5]); // �������� ������° �ʵ忡 2�� �ʵ��� �ֽ� ������ �Է��Ѵ�
			pstmt_k27.setString(7, field_k27[6]); // �������� �ϰ���° �ʵ忡 6�� �ʵ��� ���� �ŷ����� �Է��Ѵ�
			pstmt_k27.setString(8, field_k27[7]); // �������� ������° �ʵ忡 7�� �ʵ��� ���� �ŷ� ����� �Է��Ѵ�
			pstmt_k27.addBatch(); // addBatch()�޼ҵ带 ȣ���� ĳ�ÿ� sql ������ ��´�
			System.out.printf("%d��° �׸� addBatch OK\n", LineCnt_k27); // addBatch�� ���������� ����Ѵ�
			pstmt_k27.clearParameters(); // PreparedStatement�� �Ķ���͸� ����

			try {
				if ((LineCnt_k27 % 5000) == 0) { // �޸� ������ ���� 10000�پ� ���� ������
					pstmt_k27.executeBatch(); // executeBatch()�� ȣ���ؼ� ĳ�ÿ� ��� SQL ������ �����Ѵ�
					k27_conn.commit(); // commit()�� ȣ���ؼ� �����͸� ������ �����Ѵ�
				}
			}catch (Exception e_k27) {
			    // ���� ���� ���
//			    e.printStackTrace();
				error_k27 = error_k27 + "���� �� : " + String.valueOf(LineCnt_k27) + e_k27.toString() + "\n";
			}
		}
		try {
			pstmt_k27.executeBatch();
		} catch (Exception e_k27) { // executeBatch()�ÿ� Exception�� �߻��ϸ�
//			e_k27.printStackTrace(); // �����޽����� ����Ѵ�
			error_k27 = error_k27 + "���� �� : " + String.valueOf(LineCnt_k27) + e_k27.toString() + "\n";
			// �����޽����� error���ڿ��� �����Ͽ� �̾���ش�
		}
		k27_conn.commit(); // ��� insert�� �Ϸ�Ǿ����Ƿ� commit�� �Ѵ�
		k27_conn.setAutoCommit(true);// ��� insert�� �Ϸ�Ǿ����Ƿ� AutoCommit�� false�� �����Ѵ�
		long endTime_k27 = System.currentTimeMillis(); // ������ �ð��� ms������ �����Ѵ�
		currentTime = LocalDateTime.now(); // LocalDateTimeŬ������ �̿��Ͽ� ����ð��� �ٽ� �޾ƿ´�
		String endTime = currentTime.format(formatter); // �����õ� ����ð��� endTime ���ڿ��� �޾Ƶд�

		System.out.printf("Insert End\n"); // Insert�� �������� �˸��� �޽����� ����Ѵ�
		System.out.printf("total               : %d\n", LineCnt_k27); // �о�� ������ ����Ѵ�
		System.out.printf("time                : %dms\n", endTime_k27 - startTime_k27); // endTime���� startTime�� �� ����ð���
																						// ����Ѵ�
		System.out.printf("�������Է� ���۽ð� : %s\n", startTime); // startTime�� ������ش�
		System.out.printf("�������Է� �Ϸ�ð� : %s\n", endTime); // endTime�� ������ش�
		System.out.println(error_k27); // ���� ������ ����Ѵ�

		br_k27.close(); // BufferedReader�� �ݴ´�
		pstmt_k27.close(); // PreparedStatement�� �ݴ´�
		k27_conn.close(); // Connection�� �ݴ´�
	}
}