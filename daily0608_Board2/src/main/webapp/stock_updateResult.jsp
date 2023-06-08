5.updateResult.jsp
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
int stockInventory = 0;
try{
	stockInventory = Integer.parseInt(request.getParameter("stockInventory"));
}catch(Exception e){
}

StockDao stockDao = new StockDaoImpl();

Stock ss = stockDao.selectOneStock(id);
ss.setId(id);
ss.setInventory(stockInventory);

int result = stockDao.updateStock(ss);
if(result == 1){
%>
<form method="get" name="fm">
  <table width="850" border="1" cellspacing="0" cellpadding="5">
    <tr>
      <td colspan="3" align="center">
        <h2><b>재고 업데이트 성공</b></h2>
      </td>
       <td align="center">
        <input type="button" value="목록보기" onclick="location.href='stock_list.jsp?&pageNumber=<%=pageNumber%>'">
      </td>
       <td align="center">
        <input type="button" value="수정된 게시글 보러가기" onclick="location.href='stock_view.jsp?id=<%= id %>&pageNumber=<%= pageNumber %>&stockInventory=<%=stockInventory%>'">
      </td>
    </tr>
  </table>
</form>
</body>
<%} else { %>
<form method="get" name="fm">
  <table width="850" border="1" cellspacing="0" cellpadding="5">
    <tr>
      <td colspan="3" align="center">
        <h2><b>재고 업데이트 실패</b></h2>
      </td>
       <td align="center">
        <input type="button" value="목록보기" onclick="location.href='stock_list.jsp?&pageNumber=<%=pageNumber%>'">
      </td>
    </tr>
  </table>
</form>
</body>
<%} %>
</html>
