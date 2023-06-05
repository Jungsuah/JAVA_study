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

.actions {
  margin-top: 20px;
}

.actions a {
  margin-right: 10px;
  padding: 8px 12px;
  background-color: #4CAF50;
  color: white;
  border-radius: 5px;
}

.actions a:hover {
  background-color: #45a049;
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

TuypoDao tupyoDao = new TuypoDaoImpl(); 

int id = 0;
String sid = request.getParameter("id");
 if (sid != null && !sid.isEmpty()) {
	 id = Integer.parseInt(sid);
 }
 
int result = tupyoDao.deleteById(id);
%>

<table cellspacing="0" border="0">
	<tr>
		<td bgcolor="yellow"><a href="A_01.jsp">후보등록</a></td>
		<td><a href="B_01.jsp">투표</a></td>
		<td><a href="C_01.jsp">개표결과</a></td>
	</tr>
</table>

<%if(result == 1){ %>

<table cellspacing="0" border="0">
	<tr>
		<td><h2><a href="A_01.jsp">후보등록 결과: <%= id%>번 후보가 삭제되었습니다.</a></h2></td>
		<td><button onclick="location.href='A_01.jsp'">후보 재등록</button></td>
	</tr>
</table>


<%} else {%>
<table cellspacing="0" border="0">
	<tr>
		<td><h2><a href="A_01.jsp">후보등록 결과: 후보가 실패되었습니다.</a></h2></td>
		<td><button onclick="location.href='A_01.jsp'">후보 재등록</button></td>
	</tr>
</table>
<%} %>
</div>
</body>
</html>