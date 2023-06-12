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

    .styled-table {
        width: 650px;
        border-collapse: collapse;
        margin-top: 20px;
        background-color: white;
    }

    .styled-table td, .styled-table th {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    .styled-table th {
        background-color: #8ec5e3;
        color: white;
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

    .container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
</style>

<script language="JavaScript">
   function submitForm(mode) {
      if(mode=="write"){
         fm.action="gongji_write.jsp";
      }else if(mode=="delete"){
         fm.action="gongji_delete.jsp";
      }
      fm.submit();
   }
</script>
</head>

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

GongjiDao gongjiDao = new GongjiDaoImpl(); // StudentScoreDaoImpl 객체 생성

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

Gongji gongji = gongjiDao.selectOneGongji(id); // 테이블 생성 메서드 호출하여 오류 여부 확인
int gongjiId = gongji.getId();
String gongjiTitle = gongji.getTitle();
String gongjiDate = gongji.getDate();
String gongjiContent = gongji.getContent();
int updateviewcnt = gongji.getViewcnt();
%>
<div class="container">
<body>
  <form method="post" name="fm">
    <table class="styled-table">
      <tr>
        <td><b>번호</b></td>
        <td><%=gongjiId%></td>
      </tr>
      <tr>
        <td><b>제목</b></td>
        <td><%=gongjiTitle%></td>
      </tr>
      <tr>
        <td><b>일자</b></td>
        <td><%=gongjiDate%></td>
      </tr>
      <tr>
        <td><b>내용</b></td>
        <td><%=gongjiContent%></td>
      </tr>
    </table>
    <table>
      <tr>
        <td></td>
        <td>
          <input style="margin-left:500px" type="button" value="목록"  onclick="location.href='gongji_list.jsp?id=<%=gongjiId%>&viewcnt=<%=updateviewcnt%>'">
        </td>
        <td>
          <input type="button" value="수정"  onclick="location.href='gongji_update.jsp?id=<%=gongjiId%>&title=<%=gongjiTitle%>&date=<%=gongjiDate%>&content=<%=gongjiContent%>&pageNumber=<%=pageNumber%>'">
        </td>
      </tr>
    </table>
  </form>
  </div>
</body>
</html>
