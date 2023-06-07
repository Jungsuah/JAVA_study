1. gongji_list.jsp
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
</head>
<body>
<% request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

GongjiDao gongjiDao = new GongjiDaoImpl(); // StudentScoreDaoImpl 객체 생성
List<Gongji> gongjiList = gongjiDao.selectAllGongji(); // 테이블 생성 메서드 호출하여 오류 여부 확인

%>
<% if (gongjiList.isEmpty()) { %>
    <h2>등록된 공지사항이 없습니다.</h2>
<% } else { %>
    <table border=1>
    <tr>
        <th width="50">번호</th>
        <th width="500">제목</th>
        <th width="100">등록일</th>
    </tr>
    
    <% for(Gongji gongji : gongjiList) { %>
    <tr>
        <td><%=gongji.getId()%></td>
        <td><a href='gongji_view.jsp?id=<%=gongji.getId()%>'><%=gongji.getTitle()%></a></td>
        <td><%=gongji.getDate()%></td>
    </tr>
    <% } %>
    </table>

<table width=650>
<tr>
<td width=550></td>
<td><input type=button value="신규" OnClick="window.location='gongji_insert.jsp'"></td>
</tr>
</table>
<% } %>
</body>
</html>
