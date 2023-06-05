package kr.ac.kopo.ctc.kopo27.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ctc.kopo27.domain.Hubo_Table;
import kr.ac.kopo.ctc.kopo27.domain.VotingResult;

public class TuypoDaoImpl implements TuypoDao {

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rset = null;

	@Override
	public int insertHubo(int id, String name) {// 후보 추가하기
		int result = 1;
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();

			int startID = 0;

			ResultSet rset = stmt.executeQuery("select * from hubo_table;");
			// sql쿼리를 실행하고 결과를 ResultSet에 반환한다
			startID = 1;// 최초 학번을 fromId 변수에 대입
			while (rset.next()) { // rset객체의 각 행을 반복한다
				if (startID == rset.getInt(1)) { // 첫번째 자료부터 차례대로 학번을 뽑아 존재하면
					startID++; // 다음학번으로 넘어간다
				} else { // 해당학번이 존재하지 않으면
					id = startID;
					break; // 루프를 종료한다
				}
			}

			// INSERT 쿼리를 사용하여 새로운 학번을 추가
			String sql = "INSERT INTO hubo_table(id, name) VALUES(" + id + ", '" + name + "');";

			stmt.execute(sql);

			System.out.println("insert 성공");

			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {
			result = -1;
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int insertTuypo(int id, int age) {// 후보 추가하기
		int result = 1;
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
			
			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();
			
			int startID = 0;
			
			// INSERT 쿼리를 사용하여 새로운 학번을 추가
			String sql = "INSERT INTO Tupyo_table(id,age ) VALUES(" + id + ", " + age + ");";

			stmt.execute(sql);

			System.out.println("투표 성공");

			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기
			
		} catch (Exception e) {
			result = -1;
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int blankHuboNumber() {// 후보 추가하기
		int startID = 0;
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
			
			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();
			
			ResultSet rset = stmt.executeQuery("select * from hubo_table;");
			// sql쿼리를 실행하고 결과를 ResultSet에 반환한다
			startID = 1;// 최초 학번을 fromId 변수에 대입
			while (rset.next()) { // rset객체의 각 행을 반복한다
				if (startID == rset.getInt(1)) { // 첫번째 자료부터 차례대로 학번을 뽑아 존재하면
					startID++; // 다음학번으로 넘어간다
				} else { // 해당학번이 존재하지 않으면
					break; // 루프를 종료한다
				}
			}
			
			System.out.println("번호 가져오기 성공");
			
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return startID;
	}

	@Override
	public List<VotingResult> getVotingResultsHubo() {// 후보자별 득표수와 득표율 가져오기
		List<VotingResult> voteResultList = new ArrayList<VotingResult>();
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement 객체를 생성합니다.
			Statement stmt = conn.createStatement();

			// 쿼리 결과값을 담을 ResultSet 객체를 생성합니다.
			String query = "SELECT h.id, h.name, COUNT(*) AS voteCount, "
				    + "(COUNT(*) * 100 / total.total_votes) AS votePercentage "
				    + "FROM hubo_table h "
				    + "JOIN Tupyo_table t ON h.id = t.id "
				    + "CROSS JOIN (SELECT COUNT(*) AS total_votes FROM Tupyo_table) AS total "
				    + "GROUP BY h.id, h.name, total.total_votes;";

			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				VotingResult result = new VotingResult();
				result.setId(rset.getInt(1));
				result.setName(rset.getString(2));
				result.setVoteCount(rset.getInt(3));
				result.setVotePercentage(rset.getInt(4));
				voteResultList.add(result);
			}
			
			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(voteResultList.toString());
		return voteResultList;
	}

	@Override
	public List<VotingResult> getVotingResultsAge(int id) {// 후보의 연령대별 득표수와 득표율 가져오기
		System.out.println("연령별 가져오기!!!!!!!!");
		List<VotingResult> voteResultList = new ArrayList<VotingResult>();
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement 객체를 생성합니다.
			Statement stmt = conn.createStatement();

			// 쿼리 결과값을 담을 ResultSet 객체를 생성합니다.
			String query = "select B.name, A.연령대, A.득표수, A.득표율 " + "from (select id, age*10 as 연령대, count(age) as 득표수, "
					+ "count(age)/(select count(*) from Tupyo_table where id = "+  id + ") * 100 as 득표율 "
					+ "from Tupyo_table where id = "+ id +" group by age order by age) as A "
					+ "inner join hubo_table B on A.id = B.id";

			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				VotingResult result = new VotingResult();
				result.setName(rset.getString(1));
				result.setAgeGroup(rset.getInt(2));
				result.setVoteCount(rset.getInt(3));
				result.setVotePercentage(rset.getInt(4));
				voteResultList.add(result);
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {
			e.printStackTrace();
		}
		return voteResultList;
	}

	@Override
	public List<Hubo_Table> selectAll() {// StudentScore 객체들의 리스트를 반환하는 메소드 selectAll
		System.out.println("===> hubo_Table과 연결 시작!");

		List<Hubo_Table> list = new ArrayList<Hubo_Table>();
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();

			// 쿼리 결과값을 담을 ResultSet 객체를 생성합니다.
			// examtable에서 전체 행을 조회하는 쿼리
			rset = stmt.executeQuery("select * from hubo_table;");

			while (rset.next()) {
				Hubo_Table hubo = new Hubo_Table();
				hubo.setId(rset.getInt("id"));
				hubo.setName(rset.getString("NAME"));
				list.add(hubo);
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {
			e.printStackTrace();
		}
//		for (Hubo_Table hubo_Table : list) {
//			System.out.println(hubo_Table.getId() + hubo_Table.getName());
//		}
		return list;
	}

	@Override
	public int deleteById(int id) {// id로 삭제
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			stmt = conn.createStatement();
			String sql1 = "DELETE FROM Tupyo_table WHERE id = " + id;
			stmt.executeUpdate(sql1);
			String sql2 = "DELETE FROM hubo_table WHERE id = " + id;
			stmt.executeUpdate(sql2);
			System.out.println("delete id로 성공");
			result = 1;

		} catch (Exception e) {
			result = -1;
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				result = -1;
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				result = -1;
				e.printStackTrace();
			}
		}
		return result;
	}

}
