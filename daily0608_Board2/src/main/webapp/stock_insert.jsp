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
        height: 500px;
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

<script>
function validateForm() {
	  var stockIdInput = document.getElementsByName("stockId")[0];
	  var stockNameInput = document.getElementsByName("stockName")[0];
	  var stockInventoryInput = document.getElementsByName("stockInventory")[0];
	  var stockContentInput = document.getElementsByName("stockContent")[0];

	  var stockId = stockIdInput.value;
	  var stockName = stockNameInput.value.trim();
	  var stockInventory = stockInventoryInput.value;
	  var stockContent = stockContentInput.value.trim();

	  if (stockId === "") {
	    alert("상품번호를 입력하세요.");
	    stockIdInput.value = "";
	    stockIdInput.focus();
	    return false;
	  }

	  if (!/^\d+$/.test(stockId)) {
	    alert("상품번호는 숫자만 입력할 수 있습니다.");
	    stockIdInput.value = "";
	    stockIdInput.focus();
	    return false;
	  }

	  if (stockName === "") {
	    alert("상품명을 입력은 필수입니다.");
	    stockNameInput.value = "";
	    stockNameInput.focus();
	    return false;
	  }

	  if (!/^\d+$/.test(stockInventory)) {
	    alert("재고현황은 숫자만 입력할 수 있습니다.");
	    stockInventoryInput.value = "";
	    stockInventoryInput.focus();
	    return false;
	  }

	  if (stockContent === "") {
	    alert("상품설명을 입력하세요.");
	    stockContentInput.value = "";
	    stockContentInput.focus();
	    return false;
	  }
	  return true;
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

%>

<body>
    <h2 style='margin-left:200px'>(주)트와이스 재고 현황-전체현황</h2>
    <form method="post" name="fm" enctype="multipart/form-data" action="writeAction.jsp" onsubmit="return validateForm()">
        <table class="tablestyle" border="1" cellspacing="0" cellpadding="5">
            <tr>
                <td width="200"><b>상품번호</b></td>
                <td><input type="text" name="stockId"></td>
            </tr>
            <tr>
                <td><b>상품명</b></td>
                <td><input type="text" name="stockName"></td>
            </tr>
            <tr>
                <td><b>재고현황</b></td>
                <td><input type="text" name="stockInventory"></td>
            </tr>
            <tr>
                <td><b>상표등록일</b></td>
                <td><%=currentdate%></td>
            </tr>
            <tr>
                <td><b>재고등록일</b></td>
                <td><%=currentdate%></td>
            </tr>
            <tr>
                <td><b>상품설명</b></td>
                <td><input type="text" name="stockContent"></td>
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
                <td><input type="submit" value="완료"></td>
            </tr>
        </table>
    </form>
</body>
</html>
