<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*"%>
<%@page import="domain.Gongji"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="dao.GongjiDaoImpl"%>
<%@page import="dao.GongjiDao"%>
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
        if(mode=="write"){
           fm.action="gongji_update.jsp";
        }
        fm.submit();
     }
  </script>
</head>

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

GongjiDao gongjiDao = new GongjiDaoImpl();
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

Gongji gongji = gongjiDao.selectOneGongji(id);
int gongjiId = gongji.getId();
String gongjiTitle = gongji.getTitle();
String gongjiDate = gongji.getDate();
String gongjiContent = gongji.getContent();
int updateviewcnt = gongji.getViewcnt();
%>

<body>
<div class="container">
  <form method="post" name="fm">
    <table class="styled-table">
  <tr>
    <td width="100"><b>번호</b></td>
    <td><input type ="hidden" name="id" value="<%=gongjiId%>"><%=gongjiId%></td>
  </tr>
  <tr>
    <td width="100"><b>제목</b></td>
    <td>
      <input type="text" name="title" value="<%= gongjiTitle.replaceAll("<", "&lt;").replaceAll(">", "&gt;") %>" maxlength="70" size="70" readonly>
    </td>
  </tr>
  <tr>
    <td width="100"><b>일자</b></td>
    <td><input type ="hidden" name="date" value="<%=gongjiDate%>"><%=gongjiDate%></td>
  </tr>
  <tr>
    <td width="100"><b>내용</b></td>
    <td><textarea name="content" class="textarea" cols="60" rows="5" readonly><%=gongjiContent%></textarea></td>
  </tr>
  <tr>
    <td colspan="2" align="center" style="border: none; text-align: right;">
      <input type="button" value="목록" onclick="location.href='gongji_list.jsp?id=<%=gongjiId%>&viewcnt=<%=updateviewcnt%>'" class="styled-button">
      <input type="button" value="수정" onclick="submitForm('write')" class="styled-button">
    </td>
  </tr>
</table>
  </form>
</div>


  
</body>
</html>
