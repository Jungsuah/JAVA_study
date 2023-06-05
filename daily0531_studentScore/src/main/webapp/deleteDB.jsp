<%@page import="java.util.List"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dto.Pagination"%>
<%@page import="kr.ac.kopo.ctc.kopo27.service.StudentScoreServiceImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo27.service.StudentScoreService"%>
<%@page import="kr.ac.kopo.ctc.kopo27.domain.StudentScore"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.StudentScoreDaoImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo27.dao.StudentScoreDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--JSP 페이지의 언어를 Java로 설정하고, 컨텐츠 타입을 HTML로 지정합니다. 
페이지 인코딩을 UTF-8로 설정하여 한글과 같은 유니코드 문자를 올바르게 처리할 수 있도록 합니다.-->
<%@ page import="java.sql.*" %>
<%@ page import="java.net.*" %><!--한글이 post/get의 파라미터로 연동될때는 임포트 처리가 필요하다.-->
<!--java.sql 패키지에 있는 모든 클래스를 임포트합니다.
JSP 페이지에서 JDBC(Database Connectivity)를 사용하여 데이터베이스와의 연결 및 데이터 처리를 위해 필요한 클래스들을 사용-->

<!DOCTYPE html><!-- 문서 유형을 정의 -->
<html><!-- HTML 태그의 시작-->
<head> <!-- 문서의 헤더 정보를 나타냄 -->
    <meta charset="UTF-8"> <!-- 문서의 문자 인코딩 방식을 설정 -->
</head>
<style>
    .yellow{
        background-color: yellow;
    }
</style>

<script>
    function update(pa) {
        const form = document.getElementById('form_1'); // form 요소를 가져옵니다.

        if (pa == '뒤로가기') {
            form.action = 'showREC.jsp'; // form의 action을 'showREC.jsp'로 설정합니다.
        } 

        form.submit(); // form을 제출합니다.
    }
</script>
<body> 
<%
    request.setCharacterEncoding("UTF-8");//요청(request)의 문자 인코딩을 UTF-8로 설정
    response.setCharacterEncoding("UTF-8");// 응답(response)의 문자 인코딩을 UTF-8로 설정
    StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();//StudentScoreDao 인터페이스를 구현한 StudentScoreDaoImpl 객체를 생성
    StudentScoreService studentScoreService = new StudentScoreServiceImpl();//studentScoreService 인터페이스를 구현한 StudentScoreServiceImpl 객체를 생성

    int total = studentScoreDao.count(); // 전체 항목 갯수 조회
    int fromPT = 0;//시작 인덱스 변수 선언
    StudentScore ss = new StudentScore();//StudentScore객체 선언

    String name = "";
    int searchStudentID = 0;
    int kor = 0;
    int eng = 0;
    int mat = 0;

    try {
        name = request.getParameter("name"); // "name" 파라미터 값을 가져와서 name 변수에 저장합니다.
        searchStudentID = Integer.parseInt(request.getParameter("searchID")); // "searchID" 파라미터 값을 가져와서 searchStudentID 변수에 저장합니다.
        kor = Integer.parseInt(request.getParameter("kor")); // "kor" 파라미터 값을 가져와서 kor 변수에 저장합니다.
        eng = Integer.parseInt(request.getParameter("eng")); // "eng" 파라미터 값을 가져와서 eng 변수에 저장합니다.
        mat = Integer.parseInt(request.getParameter("mat")); // "mat" 파라미터 값을 가져와서 mat 변수에 저장합니다.
    } catch (Exception e) {
        // 파라미터 값을 가져오는 과정에서 예외가 발생하면, 예외를 무시하고 다음 코드를 실행합니다.
    }

    try {
        ss = studentScoreDao.selectByStudentId(searchStudentID); // searchStudentID 값을 가지고 학생 정보를 데이터베이스에서 조회하여 ss 변수에 저장합니다.
        fromPT = studentScoreDao.updateDataCount(searchStudentID); // searchStudentID 값을 가지고 몇 번째 항목인지 조회하여 fromPT 변수에 저장합니다.
        int num = ss.getId(); // ss 객체의 id 값을 num 변수에 저장합니다.
        ss.setName(name); // ss 객체의 이름을 name 변수 값으로 설정합니다.
        ss.setKor(kor); // ss 객체의 국어 점수를 kor 변수 값으로 설정합니다.
        ss.setEng(eng); // ss 객체의 영어 점수를 eng 변수 값으로 설정합니다.
        ss.setMat(mat); // ss 객체의 수학 점수를 mat 변수 값으로 설정합니다.
        studentScoreDao.deleteByStudentId(searchStudentID); // searchStudentID 값을 가지고 해당 학생 정보를 데이터베이스에서 삭제합니다.
    } catch (Exception e) {
        // 데이터베이스 조회나 삭제 과정에서 예외가 발생하면, 예외를 무시하고 다음 코드를 실행합니다.
    }

    int pageNumber = 0;// 페이지 번호를 0로 초기화합니다.
    int cntPT = 0;// 한 페이지에 출력할 항목 수를 0으로 초기화합니다.

    try {
        pageNumber = Integer.parseInt(request.getParameter("pageNumber")); // "pageNumber" 파라미터 값을 가져와서 정수로 변환하여 pageNumber 변수에 저장합니다.
    } catch (Exception e) {
        pageNumber = 1; // "pageNumber" 파라미터 값이 없거나 변환할 수 없는 경우 기본값으로 1을 할당합니다.
    }

    try {
        cntPT = Integer.parseInt(request.getParameter("cntPT")); // "cntPT" 파라미터 값을 가져와서 정수로 변환하여 cntPT 변수에 저장합니다.
    } catch (Exception e) {
        cntPT = 10; // "cntPT" 파라미터 값이 없거나 변환할 수 없는 경우 기본값으로 10을 할당합니다.
    }

    if (fromPT != 0) {
        // fromPT 값이 0이 아닌 경우, 페이지 번호를 계산하여 pageNumber 변수에 할당합니다.
        pageNumber = fromPT % cntPT == 0 ? fromPT / cntPT : (fromPT / cntPT) + 1;
    }

    Pagination pagination = studentScoreService.getPagination(pageNumber, cntPT); // pageNumber와 cntPT 값을 이용하여 Pagination 객체를 생성합니다.

    int k27_LineCnt = 0; // 라인 횟수를 셀 수 있는 숫자형 변수입니다.
    int c = pagination.getC(); // 현재 페이지 번호를 가져옵니다.
    int s = pagination.getS(); // 시작 버튼 번호를 가져옵니다.
    int e = pagination.getE(); // 마지막 버튼 번호를 가져옵니다.
    int p = pagination.getP(); // < 버튼 번호를 가져옵니다.
    int pp = pagination.getPp(); // << 버튼 번호를 가져옵니다.
    int n = pagination.getN(); // > 버튼 번호를 가져옵니다.
    int nn = pagination.getNn(); // >> 버튼 번호를 가져옵니다.

    List<StudentScore> studentScoreList = studentScoreDao.selectAll(c, cntPT); // c와 cntPT 값을 이용하여 학생 정보를 가져옵니다.
