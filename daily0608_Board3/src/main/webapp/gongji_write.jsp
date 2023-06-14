
<%@page import="domain.Gongji"%>
<%@page import="dao.GongjiDaoImpl"%>
<%@page import="dao.GongjiDao"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head>
<meta charset="UTF-8">
<title>5. gongji_write.jsp</title>
<body>
<%
request.setCharacterEncoding("UTF-8"); // 요청의 문자 인코딩 설정
response.setCharacterEncoding("UTF-8"); // 응답의 문자 인코딩 설정

int id = 0;
try{
    id = Integer.parseInt(request.getParameter("id")); // 요청 파라미터에서 게시물 ID 가져오기
}catch(Exception e){
}

String title = "";
try{
	title = request.getParameter("title"); // 요청 파라미터에서 제목 가져오기
}catch(Exception e){
}

String date = "";
try{
	date = request.getParameter("date"); // 요청 파라미터에서 날짜 가져오기
}catch(Exception e){
}

String content = "";
try{
	content = request.getParameter("content"); // 요청 파라미터에서 내용 가져오기
}catch(Exception e){
}

int rootId = 0;
try{
	rootId = Integer.parseInt(request.getParameter("rootId")); // 요청 파라미터에서 원글 ID 가져오기
}catch(Exception e){
}

int rootLevel = 0;
try{
	rootLevel = Integer.parseInt(request.getParameter("rootLevel")); // 요청 파라미터에서 댓글 수준 가져오기
}catch(Exception e){
}

int recnt = 0;
try{
	recnt = Integer.parseInt(request.getParameter("rootCnt")); // 요청 파라미터에서 댓글 내 순서 가져오기
}catch(Exception e){
}

GongjiDao gongjiDao = new GongjiDaoImpl(); // GongjiDaoImpl 객체 생성
Gongji gongji = new Gongji(); // Gongji 객체 생성
gongji.setId(id); // 게시물 ID 설정
gongji.setTitle(title); // 제목 설정
gongji.setContent(content); // 내용 설정
gongji.setRootid(rootId); // 원글 ID 설정
gongji.setRelevel(rootLevel); // 댓글 수준 설정
gongji.setRecnt(recnt); // 댓글 내 순서 설정

int result = 0; // 결과 변수 초기화

if(id != 0 && title != null && content != null && rootId == 0){
	// 원글 수정인 경우
	gongji.setRootid(id); // 원글 ID 설정
	result = gongjiDao.updateWongul(gongji); // 원글 수정 메서드 호출
	if(result == 1){
		result = 2; // 수정 성공 시 결과값 변경
	}
}else if(title != null && content != null && rootId != 0 && rootLevel != 0 && recnt != 0){
	// 댓글 등록인 경우
	gongji.setTitle(title); // 제목 설정
	gongji.setContent(content); // 내용 설정
	gongji.setRootid(rootId); // 원글 ID 설정
	gongji.setRelevel(rootLevel); // 댓글 수준 설정
	gongji.setRecnt(recnt); // 댓글 내 순서 설정
	result = gongjiDao.insertReply(gongji); // 댓글 등록 메서드 호출
	if(result == 1){
		result = 3; // 등록 성공 시 결과값 변경
	}
}else if(id != 0 && title != null && content != null && rootId != 0){
	// 댓글 수정인 경우
	gongji.setId(id); // 댓글 ID 설정
	gongji.setTitle(title); // 제목 설정
	gongji.setContent(content); // 내용 설정
	result = gongjiDao.updateReply(gongji); // 댓글 수정 메서드 호출
	if(result == 1){
		result = 4; // 수정 성공 시 결과값 변경
	}
}else{
	// 원글 등록인 경우
	result = gongjiDao.insertGongji(gongji); // 원글 등록 메서드 호출
	if(result == 1){
		result = 5; // 등록 성공 시 결과값 변경
	}
}

if (result == 2) {
    // 원글 수정 성공
    %>
    <script>
        alert("수정 성공!"); // 수정 성공 메시지 출력
        location.href = "gongji_list.jsp"; // 목록 페이지로 이동
    </script>
    <% 
} else if (result == 3) {
    // 댓글 등록 성공
    %>
    <script>
        alert("등록 성공!"); // 등록 성공 메시지 출력
        location.href = "gongji_list.jsp"; // 목록 페이지로 이동
    </script>
    <% 
} else if (result == 4) {
    // 댓글 수정 성공
    %>
    <script>
        alert("수정 성공!"); // 수정 성공 메시지 출력
        location.href = "gongji_list.jsp"; // 목록 페이지로 이동
    </script>
    <% 
} else if (result == 5) {
    // 원글 등록 성공
    %>
    <script>
        alert("등록 성공!"); // 등록 성공 메시지 출력
        location.href = "gongji_list.jsp"; // 목록 페이지로 이동
    </script>
    <% 
} else {
    // 그 외의 경우
    response.sendRedirect("gongji_list.jsp"); // 목록 페이지로 리다이렉트
}
%>
</body>
</html>