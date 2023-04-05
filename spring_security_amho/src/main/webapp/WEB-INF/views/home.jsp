<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="false" %>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<%@ include file="include/header.jsp" %>
</head>
<body>
<h2> WECOME !! </h2>
<h2 style="color:red"> ${msg} </h2>
<a href="${path}/admin/" style="color:red"> Host Page </a><br>
<a href="${path}/user/logout.do" style="color:red"> LogOut </a><br>
</body>
</html>
