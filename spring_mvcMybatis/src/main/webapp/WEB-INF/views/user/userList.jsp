<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
페이지
<form action = "" method = "post">
	<table border = "1" cellspacing = "5" cellpadding = "5">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>등록일</td>
		</tr>
		<c:forEach var="list" items="${user}">
		<tr>
			<td>${list.userId}</td>
			<td>${list.userName}</td>
			<td>${list.regDate}</td>
		</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>