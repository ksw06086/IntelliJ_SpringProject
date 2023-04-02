<%--
  Created by IntelliJ IDEA.
  User: Happy
  Date: 2023-04-02
  Time: 오후 3:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>save</title>
</head>
<body>
<form action="/board/save" method="post">
  <input type="text" name="boardWriter" placeholder="작성자">
  <input type="text" name="boardPass" placeholder="비밀번호">
  <input type="text" name="boardTitle" placeholder="제목">
  <textarea name="boardContents" cols="30" rows="10" placeholder="내용을 입력하세요"></textarea>
  <input type="submit" value="작성">
</form>
</body>
</html>