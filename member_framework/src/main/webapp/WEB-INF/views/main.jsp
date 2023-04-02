<%--
  Created by IntelliJ IDEA.
  User: Happy
  Date: 2023-04-02
  Time: 오전 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
</head>
<body>
<%-- session에 email 값 가져옴 --%>
<h2>${sessionScope.loginEmail} 님 환영합니다.</h2>
<button onclick="update()">내정보 수정하기</button>
<button onclick="logout()">로그아웃</button>

</body>
<script>
  const update = () => {
    location.href = "/member/update";
  }
  const logout = () => {
    location.href = "/member/logout";
  }
</script>
</html>
