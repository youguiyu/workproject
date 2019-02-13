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
$(function () {

    panduanUrl2();
    $('#timeselect').attr("value",getNowFormatDate());
    laydate.render({
        elem: '#timeselect',
        max:-1,
        min:-30

    });
    $.ajax({
        type:'get',
        //url:"/getRadar1Data",
        url:urlTemp+"nei/neiproj/getRadar1Data",
        dataType:"json",
        success:function(result){
            var tableData = eval(result);
            //趋势图
            initRadar1(tableData);
        }
    });

    $.ajax({
        type:'get',
        //url:"/getRadar2Data",
        url:urlTemp+"nei/neiproj/getRadar2Data",
        dataType:"json",
        success:function(result){
            var tableData = eval(result);
            //趋势图
            initRadar2(tableData);
        }
    });


    $.ajax({
        type:'post',
        //url:"/getRadar1Data",
        url:urlTemp+"nei/neiproj/getPingGuTalbeA",
        dataType:"json",
        data:{dateId:chuliRiqi($("#timeselect").val()),temp:1},
        success:function(result){
            var tableData = eval(result);
            //趋势图
            initTable1(tableData);
        }
    });

    findTableData1();
    findTableData2();
    findTableData3();
    findTableData4();

});

function findTableData(){
    findTableData1();
    findTableData2();
    findTableData3();
    findTableData4();
}
function findTableData1() {
    $("#ydyw").html("");

    $.ajax({
        type:'post',
        //url:"/getRadar1Data",
        url:urlTemp+"nei/neiproj/getPingGuTalbeA",
        dataType:"json",
        data:{dateId:chuliRiqi($("#timeselect").val()),temp:1},
        success:function(result){
            var tableData = eval(result);
            console.log("findTableData1:"+tableData);
            //趋势图
            initTable1(tableData);
        }
    });
}

function findTableData2() {

    $("#jtyw").html("");


    $.ajax({
        type:'post',
        //url:"/getRadar1Data",
        url:urlTemp+"nei/neiproj/getPingGuTalbeA",
        dataType:"json",
        data:{dateId:chuliRiqi($("#timeselect").val()),temp:2},
        success:function(result){

            var tableData = eval(result);
            console.log("findTableData2:"+tableData);
            //趋势图
            initTable2(tableData);
        }
    });
}

function findTableData3() {


    $("#zqyw").html("");



    $.ajax({
        type:'post',
        //url:"/getRadar1Data",
        url:urlTemp+"nei/neiproj/getPingGuTalbeA",
        dataType:"json",
        data:{dateId:chuliRiqi($("#timeselect").val()),temp:3},
        success:function(result){
            var tableData = eval(result);
            //趋势图
            initTable3(tableData);
        }
    });
}

function findTableData4() {


    $("#xyw").html("");

    $.ajax({
        type:'post',
        //url:"/getRadar1Data",
        url:urlTemp+"nei/neiproj/getPingGuTalbeA",
        dataType:"json",
        data:{dateId:chuliRiqi($("#timeselect").val()),temp:4},
        success:function(result){
            var tableData = eval(result);
            //趋势图
            initTable4(tableData);
        }
    });
}


