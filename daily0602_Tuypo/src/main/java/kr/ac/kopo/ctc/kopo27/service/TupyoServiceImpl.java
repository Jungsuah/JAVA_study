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
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();

			rset = stmt.executeQuery("select count(*) from Tupyo_table;");

			while (rset.next()) { // rset객체의 각 행을 반복한다
				count = rset.getInt(1);
			}

			System.out.println("총 득표수 : " + count);

			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
