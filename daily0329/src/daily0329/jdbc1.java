package daily0329;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		String id = "root";
		String password = "293564jnh!";
		String dbQuery = "select * from city";

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/world?useUnicode=true&characterEncoding=utf-8&serverRimezon=Asia/Seoul&useSSL = false",
					id, password);

			statement = connection.createStatement();

			if (statement.execute(dbQuery)) {
				resultSet = statement.getResultSet();
			}
			while (resultSet.next()) {

				String str1 = resultSet.getString(1);
				String str2 = resultSet.getString(2);
				System.out.println(str1);
				System.out.println(str2);
			}

		} catch (Exception e) {
			System.out.println("오류" + e);
		}

	}

}
