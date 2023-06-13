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

function submitForm() {
    // 재고현황 입력 제한: 숫자만 입력 가능
    var stockInventory = document.getElementsByName("stockInventory")[0].value;
    if (isNaN(stockInventory)) {
        alert("재고현황은 숫자만 입력할 수 있습니다.");
        return;
    }

    // 상품설명 입력 제한: 공백일 수 없음
    var stockContent = document.getElementsByName("stockContent")[0].value;
    if (stockContent.trim().length === 0) {
        alert("상품설명은 공백일 수 없습니다.");
        return;
    }

    fm.action = "writeAction.jsp";
    fm.submit();
}

</script>
</head>

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

LocalDate currentDate = LocalDate.now(); // 현재 날짜를 가진 LocalDate 객체 생성
String formattedDate = currentDate.toString(); // 날짜를 문자열로 변환

// 원하는 형식으로 날짜를 포맷팅
String desiredFormat = "yyyy-MM-dd";
java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern(desiredFormat);
String currentdate = currentDate.format(formatter);

String id = "";
try{
	id = request.getParameter("id");
}catch(Exception e){
}

StockDao stockDao = new StockDaoImpl(); // StudentScoreDaoImpl 객체 생성
Stock stock = stockDao.selectOneStock(id); // 테이블 생성 메서드 호출하여 오류 여부 확인

String stockId = stock.getId();
String stockName = stock.getName();
int stockInventory = stock.getInventory();
String checkdate = stock.getCheckdate();
String date = stock.getDate();
String stockContent = stock.getContent();
String stockUrl = stock.getUrl();
%>

<body>
    <h2 style='margin-left:200px'>(주)트와이스 재고 현황-전체현황</h2>
    <form method="get" name="fm" enctype="multipart/form-data">
        <table class="tablestyle" border="1" cellspacing="0" cellpadding="5">
            <tr>
                <td width="200"><b>상품번호</b></td>
                <td><input type="text" name="stockId" pattern="[0-9]+" required value="<%=stockId%>"></td>
            </tr>
            <tr>
                <td><b>상품명</b></td>
                <td><input type="text" name="stockName" pattern="[^\s]+" required value="<%=stockName%>"></td>
            </tr>
            <tr>
                <td><b>재고현황</b></td>
                <td><input type="text" name="stockInventory" pattern="[0-9]+" required value="<%=stockInventory%>"></td>
            </tr>
            <tr>
                <td><b>상표등록일</b></td>
                <td><%=checkdate%></td>
            </tr>
            <tr>
                <td><b>재고등록일</b></td>
                <td><%=date%></td>
            </tr>
            <tr>
                <td><b>상품설명</b></td>
                <td><input type="text" name="stockContent" pattern="[^\s]+" required value="<%=stockContent%>"></td>
            </tr>
            <tr width="400" height="400">
                <td><b>상품사진</b></td>
                <td>
                    <input type="file" name="url">
                </td>
            </tr>
        </table>
        <table width=700>
            <tr>
                <td width=700></td>
                <td><input type="button" value="완료" OnClick="submitForm()"></td>
            </tr>
        </table>
    </form>
</body>
</html>