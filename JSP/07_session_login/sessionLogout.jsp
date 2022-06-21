<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionLogout.jsp</title>
</head>
<body>
<!-- 1805136F7A1A4AD5BFFE5B1226642B59 -->
	<%=session.getId()%><br/>
	<%=session.getAttribute("MEMBERUID")%>
	로그아웃 완료 되었습니다.
</body>
</html>
<%
	session.removeAttribute("MEMBERUID");
	//session 객체 삭제
	//session.invalidate();
	
	//session 생성시간
	long create = session.getCreationTime();
	//마지막으로 요청을 보낸 시간
	long last = session.getLastAccessedTime();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	out.print("create : " + sdf.format(new Date(create))+"<br/>");
	out.print("last : " + sdf.format(new Date(last))+"<br/>");
	
	//session 유지 시간 - second
	long max = session.getMaxInactiveInterval();
	out.print("session 유지시간 : " + max);
	//세션 유지시간 설정 - second
	session.setMaxInactiveInterval(30);
	max = session.getMaxInactiveInterval();
	out.print("session 유지시간 : " + max);
%>