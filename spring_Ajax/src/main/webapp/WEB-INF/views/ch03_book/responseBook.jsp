<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/request.js"></script>
<script type="text/javascript">
const load = () => {
	// 서버로 요청해서 통신한 후 응답을 callback 함수로 받겠다.
	sendRequest(load_callback, "bookInfo", "post");
}

/*
 * 콜백함수
 	- 서버로부터 응답이 오면 동작할 함수(시스템이 자동으로 호출)
 	- 콜백함수 명은 sendRequest(콜백함수명)과 일치해야 한다.
 	- simple_callback() : 콜백함수
 	- result : 출력위치
 */
 
const load_callback = () => {
	let result = document.getElementById("result");
	// 4 : completed => 전체데이터가 취득환료된 상태
	if(httpRequest.readyState == 4){ 
		if(httpRequest.status == 200) { // 200 : 정상종료
			//result.innerHTML = "정상종료";
			let data = httpRequest.responseText;
			
			// 책 1권별로 자른다(7권의 정보를 list로 담는다.)
			let book1 = new Array();
			let list = data.split("|");
			let booklist = "";
			// 배열길이를 이용, 콤마를 기준으로 자른 후 제목, 저자, 가격을 bookList를 통해 출력한다.
			for(i = 0; i < list.length; i++){
				book1 = list[i].split(",");
				booklist = booklist + "도서명 : " + book1[0] + "<br> 저자 : " + book1[1] + "<br> 가격 : " + book1[2] + "<br><br>";
			}
			result.innerHTML = booklist;
			//result.innerHTML = httpRequest.responseXML;
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
	<h3> 베스트셀러 목록 </h3>
	<input type = "button" value = "확인" onclick = "load()">
	<br>
	<br>
	<hr>
	<div id = "result">
		<!-- 결과 출력 위치 -->
	</div>
</body>
</html>