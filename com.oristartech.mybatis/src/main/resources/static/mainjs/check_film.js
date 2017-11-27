var init_film_information = function() {
	//根据影片ID查询影片对象
	$.ajax({
		type: "GET",
		url: "http://118.190.112.59:8084/sessionService/sessionList/2017-10-10",
		dataType: "jsonp",
		success: function(data) {
				var arr = [];
				for (var i in data) {
//					console.log(data[i].cinema_code);
					//筛选掉重复ID
					if (arr.indexOf(data[i].film_code) === -1) {
						arr.push(data[i].film_code);
//							console.log(arr);			
					}		
				}
//				console.log(arr);
				//遍历数组 再次发送请求
				for (var j = 0;j<=arr.length;j++) {
					$.ajax({
						type:"GET",
						url:"http://118.190.112.59:8084/filmService/code/"+arr[j],
						dataType: "jsonp",
						success:function(result){
//							console.log(result.film_code);
							var row = '';
							row  += '<div class="each_film" id="'+ result.film_code + '"><span class="each_film_name">' + result.film_name + '</span><span class="each_film_code">' + result.filmVersion.version_name + '</span><span class="each_film_time"></span></div>';
							$(".film_name").append(row);
							$("#010102600101").on("click",
							function(){
								zhitable();
								SeatAllNum();
								SeatLeftNum();
							});
							$("#010102600100").on("click",function(){
								draw_table();
								SeatAllNum();
								SeatLeftNum();
							});
						}
					})
				}
		
				if(i == 0) {
					$(".each_film").addClass("active_film");
				}
		},
		error: function() {
			alert("fail");
		}
	});
}

var draw_table = function() {
	//根据日期查询对应的场次信息
	$.ajax({
		type: "GET",
		url: "http://118.190.112.59:8084/sessionService/sessionList/2017-10-16",
		dataType: "jsonp",
		success: function(data) {
			for(var i = 0; i < data.length; i++) {			
				if (data[i].film_code == "010102600101"){
					var temp = data[i];
//					console.log(temp)
					var table_row = "";
					table_row += '<tr><td>' + temp.screen_code + '</td> <td>' + temp.version_code + '</td><td>' + temp.language_code + '</td><td>' + temp.begin_time + '</td><td>' + temp.end_time + '</td> <td class="ticketNum">' + '<span class="ticketLeft"></span>' + '/' + '<span class="allTicket"></span>' + '</td> <td>' + temp.price + '</td><td ><button class="btn btn-default check_set" id=" temp.session_code ">选座</button></td></tr>';
					$("tbody").append(table_row);
				}
				
			}
		},
		error: function() {
			alert("fail");
		}
	});
	//根据场次编码查询对应的座位
	$.ajax({
		type: "GET",
		url: "http://118.190.112.59:8085/ticketService/forSaleTicketLeft/{session_code}",
		dataType: "jsonp",
		success: function(data) {
			for(var i = 0; i < data.length; i++) {
				$(".ticketLeft").text(data);
			}
		},
		error: function() {
			alert("fail");
		}
	});
	//根据影厅编码返回所有的座位对象
	$.ajax({
		type: "GET",
		url: "http://118.190.112.59:8082/cinemaservice/screencodeseatfind/ {screen_code}",
		dataType: "jsonp",
		success: function(data) {
			for(var i = 0; i < data.length; i++) {
				$(".allTicket").text(data.length);
			}
		},
		error: function() {
			alert("fail");
		}
	});
}
function zhitable(){
	$.ajax({
		type: "GET",
		url: "http://118.190.112.59:8084/sessionService/sessionList/2017-10-16",
		dataType: "jsonp",
		success: function(data) {
			for(var i = 0; i < data.length; i++) {			
				if (data[i].film_code == "010102600100"){
					var temp1 = data[i];
					console.log(temp1)
					var table_row = "";
					table_row += '<tr><td>' + temp1.screen_code + '</td> <td>' + temp1.version_code + '</td><td>' + temp1.language_code + '</td><td>' + temp1.begin_time + '</td><td>' + temp1.end_time + '</td> <td class="ticketNum">' + '<span class="ticketLeft"></span>' + '/' + '<span class="allTicket"></span>' + '</td> <td>' + temp1.price + '</td><td ><button class="btn btn-default check_set" id=" temp1.session_code ">选座</button></td></tr>';
					$("tbody").append(table_row);
				}	
			}
		},
		error: function() {
			alert("fail");
		}
	});
}

var showCinemaName = function() {
	$.ajax({
		type: "GET",
		//				url: "http://118.190.112.59:8082/cinemaservice/cinemacodefind/00000001",
		url: "http://118.190.112.59:8082/cinemaservice/cinemacodefind/00000001",
		dataType: "jsonp",
		success: function(data) {
//			console.log(data.cinema_code);
			if(data != null) {
				$("#cinemaName").text(data.cinema_name);
				$("#cinemaName").show();
			}
		},
		error: function() {
			alert("fail");
		}
	});
}
//选择座位-总票
var allticket = [];
var SeatAllNum = function() {
	$.ajax({
		type: "GET",
		url: "http://118.190.112.59:8084/sessionService/sessionList/2017-10-16",
		dataType: "jsonp",
		success: function(data) {
			for (var i in data) {			
				//总票请求
				$.ajax({
						type:"GET",
						url:"http://118.190.112.59:8082/cinemaservice/screencodefind/"+data[i].screen_code,
						dataType: "jsonp",
						success:function(result){
//							console.log(result);
//							var arr = [];
							allticket.push(result.seat_num);
//							var row = '';
//							row ='<td class="ticketNum">/<span class="allTicket">'+result.seat_num+'</span></td>'
//							$(".ticketNum").html(row);
							
						}
					})
			}
			if(data != null) {
				$("#cinemaName").text(data.cinema_name);
				$("#cinemaName").show();
			}
		},
		error: function() {
			alert("fail");
		}
	});
}

//余票
var SeatLeftNum = function() {
	$.ajax({
		type: "GET",
		url: "http://118.190.112.59:8084/sessionService/sessionList/2017-10-16",
		dataType: "jsonp",
		success: function(data) {
			for (var i in data) {
//				console.log(data[i].screen_code);			
				//余票请求
				$.ajax({
						type:"GET",
						url:"http://118.190.112.59:8085/ticketService/forSaleTicketLeft/"+data[i].session_code,
						dataType: "jsonp",
						success:function(res){
							var row = '';
							row ='<td class="ticketNum"><span class="TicketLeft">'+res+'</span>/<span class="allTicket">'+allticket[0]+'</span></td>'
							$(".ticketNum").html(row);
//							
						}
					})
			}
			if(data != null) {
				$("#cinemaName").text(data.cinema_name);
				$("#cinemaName").show();
			}
		},
		error: function() {
			alert("fail");
		}
	});
}
var init = function() {
	init_film_information();
	draw_table();
	showCinemaName();
	SeatAllNum();
	SeatLeftNum();
};

var bind = function() {
	$(document).on("click", ".each_film", function() {
		$(this).addClass("active_film").siblings().removeClass("active_film");
	})

	$(".check_set").on("click", function() {
		window.location.href = "hot_seat.html?id=" + $(this).prop("id");
	})
};

$(function() {
	$('#010102600101').on("click",draw_table);
	init();
	bind();
});