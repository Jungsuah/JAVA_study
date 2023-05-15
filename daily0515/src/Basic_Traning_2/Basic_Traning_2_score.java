package Basic_Traning_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Basic_Traning_2_score {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/database_name"; // 데이터베이스 연결 정보 입력
		String username = "your_username"; // 데이터베이스 사용자명 입력
		String password = "your_password"; // 데이터베이스 암호 입력

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			// JDBC 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 데이터베이스 연결
			connection = DriverManager.getConnection(url, username, password);

			// 성적 테이블 생성
			String createTableQuery = "CREATE TABLE score (" + "student_id INT PRIMARY KEY AUTO_INCREMENT,"
					+ "name VARCHAR(50)," + "kor INT," + "eng INT," + "mat INT" + ")";
			statement = connection.prepareStatement(createTableQuery);
			statement.executeUpdate();

			// 성적 데이터 삽입
			Random random = new Random();
			String insertQuery = "INSERT INTO score (name, kor, eng, mat) VALUES (?, ?, ?, ?)";
			statement = connection.prepareStatement(insertQuery);
			for (int i = 0; i < 1000; i++) {
				String name = "홍길동" + (i + 1);
				int kor = random.nextInt(101);
				int eng = random.nextInt(101);
				int mat = random.nextInt(101);

				statement.setString(1, name);
				statement.setInt(2, kor);
				statement.setInt(3, eng);
				statement.setInt(4, mat);

				statement.executeUpdate();
			}

			System.out.println("성적 테이블과 데이터 생성이 완료되었습니다.");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
