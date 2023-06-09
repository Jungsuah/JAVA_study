package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import domain.Stock;

public class StockDaoImpl implements StockDao {

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
			// Stock이라는 테이블을 생성하는 SQL문을 실행합니다.
			stmt.execute("CREATE TABLE Stock (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
				    "name VARCHAR(70), " +
				    "inventory INT, " +
				    "checkdate DATE, " +
				    "date DATE, " +
				    "content TEXT, " +
				    "url TEXT" +
				    ") " +
				    "DEFAULT CHARSET=utf8;");
				    
				List<String> nameList = Arrays.asList("바나나", "따알기", "사아과", "배애애", "참외애");

				for (int i = 1; i <= 60; i++) {
				    for (String fruit : nameList) {
				        String name = fruit;
				        int inventory = i;
				        java.sql.Date checkdate = new java.sql.Date(System.currentTimeMillis());
				        java.sql.Date date = java.sql.Date.valueOf("2017-01-01");
				        String content = name + "은 맛있어요!";
				        String url = "./image/no_image.png";
				        
				        String insertQuery = "INSERT INTO Stock (name, inventory, checkdate, date, content, url) VALUES ('" + name + "', '" + inventory
			                    + "', '" + checkdate + "', '" + date + "', '" + content + "', '" + url + "')";

				        stmt.executeUpdate(insertQuery);
				    }
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
	public List<Stock> selectAllStock() {
		System.out.println("===> Stock과 연결 시작!");// 확인용 출력구문

		// StudentScore 객체들의 리스트를 담기위한 리스트 선언 및 초기화
		List<Stock> StockList = new ArrayList<Stock>();
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");

			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();

			// 쿼리 결과값을 담을 ResultSet 객체를 생성합니다.
			// examtable에서 페이지의 첫번째 시작 인덱스부터 한페이지에 출력할 갯수 만큼 쿼리로 범위를 설정해서 가져오기
			rset = stmt.executeQuery("SELECT * FROM Stock ORDER BY id DESC;");

			while (rset.next()) {
				// 새로운 StudentScore 객체를 생성합니다.
				Stock Stock = new Stock();

				// ResultSet에서 각 컬럼의 값을 가져와서 Stock 객체에 설정합니다.
				Stock.setId(rset.getInt("id")); // id 컬럼 값 설정
				Stock.setName(rset.getString("name")); // title 컬럼 값 설정
				Stock.setInventory(rset.getInt("inventory")); // date 컬럼 값 설정
				Stock.setCheckdate(rset.getString("checkdate")); // content 컬럼 값 설정
				Stock.setDate(rset.getString("date")); // content 컬럼 값 설정
				Stock.setContent(rset.getString("content")); // content 컬럼 값 설정

				// Stock 객체를 StockList에 추가합니다.
				StockList.add(Stock);
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}
		return StockList;// StockList 객체들의 리스트를 반환
	}

	@Override
	public Stock selectOneStock(int id) {
		Stock Stock = null;// studentScore 객체 선언 및 초기화
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
			rset = stmt.executeQuery("SELECT * FROM Stock WHERE id = " + id + ";");

			while (rset.next()) {// rset에 받아온 값이 없을때까지 반복하면서 값 꺼내기
				Stock = new Stock();// 반복문이 돌때마다 객체를 초기화 시켜주기 위해서 새로운 객체 선언
				Stock.setId(rset.getInt("id")); // id 컬럼 값 설정
				Stock.setName(rset.getString("name")); // title 컬럼 값 설정
				Stock.setInventory(rset.getInt("inventory")); // date 컬럼 값 설정
				Stock.setCheckdate(rset.getString("checkdate")); // content 컬럼 값 설정
				Stock.setDate(rset.getString("date")); // content 컬럼 값 설정
				Stock.setContent(rset.getString("content")); // content 컬럼 값 설정
				Stock.setUrl(rset.getString("url")); // content 컬럼 값 설정
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}
		return Stock;// id값으로 조회한 학생 점수 데이터 반환
	}

	@Override
	public int deleteOneStock(int id) {
		int result = -1;
		try {
			// JDBC 드라이버 클래스를 동적으로 로드합니다.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");

			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();

			// DELETE 문을 실행하여 주어진 id에 해당하는 데이터를 삭제합니다.
			String sql = "DELETE FROM Stock WHERE id = " + id;
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
	public int updateStock(Stock stock) {
		int result = -1;// 업데이트된 객체를 반환하기위해 StudentScore 객체 선언
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");

			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();
			
			int stockId = stock.getId();
			String stockName = stock.getName();
			int stockInventory = stock.getInventory();
			String stockContent = stock.getContent();
			String stockUrl = stock.getUrl();

			// SQL 쿼리문을 실행하기 위해 executeUpdate 메서드를 호출합니다.
			// 현재시간을 사용하려면 NOW() 함수를 사용
			String updateQuery = "UPDATE Stock SET name = '" + stockName + "', " +
					"inventory = " + stockInventory + ", " +
					"date = NOW(), " +
					"content = '" + stockContent + "', " +
					"url = '" + stockUrl + "' WHERE id = " + stockId;

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
	public int insertStock(Stock stock) {
		int result = -1;
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");

			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();
			
			int id = stock.getId();
			String name = stock.getName();
			int inventory = stock.getInventory();
			String content = stock.getContent();
			String url = stock.getUrl();

			// INSERT 쿼리를 사용하여 변수를 추가
			String sql = "INSERT INTO Stock (id, name, inventory, checkdate, date, content, url) VALUES (" + id + ", '" + name + "', " + inventory + ", NOW(), NOW(), '" + content + "', '" + url + "')";

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
	public Stock newStock() {
		Stock Stock = null;
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");
			
			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();
			
			// INSERT 쿼리를 사용하여 비어있는 학번자리에 객체 추가
			rset = stmt.executeQuery("SELECT * FROM Stock ORDER BY id DESC LIMIT 1;");
			
			while (rset.next()) {
				// 새로운 Stock 객체를 생성합니다.
				Stock = new Stock();

				// ResultSet에서 각 컬럼의 값을 가져와서 Stock 객체에 설정합니다.
				Stock.setId(rset.getInt("id")); // id 컬럼 값 설정
				Stock.setName(rset.getString("name")); // title 컬럼 값 설정
				Stock.setInventory(rset.getInt("inventory")); // date 컬럼 값 설정
				Stock.setCheckdate(rset.getString("checkdate")); // content 컬럼 값 설정
				Stock.setDate(rset.getString("date")); // content 컬럼 값 설정
				Stock.setContent(rset.getString("content")); // content 컬럼 값 설정
				Stock.setUrl(rset.getString("url")); // content 컬럼 값 설정
			}
			
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기
			
		} catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}
		return Stock;// 삽입한 studentScore 객체를 반환한다.
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
			// Stock에서 전체 행 갯수를 조회하는 쿼리
			rset = stmt.executeQuery("SELECT count(*) FROM Stock;");

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
	public List<Stock> selectAll(int pageNum, int countPerPage) {
		System.out.println("===> Stock과 연결 시작!");// 확인용 출력구문

		int rstart = (pageNum - 1) * countPerPage;// 출력하고 싶은 페이지의 첫번째 데이터 인덱스 구하기

		// StudentScore 객체들의 리스트를 담기위한 리스트 선언 및 초기화
		List<Stock> StockList = new ArrayList<Stock>();
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
			// MySQL 데이터베이스와의 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

			// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopoctc");

			// Statement 객체를 생성합니다.
			stmt = conn.createStatement();

			// 쿼리 결과값을 담을 ResultSet 객체를 생성합니다.
			// Stock에서 페이지의 첫번째 시작 인덱스부터 한페이지에 출력할 갯수 만큼 쿼리로 범위를 설정해서 가져오기
			rset = stmt
					.executeQuery("SELECT * FROM Stock ORDER BY id DESC LIMIT " + rstart + "," + countPerPage + ";");

			while (rset.next()) {
				// 새로운 Stock 객체를 생성합니다.
				Stock Stock = new Stock();

				// ResultSet에서 각 컬럼의 값을 가져와서 Stock 객체에 설정합니다.
				Stock.setId(rset.getInt("id")); // id 컬럼 값 설정
				Stock.setName(rset.getString("name")); // title 컬럼 값 설정
				Stock.setInventory(rset.getInt("inventory")); // date 컬럼 값 설정
				Stock.setCheckdate(rset.getString("checkdate")); // content 컬럼 값 설정
				Stock.setDate(rset.getString("date")); // content 컬럼 값 설정
				Stock.setContent(rset.getString("content")); // content 컬럼 값 설정
				Stock.setUrl(rset.getString("url")); // content 컬럼 값 설정
				
				// Stock 객체를 StockList에 추가합니다.
				StockList.add(Stock);
			}

			rset.close();// 사용한 ResultSet 객체 닫기
			stmt.close();// 사용한 Statement 객체 닫기
			conn.close();// 사용한 Connection 객체 닫기

		} catch (Exception e) {// 오류가 발생하면
			e.printStackTrace();// 오류를 출력
		}
		return StockList;// StockList 객체들의 리스트를 반환
	}

}
