3. gongji_view.jsp
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*"%>
<%@page import="domain.Gongji"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="dao.GongjiDaoImpl"%>
<%@page import="dao.GongjiDao"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<html>
<head>
<style>
    table {
        border-collapse: collapse;
        width: 600px;
        background: linear-gradient(to bottom, #e2e2e2, #f1f1f1);
    }
    
    th, td {
        text-align: center;
        padding: 8px;
    }
    
    th {
        background-color: #f2f2f2;
    }
    
    tr:nth-child(even) {
        background-color: #ffffff;
    }
    
    h2 {
        margin-top: 20px;
    }
    
    input[type=button] {
        background-color: #4CAF50;
        border: none;
        color: white;
        padding: 8px 16px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 14px;
        margin: 4px 2px;
        cursor: pointer;
        border-radius: 4px;
    }
    
    input[type=button]:hover {
        background-color: #45a049;
    }
</style>
<script language="JavaScript">
   function submitForm(mode) {
      if(mode=="write"){
         fm.action="gongji_write.jsp";
      }else if(mode=="delete"){
         fm.action="gongji_delete.jsp";
      }
      fm.submit();
   }
</script>
</head>

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

int id = 0;
try{
	id = Integer.parseInt(request.getParameter("id"));
}catch(Exception e){
}

int pageNumber = 0;
try{
	pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
}catch(Exception e){
}

GongjiDao gongjiDao = new GongjiDaoImpl(); // StudentScoreDaoImpl 객체 생성
Gongji gongji = gongjiDao.selectOneGongji(id); // 테이블 생성 메서드 호출하여 오류 여부 확인

int gongjiId = gongji.getId();
String gongjiTitle = gongji.getTitle();
String gongjiDate = gongji.getDate();
String gongjiContent = gongji.getContent();
%>

<body>
<form method=post name='fm'>
<table width=650 border=1 cellspacing=0 cellpadding=5>
<tr>
<td><b>번호</b></td>
<td><%=gongjiId%></td>
</tr>
<tr>
<td><b>제목</b></td>
<td><%=gongjiTitle%></td>
</tr>
<tr>
<td><b>일자</b></td>
<td><%=gongjiDate%></td>
</tr>
<tr>
<td><b>내용</b></td>
<td><%=gongjiContent%></td>
</tr>
</table>
<table width=650>
<tr>
<td width=600></td>
<td><input type=button value="목록" OnClick="location.href='gongji_list.jsp?id=<%=gongjiId%>'"></td>
<td><input type="button" value="수정" onclick="location.href='gongji_update.jsp?id=<%=gongjiId%>&title=<%=gongjiTitle%>&date=<%=gongjiDate%>&content=<%=gongjiContent%>&pageNumber=<%=pageNumber%>'"></td>
</tr>
</table></form>
</body>

</html>