<%@page import="dao.StockDaoImpl"%>
<%@page import="dao.StockDao"%>
<%@page import="domain.Stock"%>
<%@ page import="java.io.File" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String path = "/image";
String realPath = request.getServletContext().getRealPath(path);
System.out.println("view.jsp - realPath : " + realPath);

int maxSize = 5 * 1024 * 1024; // 사진의 size
MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "UTF-8", new DefaultFileRenamePolicy());

// form으로 전달받은 데이터 가져오기
String id = multi.getParameter("stockId");
String name = multi.getParameter("stockName");
String inventory = multi.getParameter("stockInventory");
String content = multi.getParameter("stockContent");
String url = multi.getFilesystemName("url");
String urlPath = "./image/" + url;

if(url == null){
	urlPath = "./image/no_image.png";
}

Stock stock = new Stock();
try {
	stock.setId(id);
    stock.setName(name);
    stock.setInventory(Integer.parseInt(inventory));
    stock.setContent(content);
    
    stock.setUrl(urlPath);
} catch (Exception e) {
    e.printStackTrace();
}
StockDao stockDao = new StockDaoImpl();
int result = stockDao.insertStock(stock);

stock.getRownum();

if (result == 1) {
    int c = stockDao.getCurrentPage(id, 20);
    response.sendRedirect("stock_list.jsp?page="+c);
 } 
%>
<script>
        alert("등록되어있는 상품 번호 입니다!");
        location.href = "stock_insert.jsp";
    </script>
</body>
</html>
