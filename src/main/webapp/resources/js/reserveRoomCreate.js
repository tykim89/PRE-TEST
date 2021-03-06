
$(function(){
	
	var msg = $("#msg").val();
	if(msg){
		alert(msg);
	}
	
	$("#picker").datepicker({
		changeMonth: true, 
        changeYear: true,
        nextText: '다음 달',
        prevText: '이전 달',
        dateFormat: "yy-mm-dd",
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
        monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12']
	});
	
	$("#btn_reserve_status").on('click', function(){
		var url = '/reserve/status';
		$(location).attr('href', url);
	});
	
	$("#btn_reserve_create").on('click', function(){
/*		var r_user_name = $("#r_user_name").val(),
			r_user_password = $("#r_user_password").val(),
		    r_room_no = $("#r_room_no").val(),
		    r_reserve_date = $("#picker").val(),
		    r_start_time = $("#r_start_time").val(),
		    r_end_time = $("#r_end_time").val(),
		    r_repeat_cnt = $("#r_repeat_cnt").val();
		
		$.ajax({
			type : 'POST',
			url : '/reserve/create/new',
			data : {
				r_user_name : r_user_name,
				r_user_password : r_user_password,
				r_room_no : r_room_no,
				r_reserve_date : r_reserve_date,
				r_start_time : r_start_time,
				r_end_time : r_end_time,	
				r_repeat_cnt : r_repeat_cnt	
			},
			contentType: "application/json; charset=UTF-8",
			dataType : 'json',
			success : function(data){
				
			}
		});
*/	
		if(validation()){
			$("#rForm").attr('method', 'POST');
			$("#rForm").attr('action', '/reserve/create/new');
			$("#rForm").submit();
		}
		
	});
	
	
});

var validation = function(){
	var r_user_name = $("#r_user_name").val(),
		r_user_password = $("#r_user_password").val(),
	    r_room_no = $("#r_room_no").val(),
	    r_reserve_date = $("#picker").val(),
	    r_start_time = $("#r_start_time").val(),
	    r_end_time = $("#r_end_time").val(),
	    r_repeat_cnt = $("#r_repeat_cnt").val();
	
	if(!r_user_name){
		alert("예약자명 확인");
	}else if(!r_user_password){
		alert("비밀번호 확인");
	}else if(!r_room_no){
		alert("회의실 선택 확인");
	}else if(!r_reserve_date){
		alert("예약일자 확인");
	}else if(!r_start_time){
		alert("예약시간 확인");
	}else if(!r_end_time){
		alert("예약시간 확인");
	}else{
		return true;
	}
	
}