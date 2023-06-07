<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*,java.net.*" %>

<%

// "com.mysql.cj.jdbc.Driver" 클래스를 동적으로 로드하기 위해 Java의 Class.forName 메서드를 호출하여
// MySQL 데이터베이스와의 연결
Class.forName("com.mysql.cj.jdbc.Driver");

// MySQL 데이터베이스에 연결하기 위한 Connection 객체를 생성합니다.
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:33060/kopo27", "root", "kopoctc");

// Statement 객체를 생성합니다.
Statement stmt = conn.createStatement();

// 쿼리 결과값을 담을 ResultSet 객체를 생성합니다.
// examtable에서 전체 행 개수를 조회하는 쿼리
ResultSet rset = stmt.executeQuery("SELECT * FROM examtable;");

out.println("<datas>");
while (rset.next()) {
    out.println("<data>");
    
    out.println("<name>" + rset.getString(2) + "</name>"); // "name" 태그에 데이터베이스 결과값 출력
    out.println("<studentid>" + rset.getString(3) + "</studentid>"); // "studentid" 태그에 데이터베이스 결과값 출력
    out.println("<kor>" + rset.getString(4) + "</kor>"); // "kor" 태그에 데이터베이스 결과값 출력
    out.println("<eng>" + rset.getString(5) + "</eng>"); // "eng" 태그에 데이터베이스 결과값 출력
    out.println("<mat>" + rset.getString(6) + "</mat>"); // "mat" 태그에 데이터베이스 결과값 출력
    
    out.println("</data>");
}
out.println("</datas>");

stmt.close(); // 사용한 Statement 객체 닫기
conn.close(); // 사용한 ResultSet 객체 닫기

%>
