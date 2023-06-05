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

/* select dropdown age의 스타일 지정*/
select[name="age"] {
  padding: 8px;
  font-size: 14px;
  width: 100%;
  border-radius: 5px;
}

/* select dropdown id의 스타일 지정*/
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
//요청과 응답의 인코딩 설정

TuypoDao tupyoDao = new TuypoDaoImpl(); //TuypoDao를 임포트해서
List<Hubo_Table> huboList= tupyoDao.selectAll();//selectAll 메소드를 사용하여 전체 리스트 가져오기

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
				<select name = id><!-- 이름을 선택하는 select 박스 생성 -->
		<%for (Hubo_Table hubo : huboList) {%><!-- select박스 안에 옵션은 huboList의 값을 하나씩 출력한다 -->
					<option value = <%=hubo.getId()%>><%=hubo.getId()%>&nbsp<%=hubo.getName()%>
				<%}%>
				</select>
				</p>
				</td>
			<td width=300><p align = center>
				<select name = age><!-- 연령대 선택하는 select 박스 생성 -->
					<option value = 1>10대<!-- 10대 선택시 값은 1이 넘어감 -->
					<option value = 2>20대<!-- 20대 선택시 값은 2이 넘어감 -->
					<option value = 3>30대<!-- 30대 선택시 값은 3이 넘어감 -->
					<option value = 4>40대<!-- 40대 선택시 값은 4이 넘어감 -->
					<option value = 5>50대<!-- 50대 선택시 값은 5이 넘어감 -->
					<option value = 6>60대<!-- 60대 선택시 값은 6이 넘어감 -->
					<option value = 7>70대<!-- 70대 선택시 값은 7이 넘어감 -->
					<option value = 8>80대<!-- 80대 선택시 값은 8이 넘어감 -->
					<option value = 9>90대<!-- 90대 선택시 값은 9이 넘어감 -->
				</select>
				</p>
				</td>	
				<td>
				<!-- submit 버튼을 클릭하면 form안에 있는 값이 전부 넘어간다 -->
				<input type = submit value = "투표하기" margin-left = 100px;>
				</td>
	</form>
	</tr>
</table>
</div>
</body>
</html>