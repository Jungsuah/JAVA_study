package Basic_Traning_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Basic_Traning_2_score {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/database_name"; // �����ͺ��̽� ���� ���� �Է�
		String username = "your_username"; // �����ͺ��̽� ����ڸ� �Է�
		String password = "your_password"; // �����ͺ��̽� ��ȣ �Է�

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			// JDBC ����̹� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver");

			// �����ͺ��̽� ����
			connection = DriverManager.getConnection(url, username, password);

			// ���� ���̺� ����
			String createTableQuery = "CREATE TABLE score (" + "student_id INT PRIMARY KEY AUTO_INCREMENT,"
					+ "name VARCHAR(50)," + "kor INT," + "eng INT," + "mat INT" + ")";
			statement = connection.prepareStatement(createTableQuery);
			statement.executeUpdate();

			// ���� ������ ����
			Random random = new Random();
			String insertQuery = "INSERT INTO score (name, kor, eng, mat) VALUES (?, ?, ?, ?)";
			statement = connection.prepareStatement(insertQuery);
			for (int i = 0; i < 1000; i++) {
				String name = "ȫ�浿" + (i + 1);
				int kor = random.nextInt(101);
				int eng = random.nextInt(101);
				int mat = random.nextInt(101);

				statement.setString(1, name);
				statement.setInt(2, kor);
				statement.setInt(3, eng);
				statement.setInt(4, mat);

				statement.executeUpdate();
			}

			System.out.println("���� ���̺�� ������ ������ �Ϸ�Ǿ����ϴ�.");
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
