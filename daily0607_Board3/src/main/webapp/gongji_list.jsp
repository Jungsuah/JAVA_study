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
    body {
        font-family: Arial, sans-serif;
        background-color: white;
    }

    table {
        width: 1000px;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #8ec5e3;
        color: white;
    }

    a {
        color: #007bff;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }

    .pagination {
        text-align: center;
        margin-top: 20px;
        width: 2000px;
        margin-left:50px;
    }

    .pagination a {
        display: inline-block;
        padding: 8px 16px;
        text-decoration: none;
        color: #007bff;
        border: 1px solid #ddd;
    }

    .pagination a.active {
        background-color: #007bff;
        color: white;
        border: 1px solid #007bff;
    }

    .pagination a:hover:not(.active) {
        background-color: #ddd;
    }

    .pagination a:first-child {
        border-top-left-radius: 5px;
        border-bottom-left-radius: 5px;
    }

    .pagination a:last-child {
        border-top-right-radius: 5px;
        border-bottom-right-radius: 5px;
    }

    .new-button {
        margin-top: 20px;
        text-align: right;
        width: 1000px;
    }

    .new-button input[type="button"] {
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        border: none;
        cursor: pointer;
    }

    .new-button input[type="button"]:hover {
        background-color: #0056b3;
    }
   .pagination-and-new-button {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 1000px;
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

int viewcnt = 0;
try{
    viewcnt = Integer.parseInt(request.getParameter("viewcnt"));
}catch (Exception e){
}
out.println(viewcnt);

Pagination pagination = gongjiService.getPagination(pageNumber, cntPT);

int c = pagination.getC();//현재 페이지
int s =  pagination.getS();//시작 버튼 번호
int e = pagination.getE();//마지막 버튼 번호
int p = pagination.getP();//< 버튼
int pp = pagination.getPp();//<< 버튼
int n = pagination.getN();//> 버튼
int nn = pagination.getNn();//>> 버튼

List<Gongji> gongjiList = gongjiDao.selectAll(c, cntPT);
String bar ="";
%>
<% if (gongjiList.isEmpty()) { %>
    <h2>등록된 공지사항이 없습니다.</h2>
<% } else { %>
    <table>
    <tr>
        <th width="50">번호</th>
        <th width="500">제목</th>
        <th width="100">조회수</th>
        <th width="100">등록일</th>
    </tr>
    <% for(Gongji gongji : gongjiList) { %>
        <tr>
            <td><%=gongji.getId()%></td>
            <td>
                <% for(int i = 0; i < gongji.getRelevel(); i++) { %>
                     bar = bar + '-';
                <% } %>
                <a href='gongji_view.jsp?id=<%=gongji.getId()%>&pageNumber=<%=c%>&viewcnt=<%=viewcnt%>'><%=bar%>><%=gongji.getTitle()%></a>
            </td>
            <% if(gongji.getId() == id) { %>
                <td><%=viewcnt%></td>
            <% } else { %>
                <td><%=gongji.getViewcnt()%></td>
            <% } %>
            <td><%=gongji.getDate()%></td>
        </tr>
    <% } %>
</table>

    <div class="pagination-and-new-button">
    <div class="pagination">
        <%if(pp != -1){ %> <!--pp값이 -1이면 보이지 않게 처리-->
            <a href="gongji_list.jsp?pageNumber=<%= pp %>&cntPT=<%= cntPT %>"><<</a> <!--무조건 1페이지로 이동하는 버튼-->
            <!--p값을 통해 이전 10블록전으로 이동하는 버튼 출력 -->
            <a href="gongji_list.jsp?pageNumber=<%= p %>&cntPT=<%= cntPT %>"><</a>
        <% } %>

        <%for (int index = s; index < e + 1; index++) {%>
            <!--만약 시작번호 부터 끝 번호까지 버튼을 출력하기-->
            <% if (index == c) {%> <!--만약 번호가 현재 페이지와 같다면 빨간색으로 출력하기-->
                <a href="gongji_list.jsp?pageNumber=<%= index %>&cntPT=<%= cntPT %>" class="active"><%= index %></a>
            <%} else {%><!-- 현재 페이지와 같은 버튼이 아니라면 스타일 없이 버튼 출력-->
                <a href="gongji_list.jsp?pageNumber=<%= index %>&cntPT=<%= cntPT %>"><%= index %></a>
            <% } %>

        <% } %>

        <%if(nn != -1) {%>
        <!--다음 10블록 뒤로가는 버튼 생성-->
        <a href="gongji_list.jsp?pageNumber=<%= n %>&cntPT=<%= cntPT %>">></a>
        <!--맨 마지막 페이지로 가는 버튼 생성-->
        <a href="gongji_list.jsp?pageNumber=<%= nn %>&cntPT=<%= cntPT %>">>></a>
        <% } %>
    </div>

    <div class="new-button">
        <input type="button" value="신규" OnClick="window.location='gongji_insert.jsp'">
    </div>
</div>

<% } %>
</body>
</html>
