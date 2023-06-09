<%@page import="service.StockServiceImpl"%>
<%@page import="service.StockService"%>
<%@page import="dto.Pagination"%>
<%@page import="domain.Stock"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="dao.StockDaoImpl"%>
<%@page import="dao.StockDao"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>게시판</title>
   <style>
    body {
        font-family: Arial, sans-serif;
    }
    
    .container {
        width: 800px;
        margin: 20px auto;
        background: #E1F0FF;
        padding: 20px;
        border: 1px solid #85C1E9;
        border-radius: 4px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
    
    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #3498DB;
    }
    
    table {
        width: 100%;
        border-collapse: collapse;
        background-color: #FFFFFF;
    }
    
    th, td {
        border: 1px solid #D6EAF8;
        padding: 8px;
    }
    
    th {
        background-color: #85C1E9;
        color: #ffffff;
    }
    
    tr:nth-child(even) {
        background-color: #EBF5FB;
    }
    
    .pagination {
        margin-top: 20px;
        text-align: center;
    }
    
    .pagination a {
        display: inline-block;
        padding: 8px 16px;
        text-decoration: none;
        color: #ffffff;
        background-color: #3498DB;
        border: 1px solid #3498DB;
        margin: 2px;
        border-radius: 4px;
        transition: background-color 0.3s;
    }
    
    .pagination a.active {
        background-color: #2980B9;
        border-color: #2980B9;
    }
    
    .pagination a:hover {
        background-color: #2980B9;
    }
    
    .new-button {
        text-align: center;
        margin-top: 20px;
    }
    
    .new-button input[type="button"] {
        background-color: #3498DB;
        border: none;
        color: #ffffff;
        padding: 8px 16px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 14px;
        margin: 4px 2px;
        cursor: pointer;
        border-radius: 4px;
        transition: background-color 0.3s;
    }
    
    .new-button input[type="button"]:hover {
        background-color: #2980B9;
    }
    
    .new-button input[type="submit"] {
        background-color: #3498DB;
        border: none;
        color: #ffffff;
        padding: 8px 16px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 14px;
        margin: 4px 2px;
        cursor: pointer;
        border-radius: 4px;
        transition: background-color 0.3s;
    }
    
    .new-button input[type="submit"]:hover {
        background-color: #2980B9;
    }
</style>
</head>
<script type="text/javascript">
function validateForm() {
    var searchIdInput = document.getElementsByName("id")[0];
    var searchId = searchIdInput.value.trim();

    if (searchId === "") {
        alert("검색하고 싶은 상품번호를 입력하세요");
        searchIdInput.value = "";
        searchIdInput.focus();
        return false;
    }
}
</script>

<body>
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

StockDao gongjiDao = new StockDaoImpl();
StockService gongjiService = new StockServiceImpl();
int total = gongjiDao.count();
int pageNumber = 0;
int cntPT = 0;
int fromPT = 0;

String id = "";
try{
    id = request.getParameter("id");
}catch(Exception e){
}

try {
    pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
} catch (Exception e) {
    pageNumber = 1;
}

try {
    cntPT = Integer.parseInt(request.getParameter("cntPT"));
} catch (Exception e) {
    cntPT = 20;
}

Pagination kk = gongjiService.getPagination(pageNumber, cntPT);

int c = kk.getC();
int s = kk.getS();
int e = kk.getE();
int p = kk.getP();
int pp = kk.getPp();
int n = kk.getN();
int nn = kk.getNn();

List<Stock> stockList = gongjiDao.selectAll(c, cntPT);
%>
<div class="container">
    <% if (stockList.isEmpty()) { %>
        <h2>등록된 재고가 없습니다.</h2>
        <div class="new-button">
            <input type="button" value="재고 넣기" onclick="location.href='makedata.jsp'">
        </div>
    <% } else { %>
    <form method="post" name="fm"  action="stock_view.jsp" onsubmit="return validateForm()">
        <h2>(주)트와이스 재고 현황 - 전체현황</h2>
        <table>
        <tr>
            	<td colspan=5>
            		 <div class="new-button">
			        	<span>
				        	<input type="text" name="id" style="width: 300px; height: 28px;">
				        	<input type="submit" value="검색" >
			        	</span>
			            <input type="button" value="신규등록" OnClick="window.location='stock_insert.jsp'">
			        </div>
            	</td>
            </tr>
            <tr>
                <th width="50">상품번호</th>
                <th width="100">상품명</th>
                <th width="100">현재 재고수</th>
                <th width="100">재고파악일</th>
                <th width="100">상품등록일</th>
            </tr>
            <% for (Stock stock : stockList) { %>
                <tr>
                    <td><a href='stock_view.jsp?id=<%=stock.getId()%>&pageNumber=<%=c%>'><%=stock.getId()%></a></td>
                    <td><a href='stock_view.jsp?id=<%=stock.getId()%>&pageNumber=<%=c%>'><%=stock.getName()%></a></td>
                    <td><%=stock.getInventory()%></td>
                    <td><%=stock.getCheckdate()%></td>
                    <td><%=stock.getDate()%></td>
                </tr>
            <% } %>
        </table>
        </form>
			        <div class="pagination">
			            <% if (pp != -1) { %>
			                <a href="stock_list.jsp?pageNumber=<%= pp %>&cntPT=<%= cntPT %>"><<</a>
			                <a href="stock_list.jsp?pageNumber=<%= p %>&cntPT=<%= cntPT %>"><</a>
			            <% } %>
			            
			            <% for (int index = s; index < e + 1; index++) { %>
			                <% if (index == c) { %>
			                    <a href="stock_list.jsp?pageNumber=<%= index %>&cntPT=<%= cntPT %>" class="active"><%= index %></a>
			                <% } else { %>
			                    <a href="stock_list.jsp?pageNumber=<%= index %>&cntPT=<%= cntPT %>"><%= index %></a>
			                <% } %>
			            <% } %>
			            
			            <% if (nn != -1) { %>
			                <a href="stock_list.jsp?pageNumber=<%= n %>&cntPT=<%= cntPT %>">></a>
			                <a href="stock_list.jsp?pageNumber=<%= nn %>&cntPT=<%= cntPT %>">>></a>
			            <% } %>
			        </div>
		</div>	
    <% } %>
</body>
</html>