4. gongji_update.jsp
<%@page import="domain.Gongji"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="dao.GongjiDaoImpl"%>
<%@page import="dao.GongjiDao"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*"%>
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

String title = "";
try{
	title = request.getParameter("title");
}catch(Exception e){
}

String date ="";
try{
	date = request.getParameter("date");
}catch(Exception e){
}

String content = "";
try{
	content = request.getParameter("content");
}catch(Exception e){
}

Gongji gongji = new Gongji();
gongji.setId(id);
gongji.setTitle(title);
gongji.setDate(date);
gongji.setTitle(title);


GongjiDao gongjiDao = new GongjiDaoImpl(); // GongjiDaoImpl 객체 생성
int result = gongjiDao.updateGongji(gongji);
%>

<body>
<form method=post name='fm'>
<table width=650 border=1 cellspacing=0 cellpadding=5>
<tr>
<td><b>번호</b></td>
<td><input type=text name=id size=70 value=<%=id%> readonly></td>
</tr>
<tr>
<td><b>제목</b></td>
<td><input type=text name=title size=70 maxlength=70 value=<%=title%>></td>
</tr>
<tr>
<td><b>일자</b></td>
<td><%=date%></td>
</tr>
<tr>
<td><b>내용</b></td>
<td><textarea style='width:500px; height:250px;' name=content cols=70 row=600><%=content%></textarea></td>
</tr>
</table>
<table width=650>
<tr>
<td width=600></td>
<td><input type=button value="취소" OnClick="location.href='gongji_list.jsp'"></td>
<td><input type=button value="쓰기" OnClick="submitForm('write')"></td>
<td><input type=button value="삭제" OnClick="submitForm('delete')"></td>
</tr>
</table></form>
</body>

</html>