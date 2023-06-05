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
        
        // 입력된 매개변수(pa)에 따라 form의 action을 설정해줍니다.
        // '수정'인 경우 'updateDB.jsp'로, '삭제'인 경우 'deleteDB.jsp'로 설정합니다.
        if (pa === '수정') {
            form.action = 'updateDB.jsp';
        } else if (pa === '삭제') {
            form.action = 'deleteDB.jsp';
        }
        
        form.submit(); // form을 제출합니다.
    }

    function validateInput1(inputElement) {//유효성을 검사하는 함수
        const value = inputElement.value;//input에 담긴 value값을 담아서 value에 저장
        
        var check = true;//check를 하기위한 변수 선언 및 초기화

        const pattern1 = /^([a-zA-Z]|[가-힣])+$/; // 한글, 영어만 입력받는 정규식1 생성
        const pattern2 = /^.{1,20}$/; // 20자 이내만 입력받는 정규식2 생성
        const pattern3 = /^(?:100|[1-9]?[0-9])$/; // 0~100사이의 정수값만 입력받는 정규식3 생성
        const pattern = /^[0-9]{6}$/; // 6자리 정수만 받는 정규식 선언

	if (inputElement.name === "searchID") {//가져온 name이 searchID이라면
                if (value === null || value === "") {//name이 없을 경우
                    alert("학번을 입력해야 합니다!");//알람창 띄우기
                    check = false;//check값을 false로 리턴
                } else if (!pattern.test(value)) {//가져온 값 검사
                    alert("학번은 6자리 정수로 입력해야 합니다!");
                    check = false;//check값을 false로 리턴
                }
            }

        if (inputElement.name === "name") {//가져온 name이 name이라면
            if (value === null || value === "") {//name이 없을 경우
                alert("이름을 입력해야 합니다!");//알람창 띄우기
                inputElement.focus();//해당 칸에 focus주기
                check = false;//check값을 false로 리턴
            } else if (!pattern1.test(value) || !pattern2.test(value)) {
                alert("이름은 한글 또는 영어로 1자 이상 20자 이내로 입력해야 합니다!");
                inputElement.value = ""; // 입력 값을 초기화하거나 다른 조치를 취할 수 있습니다.
                inputElement.focus();//해당 칸에 focus주기
                check = false;//check값을 false로 리턴
            }
        } else if (inputElement.name === "kor" || inputElement.name === "eng" || inputElement.name === "mat") {
        	//가져온 name이 kor이거나 eng이거나 mat이면
            if (value === null || value === "") {// 값이 없을 경우
                if (inputElement.name === "kor") {
                    alert("국어 점수를 입력해야 합니다!");//알람창 띄우기
                } else if (inputElement.name === "eng") {
                    alert("영어 점수를 입력해야 합니다!");//알람창 띄우기
                } else if (inputElement.name === "mat") {
                    alert("수학 점수를 입력해야 합니다!");//알람창 띄우기
                }
                check = false;//check값을 false로 리턴
            } else if (!pattern3.test(value)) {
                if (inputElement.name === "kor") {//국어 값이 들어왔을때
                    alert("국어 성적은 0에서 100까지의 정수로 입력해야 합니다!");
                } else if (inputElement.name === "eng") {//영어 값이 들어왔을때
                    alert("영어 성적은 0에서 100까지의 정수로 입력해야 합니다!");
                } else if (inputElement.name === "mat") {//수학 값이 들어왔을때
                    alert("수학 성적은 0에서 100까지의 정수로 입력해야 합니다!");
                }
                inputElement.focus();//해당 칸에 focus주기
                inputElement.value = ""; // 입력 값을 초기화하거나 다른 조치를 취할 수 있습니다.
                check = false;//check값을 false로 리턴
            }
        }
        return check;//최종 check된 값을 리턴하기
    }
    
        function handleSubmit() {
            const form = document.getElementById("inputForm2"); // 폼 요소를 가져옵니다.
            const inputs = form.querySelectorAll("input"); // 폼 내의 모든 입력 요소를 가져옵니다.
            var valid = true; // 유효성 검사 결과를 저장할 변수입니다.

            // 각 입력 요소에 대해 유효성 검사를 수행합니다.
            inputs.forEach(function (input) {
                if (!validateInput(input)) { // 입력 요소가 유효하지 않은 경우
                    valid = false; // 유효성 검사 결과를 false로 설정합니다.
                }
            });

            if (valid == true) { // 모든 입력 요소가 유효한 경우
                form.submit(); // 폼을 제출합니다.
            }
        }
    </script> 
