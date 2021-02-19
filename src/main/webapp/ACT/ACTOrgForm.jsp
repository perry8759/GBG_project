<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>主辦活動表單</title>
</head>
<body>
	<jsp:include page="/fragment/topMVC.jsp" />
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form method="POST" action="<c:url value='/ACT/ACT_org' />">

					<caption>
						<h2>主辦活動表單</h2>
					</caption>

					<fieldset class="form-group">
						<label>活動標題:</label> <input type="text" class="form-control"
							name="ACT_TITLE" required="required">
					</fieldset>
					<fieldset class="form-group">
						<label>主辦方名稱:<!-- ${SessionScope.LoginOK}--></label>
					</fieldset>
					<fieldset class="form-group">
						<label>球類類型:</label>
						<!-- 						<input type="text" class="form-control" -->
						<!-- 							name="dos_sport_id" required="required"> 改下拉式選單-->
					</fieldset>
					<fieldset class="form-group">
						<label>報名費用:</label> <input type="text" class="form-control"
							name="ACT_PAY">
					</fieldset>
					<fieldset class="form-group">
						<label>參加隊伍上限:</label> <input type="text" class="form-control"
							name="ACT_MAX_TEAM">
					</fieldset>
					<fieldset class="form-group">
						<label>總人數上限:</label> <input type="text" class="form-control"
							name="ACT_MAX_PNUM">
					</fieldset>
					<fieldset class="form-group">
						<label>場地: ${param.DOSID}</label> <input type="hidden"
							value="${param.DOSID}" name="dos_id">
					</fieldset>
					<fieldset class="form-group">
						<label>活動簡介:</label> <input type="text" class="form-control"
							name="ACT_DESC">
					</fieldset>
					<fieldset class="form-group">
						<label>比賽開放報名時間:</label>
						 <input type="date" class="form-control"
							name="ACT_SIGN_O" required >
					</fieldset>
					<fieldset class="form-group">
						<label>比賽報名截止時間:</label> 
						<input type="date" class="form-control"
							name="ACT_SIGN_C" required>
					</fieldset>
					<fieldset class="form-group">
						<label>比賽開始日期:</label> 
						<input type="date" class="form-control"
							name="ACT_RUN_O" required>
					</fieldset>
					<fieldset class="form-group">
						<label>比賽結束日期:</label> 
						<input type="date" class="form-control"
							name="ACT_RUN_C" required>
					</fieldset>
					<input type="submit" class="btn btn-success" value="送出留言">
				</form>
			</div>
		</div>
	</div>
	

</body>
</html>