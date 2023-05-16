package Basic_Traning_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Basic_Traning_1_score {
	public static void main(String[] args) throws ClassNotFoundException{
		// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드 사용한다. 
		// MySQL 데이터베이스와의 연결을 수립하는 데 사용된다.
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
		Connection conn = null;
		try {
			// getConnection 메서드의 인자로는 JDBC URL, mysql의 사용자 이름, mysql사용자의 비밀번호를 입력한다.
			// 이 코드에서는 jdbc:mysql://[IP 주소]:[mysql의 포트번호]/[mysql내에 접근하고 싶은 데이터베이스 이름]을 사용하여 연결한다.
			conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
		} catch (SQLException e) {
			e.printStackTrace();//오류발생시 오류 출력해준다
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
			//score 테이블 생성하는 쿼리 작성
			stmt.execute("create table score(" +//score로 테이블 생성
						"studentid int not null primary key," + //고유 순번 키값으로 학번 사용
						"name varchar(200)," + //이름 
						"kor int,"+//국어 성적
						"eng int,"+//영어 성적
						"mat int"+//수학 성적
						")" + "DEFAULT CHARSET=utf8;");// ms949이기 때문에 utf8로 세팅을 맞춰준다.
			
			//score 테이블 삭제하는 쿼리
			//stmt.execute("drop table score;");
			
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
			e.printStackTrace();//오류발생시 오류 출력해준다
		}
	}
}
