<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	<!--jsp/ jstl/core의 접두사 선언 prefix -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL01</title>
</head>
<body>
<!-- 
* JSTL : 태그를 이용하여 프로그래밍적 동작 구현
- for : <forEach></forEach>
- if : <if></if>
- switch : <choose></choose>

* EL(Expression Language) : script tag의 표현식 업그레이드
  컨트롤러에서 request.setAttribute("data", data) 로 객체 바인딩을 해주면
  EL 식으로 request.getAttribute("data") 와 같은 작업을 해주는 것이다.
- var에 연결된 변수
- 연산자
- 속성 이름
-->
	<c:forEach var="i" begin="1" end="5" step="1">
		<font size="${i}">야호</font><br>
	</c:forEach>
</body>
</html>