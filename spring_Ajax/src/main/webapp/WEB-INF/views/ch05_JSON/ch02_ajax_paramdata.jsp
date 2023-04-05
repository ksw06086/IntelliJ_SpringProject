<%--
  Created by IntelliJ IDEA.
  User: Happy
  Date: 2023-04-05
  Time: PM 6:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<script src="/resources/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        // data 타입이 param인 경우

        $(function() {
            $('#btn').click(function(){
                var param = {};
                param.name = "김선우";
                param.tel = "010-111-1111";
                param.address = "맨하튼";

                $.ajax({
                    url : '${pageContext.request.contextPath}/paramdata_sub', // 컨트롤러/basic1_sub
                    type : 'POST',
                    data : param, 	// 전송할 데이터 타입
                    success : function(msg) { // 콜백함수 - 정상적으로 처리되었을 때의 결과가 result에 들어간다.
                        // 변수명이 반드시 . html(result)일 필요는 없으나 위 콜백함수의 변수명 result와 일치해야 한다.
                        $('#result').html(msg);
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