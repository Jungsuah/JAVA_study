package selfproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class AddressConverter {
	// MySQL 데이터베이스와의 연결
    private static final String DB_URL = "jdbc:mysql://192.168.23.214:33060/kopo27";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "kopoctc";
    private static final String KAKAO_MAP_API_KEY = "355244203d778519e56de73861518a23";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // 데이터베이스 연결
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            
            // 주소 목록 가져오기
            List<AddressData> addresses = getAddressesFromDatabase(connection);
            
            // 주소별로 위도 경도 좌표 변환 및 데이터베이스 업데이트
            for (AddressData addressData : addresses) {
                String address = addressData.getAddress();
                LatLng coordinates = convertAddressToCoordinates(address);
                if (coordinates != null) {
                    updateCoordinatesInDatabase(connection, addressData.getId(), coordinates.getLatitude(), coordinates.getLongitude());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 연결 종료
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static List<AddressData> getAddressesFromDatabase(Connection connection) throws SQLException {
        List<AddressData> addresses = new ArrayList<>();
        String selectQuery = "SELECT id, addr FROM parking";

        try (PreparedStatement statement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String address = resultSet.getString("addr");
                addresses.add(new AddressData(id, address));
            }
        }

        System.out.println(addresses.toString());
        return addresses;
    }

    private static LatLng convertAddressToCoordinates(String address) {
        OkHttpClient client = new OkHttpClient();
        String encodedAddress = urlEncode(address);
        String url = "https://dapi.kakao.com/v2/local/search/address.json?query=" + encodedAddress;

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "KakaoAK " + KAKAO_MAP_API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            JSONObject jsonObject = new JSONObject(responseBody);
            JSONArray documents = jsonObject.getJSONArray("documents");

            if (documents.length() > 0) {
                JSONObject firstResult = documents.getJSONObject(0);
                double latitude = firstResult.getDouble("y");
                double longitude = firstResult.getDouble("x");
                return new LatLng(latitude, longitude);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static void updateCoordinatesInDatabase(Connection connection, int id, double latitude, double longitude) throws SQLException {
        String updateQuery = "UPDATE parking SET latitude = ?, longitude = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setDouble(1, latitude);
            statement.setDouble(2, longitude);
            statement.setInt(3, id);
            statement.executeUpdate();
        }
    }

    private static String urlEncode(String value) {
        try {
            return java.net.URLEncoder.encode(value, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    private static class AddressData {
        private int id;
        private String addr;

        public AddressData(int id, String address) {
            this.id = id;
            this.addr = address;
        }

        public int getId() {
            return id;
        }

        public String getAddress() {
            return addr;
        }
    }

    private static class LatLng {
        private double latitude;
        private double longitude;

        public LatLng(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }
    }
}

