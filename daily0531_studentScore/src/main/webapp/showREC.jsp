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
    <script>

    function update(pa) {
        const form = document.getElementById('form_1');
        if (pa=='수정'){
            form.action = 'updateDB.jsp';
        } else if(pa=='삭제') {
            form.action = 'deleteDB.jsp';
        }
        form.submit();
    }

    function validateInput(inputElement) {
            const value = inputElement.value;
            var check = true;

            const pattern = /^[0-9]{6}$/; // 6자리 정수만 받는 정규식 선언

            if (inputElement.name === "searchID") {
                if (value === null || value === "") {
                    alert("학번을 입력해야 합니다!");
                    check = false;
                } else if (!pattern.test(value)) {
                    alert("학번은 6자리 정수로 입력해야 합니다!");
                    check = false;
                }
            }
            return check;
        }

        function handleSubmit() {
            const form = document.getElementById("inputForm2");
            const inputs = form.querySelectorAll("input");
            var valid = true;

            inputs.forEach(function (input) {
                if (!validateInput(input)) {
                    valid = false;
                }
            });

            if (valid == true) {
                form.submit();
            }
        }
    </script> 
</head>

<body> 
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

    int searchStudentID = 0;
       String searchIDParam = request.getParameter("searchID");
        if (searchIDParam != null && !searchIDParam.isEmpty()) {
        	searchStudentID = Integer.parseInt(searchIDParam);
        }

        StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
        StudentScore ss = studentScoreDao.selectBystudentid(searchStudentID);
        
%>

    <h1>성적 조회후 정정 / 삭제</h1>
    <form method="post" action="showREC.jsp" id="inputForm2">
        <table cellspacing=1 width=400 border=0>
            <tr>
                <td width=400>조회할 학번</td>
                <td width=300><p align=center></p><input type="text" name="searchID"></p></td>
                <td width=300><input type="submit" value="조회" onclick="handleSubmit()"></td>
            </tr>
        </table>
    </form>

                <% if(ss != null){ %>
                <form method="get" id="form_1">
                    <table cellspacing=1 width=400 border=1>
                            <tr>
                                <td width="100"><p align="center">이름</p></td>
                                <td width="300"><p align="center"><input type="text" name="name" value="<%= ss.getName() %>"></p></td>
                            </tr>
                            <tr>
                                <td width="100"><p align="center">학번</p></td>
                                <td width="300"><p align="center"><input type="text" name="searchID" value="<%= ss.getStudentid() %>"></p></td>
                            </tr>
                            <tr>
                                <td width="100"><p align="center">국어</p></td>
                                <td width="300"><p align="center"><input type="text" name="kor" value="<%= ss.getKor() %>"></p></td>
                            </tr>
                            <tr>
                                <td width="100"><p align="center">영어</p></td>
                                <td width="300"><p align="center"><input type="text" name="eng" value="<%= ss.getEng() %>"></p></td>
                            </tr>
                            <tr>
                                <td width="100"><p align="center">수학</p></td>
                                <td width="300"><p align="center"><input type="text" name="mat" value="<%= ss.getMat() %>"></p></td>
                            </tr>
                    </table>

                    <div style="position: relative; top: 20px; left: 310px;">
                    <span><input type="button" value="수정" onclick="update('수정')"></span>
                    <span><input type="button" value="삭제" onclick="update('삭제')"></span>
                    </div>
                </form>    

                <% } else { %>
                 <form method="get" id="form_1">
                    <table cellspacing=1 width=400 border=1>
                            <tr>
                                <td width="100"><p align="center">이름</p></td>
                                <td width="300"><p align="center"></p></td>
                            </tr>
                            <tr>
                                <td width="100"><p align="center">학번</p></td>
                                <td width="300"><p align="center">해당학번없음</p></td>
                            </tr>
                            <tr>
                                <td width="100"><p align="center">국어</p></td>
                                <td width="300"><p align="center"></p></td>
                            </tr>
                            <tr>
                                <td width="100"><p align="center">영어</p></td>
                                <td width="300"><p align="center"></p></td>
                            </tr>
                            <tr>
                                <td width="100"><p align="center">수학</p></td>
                                <td width="300"><p align="center"></p></td>
                            </tr>
                        </table>
                </form>
                <% } %>

</body>
</html>