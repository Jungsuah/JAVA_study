<%@ page import="java.sql.*, org.json.JSONArray, org.json.JSONObject" %>
<%@ page contentType="application/json; charset=UTF-8" %>
<%
    // Database connection details
    String url = "jdbc:mysql://localhost:33060/kopo27";
    String username = "root";
    String password = "kopoctc";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        // Establish database connection
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, password);

        // Fetch parking data
        String query = "SELECT * FROM parking";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);

        JSONArray parkingData = new JSONArray();

        while (rs.next()) {
            JSONObject place = new JSONObject();
            place.put("name", rs.getString("name"));
            place.put("latitude", rs.getDouble("latitude"));
            place.put("longitude", rs.getDouble("longitude"));
            parkingData.put(place);
        }

        // Close database resources
        rs.close();
        stmt.close();
        conn.close();

        // Set response content type
        response.setContentType("application/json");

        // Send JSON response
        response.getWriter().print(parkingData.toString());

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Close database resources in case of any exceptions
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }
%>
