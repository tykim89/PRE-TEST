<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회의실 예약 관리</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" ></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js" ></script>
<script type="text/javascript" src="<c:url value='/resources/js/reserveRoomList.js' />" ></script>
</head>

<body>
<input type="hidden" id="msg" value=${msg }>
	<div>
		<h2>회의실 예약 관리</h2>
	</div>
	<div>
		<h4>* 예약현황</h4>
	</div>
	<div>
		<label>일자 선택</label>
		<input type="text" id="picker" >
		<input type="button" id="btn_reserve_status_date" value="조회">
		<input type="button" id="btn_reserve" value="예약하러">
	</div>
	<form id="rForm">
	<input type="hidden" id="r_no" name="r_no">
		<div id="list" class="reserve_info">
		</div>
	</form>
</body>
</html>