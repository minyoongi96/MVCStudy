<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
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
	  <h2>MVC04</h2>
	  <div class="panel panel-success">
	    <div class="panel-heading">BOARD</div>
	    <div class="panel-body">Panel Content</div>
	    <input name="num1" type="text"/> + <input name="num2" type="text">
	    <button id="do">계산</button>
	    <button id="reset">지우기</button>
	    <div id="result">결과</div>
	    
	    <div class="panel-footer">Spring 특화과정 A</div>
	  </div>
	</div>
	
	<script>
		$(document).ready(function(){
			$("#do").on("click", function(){
				let num1 = $("input[name=num1]").val();
				let num2 = $("input[name=num2]").val();
				let result = Number(num1) + Number(num2);
				
				// 서버와 통신(비동기방식)
				$.ajax({
					url : "${cpath}/calc.do",
					type : "get",
					data : {"num1":num1, "num2":num2},
					success : function(data){
						$("#result").append("<span> : " + data + "</span>");	
					},
					error : function(){
						alert("error");
					}
				});
				
				//if(num1 != "" || num2 != ""){
				//	$("div.result").append("<span> : " + result + "</span>");	
				//}
			})
		});
		
	</script>
</body>
</html>