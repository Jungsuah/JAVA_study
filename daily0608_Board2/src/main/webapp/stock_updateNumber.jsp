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
<%@ page import="java.time.LocalDate" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<html>
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
<head>

<script language="JavaScript">

function submitForm() {
    // 재고현황 입력 제한: 숫자만 입력 가능
    var stockInventory = document.getElementsByName("stockInventory")[0].value;
    if (isNaN(stockInventory)) {
        alert("재고현황은 숫자만 입력할 수 있습니다.");
        return;
    }

    fm.action = "stock_updateResult.jsp?stockInventory=" + stockInventory;
    fm.submit();
}
</script>
</head>

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

String id = "";
try{
    id = request.getParameter("id");
}catch(Exception e){
}

int pageNumber = 0;
try{
    pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
}catch(Exception e){
}

StockDao stockDao = new StockDaoImpl(); // StudentScoreDaoImpl 객체 생성
Stock stock = stockDao.selectOneStock(id); // 테이블 생성 메서드 호출하여 오류 여부 확인

if(stock != null){
%>
<div class="container">
<body>
    <h2 style='margin-left:200px'>(주)트와이스 재고 현황-전체현황</h2>
    <form method="get" name="fm" enctype="multipart/form-data">
        <table class="tablestyle" border="1" cellspacing="0" cellpadding="5" width="700">
            <tr>
                <td width="200"><b>상품번호</b></td>
                <td><input type="hidden" name="id" value=<%=stock.getId()%>><%=stock.getId()%></td>
            </tr>
            <tr>
                <td><b>상품명</b></td>
                <td><input type="hidden" name="pageNumber" value=<%=pageNumber%>><%=stock.getName()%></td>
            </tr>
            <tr>
                <td><b>재고현황</b></td>
                <td><input type="text" name="stockInventory" pattern="[0-9]+" required value="<%=stock.getInventory()%>"></td>
            </tr>
            <tr>
                <td><b>상표등록일</b></td>
                <td><%=stock.getCheckdate()%></td>
            </tr>
            <tr>
                <td><b>재고등록일</b></td>
                <td><%=stock.getDate()%></td>
            </tr>
            <tr>
                <td><b>상품설명</b></td>
                <td><%=stock.getContent()%></td>
            </tr>
            <tr width="100%" height="300">
			  <td><b>상품사진</b></td>
			  <td>
			    <img src="<%=stock.getUrl()%>" style="width: 100%; height: 100%;">
			  </td>
			</tr>
        </table>
        <div class="new-button">
        <table width=600>
            <tr width=600>
                <td width=600></td>
                <td><input type="button" value="완료" OnClick="submitForm()"></td>
            </tr>
        </table>
        </div>
    </form>
    </div>
</body>
<% } else{%>
<h1>해당 상품이 없습니다!</h1>
<%} %>
</html>
