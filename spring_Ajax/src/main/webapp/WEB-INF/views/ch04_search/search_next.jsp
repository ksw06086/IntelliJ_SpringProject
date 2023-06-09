<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList" %>
<%@ page import ="java.util.List" %>
<%@ page import ="java.util.Collections" %>

<%!
	String keywords[] = {
				"자바프로그래밍입문",
				"자바입문",
				"자바의 정석",
				"자바지기",
				"자바자바",
				"Ajax 입문",
				"Ajax 기술서",
				"Oracle 입문",
				"Oracle SQL 활용",
				"Spring 입문",
				"Spring 활용",
				"JSP",
				"자바스크립트"
	};
	// 검색 키워드로 시작된 결과값을 list에 추가
	public List<String> search(String keyword){
		List<String> list = null;
		
		if(keyword == null || keyword.equals("")){
			return Collections.EMPTY_LIST;
		}
		
		list = new ArrayList<String>();
		
		for(int i =0; i<keywords.length; i++){
			//keywords 배열 중에서 ,입력된 키워드로 시작하는 문자열만 list에 추가
			if(keywords[i].startsWith(keyword)){
				
				list.add(keywords[i]);
			}
		}
		
		return list;
	}
%>

<%
	request.setCharacterEncoding("UTF-8");
	String keyword = request.getParameter("keyword");
	List<String> list = search(keyword);
%>

<%= list.size() %> |
<%
for(int i = 0; i<list.size(); i++){
%>
	<%= list.get(i) %>
<%	
	if(i < list.size() - 1){
%>
	,
<%
	}
}
%>