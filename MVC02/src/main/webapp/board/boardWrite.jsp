<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Board Write</title>
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
	    <div class="panel-heading">BOARD</div>
	    <div class="panel-body">
	    	<form action="/MVC02/boardWrite.do" method="post">
	    		<table class="table table-striped table-hover">
	    			<tr>
	    				<td>제목</td>
	    				<td><input type="text" name="title" class="form-control"/></td>
	    			</tr>
	    			<tr>
	    				<td>작성자</td>
	    				<td><input type="text" name="writer" class="form-control"/></td>
	    			</tr>
	    			<tr>
	    				<td>내용</td>
	    				<td><textarea name="content" rows="15" class="form-control" style="resize: none;"></textarea></td>
	    			</tr>
	    			<tr>
	    			<td colspan="2" align="right">
	    				<button type="submit" class="btn btn-success btn-sm">등록</button>
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