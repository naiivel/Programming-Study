<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elTest.jsp</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	parameter : <%=request.getParameter("test")%><br/>
	EL param : ${param.test} <br/>
	<input type="text" value="${param.test}" />
</body>
</html>