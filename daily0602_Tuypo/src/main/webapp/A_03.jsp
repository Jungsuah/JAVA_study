<%@page import="kr.ac.kopo.ctc.kopo27.dao.TuypoDaoImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.TuypoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보등록 A_03.jsp</title>
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

h1 {
  margin: 0;
  padding: 0;
  font-size: 24px;
  margin-bottom: 20px;
}

form {
  margin-bottom: 10px;
}

input[type="text"], input[type="submit"] {
  padding: 8px;
  font-size: 14px;
}

input[type="submit"] {
  background-color: #4CAF50;
  color: white;
  border: none;
  cursor: pointer;
}

a {
  text-decoration: none;
}

a:hover {
  font-weight: bold;
}

.actions {
  text-align: center;
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
</head>
<div class="container">
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

TuypoDao tupyoDao = new TuypoDaoImpl(); 

int id = 0;
String sid = request.getParameter("id");
try{
	id = Integer.parseInt(sid);
}catch(Exception e){
}

String name = "";
try{
	name = request.getParameter("name");
}catch(Exception e){
}

int result = tupyoDao.insertHubo(id, name);
%>
<body>

<table cellspacing=3 width=600 border=1>
	<tr>
		<td width=100 bgcolor="yellow"><a href="A_01.jsp">후보등록</a></td>
		<td width=100><a href="B_01.jsp">투표</a></td>
		<td width=100 ><a href="C_01.jsp">개표결과</a></td>
	</tr>
</table>

<%if(result == 1){ %>

<table cellspacing="0" border="0">
	<tr>
		<td width=500><h2><a href="A_01.jsp">후보등록 결과 : <%= id%>번 <%=name %> 후보가 추가되었습니다.</a></h2></td>
		<td width=100><button onclick="location.href='A_01.jsp'">후보 추가등록</button></td>
	</tr>
</table>


<%} else {%>
<table cellspacing="0" border="0">
	<tr>
		<td width=100><h2><a href="A_01.jsp">후보등록 결과 : 후보 추가에 실패하셨습니다.</a></h2></td>
		<td><button onclick="location.href='A_01.jsp'">후보 재등록</button></td>
	</tr>
</table>
<%} %>
</div>
</body>
</html>