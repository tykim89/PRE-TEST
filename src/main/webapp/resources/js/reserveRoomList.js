
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
	
	$("#btn_reserve_status_date").on('click', function(){
		var date = $("#picker").val();
		$.ajax({
			method : 'GET',
			url : '/reserve/status/date',
			data : {
				date : date
			},
			dataType : 'json',
			success : function(obj){
				if(obj.reserveList == ""){
					var $oldDiv = $("#list"),
						$newDiv = $(document.createElement('div'));
					
					$oldDiv.remove();
					$newDiv.append("예약없음")
							.attr('id', 'list');
					$('body').append($newDiv);
				}else{
					setGrid(obj);
					setClickEvent();
				}
			},
			error : function(){
				alert("조회실패");
			}
		});
	});
	
	$("#btn_reserve").on('click', function(){
		var url = '/reserve/create';
		$(location).attr('href', url);
	});
	
	
	var setGrid = function(obj){
		var $oldDiv = $("#list"),
		$newDiv = $(document.createElement('div')),
		$r1 = $(document.createElement('div')),
		$r2 = $(document.createElement('div')),
		$r3 = $(document.createElement('div')),
		$r4 = $(document.createElement('div')),
		$r5 = $(document.createElement('div')),
		$r6 = $(document.createElement('div')),
		$r7 = $(document.createElement('div'));
	
		$oldDiv.remove();
		$r1.append("<h5>Room1</h5>");
		$r2.append("<h5>Room2</h5>");
		$r3.append("<h5>Room3</h5>");
		$r4.append("<h5>Room4</h5>");
		$r5.append("<h5>Room5</h5>");
		$r6.append("<h5>Room6</h5>");
		$r7.append("<h5>Room7</h5>");
		
		$.each(obj.reserveList, function(index, item){
			var $r_no = $(document.createElement('div'));
			var result = '';
			result += "예약자명 : " + item.r_user_name + ' / 예약시간 : ' 
				   + item.r_start_time.substring(0,2) + ":" + item.r_start_time.substring(2,4) 
				   + ' ~ ' 
				   + item.r_end_time.substring(0,2) + ":" + item.r_end_time.substring(2,4) 
				   + '<br>';
			
			$r_no.attr('id', 'no_' + item.r_no);
			$r_no.append(result);
			
			if(item.r_room_no == '1'){
				$r1.append($r_no);
			}else if(item.r_room_no == '2'){
				$r2.append($r_no);
			}else if(item.r_room_no == '3'){
				$r3.append($r_no);
			}else if(item.r_room_no == '4'){
				$r4.append($r_no);
			}else if(item.r_room_no == '5'){
				$r5.append($r_no);
			}else if(item.r_room_no == '6'){
				$r6.append($r_no);
			}else if(item.r_room_no == '7'){
				$r7.append($r_no);
			}
			
		});
		
		$newDiv.append($r1)
				.append($r2)
				.append($r3)
				.append($r4)
				.append($r5)
				.append($r6)
				.append($r7)
			.attr('id', 'list')
			.addClass('reserve_info');

		$('body').append($newDiv);
	}
	
});

var setClickEvent = function(){
	$('#list').find('div').on('click', function(){
		if($(this).attr('id') != undefined){
			var idx = $(this).attr('id').slice(3);
			$("#r_no").val(idx);
			$("#rForm").attr('method', 'POST');
			$("#rForm").attr('action', '/reserve/detailView');
			$("#rForm").submit();
/*			$.ajax({
				type : 'GET',
				url : '/reserve/detail',
				data : {
					r_no : idx
				},
				dataType : 'json',
				success : function(obj){
					var url = '/reserve/detailView';
					var vo = obj;
					$(location).attr('href', url, vo);
				}
			});
*/		
		}
	});
}