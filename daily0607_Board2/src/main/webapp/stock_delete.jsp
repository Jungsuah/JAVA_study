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
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

    String id = "";
    try {
        id = request.getParameter("id");
    } catch (Exception e) {
    }

    int pageNumber = 0;
    try {
        pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
    } catch (Exception e) {
    }

    StockDao stockDao = new StockDaoImpl(); // stockDao 객체 생성
    int result = stockDao.deleteOneStock(id);

    if (result != 1) {
        out.println("Failed to delete the record.");
    }
%>
<script>
        alert("삭제 성공!");
        location.href = "stock_list.jsp?page=" + <%= pageNumber %>;
    </script>
</body>
</html>
