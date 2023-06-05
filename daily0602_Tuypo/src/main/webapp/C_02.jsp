<%@page import="kr.ac.kopo.ctc.kopo27.domain.VotingResult"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.TuypoDaoImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.TuypoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>C_02.jsp</title>
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
}

a {
  text-decoration: none;
}

a:hover {
  font-weight: bold;
}

p {
  margin: 0;
  padding: 0;
}

img {
  vertical-align: middle;
}

.button-container {
  text-align: center;
  margin-top: 10px;
}

.button-container button {
  padding: 10px 20px;
  background-color: #4caf50;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.button-container button:hover {
  background-color: #45a049;
}

</style>
<script>
function goBack() {
  history.go(-1);
}
</script>
</head>
<body>
<div class="container">
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

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

TuypoDao tupyoDao = new TuypoDaoImpl(); 
List<VotingResult> votingResult = tupyoDao.getVotingResultsAge(id);

if (votingResult != null) {
%>
<table cellspacing=3 width=600 border=1>
	<tr>
		<td width=100><a href="A_01.jsp">후보등록</a></td>
		<td width=100><a href="B_01.jsp">투표</a></td>
		<td width=100 bgcolor="yellow" ><a href="C_01.jsp">개표결과</a></td>
	</tr>
</table>



<table cellspacing=1 width=600 border=0>
            <tr>
                <td width=500><h1>[<%=name%>] 후보 득표 성향 </h1></td>
                <td width=300 ><button style = 'margin-left:100px;' onclick="goBack()">뒤로가기</button></td>
            </tr>
      </table>

<table cellspacing=3 width=600 border=1>

	<tr>
		<td width=75><p align=center>연령대</p></td>
		<td width=500><p align=center>인기도</p></td>
	</tr>
	 <% for (VotingResult result : votingResult) { %>
	<tr>
		<td width=75><p align=center><%=result.getAgeGroup()%>대</p></td>
		<td width=500><p align=left><img src='막대기.jpg' width=<%=result.getVotePercentage()%> height=20 >&nbsp<%=result.getVoteCount()%>&nbsp&nbsp(<%=result.getVotePercentage()%>%)</p></td>
	</tr>
	<%}%>
	
</table>
	<%}%>
</div>
</body>
</html>