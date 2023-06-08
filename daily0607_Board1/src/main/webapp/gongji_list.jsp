1. gongji_list.jsp
<%@page import="service.GongjiServiceImpl"%>
<%@page import="dto.Pagination"%>
<%@page import="service.GongjiService"%>
<%@page import="domain.Gongji"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="dao.GongjiDaoImpl"%>
<%@page import="dao.GongjiDao"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head>
<style>
    table {
        border-collapse: collapse;
        width: 600px;
        background: linear-gradient(to bottom, #e2e2e2, #f1f1f1);
    }
    
    th, td {
        text-align: center;
        padding: 8px;
    }
    
    th {
        background-color: #f2f2f2;
    }
    
    tr:nth-child(even) {
        background-color: #ffffff;
    }
    
    h2 {
        margin-top: 20px;
    }
    
    input[type=button] {
        background-color: #4CAF50;
        border: none;
        color: white;
        padding: 8px 16px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 14px;
        margin: 4px 2px;
        cursor: pointer;
        border-radius: 4px;
    }
    
    input[type=button]:hover {
        background-color: #45a049;
    }
    
    .custom-div {
            text-align: left;
            font-weight: bold;
            font-size: 20pt;
            margin-left: 150px;
        }
        
        .custom-div a {
            color: red;
            text-decoration: none;
        }
    
</style>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

GongjiDao gongjiDao = new GongjiDaoImpl(); // StudentScoreDaoImpl 객체 생성
GongjiService gongjiService = new GongjiServiceImpl(); // StudentScoreDaoImpl 객체 생성
int total = gongjiDao.count();
int pageNumber = 0;
int cntPT = 0;

int id = 0;
int fromPT = 0;
try{
	id = Integer.parseInt(request.getParameter("id"));
}catch(Exception e){
}

 try{
	  pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
 }catch (Exception e){
	  pageNumber = 1;
 }

 try{
	  cntPT = Integer.parseInt(request.getParameter("cntPT"));
 }catch (Exception e){
	  cntPT = 10;
 }
 
 Pagination pagination = gongjiService.getPagination(pageNumber, cntPT);

         int c = pagination.getC();//현재 페이지
         int s =  pagination.getS();//시작 버튼 번호
         int e = pagination.getE();//마지막 버튼 번호
         int p = pagination.getP();//< 버튼
         int pp = pagination.getPp();//<< 버튼
         int n = pagination.getN();//> 버튼
         int nn = pagination.getNn();//>> 버튼

List<Gongji> gongjiList = gongjiDao.selectAll(c, cntPT);
%>
<% if (gongjiList.isEmpty()) { %>
    <h2>등록된 공지사항이 없습니다.</h2>
<% } else { %>
    <table border=1>
    <tr>
        <th width="50">번호</th>
        <th width="500">제목</th>
        <th width="100">등록일</th>
    </tr>
    
    <% for(Gongji gongji : gongjiList) { %>
    <tr>
        <td><%=gongji.getId()%></td>
        <td><a href='gongji_view.jsp?id=<%=gongji.getId()%>&pageNumber=<%=c%>'><%=gongji.getTitle()%></a></td>
        <td><%=gongji.getDate()%></td>
    </tr>
    <% } %>
    </table>

<table width=650>
<tr>
<td width=550></td>
<td><input type=button value="신규" OnClick="window.location='gongji_insert.jsp'"></td>
</tr>
</table>

<!--버튼을 출력하기 위한 div 생성-->
        <div style ="text-align:left; font-weight: bold; font-size : 20pt;  margin-left:150px;">
                    <%if(pp != -1){ %> <!--pp값이 -1이면 보이지 않게 처리-->
                        <a href="gongji_list.jsp?pageNumber=<%= pp %>&cntPT=<%= cntPT %>"><<</a><span></span> <!--무조건 1페이지로 이동하는 버튼-->
                        <!--p값을 통해 이전 10블록전으로 이동하는 버튼 출력 -->
                        <a href="gongji_list.jsp?pageNumber=<%= p %>&cntPT=<%= cntPT %>"><</a>
                    <% } %>
                    
                        <%for (int index = s; index < e + 1; index++) {%>
                            <!--만약 시작번호 부터 끝 번호까지 버튼을 출력하기-->
                            <% if (index == c) {%> <!--만약 번호가 현재 페이지와 같다면 빨간색으로 출력하기-->
                            <a href="gongji_list.jsp?pageNumber=<%= index %>&cntPT=<%= cntPT %>" style="color: red"><%= index %></a><span></span>
                            <%} else {%><!-- 현재 페이지와 같은 버튼이 아니라면 스타일 없이 버튼 출력-->
                            <a href="gongji_list.jsp?pageNumber=<%= index %>&cntPT=<%= cntPT %>"><%= index %></a><span></span>
                            <% } %>
                            
                        <% } %>
                    
                    <%if(nn != -1) {%>
                    <!--다음 10블록 뒤로가는 버튼 생성-->
                    <a href="gongji_list.jsp?pageNumber=<%= n %>&cntPT=<%= cntPT %>">></a> 
                    <!--맨 마지막 페이지로 가는 버튼 생성-->
                    <a href="gongji_list.jsp?pageNumber=<%= nn %>&cntPT=<%= cntPT %>">>></a> 
                    <% } %>
        </div>
<% } %>
</body>
</html>
