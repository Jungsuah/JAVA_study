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
body { /* 전체 문서의 기본적인 스타일을 설정합니다. 폰트, 배경색, 여백 등을 지정*/
  font-family: Arial, sans-serif;
  background-color: #f2f2f2;
  margin: 0;
  padding: 0;
}

.container {/* 컨테이너 요소의 스타일을 설정합니다. 너비, 여백, 배경색, 테두리 등을 지정*/
  width: 800px;
  margin: 20px auto;
  background-color: #fff;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 5px;
}

table {/*테이블 요소의 스타일을 설정합니다. 너비, 테두리 축소, 테두리, 내부 여백 등을 지정합니다*/
  width: 100%;
  border-collapse: collapse;
}

table, th, td {/* 데이터 셀 요소 스타일을 설정 */
  border: 1px solid #ddd;
  padding: 10px;
}

th {/* 테이블의 헤더 셀 요소의 스타일을 설정*/
  background-color: #f2f2f2;
}

h1 {/*제목 요소의 스타일을 설정합니다. 여백, 폰트 크기 등을 지정*/
  margin: 0;
  padding: 0;
  font-size: 24px;
  margin-bottom: 20px;
}

form {/*-폼 요소의 스타일을 설정합니다. 하단 여백을 지정*/
  margin-bottom: 10px;
}

input[type="text"], input[type="submit"] {/*텍스트 입력 필드와 제출 버튼의 스타일을 설정합니다. 내부 여백, 폰트 크기 등을 지정*/
  padding: 8px;
  font-size: 14px;
}

input[type="submit"] {/*텍스트 입력 필드와 제출 버튼의 스타일을 설정합니다. 내부 여백, 폰트 크기 등을 지정*/
  background-color: #4CAF50;
  color: white;
  border: none;
  cursor: pointer;
}

a {/*링크 요소의 스타일을 설정합니다. 텍스트에 밑줄이 없도록 지정*/
  text-decoration: none;
}

a:hover {/*호버 상태일 때 링크 요소의 스타일을 설정*/
  font-weight: bold;
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