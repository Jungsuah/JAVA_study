<%@page import="dao.StockDaoImpl"%>
<%@page import="dao.StockDao"%>
<%@page import="domain.Stock"%>
<%@ page import="java.io.File" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = "";
try{
    id = request.getParameter("id");
}catch(Exception e){
}

int stockInventory = 0;
try{
	stockInventory = Integer.parseInt(request.getParameter("stockInventory"));
}catch(Exception e){
}

StockDao stockDao = new StockDaoImpl();

Stock ss = stockDao.selectOneStock(id);
ss.setInventory(stockInventory);
int result = stockDao.updateStock(ss);

ss.getRownum();

if (result != 1) {
    out.println("Failed to update the record.");
 }
	int c = stockDao.getCurrentPage(id, 20);
%>
<script>
    alert("재고 수정 성공!");
    location.href = "stock_list.jsp?page=" +  <%=  c %>;
    </script>
</body>
</html>