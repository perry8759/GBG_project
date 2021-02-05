<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <c:set var="funcName" value="LOG" scope="session"/>
      <Form action="<c:url value='login.do' />" method="POST" name="loginForm">
            帳號:<input  type="text" name="userId" size="10" 
             value="${requestScope.user}${param.userId}">
             密碼:<input  type="password" name="pswd"  size="10" 
             value="${requestScope.password}${param.pswd}">
             <input type="submit" value="登入" />
      </Form>
</body>
</html>