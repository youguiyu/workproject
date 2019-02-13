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
var $testTable = $('#testTable');
$('#timeselect').attr("value",getNowFormatDate());
// var selectsilun = $(".img-responsive").attr("alt");
// var selecttenW=checkedTest();
// var tempJSON = JSON.stringify(selecttenW);
// var reportType = $("#reportL option:selected").val();
// var cityOption = $("#cityOption option:selected").val();
// var timeselect = chuliRiqi($("#timeselect").val());


$testTable.bootstrapTable({
    url: urlTemp+'nei/neiproj/getTableData',
    //url: '/getTableData',
    queryParams: function (params) {
        return {
            offset: params.offset,
            limit: params.limit,
            selectsilun: $(".img-responsive").attr("alt"),
            selecttenW: JSON.stringify(checkedTest()),
            reportType: $("#reportL option:selected").val(),
            cityNum: $("#cityOption option:selected").val(),
            timeselect: chuliRiqi($("#timeselect").val())
        }
    },
    columns: [{
        title:'1',
        field: 'kpiName',
        visible: false
    },{
        title:'编号',
        formatter:function (value,row,index) {
            return index+1;
        }
    },{
        field: 'dimension',
        title: '维度名称'
    }, {
        field: 'subDimension',
        title: '子维度名称'
    }, {
        field: 'kpiInfo',
        title: '指标'
    }, {
        field: 'city',
        title: '地市'
    }, {
        field: 'dateId',
        title: '时间'
    }, {
        field: 'benchmarkValue',
        title: '基准值'
    }, {
        field: 'challengeValue',
        title: '挑战值'
    },{
        field: 'currentValue',
        title: '当前值',
        formatter: function (value, row, index) {
            var temp = '';
            if(row.other=='x'){
                if(row.currentValue>row.benchmarkValue && row.currentValue>row.challengeValue){
                    temp =row.currentValue+ '<span class="glyphicon glyphicon-arrow-up" aria-hidden="true">'+
                        '<span class="glyphicon glyphicon-arrow-up" aria-hidden="true">';
                }else if (row.currentValue>row.benchmarkValue && row.currentValue<=row.challengeValue){
                    temp =row.currentValue+ '<span class="glyphicon glyphicon-arrow-up" aria-hidden="true">';
                }else {
                    temp =row.currentValue;
                }
            }else if(row.other=='y'){
                if(row.currentValue<row.benchmarkValue && row.currentValue<row.challengeValue){
                    temp =row.currentValue+ '<span class="glyphicon glyphicon-arrow-up" aria-hidden="true">'+
                        '<span class="glyphicon glyphicon-arrow-up" aria-hidden="true">';
                }else if (row.currentValue<=row.benchmarkValue && row.currentValue>=row.challengeValue){
                    temp =row.currentValue+ '<span class="glyphicon glyphicon-arrow-up" aria-hidden="true">';
                }else {
                    temp =row.currentValue;
                }
            }
            return [
                temp
            ].join('');
        }
    },{
        formatter: function (value, row, index) {
            return [
                '<a href="javascript:lookqushi('+encodeURIComponent(JSON.stringify(row.kpiName))+','+encodeURIComponent(JSON.stringify(row.dimension))+','+encodeURIComponent(JSON.stringify(row.kpiInfo))+')">' +
                '<i class="glyphicon glyphicon-pencil"></i>趋势' +
                '</a>'
            ].join('');
        },
        title: '操作'
    }],
    striped: true,
    pagination: true,
    sidePagination: 'server',
    pageSize: 10,
    pageList: [5, 10, 25, 50, 100]
});


