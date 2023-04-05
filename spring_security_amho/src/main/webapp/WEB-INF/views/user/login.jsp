<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file = "../include/header.jsp" %>
<script type="text/javascript">
function join() {
	location.href = "${path}/user/join.do";
}
</script>
</head>
<body>
	<h2> 로그인 </h2>
	<span style = "color:red">${errMsg}</span>
	
	<!-- login_check.do는 컨트롤러가 아닌 security-context.xml의
				login-processing-url에서 정의함.
		2. 어플리케이션의 모든 요청은 DelegatingFilterProxy에 의해 필터되어 요청이 가로채짐(web.xml의 filter에 정의)
		스프링 시큐리티에 내장된 로직에 따라 id, 패스워드가 전달되고 
		UserAuthenticationService - loadUserByUsername으로 전달되어 비교(인증)처리한다.
		 -->
	<form action="${path}/user/login_check.do" method = "post">
		
		<%--  크로스사이드 스크립팅 공격방어를 위해 스프링시큐리티에서는 반드시 아래값을 전달해야 에러가 발생안함
			${_csrf.~} 사용
			name과 value는 반드시 아래 값을 사용해야한다. (규약)
		 --%>
		<!-- 필수 값 무조건 해야지만 암호화한다. -->
		<input type = "hidden" name = "${_csrf.parameterName}" value="${_csrf.token}">
		
		<table>
			<tr>
				<td>아이디</td>
				<td><input type = "text" name = "userid"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type = "password" name = "passwd"></td>
			</tr>
			<tr>
				<td colspan = "2"><input type = "submit" value = "로그인">
				<input type = "button" value = "회원가입" onclick = "join();"></td>
			</tr>
		</table>
	</form>
</body>
</html>