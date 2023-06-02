package kr.ac.kopo.ctc.kopo27.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ctc.kopo27.domain.StudentScore;

public class StudentScoreDaoImpl implements StudentScoreDao {

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rset = null;

	@Override
	public int count() {
		int count = 0;
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
			rset = stmt.executeQuery("SELECT count(*) FROM examtable;");

			while (rset.next()) {
				count = rset.getInt(1);
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public int updateDataCount(int studentId) {
		int count = 0;
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
			rset = stmt.executeQuery("SELECT * FROM examtable;");
			
			while (rset.next()) {
				count ++;
				if(studentId == rset.getInt("STUDENTID")) {
					break;
				}
			}
			
			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public StudentScore create(StudentScore studentScore) {// insert
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();

			// 파라미터 name을 받아서 문자열 변수 cTmp에 할당
			String name = studentScore.getName();
			int studentId = studentScore.getStudentid();
			int kor = studentScore.getKor();
			int eng = studentScore.getEng();
			int mat = studentScore.getMat();
			int startID = 0;
			
			 ResultSet rset = stmt.executeQuery("select * from examtable;");
	            //sql쿼리를 실행하고 결과를 ResultSet에 반환한다
	            startID = 209901;//최초 학번을 fromId 변수에 대입
	            while (rset.next()){ //rset객체의 각 행을 반복한다
	                if (startID == rset.getInt(3)) { //첫번째 자료부터 차례대로 학번을 뽑아 존재하면
	                    startID++;   //다음학번으로 넘어간다
	                } else { //해당학번이 존재하지 않으면
	                    break; //루프를 종료한다
	                }
	            }     

	            // INSERT 쿼리를 사용하여 새로운 학번을 추가
	            String sql = "INSERT INTO examtable (name, studentid, kor, eng, mat) VALUES ('"
	            + name + "'," + startID + ", " + kor + ", " + eng + ", " + mat + ")";

			// INSERT 쿼리를 사용하여 새로운 학번을 추가
//			String sql = "INSERT INTO examtable (name, studentid, kor, eng, mat) VALUES ('" + name + "'," + studentId
//					+ ", " + kor + ", " + eng + ", " + mat + ")";

			stmt.execute(sql);

			System.out.println("insert 성공");

			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentScore;
	}

	@Override
	public StudentScore selectOne(int id) {
		StudentScore studentScore = null;
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement 객체를 생성합니다.
			Statement stmt = conn.createStatement();

			// 쿼리 결과값을 담을 ResultSet 객체를 생성합니다.
			rset = stmt.executeQuery("SELECT *, (kor + eng + mat) AS sum, (kor + eng + mat) / 3 AS ave, "
					+ "(SELECT COUNT(*) + 1 FROM examtable WHERE (kor + eng + mat) > (t.kor + t.eng + t.mat)) AS ranking "
					+ "FROM examtable AS t WHERE id = " + id + ";");

			if (rset.next()) {
				studentScore = new StudentScore();
				studentScore.setId(rset.getInt("ID"));
				studentScore.setName(rset.getString("NAME"));
				studentScore.setStudentid(rset.getInt("STUDENTID"));
				studentScore.setKor(rset.getInt("kor"));
				studentScore.setEng(rset.getInt("eng"));
				studentScore.setMat(rset.getInt("mat"));
				studentScore.setSum(rset.getInt("sum"));
				studentScore.setAve(rset.getInt("ave"));
				studentScore.setRanking(rset.getInt("ranking"));
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentScore;
	}
	
	@Override
	public StudentScore selectBystudentid(int studentid) {
		StudentScore studentScore = null;
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
			
			// Statement 객체를 생성합니다.
			Statement stmt = conn.createStatement();
			
			// 쿼리 결과값을 담을 ResultSet 객체를 생성합니다.
			rset = stmt.executeQuery("SELECT *, (kor + eng + mat) AS sum, (kor + eng + mat) / 3 AS ave, "
					+ "(SELECT COUNT(*) + 1 FROM examtable WHERE (kor + eng + mat) > (t.kor + t.eng + t.mat)) AS ranking "
					+ "FROM examtable AS t WHERE studentid = " + studentid + ";");
			
			if (rset.next()) {
				studentScore = new StudentScore();
				studentScore.setId(rset.getInt("ID"));
				studentScore.setName(rset.getString("NAME"));
				studentScore.setStudentid(rset.getInt("STUDENTID"));
				studentScore.setKor(rset.getInt("kor"));
				studentScore.setEng(rset.getInt("eng"));
				studentScore.setMat(rset.getInt("mat"));
				studentScore.setSum(rset.getInt("sum"));
				studentScore.setAve(rset.getInt("ave"));
				studentScore.setRanking(rset.getInt("ranking"));
			}
			
			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentScore;
	}

	@Override
	public List<StudentScore> selectAll(int page, int countPerPage) {// StudentScore 객체들의 리스트를 반환하는 메소드 selectAll
		System.out.println("===> examtable과 연결 시작!");

		int rstart = (page - 1) * countPerPage;// 첫번째 데이터 인덱스 구하기
		System.out.println(rstart);

		List<StudentScore> StudentScoreList = new ArrayList<StudentScore>();
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
			rset = stmt.executeQuery("SELECT *, (kor + eng + mat) AS sum, (kor + eng + mat) / 3 AS ave, "
					+ "(SELECT COUNT(*) + 1 FROM examtable WHERE (kor + eng + mat) > (t.kor + t.eng + t.mat)) AS ranking "
					+ "FROM examtable AS t LIMIT " + rstart + "," + countPerPage + ";");

			while (rset.next()) {
				StudentScore studentScore = new StudentScore();
				studentScore.setId(rset.getInt("id"));
				studentScore.setName(rset.getString("NAME"));
				studentScore.setStudentid(rset.getInt("STUDENTID"));
				studentScore.setKor(rset.getInt("KOR"));
				studentScore.setEng(rset.getInt("ENG"));
				studentScore.setMat(rset.getInt("MAT"));
				studentScore.setSum(rset.getInt("sum"));
				studentScore.setAve(rset.getInt("ave"));
				studentScore.setRanking(rset.getInt("ranking"));
				StudentScoreList.add(studentScore);
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {
			e.printStackTrace();
		}
		return StudentScoreList;
	}

	@Override
	public StudentScore update(int id, StudentScore studentScore) {
		StudentScore ss = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();

			// SQL 쿼리문을 실행하기 위해 executeUpdate 메서드를 호출합니다.
			String updateQuery = "UPDATE examtable SET " + "name = '" + studentScore.getName() + "', " + "studentid = "
					+ studentScore.getStudentid() + ", kor = " + studentScore.getKor() + ", eng = "
					+ studentScore.getEng() + ", mat = " + studentScore.getMat() + " WHERE id = " + id;

			stmt.executeUpdate(updateQuery);

			System.out.println("update 성공");

			// 업데이트된 결과를 확인하기 위해 select 쿼리를 실행합니다.
			rset = stmt.executeQuery("SELECT * FROM examtable WHERE id = " + id);

			while (rset.next()) {
				ss = new StudentScore();
				ss.setId(rset.getInt("id"));
				ss.setName(rset.getString("name"));
				ss.setStudentid(rset.getInt("studentid"));
				ss.setKor(rset.getInt("kor"));
				ss.setEng(rset.getInt("eng"));
				ss.setMat(rset.getInt("mat"));
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ss;
	}

	@Override
	public void deleteById(int id) {// id로 삭제
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			stmt = conn.createStatement();
			String sql = "DELETE FROM examtable WHERE id = " + id;
			stmt.executeUpdate(sql);

			System.out.println("delete id로 성공");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteByStudentId(int studentId) {// studentId로 삭제
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			stmt = conn.createStatement();
			String sql = "DELETE FROM examtable WHERE studentid = " + studentId;
			stmt.executeUpdate(sql);

			System.out.println("delete studentId로 성공");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String createTable() {
		String errorMessage = "";// 오류를 보여주기 위한 문자열 변수 선언

		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			// getConnection 메서드의 인자로는 JDBC URL, mysql의 사용자 이름, mysql사용자의 비밀번호를 입력한다.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement 객체를 생성합니다.
			Statement stmt = conn.createStatement();

			// examtable이라는 테이블을 생성하는 SQL문을 실행합니다.
			stmt.execute("create table examtable ( id INT AUTO_INCREMENT PRIMARY KEY," + "name varchar(20),"
					+ "studentid int not null unique," + "kor int," + "eng int," + "mat int)"
					+ "DEFAULT CHARSET=utf8;");

			// 테이블 생성하면 문구 출력하기
			System.out.println("테이블 만들기 OK");

			stmt.close();// Statement 객체를 닫습니다.
			conn.close();// Connection 객체를 닫습니다.
		} catch (SQLException e) {// sql구문에 오류가 있을시
			errorMessage = e.getMessage();// 오류메시지를 출력할 문자열에 담기
		} catch (ClassNotFoundException e) {// 클래스를 찾지못하는 오류가 있을시
			errorMessage = "드라이버 로드 실패: " + e.getMessage();// 오류메시지를 출력할 문자열에 담기
		}

		if (!errorMessage.isEmpty()) {// 만일 오류메시지가 있다면
			System.out.println("에러 발생: " + errorMessage);// 출력하기
		}
		return errorMessage;
	}

	@Override
	public String dropTable() {
		String errorMessage = "";// 오류를 보여주기 위한 문자열 변수 선언

		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			// getConnection 메서드의 인자로는 JDBC URL, mysql의 사용자 이름, mysql사용자의 비밀번호를 입력한다.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement 객체를 생성합니다.
			Statement stmt = conn.createStatement();

			// SQL 쿼리문을 실행하기 위해 execute 메서드를 호출합니다.
			// 이 코드에서는 "drop from examtable" 쿼리를 실행하여 examtable을 삭제합니다.
			stmt.execute("drop table examtable;");

			System.out.println("테이블 지우기 OK");

			stmt.close();// Statement 객체를 닫습니다.
			conn.close();// Connection 객체를 닫습니다.

		} catch (SQLException e) {// sql구문에 오류가 있을시
			errorMessage = e.getMessage();// 오류메시지를 출력할 문자열에 담기
		} catch (ClassNotFoundException e) {// 클래스를 찾지못하는 오류가 있을시
			errorMessage = "드라이버 로드 실패: " + e.getMessage();// 오류메시지를 출력할 문자열에 담기
		}

		if (!errorMessage.isEmpty()) {// 만일 오류메시지가 있다면
			System.out.println("에러 발생: " + errorMessage);// 출력하기
		}
		return errorMessage;
	}

	@Override
	public StudentScore selectByName(String name) {
		StudentScore studentScore = null;
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
			
			// Statement 객체를 생성합니다.
			Statement stmt = conn.createStatement();
			
			// 쿼리 결과값을 담을 ResultSet 객체를 생성합니다.
			rset = stmt.executeQuery("SELECT *, (kor + eng + mat) AS sum, (kor + eng + mat) / 3 AS ave, "
					+ "(SELECT COUNT(*) + 1 FROM examtable WHERE (kor + eng + mat) > (t.kor + t.eng + t.mat)) AS ranking "
					+ "FROM examtable AS t WHERE name = '" + name + "';");
			
			if (rset.next()) {
				studentScore = new StudentScore();
				studentScore.setId(rset.getInt("ID"));
				studentScore.setName(rset.getString("NAME"));
				studentScore.setStudentid(rset.getInt("STUDENTID"));
				studentScore.setKor(rset.getInt("kor"));
				studentScore.setEng(rset.getInt("eng"));
				studentScore.setMat(rset.getInt("mat"));
				studentScore.setSum(rset.getInt("sum"));
				studentScore.setAve(rset.getInt("ave"));
				studentScore.setRanking(rset.getInt("ranking"));
			}
			
			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentScore;
	}

	@Override
	public String insertAll() {
		String errorMessage = "";// 오류를 보여주기 위한 문자열 변수 선언
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			// getConnection 메서드의 인자로는 JDBC URL, mysql의 사용자 이름, mysql사용자의 비밀번호를 입력한다.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement 객체를 생성합니다.
			Statement stmt = conn.createStatement();
			
		for (int i = 0; i < 150; i++) {//i가 0부터 999까지 반복하는 반복문
			int cnt = i + 1;
	        String name = "홍길"+cnt;
	        int studentid = 209900 + cnt;
	        stmt.execute("INSERT INTO examtable (name, studentid, kor, eng, mat) VALUE ('" + name + "', " +studentid +"," + "rand()*100, rand()*100, rand()*100);");
		}
			// 테이블 생성하면 문구 출력하기
			System.out.println("데이터 입력 OK");

			stmt.close();// Statement 객체를 닫습니다.
			conn.close();// Connection 객체를 닫습니다.
		} catch (SQLException e) {// sql구문에 오류가 있을시
			errorMessage = e.getMessage();// 오류메시지를 출력할 문자열에 담기
		} catch (ClassNotFoundException e) {// 클래스를 찾지못하는 오류가 있을시
			errorMessage = "드라이버 로드 실패: " + e.getMessage();// 오류메시지를 출력할 문자열에 담기
		}

		if (!errorMessage.isEmpty()) {// 만일 오류메시지가 있다면
			System.out.println("에러 발생: " + errorMessage);// 출력하기
		}
		return errorMessage;
	}

	@Override
	public int peopleCount() {
		int peopleCount = 0;
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
			rset = stmt.executeQuery("SELECT * FROM countpeople;");

			while (rset.next()) {
				peopleCount = rset.getInt(1);
			}
			
			System.out.println("전 : " + peopleCount);
			
			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {
			e.printStackTrace();
		}
		return peopleCount;
	}

	@Override
	public int updatePeopleCount(int peopleCount) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
	        stmt = conn.createStatement();
	        
	        String query = "UPDATE countpeople SET countnum = " + peopleCount;
	        int rowsAffected = stmt.executeUpdate(query);

	        System.out.println("방문자수 업데이트 성공");
	        System.out.println(rowsAffected + " 행이 업데이트되었습니다.");
	        
	        stmt.close();
	        conn.close();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return peopleCount;
	}
	
	@Override
	public boolean isTableExists(String tableName) {
	    boolean tableExists = false;
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
	        stmt = conn.createStatement();
	        String table = "kopo27";
	        
	        String query = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = '" + table + "' AND table_name = '" + tableName + "'";
	        ResultSet resultSet = stmt.executeQuery(query);
	        
	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            if (count > 0) {
	                tableExists = true;
	            }
	        }
	        
	        resultSet.close();
	        stmt.close();
	        conn.close();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return tableExists;
	}

}