function getNowFormatDate() {
    var date = new Date();
    date.setTime(date.getTime()-24*60*60*1000);
    var seperator1 = "-";
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

function chuliRiqi(dqDate) {
    if(dqDate.length>6){
        var dqDate1 = dqDate.substring(0,4);
        var dqDate2 = dqDate.substring(5,7);
        var dqDate3 = dqDate.substring(8,dqDate.length);
        return dqDate1+dqDate2+dqDate3;
    }else {
        var dqDate1 = dqDate.substring(0,4);
        var dqDate2 = dqDate.substring(5,7);
        return dqDate1+dqDate2;
    }

}

function findTableData() {
    if(timeselect==''){
        alert("时间未选择，请选择。。。");
    }else{
        var opt = {
            //url: "/getTableData",
            url: urlTemp+"nei/neiproj/getTableData",
            silent: true,
            query:{
                selectsilun: $(".img-responsive").attr("alt"),
                selecttenW: JSON.stringify(checkedTest()),
                reportType: $("#reportL option:selected").val(),
                cityNum: $("#cityOption option:selected").val(),
                timeselect: chuliRiqi($("#timeselect").val())
            }
        };
        $testTable.bootstrapTable('refresh', opt);
    }


}

function checkedTest() {
    var selas=[];
    var checkArry = document.getElementsByName("cc");
    for(var i=0; i<checkArry.length; i++){
        if(checkArry[i].checked == true){
            selas.push(checkArry[i].value);
        }
    }
    var jsonSelas='{';

    for(var j=0; j<selas.length; j++){
        if(j==selas.length-1){
            jsonSelas= jsonSelas+selas[j]+'}';
        }else{
            jsonSelas= jsonSelas+selas[j]+',';
        }
    }



    return jsonSelas;

}
function reportLSecOnChange(obj){

    var selectV = obj.selectedIndex;

    var monthContent = '<form action="" method=post name=form1>'+
        '<div class="col-xs-2">'+
        '<div class="input-group">'+
        ' <select  class="form-control"  >'+
        '	<option value="0" selected>福建</option>'+
        '</select>'+
        ' <span class="input-group-addon" id="basic-addon2">省</span>'+
        '</div>'+
        '</div>'+
        '<div class="col-xs-2">'+
        '<div class="input-group">'+
        '<select class="form-control" id="cityOption" >'+

        '<option value="590" selected>全省</option>'+
        '<option value="591" >福州</option>'+
        '<option value="592" >厦门</option>'+
        '<option value="593" >宁德</option>'+
        '<option value="594" >莆田</option>'+
        '<option value="595" >泉州</option>'+
        '<option value="596" >漳州</option>'+
        '<option value="597" >龙岩</option>'+
        '<option value="598" >三明</option>'+
        '<option value="599" >南平</option>'+
        '</select>'+
        '<span class="input-group-addon" id="basic-addon2">市</span>'+
        '</div>'+
        '</div>'+

        '</form>'+

        '<div class="col-xs-2">'+
        '<div class="input-group">'+
        ' <input type="text" class="form-control" placeholder="请选择月份" aria-describedby="basic-addon2" id="timeselect">'+
        '<span class="input-group-addon" id="basic-addon2">月</span>'+
        '</div>'+
        '</div>'+

        '<div class="col-xs-2">'+
        ' <button type="button" class="btn btn-default" onclick="javascript:findTableData()">查询</button>'+
        '</div>'+
        '</div>';
    var dayContent ='<form action="" method=post name=form1>'+
        '<div class="col-xs-2">'+
        '<div class="input-group">'+
        ' <select  class="form-control" >'+
        '	<option value="0" selected>福建</option>'+
        '</select>'+
        ' <span class="input-group-addon" id="basic-addon2">省</span>'+
        '</div>'+
        '</div>'+
        '<div class="col-xs-2">'+
        '<div class="input-group">'+
        '<select class="form-control" id="cityOption">'+
        '<option value="590" selected>全省</option>'+
        '<option value="591" >福州</option>'+
        '<option value="592" >厦门</option>'+
        '<option value="593" >宁德</option>'+
        '<option value="594" >莆田</option>'+
        '<option value="595" >泉州</option>'+
        '<option value="596" >漳州</option>'+
        '<option value="597" >龙岩</option>'+
        '<option value="598" >三明</option>'+
        '<option value="599" >南平</option>'+
        '</select>'+
        '<span class="input-group-addon" id="basic-addon2">市</span>'+
        '</div>'+
        '</div>'+

        '</form>'+
        '<div class="col-xs-2">'+
        '<div class="input-group">'+
        ' <input type="text" class="form-control" placeholder="请选择日期" aria-describedby="basic-addon2" id="timeselect">'+
        '<span class="input-group-addon" id="basic-addon2">日</span>'+
        '</div>'+
        '</div>'+

        '<div class="col-xs-2">'+
        ' <button type="button" class="btn btn-default" onclick="javascript:findTableData()">查询</button>'+
        '</div>'+
        '</div>';


    if(selectV==0){
        $("#xztj").html(dayContent);

        laydate.render({
            elem: '#timeselect',
            max:-1

        });

    }else if(selectV==1){
        $("#xztj").html(monthContent);

        laydate.render({
            elem: '#timeselect'
            ,type: 'month',
            max:-1
        });


    }
}



function openwin(){
    document.getElementById('light').style.display='block';
    document.getElementById('fade').style.display='block'
}




function lookqushi(kpiName,dimension,kpiInfo){
    document.getElementById('light').style.display='block';
    document.getElementById('fade').style.display='block';

    //updatequshiTable(kpiName,dimension,kpiInfo);
    $.ajax({
        type:'get',
        //url:"/getqushiData",
        url:urlTemp+"nei/neiproj/getqushiData",
        dataType:"json",
        data:{
            kpiName:kpiName,
            dimension:dimension,
            selectsilun: $(".img-responsive").attr("alt"),
            reportType: $("#reportL option:selected").val(),
            cityNum: $("#cityOption option:selected").val(),
            timeselect: chuliRiqi($("#timeselect").val())
        },
        success:function(result){

            var tableData = eval(result);
            //趋势图
           updatequshiTable(kpiName,dimension,kpiInfo,tableData);


        }
    });



}

function updatequshiTable(kpiName,dimension,kpiInfo,tableData) {


    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('chartmain'));

    // 指定图表的配置项和数据
    var option = {
        title:{
            text:"指标数据趋势("+dimension+"-"+kpiInfo+")"
        },
        tooltip:{
            trigger:'axis',
            axisPointer:{
                type:'cross',
                label:{
                    backgroundColor: '#6a7985'
                }
            }
        },
        toolbox:{
            feature:{
                dataView:{readOnly:false},
                saveAsImage:{},
                magicType:{
                    type:['line','bar']
                },
                restore:{}
            }
        },
        xAxis: {
            type: 'category',
            data: tableData.xData
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data:tableData.yData,
            type: 'line'
        }]

    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}



function panduanClass(that) {
    if(!$(that).hasClass("img-responsive")){
        $(that).attr("class","img-responsive");
        $(that).parent().siblings().children().attr("class","imgGray");
    }
}

$(function() {

    panduanUrl2();
    laydate.render({
        elem: '#timeselect',
        max:-1

    });


    $("#closeButtonId").click(function () {
        document.getElementById('light').style.display='none';
        document.getElementById('fade').style.display='none';
    });
});
