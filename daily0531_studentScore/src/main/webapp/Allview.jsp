<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="kr.ac.kopo.ctc.kopo27.domain.StudentScore"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.StudentScoreDao"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.StudentScoreDaoImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dto.Pagination"%>
<%@page import="kr.ac.kopo.ctc.kopo27.service.StudentScoreServiceImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo27.service.StudentScoreService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--JSP 페이지의 언어를 Java로 설정하고, 컨텐츠 타입을 HTML로 지정합니다. 
페이지 인코딩을 UTF-8로 설정하여 한글과 같은 유니코드 문자를 올바르게 처리할 수 있도록 합니다.-->

<!DOCTYPE html><!-- 문서 유형을 정의 -->
<html><!-- HTML 태그의 시작-->
<head> <!-- 문서의 헤더 정보를 나타냄 -->
    <meta charset="UTF-8"> <!-- 문서의 문자 인코딩 방식을 설정 -->
</head>

<body> 
<%
StudentScoreService studentScoreService = new StudentScoreServiceImpl(); // StudentScoreService 인터페이스의 구현체인 StudentScoreServiceImpl 객체를 생성합니다.
StudentScoreDao studentScoreDao = new StudentScoreDaoImpl(); // StudentScoreDao 인터페이스의 구현체인 StudentScoreDaoImpl 객체를 생성합니다.
int total = 0; // 전체 데이터 수를 저장할 변수를 초기화합니다.

int pageNumber = 1; // 페이지 번호를 1로 초기화합니다.
int cntPT = 10; // 한 페이지에 출력할 항목 수를 10으로 초기화합니다.
int searchStudentID = 0; // 검색할 학생 ID를 0으로 초기화합니다.

try {
    searchStudentID = Integer.parseInt(request.getParameter("searchStudentID")); // request 객체에서 "searchStudentID" 파라미터를 가져와서 정수형으로 변환합니다.
} catch (Exception e) {
}

try {
    pageNumber = Integer.parseInt(request.getParameter("pageNumber")); // request 객체에서 "pageNumber" 파라미터를 가져와서 정수형으로 변환합니다.
} catch (Exception e) {
}

try {
    cntPT = Integer.parseInt(request.getParameter("cntPT")); // request 객체에서 "cntPT" 파라미터를 가져와서 정수형으로 변환합니다.
} catch (Exception e) {
}

Pagination pagination = studentScoreService.getPagination(pageNumber, cntPT); // 페이지네이션 정보를 가져옵니다.

String errorMessage = ""; // 오류 메시지를 저장할 문자열 변수를 선언합니다.
int k27_LineCnt = 0; // 라인 횟수를 셀 수 있는 숫자형 변수를 선언합니다.
int c = pagination.getC(); // 현재 페이지를 가져옵니다.
int s =  pagination.getS(); // 시작 버튼 번호를 가져옵니다.
int e = pagination.getE(); // 마지막 버튼 번호를 가져옵니다.
int p = pagination.getP(); // < 버튼을 가져옵니다.
int pp = pagination.getPp(); // << 버튼을 가져옵니다.
int n = pagination.getN(); // > 버튼을 가져옵니다.
int nn = pagination.getNn(); // >> 버튼을 가져옵니다.
int fromPT = (c - 1) * cntPT; // 시작 위치를 계산합니다.

List<StudentScore> studentScoreList = studentScoreDao.selectAll(c, cntPT); // 현재 페이지에 해당하는 학생 점수 목록을 가져옵니다.

String table = "examtable"; // 테이블 이름을 지정합니다.

boolean isTableExist = studentScoreDao.isTableExists(table); // 테이블의 존재 여부를 확인합니다.

