<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-default">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand">
            <span>GBG</span>
          </a>
          <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-menu">
            <span class="sr-only">導覽按鈕</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div id="navbar-menu" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="<c:url value='/index.jsp' />">首頁</a></li>
            <c:if test="${empty LoginOK}">
            <li><a href="<c:url value='/register/register.jsp' />">註冊</a></li>
            </c:if>
            <c:if test="${empty LoginOK}">
            <li><a href="<c:url value='/login/login.jsp' />">登入</a></li> 
            </c:if>
            <c:if test="${! empty LoginOK}">  
            <li><a href="<c:url value='/login/logout.jsp' />">登出</a></li>
            </c:if>
            <li><a href="<c:url value='/DOS/DOS_Index' />">查詢所有場地</a></li>
            <li><a href="<c:url value='/ACT/HelloACTService' />">查詢所有活動</a></li>
            <c:if test="${! empty LoginOK}">
			<li><a href="#">HI! ${LoginOK.member_account }</a></li>
			</c:if>
		    
          </ul>
        </div>
      </div>
    </nav>
</body>
</html>