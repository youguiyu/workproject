var urlTemp = panduanUrl();
function panduanUrl(){
    var baseUrl = window.location.href;
    if(baseUrl.indexOf("jksdev_190_171_8080")>=0){
        return "/jksdev_190_171_8080/";
    }else {
        return "/";
    }
}


function panduanUrl2(){
    $("#glzhe").attr("href",urlTemp+"nei/neiproj/toIndex");
    $("#pgjg").attr("href",urlTemp+"nei/neiproj/toPingGu");
    $("#zlpg").attr("href",urlTemp+"nei/neiproj/toZhibiao");
    $("#dbfx").attr("href",urlTemp+"nei/neiproj/todbfx");
    $("#zbgl").attr("href",urlTemp+"nei/neiproj/toDataexport");

}
laydate.render({
    elem: '#monthselect',
    type: 'month',
    format:'M',
    value:new Date().getMonth(),
    max:-1,
    btns: ['confirm']
});
$(function () {
    panduanUrl2();

    $('#btnAll').click(function () {
        var data = $("#monthselect").val();

        if (data != null && data != "")
            //window.open("reportAll?month=" + $("#monthselect").val());
           window.open(urlTemp+"nei/neiexprot/reportAll?month=" + $("#monthselect").val());
            //window.open(urlTemp+"nei2/neiexprot/reportAll?month=12");
    });

});