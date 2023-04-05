<%--
  Created by IntelliJ IDEA.
  User: Happy
  Date: 2023-04-05
  Time: PM 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <script src="/resources/js/jquery-3.4.1.min.js"></script>
  <script type="text/javascript">
    // data 타입이 get 방식인 경우

    $(function() {
      $('#btn').click(function(){
        $.ajax({
          url : '${pageContext.request.contextPath}/paramdata3_sub?data=happy', // '{컨트롤러}/매핑주소'로 이동
          type : 'GET',
          success : function(data) {
            alert(data);
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