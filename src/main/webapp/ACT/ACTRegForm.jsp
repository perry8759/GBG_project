<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>報名活動表單</title>
</head>
<body>
	<jsp:include page="/fragment/topMVC.jsp" />
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form method="POST" action="<c:url value='/ACT/ACT_reg' />">

					<caption>
						<h2> 報名活動 </h2>
					</caption>

					<fieldset class="form-group">
						<label>隊伍名稱</label>
							<input type="text" class="form-control" name="teamName" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>單位名稱</label>
						<input type="text" class="form-control" name="unitName">
					</fieldset>

					<fieldset class="form-group">
						<label>聯絡人 ${sessionScope.LoginOK.member_real_name}</label>
					</fieldset>

					<fieldset class="form-group">
						<label>聯絡電子信箱 ${sessionScope.LoginOK.member_email}</label>
					</fieldset>

					<fieldset class="form-group">
						<label>聯絡電話 ${sessionScope.LoginOK.member_mobile_phone}</label>
					</fieldset>
					
					<input type="hidden" value="${param.Actid}" name="actid">
					
					<input type="submit" class="btn btn-success" value="送出報名資料">
				</form>
			</div>
		</div>
	</div>

</body>
</html>