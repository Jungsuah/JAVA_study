package Basic_Traning_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Basic_Traning_3 {
	public static void main(String[] args) throws Exception {
		// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���մϴ�.
		// �� Ŭ������ MySQL �����ͺ��̽����� ������ �����ϴ� �� ���˴ϴ�.
		// com.mysql.cj.jdbc.Driver�� MySQL Connector/J JDBC ����̹��� Ŭ���� �̸��Դϴ�.
		// �� ����̹��� Java�� MySQL �����ͺ��̽� ���� ����� �߰��ϰ� JDBC API�� �����ϴ� Ŭ�����Դϴ�.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
		// getConnection �޼����� ���ڷδ� JDBC URL, mysql�� ����� �̸�, mysql������� ��й�ȣ�� �Է��Ѵ�.
		// �� �ڵ忡���� jdbc:mysql://[IP �ּ�]:[mysql�� ��Ʈ��ȣ]/[mysql���� �����ϰ� ���� �����ͺ��̽� �̸�]�� ����Ͽ� ����
		Connection k27_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

		// SQL���� �����ϱ� ���� Statement ��ü�� �����մϴ�.
		Statement k27_stmt = k27_conn.createStatement();

		double k27_lat = 37.3860521;// ���� ǥ�� �Ǽ��� ���� ����
		double k27_lng = 127.1214038;// �浵 ǥ�� �Ǽ��� ���� ����

		String k27_QueryTxt;// ������ ����� ������ ���� ����

		// "freewifi" ���̺��� SQRT(POWER (latitude-%f,2) + POWER(longtitude-%f,2)) ���� �ּ��ΰ��� �����ϴ� ����
		// �� ������ �־��� ����(latitude)�� �浵(longitude) ������ �Ÿ� ����� �������, �ּ� �Ÿ��� ������ ���� �����Ѵ�
		// ���� ����� ��ġ�� �ִ� freewifi ������ ã�� ���� �ۼ�
		k27_QueryTxt = String.format(
				"select * from cctv where " + "SQRT (POWER (latitude-%f,2) + POWER(longtitude-%f,2) ) = "
						+ "(select MIN( SQRT( POWER (latitude-%f,2) + POWER(longtitude-%f,2) )  ) from cctv);",
				k27_lat, k27_lng, k27_lat, k27_lng);

		// ������� ������ Statement�� executeQuery�޼ҵ��� ���ڷ� ������ ���ϴ� ������� �������� rset�� ���ϴ� ������� �Ҵ��մϴ�.
		ResultSet k27_rset = k27_stmt.executeQuery(k27_QueryTxt);
		int iCnt = 0;// �о�� Ƚ�� ���� ����
		while (k27_rset.next()) {// ���ϴ� ������� ���� ��ü�� ������ ������������ �ݺ�
			System.out.printf("*(%d)***************************\n", iCnt++);// Ƚ����ȣ ���
			System.out.printf("����                : %s\n", k27_rset.getString(1));// getString�� ����Ͽ� 1��° Į���� ��������
			System.out.printf("���������          : %s\n", k27_rset.getString(2));// getString�� ����Ͽ� 2��° Į���� ��������
			System.out.printf("���������θ��ּ�        : %s\n", k27_rset.getString(3));// getString�� ����Ͽ� 3��° Į���� ��������
			System.out.printf("�����������ּ�          : %s\n", k27_rset.getString(4));// getString�� ����Ͽ� 4��° Į���� ��������
			System.out.printf("��ġ��������        : %s\n", k27_rset.getString(5));// getString�� ����Ͽ� 5��° Į���� ��������
			System.out.printf("ī�޶���        : %s\n", k27_rset.getString(6));// getString�� ����Ͽ� 6��° Į���� ��������
			System.out.printf("ī�޶�ȭ�Ҽ�      : %s\n", k27_rset.getString(7));// getString�� ����Ͽ� 7��° Į���� ��������
			System.out.printf("�Կ��������        : %s\n", k27_rset.getString(8));// getString�� ����Ͽ� 8��° Į���� ��������
			System.out.printf("�����ϼ�    : %s\n", k27_rset.getString(9));// getString�� ����Ͽ� 10��° Į���� ��������
			System.out.printf("��ġ���      : %s\n", k27_rset.getString(10));// getString�� ����Ͽ� 11��° Į���� ��������
			System.out.printf("���������ȭ��ȣ          : %s\n", k27_rset.getString(11));// getString�� ����Ͽ� 12��° Į���� ��������
			System.out.printf("����               : %s\n", k27_rset.getString(12));// getString�� ����Ͽ� 14��° Į���� ��������
			System.out.printf("�浵               : %s\n", k27_rset.getString(13));// getString�� ����Ͽ� 15��° Į���� ��������
			System.out.printf("�����ͱ��س�¥      : %s\n", k27_rset.getString(14));// getString�� ����Ͽ� 16��° Į���� ��������
		}
		k27_rset.close();// ResultSet ��ü�� �ݽ��ϴ�.
		k27_stmt.close();// Statement ��ü�� �ݽ��ϴ�.
		k27_conn.close();// Connection ��ü�� �ݽ��ϴ�.
	}
}
