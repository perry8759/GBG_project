<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>留言</title>
</head>
<body>
	<jsp:include page="/fragment/topMVC2.jsp" />
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form method="POST" action="<c:url value='/ACT/ACT_QesCreate' />">

					<caption>
						<h2>留言</h2>
					</caption>

					<fieldset class="form-group">
						<label>輸入內文</label> 
<!-- 						<input type="text" class="form-control" -->
<!-- 							name="comment" required="required"> -->
						<textarea class="form-control" cols="80" rows="14" name="comment" required="required"></textarea>
					</fieldset>

					<input type="hidden" value="${param.ACTID}" name="actid">
				 <input
						type="submit" class="btn btn-success" value="送出留言">
				</form>
			</div>
		</div>
	</div>

</body>
</html>