<%@page import="kr.ac.kopo.ctc.kopo27.domain.Hubo_Table"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.TuypoDaoImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.TuypoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>B_01.jsp</title>
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

input[type="submit"] {
  padding: 8px;
  font-size: 14px;
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

/* Styling for age select dropdown */
select[name="age"] {
  padding: 8px;
  font-size: 14px;
  width: 100%;
  border-radius: 5px;
}

select[name="id"] {
  padding: 8px;
  font-size: 14px;
  width: 100%;
  border-radius: 5px;
}

</style>

</head>
<body>
<div class="container">
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

TuypoDao tupyoDao = new TuypoDaoImpl(); 
List<Hubo_Table> huboList= tupyoDao.selectAll();

%>
<table cellspacing=3 width=600 border=1>
	<tr>
		<td width=100><a href="A_01.jsp">후보등록</a></td>
		<td width=100 bgcolor="yellow"><a href="B_01.jsp">투표</a></td>
		<td width=100 ><a href="C_01.jsp">개표결과</a></td>
	</tr>
</table>

<h1>투표하기</h1>

<table cellspacing=3 width=600 border=1>
	<tr>
	<form method = "post" action = "B_02.jsp">
		<td width=300><p align = center>
				<select name = id>
		<%for (Hubo_Table hubo : huboList) {%>
					<option value = <%=hubo.getId()%>><%=hubo.getId()%>&nbsp<%=hubo.getName()%>
				<%}%>
				</select>
				</p>
				</td>
			<td width=300><p align = center>
				<select name = age>
					<option value = 1>10대
					<option value = 2>20대
					<option value = 3>30대
					<option value = 4>40대
					<option value = 5>50대
					<option value = 6>60대
					<option value = 7>70대
					<option value = 8>80대
					<option value = 9>90대
				</select>
				</p>
				</td>	
				
				<td>
				<input type = submit value = "투표하기" margin-left=100px;>
				</td>
	</form>
	</tr>
</table>
</div>
</body>
</html>