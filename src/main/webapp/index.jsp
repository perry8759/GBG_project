<!-- demo查詢主頁 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basepath %>">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/fragment/topMVC2.jsp" /> 
 歡迎來到首頁!
        
         
</body>
</html>