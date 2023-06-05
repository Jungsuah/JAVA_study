<%@page import="kr.ac.kopo.ctc.kopo27.domain.VotingResult"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.TuypoDaoImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.TuypoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>C_01.jsp</title>
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
  color : red;
}

p {
  margin: 0;
  padding: 0;
}

img {
  vertical-align: middle;
}

</style>
</head>
<body>

<div class="container">

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

TuypoDao tupyoDao = new TuypoDaoImpl(); 
List<VotingResult> votingResult = tupyoDao.getVotingResultsHubo();

if (votingResult != null) {
%>
<table cellspacing=3 width=600 border=1>
    <tr>
        <td width=100><a href="A_01.jsp">후보등록</a></td>
        <td width=100><a href="B_01.jsp">투표</a></td>
        <td width=100 bgcolor="yellow" ><a href="C_01.jsp">개표결과</a></td>
    </tr>
</table>

<h1> 후보별 득표 결과 </h1>

<table cellspacing=3 width=600 border=1>
    <tr>
        <td width=75><p align=center>이름</p></td>
        <td width=500><p align=center>인기도</p></td>
    </tr>
    <% for (VotingResult result : votingResult) { %>
    <tr>
        <td width=75><a href="C_02.jsp?name=<%= result.getName() %>&id=<%= result.getId()%>"><%= result.getName() %></p></a></td>
        <td width=500>
            <p align=left>
                <img src='막대기.jpg' width=<%= result.getVotePercentage() %> height=20>
                &nbsp<%= result.getVoteCount() %>&nbsp(<%= result.getVotePercentage() %>%)
            </p>
        </td>
    </tr>
    <%}%>
</table>
<%}%>
</div>

</body>
</html>
