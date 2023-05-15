package daily0515;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class freewifi_3_4 {
	public static void main(String[] args) throws Exception {
		// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출합니다.
		// 이 클래스는 MySQL 데이터베이스와의 연결을 수립하는 데 사용됩니다.
		// com.mysql.cj.jdbc.Driver는 MySQL Connector/J JDBC 드라이버의 클래스 이름입니다.
		// 이 드라이버는 Java와 MySQL 데이터베이스 간의 통신을 중개하고 JDBC API를 구현하는 클래스입니다.
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
		// getConnection 메서드의 인자로는 JDBC URL, mysql의 사용자 이름, mysql사용자의 비밀번호를 입력한다.
		// 이 코드에서는 jdbc:mysql://[IP 주소]:[mysql의 포트번호]/[mysql내에 접근하고 싶은 데이터베이스 이름]을 사용하여 연결한다.
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

		// SQL문을 실행하기 위한 Statement 객체를 생성합니다.
		Statement stmt = conn.createStatement();
			
			String k27_QueryTxt;//쿼리를 담아줄 문자형 변수 선언
			
			//freewifi테이블에서 inst_country가 수원시인 행을 모두 가져오는 쿼리 작성
			k27_QueryTxt = "select * from freewifi where inst_country='수원시'" ;
			
			//만들어진 쿼리를 Statement의 executeQuery메소드의 인자로 보내어 원하는 결과값을 가져오고
			//rset에 원하는 결과값을 할당합니다.
			ResultSet rset = stmt.executeQuery(k27_QueryTxt);
			int iCnt = 0;//읽어온 횟수 변수 선언
			while (rset.next()) {//원하는 결과값을 담은 객체에 내용이 없어질때까지 반복
				System.out.printf("*(%d)***************************\n", iCnt++);//횟수번호 출력
				System.out.printf("순번                : %s\n", rset.getString(1));//getString을 사용하여 1번째 칼럼값 가져오기
				System.out.printf("설치장소명          : %s\n", rset.getString(2));//getString을 사용하여 2번째 칼럼값 가져오기
				System.out.printf("설치장소상세        : %s\n", rset.getString(3));//getString을 사용하여 3번째 칼럼값 가져오기
				System.out.printf("설치시도명          : %s\n", rset.getString(4));//getString을 사용하여 4번째 칼럼값 가져오기
				System.out.printf("설치시군구명        : %s\n", rset.getString(5));//getString을 사용하여 5번째 칼럼값 가져오기
				System.out.printf("설치시설구분        : %s\n", rset.getString(6));//getString을 사용하여 6번째 칼럼값 가져오기
				System.out.printf("서비스제공사명      : %s\n", rset.getString(7));//getString을 사용하여 7번째 칼럼값 가져오기
				System.out.printf("와이파이SSID        : %s\n", rset.getString(8));//getString을 사용하여 8번째 칼럼값 가져오기
				System.out.printf("설치년월            : %s\n", rset.getString(9));//getString을 사용하여 9번째 칼럼값 가져오기
				System.out.printf("소재지도로명주소    : %s\n", rset.getString(10));//getString을 사용하여 10번째 칼럼값 가져오기
				System.out.printf("소재지지번주소      : %s\n", rset.getString(11));//getString을 사용하여 11번째 칼럼값 가져오기
				System.out.printf("관리기관명          : %s\n", rset.getString(12));//getString을 사용하여 12번째 칼럼값 가져오기
				System.out.printf("관리기관전화번호    : %s\n", rset.getString(13));//getString을 사용하여 13번째 칼럼값 가져오기
				System.out.printf("위도               : %s\n", rset.getString(14));//getString을 사용하여 14번째 칼럼값 가져오기
				System.out.printf("경도               : %s\n", rset.getString(15));//getString을 사용하여 15번째 칼럼값 가져오기
				System.out.printf("데이터기준날짜      : %s\n", rset.getString(16));//getString을 사용하여 16번째 칼럼값 가져오기
			}
			
		rset.close();// ResultSet 객체를 닫습니다.
		stmt.close();// Statement 객체를 닫습니다.
		conn.close();// Connection 객체를 닫습니다.
	}
}





















//
//select * from freewifi where 
//		SQRT (POWER (latitude-%f,2) + POWER(longtitude-%f,2) ) = 
//		(select MIN( SQRT( POWER (latitude-%f,2) + POWER(longtitude-%f,2) )  ) from freewifi;
