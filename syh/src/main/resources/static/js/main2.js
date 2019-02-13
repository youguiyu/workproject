
var urlTemp = panduanUrl();
$(function(){
    updateVideoTopData();
    setInterval(updateVideoTopData,600000);

    wlwztgm();
    wlwEchartline();
    initTsty();
    initzuoqiang();
    echart_4();
    initGauge4();


    initEchartBar();

    initZdqy();

});

function initGauge4() {
    $.ajax({
        type:'post',
        url:urlTemp+'syh/wlwproj/getZuoQiangData',
        //url:getRootPath()+'/getZuoQiangData',
        dataType:"json",
        data:{temp:"1"},
        success: function(result) {

            var attach_rate=toDecimal2((result["all"].attachRate));
            var tcp_core_rate=toDecimal2((result["all"].tcpCoreRate));
            var tcp_wx_rate=toDecimal2((result["all"].tcpWxRate));
            var http_rate=toDecimal2((result["all"].httpRate));
            initGauge2(attach_rate,tcp_core_rate,tcp_wx_rate,http_rate);
        }
    });
}
function initZdqy() {
    $.ajax({
        type:'post',
        url:urlTemp+'syh/getVideoZdqyData',
        //url:getRootPath()+'/getZuoYouData',
        dataType:"json",
        success: function(data) {
            var result=eval(data);

            var temp ="<ul>";
            for(var i=0; i<result.length; i++){

               temp+= '<li>'+
                '<div class="page-box222"><h5>'+result[i]["labelCn"]+'&nbsp;-->&nbsp;用户数为:&nbsp;'+result[i]["imsiCnt"]+'人;总流量为:'+((result[i]["totalFlow"])/1024).toFixed(2)+'GB;平均下载速率为:'+(result[i]["avgthrouputdl"]).toFixed(2)+'kbps</h5></div>'+
                '</li>';
            }
            temp=temp+'</ul>';
            console.log(temp)
            $("#crollWarn5").html(temp);

        }
    });

    var that4 = $("#crollWarn5");
    scrollTalble(that4);

}

