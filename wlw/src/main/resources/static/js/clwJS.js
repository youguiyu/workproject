$(document).ready(function(){ 

	
}); 
//转向质量分析页面
function clwqualityAZ(){
	document.getElementById("wlwztmain").src="http://10.48.190.171:8022/Common/Index?flag=telematic";
}

function clwxdrAZ(){
	document.getElementById("wlwztmain").src="http://10.48.190.171:8022/Common/Index2?flag=telematic";
}
//转向业务分析页面
function clwbusinessAZ(){
	document.getElementById("wlwztmain").src="http://10.48.190.171:8022/Common/Index3?flag=telematic";
}
//转向异常行为分析页面
function clwabnormalBehaviorAZ(){
	document.getElementById("wlwztmain").src="blank_h.html";
}
//转向GIS图页面
function clwGistAZ(){
	document.getElementById("wlwztmain").src="blank_h.html";
}