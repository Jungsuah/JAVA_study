<%@page import="kr.ac.kopo.ctc.kopo27.domain.StudentScore"%>
<%@page import="kr.ac.kopo.ctc.kopo27.service.StudentScoreService"%>
<%@page import="kr.ac.kopo.ctc.kopo27.service.StudentScoreServiceImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.StudentScoreDaoImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.StudentScoreDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--JSP 페이지의 언어를 Java로 설정하고, 컨텐츠 타입을 HTML로 지정합니다. 
페이지 인코딩을 UTF-8로 설정하여 한글과 같은 유니코드 문자를 올바르게 처리할 수 있도록 합니다.-->
<%@ page import="java.sql.*" %>
<%@ page import="java.net.*" %><!--한글이 post/get의 파라미터로 연동될때는 임포트 처리가 필요하다.-->
<!--java.sql 패키지에 있는 모든 클래스를 임포트합니다.
JSP 페이지에서 JDBC(Database Connectivity)를 사용하여 데이터베이스와의 연결 및 데이터 처리를 위해 필요한 클래스들을 사용-->

<!DOCTYPE html><!-- 문서 유형을 정의 -->
<html><!-- HTML 태그의 시작-->
<head> <!-- 문서의 헤더 정보를 나타냄 -->
    <meta charset="UTF-8"> <!-- 문서의 문자 인코딩 방식을 설정 -->
</head>

<body> 
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

    String errorMessage = "";//오류를 보여주기 위한 문자열 변수 선언
    String name = "";
    int insertID = 0;
    int kor = 0;
    int eng = 0;
    int mat = 0;
    
    StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
    StudentScoreService studentScoreService = new StudentScoreServiceImpl();

    int total = studentScoreDao.count();//전체 항목 갯수 조회
    int fromPT = 0;
    StudentScore ss = new StudentScore();
    
    try{
        name = request.getParameter("name");
        kor = Integer.parseInt(request.getParameter("kor"));
        eng = Integer.parseInt(request.getParameter("eng"));
        mat = Integer.parseInt(request.getParameter("mat"));
    }catch(Exception e){
    	out.print("받아온 값이 없습니다!");
    }

    ss.setName(name);
	ss.setKor(kor);
	ss.setEng(eng);
	ss.setMat(mat);
	
	StudentScore insert = studentScoreDao.create(ss);
	
	StudentScore result = studentScoreDao.selectByName(name);
    
%>
    <h1>성적입력추가완료</h1>
        <table cellspacing=1 width=400 border=0>
            <tr>
                <td width=300></td>
                <td width=300 ><button style ="margin-left:182px;" onclick="location.href='inputForm1.html'">뒤로가기</button></td>
            </tr>
        </table>

        <table cellspacing=1 width=400 border=1>
            <tr>
                <td width=100><p align=center>이름</p></td>
                <td width=300><p align=center><%=result.getName()%></p></td>
            </tr>
            <tr>
                <td width=100><p align=center>학번</p></td>
                <td width=300><p align=center><%=result.getStudentid()%></p></td>
            </tr>
            <tr>
                <td width=100><p align=center>국어</p></td>
                <td width=300><p align=center><%=result.getKor()%></p></td>
            </tr>
            <tr>
                <td width=100><p align=center>영어</p></td>
                <td width=300><p align=center><%=result.getEng()%></p></td>
            </tr>
            <tr>
                <td width=100><p align=center>수학</p></td>
                <td width=300><p align=center><%=result.getMat()%></p></td>
            </tr>
        </table>


</body>
</html>