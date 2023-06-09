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

int iId = 0;
try{
	iId = Integer.parseInt(id);
}catch(Exception e){
}

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
	if(iId != 0){
	stock.setId(iId);
	}else{
		stock.setId(Integer.parseInt(id));
	}
    stock.setName(name);
    stock.setInventory(Integer.parseInt(inventory));
    stock.setContent(content);
    stock.setUrl(urlPath);
} catch (Exception e) {
    e.printStackTrace();
}
StockDao stockDao = new StockDaoImpl();
int result = stockDao.insertStock(stock);
%>
<% if (result > 0) { %>
    <form method="get" name="fm" action="stock_view.jsp">
        <table width="850" border="1" cellspacing="0" cellpadding="5">
            <tr>
                <td colspan="3" align="center">
                    <h2><b>재고 신규 등록 성공</b></h2>
                </td>
                <td align="center">
                    <input type="button" value="목록보기" onclick="location.href='stock_list.jsp?'">
                </td>
                <td align="center">
                    <input type="button" value="등록된 재고 보러가기" onclick="location.href='stock_view.jsp?id=<%=id%>'">
                </td>
            </tr>
        </table>
    </form>
<% } else { %>
    <form method="get" name="fm">
        <table width="850" border="1" cellspacing="0" cellpadding="5">
            <tr>
                <td colspan="3" align="center">
                    <h2><b>재고 신규 등록 실패</b></h2>
                </td>
                <td align="center">
                    <input type="button" value="목록보기" onclick="location.href='stock_list.jsp?'">
                </td>
            </tr>
        </table>
    </form>
<% } %>
</body>
</html>
