package daily0516;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Advantage_5 {// Ư������ ������ ��������
	public static void main(String[] args) throws Exception {
		// JDBC ����̹��� �����Ѵ�.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// getConnection() �޼ҵ带 ���ؼ� �����ͺ��̽��� �ڹٸ� �����Ѵ�.
		Connection k27_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

		// stock ���̺� �ֽ� ���� ���ڰ� 20051017�̰� �������� ���� �����ڵ尡 �Ｚ������ ���� �������� ������ �ۼ��Ѵ�.
		String k27_QueryTxt = String.format("select * from stock where bsop_date = '20051017' and stnd_iscd = 'A005930';");
		
		// SQL���� �����ϱ� ���� Statement ��ü�� �����մϴ�.
		Statement k27_stmt = k27_conn.createStatement();

		// ������� ������ Statement�� executeQuery�޼ҵ��� ���ڷ� ������ ���ϴ� ������� �������� 
		//rset�� ���ϴ� ������� �Ҵ��մϴ�.
		ResultSet rset = k27_stmt.executeQuery(k27_QueryTxt);
		int iCnt = 0;// �о�� Ƚ�� ���� ����
		
		while (rset.next()) {// ���ϴ� ������� ���� ��ü�� ������ ������������ �ݺ�
			System.out.printf("*(%d)***************************\n", iCnt++);// Ƚ����ȣ ���
			System.out.printf("�������� ���� �����ڵ�           : %s\n", rset.getString(1));// getString�� ����Ͽ� 1��° Į���� ��������
			System.out.printf("�ֽ� ���� ����                : %s\n", rset.getString(1));// getString�� ����Ͽ� 1��° Į���� ��������
			System.out.printf("�ֽ� ����                    : %s\n", rset.getString(2));// getString�� ����Ͽ� 2��° Į���� ��������
			System.out.printf("�ֽ� �ð�                    : %s\n", rset.getString(3));// getString�� ����Ͽ� 3��° Į���� ��������
			System.out.printf("�ֽ� �ְ�                   : %s\n", rset.getString(4));// getString�� ����Ͽ� 4��° Į���� ��������
			System.out.printf("�ֽ� ������                   : %s\n", rset.getString(5));// getString�� ����Ͽ� 5��° Į���� ��������
			System.out.printf("���� �ŷ���                   : %s\n", rset.getString(6));// getString�� ����Ͽ� 6��° Į���� ��������
			System.out.printf("���� �ŷ� ���                 : %s\n", rset.getString(7));// getString�� ����Ͽ� 7��° Į���� ��������
		}
		rset.close();// ResultSet ��ü�� �ݽ��ϴ�.
		k27_stmt.close();// Statement ��ü�� �ݽ��ϴ�.
		k27_conn.close();// Connection ��ü�� �ݽ��ϴ�.
	}
}
