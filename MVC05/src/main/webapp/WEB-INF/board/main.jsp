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
	
	<script>
		$(document).ready(function(){
			loadList();
		});
		
		function loadList(){
			$.ajax({
				url : "${cpath}/boardList.do",
				type : "get",
				dataType : "json",
				success : resultHtml,
				error : function(){alert("error");}
			});
		}
		
		// 동적인 뷰 만들기 (초기 게시판의 리스트 화면)
		function resultHtml(data){
			var html = "<table class='table table-striped table-hover'>";
			html += "<tr><td>번호</td><td>제목</td><td>작성자</td><td>작성일</td><td>조회수</td></tr>";
			
			// jQuery 반복문
			// $.each(객체나 배열, function(인덱스, 요소))
			$.each(data, function(index, obj){
				html += "<tr><td>"+obj.num+"</td><td id='t"+obj.num+"'><a href='javascript:goView("+obj.num+")'>"+obj.title+"</a></td><td>"+obj.writer+"</td>";
				html += "<td>"+obj.indate+"</td><td id='cnt"+obj.num+"'>"+obj.count+"</td></tr>";
				
				html += "<tr id='ct"+obj.num+"' style='display:none'>";
				html += "<td>내용</td>";
				html += "<td colspan='4'>";
				html += "<textarea id='ta"+obj.num+"' style='resize: none;' rows='6' readonly class='form-control'>"+obj.content+"</textarea><br>";
				html += "<span id='ub"+obj.num+"'><button class='btn btn-sm btn-primary' onclick='goUpdateForm("+obj.num+")'>수정</button></span>&nbsp;";
				html += "<button id='del"+obj.num+"' class='btn btn-sm btn-warning' onclick='goDel("+obj.num+")'>삭제</button>&nbsp;";
				html += "<button onclick='loadList()' class='btn btn-sm btn-info'>닫기</button>";
				html += "</td>";
				html += "</tr>";
			});
			
			html += "<tr><td colspan='5' align='right'>";
			html += "<button onclick='goWrite()' class='btn btn-sm btn-success'>글쓰기</button>";
			html += "</td></tr>";
			html += "</table>";
			
			$("#list").html(html);
			
			// list는 보이게, write는 안보이게
			$("#list").css("display", "block");
			$("#write").css("display", "none");
		}
		
		// 글쓰기 화면으로 변경
		function goWrite(){
			$("#list").css("display", "none");
			$("#write").css("display", "block");
		}
		
		// 새로운 글 등록
		function goInsert(){
			// form에 있는 파라메터(name) 한번에 가져오기
			var fData = $("#frm").serialize();
			
			$.ajax({
				url : "${cpath}/boardWrite.do",
				type : "post",		// form데이터를 한번에 넘기므로 post
				data : fData,		// fData를 넘기기
				success : function(){
					alert("게시물 등록 완료");
					loadList();
				},
				error : function(){alert("error");}	
			});
			
			// 데이터를 전달한 후 reset버튼을 눌러 초기화
			$("#reset").trigger("click");
		}
		
		// 글쓰기중 목록으로 돌아가기
		function backToList(){
			var confirmFlag = confirm("글쓰기를 취소하시겠습니까?");
			if (confirmFlag){
				$("#reset").trigger("click");
				loadList();
			}
		}
		
		function goView(num){
			if ($("#ct"+num).css("display") == "none") {
				$("#ct" + num).css("display", "table-row");
				$.ajax({
					url : "${cpath}/boardView.do",
					type : "get",
					data : {"num":num},
					success : function(count){
						$("cnt"+num).text(count);
					}
				})
			} else {
				$("#ct" + num).css("display", "none");
			}
		}
		
		function goDel(num){
			$.ajax({
				url : "${cpath}/boardDelete.do",
				type : "get",
				data : {"num":num},
				success : function(){
					alert("삭제 완료");
					loadList();
				},
				error : function(){alert("error");}
			})
		}
		
		function goUpdateForm(num){
			var title = $("#t"+num).text();
			var titleInput = "<input id='nt"+num+"' type='text' value='"+title+"' class='form-control'>";
			$("#t"+num).html(titleInput);
			
			$("#ta"+num).attr("readonly", false);
			// 수정 > 수정하기 버튼 변경
			var updateBtn = "<button onclick='goUpdate("+num+")' class='btn btn-sm btn-success'>수정하기</button>";
			$("#ub"+num).html(updateBtn);
			$("#del"+num).css("display", "none");
		}
		
		function goUpdate(num){
			var title = $("#nt"+num).val();
			var content = $("#ta"+num).val();
			$.ajax({
				url : "${cpath}/boardUpdate.do",
				type : "get",
				data : {"num":num, "title":title, "content":content},
				success : function(){
					$("#del"+num).css("display", "block");
					loadList();
				},
				error : function(){alert("error");}
			});
		}
		
	</script>
</head>
<body>
	<div class="container">
	<jsp:include page="../header/header.jsp"/>
	  <h2>MVC05</h2>
	  <div class="panel panel-success">
	    <div class="panel-heading">BOARD</div>
	    <div class="panel-body" id="list"></div>
	    <div class="panel-body" id="write" style="display: none;">
	    	<form id="frm">
	    		<table class="table table-striped table-hover">
	    			<tr>
	    				<td>제목</td>
	    				<td><input type="text" name="title" id="title" class="form-control"/></td>
	    			</tr>
	    			<tr>
	    				<td>작성자</td>
	    				<td><input type="text" name="writer" id="writer" class="form-control"/></td>
	    			</tr>
	    			<tr>
	    				<td>내용</td>
	    				<td><textarea name="content" id="content" rows="15" class="form-control" style="resize: none;"></textarea></td>
	    			</tr>
	    			<tr>
	    			<td colspan="2" align="right">
	    				<button type="button" class="btn btn-success btn-sm" onclick="goInsert()">등록</button>
	    				<button type="reset" id="reset" class="btn btn-warning btn-sm">취소</button>
	    			</td>
	    			<td align="left">
	    				<button type="button" class="btn btn-success btn-sm" onclick="backToList()">목록</button>
	    			</td>
	    			</tr>
	    		</table>
	    	</form>
	    </div>	<!-- 글쓰기는 초기화면엔 none하고 글쓰기 버튼을 클릭하면 활성화시키기 -->
	    <div class="panel-footer">Spring 특화과정 A</div>
	  </div>
	</div>
	
	
</body>
</html>