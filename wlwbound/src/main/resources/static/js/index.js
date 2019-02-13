var urlTemp = panduanUrl();
function panduanUrl(){
    var baseUrl = window.location.href;
    if(baseUrl.indexOf("jksdev_190_171_8080")>=0){
        return "/jksdev_190_171_8080/";
    }else {
        return "/";
    }
}

var $testTable = $('#tableData');


$testTable.bootstrapTable({
    dataType:'json',
    url: urlTemp+'wlwbound/bound/getTableData',
    columns: [{
        title:'1',
        field: 'dateId',
        visible: false
    },{
        field:'apn',
        title: '重点APN'

    },{
        field:'name',
        title:'专网名称',
    },{
        field: 'type',
        title: '主要业务承载制式'
    }, {
        field: 'userCount',
        title: '日活用户数',
        sortable:true,
        sorter:numSort
    }, {
        field: 'userCountDingjieConclusion',
        title: '日活用户数是否异常',
        formatter:function (value,row,index) {

            if(value =='专网运行正常'){
                return [
                    '<a href="javascript:findxiangqing1('+encodeURIComponent(JSON.stringify(row.apn))+','+encodeURIComponent(JSON.stringify(row.dateId))+','+encodeURIComponent(JSON.stringify(row.type))+','+encodeURIComponent(JSON.stringify(row.name))+')">' +
                    '正常' +
                    '</a>'
                ].join('');
            }else {
                return [
                    '<a style="color:#BB4E29" href="javascript:findxiangqing1('+encodeURIComponent(JSON.stringify(row.apn))+','+encodeURIComponent(JSON.stringify(row.dateId))+','+encodeURIComponent(JSON.stringify(row.type))+','+encodeURIComponent(JSON.stringify(row.name))+')">' +
                    '异常' +
                    '</a>'
                ].join('');
            }


        }
    }, {
        field: 'flowKb',
        title: '业务流量（GB）'
    }, {
        field: 'flow_dingjie_conclusion',
        title: '业务流量是否异常',
        formatter:function (value,row,index) {
            if(value=='专网运行正常'){
                return  [
                    '<a href="javascript:findxiangqing2('+encodeURIComponent(JSON.stringify(row.apn))+','+encodeURIComponent(JSON.stringify(row.dateId))+','+encodeURIComponent(JSON.stringify(row.type))+','+encodeURIComponent(JSON.stringify(row.name))+')">' +
                    '正常' +
                    '</a>'
                ].join('');
            }else {
                return [
                    '<a style="color:#BB4E29" href="javascript:findxiangqing2('+encodeURIComponent(JSON.stringify(row.apn))+','+encodeURIComponent(JSON.stringify(row.dateId))+','+encodeURIComponent(JSON.stringify(row.type))+','+encodeURIComponent(JSON.stringify(row.name))+')">' +
                    '异常' +
                    '</a>'
                ].join('');
            }


        }
    }, {
        field: 'attachCountRate',
        title: 'ATTACH成功率（%）',
        formatter:function (value,row,index) {


            if(row.type=='2G'){
                return '-';
            }else {
                return value;
            }
        }
    },{
        field: 'attachCount',
        title: '附着次数(万)'
    },{
        field: 'attachSucRateDingjieConclusion',
        title: 'ATTACH成功率是否异常',
        formatter:function (value,row,index) {

            if(value=='专网运行正常'){
                return  [
                    '<a href="javascript:findxiangqing3('+encodeURIComponent(JSON.stringify(row.apn))+','+encodeURIComponent(JSON.stringify(row.dateId))+','+encodeURIComponent(JSON.stringify(row.type))+','+encodeURIComponent(JSON.stringify(row.name))+')">' +
                    '正常' +
                    '</a>'
                ].join('');
            }else if(value=='-'||value==null||value==undefined){
                return '-';
            }else {
                return [
                    '<a style="color:#BB4E29" href="javascript:findxiangqing3('+encodeURIComponent(JSON.stringify(row.apn))+','+encodeURIComponent(JSON.stringify(row.dateId))+','+encodeURIComponent(JSON.stringify(row.type))+','+encodeURIComponent(JSON.stringify(row.name))+')">' +
                    '异常' +
                    '</a>'
                ].join('');
            }

            if(row.type=='2G'){
                return '-';
            }else {
                return value;
            }
        }
    },{
        field: 'pdpCountRate',
        title: 'PDP激活成功率（%）',
        formatter:function (value,row,index) {


            if(row.type=='4G'){
                return '-';
            }else {
                return value;
            }
        }

    },{
        field: 'attachCountPDP',
        title: '激活次数(万)'
    },{
        field: 'pdpSucRateDingjieConclusion',
        title: 'PDP激活成功率是否异常',
        formatter:function (value,row,index) {
            if(value=='专网运行正常'){
                return  [
                    '<a href="javascript:findxiangqing4('+encodeURIComponent(JSON.stringify(row.apn))+','+encodeURIComponent(JSON.stringify(row.dateId))+','+encodeURIComponent(JSON.stringify(row.type))+','+encodeURIComponent(JSON.stringify(row.name))+')">' +
                    '正常' +
                    '</a>'
                ].join('');
            }else if(value=='-'||value==null||value==undefined){
                return '-';
            }else {
                return [
                    '<a style="color:#BB4E29" href="javascript:findxiangqing4('+encodeURIComponent(JSON.stringify(row.apn))+','+encodeURIComponent(JSON.stringify(row.dateId))+','+encodeURIComponent(JSON.stringify(row.type))+','+encodeURIComponent(JSON.stringify(row.name))+')">' +
                    '异常' +
                    '</a>'
                ].join('');
            }
            if(row.type=='4G'){
                return '-';
            }else {
                return value;
            }

        }

    }]
});
function numSort(a,b){
    return b-a;
}

