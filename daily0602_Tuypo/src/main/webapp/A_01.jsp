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
// 요청과 응답의 인코딩 설정
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

// TuypoDao 객체 생성 및 후보 목록 조회
TuypoDao tupyoDao = new TuypoDaoImpl();
List<Hubo_Table> huboList = tupyoDao.selectAll();

// 빈 후보 번호 생성
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
	
<%// 후보 리스트를 받아와서 각 후보별로 반복하여 출력
for (Hubo_Table hubo : huboList) {%>
    <td>
      <form method="post" action="A_02.jsp">
        <!-- 후보 아이디 정보 출력 -->
        기호:<input type="text" name="id" value="<%= hubo.getId() %>" readonly>
        <!-- 후보 이름 정보 출력 -->
        이름:<input type="text" name="name" value="<%= hubo.getName() %>" readonly>
        <input type="submit" value="삭제">
      </form>
    </td>
  </tr>
<%}%>
	<tr>
		<td>
		<form method="post" id="formInsert">
			<!-- 새로운 후보 추가 폼 -->
			<!-- 추가되야 하는 아이디 값을 구해와서 출력 읽기 전용 -->
			기호:<input type="text" name="id" value="<%= startID %>" readonly>
			<!-- 추가되야 하는 이름을 넣어주기 -->
			이름:<input type="text" name="name" value="">
			<!-- confirmAndInsert 함수로 값을 submit 하기전에 검사하기 -->
			<input type="button" value="추가" onclick="confirmAndInsert()">
		</form>	
		</td>	
	</tr>
</table>

</div>

</body>
</html>
