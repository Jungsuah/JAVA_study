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
    body {
        font-family: Arial, sans-serif;
    }
    
    .container {
        width: 650px;
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
<script>
function validateForm() {
    var stockIdInput = document.getElementsByName("stockId")[0];
    var stockNameInput = document.getElementsByName("stockName")[0];
    var stockInventoryInput = document.getElementsByName("stockInventory")[0];
    var stockContentInput = document.getElementsByName("stockContent")[0];

    var stockId = stockIdInput.value.trim();
    var stockName = stockNameInput.value.trim();
    var stockInventory = stockInventoryInput.value.trim();
    var stockContent = stockContentInput.value.trim();

    if (stockId === "") {
        alert("상품번호를 입력하세요.");
        stockIdInput.value = "";
        stockIdInput.focus();
        return false;
    }

    if (!/^\w{1,15}$/.test(stockId)) {
        alert("상품번호는 1자리에서 15자리까지의 문자로 입력해야 합니다.");
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

    var fileInput = document.getElementById('url');
    if (fileInput.files.length === 0) {
        document.fm.url.value = "./image/no_image.png";
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

%>

<body>
<div class="container">
    <h2 style='margin-left:50px'>(주)트와이스 재고 현황-전체현황</h2>
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
        <tr width="100" height="100">
            <td><b>상품설명</b></td>
            <td><textarea name="stockContent" cols="50" rows="5" ></textarea></td>
        </tr>
        <tr>
            <td><b>상품사진</b></td>
            <td>
                <img id="preview" src="#" style="display: none; max-width: 100%; max-height: 100%;">
                <br>
                <input type="file" name="url" id="url" onchange="previewImage(event)">
            </td>
        </tr>
    </table>
    <div class="new-button">
    <table width=600>
        <tr>
        	<td width=700></td>
            <td><input type="submit" value="완료"></td>
        </tr>
    </table>
    </div>
</form>
</div>

<script>
    function previewImage(event) {
        var input = event.target;
        var preview = document.getElementById('preview');
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                preview.src = e.target.result;
                preview.style.display = 'block';
                preview.style.width = '350px'; // Set width to 200 pixels
                preview.style.height = '250px'; // Set height to 200 pixels
            }
            reader.readAsDataURL(input.files[0]);
        } else {
            preview.src = '#';
            preview.style.display = 'none';
        }
    }
</script>

</body>
</html>