function initzuoqiang() {
    //做强规模数据
    $.ajax({
        type:'post',
        url:urlTemp+'syh/wlwproj/getZuoYouData',
        //url:getRootPath()+'/getZuoYouData',
        dataType:"json",
        data:{temp:"1"},
        success: function(result) {

            zuoqaingguimo(result);
        }
    });
}
function initTsty() {

    //做大规模数据
    $.ajax({
        type:'post',
        url:urlTemp+'syh/wlwproj/getZuoDaData',
        //url:getRootPath()+'/getZuoDaData',
        dataType:"json",
        data:{temp:"3"},
        success: function(result) {
            initzuoDaty(result);
        }
    });

    //做大规模数据
    $.ajax({
        type:'post',
        url:urlTemp+'syh/wlwproj/getZuoDaData',
        // url:getRootPath()+'/getZuoDaData',
        dataType:"json",
        data:{temp:"4"},
        success: function(result) {

            //initzuodaguimo(result);

            initzuoDats(result);
        }
    });
    
}
function initEchartBar() {
    $.ajax({
        type: "Post",
        url: urlTemp+"syh/getVideoCdData",
        dataType: "json",
        success: function (data) {

            var shijian= data.shijian;

             userEchartdata(data);



        }
    });
}
function  userEchartdata(data){
    var  myChart4 =echarts.init(document.getElementById('jinquMapContent1'));

    myChart4.clear();


    var option = {
        // title : {
        //     text: shijian+'比赛场地分布地点'+temp,
        //     y:'10px',
        //     x:'center',
        //     textStyle : {
        //         color: '#B8860B'
        //     }
        // },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            data:['用户数(人)','流量(MB)','平均下载速率(kpbs)'],
            selectedMode:'single',
            orient:'vertical',
            x:'right',
            y:'center'
        },
        textStyle:{
            color: '#ffff'
        },
        grid: {
            top:'5%',
            left: '5%',
            right: '5%',
            bottom: '5%',
            containLabel: true,
        },
        xAxis: {
            type: 'value',
            position:'top',
            splitLine: {show: false},
            boundaryGap: [0, 0.01],
            axisLabel:{
                textStyle:{
                    color: '#6cbbe6'
                }
            },
        },
        yAxis: {
            type: 'category',
            splitLine: {show: false},
            data: ['福安奥体中心','福安市体育中心','福安一中溪北洋校区','福鼎羽毛球馆','古田翠屏湖水上运动中心','宁德市体育中心','宁德新师院',
                '宁德新五中','屏南县白玉村皮划艇训练基地'
                ,'屏南县一中新校区体育馆','寿宁体育馆','霞浦高罗沙滩','霞浦沙滩排球馆'
                ,'霞浦游泳馆','柘荣县体育中心','周宁县体育馆'],
            axisLabel:{
                textStyle:{
                    fontSize: 12,
                    color: '#6cbbe6'
                }
            },
        },
        series: [
            {
                name: '用户数(人)',
                itemStyle: {
                    normal: {
                        color: function(params) {
                            // build a color map as your need.
                            var colorList = [
                                '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                                '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                                '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                            ];
                            return colorList[params.dataIndex]
                        },
                        shadowBlur: 20,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },
                barWidth:10,
                barGap:20,
                type: 'bar',
                data: data.yhs
                // data: [92,132,142,181,212,28,382,41,92,132,142,181,212,28,382,41,58,33]
            },{
                name: '流量(MB)',
                itemStyle: {
                    normal: {
                        color: function(params) {
                            // build a color map as your need.
                            var colorList = [
                                '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                                '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                                '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                            ];
                            return colorList[params.dataIndex]
                        },
                        shadowBlur: 20,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },
                barWidth:10,
                barGap:20,
                type: 'bar',
                data: data.zlls
                // data: [92,132,142,181,212,28,382,41,92,132,142,181,212,28,382,41,58,33]
            },{
                name: '平均下载速率(kpbs)',
                itemStyle: {
                    normal: {
                        color: function(params) {
                            // build a color map as your need.
                            var colorList = [
                                '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                                '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                                '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                            ];
                            return colorList[params.dataIndex]
                        },
                        shadowBlur: 20,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },
                barWidth:10,
                barGap:20,
                type: 'bar',
                data: data.xzsl
                // data: [92,132,142,181,212,28,382,41,92,132,142,181,212,28,382,41,58,33]
            }
        ]
    };
    myChart4.setOption(option);
}
function echart_4() {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('chart_4'));

    myChart.setOption({
        series: [{
            type: 'map',
            mapType: 'ningde'
        }]
    });

    var geoCoordMap = {
        '福安奥体中心': [119.62826,27.0385],
        '福安市体育中心': [119.635555,27.096111],
        '福安一中溪北洋校区': [119.616528,27.04384],
        '福鼎羽毛球馆': [120.221918,27.340506],
        '古田翠屏湖水上运动中心': [118.791666,26.611944],
        '宁德市体育中心': [119.54614,26.66394],
        '宁德新师院': [119.594493,26.65626],
        '宁德新五中': [119.551865,26.649413],
        '屏南县白玉村皮划艇训练基地': [119.173068,26.911632],
        '屏南县一中新校区体育馆': [119.00177,26.91389],
        '寿宁体育馆': [119.491258,27.471114],
        '霞浦高罗沙滩': [120.091787,26.754275],
        '霞浦沙滩排球馆': [120.022222,26.8775],
        '霞浦游泳馆': [120.020278,26.879444],
        '柘荣县体育中心': [120.020278,27.24027778],
        '周宁县体育馆': [119.303403,27.119143]
    };
    var data=[
        {
            name: '福安奥体中心',
            value: 86
        },
        {
            name: '福安市体育中心',
            value: 86
        },
        {
            name: '福安一中溪北洋校区',
            value: 86
        },
        {
            name: '福鼎羽毛球馆',
            value: 86
        },
        {
            name: '古田翠屏湖水上运动中心',
            value: 86
        },
        {
            name: '宁德市体育中心',
            value: 86
        },
        {
            name: '宁德新师院',
            value: 86
        },
        {
            name: '宁德新五中',
            value: 86
        },
        {
            name: '屏南县白玉村皮划艇训练基地',
            value: 86
        },
        {
            name: '屏南县一中新校区体育馆',
            value: 86
        },
        {
            name: '寿宁体育馆',
            value: 86
        },
        {
            name: '霞浦高罗沙滩',
            value: 86
        },
        {
            name: '霞浦沙滩排球馆',
            value: 86
        },
        {
            name: '霞浦游泳馆',
            value: 86
        },
        {
            name: '柘荣县体育中心',
            value: 86
        },
        {
            name: '周宁县体育馆',
            value: 86
        }
    ];

    var max = 480,
        min = 9; // todo
    var maxSize4Pin = 100,
        minSize4Pin = 20;
    var convertData = function (data) {
        var res = [];
        for (var i = 0; i < data.length; i++) {
            var geoCoord = geoCoordMap[data[i].name];
            if (geoCoord) {
                res.push({
                    name: data[i].name,
                    value: geoCoord.concat(data[i].value)
                });
            }
        }
        return res;
    };

    myChart.setOption(option = {
        title : {
            text: '比赛场地分布地点',
            y:'10px',
            x:'center',
            textStyle : {
                color: '#B8860B'
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: function(params) {
                var res = params.name;
                return res;
            }
        },
        legend: {
            orient: 'vertical',
            y: 'bottom',
            x: 'right',
            data: ['pm2.5'],
            textStyle: {
                color: '#fff'
            }
        },
        visualMap: {
            show: false,
            min: 0,
            max: 500,
            left: 'left',
            top: 'bottom',
            text: ['高', '低'], // 文本，默认为数值文本
            calculable: true,
            seriesIndex: [1],
            inRange: {
            }
        },
        geo: {
            show: true,
            map:'ningde',
            mapType: 'ningde',
            label: {
                normal: {
                },
                //鼠标移入后查看效果
                emphasis: {
                    textStyle: {
                        color: '#fff'
                    }
                }
            },
            //鼠标缩放和平移
            roam: true,
            itemStyle: {
                normal: {
                    //          	color: '#ddd',
                    borderColor: 'rgba(147, 235, 248, 1)',
                    borderWidth: 1,
                    areaColor: {
                        type: 'radial',
                        x: 0.5,
                        y: 0.5,
                        r: 0.8,
                        colorStops: [{
                            offset: 0,
                            color: 'rgba(175,238,238, 0)' // 0% 处的颜色
                        }, {
                            offset: 1,
                            color: 'rgba(	47,79,79, .2)' // 100% 处的颜色
                        }],
                        globalCoord: false // 缺省为 false
                    },
                    shadowColor: 'rgba(128, 217, 248, 1)',
                    shadowOffsetX: -2,
                    shadowOffsetY: 2,
                    shadowBlur: 10
                },
                emphasis: {
                    areaColor: '#389BB7',
                    borderWidth: 0
                }
            }
        },
        series: [{
            name: 'light',
            type: 'map',
            coordinateSystem: 'geo',
            data: convertData(data),
            itemStyle: {
                normal: {
                    color: '#F4E925'
                }
            }
        },
            {
                name: '点',
                type: 'scatter',
                coordinateSystem: 'geo',
                symbol: 'pin',
                symbolSize: function(val) {
                    var a = (maxSize4Pin - minSize4Pin) / (max - min);
                    var b = minSize4Pin - a * min;
                    b = maxSize4Pin - a * max;
                    return (a * val[2] + b);
                },
                label: {
                    normal: {
                        // show: true,
                        // textStyle: {
                        //     color: '#fff',
                        //     fontSize: 9,
                        // }
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#F62157', //标志颜色
                    }
                },
                zlevel: 6,
                data: convertData(data),
            },
            {
                name: 'light',
                type: 'map',
                mapType: 'ningde',
                geoIndex: 0,
                aspectScale: 0.75, //长宽比
                showLegendSymbol: false, // 存在legend时显示
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: false,
                        textStyle: {
                            color: '#fff'
                        }
                    }
                },
                roam: true,
                itemStyle: {
                    normal: {
                        areaColor: '#031525',
                        borderColor: '#FFFFFF',
                    },
                    emphasis: {
                        areaColor: '#2B91B7'
                    }
                },
                animation: false,
                data: data
            },
            {
                name: ' ',
                type: 'effectScatter',
                coordinateSystem: 'geo',
                data: convertData(data.sort(function (a, b) {
                    return b.value - a.value;
                }).slice(0, 5)),
                symbolSize: function (val) {
                    return val[2]/6;
                },
                showEffectOn: 'render',
                rippleEffect: {
                    brushType: 'stroke'
                },
                hoverAnimation: true,
                label: {
                    normal: {
                        formatter: '{b}',
                        position: 'right',
                        show: true
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#05C3F9',
                        shadowBlur: 10,
                        shadowColor: '#05C3F9'
                    }
                },
                zlevel: 1
            },

        ]
    });
}

function wlwEchartline(){
    $.ajax({
        type:'post',
        url:urlTemp+'syh/wlwproj/getZuoDaLineData',
        //url:getRootPath()+'/getZuoDaLineData',
        dataType:"json",
        success: function(result) {

            initEchartTable(result);
        }
    });
}

function initEchartTable(result){
    var myChart = echarts.init(document.getElementById('wlwChartLine'));


    var option = {
        title: {

        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:result[1].legend,
            textStyle:{
                color:'#fff',
                fontSize:10
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {

            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: result[0].xAis,
            axisLabel:{
                textStyle:{
                    color:"#FFFFFF",
                    fontSize:10
                }
            },
            axisLine:{
                lineStyle: {
                    color: '#fff'
                }
            }
        },
        yAxis: {
            type: 'value',
            axisLabel:{
                color:'white'
            }
        },


        series: result[2].yAis
    };

    myChart.setOption(option);

}
function wlwztgm() {
    $.ajax({
        type:'post',
        url:urlTemp+'syh/wlwproj/getZuoDaData',
        //url:getRootPath()+'/getZuoDaData',
        dataType:"json",
        data:{temp:"1"},
        success: function(result) {
            initzuodaguimo(result);
        }
    });
}

function initzuodaguimo(result){


    var htmlText1=

    '<i class="topL"></i>'+
    '<i class="topR"></i>'+
    '<i class="bottomL"></i>'+
    '<i class="bottomR"></i>'+
    '<div class="data-title">'+
    '<b class="data-title-left">[</b>'+
    '<span>物联网总体规模</span>'+
    '<b class="data-title-right">]</b>'+
    ' </div>'+
    '<div class="page-box1">总体情况</div>'+
    '<div class="page-box12" id="page-box11"><div class="page-box22"><h4>物联网:'+result['全省'].apnCnt+'个</h4></div><div class="page-box33">	<h4>用户数:'+(Number(result['全省'].userCnt)/Number(10000)).toFixed(2)+'万</h4></div><div class="page-box44">	<h4>流量:'+(Number(result.全省.flowGb)/Number(1024)).toFixed(2)+'TB</h4></div><div class="page-box55"><h4>XDR数:'+(Number(result.全省.xdrCnt)/Number(100000000)).toFixed(2)+'亿</h4></div></div>'+
   '  <div class="page-box1">各个地市物联网总体情况</div>'+
 ' <div class="page-box13" id="scrollWarn">'+
        '	<ul >'+
        '<li><span class="dishi">福州</span>：物联网'+result["福州"].apnCnt+'个，流量'+(Number(result.福州.flowGb)/Number(1024)).toFixed(2)+'TB，XDR'+(Number(result.福州.xdrCnt)/Number(100000000)).toFixed(2)+'亿条；</li>'+
        '<li><span class="dishi">厦门</span>：物联网'+result.厦门.apnCnt+'个，流量'+(Number(result.厦门.flowGb)/Number(1024)).toFixed(2)+'TB，XDR'+(Number(result.厦门.xdrCnt)/Number(100000000)).toFixed(2)+'亿条；</li>'+
        '<li><span class="dishi">宁德</span>：物联网'+result.宁德.apnCnt+'个，流量'+(Number(result.宁德.flowGb)/Number(1024)).toFixed(2)+'TB，XDR'+(Number(result.宁德.xdrCnt)/Number(100000000)).toFixed(2)+'亿条；</li>'+
        '<li><span class="dishi">莆田</span>：物联网'+result.莆田.apnCnt+'个，流量'+(Number(result.莆田.flowGb)/Number(1024)).toFixed(2)+'TB，XDR'+(Number(result.莆田.xdrCnt)/Number(100000000)).toFixed(2)+'亿条；</li>'+
        '<li><span class="dishi">泉州</span>：物联网'+result.泉州.apnCnt+'个，流量'+(Number(result.泉州.flowGb)/Number(1024)).toFixed(2)+'TB，XDR'+(Number(result.泉州.xdrCnt)/Number(100000000)).toFixed(2)+'亿条；</li>'+
        '<li><span class="dishi">漳州</span>：物联网'+result.漳州.apnCnt+'个，流量'+(Number(result.漳州.flowGb)/Number(1024)).toFixed(2)+'TB，XDR'+(Number(result.漳州.xdrCnt)/Number(100000000)).toFixed(2)+'亿条；</li>'+
        '<li><span class="dishi">龙岩</span>：物联网'+result.龙岩.apnCnt+'个，流量'+(Number(result.龙岩.flowGb)/Number(1024)).toFixed(2)+'TB，XDR'+(Number(result.龙岩.xdrCnt)/Number(100000000)).toFixed(2)+'亿条；</li>'+
        '<li><span class="dishi">三明</span>：物联网'+result.三明.apnCnt+'个，流量'+(Number(result.三明.flowGb)/Number(1024)).toFixed(2)+'TB，XDR'+(Number(result.三明.xdrCnt)/Number(100000000)).toFixed(2)+'亿条；</li>'+
        '<li><span class="dishi">南平</span>：物联网'+result.南平.apnCnt+'个，流量'+(Number(result.南平.flowGb)/Number(1024)).toFixed(2)+'TB，XDR'+(Number(result.南平.xdrCnt)/Number(100000000)).toFixed(2)+'亿条；</li>'+
        '</ul>'+

        '</div>';

    $("#wlwztgm").html(htmlText1);
    var that1 = $("#scrollWarn");
    scrollTalble(that1);

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
function updateVideoTopData() {
    $.ajax({
        type: "Post",
        url: urlTemp+"syh/getVideoTopData",
        dataType: "json",
        success: function (data) {
            var userTop= data.userTop;
            var flowTop=data.flowTop;
            var waitTop=data.waitTop;
            var temp="";
            for(var i=0; i<userTop.length;i++){
                temp +='<tr>'+
                    '<td>'+userTop[i].labelCn+'用户数为：'+userTop[i].imsiCntSum+'人</td>'+
                    '<td>'+flowTop[i].labelCn+'流量为：'+(flowTop[i].totalFlowSum/1024).toFixed(2)+'GB</td>'+
                    '<td>'+waitTop[i].labelCn+'延时为：'+waitTop[i].waittime+'ms</td>'+
                    '</tr>'
            }

            $("#tbContent1").html(temp);



        }
    });
}


function initzuoDats(result) {

    var htmlText3=
        '<ul >'+
        '<li class="jiacu">'+result['福建省公共交通（FJMYGJ.FJ）'].apn+':</li>'+
        '<li>用户'+(result['福建省公共交通（FJMYGJ.FJ）'].userCnt/10000).toFixed(2)+'万个；流量'+(result['福建省公共交通（FJMYGJ.FJ）'].flowGb).toFixed(2)+'GB；XDR'+(result['福建省公共交通（FJMYGJ.FJ）'].xdrCnt/10000).toFixed(2)+'万条；涉及全省九地市。</li>'+


        '<li ></li>'+
        '<li class="jiacu">'+result['福建省公安（FJGA.FJ）'].apn+'：</li>'+
        '<li>用户'+(result['福建省公安（FJGA.FJ）'].userCnt/10000).toFixed(2)+'万个；流量'+(result['福建省公安（FJGA.FJ）'].flowGb).toFixed(2)+'GB；XDR'+(result['福建省公安（FJGA.FJ）'].xdrCnt/10000).toFixed(2)+'万条；涉及全省九地市。</li>'+

        '<li ></li>'+
        '<li  class="jiacu">福建水文局（FJSWGPRS.FJ）</li>'+
        '<li>用户'+(result['福建省水文局（FJSWGPRS.FJ）'].userCnt/10000).toFixed(2)+'万个；流量'+(result['福建省水文局（FJSWGPRS.FJ）'].flowGb).toFixed(2)+'GB；XDR'+(result['福建省水文局（FJSWGPRS.FJ）'].xdrCnt/10000).toFixed(2)+'万条；涉及全省九地市。</li>'+


        '<li ></li>'+
        '<li  class="jiacu">福建银联（FJYL.FJ）：</li>'+
        '<li>用户'+(result['福建省银联（FJYL.FJ）'].userCnt/10000).toFixed(2)+'万个；流量'+(result['福建省银联（FJYL.FJ）'].flowGb).toFixed(2)+'GB；XDR'+(result['福建省银联（FJYL.FJ）'].xdrCnt/10000).toFixed(2)+'万条；涉及全省九地市。</li>'+
        '<li ></li>'+
        '<li  class="jiacu">福建省电力（FJEP.FJ）：</li>'+
        '<li>用户'+(result['福建省电力（FJEP.FJ）'].userCnt/10000).toFixed(2)+'万个；流量'+(result['福建省电力（FJEP.FJ）'].flowGb).toFixed(2)+'GB；XDR'+(result['福建省电力（FJEP.FJ）'].xdrCnt/10000).toFixed(2)+'万条；涉及全省九地市。</li>'+


        '<li ></li>'+
        '</ul>';


    $("#scrollWarn2").html(htmlText3);

    //触发滚动


    var that3 = $("#scrollWarn2");
    scrollTalble(that3);

}
function initzuoDaty(result) {

    var htmlText2= '<ul >'+
        '<li class="jiacu">福建省CMIOT:</li>'+
        '<li>用户数'+(result['CMIOT'].userCnt/10000).toFixed(2)+'万个；流量'+(result['CMIOT'].flowGb).toFixed(2)+'GB；XDR'+(result['CMIOT'].xdrCnt/10000).toFixed(2)+'万条；涉及全省九地市。</li>'+

        '<li ></li>'+
        '<li class="jiacu">福建省车联网：</li>'+
        '<li>用户数'+(result['车联网'].userCnt/10000).toFixed(2)+'万个；流量'+(result['车联网'].flowGb).toFixed(2)+'GB；XDR'+(result['车联网'].xdrCnt/10000).toFixed(2)+'万条；涉及全省九地市。</li>'+


        '<li ></li>'+
        '<li  class="jiacu">国家充电桩</li>'+
        '<li>用户数'+(result['充电桩'].userCnt/10000).toFixed(2)+'万个；流量'+(result['充电桩'].flowGb).toFixed(2)+'GB；XDR'+(result['充电桩'].xdrCnt/10000).toFixed(2)+'万条；涉及全省九地市。</li>'+

        '<li ></li>'+
        '<li  class="jiacu">公共交通</li>'+
        '<li>用户数'+(result['公共交通'].userCnt/10000).toFixed(2)+'万个；流量'+(result['公共交通'].flowGb).toFixed(2)+'GB；XDR'+(result['公共交通'].xdrCnt/10000).toFixed(2)+'万条；涉及全省九地市。</li>'+

        '<li ></li>'+
        '<li  class="jiacu">公安</li>'+
        '<li>用户数'+(result['公安'].userCnt/10000)+'万个；流量'+(result['公安'].flowGb).toFixed(2)+'GB；XDR'+(result['公安'].xdrCnt/10000).toFixed(2)+'万条；涉及全省九地市。</li>'+

        '<li ></li>'+
        '<li  class="jiacu">水务</li>'+
        '<li>用户数'+(result['水务'].userCnt/10000).toFixed(2)+'万个；流量'+(result['水务'].flowGb).toFixed(2)+'GB；XDR'+(result['水务'].xdrCnt/10000).toFixed(2)+'万条；涉及全省九地市。</li>'+

        '<li ></li>'+
        '<li  class="jiacu">电力</li>'+
        '<li>用户数'+(result['电力'].userCnt/10000).toFixed(2)+'万个；流量'+(result['电力'].flowGb).toFixed(2)+'GB；XDR'+(result['电力'].xdrCnt/10000).toFixed(2)+'万条；涉及全省九地市。</li>'+

        '<li ></li>'+
        '<li  class="jiacu">路灯</li>'+
        '<li>用户数'+(result['路灯'].userCnt/10000).toFixed(2)+'万个；流量'+(result['路灯'].flowGb).toFixed(2)+'GB；XDR'+(result['路灯'].xdrCnt/10000).toFixed(2)+'万条；涉及全省九地市。</li>'+
        '<li ></li>'+
        '<li  class="jiacu">银行</li>'+
        '<li>用户数'+(result['银行'].userCnt/10000).toFixed(2)+'万个；流量'+(result['银行'].flowGb).toFixed(2)+'GB；XDR'+(result['银行'].xdrCnt/10000).toFixed(2)+'万条；涉及全省九地市。</li>'+


        '<li ></li>'+
        '<li  class="jiacu">共享单车（摩拜）：</li>'+
        '<li>日活跃单车（卡）4.52万；解锁次数13.24万次；涉及福州、厦门、泉州、漳州、龙岩等五地市。</li>'+

        '<li ></li>'+
        '</ul>';

    //$("#pageLeft").html(htmlText1);
    $("#scrollWarn1").html(htmlText2);

    var that2 = $("#scrollWarn1");
    scrollTalble(that2);

}


function  zuoqaingguimo(result) {

    var htmlText =
        '<div  class="page-box12" id="page-box11">'+
        '<div class="page-box22">'+
        '<h4>信息交互:'+result["guimo"][0].apnCnt+'个</h4>'+
        '</div>'+
        '<div class="page-box33">'+
        '	<h4>固定上报:'+result["guimo"][1].apnCnt+'个</h4>'+
        '</div>'+
        '<div class="page-box44">'+
        '	<h4>下载型:'+result["guimo"][2].apnCnt+'个</h4>'+
        '</div>'+
        '<div class="page-box55">'+
        '<h4>GRE隧道:'+result["guimo"][3].apnCnt+'个</h4>'+
        '</div>'+
        '</div>'+
        '<div class="page-box1">APN业务量占比呈现</div> '+
        ' <div  class="page-box13" id="page-box11">'+
        '<div id="gauge1"></div>'+
        '<div id="gauge2"></div>'+
        '<div id="gauge3"></div>'+
        '<div id="gauge-text">'+
        '	<h5>业务量占比最大的APN为通用CMIOT</h5>'+
        '</div>'+
        '</div>';

    $("#pageLeft").html(htmlText);

    //做强规模数据
    $.ajax({
        type:'post',
        url:urlTemp+'syh/wlwproj/getZuoYouData',
        //url:getRootPath()+'/getZuoYouData',
        dataType:"json",
        data:{temp:"2"},
        success: function(result) {

            initGauge(result);
        }
    });

    var that5 = $(".page-box14");
    scrollTalble(that5);
}

function initGauge2(attach_rate,tcp_core_rate,tcp_wx_rate,http_rate){
    //开始guage 第一个
    // 基于准备好的dom，初始化echarts图表
    var myChart1 = echarts.init(document.getElementById('gauge4'));

    var option1 = {
        title:{
            show:true,
            text:'附着成功率',
            textStyle:{
                color:'#fff',
                fontSize:12,
                align:'right'

            },
            right:65
        },
        tooltip : {
            formatter: "{a} <br/>{b} : {c}%"
        },

        series: [
            {
                name: '附着成功率',
                type: 'gauge',

                radius:'80%',
                splitNumber:4,
                itemStyle:{color:'#ffffff'},
                axisLine:{
                    show:true,
                    lineStyle:{
                        width:10
                    }
                },
                title:{
                    show:true
                },
                axisLabel:{
                    fontSize:5,
                    color:'#ffffff',
                },
                splitLine:{
                    show:true,
                    length:2,
                    lineStyle:{
                        color:'#ffffff',
                        width:2
                    }

                },
                detail: {
                    formatter:'{value}%',
                    color:'white',
                    fontSize:10
                },
                data: [{
                    value: attach_rate
                }
                ]
            }
        ]
    };


    // 为echarts对象加载数据
    myChart1.setOption(option1);

    //结束


    var myChart2 = echarts.init(document.getElementById('gauge5'));

    var option2 = {
        title:{
            show:true,
            text:'TCP核心建立成功率',
            textStyle:{
                color:'#ffffff',
                fontSize:12,
                align:'center'
            },
            left:50,

        },
        tooltip : {
            formatter: "{a} <br/>{b} : {c}%"
        },

        series: [
            {
                name: 'TCP核心建立成功率',
                type: 'gauge',

                radius:'80%',
                splitNumber:4,
                itemStyle:{color:'#ffffff'},
                axisLine:{
                    show:true,
                    lineStyle:{
                        width:10
                    }
                },
                title:{
                    show:true
                },
                axisLabel:{
                    fontSize:8,
                    color:'#ffffff',
                },
                splitLine:{
                    show:true,
                    length:2,
                    lineStyle:{
                        color:'#ffffff',
                        width:2
                    }

                },
                detail: {
                    formatter:'{value}%',
                    color:'white',
                    fontSize:10
                },
                data: [{value: tcp_core_rate}]
            }
        ]
    };


    // 为echarts对象加载数据
    myChart2.setOption(option2);




    var myChart3 = echarts.init(document.getElementById('gauge6'));

    var option3 = {
        title:{
            show:true,
            text:'TCP无线建立成功率',
            textStyle:{
                color:'#ffffff',
                fontSize:12,
                align:'center'
            },
            left:48
        },
        tooltip : {
            formatter: "{a} <br/>{b} : {c}%"
        },

        series: [
            {
                name: 'TCP无线建立成功率',
                type: 'gauge',

                radius:'80%',
                splitNumber:4,
                itemStyle:{color:'#ffffff'},
                axisLine:{
                    show:true,
                    lineStyle:{
                        width:10
                    }
                },
                title:{
                    show:true
                },
                axisLabel:{
                    fontSize:8,
                    color:'#ffffff',
                },
                splitLine:{
                    show:true,
                    length:2,
                    lineStyle:{
                        color:'#ffffff',
                        width:2
                    }

                },
                detail: {
                    formatter:'{value}%',
                    color:'white',
                    fontSize:10
                },
                data: [{value: tcp_wx_rate}]
            }
        ]
    };


    // 为echarts对象加载数据
    myChart3.setOption(option3);

    var myChart4 = echarts.init(document.getElementById('gauge7'));

    var option4 = {
        title:{
            show:true,
            text:'HTTP成功率',
            textStyle:{
                color:'#ffffff',
                fontSize:12,
                align:'right'
            },
            right:65
        },
        tooltip : {
            formatter: "{a} <br/>{b} : {c}%"
        },

        series: [
            {
                name: 'HTTP成功率',
                type: 'gauge',

                radius:'80%',
                splitNumber:4,
                itemStyle:{color:'#ffffff'},
                axisLine:{
                    show:true,
                    lineStyle:{
                        width:10
                    }
                },
                title:{
                    show:true
                },
                axisLabel:{
                    fontSize:8,
                    color:'#ffffff',
                },
                splitLine:{
                    show:true,
                    length:2,
                    lineStyle:{
                        color:'#ffffff',
                        width:2
                    }

                },
                detail: {
                    formatter:'{value}%',
                    color:'white',
                    fontSize:10
                },
                data: [{value: http_rate}]
            }
        ]
    };


    // 为echarts对象加载数据
    myChart4.setOption(option4);

}

function initGauge(result){
    var userRate= toDecimal2(result.userRate);
    var xdrRate = toDecimal2(result.xdrRate);
    var flowRate = toDecimal2(result.flowRate);


    //开始guage 第一个
    // 基于准备好的dom，初始化echarts图表
    var myChart1 = echarts.init(document.getElementById('gauge1'));

    var option1 = {
        title:{
            show:true,
            text:'XDR占比',
            textStyle:{
                color:'#fff',
                fontSize:12,
                align:'center'
            },
            right:40
        },
        tooltip : {
            formatter: "{a} <br/>{b} : {c}%"
        },

        series: [
            {
                name: 'XDR占比',
                type: 'gauge',

                radius:'80%',
                splitNumber:4,
                itemStyle:{color:'#ffffff'},
                axisLine:{
                    show:true,
                    lineStyle:{
                        width:10
                    }
                },
                title:{
                    show:true
                },
                axisLabel:{
                    fontSize:5,
                    color:'#ffffff',
                },
                splitLine:{
                    show:true,
                    length:2,
                    lineStyle:{
                        color:'#ffffff',
                        width:2
                    }

                },
                detail: {
                    formatter:'{value}%',
                    color:'white',
                    fontSize:10
                },
                data: [{value: xdrRate}]
            }
        ]
    };


    // 为echarts对象加载数据
    myChart1.setOption(option1);

    //结束


    var myChart2 = echarts.init(document.getElementById('gauge2'));

    var option2 = {
        title:{
            show:true,
            text:'用户占比',
            textStyle:{
                color:'#ffffff',
                fontSize:12,
                align:'center'
            },
            right:40
        },
        tooltip : {
            formatter: "{a} <br/>{b} : {c}%"
        },

        series: [
            {
                name: '用户占比',
                type: 'gauge',

                radius:'80%',
                splitNumber:4,
                itemStyle:{color:'#ffffff'},
                axisLine:{
                    show:true,
                    lineStyle:{
                        width:10
                    }
                },
                title:{
                    show:true
                },
                axisLabel:{
                    fontSize:8,
                    color:'#ffffff',
                },
                splitLine:{
                    show:true,
                    length:2,
                    lineStyle:{
                        color:'#ffffff',
                        width:2
                    }

                },
                detail: {
                    formatter:'{value}%',
                    color:'white',
                    fontSize:10
                },
                data: [{value: userRate}]
            }
        ]
    };


    // 为echarts对象加载数据
    myChart2.setOption(option2);




    var myChart3 = echarts.init(document.getElementById('gauge3'));

    var option3 = {
        title:{
            show:true,
            text:'流量占比',
            textStyle:{
                color:'#fff',
                fontSize:12,
                align:'center'
            },
            right:40
        },
        tooltip : {
            formatter: "{a} <br/>{b} : {c}%"
        },

        series: [
            {
                name: '流量占比',
                type: 'gauge',

                radius:'80%',
                splitNumber:4,
                itemStyle:{color:'#ffffff'},
                axisLine:{
                    show:true,
                    lineStyle:{
                        width:10
                    }
                },
                title:{
                    show:true
                },
                axisLabel:{
                    fontSize:8,
                    color:'#ffffff',
                },
                splitLine:{
                    show:true,
                    length:2,
                    lineStyle:{
                        color:'#ffffff',
                        width:2
                    }

                },
                detail: {
                    formatter:'{value}%',
                    color:'white',
                    fontSize:10
                },
                data: [{value: flowRate}]
            }
        ]
    };


    // 为echarts对象加载数据
    myChart3.setOption(option3);
}
function toDecimal2(x){
    var f = parseFloat(x);
    if(isNaN(f)){
        return;
    }
    if(x<1){
        f=Number(x*100).toFixed(2);
        return f;
    }
    f=Math.round(x*100)/100;
    return f;
}
function sildTap111(){
    //http://10.48.190.202:8010/renliu_nd_pt/gis_renliu.aspx
    window.location.href=urlTemp+"syh/toIndex";
}

function panduanUrl(){
    var baseUrl = window.location.href;
    if(baseUrl.indexOf("jksdev_190_206_8080")>=0){
        return "/jksdev_190_206_8080/";
    }else {
        return "/";
    }
}