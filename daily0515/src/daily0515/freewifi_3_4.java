package daily0515;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class freewifi_3_4 {
	public static void main(String[] args) throws Exception {
		// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���մϴ�.
		// �� Ŭ������ MySQL �����ͺ��̽����� ������ �����ϴ� �� ���˴ϴ�.
		// com.mysql.cj.jdbc.Driver�� MySQL Connector/J JDBC ����̹��� Ŭ���� �̸��Դϴ�.
		// �� ����̹��� Java�� MySQL �����ͺ��̽� ���� ����� �߰��ϰ� JDBC API�� �����ϴ� Ŭ�����Դϴ�.
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
		// getConnection �޼����� ���ڷδ� JDBC URL, mysql�� ����� �̸�, mysql������� ��й�ȣ�� �Է��Ѵ�.
		// �� �ڵ忡���� jdbc:mysql://[IP �ּ�]:[mysql�� ��Ʈ��ȣ]/[mysql���� �����ϰ� ���� �����ͺ��̽� �̸�]�� ����Ͽ� �����Ѵ�.
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

		// SQL���� �����ϱ� ���� Statement ��ü�� �����մϴ�.
		Statement stmt = conn.createStatement();
			
			String k27_QueryTxt;//������ ����� ������ ���� ����
			
			//freewifi���̺��� inst_country�� �������� ���� ��� �������� ���� �ۼ�
			k27_QueryTxt = "select * from freewifi where inst_country='������'" ;
			
			//������� ������ Statement�� executeQuery�޼ҵ��� ���ڷ� ������ ���ϴ� ������� ��������
			//rset�� ���ϴ� ������� �Ҵ��մϴ�.
			ResultSet rset = stmt.executeQuery(k27_QueryTxt);
			int iCnt = 0;//�о�� Ƚ�� ���� ����
			while (rset.next()) {//���ϴ� ������� ���� ��ü�� ������ ������������ �ݺ�
				System.out.printf("*(%d)***************************\n", iCnt++);//Ƚ����ȣ ���
				System.out.printf("����                : %s\n", rset.getString(1));//getString�� ����Ͽ� 1��° Į���� ��������
				System.out.printf("��ġ��Ҹ�          : %s\n", rset.getString(2));//getString�� ����Ͽ� 2��° Į���� ��������
				System.out.printf("��ġ��һ�        : %s\n", rset.getString(3));//getString�� ����Ͽ� 3��° Į���� ��������
				System.out.printf("��ġ�õ���          : %s\n", rset.getString(4));//getString�� ����Ͽ� 4��° Į���� ��������
				System.out.printf("��ġ�ñ�����        : %s\n", rset.getString(5));//getString�� ����Ͽ� 5��° Į���� ��������
				System.out.printf("��ġ�ü�����        : %s\n", rset.getString(6));//getString�� ����Ͽ� 6��° Į���� ��������
				System.out.printf("�����������      : %s\n", rset.getString(7));//getString�� ����Ͽ� 7��° Į���� ��������
				System.out.printf("��������SSID        : %s\n", rset.getString(8));//getString�� ����Ͽ� 8��° Į���� ��������
				System.out.printf("��ġ���            : %s\n", rset.getString(9));//getString�� ����Ͽ� 9��° Į���� ��������
				System.out.printf("���������θ��ּ�    : %s\n", rset.getString(10));//getString�� ����Ͽ� 10��° Į���� ��������
				System.out.printf("�����������ּ�      : %s\n", rset.getString(11));//getString�� ����Ͽ� 11��° Į���� ��������
				System.out.printf("���������          : %s\n", rset.getString(12));//getString�� ����Ͽ� 12��° Į���� ��������
				System.out.printf("���������ȭ��ȣ    : %s\n", rset.getString(13));//getString�� ����Ͽ� 13��° Į���� ��������
				System.out.printf("����               : %s\n", rset.getString(14));//getString�� ����Ͽ� 14��° Į���� ��������
				System.out.printf("�浵               : %s\n", rset.getString(15));//getString�� ����Ͽ� 15��° Į���� ��������
				System.out.printf("�����ͱ��س�¥      : %s\n", rset.getString(16));//getString�� ����Ͽ� 16��° Į���� ��������
			}
			
		rset.close();// ResultSet ��ü�� �ݽ��ϴ�.
		stmt.close();// Statement ��ü�� �ݽ��ϴ�.
		conn.close();// Connection ��ü�� �ݽ��ϴ�.
	}
}





















//
//select * from freewifi where 
//		SQRT (POWER (latitude-%f,2) + POWER(longtitude-%f,2) ) = 
//		(select MIN( SQRT( POWER (latitude-%f,2) + POWER(longtitude-%f,2) )  ) from freewifi;
