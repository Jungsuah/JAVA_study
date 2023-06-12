3. gongji_view.jsp
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

    .button-group {
        text-align: right;
        width: 650px;
    }

    .container {
        display: flex;
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

int viewcnt = 0;
try{
	viewcnt = Integer.parseInt(request.getParameter("viewcnt"));
}catch (Exception e){
}
viewcnt++;
	
int result = gongjiDao.updatePeopleCount(viewcnt, id);

Gongji gongji = gongjiDao.selectOneGongji(id); // 테이블 생성 메서드 호출하여 오류 여부 확인
gongji.setViewcnt(viewcnt);
gongji.setRootid(id);
int gongjiId = gongji.getId();
String gongjiTitle = gongji.getTitle();
String gongjiDate = gongji.getDate();
String gongjiContent = gongji.getContent();
int updateviewcnt = gongji.getViewcnt();
int rootId = gongji.getRootid();
%>

<body>
<div class="container">
<form method=post name='fm'>
<table width="650" border="1" cellspacing="0" cellpadding="5">
  <tr>
    <td><b>번호</b></td>
    <td colspan="4"><%=gongjiId%></td>
  </tr>
  <tr>
    <td><b>제목</b></td>
    <td colspan="4"><%=gongjiTitle%></td>
  </tr>
  <tr>
    <td><b>일자</b></td>
    <td colspan="4"><%=gongjiDate%></td>
  </tr>
  <tr>
    <td><b>조회수</b></td>
    <td colspan="4"><%=viewcnt%></td>
  </tr>
  <tr>
    <td><b>내용</b></td>
    <td colspan="4"><%=gongjiContent%></td>
  </tr>
  <tr>
    <td><b>원글</b></td>
    <td colspan="4"><%=rootId%></td>
  </tr>
  <tr>
    <td><b>댓글수준</b></td>
    <td><%=gongji.getRelevel()%></td>
    <td><b>댓글내 순서</b></td>
    <td><%=gongji.getRecnt()%></td>
  </tr>
  <tr>
    <td colspan="4" style="border: none; text-align: right;">
      <input type="button" value="목록" class="styled-button" onclick="location.href='gongji_list.jsp?id=<%=gongjiId%>&viewcnt=<%=updateviewcnt%>'">
      <input type="button" value="수정" class="styled-button" onclick="location.href='gongji_update.jsp?id=<%=gongjiId%>&title=<%=gongjiTitle%>&date=<%=gongjiDate%>&content=<%=gongjiContent%>&pageNumber=<%=pageNumber%>'">
      <input type="button" value="삭제" class="styled-button" onclick="location.href='gongji_delete.jsp?id=<%=gongjiId%>'">
      <input type="button" value="댓글" class="styled-button" onclick="location.href='gongji_updateReply.jsp?id=<%=gongjiId%>&title=<%=gongjiTitle%>&date=<%=gongjiDate%>&content=<%=gongjiContent%>&pageNumber=<%=pageNumber%>'">
    </td>
  </tr>
</table>
</form>
</div>
</body>

</html>