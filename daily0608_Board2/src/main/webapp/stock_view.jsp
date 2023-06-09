3. stock_view.jsp
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="domain.Stock"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="dao.StockDaoImpl"%>
<%@page import="dao.StockDao"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<html>
<head>
<style>
    body {
        font-family: Arial, sans-serif;
    }
    
    .container {
        width: 600px;
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
<script language="JavaScript">
	function submitForm(mode) {
    fm.action = "writeAction.jsp";
    fm.submit();
 }
</script>
</head>

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

String id = "";
try {
    id = request.getParameter("id");
} catch (Exception e) {
}

int pageNumber = 0;
try{
	pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
}catch(Exception e){
}

int stockInventory1 = 0;
try{
	stockInventory1 = Integer.parseInt(request.getParameter("stockInventory"));
}catch(Exception e){
}

String stockName = "";
int stockInventory= 0;
String stockCheckdate = "";
String stockDate= "";
String stockContent= "";
String stockUrl= "";

StockDao stockDao = new StockDaoImpl(); // StudentScoreDaoImpl 객체 생성
Stock stock = new Stock();
try{
	stock = stockDao.selectOneStock(id);
	id = stock.getId();
	stockName = stock.getName();
	
	if(stockInventory1 != 0){
		stockInventory = stockInventory1;
	}else{
	stockInventory = stock.getInventory();
	}
	
	stockCheckdate = stock.getCheckdate();
	stockDate = stock.getDate();
	stockContent = stock.getContent();
	stockUrl = stock.getUrl();
}catch(Exception e){
}

%>
<div class="container">
<body>
<h2 style='margin-left:150px'>(주)트와이스 재고 현황-전체현황</h2>
<form method="get" name="fm" enctype="multipart/form-data">
  <table class="tablestyle" border="1" cellspacing="0" cellpadding="5">
    <tr>
      <td width="200"><b>상품번호</b></td>
      <td><%=id%></td>
    </tr>
    <tr>
      <td><b>상품명</b></td>
      <td><%=stockName%></td>
    </tr>
    <tr>
      <td><b>재고현황</b></td>
      <td><%=stockInventory%> </td>
    </tr>
    <tr>
      <td><b>상표등록일</b></td>
      <td><%=stockCheckdate%></td>
    </tr>
    <tr>
      <td><b>재고등록일</b></td>
      <td><%=stockDate%></td>
    </tr>
    <tr >
      <td><b>상품설명</b></td>
      <td><textarea name="stockContent" cols="60" rows="5" readonly><%=stockContent%></textarea></td>
    </tr>
    <tr>
	  <td><b>상품사진</b></td>
	  <td>
	    <img src="<%=stockUrl%>" width='100%' height="300px">
	  </td>
	</tr>
  </table>
    <div class="new-button">
<table width=600px>
    <tr>
      <td width=600px></td>
      <td align="center">
        <input type="button" value="목록보기" onclick="location.href='stock_list.jsp?&pageNumber=<%=pageNumber%>'">
      </td>
      <td><input type="button" value="상품삭제" onclick="location.href='stock_delete.jsp?id=<%=id%>&pageNumber=<%=pageNumber%>'"></td>
      <td><input type="button" value="재고수정" onclick="location.href='stock_updateNumber.jsp?id=<%=id%>&name=<%=stockName%>&inventory=<%=stockInventory%>&checkdate=<%=stockCheckdate%>&date=<%=stockDate%>&content=<%=stockContent%>&pageNumber=<%=pageNumber%>'"></td>
    </tr>
  </table>
    </div>
  </form>
  </div>	
</body>
</html>