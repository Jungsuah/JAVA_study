<%@page import="kr.ac.kopo.ctc.kopo27.dao.TuypoDaoImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.TuypoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>B_02.jsp</title>
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

button {
  padding: 8px 12px;
  font-size: 14px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

a {
  text-decoration: none;
}

a:hover {
  font-weight: bold;
}

</style>
</head>
<body>
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

int age = 0;
String sage = request.getParameter("age");
try{
	age = Integer.parseInt(sage);
}catch(Exception e){
}

int result = tupyoDao.insertTuypo(id, age);

%>

<table cellspacing=3 width=600 border=1>
	<tr>
		<td width=100><a href="A_01.jsp">후보등록</a></td>
		<td width=100 bgcolor="yellow"><a href="B_01.jsp">투표</a></td>
		<td width=100 ><a href="C_01.jsp">개표결과</a></td>
	</tr>
</table>

<%if(result == 1){ %>
<table cellspacing=3 width=600 border=1>
	<tr>
		<td width=350><h3>투표 결과 : <%= id%>번 후보를 투표 하셨습니다.</a></h3></td>
		<td width=97 ><button onclick="location.href='B_01.jsp'">다시 투표하러가기</button></td>
	</tr>
</table>


<%} else {%>
<table cellspacing=3 width=600 border=1>
	<tr>
		<td width=350><h2><a href="B_01.jsp">투표 결과 : 투표하기가 실패 되었습니다.</a></h2></td>
		<td width=97 ><button onclick="location.href='B_01.jsp'">다시 투표하러가기</button></td>
	</tr>
</table>
<%} %>
</div>
</body>
</html>