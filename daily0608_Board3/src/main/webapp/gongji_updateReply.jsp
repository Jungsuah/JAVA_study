
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
         
         // 작은따옴표(')가 제목에 포함되어 있는지 확인
         if (title.includes("'")) {
   	      alert("제목에는 작은따옴표를 입력할 수 없습니다.");
   	      return;
   	   }
   	   
   	   // 작은따옴표(')가 내용에 포함되어 있는지 확인
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

// 요청과 응답의 문자 인코딩을 UTF-8로 설정합니다.
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

int rootId = 0;
try {
    // "rootId" 파라미터 값을 정수로 변환합니다.
    rootId = Integer.parseInt(request.getParameter("rootId"));
} catch (Exception e) {
    // 변환 중 오류가 발생하면 예외를 처리합니다.
}

int rootLevel = 0;
try {
    // "rootLevel" 파라미터 값을 정수로 변환합니다.
    rootLevel = Integer.parseInt(request.getParameter("rootLevel"));
} catch (Exception e) {
    // 변환 중 오류가 발생하면 예외를 처리합니다.
}

int recnt = 0;
try {
    // "recnt" 파라미터 값을 정수로 변환합니다.
    recnt = Integer.parseInt(request.getParameter("recnt"));
} catch (Exception e) {
    // 변환 중 오류가 발생하면 예외를 처리합니다.
}

GongjiDao gongji = new GongjiDaoImpl();

// gongji.getMiddleRecnt 메서드를 호출하여 중간 값 recnt를 가져옵니다.
recnt = gongji.getMiddleRecnt(rootId, rootLevel, recnt);

// 가져온 중간 값 recnt가 0인 경우, gongji.getMaxRecnt 메서드를 호출하여 최대 recnt 값을 가져옵니다.
if (recnt == 0) {
    recnt = gongji.getMaxRecnt(rootId);
}
%>

<body>
<div class="container">
<form method="post" name="fm">
<table width="650" border="1" cellspacing="0" cellpadding="5">
  <tr>
    <td><b>번호</b></td>
    <td colspan="3">댓글<input type="text" name="id" size="70" value="INSERT" readonly></td> <!-- 번호 필드: 댓글 -->
  </tr>
  <tr>
    <td><b>제목</b></td>
    <td colspan="3"><input type="text" name="title" size="70" maxlength="70"></td> <!-- 제목 필드 -->
  </tr>
  <tr>
    <td><b>일자</b></td>
    <td colspan="3"><%=formattedDate%></td> <!-- 현재 날짜 표시 -->
  </tr>
  <tr>
    <td><b>내용</b></td>
    <td colspan="3"><textarea class="textarea" style="width:500px; height:250px;" name="content" cols="70" rows="600"></textarea></td> <!-- 내용 입력란 -->
  </tr>
  <tr>
    <td><b>원글</b></td>
    <td colspan="3"><input type="hidden" name="rootId" value="<%=rootId%>"><%=rootId%></td> <!-- 원글 ID 히든 필드 -->
  </tr>
  <tr>
    <td><b>댓글수준</b></td>
    <td><input type="hidden" name="rootLevel" value="<%=rootLevel+1%>"><%=rootLevel+1%></td> <!-- 댓글 수준 히든 필드 -->
    <td><b>댓글내 순서</b></td>
    <td><input type="hidden" name="rootCnt" value="<%=recnt%>"><%=recnt%></td> <!-- 댓글 순서 히든 필드 -->
  </tr>
  <tr>
    <td colspan="4" style="border: none; text-align: right;">
      <input type="button" value="취소" onclick="location.href='gongji_list.jsp'" class="cancel-button"> <!-- 취소 버튼 -->
      <input type="button" value="쓰기" onclick="submitForm('write')" class="cancel-button"> <!-- 쓰기 버튼 -->
    </td>
  </tr>
</table>
</form>
</div>
</body>
</html>