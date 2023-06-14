
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
         document.fm.action="gongji_updateReply.jsp"; // 설정된 mode가 'updateReply'일 경우 gongji_updateReply.jsp로 전송할 form action 설정
      }else if(mode=="delete"){
         document.fm.action="gongji_delete.jsp"; // 설정된 mode가 'delete'일 경우 gongji_delete.jsp로 전송할 form action 설정
      }else if(mode=="update"){
         document.fm.action="gongji_update.jsp"; // 설정된 mode가 'update'일 경우 gongji_update.jsp로 전송할 form action 설정
      }
      document.fm.submit(); // form 전송
   }
</script>
</head>

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

GongjiDao gongjiDao = new GongjiDaoImpl(); // GongjiDaoImpl 객체 생성

int id = 0;
try{
	id = Integer.parseInt(request.getParameter("id")); // id 파라미터를 정수형으로 변환하여 저장
}catch(Exception e){
}

int pageNumber = 0;
try{
	pageNumber = Integer.parseInt(request.getParameter("pageNumber")); // pageNumber 파라미터를 정수형으로 변환하여 저장
}catch(Exception e){
}

int viewcnt = 0;
try{
	viewcnt = Integer.parseInt(request.getParameter("viewcnt")); // viewcnt 파라미터를 정수형으로 변환하여 저장
}catch (Exception e){
}
	
int result = gongjiDao.updatePeopleCount(viewcnt, id); // viewcnt와 id를 이용하여 gongjiDao의 updatePeopleCount 메서드 호출

String title = "";
String date = "";
String content =  "";
int rootid = 0;
int relevel = 0;
int recnt = 0;

Gongji gongji = null; // Gongji 객체 초기화
try{
	gongji = gongjiDao.selectOneGongji(id); // id에 해당하는 공지사항 레코드를 가져와서 Gongji 객체에 저장
	id = gongji.getId(); // 공지사항 ID
	title = gongji.getTitle(); // 공지사항 제목
	date = gongji.getDate(); // 공지사항 날짜
	viewcnt = gongji.getViewcnt(); // 공지사항 조회수
	content = gongji.getContent(); // 공지사항 내용
	rootid = gongji.getRootid(); // 루트 ID
	relevel = gongji.getRelevel(); // 댓글 수준
	recnt = gongji.getRecnt(); // 댓글 내 순서
	viewcnt = gongji.getViewcnt(); // 조회수
}catch(Exception e){
}
%>

<body>
<div class="container">
<form method=post name='fm'>
<table width="650" border="1" cellspacing="0" cellpadding="5">
  <tr>
    <td><b>번호</b></td><!-- 번호 출력 -->
    <td colspan="4"><input type="hidden" name="id" value="<%=id%>"><%=id%></td>
  </tr>
  <tr>
    <td><b>제목</b></td><!-- 제목 출력 -->
    <td colspan="4"><input type="hidden" name="title" value="<%=title%>"><%=title.replaceAll("<", "&lt;").replaceAll(">", "&gt;")%></td>
  </tr>
  <tr>
    <td><b>일자</b></td><!-- 일자 출력 -->
    <td colspan="4"><input type="hidden" name="date" value="<%=date%>"><%=date%></td>
  </tr>
  <tr>
    <td><b>조회수</b></td><!-- 조회수 출력 -->
    <td colspan="4"><input type="hidden" name="viewcnt" value="<%=viewcnt%>"><%=viewcnt%></td>
  </tr>
  <tr>
    <td><b>내용</b></td><!-- 내용 출력 -->
    <td colspan="4"><input type="hidden" name="content" value="<%=content%>">
    <textarea name="stockContent" class="textarea" readonly><%=content.replaceAll("<", "&lt;").replaceAll(">", "&gt;")%></textarea>
    </td>
  </tr>
  <tr>
    <td><b>원글</b></td><!-- 원글 출력 -->
    <td colspan="4"><input type="hidden" name="rootId" value="<%=rootid%>"><%=rootid%></td>
  </tr>
  <tr>
    <td><b>댓글수준</b></td><!-- 댓글수준 출력 -->
    <td><input type="hidden" name="rootLevel" value="<%=relevel%>"><%=relevel%></td>
    <td><b>댓글내 순서</b></td><!-- 댓글내 순서 출력 -->
    <td><input type="hidden" name="recnt" value="<%=recnt%>"><%=recnt%></td>
  </tr>
  <tr>
    <td colspan="4" style="border: none; text-align: right;">
      <input type="button" value="목록" class="styled-button" onclick="location.href='gongji_list.jsp'"><!-- 목록 출력 -->
      <input type="button" value="수정" class="styled-button" onclick="submitForm('update')"><!-- 수정 출력 -->
		<input type="button" value="삭제" class="styled-button" onclick="submitForm('delete')"><!-- 삭제 출력 -->
		<input type="button" value="댓글" class="styled-button" onclick="submitForm('updateReply')"><!-- 댓글 출력 -->
    </td>
  </tr>
</table>
</form>
</div>
</body>

</html>