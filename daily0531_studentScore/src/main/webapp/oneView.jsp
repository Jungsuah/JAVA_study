<%@page import="kr.ac.kopo.ctc.kopo27.domain.StudentScore"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.StudentScoreDaoImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.StudentScoreDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--JSP 페이지의 언어를 Java로 설정하고, 컨텐츠 타입을 HTML로 지정합니다. 
페이지 인코딩을 UTF-8로 설정하여 한글과 같은 유니코드 문자를 올바르게 처리할 수 있도록 합니다.-->
<%@ page import="java.sql.*" %>
<!--java.sql 패키지에 있는 모든 클래스를 임포트합니다.
JSP 페이지에서 JDBC(Database Connectivity)를 사용하여 데이터베이스와의 연결 및 데이터 처리를 위해 필요한 클래스들을 사용-->

<!DOCTYPE html><!-- 문서 유형을 정의 -->
<html><!-- HTML 태그의 시작-->
<head> <!-- 문서의 헤더 정보를 나타냄 -->
    <meta charset="UTF-8"> <!-- 문서의 문자 인코딩 방식을 설정 -->
    
    <script>
        function goBack() {<!-- 이번페이지로 가는 함수 -->
            history.go(-1);
        }
    </script>
    
</head>

<body> 
<%
StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
int id = Integer.parseInt(request.getParameter("id")); // 파라미터로 전달된 id 값을 가져온다
StudentScore ss = studentScoreDao.selectOne(id); // 해당 id에 해당하는 학생 정보를 조회한다
String name = ss.getName(); // 조회된 학생의 이름을 가져A온다

// 조회한 이름을 출력한다
out.println("<h1>[" + name + "]조회</h1>");
%>

<table cellspacing=1 width=600 border=0>
    <tr>
        <td width=300></td>
        <td width=500 ><button style ="margin-left:380px;" onclick="goBack()">뒤로가기</button></td>
    </tr>
</table>

<table cellspacing=1 width=600 border=1>
    <tr>
        <td width=50><p align="center">이름</p></td>
        <td width=50><p align="center">학번</p></td>
        <td width=50><p align="center">국어</p></td>
        <td width=50><p align="center">영어</p></td>
        <td width=50><p align="center">수학</p></td>
        <td width=50><p align="center">총점</p></td>
        <td width=50><p align="center">평균</p></td>
        <td width=50><p align="center">등수</p></td>
    </tr>

    <%
        while (ss != null) { // 원하는 결과값을 담은 객체에 내용이 없어질때까지 반복
            out.println("<tr>"); // tr 생성
            out.println("<td width=50><p align = center>" + ss.getName()+ "</p></td>"); // getName을 사용하여 이름 가져오기
            out.println("<td width=50><p align = center>" + ss.getStudentid()+ "</p></td>"); // getStudentid을 사용하여 학번 가져오기
            out.println("<td width=50><p align = center>" + ss.getKor()+ "</p></td>"); // getKor을 사용하여 국어 점수 가져오기
            out.println("<td width=50><p align = center>" + ss.getEng()+ "</p></td>"); // getEng을 사용하여 영어 점수 가져오기
            out.println("<td width=50><p align = center>" + ss.getMat() + "</p></td>"); // getMat을 사용하여 수학 점수 가져오기
            out.println("<td width=50><p align = center>" + ss.getSum() + "</p></td>"); // getSum을 사용하여 총점 가져오기
            out.println("<td width=50><p align = center>" + ss.getAve() + "</p></td>"); // getAve을 사용하여 평균 가져오기
            out.println("<td width=50><p align = center>" + ss.getRanking() + "</p></td>"); // getRanking을 사용하여 등수 가져오기
            out.println("</tr>");
            break;
        }
    %>
</table>

</body>
</html>