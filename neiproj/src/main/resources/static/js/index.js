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
$(function(){
    panduanUrl2();
	   //$("#chartmain").html();
    $.ajax({
        type:'get',
        url:urlTemp+"nei/neiproj/getMapData",
       // url:"/getMapData",

        dataType:"json",
        success:function(result){
            var tableData = eval(result);
            //趋势图
            initMapData(tableData);
        }
    });
	
	  
});

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
                        {start: 90},
                        {start: 70, end: 80},
                        {start: 60, end:70},
                        {start: 50, end: 60},
                        {start: 40, end: 50},
                        {start: 30, end: 40},
                        {start: 20, end: 30},
                        {start: 10, end: 20},
                        {start: 0, end: 10}
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