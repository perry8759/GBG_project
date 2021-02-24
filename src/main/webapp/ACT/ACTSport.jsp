<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <jsp:include page="/fragment/topMVC2.jsp" />
     <a href="<c:url value='/ACT/ACT_Main' />">籃球</a>
     <a href="<c:url value='/ACT/ACT_Main' />">排球</a>
     
</body>
</html>