package daily0515;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class examtable_3 {
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

		// SQL �������� �����ϱ� ���� execute �޼��带 ȣ���մϴ�.
		// �� �ڵ忡���� "insert into values" ������ �����Ͽ� examtable�� ���� �־��ݴϴ�.
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('ȿ��', 209901,  95, 100,  95);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('����', 209902,  95, 95,  95);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('����', 209903,  100, 100,  100);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('����', 209904,  100, 95,  90);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('�ҿ�', 209905,  80, 100,  70);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('ť��', 209906,  100, 100,  70);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('ȭ��', 209907,  70, 70,  70);");
		
		stmt.close();// Statement ��ü�� �ݽ��ϴ�.
		conn.close();// Connection ��ü�� �ݽ��ϴ�.
	}
}
