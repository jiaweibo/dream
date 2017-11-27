var seat_film = function() {
	var screen_code = "00000001A2"

	$.ajax({
		type: "GET",
	
		url: "http://118.190.112.59:8082/cinemaservice/screencodeseatfind/" + screen_code,
		dataType: "jsonp",
		success: function(data) {

			var row = "";
			for(var i = 0; i < data.length; i++) {
				var temp = data[i];

				row = row + '<button class="seat"  name="seat_code" id="' + temp.seat_code + '"  onmouseover="changeColor()" >' + temp.seat_code + '</button>'

				//				row = row+'<div class="blue_seat" style="left:'+ temp.seat_x_axis+';top:'+temp.seat_y_axis+'"screen_name="'+ temp.film_name+'"></div>'
				$("#film_name").html(data[0].screen_code)
			}

			//			," top: data[i].seat_y_axis "; film_name = " data[i].film_name "
			$(".seat_film").html(row)
		},
		error: function() {
			alert("fail");
		}
	});
}

function changeColor() {

	    var btn  = document.getElementsByTagName("button");
    for(var i=0;i<btn.length;i++){
        (function(index){
            btn[index].onclick = function(){
                if(btn[index].style.backgroundColor === "red"){
                    btn[index].style.backgroundColor = "";
                }else{
                    btn[index].style.backgroundColor = "red";
                }
            }
        }(i))
 
    }
	//$("dtb").style.backgroundcolor="red";
	//dtn.style.backgroundcolor="red";
}
var init = function() {
	seat_film();
};

var bind = function() {
	$(".blue_seat").on("click", function() {
		$("#film_name").html($(this).attr("film_name"))
	})
};

$(function() {
	init();
	bind();
})