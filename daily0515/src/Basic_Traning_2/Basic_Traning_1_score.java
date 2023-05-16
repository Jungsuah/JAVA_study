package Basic_Traning_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Basic_Traning_1_score {
	public static void main(String[] args) throws ClassNotFoundException{
		// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε� ����Ѵ�. 
		// MySQL �����ͺ��̽����� ������ �����ϴ� �� ���ȴ�.
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
		Connection conn = null;
		try {
			// getConnection �޼����� ���ڷδ� JDBC URL, mysql�� ����� �̸�, mysql������� ��й�ȣ�� �Է��Ѵ�.
			// �� �ڵ忡���� jdbc:mysql://[IP �ּ�]:[mysql�� ��Ʈ��ȣ]/[mysql���� �����ϰ� ���� �����ͺ��̽� �̸�]�� ����Ͽ� �����Ѵ�.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
		} catch (SQLException e) {
			e.printStackTrace();//�����߻��� ���� ������ش�
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
			//score ���̺� �����ϴ� ���� �ۼ�
			stmt.execute("create table score(" +//score�� ���̺� ����
						"studentid int not null primary key," + //���� ���� Ű������ �й� ���
						"name varchar(200)," + //�̸� 
						"kor int,"+//���� ����
						"eng int,"+//���� ����
						"mat int"+//���� ����
						")" + "DEFAULT CHARSET=utf8;");// ms949�̱� ������ utf8�� ������ �����ش�.
			
			//score ���̺� �����ϴ� ����
			//stmt.execute("drop table score;");
			
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
			e.printStackTrace();//�����߻��� ���� ������ش�
		}
	}
}
