<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단.jsp</title>
</head>
<body>
	<table border="1">
		<tr>
			<%for(int i = 2; i <= 9; i++){%>
				<td style=text-align:center>
					<%=i%>단
				</td>
			<%}%>
		</tr>
		<%for(int i = 1; i <= 9; i++){%>
			<tr>
			<%for(int j = 2; j <= 9; j++){%>
					<td>
						<%=j%> * <%=i%> = <%=i*j%>
					</td>
				<%}%>
			</tr>
		<%}%>
	</table>
</body>
</html>