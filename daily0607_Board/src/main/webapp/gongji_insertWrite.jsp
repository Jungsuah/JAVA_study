5. gongji_insertWrite.jsp
<%@page import="domain.Gongji"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="dao.GongjiDaoImpl"%>
<%@page import="dao.GongjiDao"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head>
<meta charset="UTF-8">
<title>5. gongji_insertWrite.jsp</title>
<style>
    table {
        border-collapse: collapse;
        width: 850px;
        background: linear-gradient(to bottom, #e2e2e2, #f1f1f1);
    }
    
    th, td {
        text-align: center;
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
</head>
<body>
<% 
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

String title = "";
try{
	title = request.getParameter("title");
}catch(Exception e){
}

String content = "";
try{
	content = request.getParameter("content");
}catch(Exception e){
}

GongjiDao gongjiDao = new GongjiDaoImpl(); // GongjiDaoImpl 객체 생성
int result = gongjiDao.insertGongji(title,content);

Gongji gongji = gongjiDao.newGongji();
int newid = gongji.getId();
%>
<form method="post" name="fm">
  <table width="850" border="1" cellspacing="0" cellpadding="5">
    <tr>
      <td colspan="3" align="center">
        <h2><b>게시글 등록 성공</b></h2>
      </td>
       <td align="center">
        <input type="button" value="목록보기" onclick="location.href='gongji_list.jsp'">
      </td>
       <td align="center">
        <input type="button" value="등록된 게시글 보러가기" onclick="location.href='gongji_view.jsp?id=<%=newid%>'">
      </td>
    </tr>
  </table>
</form>
</body>
</html>