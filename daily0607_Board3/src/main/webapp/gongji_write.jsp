5. gongji_write.jsp
<%@page import="domain.Gongji"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="dao.GongjiDaoImpl"%>
<%@page import="dao.GongjiDao"%>
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

int pageNumber = 0;
try{
	pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
}catch(Exception e){
}

GongjiDao gongjiDao = new GongjiDaoImpl();
Gongji gongji = new Gongji();
gongji.setId(id);
gongji.setTitle(title);
gongji.setContent(content);

int result = gongjiDao.updateGongji(gongji);

if (result == 1) {
    response.sendRedirect("gongji_view.jsp?id="+id);
 } else {
    out.println("Failed to update the record.");
 }
%>
</body>
</html>