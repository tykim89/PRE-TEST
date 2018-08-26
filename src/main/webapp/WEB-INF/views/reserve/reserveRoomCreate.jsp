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
<script type="text/javascript" src="<c:url value='/resources/js/reserveRoomCreate.js' />" ></script>
</head>
<body>
<input type="hidden" id="msg" value=${msg }>
	<div>
		<h2>회의실 예약 관리</h2>
	</div>
	<div>
		<h4>* 예약하기</h4>
	</div>
	
	<div>
	<form id="rForm" >
		<div>
			예약자명 : <input type="text" id="r_user_name" name="r_user_name">
		</div>
		<div>
			비밀번호 : <input type="password" id="r_user_password" name="r_user_password">
		</div>
		<div>
			회의실 : 
			<select id="r_room_no" name="r_room_no">
				<option value=""></option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
			</select>
		</div>
		<div>
			예약일자 : <input type="text" id="picker" name="r_reserve_date">
		</div>
		<div>
			예약시간 : 
			<select id="r_start_time" name="r_start_time">
				<option value=""></option>
				<option value="090000">09:00</option>
				<option value="093000">09:30</option>
				<option value="100000">10:00</option>
				<option value="103000">10:30</option>
				<option value="110000">11:00</option>
				<option value="113000">11:30</option>
				<option value="120000">12:00</option>
				<option value="123000">12:30</option>
				<option value="130000">13:00</option>
				<option value="133000">13:30</option>
				<option value="140000">14:00</option>
				<option value="143000">14:30</option>
				<option value="150000">15:00</option>
				<option value="153000">15:30</option>
				<option value="160000">16:00</option>
				<option value="163000">16:30</option>
				<option value="170000">17:00</option>
				<option value="173000">17:30</option>
			</select>
			~
			<select id="r_end_time" name="r_end_time">
				<option value=""></option>
				<option value="093000">09:30</option>
				<option value="100000">10:00</option>
				<option value="103000">10:30</option>
				<option value="110000">11:00</option>
				<option value="113000">11:30</option>
				<option value="120000">12:00</option>
				<option value="123000">12:30</option>
				<option value="130000">13:00</option>
				<option value="133000">13:30</option>
				<option value="140000">14:00</option>
				<option value="143000">14:30</option>
				<option value="150000">15:00</option>
				<option value="153000">15:30</option>
				<option value="160000">16:00</option>
				<option value="163000">16:30</option>
				<option value="170000">17:00</option>
				<option value="173000">17:30</option>
				<option value="180000">18:00</option>
			</select>
		</div>
		<div>
			반복횟수 : 
			<select id="r_repeat_cnt" name="r_repeat_cnt">
				<option value=""></option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
			</select>
		</div>
		<div>
			<input type="button" id="btn_reserve_create" value="예약">
			<input type="button" id="btn_reserve_status" value="뒤로">
		</div>
	</form>
	</div>
</body>
</html>