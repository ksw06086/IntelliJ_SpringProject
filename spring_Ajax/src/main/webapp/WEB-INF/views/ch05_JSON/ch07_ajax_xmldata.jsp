<%--
  Created by IntelliJ IDEA.
  User: Happy
  Date: 2023-04-05
  Time: PM 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/resources/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        // data 타입이 XML인 경우

        $(function() {
            $('#btn').click(function(){
                $.ajax({
                    url : '/resources/js/xmldata.xml',
                    type : 'GET',
                    success : function(data) { // 콜백함수 - 정상적으로 처리되었을 때의 결과가 result에 들어간다.
                        // 변수명이 반드시 . html(result)일 필요는 없으나 위 콜백함수의 변수명 result와 일치해야 한다.
                        var text = "";
                        $(data).find('season').each(function() {
                            var item = $(this).text(); // 실제값 파싱.. 봄, 여름, 가을, 겨울
                            text += $(this).text();
                        });
                        $('#result').html(text);
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