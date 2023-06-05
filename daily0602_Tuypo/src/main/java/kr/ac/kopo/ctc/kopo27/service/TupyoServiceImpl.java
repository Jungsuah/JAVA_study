package kr.ac.kopo.ctc.kopo27.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TupyoServiceImpl implements TupyoService {

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rset = null;

	@Override
	public int totalCount() {
		int count = 0;
		try {
			// "com.mysql.cj.jdbc.Driver" Ŭ������ �������� �ε��ϱ� ���� Java�� Class.forName �޼��带 ȣ���Ͽ�
			// MySQL �����ͺ��̽����� ����
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL �����ͺ��̽��� �����ϱ� ���� Connection ��ü�� �����մϴ�.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement ��ü�� �����մϴ�.
			stmt = conn.createStatement();

			rset = stmt.executeQuery("select count(*) from Tupyo_table;");

			while (rset.next()) { // rset��ü�� �� ���� �ݺ��Ѵ�
				count = rset.getInt(1);
			}

			System.out.println("�� ��ǥ�� : " + count);

			stmt.close();// ����� Statement ��ü �ݱ�
			conn.close();// ����� Connection ��ü �ݱ�

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
