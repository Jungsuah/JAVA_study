package daily0516;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Advantage_5 {// 특정일자 쿼리를 가져오기
	public static void main(String[] args) throws Exception {
		// JDBC 드라이버를 적재한다.
		Class.forName("com.mysql.cj.jdbc.Driver");

		// getConnection() 메소드를 통해서 데이터베이스와 자바를 연결한다.
		Connection k27_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

		// stock 테이블에 주식 영업 일자가 20051017이고 유가증권 단축 종목코드가 삼성전자인 행을 가져오는 쿼리를 작성한다.
		String k27_QueryTxt = String.format("select * from stock where bsop_date = '20051017' and stnd_iscd = 'A005930';");
		
		// SQL문을 실행하기 위한 Statement 객체를 생성합니다.
		Statement k27_stmt = k27_conn.createStatement();

		// 만들어진 쿼리를 Statement의 executeQuery메소드의 인자로 보내어 원하는 결과값을 가져오고 
		//rset에 원하는 결과값을 할당합니다.
		ResultSet rset = k27_stmt.executeQuery(k27_QueryTxt);
		int iCnt = 0;// 읽어온 횟수 변수 선언
		
		while (rset.next()) {// 원하는 결과값을 담은 객체에 내용이 없어질때까지 반복
			System.out.printf("*(%d)***************************\n", iCnt++);// 횟수번호 출력
			System.out.printf("유가증권 단축 종목코드           : %s\n", rset.getString(1));// getString을 사용하여 1번째 칼럼값 가져오기
			System.out.printf("주식 영업 일자                : %s\n", rset.getString(1));// getString을 사용하여 1번째 칼럼값 가져오기
			System.out.printf("주식 종가                    : %s\n", rset.getString(2));// getString을 사용하여 2번째 칼럼값 가져오기
			System.out.printf("주식 시가                    : %s\n", rset.getString(3));// getString을 사용하여 3번째 칼럼값 가져오기
			System.out.printf("주식 최고가                   : %s\n", rset.getString(4));// getString을 사용하여 4번째 칼럼값 가져오기
			System.out.printf("주식 최저가                   : %s\n", rset.getString(5));// getString을 사용하여 5번째 칼럼값 가져오기
			System.out.printf("누적 거래량                   : %s\n", rset.getString(6));// getString을 사용하여 6번째 칼럼값 가져오기
			System.out.printf("누적 거래 대금                 : %s\n", rset.getString(7));// getString을 사용하여 7번째 칼럼값 가져오기
		}
		rset.close();// ResultSet 객체를 닫습니다.
		k27_stmt.close();// Statement 객체를 닫습니다.
		k27_conn.close();// Connection 객체를 닫습니다.
	}
}