function initTable1(tableData) {
    var htmlText='';
    var nameTemp=1;
    if(tableData[0].temp>0){
        htmlText ='<tr>'+
            '<td rowspan="'+tableData.length+'">移动业务</td>'+
            '<td>'+tableData[0].ziweidu+'</td>'+
            '<td>'+tableData[0].score+'</td>'+
            '<td><a href="javascript:findZhibiaoInfo('+nameTemp+','+encodeURIComponent(JSON.stringify(tableData[0].ziweidu))+');">'+tableData[0].temp+'</a></td>'+
            '</tr>';
    }else{
        htmlText ='<tr>'+
            '<td rowspan="'+tableData.length+'">移动业务</td>'+
            '<td>'+tableData[0].ziweidu+'</td>'+
            '<td>'+tableData[0].score+'</td>'+
            '<td>'+tableData[0].temp+'</td>'+
            '</tr>';
    }



    for(var i=1; i<tableData.length;i++){
        if(tableData[i].temp>0){
            htmlText=htmlText+'<tr>'+
                '<td>'+tableData[i].ziweidu+'</td>'+
                '<td>'+tableData[i].score+'</td>'+
                '<td><a href="javascript:findZhibiaoInfo('+nameTemp+','+encodeURIComponent(JSON.stringify(tableData[i].ziweidu))+')">'+tableData[i].temp+'</a></td>'+

                '</tr>';
        }else{
            htmlText=htmlText+'<tr>'+
                '<td>'+tableData[i].ziweidu+'</td>'+
                '<td>'+tableData[i].score+'</td>'+
                '<td>'+tableData[i].temp+'</td>'+
                '</tr>';
        }

    }

    $("#ydyw").html(htmlText);
}
function initTable2(tableData) {

    var nameTemp=2;
    var htmlText='';
    if(tableData[0].temp>0){
        htmlText ='<tr>'+
            '<td rowspan="'+tableData.length+'">家庭业务</td>'+
            '<td>'+tableData[0].ziweidu+'</td>'+
            '<td>'+tableData[0].score+'</td>'+
            '<td><a href="javascript:findZhibiaoInfo('+nameTemp+','+encodeURIComponent(JSON.stringify(tableData[0].ziweidu))+');">'+tableData[0].temp+'</a></td>'+
            '</tr>';
    }else{
        htmlText ='<tr>'+
            '<td rowspan="'+tableData.length+'">家庭业务</td>'+
            '<td>'+tableData[0].ziweidu+'</td>'+
            '<td>'+tableData[0].score+'</td>'+
            '<td>'+tableData[0].temp+'</td>'+
            '</tr>';
    }



    for(var i=1; i<tableData.length;i++){
        if(tableData[i].temp>0){
            htmlText=htmlText+'<tr>'+
                '<td>'+tableData[i].ziweidu+'</td>'+
                '<td>'+tableData[i].score+'</td>'+
                '<td><a href="javascript:findZhibiaoInfo('+nameTemp+','+encodeURIComponent(JSON.stringify(tableData[i].ziweidu))+')">'+tableData[i].temp+'</a></td>'+

                '</tr>';
        }else{
            htmlText=htmlText+'<tr>'+
                '<td>'+tableData[i].ziweidu+'</td>'+
                '<td>'+tableData[i].score+'</td>'+
                '<td>'+tableData[i].temp+'</td>'+
                '</tr>';
        }

    }

    $("#jtyw").html(htmlText);
}
function initTable3(tableData) {

    var nameTemp=3;
    var htmlText='';
    if(tableData[0].temp>0){
        htmlText ='<tr>'+
            '<td rowspan="'+tableData.length+'">政企业务</td>'+
            '<td>'+tableData[0].ziweidu+'</td>'+
            '<td>'+tableData[0].score+'</td>'+
            '<td><a href="javascript:findZhibiaoInfo('+nameTemp+','+encodeURIComponent(JSON.stringify(tableData[0].ziweidu))+');">'+tableData[0].temp+'</a></td>'+
            '</tr>';
    }else{
        htmlText ='<tr>'+
            '<td rowspan="'+tableData.length+'">政企业务</td>'+
            '<td>'+tableData[0].ziweidu+'</td>'+
            '<td>'+tableData[0].score+'</td>'+
            '<td>'+tableData[0].temp+'</td>'+
            '</tr>';
    }



    for(var i=1; i<tableData.length;i++){
        if(tableData[i].temp>0){
            htmlText=htmlText+'<tr>'+
                '<td>'+tableData[i].ziweidu+'</td>'+
                '<td>'+tableData[i].score+'</td>'+
                '<td><a href="javascript:findZhibiaoInfo('+nameTemp+','+encodeURIComponent(JSON.stringify(tableData[i].ziweidu))+')">'+tableData[i].temp+'</a></td>'+

                '</tr>';
        }else{
            htmlText=htmlText+'<tr>'+
                '<td>'+tableData[i].ziweidu+'</td>'+
                '<td>'+tableData[i].score+'</td>'+
               '<td>'+tableData[i].temp+'</td>'+
                '</tr>';
        }

    }

    $("#zqyw").html(htmlText);
}
function initTable4(tableData) {

    var nameTemp=4;
    var htmlText='';
    if(tableData[0].temp>0){
        htmlText ='<tr>'+
            '<td rowspan="'+tableData.length+'">新业务</td>'+
            '<td>'+tableData[0].ziweidu+'</td>'+
            '<td>'+tableData[0].score+'</td>'+
            '<td><a href="javascript:findZhibiaoInfo('+nameTemp+','+encodeURIComponent(JSON.stringify(tableData[0].ziweidu))+');">'+tableData[0].temp+'</a></td>'+
            '</tr>';
    }else{
        htmlText ='<tr>'+
            '<td rowspan="'+tableData.length+'">新业务</td>'+
            '<td>'+tableData[0].ziweidu+'</td>'+
            '<td>'+tableData[0].score+'</td>'+
            '<td>'+tableData[0].temp+'</td>'+
            '</tr>';
    }



    for(var i=1; i<tableData.length;i++){
        if(tableData[i].temp>0){
            htmlText=htmlText+'<tr>'+
                '<td>'+tableData[i].ziweidu+'</td>'+
                '<td>'+tableData[i].score+'</td>'+
                '<td><a href="javascript:findZhibiaoInfo('+nameTemp+','+encodeURIComponent(JSON.stringify(tableData[i].ziweidu))+')">'+tableData[i].temp+'</a></td>'+

                '</tr>';
        }else{
            htmlText=htmlText+'<tr>'+
                '<td>'+tableData[i].ziweidu+'</td>'+
                '<td>'+tableData[i].score+'</td>'+
                '<td>'+tableData[i].temp+'</td>'+
                '</tr>';
        }

    }

    $("#xyw").html(htmlText);
}

