package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Gongji;

public class GongjiDaoImpl implements GongjiDao {

	private Connection conn = null; // 데이터베이스 연결을 위한 Connection 객체
	private Statement stmt = null; // SQL문 실행을 위한 Statement 객체
	private ResultSet rset = null; // SQL 쿼리 결과를 저장하기 위한 ResultSet 객체

	@Override
	public int makeData() {
		int result = -1; // 오류를 보여주기 위한 문자열 변수 선언
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			// getConnection 메서드의 인자로는 JDBC URL, mysql의 사용자 이름, mysql사용자의 비밀번호를 입력한다.
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root",
					"kopoctc");

			// Statement 객체를 생성합니다.
			Statement stmt = conn.createStatement();

			// gongji이라는 테이블을 생성하는 SQL문을 실행합니다.
			stmt.execute("create table gongji ( id INT not null AUTO_INCREMENT PRIMARY KEY," + "title varchar(70),"
					+ "date date," + "content text)" + "DEFAULT CHARSET=utf8;");

			for (int i = 1; i <= 150; i++) {
				String title = "공지사항 " + i;
				java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
				String content = "공지사항내용 " + i;

				String insertQuery = "INSERT INTO gongji (title, date, content) VALUES ('" + title + "', '" + date
						+ "', '" + content + "')";

				stmt.executeUpdate(insertQuery);
			}

			result = 1;
			// 테이블 생성하면 문구 출력하기
			System.out.println("테이블 만들기 OK");

