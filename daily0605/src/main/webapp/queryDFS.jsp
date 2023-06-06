<%@page import="org.w3c.dom.Element"%>
<%@page import="org.w3c.dom.Document"%>
<%@page import="org.w3c.dom.NodeList"%>
<%@page import="java.io.File"%>
<%@page import="javax.xml.parsers.DocumentBuilderFactory"%>
<%@page import="javax.xml.parsers.DocumentBuilder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	Document doc = docBuilder.parse("http://www.kma.go.kr/wid/queryDFS.jsp?gridx=61&gridy=123");
	
String seq="";//48시간중 몇번째 인지 가르킴
String temp="";//현재 시간온도
String tmx="";// 최고 온도
String tmn="";// 최저 온도
String sky="";// 하늘 상태코드 (1: 맑음, 2:구름조금, 3:구름많음, 4:흐림)
String pty="";// 강수 상태코드 (0: 없음, 1: 비, 2:비/눈, 3:눈/비, 4:눈)
String wfKor="";// 날씨 한국어
String wfEn="";// 날씨 영어
String pop=""; //강수 확률%
String r12=""; //12시간 예상 강수량
String s12=""; //12시간 예상 적설량
String ws=""; //풍속 (m/s)
String wd=""; //풍향 (0~7: 북, 북동, 동, 남동, 남, 남서, 서, 북서)
String wdKor=""; // 풍향 한국어
String wdEn=""; //풍향 영어 
String reh=""; //습도 %
String r06=""; //6시간 예상 강수량 
String s06="";//6시간 예상 적설량

out.println("<table cellspacing = 1 width =500 border = 1>");
out.println("<tr>");
out.println("<td width = 100>seq</td>"); // 순서
out.println("<td width = 100>datetime</td>"); // 날짜와 시간
out.println("<td width = 100>temp</td>"); // 현재 온도
out.println("<td width = 100>tmx</td>"); // 최고 온도
out.println("<td width = 100>tmn</td>"); // 최저 온도
out.println("<td width = 100>sky</td>"); // 하늘 상태
out.println("<td width = 100>pty</td>"); // 강수형태
out.println("<td width = 100>wfKor</td>"); // 날씨(한국어)
out.println("<td width = 100>wfEn</td>"); // 날씨(영어)
out.println("<td width = 100>pop</td>"); // 강수확률
out.println("<td width = 100>r12</td>"); // 12시간 강수량
out.println("<td width = 100>s12</td>"); // 12시간 신적설
out.println("<td width = 100>ws</td>"); // 풍속
out.println("<td width = 100>wd</td>"); // 풍향
out.println("<td width = 100>wdKor</td>"); // 풍향(한국어)
out.println("<td width = 100>wdEn</td>"); // 풍향(영어)
out.println("<td width = 100>reh</td>"); // 습도
out.println("<td width = 100>r06</td>"); // 6시간 강수량
out.println("<td width = 100>s06</td>"); // 6시간 신적설
out.println("</tr>");

Element root = doc.getDocumentElement();
NodeList tag_001 = doc.getElementsByTagName("data"); // XML 데이터 태그

