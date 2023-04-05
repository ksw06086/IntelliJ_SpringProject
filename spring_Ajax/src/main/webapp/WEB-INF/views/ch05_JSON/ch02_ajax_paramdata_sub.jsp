<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
이름 : ${param.name}<br>
전화 : ${param.tel}<br>
주소 : ${param.address}<br>

<%

    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String tel = request.getParameter("tel");
    String address = request.getParameter("address");

%>

이름 : <%=name%><br>
전화 : <%=tel%><br>
주소 : <%=address%><br>