			stmt.close(); // Statement 객체를 닫습니다.
			conn.close(); // Connection 객체를 닫습니다.
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;// 오류메시지를 반환
	}

	@Override
	public List<Gongji> selectAllGongji() {
		System.out.println("===> gongji과 연결 시작!");// 확인용 출력구문

		// StudentScore 객체들의 리스트를 담기위한 리스트 선언 및 초기화
		List<Gongji> GongjiList = new ArrayList<Gongji>();
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");

			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();

			// 쿼리 결과값을 담을 ResultSet 객체를 생성합니다.
			// gongji에서 페이지의 첫번째 시작 인덱스부터 한페이지에 출력할 갯수 만큼 쿼리로 범위를 설정해서 가져오기
			rset = stmt.executeQuery("SELECT * FROM gongji ORDER BY id DESC;");

			while (rset.next()) {
				// 새로운 gongji 객체를 생성합니다.
				Gongji gongji = new Gongji();

				// ResultSet에서 각 컬럼의 값을 가져와서 gongji 객체에 설정합니다.
				gongji.setId(rset.getInt("id")); // id 컬럼 값 설정
				gongji.setTitle(rset.getString("title")); // title 컬럼 값 설정
				gongji.setDate(rset.getString("date")); // date 컬럼 값 설정
				gongji.setContent(rset.getString("content")); // content 컬럼 값 설정

				// gongji 객체를 GongjiList에 추가합니다.
				GongjiList.add(gongji);
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}
		return GongjiList;// GongjiList 객체들의 리스트를 반환
	}

	@Override
	public Gongji selectOneGongji(int id) {
		Gongji gongji = null;// gongji 객체 선언 및 초기화
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");

			// Statement 객체를 생성합니다.
			Statement stmt = conn.createStatement();

			// 쿼리 결과값을 담을 ResultSet 객체를 생성합니다.
			// id값으로 원하는 값을 쿼리로 검색해서 가져오는데 id가 파라미터로 받은 id와 같은 값을 조회
			rset = stmt.executeQuery("SELECT * FROM gongji WHERE id = " + id + ";");

			while (rset.next()) {// rset에 받아온 값이 없을때까지 반복하면서 값 꺼내기
				gongji = new Gongji();// 반복문이 돌때마다 객체를 초기화 시켜주기 위해서 새로운 객체 선언
				gongji.setId(rset.getInt("id")); // id 컬럼 값 설정
				gongji.setTitle(rset.getString("title")); // title 컬럼 값 설정
				gongji.setDate(rset.getString("date")); // date 컬럼 값 설정
				gongji.setContent(rset.getString("content")); // content 컬럼 값 설정
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}
		return gongji;// id값으로 조회한 gongji 데이터 반환
	}

	@Override
	public int deleteOneGongji(int id) {
		int result = -1;
		try {
			// JDBC 드라이버 클래스를 동적으로 로드합니다.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");

			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();

			// DELETE 문을 실행하여 주어진 id에 해당하는 데이터를 삭제합니다.
			String sql = "DELETE FROM gongji WHERE id = " + id;
			stmt.executeUpdate(sql);

			System.out.println("delete id로 성공");
			result = 1;

			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}
		return result;
	}

	@Override
	public int updateGongji(Gongji gongji) {
		int result = -1;// 업데이트된 객체를 반환하기위해 gongji 객체 선언
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");

			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();

			// SQL 쿼리문을 실행하기 위해 executeUpdate 메서드를 호출합니다.
			// 현재시간을 사용하려면 NOW() 함수를 사용
			String updateQuery = "UPDATE gongji SET " + "title = '" + gongji.getTitle() + "', " + "date = NOW(), "
					+ "content = '" + gongji.getContent() + "' " + "WHERE id = " + gongji.getId();

			stmt.executeUpdate(updateQuery);

			System.out.println("update 성공");
			result = 1;

			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}
		return result;// 업데이트된 객체를 반환
	}

	@Override
	public int insertGongji(String title, String content) {
		int result = -1;
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");

			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();

			// INSERT 쿼리를 사용하여 새로운 내용 추가
			String sql = "INSERT INTO gongji (title, date, content) VALUES ('" + title + "', NOW(), '" + content + "')";

			stmt.execute(sql);// sql문을 실행한다.
			System.out.println("insert 성공");// 성공시 insert 성공 출력
			result = 1;

			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}
		return result;// 삽입한 studentScore 객체를 반환한다.
	}
	
	@Override
	public Gongji newGongji() {
		Gongji gongji = null;
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");
			
			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();
			
			// 가장 최신 공지 객체를 찾아오는 쿼리 생성
			rset = stmt.executeQuery("SELECT * FROM gongji ORDER BY id DESC LIMIT 1;");
			
			while (rset.next()) {
				// 새로운 Gongji 객체를 생성합니다.
				gongji = new Gongji();

				// ResultSet에서 각 컬럼의 값을 가져와서 gongji 객체에 설정합니다.
				gongji.setId(rset.getInt("id")); // id 컬럼 값 설정
				gongji.setTitle(rset.getString("title")); // title 컬럼 값 설정
				gongji.setDate(rset.getString("date")); // date 컬럼 값 설정
				gongji.setContent(rset.getString("content")); // content 컬럼 값 설정
				
			}
			
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기
			
		} catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}
		return gongji;// 삽입한 studentScore 객체를 반환한다.
	}

	@Override
	public int count() {
		int count = 0;
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");

			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();

			// 쿼리 결과값을 담을 ResultSet 객체를 생성합니다.
			// gongji에서 전체 행 갯수를 조회하는 쿼리
			rset = stmt.executeQuery("SELECT count(*) FROM gongji;");

			// rset에 받아온 값이 없을때까지 반복하면서 값 꺼내기
			while (rset.next()) {
				count = rset.getInt(1);// 반환되는 첫번째 숫자를 count에 대입
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
	public List<Gongji> selectAll(int pageNum, int countPerPage) {
		System.out.println("===> gongji과 연결 시작!");// 확인용 출력구문

		int rstart = (pageNum - 1) * countPerPage;// 출력하고 싶은 페이지의 첫번째 데이터 인덱스 구하기

		// gongji 객체들의 리스트를 담기위한 리스트 선언 및 초기화
		List<Gongji> GongjiList = new ArrayList<Gongji>();
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");

			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();

			// 쿼리 결과값을 담을 ResultSet 객체를 생성합니다.
			// gongji에서 페이지의 첫번째 시작 인덱스부터 한페이지에 출력할 갯수 만큼 쿼리로 범위를 설정해서 가져오기
			rset = stmt
					.executeQuery("SELECT * FROM gongji ORDER BY id DESC LIMIT " + rstart + "," + countPerPage + ";");

			while (rset.next()) {
				// 새로운 Gongji 객체를 생성합니다.
				Gongji gongji = new Gongji();

				// ResultSet에서 각 컬럼의 값을 가져와서 gongji 객체에 설정합니다.
				gongji.setId(rset.getInt("id")); // id 컬럼 값 설정
				gongji.setTitle(rset.getString("title")); // title 컬럼 값 설정
				gongji.setDate(rset.getString("date")); // date 컬럼 값 설정
				gongji.setContent(rset.getString("content")); // content 컬럼 값 설정

				// gongji 객체를 GongjiList에 추가합니다.
				GongjiList.add(gongji);
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}
		return GongjiList;// GongjiList 객체들의 리스트를 반환
	}
	
	
	@Override
	public int updatePeopleCount(int viewcnt, int id) {
		int result = -1;
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");
			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();

			//방문자 수를 업데이트 하는 쿼리를 실행
			String query = "UPDATE gongji SET viewcnt = " + viewcnt + " WHERE id = " + id;
	        int rowsAffected = stmt.executeUpdate(query);//쿼리를 실행하고 결과를 숫자형 변수에 담기

			System.out.println("방문자수 업데이트 성공");//방문자수 업데이트 성공시 출력
			result = 1;
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {//오류가 발생하면
			e.printStackTrace();//오류를 출력
		}

		return result;//업데이트된 방문자 수를 업데이트
	}
}
