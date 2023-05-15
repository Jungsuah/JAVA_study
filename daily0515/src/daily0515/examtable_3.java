package daily0515;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class examtable_3 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출합니다.
		// 이 클래스는 MySQL 데이터베이스와의 연결을 수립하는 데 사용됩니다.
		// com.mysql.cj.jdbc.Driver는 MySQL Connector/J JDBC 드라이버의 클래스 이름입니다.
		// 이 드라이버는 Java와 MySQL 데이터베이스 간의 통신을 중개하고 JDBC API를 구현하는 클래스입니다.
		
		// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
		// getConnection 메서드의 인자로는 JDBC URL, mysql의 사용자 이름, mysql사용자의 비밀번호를 입력한다.
		// 이 코드에서는 jdbc:mysql://[IP 주소]:[mysql의 포트번호]/[mysql내에 접근하고 싶은 데이터베이스 이름]을 사용하여 연결한다.
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");

		// Statement 객체를 생성합니다.
		Statement stmt = conn.createStatement();

		// SQL 쿼리문을 실행하기 위해 execute 메서드를 호출합니다.
		// 이 코드에서는 "insert into values" 쿼리를 실행하여 examtable에 값을 넣어줍니다.
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('효민', 209901,  95, 100,  95);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('보람', 209902,  95, 95,  95);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('은정', 209903,  100, 100,  100);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('지연', 209904,  100, 95,  90);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('소연', 209905,  80, 100,  70);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('큐리', 209906,  100, 100,  70);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('화영', 209907,  70, 70,  70);");
		
		stmt.close();// Statement 객체를 닫습니다.
		conn.close();// Connection 객체를 닫습니다.
	}
}
