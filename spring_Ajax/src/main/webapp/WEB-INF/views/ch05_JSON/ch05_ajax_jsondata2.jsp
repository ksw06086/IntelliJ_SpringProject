<%--
  Created by IntelliJ IDEA.
  User: Happy
  Date: 2023-04-05
  Time: PM 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <script src="/resources/js/jquery-3.4.1.min.js"></script>
  <script type="text/javascript">
    // data 타입이 JsonData Type인 경우

    $(function() {
      $('#btn').click(function(){
        // 자바스크립트 객체 생성
        let obj = new Object();
        obj.id = 'hong';
        obj.name = 'kil dong';

        // json 객체를 String 객체로 변환 --
        // 제이슨은 안드로이드에서 이제는 jsp로 하지 않고 안드로이드에서 뿌려줄 때 json 형식으로 불러와서 활용한다.
        // 빅데이터 00데이터들은 실제 값들을 XML로 많이 사용할 것임
        let jsonData = JSON.stringify(obj);

        // cf) String 객체를 json 객체로 변환
        // var jsonData = JSON.parse(obj);
        $.ajax({
          url : '${pageContext.request.contextPath}/jsondata2_sub', // '{컨트롤러}/매핑주소'로 이동
          type : 'POST',
          data : jsonData,
          contentType : 'application/json;charset=UTF-8',
          success : function(msg) {
            alert(msg);
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