package Basic_Traning_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class Basic_Traning_2_score {
	public static void main(String[] args) {
		try {
			// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출합니다.
			// 이 클래스는 MySQL 데이터베이스와의 연결을 수립하는 데 사용됩니다.
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();//오류발생시 오류 출력해준다
		}

		// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
		Connection k27_conn = null;
		try {
			// getConnection 메서드의 인자로는 JDBC URL, mysql의 사용자 이름, mysql사용자의 비밀번호를 입력한다.
			// 이 코드에서는 jdbc:mysql://[IP 주소]:[mysql의 포트번호]/[mysql내에 접근하고 싶은 데이터베이스 이름]을 사용하여 연결
			k27_conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root", "kopo27");
		} catch (SQLException e) {
			e.printStackTrace();//오류발생시 오류 출력해준다
		}

		// SQL문을 실행하기 위한 Statement 객체를 생성합니다.
		Statement k27_stmt = null;
		try {
			// conn객체에 createStatement의 메소드를 사용해 Statement 객체에 할당한다.
			k27_stmt = k27_conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();// 오류발생시 오류 출력해준다
		}
		for (int i = 0; i < 1000; i++) {//i가 0부터 999까지 반복하는 반복문
			String k27_QueryTxt;// 쿼리를 담아줄 문자형 변수 선언

			// 삽입하는 insert문을 작성해서 칼럼에 맞춰서 데이터 삽입한다.
			//studentid와 name에 i를 매칭시켜 insert하는 값에 변화를 준다.
			// kor,eng,mat -> 랜덤으로 0부터 100까지 값을 넣어준다.
			k27_QueryTxt = String.format("insert into score values (%d, '홍길%03d',rand()*100,rand()*100,rand()*100);", i,i);

			try {
				// Statement객체에 execute 메소드를 통해 만들어진 쿼리문을 전달한다.
				k27_stmt.execute(k27_QueryTxt);
			} catch (SQLException e) {
				e.printStackTrace();//오류발생시 오류 출력해준다
			}
		}
	}
}
