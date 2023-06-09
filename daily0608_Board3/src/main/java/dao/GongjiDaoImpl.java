package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	public int makeData() {// 데이터를 입력하는 함수
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
			stmt.execute("CREATE TABLE gongji (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
					+ "title VARCHAR(70), date DATE, content longtext, rootid INT, relevel INT, recnt INT, viewcnt INT) "
					+ "DEFAULT CHARSET=utf8");

			for (int i = 1; i <= 150; i++) {// 데이터 150개 입력
				String title = "공지사항 " + i;// 몇번째 공지사항인지 알려주기위해 i를 붙여서 만들기
				// java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
				java.sql.Date date = java.sql.Date.valueOf("2017-01-01");//초기값 세팅
				String content = "공지사항내용 " + i;//공지사항 내용 넣기
				int rootid = i;//원글의 rootid는 id와 같아야함
				int relevel = 0;//댓글레벨은 0
				int recnt = 0;//댓글내 표시순서는 0
				int viewcnt = 0;//조회수는 0

				//만든 값을 테이블에 넣어주기
				String insertQuery = "INSERT INTO gongji (title, date, content, rootid, relevel, recnt, viewcnt) "
						+ "VALUES ('" + title + "', '" + date + "', '" + content + "', " + rootid + ", " + relevel
						+ ", " + recnt + ", " + viewcnt + ")";
				
				//update하기
				stmt.executeUpdate(insertQuery);
			}

			result = 1;
			// 테이블 생성하면 문구 출력하기
			System.out.println("테이블 만들기 OK");

			stmt.close(); // Statement 객체를 닫습니다.
			conn.close(); // Connection 객체를 닫습니다.
		} catch (Exception e) {//오류가 발생하면
			e.printStackTrace();//메세지 출력
		}
		return result;// 오류메시지를 반환
	}

	@Override
	public Gongji selectOneGongji(int id) {//id롤 객체 하나 조회하기
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
				gongji.setRootid(rset.getInt("rootid")); // rootid 컬럼 값 설정
				gongji.setRelevel(rset.getInt("relevel"));// relevel 컬럼 값 설정
				gongji.setRecnt(rset.getInt("recnt")); // recnt 컬럼 값 설정
				gongji.setViewcnt(rset.getInt("viewcnt")); // viewcnt 컬럼 값 설정
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
	public int updateWongul(Gongji gongji) {//원글 수정하기
		int result = -1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");
			stmt = conn.createStatement();
			
			//업데이트 하는 쿼리로 객체에서 값을 받아서 업데이트 해주기
			String updateQuery = "UPDATE gongji SET " + "title = '" + gongji.getTitle() + "', " + "date = NOW(), "
					+ "content = '" + gongji.getContent() + "', " + "rootid = " + gongji.getRootid() + ", "
					+ "relevel = " + gongji.getRelevel() + ", " + "recnt = " + gongji.getRecnt() + " WHERE id = "
					+ gongji.getId();

			stmt.executeUpdate(updateQuery);// 업데이트 실행

			System.out.println("원글 update 성공");
			result = 1;//성공시 반환값 1로 설정

			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기
		} catch (Exception e) {//오류발생시
			e.printStackTrace();//오류출력
		}
		return result;//반환값 반환
	}

	@Override
	public int count() {//전체 행수를 조회하는 쿼리 
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
	public List<Gongji> selectAll(int pageNum, int countPerPage) {//전체 공지리스트를 가져오는 쿼리
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
			rset = stmt.executeQuery(
					"SELECT * FROM gongji order by rootid desc, recnt asc LIMIT " + rstart + "," + countPerPage + ";");

			while (rset.next()) {
				// 새로운 Gongji 객체를 생성합니다.
				Gongji gongji = new Gongji();

				// ResultSet에서 각 컬럼의 값을 가져와서 gongji 객체에 설정합니다.
				gongji.setId(rset.getInt("id")); // id 컬럼 값 설정
				gongji.setTitle(rset.getString("title")); // title 컬럼 값 설정
				gongji.setDate(rset.getString("date")); // date 컬럼 값 설정
				gongji.setContent(rset.getString("content")); // content 컬럼 값 설정
				gongji.setRootid(rset.getInt("rootid")); // rootid 컬럼 값 설정
				gongji.setRelevel(rset.getInt("relevel"));// relevel 컬럼 값 설정
				gongji.setRecnt(rset.getInt("recnt")); // recnt 컬럼 값 설정
				gongji.setViewcnt(rset.getInt("viewcnt")); // viewcnt 컬럼 값 설정

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

			// 방문자 수를 업데이트 하는 쿼리를 실행
			String query = "UPDATE gongji SET viewcnt = " + (viewcnt + 1) + " WHERE id = " + id;
			int rowsAffected = stmt.executeUpdate(query);// 쿼리를 실행하고 결과를 숫자형 변수에 담기

			System.out.println("방문자수 업데이트 성공");// 방문자수 업데이트 성공시 출력
			result = 1;
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}

		return result;// 업데이트된 방문자 수를 업데이트
	}

	@Override
	public int insertGongji(Gongji gongji) {// 원글 등록
	    int result = -1;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 클래스를 로드합니다.
	     // 데이터베이스에 연결합니다. JDBC URL, 사용자 이름, 비밀번호를 입력합니다.
	        conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc"); 
	        stmt = conn.createStatement(); // Statement 객체를 생성합니다.

	        String sql = "INSERT INTO gongji (title, date, content, rootid, relevel, recnt) " + "VALUES ('"
	                + gongji.getTitle() + "', NOW(), '" + gongji.getContent() + "', " + gongji.getRootid() + ", "
	                + gongji.getRelevel() + ", " + gongji.getRecnt() + ")"; // SQL 쿼리를 생성합니다. 'gongji' 테이블에 데이터를 삽입합니다.

	        stmt.execute(sql); // SQL 쿼리를 실행합니다.

	        result = 1; // 결과를 1로 설정하여 원글 등록이 성공했음을 나타냅니다.
	        System.out.println("원글 등록 성공"); // 성공 메시지를 출력합니다.

	        stmt.close(); // Statement 객체를 닫습니다.
	        conn.close(); // 연결을 닫습니다.
	    } catch (Exception e) {
	        e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력합니다.
	    }
	    return result; // 결과를 반환합니다.
	}


	@Override
	public int insertReply(Gongji gongji) {// 댓글 등록
	    int result = -1;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 클래스를 로드합니다.
	     // 데이터베이스에 연결합니다. JDBC URL, 사용자 이름, 비밀번호를 입력합니다.
	        conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc"); 
	        stmt = conn.createStatement(); // Statement 객체를 생성합니다.

	        stmt.executeUpdate("update gongji set recnt = recnt+1 where recnt >= " + gongji.getRecnt()
	                + " and rootid = " + gongji.getRootid() + ";");
	        // 해당 순서로 내가 들어가기 위해 원래 있던 자료부터 다음 차례의 자료들의 순서를 모두 +1해줌

	        String sql = "INSERT INTO gongji (title, date, content, rootid, relevel, recnt) " + "VALUES ('"
	                + gongji.getTitle() + "', NOW(), '" + gongji.getContent() + "', " + gongji.getRootid() + ", "
	                + gongji.getRelevel() + ", " + gongji.getRecnt() + ")"; // SQL 쿼리를 생성합니다. 'gongji' 테이블에 데이터를 삽입합니다.

	        stmt.execute(sql); // SQL 쿼리를 실행합니다.

	        result = 1; // 결과를 1로 설정하여 댓글 등록이 성공했음을 나타냅니다.
	        System.out.println("댓글 등록 성공"); // 성공 메시지를 출력합니다.

	        stmt.close(); // Statement 객체를 닫습니다.
	        conn.close(); // 연결을 닫습니다.
	    } catch (Exception e) {
	        e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력합니다.
	    }
	    return result; // 결과를 반환합니다.
	}

	@Override
	public int insertNewGongji(String title, String content, int rootid) {// 원글 등록
	    int result = -1;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 클래스를 로드합니다.
	        // 데이터베이스에 연결합니다. JDBC URL, 사용자 이름, 비밀번호를 입력합니다.
	        conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc"); 
	        stmt = conn.createStatement(); // Statement 객체를 생성합니다.

	        String sql = "INSERT INTO gongji (title, date, content, rootid, relevel, recnt) " + "VALUES ('" + title
	                + "', NOW(), '" + content + "', " + (rootid + 1) + ", " + 0 + ", " + 0 + ")"; // SQL 쿼리를 생성합니다. 'gongji' 테이블에 데이터를 삽입합니다.

	        stmt.execute(sql); // SQL 쿼리를 실행합니다.

	        result = 1; // 결과를 1로 설정하여 원글 등록이 성공했음을 나타냅니다.
	        System.out.println("원글 등록 성공"); // 성공 메시지를 출력합니다.

	        stmt.close(); // Statement 객체를 닫습니다.
	        conn.close(); // 연결을 닫습니다.
	    } catch (Exception e) {
	        e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력합니다.
	    }
	    return result; // 결과를 반환합니다.
	}


	@Override
	public int getMiddleRecnt(int rootid, int relevel, int recnt) { // 해당 원글번호에서 댓글이 중간에 들어갈 순서를 찾는 함수
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 데이터베이스와 통신하는데 사용되는 클래스를 호출한다
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");
			// jdbc를 이용하여 mysql데이터베이스에 대한 연결을 설정한다
			stmt = conn.createStatement();
			// 데이터베이스에 대해 sql문을 실행하는데 사용할 statement객체를 생성한다
			rset = stmt.executeQuery("select min(recnt) from gongji where recnt > " + recnt + " and relevel <= "
					+ relevel + " and rootid = " + rootid + ";");
			// 해당 원글의 댓글들 사이에 입력될 순서를 찾는다.
			// 같은 원글을 가지고, 댓글레벨이 같거나 작고, 순서가 큰 댓글들 중에 최소순서를 들어갈 자리로 조회한다
			while (rset.next()) {
				recnt = rset.getInt(1);
			}
			stmt.close(); // Statement개체를 닫는다
			conn.close(); // 데이터베이스 연결을 닫는다
		} catch (Exception e) { // 해당 오류가 발생하면
			e.printStackTrace(); // 오류메시지를 출력하고
			return -1; // -1값을 리턴한다
		}
		return recnt; // 해당순서를 리턴한다
	}

	@Override
	public int getMaxRecnt(int rootid) { // 해당 원글의 마지막 순서를 찾는 함수
		int recnt = -1; // 순서를 담기 위한 정수형 변수 선언 -1로 초기화
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 데이터베이스와 통신하는데 사용되는 클래스를 호출한다
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");
			// jdbc를 이용하여 mysql데이터베이스에 대한 연결을 설정한다
			stmt = conn.createStatement();
			// 데이터베이스에 대해 sql문을 실행하는데 사용할 statement객체를 생성한다
			rset = stmt.executeQuery("select max(recnt)+1 from gongji where rootid = " + rootid + ";");
			// 해당 원글의 마지막 순서를 조회하여 rset에 담아준다
			while (rset.next()) {
				recnt = rset.getInt(1); // 해당 번호를 변수에 대입한다
			}
			stmt.close(); // Statement개체를 닫는다
			conn.close(); // 데이터베이스 연결을 닫는다
		} catch (Exception e) { // 해당 오류가 발생하면
			e.printStackTrace(); // 오류메시지를 출력하고
			return -1; // -1값을 리턴한다
		}
		return recnt; // 해당순서를 리턴한다
	}

	@Override
	public int updateReply(Gongji gongji) {
	    int result = -1;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 클래스를 로드합니다.
	        conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc"); // 데이터베이스에 연결합니다. JDBC URL, 사용자 이름, 비밀번호를 입력합니다.
	        stmt = conn.createStatement(); // Statement 객체를 생성합니다.

	        String updateQuery = "UPDATE gongji SET " + "title = '" + gongji.getTitle() + "', " + "content = '"
	                + gongji.getContent() + "', " + "date = NOW() " + "WHERE id = " + gongji.getId(); // UPDATE 쿼리를 생성하여 댓글을 수정합니다.

	        stmt.executeUpdate(updateQuery); // UPDATE 쿼리를 실행합니다.

	        System.out.println("댓글 update 성공"); // 성공 메시지를 출력합니다.
	        result = 1; // 결과를 1로 설정하여 댓글 수정이 성공했음을 나타냅니다.

	        stmt.close(); // Statement 객체를 닫습니다.
	        conn.close(); // 연결을 닫습니다.
	    } catch (Exception e) {
	        e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력합니다.
	    }
	    return result; // 결과를 반환합니다.
	}

	@Override
	public int delete(int rootid, int relevel, int recnt) {//삭제하는 쿼리
	    String sql = "CALL deletePost(?,?,?)"; // deletePost 프로시저를 호출하는 SQL 쿼리입니다.
	    try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root",
	            "kopoctc"); // 데이터베이스에 연결합니다. JDBC URL, 사용자 이름, 비밀번호를 입력합니다.
	        PreparedStatement pstmt = conn.prepareStatement(sql);) {
	        pstmt.setInt(1, rootid); // 첫 번째 매개변수에 rootid 값을 설정합니다.
	        pstmt.setInt(2, relevel); // 두 번째 매개변수에 relevel 값을 설정합니다.
	        pstmt.setInt(3, recnt); // 세 번째 매개변수에 recnt 값을 설정합니다.

	        return pstmt.executeUpdate(); // SQL 쿼리를 실행하고 결과를 반환합니다.
	    } catch (Exception e) {
	        e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력합니다.
	    }
	    return -1; // 실패한 경우 -1을 반환합니다.
	}
}
