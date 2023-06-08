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
    .tablestyle {
        border-collapse: collapse;
        width: 700px;
        height:500px;
        background: linear-gradient(to bottom, #e2e2e2, #f1f1f1);
    }
    
    th, td {
        text-align: start;
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

int stockInventory1 = 0;
try{
	stockInventory1 = Integer.parseInt(request.getParameter("stockInventory"));
}catch(Exception e){
}

int stockId = 0;
String stockName = "";
int stockInventory= 0;
String stockCheckdate = "";
String stockDate= "";
String stockContent= "";
String stockUrl= "";

StockDao stockDao = new StockDaoImpl(); // StudentScoreDaoImpl 객체 생성
Stock stock = null;
try{
	if(id != 0){
	stockId = id;
	stock = stockDao.selectOneStock(stockId);
	}
	
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
<body>
<h2 style='margin-left:200px'>(주)트와이스 재고 현황-전체현황</h2>
<form method="get" name="fm" enctype="multipart/form-data">
  <table class="tablestyle" border="1" cellspacing="0" cellpadding="5">
    <tr>
      <td width="200"><b>상품번호</b></td>
      <td><%=stockId%></td>
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
    <tr>
      <td><b>상품설명</b></td>
      <td><%=stockContent%></td>
    </tr>
    <tr width="400" height="400">
	  <td><b>상품사진</b></td>
	  <td>
	    <img src="<%=stockUrl%>" style="width: 100%; height: 100%;">
	  </td>
	</tr>
  </table>
<table width=700>
    <tr>
      <td width=700></td>
      <td align="center">
        <input type="button" value="목록보기" onclick="location.href='stock_list.jsp?&pageNumber=<%=pageNumber%>'">
      </td>
      <td><input type="button" value="상품삭제" onclick="location.href='stock_delete.jsp?id=<%=stockId%>&pageNumber=<%=pageNumber%>'"></td>
      <td><input type="button" value="재고수정" onclick="location.href='stock_updateNumber.jsp?id=<%=stockId%>&name=<%=stockName%>&inventory=<%=stockInventory%>&checkdate=<%=stockCheckdate%>&date=<%=stockDate%>&content=<%=stockContent%>&pageNumber=<%=pageNumber%>'"></td>
    </tr>
  </table>
  </form>
</body>
</html>