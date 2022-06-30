<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<!-- application 영역에 등록된 회원 정보 -->
	<jsp:useBean id="joinMember" class="beans.MemberBean" scope="application" />
	
	<jsp:useBean id="loginMember" class="beans.MemberBean" scope="session" />
	<%
		request.setCharacterEncoding("UTF-8");
		Cookie[] cookies = request.getCookies();
		if(cookies != null && joinMember.getId() != null && loginMember.getId() == null){
			for(int i=0; i<cookies.length; i++){
				System.out.println(cookies[i].getName()+":"+cookies[i].getValue());
				if(cookies[i].getName().equals("id") && cookies[i].getValue().equals(joinMember.getId())){
					session.setAttribute("loginMember", joinMember);
					loginMember = joinMember;
				}
			}
		}
	%>
	<h1>INDEX JSP</h1>
	<%
		String name = loginMember.getName();
		if(name != null){
			//로그인이 완료된 상태
	%>
		<%=name%>님 방가방가 | <a href="logOut.jsp">로그아웃</a>		
	<%	} else {
		
			//로그인이 안된 상태
	%>
		<a href="login.jsp">로그인</a> | <a href="join.jsp">회원가입</a>
	<%		
		}
	%>
</body>
</html>
