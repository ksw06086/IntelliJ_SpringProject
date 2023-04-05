<%--
  Created by IntelliJ IDEA.
  User: Happy
  Date: 2023-04-05
  Time: PM 6:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <script src="/resources/js/jquery-3.4.1.min.js"></script>
  <script type="text/javascript">
    // data 타입이 param인 경우 2

    $(function() {
      $('#stateid').change(function(){
        $.ajax({
          url : '${pageContext.request.contextPath}/state?data=' + $('#stateid').val(),
          type : 'GET',
          success : function(data) { // 콜백함수 - 정상적으로 처리되었을 때의 결과가 result에 들어간다.
            // 변수명이 반드시 . html(result)일 필요는 없으나 위 콜백함수의 변수명 result와 일치해야 한다.
            let text = "";
            $(data).each(function() {

              // $('input[name=price]').val(this.price);
              text += '<option value = "' + this.name + '">' + this.name + '</option>';
            });
            $('#statelistid').html(text);
          },
          error : function() {
            alert('오류');
          }
        });
      });

      $('#statelistid').change(function(){
        $.ajax({
          url : '${pageContext.request.contextPath}/statelist?datalist=' + $('#statelistid').val(),
          type : 'GET',
          success : function(data) { // 콜백함수 - 정상적으로 처리되었을 때의 결과가 result에 들어간다.
            // 변수명이 반드시 . html(result)일 필요는 없으나 위 콜백함수의 변수명 result와 일치해야 한다.
            $('input[name=price]').val(data);
          },
          error : function() {
            alert('오류');
          }
        });
      });
    });

    const addlist = () => {
      document.getElementById("result").innerHTML = ' 상태 : ' + document.getElementById("statelistid").value
                                                    + ', 가격 : ' + document.getElementById("price").value;
    }
  </script>
</head>
<body>
<select name = "state" id = "stateid">
  <option value = "0">상태</option>
  <option value = "1">지급</option>
</select>
<select name = "statelist" id = "statelistid">

</select>
<input type="text" id = "price" name = "price" placeholder = "금액을 입력하세요!">원
<input type="button" id = "btn" value = "추가" onclick="addlist()">

<span id = "result">

</span>

</body>
</html>