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
	<title>Board View</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script>
		function goList(){
			location.href = "/MVC02/boardList.do";
		}
		function goDelete(num){
			location.href = "/MVC02/boardDelete.do?num=" + num;
		}
		function goUpdate(num){
			location.href = "/MVC02/boardUpdateForm.do?num=" + num;
		}
	</script>
</head>
<body>
	<div class="container">
	  <h2>MVC02</h2>
	  <div class="panel panel-success">
	    <div class="panel-heading">게시물 상세보기</div>
	    <div class="panel-body">
	    	<table class="table table-striped table-hover">
	    		<tr>
	    			<td>제목</td>
	    			<td><%=vo.getTitle() %></td>
	    		</tr>
	    		<tr>
	    			<td>작성자</td>
	    			<td><%=vo.getWriter() %></td>
	    		</tr>
	    		<tr>
	    			<td>내용</td>
	    			<td><textarea style="resize: none;" rows="15" readonly="readonly" class="form-control"><%=vo.getContent() %></textarea></td>
	    		</tr>
	    		<tr>
	    			<td>작성일</td>
	    			<td><%=vo.getIndate() %></td>
	    		</tr>
	    		<tr>
	    		<td colspan="2" align="right">
	    			<button class="btn btn-sm btn-primary" onclick="goUpdate(<%=vo.getNum()%>)">수정</button>
	    			<button class="btn btn-sm btn-warning" onclick="goDelete(<%=vo.getNum()%>)">삭제</button>
	    			<button class="btn btn-sm btn-info" onclick="goList()">목록</button>
	    		</td>
	    		</tr>
	    	</table>
	    </div>
	    <div class="panel-footer">Spring 특화과정 A</div>
	  </div>
	</div>
</body>
</html>