<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="domain.Gongji"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="dao.GongjiDaoImpl"%>
<%@page import="dao.GongjiDao"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<html>
<head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f1f8ff;
    }

    table {
        width: 650px;
        border-collapse: collapse;
        margin-top: 20px;
        background-color: white;
    }

    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #8ec5e3;
        color: white;
    }

    input[type="text"], textarea {
        width: 500px;
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 4px;
        resize: vertical;
    }

    input[type="button"] {
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        border: none;
        cursor: pointer;
        border-radius: 4px;
        margin-right: 10px;
    }

    input[type="button"]:hover {
        background-color: #0056b3;
    }

    .cancel-button {
        background-color: #dc3545;
    }

    .cancel-button:hover {
        background-color: #a71d2a;
    }

    .container {
        display: flex;
        height: 100vh;
    }
    
     .button-group {
        text-align: right;
        width: 650px;
        margin-top:5px;
    }
    
    .textarea {
        width: 500px;
        height: 200px;
        padding: 10px;
        font-family: Arial, sans-serif;
        font-size: 14px;
        border: 1px solid #ddd;
        border-radius: 4px;
        resize: none;
    }
</style>

<script language="JavaScript">
function submitForm(mode) {
   var title = document.forms["fm"]["title"].value;
   var content = document.forms["fm"]["content"].value;
   
   if (title.includes("'")) {
	      alert("제목에는 작은따옴표를 입력할 수 없습니다.");
	      return;
	   }
	   
	   if (content.includes("'")) {
	      alert("내용에는 작은따옴표를 입력할 수 없습니다.");
	      return;
	   }
   
   if (title.trim() === "") {
      alert("제목은 필수 입력 항목입니다.");
      return;
   }
   
   if (content.trim() === "") {
      alert("내용은 필수 입력 항목입니다.");
      return;
   }
   
   fm.action = "gongji_insertWrite.jsp";
   fm.submit();
}
</script>

</head>
<body>
<div class="container">
<%
  Date currentDate = new Date();
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  String formattedDate = sdf.format(currentDate);
  
  int rootid = 0;
  try{
  	rootid = Integer.parseInt(request.getParameter("rootid"));
  }catch(Exception e){
  }
  
%>
<form method="post" name="fm">
<table>
<tr>
<th>번호</th>
<td>신규(insert)<input type="hidden" name="rootid" value="<%=rootid%>"></td>
</tr>
<tr>
<th>제목</th>
<td><input type="text" name="title" size="70" maxlength="70"></td>
</tr>
<tr>
<th>일자</th>
<td><%=formattedDate%></td>
</tr>
<tr>
<th>내용</th>
<td><textarea class="textarea" name="content" cols="70" rows="10"></textarea></td>
</tr>
</table>

<div class="button-group">
<input type="button" value="취소" onclick="location.href='gongji_list.jsp'" class="cancel-button">
<input type="button" value="쓰기" onclick="submitForm('write')">
</div>
</form>

</div>
</body>

</html>
