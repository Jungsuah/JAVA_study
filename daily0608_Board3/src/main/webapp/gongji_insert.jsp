<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="domain.Gongji"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="dao.GongjiDaoImpl"%>
<%@page import="dao.GongjiDao"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<html>
<head>
<style>
    body {
        font-family: Arial, sans-serif; /* 설정된 글꼴과 fallback 글꼴 지정 */
        background-color: #f1f8ff; /* 배경 색상 지정 */
    }

    table {
        width: 650px; /* 테이블 너비 설정 */
        border-collapse: collapse; /* 테이블 셀 경계 설정 */
        margin-top: 20px; /* 위쪽 여백 지정 */
        background-color: white; /* 테이블 배경 색상 지정 */
    }

    th, td {
        padding: 10px; /* 셀 안쪽 여백 지정 */
        text-align: left; /* 텍스트 정렬 방식 지정 */
        border-bottom: 1px solid #ddd; /* 아래쪽 테두리 지정 */
    }

    th {
        background-color: #8ec5e3; /* 헤더 셀 배경 색상 지정 */
        color: white; /* 헤더 셀 글자 색상 지정 */
    }

    input[type="text"], textarea {
        width: 500px; /* 입력 필드 너비 설정 */
        padding: 8px; /* 입력 필드 안쪽 여백 지정 */
        border: 1px solid #ddd; /* 입력 필드 테두리 지정 */
        border-radius: 4px; /* 입력 필드 테두리 둥글기 설정 */
        resize: vertical; /* textarea의 크기 조절 여부 지정 */
    }

    input[type="button"] {
        background-color: #007bff; /* 버튼 배경 색상 지정 */
        color: white; /* 버튼 글자 색상 지정 */
        padding: 10px 20px; /* 버튼 안쪽 여백 지정 */
        border: none; /* 버튼 테두리 제거 */
        cursor: pointer; /* 마우스 커서 스타일 지정 */
        border-radius: 4px; /* 버튼 테두리 둥글기 설정 */
        margin-right: 10px; /* 오른쪽 여백 지정 */
    }

    input[type="button"]:hover {
        background-color: #0056b3; /* 버튼 호버 상태 배경 색상 지정 */
    }

    .cancel-button {
        background-color: #dc3545; /* 취소 버튼 배경 색상 지정 */
    }

    .cancel-button:hover {
        background-color: #a71d2a; /* 취소 버튼 호버 상태 배경 색상 지정 */
    }

    .container {
        display: flex; /* 컨테이너 요소를 플렉스 박스로 설정 */
        height: 100vh; /* 컨테이너의 높이를 뷰포트의 100%로 설정 */
    }

    .button-group {
        text-align: right; /* 버튼 그룹을 오른쪽 정렬 */
        width: 650px; /* 버튼 그룹 너비 설정 */
        margin-top: 5px; /* 위쪽 여백 지정 */
    }

    .textarea {
        width: 500px; /* 텍스트 영역 너비 설정 */
        height: 200px; /* 텍스트 영역 높이 설정 */
        padding: 10px; /* 텍스트 영역 안쪽 여백 지정 */
        font-family: Arial, sans-serif; /* 설정된 글꼴과 fallback 글꼴 지정 */
        font-size: 14px; /* 글꼴 크기 설정 */
        border: 1px solid #ddd; /* 텍스트 영역 테두리 지정 */
        border-radius: 4px; /* 텍스트 영역 테두리 둥글기 설정 */
        resize: none; /* 텍스트 영역의 크기 조절 여부 지정 */
    }
</style>


<script language="JavaScript">
function submitForm(mode) {
   var title = document.forms["fm"]["title"].value; // 제목 입력 필드의 값 가져오기
   var content = document.forms["fm"]["content"].value; // 내용 입력 필드의 값 가져오기
   
   if (title.includes("'")) { // 제목에 작은따옴표가 포함되어 있는지 확인
	      alert("제목에는 작은따옴표를 입력할 수 없습니다."); // 작은따옴표가 포함된 경우 알림 표시
	      return; // 함수 종료
	   }
	   
	   if (content.includes("'")) { // 내용에 작은따옴표가 포함되어 있는지 확인
	      alert("내용에는 작은따옴표를 입력할 수 없습니다."); // 작은따옴표가 포함된 경우 알림 표시
	      return; // 함수 종료
	   }
   
   if (title.trim() === "") { // 제목이 공백 문자로만 이루어져 있는지 확인
      alert("제목은 필수 입력 항목입니다."); // 공백 문자로만 이루어진 경우 알림 표시
      return; // 함수 종료
   }
   
   if (content.trim() === "") { // 내용이 공백 문자로만 이루어져 있는지 확인
      alert("내용은 필수 입력 항목입니다."); // 공백 문자로만 이루어진 경우 알림 표시
      return; // 함수 종료
   }
   
   fm.action = "gongji_insertWrite.jsp"; // 폼의 전송 대상 페이지 지정
   fm.submit(); // 폼 전송
}
</script>

</head>
<body>
<div class="container">
<%
  Date currentDate = new Date(); // 현재 날짜 가져오기
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 날짜 형식 지정
  String formattedDate = sdf.format(currentDate); // 형식에 맞게 날짜를 문자열로 변환
  
  int rootid = 0;
  try{
  	rootid = Integer.parseInt(request.getParameter("rootid")); // rootid 파라미터 가져오기
  }catch(Exception e){
  }
  
%>
<form method="post" name="fm"> <!-- 폼 시작 -->
<table>
<tr>
<th>번호</th>
<td>신규(insert)<input type="hidden" name="rootid" value="<%=rootid%>"></td> <!-- rootid 파라미터 전달 -->
</tr>
<tr>
<th>제목</th>
<td><input type="text" name="title" size="70" maxlength="70"></td> <!-- 제목 입력 필드 -->
</tr>
<tr>
<th>일자</th>
<td><%=formattedDate%></td> <!-- 현재 날짜 출력 -->
</tr>
<tr>
<th>내용</th>
<td><textarea class="textarea" name="content" cols="70" rows="10"></textarea></td> <!-- 내용 입력 필드 -->
</tr>
</table>

<div class="button-group">
<input type="button" value="취소" onclick="location.href='gongji_list.jsp'" class="cancel-button"> <!-- 취소 버튼 -->
<input type="button" value="쓰기" onclick="submitForm('write')"> <!-- 쓰기 버튼 -->
</div>
</form> <!-- 폼 종료 -->

</div>
</body>

</html>
