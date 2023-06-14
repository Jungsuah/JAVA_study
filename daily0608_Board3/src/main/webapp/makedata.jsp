<%@page import="dao.GongjiDaoImpl"%>
<%@page import="dao.GongjiDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- JSP 페이지의 언어를 Java로 설정하고, 컨텐츠 타입을 HTML로 지정합니다.
페이지 인코딩을 UTF-8로 설정하여 한글과 같은 유니코드 문자를 올바르게 처리할 수 있도록 합니다. -->
<%@ page import="java.sql.*" %>
<!-- java.sql 패키지에 있는 모든 클래스를 임포트합니다.
JSP 페이지에서 JDBC(Database Connectivity)를 사용하여 데이터베이스와의 연결 및 데이터 처리를 위해 필요한 클래스들을 사용 -->

<!DOCTYPE html><!-- 문서 유형을 정의 -->
<html><!-- HTML 태그의 시작-->
<head> <!-- 문서의 헤더 정보를 나타냄 -->
    <meta charset="UTF-8"> <!-- 문서의 문자 인코딩 방식을 설정 -->
    <title>테이블 생성 예제</title><!-- 문서의 제목을 설정 -->
</head>
<body>
<h1>Make Table</h1>
<%
Class.forName("com.mysql.cj.jdbc.Driver");

// getConnection 메서드의 인자로는 JDBC URL, mysql의 사용자 이름, mysql사용자의 비밀번호를 입력한다.
Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.23.214:33060/kopo27", "root",
		"kopoctc");

// Statement 객체를 생성합니다.
Statement stmt = conn.createStatement();
%>
<%
try{
	stmt.execute("drop table gongji");
	out.println("gongji 테이블이 있어서 삭제합니다.<br>");
}catch(Exception e){
	out.println("gongji 테이블이 있어서 삭제에 실패했습니다.<br>");
	out.println(e.toString());
}
%>
<%
GongjiDao gongjiDao = new GongjiDaoImpl(); // GongjiDaoImpl 객체 생성
int result = gongjiDao.makeData(); // 테이블 생성 메서드 호출하여 오류 여부 확인

if (result == -1) { // 오류가 발생한 경우
    out.println("<h1>테이블 생성 실패</h1>"); // 오류 메시지 출력
} else if (result == 1) {
    out.println("<h1>테이블 생성 완료</h1>"); // 제목 출력
    out.println("<table>");
    out.println("<tr>");
    out.println("<td><input type=\"button\" value=\"공지 목록 보러가기\" onclick=\"window.location='gongji_list.jsp'\" /></td>");
    out.println("</tr>");
    out.println("</table>");
}
%>
</body>
</html>
