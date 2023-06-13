3. gongji_view.jsp
<%@page import="domain.Gongji"%>
<%@page import="dao.GongjiDaoImpl"%>
<%@page import="dao.GongjiDao"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*"%>
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
	  width: 350px;
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
      if(mode=="updateReply"){
         document.fm.action="gongji_updateReply.jsp";
      }else if(mode=="delete"){
         document.fm.action="gongji_delete.jsp";
      }else if(mode=="update"){
         document.fm.action="gongji_update.jsp";
      }
      document.fm.submit();
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
	
int result = gongjiDao.updatePeopleCount(viewcnt, id);

String title = "";
String date = "";
String content =  "";
int rootid = 0;
int relevel = 0;
int recnt = 0;

Gongji gongji = null; // 테이블 생성 메서드 호출하여 오류 여부 확인
try{
	gongji = gongjiDao.selectOneGongji(id);
	id = gongji.getId();
	title = gongji.getTitle();
	date = gongji.getDate();
	viewcnt = gongji.getViewcnt();
	content = gongji.getContent();
	rootid = gongji.getRootid();
	relevel = gongji.getRelevel();
	recnt = gongji.getRecnt();
	viewcnt = gongji.getViewcnt();
}catch(Exception e){
}
%>

<body>
<div class="container">
<form method=post name='fm'>
<table width="650" border="1" cellspacing="0" cellpadding="5">
  <tr>
    <td><b>번호</b></td>
    <td colspan="4"><input type="hidden" name="id" value="<%=id%>"><%=id%></td>
  </tr>
  <tr>
    <td><b>제목</b></td>
    <td colspan="4"><input type="hidden" name="title" value="<%=title%>"><%=title.replaceAll("<", "&lt;").replaceAll(">", "&gt;")%></td>
  </tr>
  <tr>
    <td><b>일자</b></td>
    <td colspan="4"><input type="hidden" name="date" value="<%=date%>"><%=date%></td>
  </tr>
  <tr>
    <td><b>조회수</b></td>
    <td colspan="4"><input type="hidden" name="viewcnt" value="<%=viewcnt%>"><%=viewcnt%></td>
  </tr>
  <tr>
    <td><b>내용</b></td>
    <td colspan="4"><input type="hidden" name="content" value="<%=content%>">
    <textarea name="stockContent" class="textarea" readonly><%=content.replaceAll("<", "&lt;").replaceAll(">", "&gt;")%></textarea>
    </td>
  </tr>
  <tr>
    <td><b>원글</b></td>
    <td colspan="4"><input type="hidden" name="rootId" value="<%=rootid%>"><%=rootid%></td>
  </tr>
  <tr>
    <td><b>댓글수준</b></td>
    <td><input type="hidden" name="rootLevel" value="<%=relevel%>"><%=relevel%></td>
    <td><b>댓글내 순서</b></td>
    <td><input type="hidden" name="recnt" value="<%=recnt%>"><%=recnt%></td>
  </tr>
  <tr>
    <td colspan="4" style="border: none; text-align: right;">
      <input type="button" value="목록" class="styled-button" onclick="location.href='gongji_list.jsp'">
      <input type="button" value="수정" class="styled-button" onclick="submitForm('update')">
		<input type="button" value="삭제" class="styled-button" onclick="submitForm('delete')">
		<input type="button" value="댓글" class="styled-button" onclick="submitForm('updateReply')">
    </td>
  </tr>
</table>
</form>
</div>
</body>

</html>