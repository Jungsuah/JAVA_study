<%@page import="kr.ac.kopo.ctc.kopo27.dao.StudentScoreDaoImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.StudentScoreDao"%>
<%@page import="kr.ac.kopo.ctc.kopo27.service.StudentScoreServiceImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo27.service.StudentScoreService"%>
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
</head>

<body> 

<%
    StudentScoreDao studentScoreDao = new StudentScoreDaoImpl(); // StudentScoreDao 인터페이스의 구현체인 StudentScoreDaoImpl 객체를 생성합니다.
    String error = studentScoreDao.insertAll(); // 데이터를 삽입하는 insertAll() 메소드를 호출하여 반환된 결과를 error 변수에 저장합니다.
    
    out.println("<h1>데이터 삽입</h1>"); // 웹 페이지에 "데이터 삽입"이라는 제목을 출력합니다.
	
    if(error != null){ // error 변수에 값이 null이 아닌 경우
    	out.println(error); // 에러 메시지를 웹 페이지에 출력합니다.
    }
%>

</body>
</html>