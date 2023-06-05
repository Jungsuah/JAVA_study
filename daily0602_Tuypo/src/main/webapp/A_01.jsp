<%@page import="kr.ac.kopo.ctc.kopo27.domain.Hubo_Table"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.TuypoDao"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.TuypoDaoImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보등록 A_01.jsp</title>
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

<script type="text/javascript">

function confirmAndInsert() { //함수 confirmAndInsert 생성
    const form = document.getElementById('formInsert');
     //id가 formInsert인 html을 받아와 form에 할당한다
  const n1 = form.elements.name.value;
    //form html에서 name으로 입력된 값을 받아와 username에 할당한다
    const pattern1 = /^([a-zA-Z]|[가-힣])+$/; //한글,영어만 입력받는 정규식1 생성
    const pattern2 = /^.{1,20}$/; //20자 이내만 입력받는 정규식2 생성
    if(!pattern1.test(n1)) { //username값이 정규식1을 만족하지 않으면 
        alert("이름에 한글, 영어를 입력해주세요"); //해당문구를 알림창에 띄워준다
    } else if (!pattern2.test(n1)) { //username값이 정규식2을 만족하지 않으면 
        alert("이름은 20자 이내로 입력해주세요"); //해당문구를 알림창에 띄워준다
    } else { //변수값들이 모두 위의 정규식들을 만족하면          
        var confirmed = confirm("후보를 등록하시겠습니까?"); //해당 문자열을 띄우는 확인창을 생성한다
         if (confirmed) { //확인버튼을 누르면
            form.action = 'A_03.jsp';  //form의 action요소를 A_03_H.jsp로 지정해준다
             form.submit(); //form의 데이터를 해당 경로로 제출한다 
         }
    }        
}
	
</script>
<body>

<div class="container">

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

TuypoDao tupyoDao = new TuypoDaoImpl(); 
List<Hubo_Table> huboList= tupyoDao.selectAll();
int startID = tupyoDao.blankHuboNumber();
%>


<table cellspacing="0" border="0">
	<tr>
		<td bgcolor="yellow"><a href="A_01.jsp">후보등록</a></td>
		<td><a href="B_01.jsp">투표</a></td>
		<td><a href="C_01.jsp">개표결과</a></td>
	</tr>
</table>
<h1>후보등록 추가</h1>
<table cellspacing="0" border="0">

	<tr>
		<td><p align="center">후보명 입력</p></td>
	</tr>
	
<%
for (Hubo_Table hubo : huboList) {
System.out.println(hubo.getId() + hubo.getName());
%>

  <tr>
    <td>
      <form method="post" action="A_02.jsp" >
        기호:<input type="text" name="id" value="<%= hubo.getId() %>" readonly >
        이름:<input type="text" name="name" value="<%= hubo.getName() %>" readonly>
        <input type="submit" value="삭제">
      </form>
    </td>
  </tr>
<%
  }
%>
	<tr>
		<td>
		<form method="post" id = "formInsert">
			기호:<input type="text" name="id" value="<%= startID %>" readonly>
			이름:<input type="text" name="name" value="">
			<input type="button" value="추가" onclick="confirmAndInsert()">
		</form>	
		</td>	
	</tr>

</table>

</div>

</body>
</html>
