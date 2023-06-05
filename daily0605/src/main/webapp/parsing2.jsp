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
	DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	//Document doc = docBuilder.parse(new File("/var/lib/tomcat9/webapps/ROOT/xml/testdata.xml"));
	Document doc = docBuilder.parse("http://192.168.23.214:8081/daily0605/xmlmake.jsp");
	
	Element root = doc.getDocumentElement();
	NodeList tag_name = doc.getElementsByTagName("name");
	NodeList tag_studentid = doc.getElementsByTagName("studentid");
	NodeList tag_kor = doc.getElementsByTagName("kor");
	NodeList tag_eng = doc.getElementsByTagName("eng");
	NodeList tag_mat = doc.getElementsByTagName("mat");
	
	
			out.println("<table cellspacing = 1 width =500 border = 1>");
			out.println("<tr>");
			out.println("<td width = 100>이름</td>");
			out.println("<td width = 100>학번</td>");
			out.println("<td width = 100>국어</td>");
			out.println("<td width = 100>영어</td>");
			out.println("<td width = 100>수학</td>");
			out.println("</tr>");
			
	for(int i = 0; i < tag_name.getLength(); i++){
		out.println("<tr>");
		out.println("<td width = 100>" + tag_name.item(i).getFirstChild().getNodeValue()+"</td>");
		out.println("<td width = 100>" + tag_studentid.item(i).getFirstChild().getNodeValue()+"</td>");
		out.println("<td width = 100>" + tag_kor.item(i).getFirstChild().getNodeValue()+"</td>");
		out.println("<td width = 100>" + tag_eng.item(i).getFirstChild().getNodeValue()+"</td>");
		out.println("<td width = 100>" + tag_mat.item(i).getFirstChild().getNodeValue()+"</td>");
		out.println("</tr>");
	}
%>
</body>
</html>