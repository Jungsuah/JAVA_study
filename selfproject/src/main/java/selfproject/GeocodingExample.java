package selfproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

public class GeocodingExample {
	// Kakao Maps REST API 키
	private static final String API_KEY = "	355244203d778519e56de73861518a23";

	// 데이터베이스 연결 정보
	private static final String DB_URL = "jdbc:mysql://192.168.23.214:33060/kopo27";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "kopoctc";

	public static void main(String[] args) {
		// 데이터베이스 연결
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			// parking 테이블에서 주소를 가져와서 geocodeAndSaveAddress 메서드 실행
			fetchAddressesAndGeocode(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void fetchAddressesAndGeocode(Connection connection) throws SQLException {
		String selectQuery = "SELECT addr FROM parking";
		PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
		ResultSet resultSet = selectStatement.executeQuery();

		while (resultSet.next()) {
			String addr = resultSet.getString("addr");
			geocodeAndSaveAddress(connection, addr);
		}

		resultSet.close();
		selectStatement.close();
	}

	private static void geocodeAndSaveAddress(Connection connection, String addr) throws SQLException {
	    try {
	        // 주소 인코딩
	        String encodedAddress = URLEncoder.encode(addr, "UTF-8");

	        // Geocoding API 요청 URL 생성
	        String geocodingUrl = "https://dapi.kakao.com/v2/local/search/address.json?query=" + encodedAddress;

	        // Geocoding API 호출
	        URL url = new URL(geocodingUrl);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Authorization", "KakaoAK " + API_KEY);

	        // 응답 읽기
	        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        StringBuilder response = new StringBuilder();
	        String line;
	        while ((line = reader.readLine()) != null) {
	            response.append(line);
	        }
	        reader.close();

	        // 응답 JSON 파싱
	        JSONObject jsonResponse = new JSONObject(response.toString());
	        JSONArray documents = jsonResponse.getJSONArray("documents");

	        if (documents.length() > 0) {
	            JSONObject firstDocument = documents.getJSONObject(0);
	            String latitude = firstDocument.getString("y");
	            String longitude = firstDocument.getString("x");

	            System.out.println("latitude: " + latitude);
	            System.out.println("longitude: " + longitude);

	            // 추출한 위도(latitude)와 경도(longitude) 값을 디비에 저장하는 로직 추가
	            String updateQuery = "UPDATE parking SET latitude = ?, longitude = ? WHERE addr = ?";
	            PreparedStatement statement = connection.prepareStatement(updateQuery);
	            statement.setString(1, latitude);
	            statement.setString(2, longitude);
	            statement.setString(3, addr);
	            statement.executeUpdate();

	            System.out.println("위도와 경도를 디비에 저장했습니다.");
	        } else {
	            System.out.println("주소에 대한 위도와 경도를 검색할 수 없습니다.");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
}
