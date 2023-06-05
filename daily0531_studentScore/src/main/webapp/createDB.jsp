<%@page import="kr.ac.kopo.ctc.kopo27.domain.StudentScore"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.StudentScoreDaoImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.StudentScoreDao"%>
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
<%
String error; // 오류 메시지를 담을 변수 선언
StudentScoreDao studentScoreDao = new StudentScoreDaoImpl(); // StudentScoreDaoImpl 객체 생성
error = studentScoreDao.createTable(); // 테이블 생성 메서드 호출하여 오류 여부 확인

out.println("<h1>테이블 생성</h1>"); // 제목 출력

if (error != null) { // 오류가 발생한 경우
    out.println(error); // 오류 메시지 출력
}
%>
</body>
</html>
