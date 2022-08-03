<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>time.jsp</title>
</head>
<body>
	
	<!-- 자바 코드 입력할 수 있는 기호 -->
	<%	
		Date d = new Date();
	%>
	지금 시간은 : <%= d.toString() %>	<!-- 출력 방법 -->
</body>
</html>