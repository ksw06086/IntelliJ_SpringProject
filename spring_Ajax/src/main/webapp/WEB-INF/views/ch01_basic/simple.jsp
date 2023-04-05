<%--
  Created by IntelliJ IDEA.
  User: Happy
  Date: 2023-04-04
  Time: PM 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple</title>

  <script type="text/javascript" src="/resources/js/request.js"></script>
  <script type="text/javascript">
    function show(){
      // 서버로 요청해서 통신한 후 응답을 callback 함수로 받겠다.
      sendRequest(simple_callback, "simple", "post");
    }

    /*
     * 콜백함수
         - 서버로부터 응답이 오면 동작할 함수(시스템이 자동으로 호출)
         - 콜백함수 명은 sendRequest(콜백함수명)과 일치해야 한다.
         - simple_callback() : 콜백함수
         - result : 출력위치
     */

    function simple_callback(){
      let result = document.getElementById("result");
      // 4 : completed => 전체데이터가 취득환료된 상태
      if(httpRequest.readyState == 4){
        if(httpRequest.status == 200) { // 200 : 정상종료
          result.innerHTML = document.inputForm.username.value;
        } else {
          result.innerHTML = "에러발생";
        }
      } else {
        result.innerHTML = "상태 : " + httpRequest.readyState;
      }
    }
  </script>
</head>
<body>
<h2>Ajax(Asynchronous Javascript And Xml, 비동기적인 자바스크립트와 XML)</h2>

<form name = "inputForm" method="post">
  <table border="1">
    <tr>
      <th> 이름 </th>
      <td>
        <input type = "text" name = "username">
        <input type = "button" value = "확인" onclick = "show();">
      </td>
    </tr>
  </table>
</form>

<br>
<br>
<br>
<hr>
<div id = "result">
  <!-- 결과 출력 위치 -->
</div>
<hr>


</body>
</html>