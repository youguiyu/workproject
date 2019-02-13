var urlTemp = panduanUrl();
function panduanUrl(){
    var baseUrl = window.location.href;
    if(baseUrl.indexOf("jksdev_190_171_8080")>=0){
        return "/jksdev_190_171_8080/";
    }else {
        return "/";
    }
}

$(function(){
	var counter=1;
	$('#clickButton').bind("click", function() {
		counter++ % 2 ? 
			(function() { 
			 $("#leftmenu").hide(1000);
				$("#topMenu").hide(1000);
				$("#topMenu").removeClass("navbar navbar-inverse navbar-fixed-top");
				
				$("#rightContent").removeClass("col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main");
				$("#rightContent").addClass("col-sm-12 col-md-12  main");
				$("body").css('padding-top','0px');
				$("#middleContent").removeClass("col-sm-1 col-sm-offset-3 col-md-1 col-md-offset-2 middle");
				$("#middleContent").addClass("col-sm-1 col-md-1 middle");
                init();


				
			
			}()) :
			(function() { 
			
			    $("#leftmenu").show(1000);
				$("#topMenu").show(1000);
				$("#topMenu").addClass("navbar navbar-inverse navbar-fixed-top");
				
				$("#rightContent").addClass("col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main");
			    $("body").css('padding-top','50px');
				$("#middleContent").addClass("col-sm-1 col-sm-offset-3 col-md-1 col-md-offset-2 middle");
                init();

			}()); 

		
    });
	
	
	
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("rightContent").innerHTML = xmlhttp.responseText;
		}
	}
	xmlhttp.open("GET", urlTemp+"nei/neiproj/toIndex2", true);
	xmlhttp.send();

});


function selectMenu(temp){
	if(temp==1){
		$("#guanlizhe").addClass("active");
		$("#zhibiaofenxi").removeClass("active");
		$("#gongdanguanli").removeClass("active");
		$("#zhibiaoshujuguanli").removeClass("active");
		selectSecondMenu(1);
	}else if(temp==2){
		$("#guanlizhe").removeClass("active");
		$("#zhibiaofenxi").addClass("active");
		$("#gongdanguanli").removeClass("active");
		$("#zhibiaoshujuguanli").removeClass("active");
		selectSecondMenu(2);
	}else if(temp==3){
		$("#guanlizhe").removeClass("active");
		$("#zhibiaofenxi").removeClass("active");
		$("#gongdanguanli").addClass("active");
		$("#zhibiaoshujuguanli").removeClass("active");
		selectSecondMenu(3);
	}else{
		$("#guanlizhe").removeClass("active");
		$("#zhibiaofenxi").removeClass("active");
		$("#gongdanguanli").removeClass("active");
		$("#zhibiaoshujuguanli").addClass("active");
		selectSecondMenu(4);
	}
}

function selectSecondMenu(temp){
	
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("rightContent").innerHTML = xmlhttp.responseText;
		}
	}
	
	if(temp==1){
		xmlhttp.open("post", urlTemp+"nei/neiproj/toIndex2", true);
	}else if(temp==2){
		xmlhttp.open("GET",  urlTemp+"nei/neiproj/toIndexAnalysis", true);
	}else if(temp==3){
		xmlhttp.open("GET", "../static/html/menu3.dat", true);
	}else{
		xmlhttp.open("GET", "../static/html/menu4.dat", true);
	}
	
	xmlhttp.send();
}

