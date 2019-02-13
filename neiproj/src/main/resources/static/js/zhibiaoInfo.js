var urlTemp = panduanUrl();

$(function(){



    var time= $("#time").val();
    var demension= $("#demension").val();
    var businessType=$("#businessType").val();
    var $testTable = $('#testTable');
    //console.log(time);
    //console.log(businessType);
    var text = time + panduanZibiao(businessType) +"中的"+demension+"子维度未达指标详情";
    $("#title").html(text);

    $testTable.bootstrapTable({
        url: urlTemp+'nei/neiproj/getTableData2',
        //url: '/getTableData',
        queryParams: function (params) {
            return {
                offset: params.offset,
                limit: params.limit,
                selectsilun: businessType,
                selecttenW: demension,
                timeselect: time
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
                    '<a href="javascript:lookqushi('+encodeURIComponent(JSON.stringify(row.kpiName))+','+encodeURIComponent(JSON.stringify(row.dimension))+','+encodeURIComponent(JSON.stringify(row.kpiInfo))+','+encodeURIComponent(JSON.stringify(row.city))+')">' +
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
});

function panduanZibiao(b){
    if(b==1){
        return "移动业务";
    }else if(b==2){
        return "家庭业务";
    }else if(b==3){
        return "政企业务";
    }else{
        return "新业务";
    }
}


function panduanUrl(){
    var baseUrl = window.location.href;
    if(baseUrl.indexOf("jksdev_190_171_8080")>=0){
        return "/jksdev_190_171_8080/";
    }else {
        return "/";
    }
}


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




function openwin(){
    document.getElementById('light').style.display='block';
    document.getElementById('fade').style.display='block'
}




function lookqushi(kpiName,dimension,kpiInfo,city){
    document.getElementById('light').style.display='block';
    document.getElementById('fade').style.display='block';
    var cityNum=panduanCity(city);
    //updatequshiTable(kpiName,dimension,kpiInfo);
    $.ajax({
        type:'get',
        //url:"/getqushiData",
        url:urlTemp+"nei/neiproj/getqushiData2",
        dataType:"json",
        data:{
            kpiName:kpiName,
            dimension:dimension,
            selectsilun: $("#businessType").val(),
            cityNum: cityNum,
            timeselect: $("#time").val()
        },
        success:function(result){

            var tableData = eval(result);
            //趋势图
            updatequshiTable(kpiName,dimension,kpiInfo,tableData);


        }
    });



}
function panduanCity(city) {
    if(city=='全省'){
        return 590;
    }else if(city=='福州'){
        return 591;
    }else if(city=='厦门'){
        return 592;
    }else if(city=='宁德'){
        return 593;
    }else if(city=='莆田'){
        return 594;
    }else if(city=='泉州'){
        return 595;
    }else if(city=='漳州'){
        return 596;
    }else if(city=='龙岩'){
        return 597;
    }else if(city=='三明'){
        return 598;
    }else {
        return 599;
    }
    
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
    laydate.render({
        elem: '#timeselect',
        max:-1

    });


    $("#closeButtonId").click(function () {
        document.getElementById('light').style.display='none';
        document.getElementById('fade').style.display='none';
    });
});
