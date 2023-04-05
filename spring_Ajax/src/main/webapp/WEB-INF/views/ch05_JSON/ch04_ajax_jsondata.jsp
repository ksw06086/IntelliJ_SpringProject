<%--
  Created by IntelliJ IDEA.
  User: Happy
  Date: 2023-04-05
  Time: PM 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <script src="/resources/js/jquery-3.4.1.min.js"></script>
  <script type="text/javascript">
    // data 타입이 .Json인 경우

    $(function() {
      $('#btn').click(function(){
        var obj = new Object();
        var data = '';
        $.ajax({
          url : '/resources/js/Jsondata.js', // new>file>파일명:Jsondata.js
          type : 'GET',
          dataType : 'json',
          success : function(obj) {
            alert(obj[0].name + "\n" + obj[0].tel + "\n" + obj[0].email);
            data = obj[0].name + "\n" + obj[0].tel + "\n" + obj[0].email;
            $('#result').html(data);
          },
          error : function() {
            alert('오류');
          }
        });
      });
    });
  </script>
</head>
<body>
<button id = "btn">Ajax 요청</button>
<hr>

<div id = "result">
  <!-- 결과 출력 위치 -->
</div>
</body>
</html>