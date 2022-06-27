<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- logout.jsp -->
<%
	session.removeAttribute("loginMember");
	//로그아웃 시 쿠키정보 삭제 (다시 자동로그인 안됌)
	Cookie cookie = new Cookie("id", "");
	cookie.setMaxAge(0);
	response.addCookie(cookie);
%>
<script>
	alert("로그아웃 완료");
	location.href="index.jsp";
</script>