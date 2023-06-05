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

a {/*링크 요소의 스타일을 설정합니다. 텍스트에 밑줄이 없도록 지정*/
  text-decoration: none;
}

a:hover {/*호버 상태일 때 링크 요소의 스타일을 설정*/
  font-weight: bold;
}
</style>

</head>
<body>
<div class="container">
<%
//요청과 응답의 인코딩 설정
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

TuypoDao tupyoDao = new TuypoDaoImpl(); //tupyoDao를 임포트 해서 메소드 사용하게 하기

int id = 0;
String sid = request.getParameter("id");//id값을 받아오고 문자열 변수에 저장
try{
	id = Integer.parseInt(sid);//숫자형 변수로 변환해서 저장
}catch(Exception e){
}

int age = 0;
String sage = request.getParameter("age");//age값을 받아오고 문자열 변수에 저장
try{
	age = Integer.parseInt(sage);//숫자형 변수로 변환해서 저장
}catch(Exception e){
}

int result = tupyoDao.insertTuypo(id, age);//id와 age를 사용하여 투표결과를 insert하기
%>

<table cellspacing=3 width=600 border=1>
	<tr>
		<td width=100><a href="A_01.jsp">후보등록</a></td>
		<td width=100 bgcolor="yellow"><a href="B_01.jsp">투표</a></td>
		<td width=100 ><a href="C_01.jsp">개표결과</a></td>
	</tr>
</table>

<%if(result == 1){ %><!-- insert가 잘 되었다면 -->
<table cellspacing=3 width=600 border=1>
	<tr><!-- insert가 된 후보이름을 보여주기 -->
		<td width=350><h3>투표 결과 : <%= id%>번 후보를 투표 하셨습니다.</a></h3></td>
		<!-- 다시 투표하러가기 버튼 보여주기 -->
		<td width=97 ><button onclick="location.href='B_01.jsp'">다시 투표하러가기</button></td>
	</tr>
</table>

<%} else {%><!-- insert가 안됐다면 -->
<table cellspacing=3 width=600 border=1>
	<tr><!-- 실패 안내문 띄우기 -->
		<td width=350><h2><a href="B_01.jsp">투표 결과 : 투표하기가 실패 되었습니다.</a></h2></td>
		<!-- 다시 투표하러가기 버튼 보여주기 -->
		<td width=97 ><button onclick="location.href='B_01.jsp'">다시 투표하러가기</button></td>
	</tr>
</table>
<%} %>
</div>
</body>
</html>