<%@page import="kr.board.entity.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	Board vo = new Board();
	vo.setNum(1);
	vo.setTitle("게시판");
	vo.setContent("게시판 내용");
	vo.setWriter("관리자");
	request.setAttribute("vo", vo);		// 객체 바인딩(원래는 컨트롤러에서 하는 작업)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL식, 객체 바인딩</title>
</head>
<body>
	${vo.num}  <!-- num은 private이지만 EL에선 vo.num으로 작성해도 톰캣에서 해석을 해준다. -->
</body>
</html>