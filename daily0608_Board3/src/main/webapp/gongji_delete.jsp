6. gongji_delete.jsp
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
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

int id = 0;
try{
    id = Integer.parseInt(request.getParameter("id"));
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
	recnt = Integer.parseInt(request.getParameter("recnt"));
}catch(Exception e){
}


System.out.println("!!!!!!id : "+id);
System.out.println("!!!!!!rootId : "+rootId);
System.out.println("!!!!!!rootLevel : "+rootLevel);
System.out.println("!!!!!!recnt : "+recnt);

GongjiDao gongjiDao = new GongjiDaoImpl();
//int result = gongjiDao.deleteOneGongji(id);

int result = gongjiDao.delete(rootId,rootLevel,recnt);

if (result != 1) {
    out.println("Failed to delete the record.");
 }
%>
<script>
        alert("삭제 성공!");
        location.href = "gongji_list.jsp";
</script>
</body>
</html>