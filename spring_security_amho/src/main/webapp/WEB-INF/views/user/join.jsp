<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<%@ include file = "../include/header.jsp" %>
</head>
<body>
	<h2> 회원가입 </h2>
	<form action="${path}/user/insertUser.do" method = "post">
		
		 <%-- 크로스사이드 스크립팅 공격방어를 위해 스프링시큐리티에서는 반드시 아래값을 전달해야 에러가 발생안함
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
				<td>이름</td>
				<td><input type = "text" name = "name"></td>
			</tr>
			<tr>
				<td>사용권한</td>
				<td><select name = "authority">
					<option value = "ROLE_USER">일반사용자</option>
					<option value = "ROLE_ADMIN">관리자</option>
				</select></td>
			</tr>
			<tr>
				<td colspan = "2" align = "center"><input type = "submit" value = "회원가입"></td>
			</tr>
		</table>
	</form>
</body>
</html>