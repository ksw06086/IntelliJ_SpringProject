<%--
  Created by IntelliJ IDEA.
  User: Happy
  Date: 2023-04-02
  Time: 오전 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>save</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
</head>
<body>
    <form action="/member/save" method="post">                                      <%-- 입력창을 벗어났을 때 실행됨 --%>
        <input type="text" name="memberEmail" placeholder="이메일" id = "memberEmail" onblur="emailCheck();">
        <p id = "check-result"></p>
        <input type="text" name="memberPassword" placeholder="비밀번호">
        <input type="text" name="memberName" placeholder="이름">
        <input type="text" name="memberAge" placeholder="나이">
        <input type="text" name="memberMobile" placeholder="전화번호">

        <input type="submit" value ="회원가입">
    </form>
</body>
<script>
    // 이메일 입력 값을 가져오고,
    // 입력값을 서버로 전송하고 똑같은 이메일이 있는지 체크한 후
    // 사용 가능 여부를 이메일 입력창 아래에 표시
    const emailCheck = () => {
        const email = document.getElementById("memberEmail").value;     // => 이메일 값 가져오기
        const checkResult = document.getElementById("check-result");    // => 처리 결과 출력을 위한 요소 가져오기
        console.log("입력한 이메일", email);
        $.ajax({    // Ajax 시작
            // 요청방식: post, url: "email-check", 데이터: 이메일
            type: "post",
            url: "/member/email-check", // 보낼 주소
            data: {                     // 보낼 데이터 전송
                "memberEmail": email
            },
            success: function(res) {    // 요청이 성공해서 응답이 오게되었을 때 처리
                console.log("요청성공", res);
                if (res == "ok") {
                    console.log("사용가능한 이메일");
                    checkResult.style.color = "green";
                    checkResult.innerHTML = "사용가능한 이메일";
                } else {
                    console.log("이미 사용중인 이메일");
                    checkResult.style.color = "red";
                    checkResult.innerHTML = "이미 사용중인 이메일";
                }
            },
            error: function(err) {      // error 발생 시 실행
                console.log("에러발생", err);
            }
        });
    }
</script>
</html>
