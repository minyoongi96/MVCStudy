<%@page import="java.util.ArrayList"%>
<%@page import="kr.board.entity.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>	<!-- Context Path를 변수로 저장하기 -->

<%
	Board vo = new Board();
	vo.setNum(1);
	vo.setTitle("게시판");
	vo.setContent("게시판 내용");
	vo.setWriter("관리자");
	List<Board> list = new ArrayList<Board>();
	list.add(vo);
	list.add(vo);
	list.add(vo);
	request.setAttribute("list", list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 리스트</title>
</head>
<body>
	<c:forEach var="vo" items="${list}">
		<p>Num : ${vo.num}</p>
	</c:forEach>
	
	<h2>Context Path 가져오기</h2>
	<p><%= request.getContextPath() %></p>		<!-- 자바 코드로 가져오는 법 -->
	<p>${cpath}</p>	<!-- EL로 가져오는 법 -->
</body>
</html>