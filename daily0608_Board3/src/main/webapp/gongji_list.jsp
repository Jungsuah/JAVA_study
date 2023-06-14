<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="domain.Gongji"%>
<%@page import="service.GongjiServiceImpl"%>
<%@page import="service.GongjiService"%>
<%@page import="dao.GongjiDaoImpl"%>
<%@page import="dao.GongjiDao"%>
<%@page import="dto.Pagination"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: white;
    }

    table {
        width: 1000px;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #8ec5e3;
        color: white;
    }

    a {
        color: #007bff;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }

    .pagination {
        text-align: center;
        margin-top: 20px;
        width: 2000px;
        margin-left:50px;
    }

    .pagination a {
        display: inline-block;
        padding: 8px 16px;
        text-decoration: none;
        color: #007bff;
        border: 1px solid #ddd;
    }

    .pagination a.active {
        background-color: #007bff;
        color: white;
        border: 1px solid #007bff;
    }

    .pagination a:hover:not(.active) {
        background-color: #ddd;
    }

    .pagination a:first-child {
        border-top-left-radius: 5px;
        border-bottom-left-radius: 5px;
    }

    .pagination a:last-child {
        border-top-right-radius: 5px;
        border-bottom-right-radius: 5px;
    }

    .new-button {
        margin-top: 20px;
        text-align: right;
        width: 1000px;
    }

    .new-button input[type="button"] {
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        border: none;
        cursor: pointer;
    }

    .new-button input[type="button"]:hover {
        background-color: #0056b3;
    }
   .pagination-and-new-button {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 1000px;
}
</style>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8"); // 요청 데이터의 인코딩을 UTF-8로 설정합니다.
response.setCharacterEncoding("UTF-8"); // 응답 데이터의 인코딩을 UTF-8로 설정합니다.

GongjiDao gongjiDao = new GongjiDaoImpl(); // GongjiDaoImpl 객체를 생성합니다.
GongjiService gongjiService = new GongjiServiceImpl(); // GongjiServiceImpl 객체를 생성합니다.

int total = gongjiDao.count(); // 공지사항 전체 개수를 조회하여 변수 total에 저장합니다.

int pageNumber = 0; // 페이지 번호를 저장할 변수입니다.
int cntPT = 0; // 페이지당 공지사항 개수를 저장할 변수입니다.

int id = 0; // 아이디를 저장할 변수입니다.
int fromPT = 0; // 페이지의 시작 위치를 저장할 변수입니다.

try {
    id = Integer.parseInt(request.getParameter("id")); // request에서 전달된 "id" 파라미터 값을 정수로 변환하여 변수 id에 저장합니다.
} catch (Exception e) {
}

try {
    pageNumber = Integer.parseInt(request.getParameter("pageNumber")); // request에서 전달된 "pageNumber" 파라미터 값을 정수로 변환하여 변수 pageNumber에 저장합니다.
} catch (Exception e) {
    pageNumber = 1; // 파라미터가 전달되지 않았거나 변환에 실패한 경우, 기본값으로 1을 설정합니다.
}

try {
    cntPT = Integer.parseInt(request.getParameter("cntPT")); // request에서 전달된 "cntPT" 파라미터 값을 정수로 변환하여 변수 cntPT에 저장합니다.
} catch (Exception e) {
    cntPT = 20; // 파라미터가 전달되지 않았거나 변환에 실패한 경우, 기본값으로 20을 설정합니다.
}

Pagination pagination = gongjiService.getPagination(pageNumber, cntPT);
// 페이지네이션 객체를 생성하여 페이지 번호와 페이지당 공지사항 개수를 전달하여 초기화합니다.

int c = pagination.getC();//현재 페이지
int s =  pagination.getS();//시작 버튼 번호
int e = pagination.getE();//마지막 버튼 번호
int p = pagination.getP();//< 버튼
int pp = pagination.getPp();//<< 버튼
int n = pagination.getN();//> 버튼
int nn = pagination.getNn();//>> 버튼

List<Gongji> gongjiList = gongjiDao.selectAll(pageNumber, cntPT); // 페이지 번호와 페이지당 공지사항 개수를 전달하여 공지사항 목록을 조회하여 리스트에 저장합니다.
int rootid = gongjiList.get(0).getId(); // 공지사항 목록에서 첫 번째 항목의 id를 가져와 변수 rootid에 저장합니다.

Date currentDate = new Date(); // 현재 날짜를 가져옵니다.
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 날짜 형식을 지정합니다.
String formattedDate = sdf.format(currentDate); // 현재 날짜를 지정된 형식으로 변환하여 변수 formattedDate에 저장합니다.

%>
<% if (gongjiList.isEmpty()) { %> <!-- 공지사항 목록이 비어있는 경우 -->
    <h2>등록된 공지사항이 없습니다.</h2>
<% } else { %> <!-- 공지사항 목록이 있는 경우 -->
    <table>
    <tr>
        <th width="50">번호</th>
        <th width="500">제목</th>
        <th width="100">조회수</th>
        <th width="100">등록일</th>
    </tr>
    <% for(Gongji gongji : gongjiList) { %> <!-- 공지사항 목록을 반복하면서 테이블에 출력 -->
        <tr>
            <td><%=gongji.getId()%></td> <!-- 공지사항 번호를 출력 -->
            <td>
                <% 
                if(formattedDate.equals(gongji.getDate())){ // 오늘 작성된 게시글인 경우
                    String dashes = "";
                    if(gongji.getRelevel() == 0){
                        dashes = "";
                    }else{
                        for(int i = 0; i < gongji.getRelevel(); i++) {
                            dashes += "-"; 
                        }
                        dashes += "> [RE] "; //[RE] 출력하기 
                    }
                %>
                <a href='gongji_view.jsp?id=<%=gongji.getId()%>&pageNumber=<%=c%>&viewcnt=<%=gongji.getViewcnt()%>'>
                <%=dashes%><%=gongji.getTitle().replaceAll("<", "&lt;").replaceAll(">", "&gt;")%> [NEW]</a>
                <% } else { %> <!-- 오늘 작성된 게시글이 아닌 경우 -->
                    <% 
                    String dashes = "";
                    if(gongji.getRelevel() == 0) {
                        dashes = "";
                    } else {
                        for(int i = 0; i < gongji.getRelevel(); i++) {
                            dashes += " - "; 
                        }
                        dashes += ">[RE] "; //[RE] 출력하기
                    }
                    %>
                    <a href='gongji_view.jsp?id=<%=gongji.getId()%>&pageNumber=<%=c%>&viewcnt=<%=gongji.getViewcnt()%>'>
                    <%=dashes%><%=gongji.getTitle().replaceAll("<", "&lt;").replaceAll(">", "&gt;")%> </a>
                <% } %>
            </td>
            <td><%=gongji.getViewcnt()%></td> <!-- 조회수를 출력 -->
            <td><%=gongji.getDate()%></td> <!-- 등록일을 출력 -->
        </tr>
    <% } %>
</table>

    <div class="pagination-and-new-button">
    <div class="pagination">
        <%if(pp != -1){ %> <!-- pp값이 -1이면 보이지 않게 처리 -->
            <a href="gongji_list.jsp?pageNumber=<%= pp %>&cntPT=<%= cntPT %>"><<</a> <!-- 무조건 1페이지로 이동하는 버튼 -->
            <a href="gongji_list.jsp?pageNumber=<%= p %>&cntPT=<%= cntPT %>"><</a> <!-- p값을 통해 이전 10블록 전으로 이동하는 버튼 출력 -->
        <% } %>

        <% for (int index = s; index < e + 1; index++) { %>
            <!-- 시작번호부터 끝 번호까지 버튼을 출력 -->
            <% if (index == c) { %> <!-- 번호가 현재 페이지와 같다면 빨간색으로 출력 -->
                <a href="gongji_list.jsp?pageNumber=<%= index %>&cntPT=<%= cntPT %>" class="active"><%= index %></a>
            <% } else { %><!-- 현재 페이지와 같은 버튼이 아니라면 스타일 없이 버튼 출력 -->
                <a href="gongji_list.jsp?pageNumber=<%= index %>&cntPT=<%= cntPT %>"><%= index %></a>
            <% } %>
        <% } %>

        <%if(nn != -1) { %>
            <!-- 다음 10블록 뒤로가는 버튼 생성 -->
            <a href="gongji_list.jsp?pageNumber=<%= n %>&cntPT=<%= cntPT %>">></a>
            <!-- 맨 마지막 페이지로 가는 버튼 생성 -->
            <a href="gongji_list.jsp?pageNumber=<%= nn %>&cntPT=<%= cntPT %>">>></a>
        <% } %>
    </div>

    <div class="new-button">
        <input type="button" value="신규" OnClick="window.location='gongji_insert.jsp?rootid=<%=rootid%>'">
    </div>
</div>

<% } %>
</body>
</html>