</head>

<body> 
<% 
	//요청과 응답의 문자 인코딩을 UTF-8로 설정
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

    int searchStudentID = 0;
    //searchID 파라미터를 받아서 searchStudentID 변수에 정수로 변환하여 저장
       String searchIDParam = request.getParameter("searchID");
       try{
    	   //문자형을 숫자형을 변환하여 숫자형 변수에 저장
    	   searchStudentID = Integer.parseInt(searchIDParam);
          }catch(Exception e){
          }

        StudentScoreDao studentScoreDao = new StudentScoreDaoImpl();
        //StudentScoreDao를 사용하여 학번을 기준으로 학생 정보를 조회
        StudentScore ss = studentScoreDao.selectByStudentId(searchStudentID);
        //학번을 기준으로 학생 정보를 각각의 변수에 저장
        String name="";
        int studentid = 0;
        int kor = 0;
        int eng = 0;
        int mat = 0;
        try{
         name = ss.getName();//학번을 기준으로 이름 정보를 name 변수에 저장
        }catch(Exception e){
        }
        try{
         studentid = ss.getStudentid();//학번을 기준으로 학번 정보를 studentid 변수에 저장
        }catch(Exception e){
        }
        try{
        	kor = ss.getKor();//학번을 기준으로 국어 정보를 kor 변수에 저장
        }catch(Exception e){
        }
        try{
        	eng = ss.getEng();//학번을 기준으로 영어 정보를 eng 변수에 저장
        }catch(Exception e){
        }
        try{
        	mat = ss.getMat();//학번을 기준으로 수학 정보를 mat 변수에 저장
        }catch(Exception e){
        }
    
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

                <% if(ss != null){ %><!-- 가져온 객체 값이 있을 경우 -->
                <form method="get" id="form_1">
                    <table cellspacing=1 width=400 border=1>
                            <tr>
                                <td width="100"><p align="center">이름</p></td><!-- 가져온 객체의 이름값을 출력 -->
                                <td width="300"><p align="center"><input type="text" name="name" value="<%=name%>" onchange="validateInput(this)"></p></td>
                            </tr>
                            <tr>
                                <td width="100"><p align="center">학번</p></td><!-- 가져온 객체의 학번 출력 -->
                                <td width="300"><p align="center"><input type="text" name="searchID" value="<%=studentid%>" readonly></p></td>
                            </tr>
                            <tr>
                                <td width="100"><p align="center">국어</p></td><!-- 가져온 객체의 국어 출력 -->
                                <td width="300"><p align="center"><input type="text" name="kor" value="<%=kor%>" onchange="validateInput(this)"></p></td>
                            </tr>
                            <tr>
                                <td width="100"><p align="center">영어</p></td><!-- 가져온 객체의 영어 출력 -->
                                <td width="300"><p align="center"><input type="text" name="eng" value="<%=eng%>" onchange="validateInput(this)"></p></td>
                            </tr>
                            <tr>
                                <td width="100"><p align="center">수학</p></td><!-- 가져온 객체의 수학 출력 -->
                                <td width="300"><p align="center"><input type="text" name="mat" value="<%=mat%>" onchange="validateInput(this)"></p></td>
                            </tr>
                    </table>

                    <div style="position: relative; top: 20px; left: 310px;">
                    <!-- 버튼은 각자 "수정"과 "삭제" 값을 가지며, 클릭 시 update 함수가 호출됩니다. -->
                    <span><input type="button" value="수정" onclick="update('수정')"></span>
                    <span><input type="button" value="삭제" onclick="update('삭제')"></span>
                    </div>
                </form>    

                <% } else { %><!-- 가져온 객체 값이 아무것도 없을 경우 -->
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