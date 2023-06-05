<%@page import="kr.ac.kopo.ctc.kopo27.dao.StudentScoreDao"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.StudentScoreDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--JSP 페이지의 언어를 Java로 설정하고, 컨텐츠 타입을 HTML로 지정합니다. 
페이지 인코딩을 UTF-8로 설정하여 한글과 같은 유니코드 문자를 올바르게 처리할 수 있도록 합니다.-->
<%@ page import="java.io.*" %>
<%@ page import="java.net.*" %><!--한글이 post/get의 파라미터로 연동될때는 임포트 처리가 필요하다.-->
<!--java.sql 패키지에 있는 모든 클래스를 임포트합니다.
JSP 페이지에서 JDBC(Database Connectivity)를 사용하여 데이터베이스와의 연결 및 데이터 처리를 위해 필요한 클래스들을 사용-->

<!DOCTYPE html> <!-- 문서 유형을 정의 -->
<html lang="en"> <!-- 언어와 함께 HTML 태그의 시작을 나타냄 -->

<head> <!-- 문서의 헤더 정보를 나타냄 -->
    <meta charset="UTF-8"> <!-- 문서의 문자 인코딩 방식을 설정 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge"> <!-- 렌더링 엔진을 지정 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 모바일 장치의 화면 크기에 따라 화면 비율을 조정하기 위한 메타 태그 -->
    <title>intro.html</title> <!-- 문서의 제목을 설정 -->
</head>
<body>
<h1>JSP Database 실습 1</h1> <!-- 첫 화면에서 result라는 name의 iframe에 보여질 처음 문자 설정 -->

<%	
    StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
    int cnt = studentScoreDao.peopleCount(); // 홈페이지 방문조회수 조회
    cnt++; // 방문조회수 증가
    out.println("<br><br>현재 홈페이지 방문조회수는 ["+cnt+"] 입니다</br>"); // 방문조회수 출력
   
    int updatecnt = studentScoreDao.updatePeopleCount(cnt); // 방문조회수 업데이트
%>

</body>
</html>