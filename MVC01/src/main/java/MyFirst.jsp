<!-- page 지시자ㄴ -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    


<!-- 스크립틀릿(자바코드) -->
<%
int a = 10;
int b = 20;
int sum = hap(a, b);
%>

<!-- 선언문(메서드)  -->
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
	<!-- 출력 -->
	<%=a %> + <%=b %> = <%=sum%>
	
	<!-- 태그로 for문 사용하기 -->
	<for begin="1" end="5" step="1">
	
	</for>
	
	<if test="a < b">
	</if>
</body>
</html>