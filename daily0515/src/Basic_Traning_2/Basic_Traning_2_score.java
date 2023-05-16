package Basic_Traning_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Basic_Traning_2_score {
	public static void main(String[] args) {
		try {
			// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���մϴ�.
			// �� Ŭ������ MySQL �����ͺ��̽����� ������ �����ϴ� �� ���˴ϴ�.
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();//�����߻��� ���� ������ش�
		}

		// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
		Connection k27_conn = null;
		try {
			// getConnection �޼����� ���ڷδ� JDBC URL, mysql�� ����� �̸�, mysql������� ��й�ȣ�� �Է��Ѵ�.
			// �� �ڵ忡���� jdbc:mysql://[IP �ּ�]:[mysql�� ��Ʈ��ȣ]/[mysql���� �����ϰ� ���� �����ͺ��̽� �̸�]�� ����Ͽ� ����
			k27_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
		} catch (SQLException e) {
			e.printStackTrace();//�����߻��� ���� ������ش�
		}

		// SQL���� �����ϱ� ���� Statement ��ü�� �����մϴ�.
		Statement k27_stmt = null;
		try {
			// conn��ü�� createStatement�� �޼ҵ带 ����� Statement ��ü�� �Ҵ��Ѵ�.
			k27_stmt = k27_conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();// �����߻��� ���� ������ش�
		}
		for (int i = 0; i < 1000; i++) {//i�� 0���� 999���� �ݺ��ϴ� �ݺ���
			String k27_QueryTxt;// ������ ����� ������ ���� ����

			// �����ϴ� insert���� �ۼ��ؼ� Į���� ���缭 ������ �����Ѵ�.
			//studentid�� name�� i�� ��Ī���� insert�ϴ� ���� ��ȭ�� �ش�.
			// kor,eng,mat -> �������� 0���� 100���� ���� �־��ش�.
			k27_QueryTxt = String.format("insert into score values (%d, 'ȫ��%03d',rand()*100,rand()*100,rand()*100);", i,i);

			try {
				// Statement��ü�� execute �޼ҵ带 ���� ������� �������� �����Ѵ�.
				k27_stmt.execute(k27_QueryTxt);
			} catch (SQLException e) {
				e.printStackTrace();//�����߻��� ���� ������ش�
			}
		}
	}
}
