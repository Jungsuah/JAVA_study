<%@page import="dao.GongjiDaoImpl"%>
<%@page import="dao.GongjiDao"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head>
<meta charset="UTF-8">
<title>6. gongji_delete.jsp</title>
<%
request.setCharacterEncoding("UTF-8"); // 요청의 문자 인코딩을 UTF-8로 설정합니다.
response.setCharacterEncoding("UTF-8"); // 응답의 문자 인코딩을 UTF-8로 설정합니다.

int id = 0;
try{
    id = Integer.parseInt(request.getParameter("id")); // "id" 파라미터를 가져와 정수로 변환합니다.
}catch(Exception e){
}

int rootId = 0;
try{
	rootId = Integer.parseInt(request.getParameter("rootId")); // "rootId" 파라미터를 가져와 정수로 변환합니다.
}catch(Exception e){
}

int rootLevel = 0;
try{
	rootLevel = Integer.parseInt(request.getParameter("rootLevel")); // "rootLevel" 파라미터를 가져와 정수로 변환합니다.
}catch(Exception e){
}

int recnt = 0;
try{
	recnt = Integer.parseInt(request.getParameter("recnt")); // "recnt" 파라미터를 가져와 정수로 변환합니다.
}catch(Exception e){
}

System.out.println("!!!!!!id : "+id); // 전달받은 id 출력
System.out.println("!!!!!!rootId : "+rootId); // 전달받은 rootId 출력
System.out.println("!!!!!!rootLevel : "+rootLevel); // 전달받은 rootLevel 출력
System.out.println("!!!!!!recnt : "+recnt); // 전달받은 recnt 출력

GongjiDao gongjiDao = new GongjiDaoImpl(); // GongjiDaoImpl 객체 생성

int result = gongjiDao.delete(rootId,rootLevel,recnt); // delete 메소드를 사용하여 레코드 삭제

if (result != 1) {
    out.println("Failed to delete the record."); // 삭제 실패 시 오류 메시지 출력
 }
%>
<script>
        alert("삭제 성공!"); // 삭제 성공 알림창 표시
        location.href = "gongji_list.jsp"; // gongji_list.jsp로 페이지 이동
</script>
</body>
</html>
