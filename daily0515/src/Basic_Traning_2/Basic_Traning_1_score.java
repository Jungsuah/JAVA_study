package Basic_Traning_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Basic_Traning_1_score {
	public static void main(String[] args) throws ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출합니다.
		// 이 클래스는 MySQL 데이터베이스와의 연결을 수립하는 데 사용됩니다.
		// com.mysql.cj.jdbc.Driver는 MySQL Connector/J JDBC 드라이버의 클래스 이름입니다.
		// 이 드라이버는 Java와 MySQL 데이터베이스 간의 통신을 중개하고 JDBC API를 구현하는 클래스입니다.
		
		// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
		// getConnection 메서드의 인자로는 JDBC URL, mysql의 사용자 이름, mysql사용자의 비밀번호를 입력한다.
		// 이 코드에서는 jdbc:mysql://[IP 주소]:[mysql의 포트번호]/[mysql내에 접근하고 싶은 데이터베이스 이름]을 사용하여 연결한다.
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// SQL문을 실행하기 위한 Statement 객체를 생성합니다.
		Statement stmt= null;
		try {
			//conn객체에 createStatement의 메소드를 사용해 Statement 객체에 할당한다.
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();//오류발생시 오류 출력해준다
		}
		
		try {
			//cctv 테이블 삭제하는 쿼리
			stmt.execute("create table score(" +//freewifi로 테이블 생성
						"studentid int not null AUTO_INCREMENT primary key," + //고유 순번 키값 부여
						"name varchar(200)," + //관리기관명
						"kor int,"+//소재지도로명주소
						"eng int,"+//소재지지번주소
						"mat int"+//설치목적구분
						")" + "DEFAULT CHARSET=utf8;");
			
			//cctv 테이블 삭제하는 쿼리
			//stmt.execute("drop table cctv;");
		} catch (SQLException e) {
			e.printStackTrace();//오류발생시 오류 출력해준다
		}
		
		try {
			// Statement 객체를 닫습니다.
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();//오류발생시 오류 출력해준다
		}
		try {
			// Connection 객체를 닫습니다.
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
