<%--
  Created by IntelliJ IDEA.
  User: Happy
  Date: 2023-04-05
  Time: PM 1:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>responseNews</title>
    <script type="text/javascript" src = "/resources/js/request.js"></script>
    <script type="text/javascript">
      const load = (url) => {
        // 서버로 요청해서 통신한 후 응답을 callback 함수로 받음
        // function sendRequest(callback, url, method, params)
        // news1.jsp=>콜백함수로 리턴
        sendRequest(loadNews, url, "post");
      }

      const loadNews = () => {
        let result = document.getElementById("result");

        if(httpRequest.readyState == 4) { // 전체 데이터가 취득완료된 상태
          if(httpRequest.status == 200) { // 정상 종료
            result.innerHTML = httpRequest.responseText;
            // 응답결과가 html이면 responseText로 받고
            // 응답결과가 XML이면 responseXML로 받는다.
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

<h3> 오늘의 뉴스 </h3>

<a onclick="load('news1')">캐시슬라이드 12일 초성퀴즈, 주제는 도미노 ‘치즈폭포피자’</a><br><br>

<a onclick="load('news2')">[단독] “러시아, 일 규제 불화수소 한국에 공급 제안”</a><br><br>

<a onclick="load('news3')">하리수 분노 “강인으로 재기 노린다고? 우습지도 않네”(전문)</a><br><br>



<br><br>



<hr>



<div id="result">

  <!-- 결과 출력 위치  -->

</div>

<hr>
</body>
</html>
