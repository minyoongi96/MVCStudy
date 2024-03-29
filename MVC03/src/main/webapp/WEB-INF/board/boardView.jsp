<%@page import="kr.board.entity.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="cpath" value="${pageContext.request.contextPath}" />
<% pageContext.setAttribute("newLineChar", "\n"); %>

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
			location.href = "${cpath}/boardList.do";
		}
		function goDelete(num){
			location.href = "${cpath}/boardDelete.do?num=" + num;
		}
		function goUpdate(num){
			location.href = "${cpath}/boardUpdateForm.do?num=" + num;
		}
	</script>
</head>
<body>
	<div class="container">
	  <h2>MVC03</h2>
	  <div class="panel panel-success">
	    <div class="panel-heading">게시물 상세보기</div>
	    <div class="panel-body">
	    	<table class="table table-striped table-hover">
	    		<tr>
	    			<td>제목</td>
	    			<td>${vo.title }</td>
	    		</tr>
	    		<tr>
	    			<td>작성자</td>
	    			<td>${vo.writer }</td>
	    		</tr>
	    		<tr>
	    			<td>내용</td>
	    			<td><textarea style="resize: none;" rows="15" readonly="readonly" class="form-control">${vo.content }</textarea></td>
	    		</tr>
	    		<tr>
	    			<td>작성일</td>
	    			<td>${fn:split(vo.indate, " ")[0]}</td>
	    		</tr>
	    		<tr>
	    		<td colspan="2" align="right">
	    			<button class="btn btn-sm btn-primary" onclick="goUpdate(${vo.num})">수정</button>
	    			<button class="btn btn-sm btn-warning" onclick="goDelete(${vo.num})">삭제</button>
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