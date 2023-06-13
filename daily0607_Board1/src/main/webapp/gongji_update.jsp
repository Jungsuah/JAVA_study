<%@page import="dao.GongjiDaoImpl"%>
<%@page import="dao.GongjiDao"%>
<%@page import="domain.Gongji"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*"%>
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

    .button-group {
        text-align: right;
        width: 650px;
        margin-top:7px;
    }

    .container {
        display: flex;
        height: 100vh;
    }
    
     .textarea {
        width: 500px;
        height: 100px;
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
      if (mode == "write") {
    	  var title = document.getElementsByName('title')[0].value;
    	  var content = document.getElementsByName('content')[0].value;
         
         if (title.trim().length === 0) {
             alert("제목을 입력해주세요.");
             return;
         }
         
         if (content.trim().length === 0) {
             alert("내용을 입력해주세요.");
             return;
         }
         
         fm.action = "gongji_write.jsp";
         fm.submit();
      } else if (mode == "delete") {
         fm.action = "gongji_delete.jsp";
         fm.submit();
      }
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

String title = "";
try{
	title = request.getParameter("title");
}catch(Exception e){
}

String date ="";
try{
	date = request.getParameter("date");
}catch(Exception e){
}

String content = "";
try{
	content = request.getParameter("content");
}catch(Exception e){
}

int pageNumber = 0;
try{
	pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
}catch(Exception e){
}

Gongji gongji = new Gongji();
gongji.setId(id);
gongji.setTitle(title);
gongji.setDate(date);
gongji.setTitle(title);

GongjiDao gongjiDao = new GongjiDaoImpl(); // GongjiDaoImpl 객체 생성
int result = gongjiDao.updateGongji(gongji);
%>

<body>
<div class="container">
<form method="post" name="fm">
<table>
<tr>
<th>번호</th>
<td><input type="hidden" name="pageNumber" value="<%=pageNumber%>"><input type="text" name="id" size="70" value="<%=id%>" readonly></td>
</tr>
<tr>
<th>제목</th>
<td><input type="text" name="title" size="70" maxlength="70" value="<%=title%>"></td>
</tr>
<tr>
<th>일자</th>
<td><%=date%></td>
</tr>
<tr>
<th>내용</th>
<td><textarea name="content" class="textarea" cols="70" rows="10"><%=content%></textarea></td>
</tr>
</table>
<div class="button-group">
<input type="button" value="취소" onclick="location.href='gongji_list.jsp'" class="cancel-button">
<input type="button" value="쓰기" onclick="submitForm('write')">
<input type="button" value="삭제" onclick="submitForm('delete')">
</div>
</form>
</div>
</body>

</html>
