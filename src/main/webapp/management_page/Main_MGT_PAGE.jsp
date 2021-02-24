<!-- 管理主頁 -->
<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>管理主頁</title>
</head>
<body>
	管理主頁
	<ul>
		<li><a href="<c:url value='/DOS/DOS_list' />">場地管理 </a></li>
		<li><a href="<c:url value='/DOS/DOS_sport_list' />">運動種類管理</a></li>
	</ul>
</body>
</html>