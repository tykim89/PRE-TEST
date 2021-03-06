
$(function(){
	
	var room_no = $("#res_r_room_no").val(),
		start_time = $("#res_r_start_time").val(),
		end_time = $("#res_r_end_time").val();
	
	if(room_no){
		$("#r_room_no").val(room_no).prop('selected', true);
	}
	if(start_time){
		$("#r_start_time").val(start_time).prop('selected', true);
	}
	if(end_time){
		$("#r_end_time").val(end_time).prop('selected', true);
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
	
	$("#btn_reserve_cancel").click(function(){
		$.ajax({
			type : 'POST',
			url : '/reserve/delete',
			data : {
				r_no : $("#r_no").val(),
				r_user_password : $("#r_user_password").val()
			},
			dataType : 'json',
			success : function(data){
				alert(data.msg);
				if(data.result == 1){
					var url = '/reserve/status';
					$(location).attr('href', url);
				}
			}
		});
		
	});
	
	
});