if (!isTableExist) {
    out.println("<h1>테이블이 생성되어 있지 않습니다!</h1>"); // 테이블이 생성되어 있지 않은 경우 에러 메시지를 출력합니다.
} else {
    total = studentScoreDao.count(); // 전체 데이터 수를 계산합니다.
    if (total == 0) {
        out.println("<h1>테이블에 데이터가 없습니다!</h1>"); // 데이터가 없는 경우 에러 메시지를 출력합니다.
    } else {
       
%>

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
    for (StudentScore studentScore : studentScoreList) {// 현재 페이지에 해당하는 학생 점수 목록을 foreach를 사용하여 하나씩 읽는다.	
        if (studentScore.getStudentid() == searchStudentID) { // 결과셋의 학번과 파라미터로 받아온 학번이 같으면
            out.println("<tr style=\"background-color: yellow;\">"); // 해당 테이블 행에 노란 배경
        } else {
            out.println("<tr>");//테이블의 데이터 행 시작
        } 
        out.println("<td><p align=center><p align=center><a href=\"oneView.jsp?id=" + studentScore.getId() + "\" target=\"result\">" + studentScore.getName() + "</p></td>"); // 학생의 이름을 출력하고, 해당 학생의 상세 정보를 보여주는 링크를 생성합니다.
        out.println("<td><p align=center>" + studentScore.getStudentid() + "</p></td>"); // 학생의 학번을 출력합니다.
        out.println("<td><p align=right>" + studentScore.getKor() + "</p></td>"); // 국어 점수를 출력합니다.
        out.println("<td><p align=right>" + studentScore.getEng() + "</p></td>"); // 영어 점수를 출력합니다.
        out.println("<td><p align=right>" + studentScore.getMat() + "</p></td>"); // 수학 점수를 출력합니다.
        out.println("<td><p align=center>" + studentScore.getSum() + "</p></td>"); // 총점을 출력합니다.
        out.println("<td><p align=center>" + studentScore.getAve() + "</p></td>"); // 평균을 출력합니다.
        out.println("<td><p align=center>" + studentScore.getRanking() + "</p></td>"); // 등수를 출력합니다.
        out.println("</tr>");//테이블의 데이터 행 끝
    }

    out.println("<h1>조회</h1>"); // 값을 보여주고 조회를 띄워줍니다.
    %>
</table>


        <!--버튼을 출력하기 위한 div 생성-->
        <div style ="text-align:left; font-weight: bold; font-size : 20pt;  margin-left:150px;">
                    <%if(pp != -1){ %> <!--pp값이 -1이면 보이지 않게 처리-->
                        <a href="Allview.jsp?pageNumber=<%= pp %>&cntPT=<%= cntPT %>&searchStudentID=<%=searchStudentID %>"><<</a><span></span> <!--무조건 1페이지로 이동하는 버튼-->
                        <!--p값을 통해 이전 10블록전으로 이동하는 버튼 출력 -->
                        <a href="Allview.jsp?pageNumber=<%= p %>&cntPT=<%= cntPT %>&searchStudentID=<%=searchStudentID %>"><</a>
                    <% } %>
                    
                        <%for (int index = s; index < e + 1; index++) {%>
                            <!--만약 시작번호 부터 끝 번호까지 버튼을 출력하기-->
                            <% if (index == c) {%> <!--만약 번호가 현재 페이지와 같다면 빨간색으로 출력하기-->
                            <a href="Allview.jsp?pageNumber=<%= index %>&cntPT=<%= cntPT %>&searchStudentID=<%=searchStudentID %>" style="color: red"><%= index %></a><span></span>
                            <%} else {%><!-- 현재 페이지와 같은 버튼이 아니라면 스타일 없이 버튼 출력-->
                            <a href="Allview.jsp?pageNumber=<%= index %>&cntPT=<%= cntPT %>&searchStudentID=<%=searchStudentID %>"><%= index %></a><span></span>
                            <% } %>
                            
                        <% } %>
                    
                    <%if(nn != -1) {%>
                    <!--다음 10블록 뒤로가는 버튼 생성-->
                    <a href="Allview.jsp?pageNumber=<%= n %>&cntPT=<%= cntPT %>&searchStudentID=<%=searchStudentID %>">></a> 
                    <!--맨 마지막 페이지로 가는 버튼 생성-->
                    <a href="Allview.jsp?pageNumber=<%= nn %>&cntPT=<%= cntPT %>&searchStudentID=<%=searchStudentID %>">>></a> 
                    <% } %>
        </div>
 		 <% } %>  
    <% } %>     
</body>
</html>
