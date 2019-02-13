var urlTemp = panduanUrl();

$(function () {
    var result= $("#result").val();
    var status= $("#status").val();
    $("#leadContent").text(result);
    if(status==0){
        $("#leadC2").css('display','none');

    }else {
        $("#leadC2").css('display','block');
        var url= "nei/static/res/result.csv"

        $("#btn").attr("href",urlTemp+url);
    }

});


function panduanUrl(){
    var baseUrl = window.location.href;
    if(baseUrl.indexOf("jksdev_190_171_8080")>=0){
        return "/jksdev_190_171_8080/";
    }else {
        return "/";
    }
}