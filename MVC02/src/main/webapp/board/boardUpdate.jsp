<%@page import="kr.board.entity.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
Board vo = (Board)request.getAttribute("vo");
 %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Main Board</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<jsp:include page="../header/header.jsp"/>
	  <h2>MVC02</h2>
	  <div class="panel panel-success">
	    <div class="panel-heading">게시물 수정</div>
	    <div class="panel-body">
	    	<form action="/MVC02/boardUpdate.do" method="post">
	    		<input type="hidden" name="num" value="<%=vo.getNum()%>"/>
		    	<table class="table table-striped table-hover">
		    		<tr>
		    			<td>제목</td>
		    			<td><input type="text" name="title" class="form-control" value="<%=vo.getTitle() %>"/></td>
		    		</tr>
		    		<tr>
		    			<td>작성자</td>
		    			<td><%=vo.getWriter() %></td>
		    		</tr>
		    		<tr>
		    			<td>제목</td>
		    			<td><textarea name="content" rows="15" class="form-control" style="resize: none;"><%=vo.getContent() %></textarea></td>
		    		</tr>
		    		<tr>
		    			<td colspan="2" align="right">
		    				<button type="submit" class="btn btn-success btn-primary" onclick="location.href='/MVC02/boardUpdate.do'">수정</button>
		    				<button type="reset" class="btn btn-warning btn-sm">취소</button>
		    			</td>
		    			<td align="left">
		    				<button type="button" class="btn btn-success btn-sm" onclick="location.href='/MVC02/boardList.do'">목록</button>
		    			</td>
		    		</tr>
		    	</table>
	    	</form>
	    </div>
	    <div class="panel-footer">Spring 특화과정 A</div>
	  </div>
	</div>
</body>
</html>