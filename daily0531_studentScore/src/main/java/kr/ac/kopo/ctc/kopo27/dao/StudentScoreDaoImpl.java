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

	private Connection conn = null;  // 데이터베이스 연결을 위한 Connection 객체
	private Statement stmt = null;  // SQL문 실행을 위한 Statement 객체
	private ResultSet rset = null;  // SQL 쿼리 결과를 저장하기 위한 ResultSet 객체
	
	@Override
	// 학생 점수 데이터의 총 개수를 반환합니다.
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
			// examtable에서 전체 행 갯수를 조회하는 쿼리
			rset = stmt.executeQuery("SELECT count(*) FROM examtable;");

			//rset에 받아온 값이 없을때까지 반복하면서 값 꺼내기
			while (rset.next()) {
				count = rset.getInt(1);//반환되는 첫번째 숫자를 count에 대입
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {//오류가 발생하면 
			e.printStackTrace();//오류를 출력
		}
		return count;//count값을 반환
	}

	@Override
	// 주어진 학생 id에 해당하는 학생 점수 데이터의 데이터 개수를 조회하여 다음으로 들어가야되는 studentId를 반환합니다.
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
			// examtable에서 전체 행을 전부 가져오는 쿼리
			rset = stmt.executeQuery("SELECT * FROM examtable;");

			while (rset.next()) {// rset에 받아온 값이 없을때까지 반복하면서 값 꺼내기
				count++;// 파라미터로 studentId를 받아서 STUDENTID칼럼에서 같은 값이 있기 전까지 +1씩 하면서 증가
				if (studentId == rset.getInt("STUDENTID")) {
					break;// 같은 값이 있다면 반복문 탈출
				}
			}
			
			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}
		return count;// count값을 반환
	}

	@Override
	public StudentScore create(StudentScore studentScore) {// studentScore객체를 파라미터로 받아서 데이터베이스에 추가하는 함수
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();

			String name = studentScore.getName();// 파라미터 studentScore 객체를 받아서 문자열 변수 name에 할당
			int kor = studentScore.getKor();// 파라미터 studentScore 객체를 받아서 숫자형 변수 kor에 할당
			int eng = studentScore.getEng();// 파라미터 studentScore 객체를 받아서 숫자형 변수 eng에 할당
			int mat = studentScore.getMat();// 파라미터 studentScore 객체를 받아서 숫자형 변수 mat에 할당
			int startID = 0;//데이터 넣을때 없는 번호의 studentid값으로 넣기위한 startid 숫자형 변수 선언

			// sql쿼리를 실행하고 결과를 ResultSet에 반환한다
			ResultSet rset = stmt.executeQuery("select * from examtable;");
			startID = 209901;// 최초 학번을 startID 변수에 대입
			while (rset.next()) { // rset 객체의 각 행을 반복한다
				if (startID == rset.getInt(3)) { // 첫번째 자료부터 차례대로 학번을 뽑아 존재하면
					startID++; // 다음학번으로 넘어간다
				} else { // 해당학번이 존재하지 않으면
					break; // 루프를 종료한다
				}
			}

			// INSERT 쿼리를 사용하여 비어있는 학번자리에 객체 추가 
			String sql = "INSERT INTO examtable (name, studentid, kor, eng, mat) VALUES ('" + name + "'," + startID
					+ ", " + kor + ", " + eng + ", " + mat + ")";

			stmt.execute(sql);//sql문을 실행한다.

			System.out.println("insert 성공");//성공시 insert 성공 출력

			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}

		return studentScore;//삽입한 studentScore 객체를 반환한다.
	}

	@Override
	// 주어진 id에 해당하는 학생 점수 데이터를 조회합니다.
	public StudentScore selectOne(int id) {
		StudentScore studentScore = null;//studentScore 객체 선언 및 초기화 
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

			// Statement 객체를 생성합니다.
			Statement stmt = conn.createStatement();

			// 쿼리 결과값을 담을 ResultSet 객체를 생성합니다.
			//id값으로 원하는 값을 쿼리로 검색해서 가져오는데 id가 파라미터로 받은 id와 같은 값을 조회
			rset = stmt.executeQuery("SELECT *, (kor + eng + mat) AS sum, (kor + eng + mat) / 3 AS ave, "
					+ "(SELECT COUNT(*) + 1 FROM examtable WHERE (kor + eng + mat) > (t.kor + t.eng + t.mat)) AS ranking "
					+ "FROM examtable AS t WHERE id = " + id + ";");

			while (rset.next()) {// rset에 받아온 값이 없을때까지 반복하면서 값 꺼내기
				studentScore = new StudentScore();//반복문이 돌때마다 객체를 초기화 시켜주기 위해서 새로운 객체 선언
				studentScore.setId(rset.getInt("ID"));//rset에서 칼럽이 ID을 가져와서 studentScore의 id에 대입
				studentScore.setName(rset.getString("NAME"));//rset에서 칼럽이 NAME을 가져와서 studentScore의 NAME에 대입
				studentScore.setStudentid(rset.getInt("STUDENTID"));//rset에서 칼럽이 STUDENTID을 가져와서 studentScore의 STUDENTID에 대입
				studentScore.setKor(rset.getInt("kor"));//rset에서 칼럽이 kor을 가져와서 studentScore의 kor에 대입
				studentScore.setEng(rset.getInt("eng"));//rset에서 칼럽이 eng을 가져와서 studentScore의 eng에 대입
				studentScore.setMat(rset.getInt("mat"));//rset에서 칼럽이 mat을 가져와서 studentScore의 mat에 대입
				studentScore.setSum(rset.getInt("sum"));//rset에서 칼럽이 sum을 가져와서 studentScore의 sum에 대입
				studentScore.setAve(rset.getInt("ave"));//rset에서 칼럽이 ave을 가져와서 studentScore의 ave에 대입
				studentScore.setRanking(rset.getInt("ranking"));//rset에서 칼럽이 ranking을 가져와서 studentScore의 ranking에 대입
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		}catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}
		return studentScore;//id값으로 조회한 학생 점수 데이터 반환
	}

	@Override
	// 주어진 학생 studentId에 해당하는 학생 점수 데이터를 조회합니다.
	public StudentScore selectByStudentId(int studentid) {
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
			//파라미터로 받은 studentid값과 같은 studentid의 학생 점수 데이터를 가져오는 쿼리를 실행한다.
			rset = stmt.executeQuery("SELECT *, (kor + eng + mat) AS sum, (kor + eng + mat) / 3 AS ave, "
					+ "(SELECT COUNT(*) + 1 FROM examtable WHERE (kor + eng + mat) > (t.kor + t.eng + t.mat)) AS ranking "
					+ "FROM examtable AS t WHERE studentid = " + studentid + ";");
			
			// ResultSet에서 데이터를 읽어와 StudentScore 객체에 저장합니다.
			while (rset.next()) {
			    // 새로운 StudentScore 객체를 생성합니다.
			    studentScore = new StudentScore();

			    // ResultSet에서 각 컬럼의 값을 가져와서 StudentScore 객체에 설정합니다.
			    studentScore.setId(rset.getInt("ID"));  // ID 컬럼 값 설정
			    studentScore.setName(rset.getString("NAME"));  // NAME 컬럼 값 설정
			    studentScore.setStudentid(rset.getInt("STUDENTID"));  // STUDENTID 컬럼 값 설정
			    studentScore.setKor(rset.getInt("kor"));  // kor 컬럼 값 설정
			    studentScore.setEng(rset.getInt("eng"));  // eng 컬럼 값 설정
			    studentScore.setMat(rset.getInt("mat"));  // mat 컬럼 값 설정
			    studentScore.setSum(rset.getInt("sum"));  // sum 컬럼 값 설정
			    studentScore.setAve(rset.getInt("ave"));  // ave 컬럼 값 설정
			    studentScore.setRanking(rset.getInt("ranking"));  // ranking 컬럼 값 설정
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		}catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}
		return studentScore;// 주어진 학생 studentId에 해당하는 학생 점수 데이터를 반환
	}

	@Override
	public List<StudentScore> selectAll(int page, int countPerPage) {// StudentScore 객체들의 리스트를 반환하는 메소드 selectAll
		System.out.println("===> examtable과 연결 시작!");//확인용 출력구문

		int rstart = (page - 1) * countPerPage;// 출력하고 싶은 페이지의 첫번째 데이터 인덱스 구하기

		//StudentScore 객체들의 리스트를 담기위한 리스트 선언 및 초기화
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
			// examtable에서 페이지의 첫번째 시작 인덱스부터 한페이지에 출력할 갯수 만큼 쿼리로 범위를 설정해서 가져오기
			rset = stmt.executeQuery("SELECT *, (kor + eng + mat) AS sum, (kor + eng + mat) / 3 AS ave, "
					+ "(SELECT COUNT(*) + 1 FROM examtable WHERE (kor + eng + mat) > (t.kor + t.eng + t.mat)) AS ranking "
					+ "FROM examtable AS t ORDER BY studentid ASC LIMIT " + rstart + "," + countPerPage + ";");

			while (rset.next()) {
			    // 새로운 StudentScore 객체를 생성합니다.
			    StudentScore studentScore = new StudentScore();

			    // ResultSet에서 각 컬럼의 값을 가져와서 StudentScore 객체에 설정합니다.
			    studentScore.setId(rset.getInt("id"));  // id 컬럼 값 설정
			    studentScore.setName(rset.getString("NAME"));  // NAME 컬럼 값 설정
			    studentScore.setStudentid(rset.getInt("STUDENTID"));  // STUDENTID 컬럼 값 설정
			    studentScore.setKor(rset.getInt("KOR"));  // KOR 컬럼 값 설정
			    studentScore.setEng(rset.getInt("ENG"));  // ENG 컬럼 값 설정
			    studentScore.setMat(rset.getInt("MAT"));  // MAT 컬럼 값 설정
			    studentScore.setSum(rset.getInt("sum"));  // sum 컬럼 값 설정
			    studentScore.setAve(rset.getInt("ave"));  // ave 컬럼 값 설정
			    studentScore.setRanking(rset.getInt("ranking"));  // ranking 컬럼 값 설정

			    // StudentScore 객체를 StudentScoreList에 추가합니다.
			    StudentScoreList.add(studentScore);
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		}catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}
		return StudentScoreList;//StudentScore 객체들의 리스트를 반환
	}

	@Override
	// 주어진 id에 해당하는 학생 점수 데이터를 파라미터로 받아 정보를 업데이트하는 함수
	public StudentScore update(int id, StudentScore studentScore) {
		StudentScore ss = null;//업데이트된 객체를 반환하기위해 StudentScore 객체 선언
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
			    // 새로운 StudentScore 객체를 생성합니다.
			    ss = new StudentScore();

			    // ResultSet에서 각 컬럼의 값을 가져와서 StudentScore 객체에 설정합니다.
			    ss.setId(rset.getInt("id"));  // id 컬럼 값 설정
			    ss.setName(rset.getString("name"));  // name 컬럼 값 설정
			    ss.setStudentid(rset.getInt("studentid"));  // studentid 컬럼 값 설정
			    ss.setKor(rset.getInt("kor"));  // kor 컬럼 값 설정
			    ss.setEng(rset.getInt("eng"));  // eng 컬럼 값 설정
			    ss.setMat(rset.getInt("mat"));  // mat 컬럼 값 설정
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		}catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}
		return ss;//업데이트된 객체를 반환
	}

	@Override
	// 주어진 id에 해당하는 학생 점수 데이터를 삭제하는 함수
	public void deleteById(int id) {
	    try {
	        // JDBC 드라이버 클래스를 동적으로 로드합니다.
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
	        conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

	        // Statement 객체를 생성합니다.
	        stmt = conn.createStatement();

	        // DELETE 문을 실행하여 주어진 id에 해당하는 데이터를 삭제합니다.
	        String sql = "DELETE FROM examtable WHERE id = " + id;
	        stmt.executeUpdate(sql);

	        System.out.println("delete id로 성공");

	    } catch (Exception e) {//오류가 발생하면 
	        e.printStackTrace();//오류를 출력
	    } finally {
	        try {
	            stmt.close();  // 사용한 Statement 객체를 닫습니다.
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        try {
	            conn.close();  // 사용한 Connection 객체를 닫습니다.
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	@Override
	// 주어진 학생 studentId에 해당하는 학생 점수 데이터를 삭제합니다.
	public void deleteByStudentId(int studentId) {// studentId로 삭제
	    try {
	        // JDBC 드라이버 클래스를 동적으로 로드합니다.
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
	        conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

	        // Statement 객체를 생성합니다.
	        stmt = conn.createStatement();

	        // DELETE 문을 실행하여 주어진 studentId에 해당하는 데이터를 삭제합니다.
	        String sql = "DELETE FROM examtable WHERE studentid = " + studentId;
	        stmt.executeUpdate(sql);

	        System.out.println("delete studentId로 성공");

	    } catch (Exception e) {//오류가 발생하면 
	        e.printStackTrace();//오류를 출력
	    } finally {
	        try {
	            stmt.close();  // 사용한 Statement 객체를 닫습니다.
	        } catch (SQLException e) {
	            e.printStackTrace();//오류를 출력
	        }
	        try {
	            conn.close();  // 사용한 Connection 객체를 닫습니다.
	        } catch (SQLException e) {
	            e.printStackTrace();//오류를 출력
	        }
	    }
	}


	@Override
	// examtable 테이블을 생성하는 함수입니다.
	public String createTable() {
	    String errorMessage = ""; // 오류를 보여주기 위한 문자열 변수 선언

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

	        stmt.close(); // Statement 객체를 닫습니다.
	        conn.close(); // Connection 객체를 닫습니다.
	    } catch (SQLException e) { // sql구문에 오류가 있을 시
	        errorMessage = e.getMessage(); // 오류메시지를 출력할 문자열에 담기
	    } catch (ClassNotFoundException e) { // 클래스를 찾지 못하는 오류가 있을 시
	        errorMessage = "드라이버 로드 실패: " + e.getMessage(); // 오류메시지를 출력할 문자열에 담기
	    }

	    if (!errorMessage.isEmpty()) { // 만일 오류메시지가 있다면
	        System.out.println("에러 발생: " + errorMessage); // 출력하기
	    }
	    return errorMessage;//오류메시지를 반환
	}


	@Override
	// examtable 테이블을 삭제하는 함수입니다.
	public String dropTable() {
	    String errorMessage = ""; // 오류를 보여주기 위한 문자열 변수 선언

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

	        stmt.close(); // Statement 객체를 닫습니다.
	        conn.close(); // Connection 객체를 닫습니다.

	    } catch (SQLException e) { // sql구문에 오류가 있을 시
	        errorMessage = e.getMessage(); // 오류메시지를 출력할 문자열에 담기
	    } catch (ClassNotFoundException e) { // 클래스를 찾지 못하는 오류가 있을 시
	        errorMessage = "드라이버 로드 실패: " + e.getMessage(); // 오류메시지를 출력할 문자열에 담기
	    }

	    if (!errorMessage.isEmpty()) { // 만일 오류메시지가 있다면
	        System.out.println("에러 발생: " + errorMessage); // 출력하기
	    }
	    return errorMessage;//오류메시지를 반환
	}


	@Override
	// examtable 테이블에 모든 데이터를 삽입하는 함수입니다.
	public String insertAll() {
	    String errorMessage = ""; // 오류를 보여주기 위한 문자열 변수 선언
	    try {
	        // "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
	        // MySQL 데이터베이스와의 연결
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
	        // getConnection 메서드의 인자로는 JDBC URL, mysql의 사용자 이름, mysql사용자의 비밀번호를 입력한다.
	        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

	        // Statement 객체를 생성합니다.
	        Statement stmt = conn.createStatement();

	        for (int i = 0; i < 150; i++) { // i가 0부터 149까지 150번 반복하는 반복문
	            int cnt = i + 1;//이름뒤에 숫자를 붙이기 위해 cnt 변수 선언
	            String name = "홍길" + cnt;//만들어진 cnt를 홍길뒤에 하나씩 붙이면서 이름을 생성
	            int studentid = 209900 + cnt;//학번을 만들기 위해 초기값 209900에 cnt를 더해서 studentid를 생성
	            //만들어진 값으로 insert하는 쿼리 한번 실행
	            stmt.execute("INSERT INTO examtable (name, studentid, kor, eng, mat) VALUE ('" + name + "', "
	                    + studentid + "," + "rand()*100, rand()*100, rand()*100);");
	        }
	        // 데이터 삽입 후 문구 출력하기
	        System.out.println("데이터 입력 OK");

	        stmt.close(); // Statement 객체를 닫습니다.
	        conn.close(); // Connection 객체를 닫습니다.
	    } catch (SQLException e) { // sql구문에 오류가 있을 시
	        errorMessage = e.getMessage(); // 오류메시지를 출력할 문자열에 담기
	    } catch (ClassNotFoundException e) { // 클래스를 찾지 못하는 오류가 있을 시
	        errorMessage = "드라이버 로드 실패: " + e.getMessage(); // 오류메시지를 출력할 문자열에 담기
	    }

	    if (!errorMessage.isEmpty()) { // 만일 오류메시지가 있다면
	        System.out.println("에러 발생: " + errorMessage); // 출력하기
	    }
	    return errorMessage;//오류메시지를 반환
	}


	@Override
	public int peopleCount() {//방문자 수를 세는 함수 
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
			// countpeople에서 전체 행을 조회하는 쿼리
			rset = stmt.executeQuery("SELECT * FROM countpeople;");

			while (rset.next()) {
				peopleCount = rset.getInt(1);
			}

			System.out.println("전 : " + peopleCount);

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {//오류가 발생하면
			e.printStackTrace();//오류를 출력
		}
		return peopleCount;//방문자 수를 반환
	}

	@Override
	public int updatePeopleCount(int peopleCount) {
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();

			//방문자 수를 업데이트 하는 쿼리를 실행
			String query = "UPDATE countpeople SET countnum = " + peopleCount;
			int rowsAffected = stmt.executeUpdate(query);//쿼리를 실행하고 결과를 숫자형 변수에 담기

			System.out.println("방문자수 업데이트 성공");//방문자수 업데이트 성공시 출력

			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {//오류가 발생하면
			e.printStackTrace();//오류를 출력
		}

		return peopleCount;//업데이트된 방문자 수를 업데이트
	}

	@Override
	// 주어진 테이블명이 존재하는지 확인하는 함수입니다.
	public boolean isTableExists(String tableName) {
	    boolean tableExists = false;
	    try {
	        // JDBC 드라이버 클래스를 동적으로 로드합니다.
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
	        conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

	        // Statement 객체를 생성합니다.
	        stmt = conn.createStatement();
	        String table = "kopo27";

	        // 주어진 테이블명이 정보 스키마 내에 존재하는지 확인하는 쿼리를 실행합니다.
	        String query = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = '" + table
	                + "' AND table_name = '" + tableName + "'";
	         rset = stmt.executeQuery(query);

	        //rset 객체인 rset에서 결과를 가져와서 rset.getInt(1)은 결과 집합의 첫 번째 열의 값을 가져오기
	         //값이 0보다 큰 경우, 테이블이 존재하는 경우 tableExists 변수를 true로 설정합니다.
	        while (rset.next()) {
	            int count = rset.getInt(1);
	            if (count > 0) {
	                tableExists = true;
	            }
	        }

	        rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

	    } catch (Exception e) {//오류가 발생하면 
	        e.printStackTrace();//오류출력
	    }
	    return tableExists;//테이블의 존재유무를 반환
	}

	@Override
	// 주어진 학생 name에 해당하는 학생 점수 데이터를 반환
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
			//파라미터로 받은 name값과 같은 name의 학생 점수 데이터를 가져오는 쿼리를 실행한다.
			rset = stmt.executeQuery("SELECT *, (kor + eng + mat) AS sum, (kor + eng + mat) / 3 AS ave, "
					+ "(SELECT COUNT(*) + 1 FROM examtable WHERE (kor + eng + mat) > (t.kor + t.eng + t.mat)) AS ranking "
					+ "FROM examtable AS t WHERE name = '" + name + "';");
			
			// ResultSet에서 데이터를 읽어와 StudentScore 객체에 저장합니다.
			while (rset.next()) {
			    // 새로운 StudentScore 객체를 생성합니다.
			    studentScore = new StudentScore();

			    // ResultSet에서 각 컬럼의 값을 가져와서 StudentScore 객체에 설정합니다.
			    studentScore.setId(rset.getInt("ID"));  // ID 컬럼 값 설정
			    studentScore.setName(rset.getString("NAME"));  // NAME 컬럼 값 설정
			    studentScore.setStudentid(rset.getInt("STUDENTID"));  // STUDENTID 컬럼 값 설정
			    studentScore.setKor(rset.getInt("kor"));  // kor 컬럼 값 설정
			    studentScore.setEng(rset.getInt("eng"));  // eng 컬럼 값 설정
			    studentScore.setMat(rset.getInt("mat"));  // mat 컬럼 값 설정
			    studentScore.setSum(rset.getInt("sum"));  // sum 컬럼 값 설정
			    studentScore.setAve(rset.getInt("ave"));  // ave 컬럼 값 설정
			    studentScore.setRanking(rset.getInt("ranking"));  // ranking 컬럼 값 설정
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		}catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}
		return studentScore;// 주어진 학생 name에 해당하는 학생 점수 데이터를 반환
	}
}
