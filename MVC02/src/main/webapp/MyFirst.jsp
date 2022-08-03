<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<!-- 스크립틀릿 -->
<%
int a = 10;
int b = 20;
int sum = hap(a, b);
%>

<!-- 선언문  -->
<%!
public int hap(int a, int b){
	return a + b;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=a %> + <%=b %> = <%=sum%>
	 
</body>
</html>