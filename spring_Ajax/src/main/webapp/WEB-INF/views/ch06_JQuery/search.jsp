<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
// Ajax 방식
$(function() {
	$('#keyword').keyup(function(){ // keyup : 데이터 입력이 끝났을 때
		let keyword = $('#keyword').val(); // 입력한 키워드를 가져와라
		if(keyword.length == 0){ // 글자수가 0인 경우
			$('#result').css('visibility', 'hidden'); // 숨김
		} else {
			$('#result').css('visibility', 'visible'); // 표시
			$.ajax({
				url : '${pageContext.request.contextPath}/search_sub', // '{컨트롤러}/매핑주소'로 이동 
				type : 'POST',
				data : 'keyword=' + keyword,
				success : function(data) {
					$('#result').html(data);
				},
				error : function() {
					alert('오류');
				}
			});
		}
	});
});
</script>
</head>
<body>
	<h3> Ajax 방식 </h3>
	
	<form action="" name = "searchForm" method = "post"> 검색할 단어를 입력하세요.
		<input type = "text" id = "keyword">
		
		<div id = "result">
			<!-- 결과 출력 위치 -->
		</div>
	</form>
</body>
</html>