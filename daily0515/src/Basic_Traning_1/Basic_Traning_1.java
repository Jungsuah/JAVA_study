package Basic_Traning_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Basic_Traning_1 {
	public static void main(String[] args) throws ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출합니다.
		// 이 클래스는 MySQL 데이터베이스와의 연결을 수립하는 데 사용됩니다.
		// com.mysql.cj.jdbc.Driver는 MySQL Connector/J JDBC 드라이버의 클래스 이름입니다.
		// 이 드라이버는 Java와 MySQL 데이터베이스 간의 통신을 중개하고 JDBC API를 구현하는 클래스입니다.
		
		// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
		// getConnection 메서드의 인자로는 JDBC URL, mysql의 사용자 이름, mysql사용자의 비밀번호를 입력한다.
		// 이 코드에서는 jdbc:mysql://[IP 주소]:[mysql의 포트번호]/[mysql내에 접근하고 싶은 데이터베이스 이름]을 사용하여 연결한다.
		Connection k27_conn = null;
		try {
			k27_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// SQL문을 실행하기 위한 Statement 객체를 생성합니다.
		Statement k27_stmt= null;
		try {
			//conn객체에 createStatement의 메소드를 사용해 Statement 객체에 할당한다.
			k27_stmt = k27_conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();//오류발생시 오류 출력해준다
		}
		
		try {
			//cctv 테이블 생성하는 쿼리
			k27_stmt.execute("create table cctv(" +//freewifi로 테이블 생성
						"ROWNUM int not null primary key," + //고유 순번 키값 부여
						"manage_place varchar(200)," + //관리기관명
						"place_addr_road varchar(200),"+//소재지도로명주소
						"place_addr_land varchar(500),"+//소재지지번주소
						"inst_purpose varchar(50),"+//설치목적구분
						"inst_camera int,"+//카메라대수
						"inst_camera_pixel int,"+//카메라화소수
						"inst_camera_detail varchar(500),"+//촬영방면정보
						"storage_days varchar(50),"+//보관일수
						"inst_date varchar(50)," + //설치년월 
						"manage_office_phone varchar(50),"+//관리기관전화번호
						"latitude double," +//위도
						"longtitude double," +//경도
						"write_date date" +//데이터기준날짜
						")" + "DEFAULT CHARSET=utf8;");
			
			//cctv 테이블 삭제하는 쿼리
			//stmt.execute("drop table cctv;");
		} catch (SQLException e) {
			e.printStackTrace();//오류발생시 오류 출력해준다
		}
		
		try {
			// Statement 객체를 닫습니다.
			k27_stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();//오류발생시 오류 출력해준다
		}
		try {
			// Connection 객체를 닫습니다.
			k27_conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
