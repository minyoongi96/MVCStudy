<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="num" value="11"/>	<!-- 변수 선언 num = 10 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL02</title>
</head>
<body>
	<!-- if문(else는 존재하지 않음) -->
	<c:if test="${num % 2 == 0}">
		짝수입니다.
	</c:if>
	<c:if test="${num % 2 != 0}">
		홀수입니다.
	</c:if>
	<br>
	<!-- switch ~ case문 -->
	<c:choose>
		<c:when test="${num % 2 == 0}">
			짝수입니다.
		</c:when>
		<c:when test="${num % 2 != 0}">
			홀수입니다.
		</c:when>
		<c:otherwise>
			일치하는 when이 없을 때 실행
		</c:otherwise>
	</c:choose>
</body>
</html>