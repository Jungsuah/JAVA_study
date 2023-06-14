
<%@page import="dao.GongjiDaoImpl"%>
<%@page import="dao.GongjiDao"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head>
<meta charset="UTF-8">
<title>5. gongji_insertWrite.jsp</title>
<body>
<%
request.setCharacterEncoding("UTF-8"); // 요청의 문자 인코딩을 UTF-8로 설정합니다.
response.setCharacterEncoding("UTF-8"); // 응답의 문자 인코딩을 UTF-8로 설정합니다.

int id = 0;
try{
    id = Integer.parseInt(request.getParameter("id")); // "id" 파라미터를 가져와 정수로 변환합니다.
}catch(Exception e){
}

String title = "";
try{
	title = request.getParameter("title"); // "title" 파라미터를 가져옵니다.
}catch(Exception e){
}

String content = "";
try{
	content = request.getParameter("content"); // "content" 파라미터를 가져옵니다.
}catch(Exception e){
}

int pageNumber = 0;
try{
	pageNumber = Integer.parseInt(request.getParameter("pageNumber")); // "pageNumber" 파라미터를 가져와 정수로 변환합니다.
}catch(Exception e){
}

int rootid = 0;
try{
	rootid = Integer.parseInt(request.getParameter("rootid")); // "rootid" 파라미터를 가져와 정수로 변환합니다.
}catch(Exception e){
}

GongjiDao gongjiDao = new GongjiDaoImpl(); // GongjiDaoImpl 객체를 생성합니다.
int result = gongjiDao.insertNewGongji(title, content, rootid); // insertNewGongji 메서드를 호출하여 원글을 등록하고, 결과를 저장합니다.

if (result != 1) {
    out.println("원글 등록 실패."); // 결과가 1이 아닌 경우 등록 실패 메시지를 출력합니다.
}
%>
<script>
    alert("원글 등록 성공!"); // 원글 등록 성공 알림 메시지를 표시합니다.
    location.href = "gongji_list.jsp"; // gongji_list.jsp로 페이지 이동합니다.
</script>
</body>
</html>