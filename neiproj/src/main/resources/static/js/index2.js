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

   // panduanUrl2();
    $('#timeselect').attr("value",getNowFormatDate());
    laydate.render({
        elem: '#timeselect',
        max:-1

    });
    init();



});

function init(){
    $.ajax({
        type:'post',
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
        type:'post',
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
        url:urlTemp+"nei/neiproj/getRadar1Data",
        dataType:"json",
        success:function(result){
            var tableData = eval(result);
            //趋势图
            initRadar3(tableData);
        }
    });

    $.ajax({
        type:'post',
        //url:"/getRadar2Data",
        url:urlTemp+"nei/neiproj/getRadar2Data",
        dataType:"json",
        success:function(result){
            var tableData = eval(result);
            //趋势图
            initRadar4(tableData);
        }
    });


    $.ajax({
        type:'post',
        url:urlTemp+"nei/neiproj/getMapData",
        // url:"/getMapData",

        dataType:"json",
        success:function(result){
            var tableData = eval(result);
            //趋势图
            initMapData(tableData);
        }
    });

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
            data: ['本期', '上期','全国','最优','最差'],
            orient: 'vertical',
            y: 'bottom',
            x:'left'
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
            data: ['本期', '上期','全国','最优','最差'],
            orient: 'vertical',
            y: 'bottom',
            x:'left'
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

function initRadar3(tableData) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('radar3'));
    var option = {
        title: {
            text: '四轮总体情况'
        },
        tooltip: {},
        legend: {
            data: ['本期', '上期','全国','最优','最差'],
            orient: 'vertical',
            y: 'bottom',
            x:'left'
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

function initRadar4(tableData) {
    // 基于准备好的dom，初始化echarts实例
    var myChart1 = echarts.init(document.getElementById('radar4'));
    var option1 = {
        title: {
            text: '十维度情况表现分布图'
        },
        tooltip: {},
        legend: {
            data: ['本期', '上期','全国','最优','最差'],
            orient: 'vertical',
            y: 'bottom',
            x:'left'
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


function initMapData(tableData) {
    // 指定图表的配置项和数据
    function randomData() {
        return Math.round(Math.random()*100);
    }

    require.config({
        paths: {
            echarts: '../static/js/dist'
        }
    });



    // 使用
    require(
        [
            'echarts',
            'echarts/chart/map' // 使用柱状图就加载bar模块，按需加载
        ],
        function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('ydywEchart'));

            var option = {
                title : {
                    text: '福建省NEI网络质量评估（'+tableData.riqi+'）',
                    x:'center'
                },
                tooltip : {
                    trigger: 'item',
                    formatter: function(params) {
                        var res = params.name+'<br/>';
                        var myseries = option.series;
                        for (var i = 0; i < myseries.length; i++) {
                            for(var j=0;j<myseries[i].data.length;j++){
                                if(myseries[i].data[j].name==params.name){
                                    res+=myseries[i].name +' : '+myseries[i].data[j].value+'</br>';
                                }
                            }
                        }
                        return res;
                    }
                },
                legend: {
                    orient: 'vertical',
                    x:'left',
                    data:['总体性能评估值','移动业务NEI-性能评估值','家庭业务NEI-性能评估值','政企业务NEI-性能评估值','新业务NEI-性能评估值']
                },
                dataRange: {
                    x: 'left',
                    y: 'bottom',
                    splitList: [
                        {start: 99},
                        {start: 96, end: 99},
                        {start: 93, end:96},
                        {start: 90, end: 93},
                        {start: 85, end: 90},
                        {start: 80, end: 85},
                        {start: 75, end: 80},
                        {start: 70, end: 75},
                        {start: 0, end: 70}
                    ],
                    color: ['#CAE1FF', '#C0FF3E', '#BFEFFF','#B452CD', '#B22222', '#4169E1','#00FF7F', '#8B814C', '#CD9B1D']
                },
                toolbox: {
                    show: true,
                    orient : 'vertical',
                    x: 'right',
                    y: 'center',
                    feature : {
                        dataView : {show: true, readOnly: false},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                series : [
                    {
                        name: '总体性能评估值',
                        type: 'map',
                        mapType: '福建',
                        roam:true,
                        mapValueCalculation:'average',
                        itemStyle:{
                            normal:{label:{show:true}},
                            emphasis:{label:{show:true}}
                        },
                        data:tableData.zxnpg
                    },{
                        name: '移动业务NEI-性能评估值',
                        type: 'map',
                        mapType: '福建',
                        roam:true,
                        mapValueCalculation:'average',
                        itemStyle:{
                            normal:{label:{show:true}},
                            emphasis:{label:{show:true}}
                        },
                        label: {
                            normal: {
                                show: true    //是否显示默认名称
                            },
                            emphasis: {
                                show: true    //鼠标悬浮是否显示默认地理名称
                            }
                        },
                        data:tableData.ydywxnpg
                    },{
                        name: '家庭业务NEI-性能评估值',
                        type: 'map',
                        mapType: '福建',
                        roam:true,
                        mapValueCalculation:'average',
                        itemStyle:{
                            normal:{label:{show:true}},
                            emphasis:{label:{show:true}}
                        },
                        data:tableData.jtywxnpg
                    },{
                        name: '政企业务NEI-性能评估值',
                        type: 'map',
                        mapType: '福建',
                        roam:true,
                        mapValueCalculation:'average',
                        itemStyle:{
                            normal:{label:{show:true}},
                            emphasis:{label:{show:true}}
                        },
                        data:tableData.zqywxnpg
                    },{
                        name: '新业务NEI-性能评估值',
                        type: 'map',
                        mapType: '福建',
                        roam:true,
                        mapValueCalculation:'average',
                        itemStyle:{
                            normal:{label:{show:true}},
                            emphasis:{label:{show:true}}
                        },
                        data:tableData.xywxnpg
                    }

                ]
            };

            // 为echarts对象加载数据
            myChart.setOption(option);

            myChart.on('click', function (params) {

                var city = params.name;
                var titlename1 = params.name+'NEI网络质量评估趋势呈现';
                //alert(titlename1);

                document.getElementById('light').style.display='block';
                document.getElementById('fade').style.display='block';
                $('#light').html("");

                $('#light').html('<a href = "javascript:closewin();" ><img src="../static/img/close2.png" class="colse-puttton"/></a><h4>'+titlename1+'</h4><div id="shengfenzhibiao" style="width: 100%;height:420px;text-color:red;"></div>');


                $.ajax({
                    type:'post',
                    url:urlTemp+"nei/neiproj/getMapLineData",
                    dataType:"json",
                    data:{city:  city},
                    success:function(result){
                        var tableData = eval(result);
                        //趋势图
                        initMapLineData(tableData);
                    }
                });

            });
        }
    );

}


function initMapLineData(tableData) {
    require(
        [
            'echarts',
            'echarts/chart/line' // 使用折线图就加载，按需加载
        ],
        function (ec) {

            var myChart1 = ec.init(document.getElementById('shengfenzhibiao'));

            var option1 = {

                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['总体性能评估值','移动业务NEI','家庭业务NEI','政企业务NEI','新业务NEI']
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : false,
                        data : tableData.xdata
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : tableData.series
            };

            // 为echarts对象加载数据
            myChart1.setOption(option1);
        }
    );
}

function closewin(){
    console.log("aaaaa");
    document.getElementById('light').style.display='none';
    document.getElementById('fade').style.display='none';
}


