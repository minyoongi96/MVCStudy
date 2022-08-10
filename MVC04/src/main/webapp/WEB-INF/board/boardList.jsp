<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>  
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Main Board List</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<jsp:include page="../header/header.jsp"/>
	  <h2>MVC04</h2>
	  <div class="panel panel-success">
	    <div class="panel-heading">BOARD</div>
	    <div class="panel-body">
			<table class="table table-striped table-hover">
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일</td>
					<td>조회수</td>
				</tr>
				<c:forEach var="vo" items="${list}">
					<tr>
						<td>${vo.num}</td>
						<td><a href="${cpath}/boardView.do?num=${vo.num}">${vo.title}</a></td>
						<td>${vo.writer}</td>
						<td>${vo.indate}</td>
						<td>${vo.count}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="right">
						<button class="btn btn-success btn-sm" onclick="location.href='${cpath}/boardWriteForm.do'">글쓰기</button>
					</td>
				</tr>
			</table>
		</div>
	    <div class="panel-footer">Spring 특화과정 A</div>
	  </div>
	</div>
</body>
</html>