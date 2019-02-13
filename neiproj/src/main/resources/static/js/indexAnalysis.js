
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
   //init();
});

function init() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("home").innerHTML = xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET", urlTemp+"nei/neiproj/toZhibiao", true);
    xmlhttp.send();
}