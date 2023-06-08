6. stock_delete.jsp
<%@page import="domain.Stock"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="dao.StockDaoImpl"%>
<%@page import="dao.StockDao"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head>
<meta charset="UTF-8">
<title>6.stock_delete.jsp</title>
<style>
    table {
        border-collapse: collapse;
        width: 850px;
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

int id = 0;
try{
	id = Integer.parseInt(request.getParameter("id"));
}catch(Exception e){
}

int pageNumber = 0;
try{
	pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
}catch(Exception e){
}

StockDao gongjiDao = new StockDaoImpl(); // GongjiDaoImpl 객체 생성
int result = gongjiDao.deleteOneStock(id);
%>
<% if (result > 0) { %>
    <form method="get" name="fm">
        <table width="650" border="1" cellspacing="0" cellpadding="5">
            <tr>
                <td colspan="3" align="center">
                    <h2><b>재고 삭제 성공</b></h2>
                </td>
                <td align="center">
                    <input type="button" value="목록보기" onclick="location.href='stock_list.jsp?pageNumber=<%=pageNumber%>'">
                </td>
            </tr>
        </table>
    </form>
<% } else { %>
    <form method="get" name="fm">
        <table width="650" border="1" cellspacing="0" cellpadding="5">
            <tr>
                <td colspan="3" align="center">
                    <h2><b>재고 삭제 실패</b></h2>
                </td>
                <td align="center">
                    <input type="button" value="목록보기" onclick="location.href='stock_list.jsp?pageNumber=<%=pageNumber%>>'">
                </td>
            </tr>
        </table>
    </form>
<% } %>
</body>
</html>