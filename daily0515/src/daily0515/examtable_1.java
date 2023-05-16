package daily0515;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class examtable_1 {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출한다.
		// 이 클래스는 MySQL 데이터베이스와의 연결을 수립하는 데 사용됩니다.
		// com.mysql.cj.jdbc.Driver는 MySQL Connector/J JDBC 드라이버의 클래스 이름입니다.
		// 이 드라이버는 Java와 MySQL 데이터베이스 간의 통신을 중개하고 JDBC API를 구현하는 클래스입니다.
		
		Connection k27_conn = null;// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
		try {
			// getConnection 메서드의 인자로는 JDBC URL, mysql의 사용자 이름, mysql사용자의 비밀번호를 입력한다.
			// 이 코드에서는 jdbc:mysql://[IP 주소]:[mysql의 포트번호]/[mysql내에 접근하고 싶은 데이터베이스 이름]을 사용하여 연결한다.
			k27_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
		} catch (SQLException e) {
			e.printStackTrace();//오류 발생시 오류를 알려준다.
		}
		
		Statement k27_stmt = null;// SQL문을 실행하기 위한 Statement 객체를 생성합니다.
		try {
			k27_stmt = k27_conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();//오류 발생시 오류를 알려준다.
		}

		// examtable이라는 테이블을 생성하는 SQL문을 실행합니다.
		// name, studentid, kor, eng, mat 열을 가지며, studentid 열은 PRIMARY KEY로 설정됩니다.
		try {
			k27_stmt.execute("create table examtable (" + "name varchar(20)," + "studentid int not null primary key,"
					+ "kor int," + "eng int," + "mat int)" + "DEFAULT CHARSET=utf8;");
		} catch (SQLException e) {
			e.printStackTrace();//오류 발생시 오류를 알려준다.
		}

		try {
			// Statement 객체를 닫습니다.
			k27_stmt.close();//Open()한 만큼 close() 안하면 나중에 프로그램 박살된다
		} catch (SQLException e) {
			e.printStackTrace();//오류 발생시 오류를 알려준다.
		}
		try {
			// Connection 객체를 닫습니다.
			k27_conn.close();//Open()한 만큼 close() 안하면 나중에 프로그램 박살난다
		} catch (SQLException e) {
			e.printStackTrace();//오류 발생시 오류를 알려준다.
		}
	}

}
