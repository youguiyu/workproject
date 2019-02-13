$(document).ready(function(){ 

	
}); 
//转向质量分析页面
function shuiliqualityAZ(){
	document.getElementById("wlwztmain").src="http://10.48.190.171:8022/Common/Index?flag=water";
}
function shuilixdrAZ(){
	
	document.getElementById("wlwztmain").src="http://10.48.190.171:8022/Common/Index2?flag=water";
}
//转向业务分析页面
function shuilibusinessAZ(){
	document.getElementById("wlwztmain").src="http://10.48.190.171:8022/Common/Index3?flag=water";
}
//转向异常行为分析页面
function shuiliabnormalBehaviorAZ(){
	document.getElementById("wlwztmain").src="blank_h.html";
}
//转向GIS图页面
function shuiliGistAZ(){
	document.getElementById("wlwztmain").src="blank_h.html";
}