%>


<form method="post" id="form_1">
    <table cellspacing=1 width=600 border=1>
        <tr>
            <td width=50><p align="center">이름</p></td>
            <td width=50><p align="center">학번</p></td>
            <td width=50><p align="center">국어</p></td>
            <td width=50><p align="center">영어</p></td>
            <td width=50><p align="center">수학</p></td>
            <td width=50><p align="center">총점</p></td>
            <td width=50><p align="center">평균</p></td>
            <td width=50><p align="center">등수</p></td>
        </tr>
        
        <%
        for (StudentScore studentScore : studentScoreList) {// 현재 페이지에 해당하는 학생 점수 목록을 foreach를 사용하여 하나씩 읽는다.	
			if (studentScore.getStudentid() == searchStudentID){ //결과셋의 학번과 파라미터로받아온 학번이 같으면
                out.println("<tr style=\"background-color: yellow;\">"); // 해당 테이블 행에 노란 배경
            } else{
            	out.println("<tr>");//테이블의 데이터 행 시작   
            } 
			out.println("<td><p align=center>" + studentScore.getName() + "</p></td>");
			out.println("<td><p align=center>" + studentScore.getStudentid() + "</p></td>");// 학생의 학번을 출력합니다.
			out.println("<td><p align=right>" + studentScore.getKor() + "</p></td>"); // 국어 점수를 출력합니다.
		    out.println("<td><p align=right>" + studentScore.getEng() + "</p></td>"); // 영어 점수를 출력합니다.
		    out.println("<td><p align=right>" + studentScore.getMat() + "</p></td>"); // 수학 점수를 출력합니다.
		    out.println("<td><p align=center>" + studentScore.getSum() + "</p></td>"); // 총점을 출력합니다.
		    out.println("<td><p align=center>" + studentScore.getAve() + "</p></td>"); // 평균을 출력합니다.
		    out.println("<td><p align=center>" + studentScore.getRanking() + "</p></td>"); // 등수를 출력합니다.
		    out.println("</tr>");//테이블의 데이터 행 끝
		}
        
        out.println("<h1>레코드 삭제</h1>");//값을 보여주고 조회를 띄워준다
        %>

    </table>
</form>

         <!--버튼을 출력하기 위한 div 생성-->
        <div style ="text-align:left; font-weight: bold; font-size : 20pt;  margin-left:150px;">
                    <%if(pp != -1){ %> <!--pp값이 -1이면 보이지 않게 처리-->
                        <a href="Allview.jsp?pageNumber=<%= pp %>&cntPT=<%= cntPT %>&searchStudentID=<%=searchStudentID %>"><<</a><span></span> <!--무조건 1페이지로 이동하는 버튼-->
                        <!--p값을 통해 이전 10블록전으로 이동하는 버튼 출력 -->
                        <a href="Allview.jsp?pageNumber=<%= p %>&cntPT=<%= cntPT %>&searchStudentID=<%=searchStudentID %>"><</a>
                    <% } %>
                    
                        <%for (int index = s; index < e + 1; index++) {%>
                            <!--만약 시작번호 부터 끝 번호까지 버튼을 출력하기-->
                            <% if (index == c) {%> <!--만약 번호가 현재 페이지와 같다면 빨간색으로 출력하기-->
                            <a href="Allview.jsp?pageNumber=<%= index %>&cntPT=<%= cntPT %>&searchStudentID=<%=searchStudentID %>" style="color: red"><%= index %></a><span></span>
                            <%} else {%><!-- 현재 페이지와 같은 버튼이 아니라면 스타일 없이 버튼 출력-->
                            <a href="Allview.jsp?pageNumber=<%= index %>&cntPT=<%= cntPT %>&searchStudentID=<%=searchStudentID %>"><%= index %></a><span></span>
                            <% } %>
                            
                        <% } %>
                    
                    <%if(nn != -1) {%>
                    <!--다음 10블록 뒤로가는 버튼 생성-->
                    <a href="Allview.jsp?pageNumber=<%= n %>&cntPT=<%= cntPT %>&searchStudentID=<%=searchStudentID %>">></a> 
                    <!--맨 마지막 페이지로 가는 버튼 생성-->
                    <a href="Allview.jsp?pageNumber=<%= nn %>&cntPT=<%= cntPT %>&searchStudentID=<%=searchStudentID %>">>></a> 
                    <% } %>
        </div>

</body>
</html>