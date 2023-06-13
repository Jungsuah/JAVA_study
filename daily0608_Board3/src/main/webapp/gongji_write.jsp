5. gongji_write.jsp
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
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

int id = 0;
try{
    id = Integer.parseInt(request.getParameter("id"));
}catch(Exception e){
}

String title = "";
try{
	title = request.getParameter("title");
}catch(Exception e){
}

String content = "";
try{
	content = request.getParameter("content");
}catch(Exception e){
}

int rootId = 0;
try{
	rootId = Integer.parseInt(request.getParameter("rootId"));
}catch(Exception e){
}

int rootLevel = 0;
try{
	rootLevel = Integer.parseInt(request.getParameter("rootLevel"));
}catch(Exception e){
}

int recnt = 0;
try{
	recnt = Integer.parseInt(request.getParameter("rootCnt"));
}catch(Exception e){
}

GongjiDao gongjiDao = new GongjiDaoImpl();
Gongji gongji = new Gongji();
gongji.setId(id);
gongji.setTitle(title);
gongji.setContent(content);
gongji.setRootid(rootId);
gongji.setRelevel(rootLevel);
gongji.setRecnt(recnt);

int result = 0;

if(id != 0 && title != null && content != null && rootId == 0){
	 gongji.setRootid(id);
	 result = gongjiDao.updateWongul(gongji);//원글 수정
}else if(title != null && content != null && rootId != 0 && rootLevel != 0 && recnt != 0 ){
	gongji.setTitle(title);
	gongji.setContent(content);
	gongji.setRootid(rootId);
	gongji.setRelevel(rootLevel);
	gongji.setRecnt(recnt);
	result = gongjiDao.insertReply(gongji);//댓글 등록
}else if(id != 0 && title != null && content != null && rootId != 0){
	gongji.setId(id);
	gongji.setTitle(title);
	gongji.setContent(content);
	result = gongjiDao.updateReply(gongji);//댓글 수정
}else{
	 result = gongjiDao.insertGongji(gongji);//원글 등록
}

if (result == 1) {
    response.sendRedirect("gongji_list.jsp");
 } else {
    out.println("Failed to update the record.");
 }
%>
</body>
</html>