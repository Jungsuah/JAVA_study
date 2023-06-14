
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
         var title = document.getElementsByName('title')[0].value; // 제목 입력값 가져오기
         var content = document.getElementsByName('content')[0].value; // 내용 입력값 가져오기
         
         if (title.trim().length === 0) {
             alert("제목을 입력해주세요."); // 제목이 비어있을 경우 경고 메시지 출력
             return;
         }
         
         if (content.trim().length === 0) {
             alert("내용을 입력해주세요."); // 내용이 비어있을 경우 경고 메시지 출력
             return;
         }
         
         fm.action = "gongji_write.jsp"; // 폼의 action을 "gongji_write.jsp"로 설정
         fm.submit(); // 폼 제출
      } else if (mode == "delete") {
         fm.action = "gongji_delete.jsp"; // 폼의 action을 "gongji_delete.jsp"로 설정
         fm.submit(); // 폼 제출
      }
   }
</script>
<%
request.setCharacterEncoding("UTF-8"); // 요청 데이터의 문자 인코딩을 UTF-8로 설정
response.setCharacterEncoding("UTF-8"); // 응답 데이터의 문자 인코딩을 UTF-8로 설정

int id = 0;
try{
	id = Integer.parseInt(request.getParameter("id")); // 요청 파라미터 "id"를 정수로 변환하여 변수에 할당
}catch(Exception e){
}

int rootId = 0;
try{
	rootId = Integer.parseInt(request.getParameter("rootId")); // 요청 파라미터 "rootId"를 정수로 변환하여 변수에 할당
}catch(Exception e){
}

String title = "";
try{
	title = request.getParameter("title"); // 요청 파라미터 "title"을 문자열로 가져와 변수에 할당
}catch(Exception e){
}

String content = "";
try{
	content = request.getParameter("content"); // 요청 파라미터 "content"를 문자열로 가져와 변수에 할당
}catch(Exception e){
}
%>

<body>
<div class="container">
<form method="post" name="fm" >
  <table width="650" border="1" cellspacing="0" cellpadding="5">
    <tr>
      <td><b>번호</b></td>
      <td><input type="hidden" name="rootId" value="<%=rootId%>"><input type="text" name="id" size="70" value="<%=id%>" readonly></td> <!-- 숨겨진 필드(rootId)와 읽기 전용 필드(id)를 생성 -->
    </tr>
    <tr>
      <td><b>제목</b></td>
      <td><input type="text" name="title" size="70" maxlength="70" value="<%=title%>"></td> <!-- 제목을 입력받는 필드 -->
    </tr>
    <tr>
	  <td><b>일자</b></td>
	  <td><input type="hidden" name="date" value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())%>">
	  <%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %></td> <!-- 숨겨진 필드(date)와 현재 날짜를 출력하는 필드 -->
	</tr>
    <tr>
      <td><b>내용</b></td>
      <td><textarea class="textarea" name="content" cols="70" rows="10"><%=content%></textarea></td> <!-- 내용을 입력받는 텍스트 영역 -->
    </tr>
    <tr>
      <td colspan="3" style="border: none; text-align: right;">
        <input type="button" value="취소" onclick="location.href='gongji_list.jsp'" class="cancel-button"> <!-- 취소 버튼 -->
        <input type="button" value="쓰기" onclick="submitForm('write')" class="cancel-button"> <!-- 쓰기 버튼 -->
        <input type="button" value="삭제" onclick="submitForm('delete')" class="cancel-button"> <!-- 삭제 버튼 -->
      </td>
    </tr>
  </table>
</form>
</div>
</body>
</html>
