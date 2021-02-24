<!-- 建立活動表單 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="./jquery.datetimepicker.css">
<script src="./jquery.js"></script>
<script src="./jquery.datetimepicker.full.min.js"></script>
<script>
	function fun() {
		document.getElementById('time').value = '';
		document.getElementById('time1').value = '';
		document.getElementById('time2').value = '';
	}
</script>
</head>
<body>

	<Form action="ACT_Main_Insert" method="post">
		<h3>
			場地名稱:
			<c:out value="${DOSID.DOS_NAME}" />
		</h3>
		<div class="form-group row">

			<div class="right col-xs-6 text-left">
				<div class="input-group">
					<input type="hidden" name="DOS_ID"
						value="<c:out value="${DOSID.DOS_ID}"/>"> 活動標題: <input
						type="text" name="ACT_MAIN_TITLE" id="title_input">
					<div class="error" id="title_error"></div>
					活動簡章: <input type="text" name="ACT_MAIN_DESC"> 活動最大人數: <input
						type="text" name="ACT_MAIN_PERSON" /> 報名費用:<input type="text"
						name="ACT_MAIN_PAY" /> 開放報名時間:<input type="text"
						class="form-control form_datetime" id="time" name="time"
						data-date-format="yyyy-mm-dd hh:ii" placeholder=""> <input
						type="hidden" name="ACT_MAIN_OPENING" value=""
						id="selectedDtaeVal"> 截止報名時間:<input type="text"
						class="form-control form_datetime1" id="time1" name="time1"
						data-date-format="yyyy-mm-dd hh:ii" placeholder=""> <input
						type="hidden" name="ACT_MAIN_CLOSING" value=""
						id="selectedDtaeVal"> 比賽時間: <input type="text"
						class="form-control form_datetime2" id="time2" name="time2"
						data-date-format="yyyy-mm-dd hh:ii" placeholder=""> <input
						type="hidden" name="ACT_MAIN_TIME" value="" id="selectedDtaeVal">
					<span class="input-group-addon" id="basic-addon2"><span
						class="glyphicon glyphicon-time" aria-hidden="true"></span></span> <input
						onclick="fun()" type="submit" value="確認活動" />
				</div>
			</div>
		</div>
	</form>
</body>
<script>
	$(function() {
		$('.form_datetime').datetimepicker({
			language : 'zh-CN',
			format : 'Y-m-d H:i:00',
			todayBtn : 1,
			autoclose : 1,
			step : 15,
			minView : 0, //0表示可以選擇小時、分鐘   1只可以選擇小時
			minuteStep : 10,//分鐘間隔10分鐘	
		});
		$(".form_datetime").on("change", function() {
			var selected = $(this).val();
			$('input[name="ACT_MAIN_OPENING"]').val(selected);
		});

	});
	$(function() {
		$('.form_datetime1').datetimepicker({
			language : 'zh-CN',
			format : 'Y-m-d H:i:00',
			todayBtn : 1,
			autoclose : 1,
			step : 15,
			minView : 0, //0表示可以選擇小時、分鐘   1只可以選擇小時
			minuteStep : 1,//分鐘間隔10分鐘	
		});
		$(".form_datetime1").on("change", function() {
			var selected = $(this).val();
			$('input[name="ACT_MAIN_CLOSING"]').val(selected);
		});

	});
	$(function() {
		$('.form_datetime2').datetimepicker({
			language : 'zh-CN',
			format : 'Y-m-d H:i:00',
			todayBtn : 1,
			autoclose : 1,
			step : 15,
			minView : 0, //0表示可以選擇小時、分鐘   1只可以選擇小時
			minuteStep : 1,//分鐘間隔10分鐘	
		});
		$(".form_datetime2").on("change", function() {
			var selected = $(this).val();
			$('input[name="ACT_MAIN_TIME"]').val(selected);
		});
	});
	$(function() {
		var title_input = $('#title_input');
		var title_error = $('#title_error');
		title_error.hide();
		function title_validate() {
			var title = title_input.val();
			var user = {
				'ACT_MAIN_TITLE' : title
			};
			if (title.trim() == "") {
				title_error.html("不能為空");
				title_error.show();
				title_input.val("").focus();
			} else {
				title_error.hide();
			}
		}
		title_input.blur(title_validate);
	});
</script>
</html>