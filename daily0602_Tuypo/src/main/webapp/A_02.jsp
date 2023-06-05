<%@page import="kr.ac.kopo.ctc.kopo27.domain.Hubo_Table"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.TuypoDaoImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.TuypoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보등록 A_02.jsp</title>
<style>
body {
  font-family: Arial, sans-serif;
  background-color: #f2f2f2;
  margin: 0;
  padding: 0;
}

.container {
  width: 800px;
  margin: 20px auto;
  background-color: #fff;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 5px;
}

table {
  width: 100%;
  border-collapse: collapse;
}

table, th, td {
  border: 1px solid #ddd;
  padding: 10px;
}

th {
  background-color: #f2f2f2;
}

h2, h3 {
  margin: 0;
  padding: 0;
}

a {
  text-decoration: none;
}

a:hover {
  font-weight: bold;
}

</style>
<script>
function goBack() {
  window.history.back();
}
</script>
</head>
<body>

<div class="container">

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
//요청과 응답의 인코딩 설정

TuypoDao tupyoDao = new TuypoDaoImpl(); //tupyoDao를 임포트한다

int id = 0;
String sid = request.getParameter("id");//id값을 넘겨받고 문자열에 저장
 if (sid != null && !sid.isEmpty()) {
	 id = Integer.parseInt(sid);//값이 null이 아니고 있다면 int로 형변환하여 저장
 }
 
int result = tupyoDao.deleteById(id);//id값으로 삭제하는 메소드 실행
%>

<table cellspacing="0" border="0">
	<tr>
		<td bgcolor="yellow"><a href="A_01.jsp">후보등록</a></td>
		<td><a href="B_01.jsp">투표</a></td>
		<td><a href="C_01.jsp">개표결과</a></td>
	</tr>
</table>

<%if(result == 1){ %><!-- id로 투표가 삭제가 되었다면 -->

<table cellspacing="0" border="0">
	<tr>
		<td><h2><a href="A_01.jsp">후보등록 결과: <%= id%>번 후보가 삭제되었습니다.</a></h2></td><!-- 몇번째 id값의 후보가 삭제되었는지 출력-->
		<td><button onclick="location.href='A_01.jsp'">후보 재등록</button></td><!-- 재등록 버튼 생성-->
	</tr>
</table>

<%} else {%><!-- id로 투표가 삭제가 되지않았다면 -->
<table cellspacing="0" border="0">
	<tr>
		<td><h2><a href="A_01.jsp">후보등록 결과: 후보가 실패되었습니다.</a></h2></td><!-- 후보등록 결과 출력-->
		<td><button onclick="location.href='A_01.jsp'">후보 재등록</button></td><!-- 재등록 버튼 생성-->
	</tr>
</table>
<%} %>
</div>
</body>
</html>