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
    request.setCharacterEncoding("UTF-8"); // 요청의 문자 인코딩 설정
    response.setCharacterEncoding("UTF-8"); // 응답의 문자 인코딩 설정

    String errorMessage = ""; // 오류를 보여주기 위한 문자열 변수 선언
    String name = ""; // 이름 변수 초기화
    int insertID = 0; // 학번 변수 초기화
    int kor = 0; // 국어 점수 변수 초기화
    int eng = 0; // 영어 점수 변수 초기화
    int mat = 0; // 수학 점수 변수 초기화
    
    StudentScoreDao studentScoreDao = new StudentScoreDaoImpl(); // 학생 성적 DAO 인스턴스 생성
    StudentScoreService studentScoreService = new StudentScoreServiceImpl(); // 학생 성적 서비스 인스턴스 생성

    int total = studentScoreDao.count(); // 전체 항목 개수 조회
    int fromPT = 0; // 페이지 시작 인덱스 초기화
    StudentScore ss = new StudentScore(); // 학생 성적 객체 생성
    
    try {
        name = request.getParameter("name"); // 이름 파라미터 받아오기
        kor = Integer.parseInt(request.getParameter("kor")); // 국어 점수 파라미터 받아오기
        eng = Integer.parseInt(request.getParameter("eng")); // 영어 점수 파라미터 받아오기
        mat = Integer.parseInt(request.getParameter("mat")); // 수학 점수 파라미터 받아오기
    } catch (Exception e) {
        out.print("받아온 값이 없습니다!"); // 값이 없을 경우 오류 메시지 출력
    }

    ss.setName(name); // 학생 성적 객체에 이름 설정
    ss.setKor(kor); // 학생 성적 객체에 국어 점수 설정
    ss.setEng(eng); // 학생 성적 객체에 영어 점수 설정
    ss.setMat(mat); // 학생 성적 객체에 수학 점수 설정
    
    StudentScore insert = studentScoreDao.create(ss); // 학생 성적 추가
    
    StudentScore result = studentScoreDao.selectByName(name); // 이름으로 학생 성적 조회
    try {
        name = result.getName(); // 조회 결과의 이름 가져오기
        kor = result.getKor(); // 조회 결과의 국어 점수 가져오기
        eng = result.getEng(); // 조회 결과의 영어 점수 가져오기
        mat = result.getMat(); // 조회 결과의 수학 점수 가져오기
        insertID = result.getStudentid();
    } catch (Exception e) {
    }
%>

    <h1>성적입력추가완료</h1> <!-- 성적 입력 추가 완료 메시지 출력 -->

<table cellspacing=1 width=400 border=0>
    <tr>
        <td width=300></td>
        <td width=300><button style="margin-left:182px;" onclick="location.href='inputForm1.html'">뒤로가기</button></td>
        <!-- 뒤로가기 버튼 -->
    </tr>
</table>

<table cellspacing=1 width=400 border=1>
    <tr>
        <td width=100><p align=center>이름</p></td> <!-- 이름 출력 -->
        <td width=300><p align=center><%=name%></p></td> <!-- 이름 값 출력 -->
    </tr>
    <tr>
        <td width=100><p align=center>학번</p></td> <!-- 학번 출력 -->
        <td width=300><p align=center><%=insertID%></p></td> <!-- 학번 값 출력 -->
    </tr>
    <tr>
        <td width=100><p align=center>국어</p></td> <!-- 국어 출력 -->
        <td width=300><p align=center><%=kor%></p></td> <!-- 국어 값 출력 -->
    </tr>
    <tr>
        <td width=100><p align=center>영어</p></td> <!-- 영어 출력 -->
        <td width=300><p align=center><%=eng%></p></td> <!-- 영어 값 출력 -->
    </tr>
    <tr>
        <td width=100><p align=center>수학</p></td> <!-- 수학 출력 -->
        <td width=300><p align=center><%=mat%></p></td> <!-- 수학 값 출력 -->
    </tr>
</table>

</body>
</html>