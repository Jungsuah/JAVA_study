package daily0515;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class examtable_1 {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ѵ�.
		// �� Ŭ������ MySQL �����ͺ��̽����� ������ �����ϴ� �� ���˴ϴ�.
		// com.mysql.cj.jdbc.Driver�� MySQL Connector/J JDBC ����̹��� Ŭ���� �̸��Դϴ�.
		// �� ����̹��� Java�� MySQL �����ͺ��̽� ���� ����� �߰��ϰ� JDBC API�� �����ϴ� Ŭ�����Դϴ�.
		
		Connection k27_conn = null;// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
		try {
			// getConnection �޼����� ���ڷδ� JDBC URL, mysql�� ����� �̸�, mysql������� ��й�ȣ�� �Է��Ѵ�.
			// �� �ڵ忡���� jdbc:mysql://[IP �ּ�]:[mysql�� ��Ʈ��ȣ]/[mysql���� �����ϰ� ���� �����ͺ��̽� �̸�]�� ����Ͽ� �����Ѵ�.
			k27_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
		} catch (SQLException e) {
			e.printStackTrace();//���� �߻��� ������ �˷��ش�.
		}
		
		Statement k27_stmt = null;// SQL���� �����ϱ� ���� Statement ��ü�� �����մϴ�.
		try {
			k27_stmt = k27_conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();//���� �߻��� ������ �˷��ش�.
		}

		// examtable�̶�� ���̺��� �����ϴ� SQL���� �����մϴ�.
		// name, studentid, kor, eng, mat ���� ������, studentid ���� PRIMARY KEY�� �����˴ϴ�.
		try {
			k27_stmt.execute("create table examtable (" + "name varchar(20)," + "studentid int not null primary key,"
					+ "kor int," + "eng int," + "mat int)" + "DEFAULT CHARSET=utf8;");
		} catch (SQLException e) {
			e.printStackTrace();//���� �߻��� ������ �˷��ش�.
		}

		try {
			// Statement ��ü�� �ݽ��ϴ�.
			k27_stmt.close();//Open()�� ��ŭ close() ���ϸ� ���߿� ���α׷� �ڻ�ȴ�
		} catch (SQLException e) {
			e.printStackTrace();//���� �߻��� ������ �˷��ش�.
		}
		try {
			// Connection ��ü�� �ݽ��ϴ�.
			k27_conn.close();//Open()�� ��ŭ close() ���ϸ� ���߿� ���α׷� �ڻ쳭��
		} catch (SQLException e) {
			e.printStackTrace();//���� �߻��� ������ �˷��ش�.
		}
	}

}
