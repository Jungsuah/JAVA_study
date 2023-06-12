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
    Stock stock = stockDao.selectOneStock(id);

    if (stock != null) {
    	 response.sendRedirect("stock_view.jsp?id="+id);
    }
%>
<script>
        alert("등록되어 있지 않은 상품번호 입니다!");
        location.href = "stock_list.jsp";
   </script>
</body>
</html>