$(function() {

    var that = $("#scrollWarn");
    getWeekData();
    scrollTalble(that);
    laydate.render({
        elem: '#timeselect',
        format:'yyyyMMdd',
        max:-1

    });
    $('#timeselect').attr("value",getNowFormatDate());

    $("#closeButtonId").click(function () {
        document.getElementById('light').style.display='none';
        document.getElementById('fade').style.display='none';
    });
    $.ajax({
        type:'get',
        url:urlTemp+"wlwbound/bound/getTime",
        dataType:"json",
        success:function(result){
            $('#timeselect').attr("value",result);
            $('#dingjietitle').text(result+'物联网重点行业APN异常监测及问题自动定界');
        }
    });
});
function findTableData() {
    var opt = {
        url: urlTemp+"wlwbound/bound/updateTable",
        silent: true,
        query:{
            timeselect:  $('#timeselect').val()
        }
    };
    $testTable.bootstrapTable('refresh', opt);

    $('#dingjietitle').text($('#timeselect').val()+'物联网重点行业APN异常监测及问题自动定界');
}

//工具方法
function getNowFormatDate() {
    var date = new Date();
    date.setTime(date.getTime()-24*60*60*1000);
    var seperator1 = "";
    var year = date.getFullYear();
    var month = date.getMonth()+1;
    var strDate = date.getDate();
    if(month>=1 && month <=9){
        month = "0"+month;
    }
    if(strDate>=0 && strDate <=9){
        strDate = "0"+strDate;
    }
    var currentdate = year+seperator1+month+seperator1+strDate;
    return currentdate;
}

function findxiangqing1(apn,dateId,type,name) {
    window.open(urlTemp+"wlwbound/bound/toUserCount?apn="+apn+"&dateId="+dateId+"&type="+type+"&name="+name,"_blank");
}

function findxiangqing2(apn,dateId,type,name) {
    window.open(urlTemp+"wlwbound/bound/toFlow?apn="+apn+"&dateId="+dateId+"&type="+type+"&name="+name,"_blank");
}

function findxiangqing3(apn,dateId,type,name) {
    window.open(urlTemp+"wlwbound/bound/toAttach?apn="+apn+"&dateId="+dateId+"&type="+type+"&name="+name,"_blank");
}

function findxiangqing4(apn,dateId,type,name) {
    window.open(urlTemp+"wlwbound/bound/toPdp?apn="+apn+"&dateId="+dateId+"&type="+type+"&name="+name,"_blank");
}

function findGuiZe(){
    document.getElementById('light').style.display='block';
    document.getElementById('fade').style.display='block';
}


function scrollTalble(that){
    var scrollTimer;
    that.hover(function () {
        clearInterval(scrollTimer);
    }, function () {
        scrollTimer = setInterval(function () {
            scrollNews(that);
        }, 1500);
    }).trigger("mouseleave");

    function scrollNews(obj) {
        var $self = obj.find("ul");
        var lineHeight = $self.find("li:first").height();
        $self.animate({
            "marginTop": -lineHeight + "px"
        }, 600, function () {
            $self.css({
                marginTop: 0
            }).find("li:first").appendTo($self);
        })
    }

}

function exportTable() {
    window.location.href=urlTemp+"wlwbound/bound/createzhongduanExcel?timeselect="+ $("#timeselect").val();

}

function  getWeekData(){
   console.log("---------------")


    $("#weekData").attr("class","btn btn-success");
    $("#monthData").attr("class","btn btn-default");
    $.ajax({
        type:'get',
        url:urlTemp+"wlwbound/bound/getWarnApn",
        dataType:"json",
        data:{
            temp:1
        },
        success:function(data){
            var result = eval(data)
            console.log(result.length);
            var htmlText ='<ul style="margin-top: 0px;">';
            for(var i=0;i<result.length;i++){
                htmlText += '<li style="text-align:center;">'+
                    '<span class="warnDate">'+result[i].time+'</span>'+
                    '<span class="warnApn">'+result[i].apn+'</span>'+
                    '<span class="warnApnName">'+result[i].name+'</span>'+
                    '<span class="warnContent">'+result[i].content+'</span>'+
                    ' <span class="warnResult">'+result[i].result+'</span>'+
                    '</li>';
            }




            htmlText+= ' </ul>';

            $("#scrollWarn").html(htmlText);


        }
    });

}

function  getMonthData(){
    $("#monthData").attr("class","btn btn-success");
    $("#weekData").attr("class","btn btn-default");

    $.ajax({
        type:'get',
        url:urlTemp+"wlwbound/bound/getWarnApn",
        dataType:"json",
        data:{
            temp:2
        },
        success:function(result){
            var htmlText ='<ul style="margin-top: 0px;">';
            for(var i=0;i<result.length;i++){
                htmlText += '<li style="text-align:center;">'+
                    '<span class="warnDate">'+result[i].time+'</span>'+
                    '<span class="warnApn">'+result[i].apn+'</span>'+
                    '<span class="warnApnName">'+result[i].name+'</span>'+
                    '<span class="warnContent">'+result[i].content+'</span>'+
                    ' <span class="warnResult">'+result[i].result+'</span>'+
                    '</li>';
            }




            htmlText+= ' </ul>';
            $("#scrollWarn").html(htmlText);


        }
    });


}