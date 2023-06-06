<%@page import="org.w3c.dom.Element"%>
<%@page import="org.w3c.dom.Document"%>
<%@page import="org.w3c.dom.NodeList"%>
<%@page import="java.io.File"%>
<%@page import="javax.xml.parsers.DocumentBuilderFactory"%>
<%@page import="javax.xml.parsers.DocumentBuilder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); // DocumentBuilder 객체를 생성합니다.

	Document doc = docBuilder.parse("http://192.168.23.214:8081/daily0605/xmlmake.jsp"); // 주어진 URL에서 XML 문서를 파싱합니다.

	Element root = doc.getDocumentElement(); // 문서의 루트 요소를 가져옵니다.

	NodeList tag_name = doc.getElementsByTagName("name"); // "name" 태그에 대한 NodeList를 가져옵니다.
	NodeList tag_studentid = doc.getElementsByTagName("studentid"); // "studentid" 태그에 대한 NodeList를 가져옵니다.
	NodeList tag_kor = doc.getElementsByTagName("kor"); // "kor" 태그에 대한 NodeList를 가져옵니다.
	NodeList tag_eng = doc.getElementsByTagName("eng"); // "eng" 태그에 대한 NodeList를 가져옵니다.
	NodeList tag_mat = doc.getElementsByTagName("mat"); // "mat" 태그에 대한 NodeList를 가져옵니다.

	out.println("<table cellspacing = 1 width =500 border = 1>"); // 테이블 태그를 출력합니다.
	out.println("<tr>"); // 테이블 행 시작
	out.println("<td width = 100>이름</td>"); // "이름" 헤더 셀 출력
	out.println("<td width = 100>학번</td>"); // "학번" 헤더 셀 출력
	out.println("<td width = 100>국어</td>"); // "국어" 헤더 셀 출력
	out.println("<td width = 100>영어</td>"); // "영어" 헤더 셀 출력
	out.println("<td width = 100>수학</td>"); // "수학" 헤더 셀 출력
	out.println("</tr>"); // 테이블 행 종료

	for (int i = 0; i < tag_name.getLength(); i++) {
		out.println("<tr>"); // 테이블 행 시작
		out.println("<td width = 100>" + tag_name.item(i).getFirstChild().getNodeValue() + "</td>"); // "name" 태그의 값 출력
		out.println("<td width = 100>" + tag_studentid.item(i).getFirstChild().getNodeValue() + "</td>"); // "studentid" 태그의 값 출력
		out.println("<td width = 100>" + tag_kor.item(i).getFirstChild().getNodeValue() + "</td>"); // "kor" 태그의 값 출력
		out.println("<td width = 100>" + tag_eng.item(i).getFirstChild().getNodeValue() + "</td>"); // "eng" 태그의 값 출력
		out.println("<td width = 100>" + tag_mat.item(i).getFirstChild().getNodeValue() + "</td>"); // "mat" 태그의 값 출력
		out.println("</tr>"); // 테이블 행 종료
	}
%>
</body>
</html>