for (int i = 0; i < tag_001.getLength(); i++) {
    Element elmt = (Element) tag_001.item(i);
    
    // 시간 정보 처리
    String hour = elmt.getElementsByTagName("hour").item(0).getFirstChild().getNodeValue();
    String formattedHour = "";
    if (hour.equals("0")) {
        formattedHour = "00:00";
    } else {
        formattedHour = String.format("%02d:00", Integer.parseInt(hour));
    }

    // 날짜 정보 처리
    String day = elmt.getElementsByTagName("day").item(0).getFirstChild().getNodeValue();
    String formattedDay = "";
    if (day.equals("0")) {
        formattedDay = "오늘";
    } else if (day.equals("1")) {
        formattedDay = "내일";
    } else if (day.equals("2")) {
        formattedDay = "모래";
    }
    // 날짜와 시간을 조합하여 표시 형식으로 변환
    String datetime = formattedDay + " " + formattedHour;
	    
    String skyCode = elmt.getElementsByTagName("sky").item(0).getFirstChild().getNodeValue();
    String weatherImage = "";

    // "sky" 요소의 값에 따라 해당하는 이미지 파일명 설정
    if (skyCode.equals("1")) {
        weatherImage = "기호 - 복사본 (1).jpg"; // 맑음에 해당하는 그림 파일명
    } else if (skyCode.equals("2")) {
        weatherImage = "기호 - 복사본 (9).jpg"; // 구름조금에 해당하는 그림 파일명
    } else if (skyCode.equals("3")) {
        weatherImage = "기호 - 복사본 (2).jpg"; // 구름많음에 해당하는 그림 파일명
    } else if (skyCode.equals("4")) {
        weatherImage = "기호 - 복사본 (8).jpg"; // 흐림에 해당하는 그림 파일명
    } else {
        // 기본값 또는 다른 경우에 대한 처리
        weatherImage = "기호 - 복사본 (2).jpg"; // 알 수 없는 그림 파일명 또는 기본 그림 파일명
    }

    String ptyCode = elmt.getElementsByTagName("pty").item(0).getFirstChild().getNodeValue();
    String ptyImage = "";

    // "pty" 요소의 값에 따라 해당하는 이미지 파일명 설정
    if (ptyCode.equals("0")) { // 강수없음
        ptyImage = "기호 - 복사본 (1).jpg";
    } else if (ptyCode.equals("1")) { // 비
        ptyImage = "기호 - 복사본 (4).jpg";
    } else if (ptyCode.equals("2")) { // 비/눈
        ptyImage = "기호 - 복사본 (7).jpg";
    } else if (ptyCode.equals("3")) { // 눈/비
        ptyImage = "기호 - 복사본 (7).jpg";
    } else {
	        // 기본값 또는 다른 경우에 대한 처리
	        ptyImage = "기호 - 복사본 (2).jpg"; // 알 수 없는 그림 파일명 또는 기본 그림 파일명
	    }
	    
	    String wfKorCode = elmt.getElementsByTagName("wfKor").item(0).getFirstChild().getNodeValue();
	    String wfKorImage = "";

	    if (wfKorCode.equals("맑음")) {
	    	wfKorImage = "기호 - 복사본 (1).jpg"; // 맑음에 해당하는 그림 파일명
	    } else if (wfKorCode.equals("구름많음")) {
	    	wfKorImage = "기호 - 복사본 (9).jpg"; // 구름조금에 해당하는 그림 파일명
	    } else if (wfKorCode.equals("구름많음")) {
	    	wfKorImage = "기호 - 복사본 (2).jpg"; // 구름많음에 해당하는 그림 파일명
	    } else if (wfKorCode.equals("흐림")) {
	    	wfKorImage = "기호 - 복사본 (8).jpg"; // 흐림에 해당하는 그림 파일명
	    } else {
	        // 기본값 또는 다른 경우에 대한 처리
	        wfKorImage = "기호 - 복사본 (2).jpg"; // 알 수 없는 그림 파일명 또는 기본 그림 파일명
	    }
	    
	    String wfEnCode = elmt.getElementsByTagName("wfEn").item(0).getFirstChild().getNodeValue();
	    String wfEnImage = "";

	    if (wfEnCode.equals("Clear")) {
	    	wfEnImage = "기호 - 복사본 (1).jpg"; // 맑음에 해당하는 그림 파일명
	    } else if (wfEnCode.equals("Mostly Cloudy")) {
	    	wfEnImage = "기호 - 복사본 (9).jpg"; // 구름조금에 해당하는 그림 파일명
	    } else if (wfEnCode.equals("Cloudy")) {
	    	wfEnImage = "기호 - 복사본 (2).jpg"; // 구름많음에 해당하는 그림 파일명
	    } else {
	        // 기본값 또는 다른 경우에 대한 처리
	        wfEnImage = "기호 - 복사본 (2).jpg"; // 알 수 없는 그림 파일명 또는 기본 그림 파일명
	    }
	    
	    out.println("<tr>");
	    out.println("<td width = 100>" + tag_001.item(i).getAttributes().getNamedItem("seq").getNodeValue()+"</td>"); // seq 값 출력
	    out.println("<td width = 100>" + datetime +"</td>"); // 날짜 및 시간 출력
	    out.println("<td width = 100>" + elmt.getElementsByTagName("temp").item(0).getFirstChild().getNodeValue()+"</td>"); // 온도 출력
	    out.println("<td width = 100>" + elmt.getElementsByTagName("tmx").item(0).getFirstChild().getNodeValue()+"</td>"); // 최고 기온 출력
	    out.println("<td width = 100>" + elmt.getElementsByTagName("tmn").item(0).getFirstChild().getNodeValue()+"</td>"); // 최저 기온 출력
	    out.println("<td width = 100><img width = 100 src=\"images/" + weatherImage + "\" alt=\"날씨 그림\"></td>"); // 날씨 이미지 출력
	    out.println("<td width = 100><img width = 100 src=\"images/" + ptyImage + "\" alt=\"날씨 그림\"></td>"); // 강수 형태 이미지 출력
	    out.println("<td width = 100><img width = 100 src=\"images/" + wfKorImage + "\" alt=\"날씨 그림\"></td>"); // 날씨 상태(한국어) 이미지 출력
	    out.println("<td width = 100><img width = 100 src=\"images/" + wfEnImage + "\" alt=\"날씨 그림\"></td>"); // 날씨 상태(영어) 이미지 출력
	    out.println("<td width = 100>" + elmt.getElementsByTagName("pop").item(0).getFirstChild().getNodeValue()+"</td>"); // 강수 확률 출력
	    out.println("<td width = 100>" + elmt.getElementsByTagName("r12").item(0).getFirstChild().getNodeValue()+"</td>"); // 12시간 강수량 출력
	    out.println("<td width = 100>" + elmt.getElementsByTagName("s12").item(0).getFirstChild().getNodeValue()+"</td>"); // 12시간 적설량 출력
	    out.println("<td width = 100>" + elmt.getElementsByTagName("ws").item(0).getFirstChild().getNodeValue()+"</td>"); // 풍속 출력
	    out.println("<td width = 100>" + elmt.getElementsByTagName("wd").item(0).getFirstChild().getNodeValue()+"</td>"); // 풍향 출력
	    out.println("<td width = 100>" + elmt.getElementsByTagName("wdKor").item(0).getFirstChild().getNodeValue()+"</td>"); // 풍향(한국어) 출력
	    out.println("<td width = 100>" + elmt.getElementsByTagName("wdEn").item(0).getFirstChild().getNodeValue()+"</td>"); // 풍향(영어) 출력
	    out.println("<td width = 100>" + elmt.getElementsByTagName("reh").item(0).getFirstChild().getNodeValue()+"</td>"); // 습도 출력
	    out.println("<td width = 100>" + elmt.getElementsByTagName("r06").item(0).getFirstChild().getNodeValue()+"</td>"); // 6시간 강수량 출력
	    out.println("<td width = 100>" + elmt.getElementsByTagName("s06").item(0).getFirstChild().getNodeValue()+"</td>"); // 6시간 적설량 출력
	    out.println("</tr>");

	}   
%>
</body>
</html>
