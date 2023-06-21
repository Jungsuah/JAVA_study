package daily0619_Encryption;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class P4 {
	public static void main(String[] args) {
		String name = getInput("Enter your name: ");
		String password = getInput("Enter your password: ");

		try {
			// JDBC 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root",
					"kopoctc");
			Statement stmt = conn.createStatement();

			// 암호화
			String encryptedPassword = encrypt(password);
			System.out.println("encryptedPassword : " + encryptedPassword);

			// 데이터베이스 조회
			String sql = "SELECT * FROM users WHERE name = '" + name + "' AND password = '" + encryptedPassword + "'";
			ResultSet rs = stmt.executeQuery(sql);

			// 결과 확인
			if (rs.next()) {
				System.out.println("로그인 성공!");
			} else {
				String insertQuery = "INSERT INTO users (name, password) VALUES ('" + name + "', '" + encryptedPassword
						+ "')";
				stmt.executeUpdate(insertQuery);
				System.out.println("없는 회원 정보입니다! 회원 정보를 등록합니다.");
			}

			// 자원 정리
			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getInput(String prompt) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(prompt);
		return scanner.nextLine();

	}

	private static String encrypt(String password) {
		try {
			// AES256 encryption
			String key = "ThisIsASecretKey1234567890123456";
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] encryptedData = cipher.doFinal(password.getBytes("UTF-8"));
			return Base64.encodeBase64String(encryptedData);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