function findZhibiaoInfo(businessType,demension) {
    var time=chuliRiqi($("#timeselect").val());

    window.open(urlTemp+'nei/neiproj/toZhibiaoInfo?time='+time+'&&businessType='+businessType+'&&demension='+demension,'_blank');

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
function initRadar1(tableData) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('radar1'));
    var option = {
        title: {
            text: '四轮总体情况'
        },
        tooltip: {},
        legend: {
            data: ['本期', '上期','全国','最优','最差']
        },
        radar: {
            // shape: 'circle',
            name: {
                textStyle: {
                    color: '#fff',
                    backgroundColor: '#999',
                    borderRadius: 3,
                    padding: [3, 5]
                }
            },
            indicator: [
                { name: '四轮驱动总分', max: 100},
                { name: '移动业务', max: 100},
                { name: '家庭业务', max: 100},
                { name: '政企业务', max: 100},
                { name: '新业务', max: 100}
            ]
        },
        series: [{
            name: '四轮总体情况',
            type: 'radar',
            // areaStyle: {normal: {}},
            data : tableData
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

function initRadar2(tableData) {
    // 基于准备好的dom，初始化echarts实例
    var myChart1 = echarts.init(document.getElementById('radar2'));
    var option1 = {
        title: {
            text: '十维度情况表现分布图'
        },
        tooltip: {},
        legend: {
            data: ['本期', '上期','全国','最优','最差']
        },
        radar: {
            // shape: 'circle',
            name: {
                textStyle: {
                    color: '#fff',
                    backgroundColor: '#999',
                    borderRadius: 3,
                    padding: [3, 5]
                }
            },
            indicator: [
                { name: '客户反映', max: 100},
                { name: '业务感知', max: 100},
                { name: '服务感知', max: 100},
                { name: '竞对感知', max: 100},
                { name: '场景感知', max: 100},
                { name: '最差感知', max: 100},
                { name: '覆盖感知', max: 100},
                { name: '容量感知', max: 100},
                { name: '结构感知', max: 100}

            ]
        },
        series: [{
            name: '十维度情况表现分布图',
            type: 'radar',
            // areaStyle: {normal: {}},
            data : tableData
        }]
    };

// 使用刚指定的配置项和数据显示图表。
    myChart1.setOption(option1);
}




