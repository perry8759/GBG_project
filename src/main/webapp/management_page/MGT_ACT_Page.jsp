<!-- 管理活動頁面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/fragment/topMVC.jsp" />
	<header> </header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">活動列表</h3>
			<hr>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>活動標題</th>
						<th>參加人數</th>
						<th>比賽開始時間</th>
						<th>比賽結束時間</th>
					</tr>
				</thead>
				<tbody>
					<!--   列出活動  -->
					<c:forEach var="act" items="${AllACT}">
						<tr>
							<td><c:out value="${act.ACT_TITLE}" /></td>
							<td><c:out value="${act.ACT_PNUM}" /></td>
							<td><c:out value="${act.ACT_RUN_C}" /></td>
							<td><c:out value="${act.ACT_RUN_O}" /></td>
						<td>
							<a href="ACT_edit?actid=<c:out value='${act.ACT_ID}'/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="ACT_delete?actid=<c:out value='${act.ACT_ID}'/>">Delete</a>
						</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>