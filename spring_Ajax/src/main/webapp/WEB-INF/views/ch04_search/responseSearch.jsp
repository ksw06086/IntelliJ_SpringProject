<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/request.js"></script>
<script type="text/javascript">

  let checkFirst = true; // 처음
  let loopSendKeyword = false; // 작업완료 후에 0.5초마다 반복했던 작업을 중단
  let lastKeyword = null; // 마지막 키워드

  const startSearch = () => {
	  const searchKeyword = (aa) => {
		  if(loopSendKeyword === false) return false; // 반복작업 중단
		  let keyword = document.search.keyword.value;

		  // 검색어를 지운 경우 출력결과를 지워라(=출력위치를 숨겨라)
		  if(keyword == null) {
			  hide("result");
			  lastKeyword = "";
		  } else if(keyword != lastKeyword) {
			  // 똑같은 검색어는 계속 검색하지 않도록 함
			  lastKeyword = keyword;
			  let params = "keyword=" + keyword;

			  sendRequest(search_callback, "search_next", "GET", params); // search_next.jsp -> 콜백함수로 리턴
		  }
		  setTimeout(searchKeyword, 1);
	  }
	  
	//이츠더 콜백
	  const search_callback = () => {
		  let searchList = document.getElementById("searchList");
		  
		  if(httpRequest.readyState == 4){
			  if(httpRequest.status == 200) {
				  searchList.innerHTML = "정상종료";
				  
				  let books = "";
				  let data = httpRequest.responseText; // 결과 .. search_next.jsp의 list.. 검색어로 시작하는 키워드 목록
				  let datalist = data.split("|");
				  let count = datalist[0]; // 건수
				  // 5 | dsfas,dfsdfas,sdfsdfa,dfasfsdf,dsfadsf
				  books = "";
				  if(count > 0) {
					  // 책이름을 가지고 와라
					  let booklist = datalist[1].split(",");
					  for(i = 0; i < count; i++) {
						  books += "<a href=\"javascript:select('" + booklist[i] + "')\">" + booklist[i] + "</a>, ";
					  }
					  show("result");
					  searchList.innerHTML = count + " | " + books;
				  } else {
					  hide("result");
				  }
			  } else {
				  searchList.innerHTML = "상태 :" + httpRequest.readyState;
			  }  
		  }
	  } 
	  
	 const show = (str) => {
		let element = document.getElementById(str);
		if(element) {
			element.style.display="";
		}
	  }
	  
	 const hide = (str) => {
		let element = document.getElementById(str);
		if(element) {
			element.style.display="none";
		}
	 }
	 
	  // select() : 검색 결과 중 하나를 선택할 경우, 그 결과가 input box로 들어가도록 처리
	  const select = (book) => {
		  document.search.keyword.value = book;
		  loopSendKeyword = false; // sendKeyword() 반복문 종료
		  checkFirst = true;
		  hide("result");
	  }

	  if(checkFirst == true) { // 처음
		  loopSendKeyword = true; // 0.5초마다 반복해라
		  setTimeout(searchKeyword, 500);
	  }
  }
  
  // select() : 검색 결과 중 하나를 선택할 경우, 그 결과가 input box로 들어가도록 처리
  const select = (book) => {
	  document.search.keyword.value = book;
	  loopSendKeyword = false; // sendKeyword() 반복문 종료
	  checkFirst = true;
	  hide("result");
	  
	  const hide = (str) => {
		let element = document.getElementById(str);
		if(element) {
			element.style.display="none";
		}
	 }
  }
  
  
</script>
</head>
<body>
	<h3>검색 기능</h3>
	검색어로 책제목을 찾아서 출력
	<br><br>
	
	<form name="search">
		<input type="text" name="keyword" onkeyup="startSearch();">
		<input type="button" value="검색" onclick = "window.location = 'https://search.shopping.naver.com/search/all?query=' + encodeURI(document.search.keyword.value) + '&prevQuery=djdjdj'">
		
	</form>
	<div id="result">
		<div id="searchList">
			<!-- 결과 출력위치 -->
		</div>
	</div>
</body>
</html>