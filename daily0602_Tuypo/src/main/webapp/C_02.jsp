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
/* body 스타일 */
body {
font-family: Arial, sans-serif;
background-color: #f2f2f2;
margin: 0;
padding: 0;
}

/* 컨테이너 스타일 */
.container {
width: 800px;
margin: 20px auto;
background-color: #fff;
padding: 20px;
border: 1px solid #ddd;
border-radius: 5px;
}

/* 테이블 스타일 */
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

/* 제목 스타일 */
h1 {
margin: 0;
padding: 0;
}

/* 링크 스타일 */
a {
text-decoration: none;
}

a:hover {
font-weight: bold;
}

/* 문단 스타일 */
p {
margin: 0;
padding: 0;
}

/* 이미지 스타일 */
img {
vertical-align: middle;
}

/* 버튼 컨테이너 스타일 */
.button-container {
text-align: center;
margin-top: 10px;
}

/* 버튼 스타일 */
.button-container button {
padding: 10px 20px;
background-color: #4caf50;
color: #fff;
border: none;
border-radius: 4px;
cursor: pointer;
}

/* 버튼 호버 스타일 */
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
//요청과 응답의 인코딩 설정
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

TuypoDao tupyoDao = new TuypoDaoImpl(); //tupyoDao를 임포트 해서 메소드 사용하게 하기

int id = 0;
String sid = request.getParameter("id");//id값을 받아서 문자열 변수에 저장
try{
	id = Integer.parseInt(sid);//문자열 변수를 숫자형을 변환
}catch(Exception e){
}

String name = "";
try{
	name = request.getParameter("name");//name값을 받아서 문자열 변수에 저장
}catch(Exception e){
}

//id를 기준으로 후보자의 연령대별 득표수와 득표율을 구해서 리스트로 받아온다
List<VotingResult> votingResult = tupyoDao.getVotingResultsAge(id);

if (votingResult != null) {//값이 있으면 출력
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
                <td width=500><h1>[<%=name%>] 후보 득표 성향 </h1></td><!-- 받아온 후보자의 이름 출력 -->
                <!-- 뒤로가기 버튼 출력 -->
                <td width=300 ><button style = 'margin-left:100px;' onclick="goBack()">뒤로가기</button></td>
            </tr>
      </table>

<table cellspacing=3 width=600 border=1>
	<tr>
		<td width=75><p align=center>연령대</p></td>
		<td width=500><p align=center>인기도</p></td>
	</tr>
	 <% for (VotingResult result : votingResult) { %><!-- votingResult리스트에서 result 객체 하나씩 출력하기-->
	<tr><!-- result 객체의 연령대 출력하기-->
		<td width=75><p align=center><%=result.getAgeGroup()%>대</p></td>
		<!-- result 객체의 득표율, 득표수 출력하기-->
		<td width=500><p align=left><img src='막대기.jpg' width=<%=result.getVotePercentage() * 15%> height=20 >&nbsp<%=result.getVoteCount()%>&nbsp&nbsp(<%=result.getVotePercentage()%>%)</p></td>
	</tr>
	<%}%>
</table>
	<%}%>
</div>
</body>
</html>