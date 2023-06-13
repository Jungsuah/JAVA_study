4. gongji_updateReply.jsp
<%@page import="domain.Gongji"%>
<%@page import="dao.GongjiDaoImpl"%>
<%@page import="dao.GongjiDao"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
    }

    .container {
        display: flex;
        height: 100vh;
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
      if (mode == "write") {
         var title = document.getElementsByName('title')[0].value;
         var content = document.getElementsByName('content')[0].value;
         
       if (title.includes("'")) {
   	      alert("제목에는 작은따옴표를 입력할 수 없습니다.");
   	      return;
   	   }
   	   
   	   if (content.includes("'")) {
   	      alert("내용에는 작은따옴표를 입력할 수 없습니다.");
   	      return;
   	   }
      
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
Date currentDate = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
String formattedDate = sdf.format(currentDate);
      
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

int rootId = 0;
try{
	rootId = Integer.parseInt(request.getParameter("rootId"));
}catch(Exception e){
}

int rootLevel = 0;
try{
	rootLevel = Integer.parseInt(request.getParameter("rootLevel"));
}catch(Exception e){
}

int recnt = 0;
try{
	recnt = Integer.parseInt(request.getParameter("recnt"));
}catch(Exception e){
}

GongjiDao gongji = new GongjiDaoImpl();
recnt = gongji.getMiddleRecnt(rootId, rootLevel, recnt);
if(recnt == 0){
	recnt = gongji.getMaxRecnt(rootId);
}
%>

<body>
<div class="container">
<form method=post name='fm'>
<table width="650" border="1" cellspacing="0" cellpadding="5">
  <tr>
    <td><b>번호</b></td>
    <td colspan="3">댓글<input type="text" name="id" size="70" value="INSERT" readonly></td>
  </tr>
  <tr>
    <td><b>제목</b></td>
    <td colspan="3"><input type="text" name="title" size="70" maxlength="70"></td>
  </tr>
  <tr>
    <td><b>일자</b></td>
    <td colspan="3"><%=formattedDate%></td>
  </tr>
  <tr>
    <td><b>내용</b></td>
    <td colspan="3"><textarea class="textarea" style="width:500px; height:250px;" name="content" cols="70" rows="600"></textarea></td>
  </tr>
  <tr>
    <td><b>원글</b></td>
    <td colspan="3"><input type="hidden" name="rootId" value="<%=rootId%>"><%=rootId%></td>
  </tr>
  <tr>
    <td><b>댓글수준</b></td>
    <td><input type="hidden" name="rootLevel" value="<%=rootLevel+1%>"><%=rootLevel+1%></td>
    <td><b>댓글내 순서</b></td>
    <td><input type="hidden" name="rootCnt" value="<%=recnt%>"><%=recnt%></td>
  </tr>
  <tr>
    <td colspan="4" style="border: none; text-align: right;">
      <input type="button" value="취소" onclick="location.href='gongji_list.jsp'" class="cancel-button">
      <input type="button" value="쓰기" onclick="submitForm('write')" class="cancel-button">
    </td>
  </tr>
</table>
</form>
</div>
</body>

</html>