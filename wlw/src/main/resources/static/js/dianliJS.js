﻿$(document).ready(function(){ 

	
}); 
//转向质量分析页面
function dianliqualityAZ(){
	document.getElementById("wlwztmain").src="http://10.48.190.171:8022/Common/Index?flag=power";

}

function dianlixdrAZ(){
	document.getElementById("wlwztmain").src="http://10.48.190.171:8022/Common/Index2?flag=power";
}
//转向业务分析页面
function dianlibusinessAZ(){
	document.getElementById("wlwztmain").src="http://10.48.190.171:8022/Common/Index3?flag=power";
}
//转向异常行为分析页面
function dianliabnormalBehaviorAZ(){
	document.getElementById("wlwztmain").src="blank_h.html";
}
//转向GIS图页面
function dianliGistAZ(){
	document.getElementById("wlwztmain").src="blank_h.html";
}