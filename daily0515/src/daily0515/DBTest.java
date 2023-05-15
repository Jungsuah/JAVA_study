package daily0515;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���մϴ�.
		// �� Ŭ������ MySQL �����ͺ��̽����� ������ �����ϴ� �� ���˴ϴ�.
		// com.mysql.cj.jdbc.Driver�� MySQL Connector/J JDBC ����̹��� Ŭ���� �̸��Դϴ�.
		// �� ����̹��� Java�� MySQL �����ͺ��̽� ���� ����� �߰��ϰ� JDBC API�� �����ϴ� Ŭ�����Դϴ�.
		
		// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
		// getConnection �޼����� ���ڷδ� JDBC URL, mysql�� ����� �̸�, mysql������� ��й�ȣ�� �Է��Ѵ�.
		// �� �ڵ忡���� jdbc:mysql://[IP �ּ�]:[mysql�� ��Ʈ��ȣ]/[mysql���� �����ϰ� ���� �����ͺ��̽� �̸�]�� ����Ͽ� �����Ѵ�.
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

		// Statement ��ü�� �����մϴ�.
		Statement stmt = conn.createStatement();

		// SQL �������� �����ϱ� ���� executeQuery �޼��带 ȣ���մϴ�.
		// �� �ڵ忡���� "show databases" ������ �����Ͽ� ��� �����ͺ��̽� �̸��� �����ɴϴ�.
		ResultSet rset = stmt.executeQuery("show databases;");

		// ResultSet ��ü���� �� ���� ��ȸ�ϸ� ������� ó���մϴ�.
		while (rset.next()) {
			// ���� ���� ù ��° �� ���� ����մϴ�.
			System.out.println("�� : " + rset.getString(1));
		}

		// ResultSet, Statement, Connection ��ü�� ���� �ݽ��ϴ�.
		rset.close();
		stmt.close();
		conn.close();
	}
}
