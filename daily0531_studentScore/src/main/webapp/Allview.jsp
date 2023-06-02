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
StudentScoreService studentScoreService = new StudentScoreServiceImpl();
StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
int total = 0;

int pageNumber = 1;
int cntPT = 10;
int searchStudentID  = 0;

try{
	searchStudentID = Integer.parseInt(request.getParameter("searchStudentID"));
}catch (Exception e){
}

try{
	pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
}catch (Exception e){
}

try{
cntPT = Integer.parseInt(request.getParameter("cntPT"));
}catch (Exception e){
}

Pagination pagination = studentScoreService.getPagination(pageNumber, cntPT);

String errorMessage = "";//오류를 보여주기 위한 문자열 변수 선언
   		int k27_LineCnt = 0;// 라인 횟수를 셀수있는 숫자형 변수 선언
        int c = pagination.getC();//현재 페이지
        int s =  pagination.getS();//시작 버튼 번호
        int e = pagination.getE();//마지막 버튼 번호
        int p = pagination.getP();//< 버튼
        int pp = pagination.getPp();//<< 버튼
        int n = pagination.getN();//> 버튼
        int nn = pagination.getNn();//>> 버튼
        int fromPT = (c - 1) * cntPT;//>> 버튼

List<StudentScore> studentScoreList = studentScoreDao.selectAll(c, cntPT);

String table = "examtable";

boolean isTableExist = studentScoreDao.isTableExists(table);

if (!isTableExist) {
    out.println("<h1>테이블이 생성되어 있지 않습니다!</h1>");
} else {
    total = studentScoreDao.count();
    if (total == 0) {
        out.println("<h1>테이블에 데이터가 없습니다!</h1>");
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
        for (StudentScore studentScore : studentScoreList) {	
        	if (studentScore.getStudentid() == searchStudentID){ //결과셋의 학번과 파라미터로받아온 학번이 같으면
                out.println("<tr style=\"background-color: yellow;\">"); // 해당 테이블 행에 노란 배경
            } else{
                out.println("<tr>");    
            } 
			out.println("<td><p align=center><p align=center><a href=\"oneView.jsp?id=" + studentScore.getId() + "\" target=\"result\">" + studentScore.getName() + "</p></td>");
			out.println("<td><p align=center>" + studentScore.getStudentid() + "</p></td>");
			out.println("<td><p align=right>" + studentScore.getKor() + "</p></td>");
			out.println("<td><p align=right>" + studentScore.getEng() + "</p></td>");
			out.println("<td><p align=right>" + studentScore.getMat() + "</p></td>");
			out.println("<td><p align=center>" + studentScore.getSum() + "</p></td>");
			out.println("<td><p align=center>" + studentScore.getAve() + "</p></td>");
			out.println("<td><p align=center>" + studentScore.getRanking() + "</p></td>");
			out.println("</tr>");
		}

        out.println("<h1>조회</h1>");//값을 보여주고 조회를 띄워준다
        %>
    </table>

        <!--버튼을 출력하기 위한 div 생성-->
        <div style ="text-align:left; font-weight: bold; font-size : 20pt;  margin-left:150px;">
                    <%if(pp != -1){ %> <!--현재 페이지가 10보다 크다면 <<와 <버튼 출력-->
                        <a href="Allview.jsp?pageNumber=<%= pp %>&cntPT=<%= cntPT %>&searchStudentID=<%=searchStudentID %>"><<</a><span></span> <!--무조건 1페이지로 이동하는 버튼-->
                        <!--before은 버튼임으로 버튼과 cntPT를 사용하여 fromPT값을 구하기-->
                        <a href="Allview.jsp?pageNumber=<%= p %>&cntPT=<%= cntPT %>&searchStudentID=<%=searchStudentID %>"><</a>
                    <% } %>
                    
                        <%for (int index = s; index < e + 1; index++) {%>
                            <!--만약 현재 페이지가 출력하고 싶은 버튼의 수와 같다면 스타일을 red로 지정-->
                            <% if (index == c) {%>
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
