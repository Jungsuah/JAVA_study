package daily0329;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class test {
	public static void main(String[] args) {
		Statement statement = null;
		ResultSet resultSet = null;
		Connection conn = null;
		String id = "root";
		String password = "kopo27";
		String dbQuery = "select * from city";
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useUnicode=true&characterEncoding=utf-8&&serverRimezon=Asia/Seoul&useSSL = false",id,password);
			statement = conn.createStatement();
			
			if (statement.execute(dbQuery)) {
				resultSet = statement.getResultSet();
			}
			while (resultSet.next()) {
				for (int i = 1; i <= 3; i++) {
					String str = resultSet.getString(i);
					System.out.print(str + " ");
				}
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println("오류"+e);
		}
	}
}
