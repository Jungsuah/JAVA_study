1. stock_list.jsp
<%@page import="service.StockServiceImpl"%>
<%@page import="service.StockService"%>
<%@page import="dto.Pagination"%>
<%@page import="domain.Stock"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="dao.StockDaoImpl"%>
<%@page import="dao.StockDao"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head>
<style>
    table {
        border-collapse: collapse;
        width: 800px;
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
</style>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

StockDao gongjiDao = new StockDaoImpl(); // StudentScoreDaoImpl 객체 생성
StockService gongjiService = new StockServiceImpl(); // StudentScoreDaoImpl 객체 생성
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
	  cntPT = 20;
 }
 
 Pagination pagination = gongjiService.getPagination(pageNumber, cntPT);

         int c = pagination.getC();//현재 페이지
         int s =  pagination.getS();//시작 버튼 번호
         int e = pagination.getE();//마지막 버튼 번호
         int p = pagination.getP();//< 버튼
         int pp = pagination.getPp();//<< 버튼
         int n = pagination.getN();//> 버튼
         int nn = pagination.getNn();//>> 버튼

List<Stock> stockList = gongjiDao.selectAll(c, cntPT);
         
%>
<% if (stockList.isEmpty()) { %>
    <table width="650" border="1" cellspacing="0" cellpadding="5">
            <tr>
                <td colspan="3" align="center">
                    <h2>등록된 재고가 없습니다.</h2>
                </td>
                <td align="center">
                    <input type="button" value="재고 넣기" onclick="location.href='makedata.jsp'">
                </td>
            </tr>
        </table>
<% } else { %>
    <h2 style='margin-left:225px'>(주)트와이스 재고 현황-전체현황</h2>
    <table border=1>
    <tr>
        <th width="50">상품번호</th>
        <th width="100">상품명</th>
        <th width="100">현재 재고수</th>
        <th width="100">재고파악일</th>
        <th width="100">상품등록일</th>
    </tr>
    
    <% for(Stock stock : stockList) { %>
    <tr>
        <td><a href='stock_view.jsp?id=<%=stock.getId()%>&pageNumber=<%=c%>'><%=stock.getId()%></a></td>
        <td><a href='stock_view.jsp?id=<%=stock.getId()%>&pageNumber=<%=c%>'><%=stock.getName()%></a></td>
        <td><%=stock.getInventory()%></td>
        <td><%=stock.getCheckdate()%></td>
        <td><%=stock.getDate()%></td>
    </tr>
    <% } %>
    <tr><td colspan =5>
    <div style ="align:center; font-weight: bold; font-size : 20pt;  ">
                    <%if(pp != -1){ %> <!--pp값이 -1이면 보이지 않게 처리-->
                        <a href="stock_list.jsp?pageNumber=<%= pp %>&cntPT=<%= cntPT %>"><<</a><span></span> <!--무조건 1페이지로 이동하는 버튼-->
                        <!--p값을 통해 이전 10블록전으로 이동하는 버튼 출력 -->
                        <a href="stock_list.jsp?pageNumber=<%= p %>&cntPT=<%= cntPT %>"><</a>
                    <% } %>
                    
                        <%for (int index = s; index < e + 1; index++) {%>
                            <!--만약 시작번호 부터 끝 번호까지 버튼을 출력하기-->
                            <% if (index == c) {%> <!--만약 번호가 현재 페이지와 같다면 빨간색으로 출력하기-->
                            <a href="stock_list.jsp?pageNumber=<%= index %>&cntPT=<%= cntPT %>" style="color: red"><%= index %></a><span></span>
                            <%} else {%><!-- 현재 페이지와 같은 버튼이 아니라면 스타일 없이 버튼 출력-->
                            <a href="stock_list.jsp?pageNumber=<%= index %>&cntPT=<%= cntPT %>"><%= index %></a><span></span>
                            <% } %>
                            
                        <% } %>
                    
                    <%if(nn != -1) {%>
                    <!--다음 10블록 뒤로가는 버튼 생성-->
                    <a href="stock_list.jsp?pageNumber=<%= n %>&cntPT=<%= cntPT %>">></a> 
                    <!--맨 마지막 페이지로 가는 버튼 생성-->
                    <a href="stock_list.jsp?pageNumber=<%= nn %>&cntPT=<%= cntPT %>">>></a> 
                    <% } %>
                    <span><input type=button value="신규등록" OnClick="window.location='stock_insert.jsp'"></span>
        </div>
     </td></tr>
    </table>

<!--버튼을 출력하기 위한 div 생성-->
        
        
<% } %>
</body>
</html>
