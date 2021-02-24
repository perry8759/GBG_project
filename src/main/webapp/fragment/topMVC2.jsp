<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!doctype html>
<html lang="en">

<head>
<script src="https://kit.fontawesome.com/82fbc43281.js"
	crossorigin="anonymous"></script>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<title>Hello, world!</title>
<link rel="stylesheet" href="<%=path%>/fragment/style.css">
</head>

<body>
	<input type="checkbox" name="" id="menu_control">
	<div class="header">
		<a href="<c:url value='/index.jsp' />" class="logo"><img
			src="<%=path%>/Images/logo-1.png" width="180" alt="logo"></a> <label
			for="menu_control" class="menu_btn"> <span>選單</span>
		</label>
		<nav class="menu">
			<ul class="menu_ul">
				<div class="search">
					<input type="text" class="search-bar" id="search"
						placeholder="Search">
					<button class="search-btn">
						<i class="fas fa-search"></i>
					</button>
				</div>
				<!-- 				<li class="active"><a href="#">首頁</a></li> -->
				<li><a href="<c:url value='/ACT/ACTSport.jsp' />">賽事</a></li>
				<li><a href="<c:url value='/DOS/DOS_Index' />">場地</a></li>
				<li><a href="#">商城</a></li>
				<c:choose>
					<c:when
						test="${LoginOK.member_perm_id.member_perm_id==1 ||
								LoginOK.member_perm_id.member_perm_id==2}">
						<li><a
							href="<c:url value='/management_page/Main_MEM_PAGE.jsp' />">會員</a></li>
					</c:when>
					<c:when test="${LoginOK.member_perm_id.member_perm_id==3 }">
						<li><a
							href="<c:url value='/management_page/Main_MGT_PAGE.jsp' />">管理</a></li>
					</c:when>
				</c:choose>
				<div class="user">
					<c:if test="${empty  LoginOK}">
						<a href="<c:url value='/login/login2.jsp' />" class="user-btn"><img
							src="<%=path%>/Images/user.png" alt="user" class="user-btn-img">
							<span>登入/註冊</span> </a>
					</c:if>
					<c:if test="${! empty LoginOK}">
						<a href="<c:url value='/login/logout.jsp' />" class="user-btn"><img
							src="<%=path%>/Images/user.png" alt="user" class="user-btn-img">
							<span> 登出<br> <c:choose>
									<c:when test="${LoginOK.member_perm_id.member_perm_id==1 }">
										<li>一般會員${LoginOK.member_account }</li>
									</c:when>
									<c:when test="${LoginOK.member_perm_id.member_perm_id==2 }">
										<li>主辦方${LoginOK.member_account }</li>
									</c:when>
									<c:when test="${LoginOK.member_perm_id.member_perm_id==3 }">
										<li>管理員${LoginOK.member_account }</li>
									</c:when>
								</c:choose>
						</span></a>
					</c:if>
				</div>
			</ul>
		</nav>
	</div>
	<div class="banner">
		<!-- <img src="image/basketball-1.jpg"  alt="basketball"> -->
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
		integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
		crossorigin="anonymous"></script>
</body>

</html>
