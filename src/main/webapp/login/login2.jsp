<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">

<title>登入</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>

<script src="https://kit.fontawesome.com/82fbc43281.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<jsp:include page="/fragment/topMVC2.jsp" />
	<div id="Body" style="background: #fff;">
		<div id="login">
			<h3 class="text-center text-white pt-5">Login form</h3>
			<div class="container">
				<div id="login-row"
					class="row justify-content-center align-items-center">
					<div id="login-column" class="col-md-6">
						<div id="login-box" class="col-md-12">
							<form id="login-form" class="form" action="<c:url value='login.do' />" method="post" name="loginForm">
								<h3 class="text-center text-info">登入</h3>
								<div class="form-group">
									<label for="username" class="text-info">帳號:</label><br> <input
										type="text" name="userId" id="username" size="10"
										class="form-control"
										value="${requestScope.user}${param.userId}">
								</div>
								<div class="form-group">
									<label for="password" class="text-info">密碼:</label><br> <input
										type="text" name="pswd" id="password" class="form-control"
										value="${requestScope.password}${param.pswd}">
								</div>
								<div class="text-group">
									<div class="left">
										<label for="remember-me" class="text-info"> <span><input
												id="remember-me" name="remember-me" type="checkbox"></span>
											<span>Remember me</span></label>
									</div>
									<div class="right">
										<a href="Forgot_Password.html" class="text-info">忘記密碼 ?</a>
									</div>
								</div>
								<div class="login-box">
									<input type="submit" style="width: 465px; height: 50px;"
										name="submit" class="btn btn-info btn-md" value="Login">
								</div>
								<br>
								<div class="register">
									<a href="D:\_web\Topic_Member\demo_註冊.html" class="text-info">註冊會員</a>
								</div>

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div style='clear: both;'></div>
		<!-- <div id="Footer" style="color:red;">Footer 欄位</div> -->
</body>
</html>