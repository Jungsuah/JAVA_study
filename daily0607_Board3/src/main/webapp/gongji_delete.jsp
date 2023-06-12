6. gongji_delete.jsp
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
<title>6. gongji_delete.jsp</title>
<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

int id = 0;
try{
    id = Integer.parseInt(request.getParameter("id"));
}catch(Exception e){
}

GongjiDao gongjiDao = new GongjiDaoImpl();
int result = gongjiDao.deleteOneGongji(id);

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