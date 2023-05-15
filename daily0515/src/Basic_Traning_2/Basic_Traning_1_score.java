package Basic_Traning_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Basic_Traning_1_score {
	public static void main(String[] args) throws ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���մϴ�.
		// �� Ŭ������ MySQL �����ͺ��̽����� ������ �����ϴ� �� ���˴ϴ�.
		// com.mysql.cj.jdbc.Driver�� MySQL Connector/J JDBC ����̹��� Ŭ���� �̸��Դϴ�.
		// �� ����̹��� Java�� MySQL �����ͺ��̽� ���� ����� �߰��ϰ� JDBC API�� �����ϴ� Ŭ�����Դϴ�.
		
		// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
		// getConnection �޼����� ���ڷδ� JDBC URL, mysql�� ����� �̸�, mysql������� ��й�ȣ�� �Է��Ѵ�.
		// �� �ڵ忡���� jdbc:mysql://[IP �ּ�]:[mysql�� ��Ʈ��ȣ]/[mysql���� �����ϰ� ���� �����ͺ��̽� �̸�]�� ����Ͽ� �����Ѵ�.
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// SQL���� �����ϱ� ���� Statement ��ü�� �����մϴ�.
		Statement stmt= null;
		try {
			//conn��ü�� createStatement�� �޼ҵ带 ����� Statement ��ü�� �Ҵ��Ѵ�.
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();//�����߻��� ���� ������ش�
		}
		
		try {
			//cctv ���̺� �����ϴ� ����
			stmt.execute("create table score(" +//freewifi�� ���̺� ����
						"studentid int not null AUTO_INCREMENT primary key," + //���� ���� Ű�� �ο�
						"name varchar(200)," + //���������
						"kor int,"+//���������θ��ּ�
						"eng int,"+//�����������ּ�
						"mat int"+//��ġ��������
						")" + "DEFAULT CHARSET=utf8;");
			
			//cctv ���̺� �����ϴ� ����
			//stmt.execute("drop table cctv;");
		} catch (SQLException e) {
			e.printStackTrace();//�����߻��� ���� ������ش�
		}
		
		try {
			// Statement ��ü�� �ݽ��ϴ�.
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();//�����߻��� ���� ������ش�
		}
		try {
			// Connection ��ü�� �ݽ��ϴ�.
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
