
var urlTemp =panduanUrl();
$(function(){
    //初始化全国漫游到宁德人流量地图
    initChinaToNdMap();
    //初始化全省漫游到宁德人流量地图
    initProvinceToNdMap();
    //10分钟刷新全国漫游到宁德人流量地图
    setInterval(initChinaToNdMap,600000);
    //10分钟刷新全省漫游到宁德人流量地图
    setInterval(initProvinceToNdMap,600000);


    initEchart_5();
    setInterval(initEchart_5,600000);


    echart_4();
    initloadoOption4();

    setInterval(initloadoOption4,600000);

    initechart_6();
    setInterval(initechart_6,600000);

    initechart_7();
    setInterval(initechart_7,600000);

    updateDaytime();
    setInterval(updateDaytime,600000);

    updateTopData();
    setInterval(updateTopData,600000);
    //获取当前时间，并在页面中显示
    var timer = setInterval(function () {
        var date = new Date();
        var year = date.getFullYear(); //当前年份
        var month = date.getMonth(); //当前月份
        var data = date.getDate(); //天
        var hours = date.getHours(); //小时
        var minute = date.getMinutes(); //分
        var second = date.getSeconds(); //秒
        var day = date.getDay(); //获取当前星期几
        var ampm = hours < 12 ? 'am' : 'pm';
        $('#time').html(fnW(hours) + ":" + fnW(minute) + ":" + fnW(second));
        $('#date').html('<span>' + year + '/' + (month + 1) + '/' + data + '</span><span>' + ampm + '</span><span>周' + day + '</span>')

    }, 1000)
});
function  updateDaytime() {
    var date = new Date();
    var year = date.getFullYear(); //当前年份
    var month = date.getMonth()+1; //当前月份
    var day = date.getDate(); //天

    if(day==16&&month==10){
        $("#time1").html("倒计时：3天");
    }else if(day==17&&month==10){
        $("#time1").html("倒计时：2天");
    }else if(day==18&&month==10){
        $("#time1").html("倒计时：1天");
    }else if(day==19&&month==10){
        $("#time1").html("保障：第1天");
    }else if(day==20&&month==10){
        $("#time1").html("保障：第2天");
    }else if(day==21&&month==10){
        $("#time1").html("保障：第3天");
    }else if(day==22&&month==10){
        $("#time1").html("保障：第4天");
    }else if(day==23&&month==10){
        $("#time1").html("保障：第5天");
    }else if(day==24&&month==10){
        $("#time1").html("保障：第6天");
    }else if(day==25&&month==10){
        $("#time1").html("保障：第7天");
    }else if(day==26&&month==10){
        $("#time1").html("保障：第8天");
    }else if(day==27&&month==10){
        $("#time1").html("保障：第9天");
    }else if(day==28&&month==10){
        $("#time1").html("保障：第10天");
    }else if(day==29&&month==10){
        $("#time1").html("保障：第11天");
    }else if(day==30&&month==10){
        $("#time1").html("保障：第12天");
    }else if(day==31&&month==10){
        $("#time1").html("保障：第13天");
    }
}
function updateTopData() {
    $.ajax({
        type: "Post",
        url: urlTemp+"syh/getTopData",
        dataType: "json",
        success: function (data) {
            var topdata= data.top;
            var lowdata=data.low;
            var temp="";
            for(var i=0; i<topdata.length;i++){
                 temp +='<tr>'+
                       '<td>'+topdata[i].cellName+'用户数为：'+topdata[i].countNum+'人</td>'+
                       '<td>'+lowdata[i].cellName+'用户数为：'+lowdata[i].countNum+'人</td>'+
                     '</tr>'
            }

            $("#tbContent").html(temp);



        }
    });
}
function initechart_7() {
    $.ajax({
        type: "Post",
        url: urlTemp+"syh/getZdData",
        dataType: "json",
        success: function (data) {
            var res =eval(data);
            var resultHtml ='<li><b class="litext" >汽车北站:当前时间段2g用户数:'+res[0].bz2g+'人,4g用户数'+res[0].bz4g+'人</b><span class="r">总人流量：'+(parseInt(res[0].bz2g)+parseInt(res[0].bz4g))+'人次</span></li>'+
                         '<li><b class="litext" >汽车南站:当前时间段2g用户数:'+res[1].nz2g+'人,4g用户数'+res[1].nz4g+'人</b><span class="r">总人流量：'+(parseInt(res[1].nz2g)+parseInt(res[1].nz4g))+'人次</span></li>'+
                         '<li><b class="litext" >宁德火车站:当前时间段2g用户数:'+res[2].ndz2g+'人,4g用户数'+res[2].ndz4g+'人</b><span class="r">总人流量：'+(parseInt(res[2].ndz2g)+parseInt(res[2].ndz4g))+'人次</span></li>'+
                         '<li><b class="litext" >宝信广场:当前时间段2g用户数:'+res[3].bx2g+'人,4g用户数'+res[3].bx4g+'人</b><span class="r">总人流量：'+(parseInt(res[3].bx2g)+parseInt(res[3].bx4g))+'人次</span></li>'+
                         '<li><b class="litext" >万达广场:当前时间段2g用户数:'+res[4].wd2g+'人,4g用户数'+res[4].wd4g+'人</b><span class="r">总人流量：'+(parseInt(res[4].wd2g)+parseInt(res[4].wd4g))+'人次</span></li>';

            $("#ulContent").html(resultHtml);



        }
    });
}
function initechart_6() {
    $.ajax({
        type: "Post",
        url: urlTemp+"syh/getBisaichangdiData",
        dataType: "json",
        success: function (data) {
            var res =eval(data);
            echart_6(res);

        }
    });
}
function initloadoOption4() {
    $.ajax({
        type: "Post",
        url: urlTemp+"syh/getJiudianData",
        dataType: "json",
        success: function (data) {
            var res =eval(data);
            loadoOption4(res);

        }
    });
}
//初始化风景区地图
function initEchart_5() {
    $.ajax({
        type: "Post",
        url: urlTemp+"syh/getFengjinquData",
        dataType: "json",
        success: function (data) {
           var res =eval(data);
           echart_5(res);

           tms(res);
        }
    });
}

//切换成人流量多边形图
function sildTap1(){
	//http://10.48.190.202:8010/renliu_nd_pt/gis_renliu.aspx
	var temp ='<a id="switch_btn"  href="javascript:sildTap2();"></a><iframe class="iframecss" src="http://10.48.190.202:8010/renliu_nd_pt/gis_renliu.aspx" frameborder="no" border="0" marginwidth="0" marginheight="0" allowtransparency="true" scrolling="no"  width="94%" height="99%"></iframe>';
	$("#centerTop").html(temp);
}

function sildTap11(){
	//http://10.48.190.202:8010/renliu_nd_pt/gis_renliu.aspx
    window.location.href=urlTemp+"syh/toIndex2";
}

//切换成人流量漫游图
function sildTap2(){
	
	var temp ='<a id="switch_btn"  href="javascript:sildTap1();"></a><div id="chartChina"></div><div id="chartMap"></div>';
	$("#centerTop").html(temp);

    initChinaToNdMap();
    initProvinceToNdMap();
}

//处理时间方法
function fnW(str) {
    var num;
    str >= 10 ? num = str : num = "0" + str;
    return num;
}
//请求全国漫游到宁德人流量地图的原始数据
function initChinaToNdMap(){
    $.ajax({
        type: "Post",
        url: urlTemp+"syh/getChinaToNdMap",
        dataType: "json",
        success: function (data) {
            var item=[];
            var data1=data["4g"];
            var data2=data["2g"];
            var data3=data["nowtime"];
            var totalNum2g =0;
            var totalNum4g =0;
            for (var i=0; i<data1.length; i++) {
                var y = [];
                var item1 = {};
                item1.name = data1[i].userProvince;
                var item2 = {};
                item2.name = data1[i].cityName;
                item2.value = data1[i].userCount;
                y.push(item1);
                y.push(item2);
                item.push(y);
                if(data1[i].userCity!='宁德'){
                    totalNum4g=totalNum4g+parseInt(data1[i].userCount);
                }

            }
            var itemt=[];
            for (var i=0; i<data1.length; i++) {

                var y = [];
                var item1 = {};
                item1.name = data2[i].userProvince;
                var item2 = {};
                item2.name = data2[i].cityName;
                item2.value = data2[i].userCount;
                y.push(item1);
                y.push(item2);
                itemt.push(y);
                if(data2[i].userCity!='宁德'){
                    totalNum2g=totalNum2g+parseInt(data2[i].userCount);
                }

            }

            $("#renliuq").text("全国->宁德："+((totalNum2g+totalNum4g)/10000).toFixed(2)+"万人");
            echart_map1(item,itemt,data3,totalNum2g,totalNum4g)

        }

    });
}
//请求全省漫游到宁德人流量地图的原始数据
function initProvinceToNdMap(){
    $.ajax({
        type: "Post",
        url: urlTemp+"syh/getProvToNdMap",
        dataType: "json",
        success: function (data) {
            var item=[];
            var data1=data["4g"];
            var data2=data["2g"];
            var data3=data["nowtime"];
            var totalNum2g =0;
            var totalNum4g =0;
            for (var i=0; i<data1.length; i++) {

                var y = [];
                var item1 = {};
                item1.name = data1[i].userCity;
                var item2 = {};
                item2.name = data1[i].cityName;
                item2.value = data1[i].userCount;
                y.push(item1);
                y.push(item2);
                item.push(y);
                if(data1[i].userCity!='宁德'){
                    totalNum4g=totalNum4g+parseInt(data1[i].userCount);
                }
            }
            var itemt=[];
            for (var i=0; i<data1.length; i++) {

                var y = [];
                var item1 = {};
                item1.name = data2[i].userCity;
                var item2 = {};
                item2.name = data2[i].cityName;
                item2.value = data2[i].userCount;
                y.push(item1);
                y.push(item2);
                itemt.push(y);
                if(data1[i].userCity!='宁德'){
                    totalNum2g=totalNum2g+parseInt(data2[i].userCount);

                }



            }
            //console.log(item);
            $("#renlius").text("全省->宁德："+((totalNum2g+totalNum4g)/10000).toFixed(2)+"万人");
            echart_map(item,itemt,data3,totalNum2g,totalNum4g);

        }

    });
}

//初始化全国漫游到宁德人流量地图
function echart_map1(item,itemt,data3,totalNum2g,totalNum4g) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('chartChina'));

    var mapName = 'china'
    var data = []
    var toolTipData = [];

    /*获取地图数据*/
    myChart.showLoading();
    var mapFeatures = echarts.getMap(mapName).geoJson.features;
    myChart.hideLoading();
    var geoCoordMap = {
        "广西": [108.320004, 22.82402],
        "内蒙古": [111.670801, 40.818311],
        "河北": [114.502461, 38.045474],
        "山西": [112.549248, 37.857014],
        "澳门": [113.54909, 22.198951],
        "香港": [114.173355, 22.320048],
        "天津": [117.190182, 39.125596],
        "新疆": [87.617733, 43.792818],
        "宁夏": [106.278179, 38.46637],
        "青海": [101.778916, 36.623178],
        "甘肃": [103.823557, 36.058039],
        "西藏": [91.132212, 29.660361],
        "云南": [102.712251, 25.040609],
        "贵州": [106.713478, 26.578343],
        "广东": [113.280637, 23.125178],
        "湖北": [114.298572, 30.584355],
        "河南": [113.665412, 34.757975],
        "江西": [115.892151, 28.676493],
        "安徽": [117.283042, 31.86119],
        "浙江": [120.153576, 30.287459],
        "江苏": [118.767413, 32.041544],
        "黑龙江": [126.642464, 45.756967],
        "辽宁": [123.429096, 41.796767],
        "台湾": [121.509062, 25.044332],
        "山东": [117.000923, 36.675807],
        '吉林': [125.8154, 44.2584],
        '重庆': [107.7539, 30.1904],
        '陕西': [109.1162, 34.2004],
        '四川': [103.9526, 30.7617],
        '北京': [116.4551, 40.2539],
        '海南': [110.3893, 19.8516],
        '湖南': [113.019455, 28.200103],
        '上海': [121.40, 31.73],
        '内蒙古': [106.82, 39.67],
        '宁德': [119.518318, 26.666477],
        "福建": [119.306239, 26.075302]

    };
    var convertData = function (data) {
        var res = [];
        for (var i = 0; i < data.length; i++) {
            var dataItem = data[i];
            var fromCoord = geoCoordMap[dataItem[0].name];
            var toCoord = geoCoordMap[dataItem[1].name];
            if (fromCoord && toCoord) {
                res.push({
                    fromName: dataItem[0].name,
                    toName: dataItem[1].name,
                    value: dataItem[1].value,
                    coords: [fromCoord, toCoord]
                });
            }
        }
        return res;
    };

    var color = ['#c5f80e'];
    var series = [];

    [
        ['2G', itemt]
    ].forEach(function (item, i) {
        series.push({
                name: item[0],
                type: 'lines',
                zlevel: 2,
                symbol: ['none', 'arrow'],
                symbolSize: 10,
                effect: {
                    show: true,
                    period: 6,
                    trailLength: 0,
                    symbol: 'arrow',
                    symbolSize: 5
                },
                lineStyle: {
                    normal: {
                        color: color[i],
                        width: 1,
                        opacity: 0.6,
                        curveness: 0.2
                    }
                },
                data: convertData(item[1])
            }, {
                name: item[0],
                type: 'effectScatter',
                coordinateSystem: 'geo',
                zlevel: 2,
                rippleEffect: {
                    brushType: 'stroke'
                },
                label: {
                    normal: {
                        show: true,
                        position: 'right',
                        formatter: '{b}'
                    }
                },
                symbolSize: function (val) {
                    return val[2] / 4000;
                },
                itemStyle: {
                    normal: {
                        color: color[i]
                    }
                },
                data: item[1].map(function (dataItem) {

                    return {
                        name: dataItem[0].name,
                        value: geoCoordMap[dataItem[0].name].concat([dataItem[1].value])
                    };
                })
            },
            {
                name: '点',
                type: 'scatter',
                coordinateSystem: 'geo',
                symbol: 'pin',
                symbolSize: function (val) {
                    var a = (maxSize4Pin - minSize4Pin) / (max - min);
                    var b = minSize4Pin - a * min;
                    b = maxSize4Pin - a * max;
                    return a * val[2] + b;
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
            });
    });
    [
        ['4G', item]
    ].forEach(function (item, i) {


        series.push({
                name: item[0],
                type: 'lines',
                zlevel: 2,
                symbol: ['none', 'arrow'],
                symbolSize: 10,
                effect: {
                    show: true,
                    period: 6,
                    trailLength: 0,
                    symbol: 'arrow',
                    symbolSize: 5
                },
                lineStyle: {
                    normal: {
                        color: color[i],
                        width: 1,
                        opacity: 0.6,
                        curveness: 0.2
                    }
                },
                data: convertData(item[1])
            }, {
                name: item[0],
                type: 'effectScatter',
                coordinateSystem: 'geo',
                zlevel: 2,
                rippleEffect: {
                    brushType: 'stroke'
                },
                label: {
                    normal: {
                        show: true,
                        position: 'right',
                        formatter: '{b}'
                    }
                },
                symbolSize: function (val) {
                    return val[2] / 4000;
                },
                itemStyle: {
                    normal: {
                        color: color[i]
                    }
                },
                data: item[1].map(function (dataItem) {

                    return {
                        name: dataItem[0].name,
                        value: geoCoordMap[dataItem[0].name].concat([dataItem[1].value])
                    };
                })
            },
            {
                name: '点',
                type: 'scatter',
                coordinateSystem: 'geo',
                symbol: 'pin',
                symbolSize: function (val) {
                    var a = (maxSize4Pin - minSize4Pin) / (max - min);
                    var b = minSize4Pin - a * min;
                    b = maxSize4Pin - a * max;
                    return a * val[2] + b;
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
            });
    });

    option = {
        title : {
            text: data3+':全国省会城市到宁德市人流量统计',
            subtext: '2G的人流总量：'+totalNum2g+'人次，4G的人流总量：'+totalNum4g+'人次',
            x:'center',
            y:'20px',
            textStyle : {
                color: '#B8860B'
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: function (param) {//提示信息格式化
                //alert(JSON.stringify(param));
                if (param.componentSubType == "lines")
                    return "<b>" + param.data.fromName + ">" + param.data.toName + ": " + param.data.value;
                else if (param.componentSubType == "effectScatter")
                    return "<b>" + param.data.name + ": " + param.data.value[2];

            }
         },
        // toolbox: {
        //     show : true,
        //     feature : {
        //         dataZoom : {show: true},
        //         dataView : {show: true, readOnly: false},
        //         restore : {show: true},
        //         saveAsImage : {show: true}
        //     }
        // },
        legend: {
            orient: 'vertical',
            x:'left',
            y: 'center',
            data:['2G', '4G'],
            selectedMode: 'single',
            selected:{
                '4G' : false
            },
            textStyle : {
                color: '#fff'
            }
        },
        dataRange: {
            min : 0,
            max : 10000,
            calculable : true,
            color: ['#ff3333', 'orange', 'yellow','lime','aqua'],
            textStyle:{
                color:'#fff'
            }
        },
        geo: {
            map: 'china',
            label: {
                emphasis: {
                    show: false
                }
            },
            roam: true,
            itemStyle: {
                normal: {
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
                            color: 'rgba(47,79,79, .1)' // 100% 处的颜色
                        }],
                        globalCoord: false // 缺省为 false
                    },
                    shadowColor: 'rgba(128, 217, 248, 1)',
                    // shadowColor: 'rgba(255, 255, 255, 1)',
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
        series: series
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    window.addEventListener("resize", function () {
        myChart.resize();
    });

}


//初始化全省漫游到宁德人流量地图
function echart_map(item,itemt,data3,totalNum2g,totalNum4g) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('chartMap'));

    var mapName = 'fujian'
    var data = []
    var toolTipData = [];

    /*获取地图数据*/
    myChart.showLoading();
    var mapFeatures = echarts.getMap(mapName).geoJson.features;
    myChart.hideLoading();
    var geoCoordMap = {
        '福州': [119.297813, 26.0785903],
        '厦门': [118.087516, 24.4574356],
        '宁德': [119.518318, 26.666477],
        '泉州': [118.5896378, 24.91591835],
        '莆田': [119.0103226, 25.43813705],
        '漳州': [117.6530914, 24.51816368],
        '三明': [117.6012268, 26.22301292],
        '龙岩': [117.0303879, 25.10970306],
        '南平': [118.1691208, 26.64484215]
    };



    var convertData = function (data) {
        var res = [];
        for (var i = 0; i < data.length; i++) {
            var dataItem = data[i];
            var fromCoord = geoCoordMap[dataItem[0].name];
            var toCoord = geoCoordMap[dataItem[1].name];
            if (fromCoord && toCoord) {
                res.push({
                    fromName: dataItem[0].name,
                    toName: dataItem[1].name,
                    value: dataItem[1].value,
                    coords: [fromCoord, toCoord]
                });
            }
        }
        return res;
    };

    var color = ['#c5f80e'];
    var series = [];
    [
        ['4G', item]
    ].forEach(function (item, i) {


        series.push({
                name: item[0],
                type: 'lines',
                zlevel: 2,
                symbol: ['none', 'arrow'],
                symbolSize: 10,
                effect: {
                    show: true,
                    period: 6,
                    trailLength: 0,
                    symbol: 'arrow',
                    symbolSize: 5
                },
                lineStyle: {
                    normal: {
                        color: color[i],
                        width: 1,
                        opacity: 0.6,
                        curveness: 0.2
                    }
                },
                data: convertData(item[1])
            }, {
                name: item[0],
                type: 'effectScatter',
                coordinateSystem: 'geo',
                zlevel: 2,
                rippleEffect: {
                    brushType: 'stroke'
                },
                label: {
                    normal: {
                        show: true,
                        position: 'right',
                        formatter: '{b}'
                    }
                },
                symbolSize: function (val) {
                    return val[2] / 20000;
                },
                itemStyle: {
                    normal: {
                        color: color[i]
                    }
                },
                data: item[1].map(function (dataItem) {

                    return {
                        name: dataItem[0].name,
                        value: geoCoordMap[dataItem[0].name].concat([dataItem[1].value])
                    };

                })
            },
            {
                name: '点',
                type: 'scatter',
                coordinateSystem: 'geo',
                symbol: 'pin',
                symbolSize: function (val) {
                    var a = (maxSize4Pin - minSize4Pin) / (max - min);
                    var b = minSize4Pin - a * min;
                    b = maxSize4Pin - a * max;
                    return a * val[2] + b;
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
            });
    });


    [
        ['2G', itemt]
    ].forEach(function (item, i) {


        series.push({
                name: item[0],
                type: 'lines',
                zlevel: 2,
                symbol: ['none', 'arrow'],
                symbolSize: 10,
                effect: {
                    show: true,
                    period: 6,
                    trailLength: 0,
                    symbol: 'arrow',
                    symbolSize: 5
                },
                lineStyle: {
                    normal: {
                        color: color[i],
                        width: 1,
                        opacity: 0.6,
                        curveness: 0.2
                    }
                },
                data: convertData(item[1])
            }, {
                name: item[0],
                type: 'effectScatter',
                coordinateSystem: 'geo',
                zlevel: 2,
                rippleEffect: {
                    brushType: 'stroke'
                },
                label: {
                    normal: {
                        show: true,
                        position: 'right',
                        formatter: '{b}'
                    }
                },
                symbolSize: function (val) {
                    return val[2] /  20000;
                },
                itemStyle: {
                    normal: {
                        color: color[i]
                    }
                },
                data: item[1].map(function (dataItem) {

                    return {
                        name: dataItem[0].name,
                        value: geoCoordMap[dataItem[0].name].concat([dataItem[1].value])
                    };
                })
            },
            {
                name: '点',
                type: 'scatter',
                coordinateSystem: 'geo',
                symbol: 'pin',
                symbolSize: function (val) {
                    var a = (maxSize4Pin - minSize4Pin) / (max - min);
                    var b = minSize4Pin - a * min;
                    b = maxSize4Pin - a * max;
                    return a * val[2] + b;
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
            });
    });
    option = {

        title : {
            text: data3+':全省各个地市到宁德市人流量统计',
            subtext: '2G的人流总量：'+totalNum2g+'人次，4G的人流总量：'+totalNum4g+'人次',
            x:'center',
            y:'20px',
            textStyle : {
                color: '#B8860B'
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: function (param) {//提示信息格式化
                //alert(JSON.stringify(param));
                if (param.componentSubType == "lines")
                    return "<b>" + param.data.fromName + ">" + param.data.toName + ": " + param.data.value;
                else if (param.componentSubType == "effectScatter")
                    return "<b>" + param.data.name + ": " + param.data.value[2];

            }
        },
        legend: {
            orient: 'vertical',
            x:'right',
            y:'center',
            data:['2G', '4G'],
            selectedMode: 'single',
            selected:{
                '4G' : false
            },
            textStyle : {
                color: '#fff'
            }
        },
        dataRange: {
            min : 0,
            max : 10000,
            calculable : true,
            color: ['#ff3333', 'orange', 'yellow','lime','aqua'],
            x:'right',
            textStyle:{
                color:'#fff'
            }
        },
        geo: {
            map: 'fujian',
            label: {
                emphasis: {
                    show: false
                }
            },
            roam: true,
            itemStyle: {
                normal: {
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
                            color: 'rgba(47,79,79, .1)' // 100% 处的颜色
                        }],
                        globalCoord: false // 缺省为 false
                    },
                    shadowColor: 'rgba(128, 217, 248, 1)',
                    // shadowColor: 'rgba(255, 255, 255, 1)',
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
        series: series
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    window.addEventListener("resize", function () {
        myChart.resize();
    });

}



//宁德风景区人流量统计
function echart_5(res) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('chart_5'));

    function showProvince() {
        var geoCoordMap = {
            '福鼎太姥山风景区': [120.1925,27.10278],
            '周宁鲤鱼溪风景区': [119.2973,27.12353],
            '柘荣东狮山风景区': [119.9126,27.23924],
            '屏南白水洋风景区': [119.0971,27.05867],
            '霞浦北岐风景区': [120.0667,26.89089],
            '古田翠屏湖风景区': [118.781,26.60195]
        };
        var data=[];
        var tmsd={};
        tmsd.name='福鼎太姥山风景区';
        tmsd.value=res.tms4g+res.tms2g;
        data.push(tmsd);


        var lyxd={};
        lyxd.name='周宁鲤鱼溪风景区';
        lyxd.value=res.lyx4g+res.lyx2g;
        data.push(lyxd);

        var bsyd={};
        bsyd.name='屏南白水洋风景区';
        bsyd.value=res.bsy4g+res.bsy2g;
        data.push(bsyd);

        var bqd={};
        bqd.name='霞浦北岐风景区';
        bqd.value=res.bq4g+res.bq2g;
        data.push(bqd);


        var cphd={};
        cphd.name='古田翠屏湖风景区';
        cphd.value=res.cph4g+res.cph2g;
        data.push(cphd);

        var dssd={};
        dssd.name='柘荣东狮山风景区';
        dssd.value=res.dss4g+res.dss2g;
        data.push(dssd);

        //console.log(data);


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
                text: '宁德风景区当前人流量统计',
                x:'center',
                y:'10px',
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
                        return (a * val[2] + b)/10;
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
                        return val[2] /500;
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

        myChart.on('click', function (param) {
            var name = param.name;

            if(name=='福鼎太姥山风景区'){
                  tms(res);
            }else if(name=='周宁鲤鱼溪风景区'){
                lyx(res);
            }else if(name=='屏南白水洋风景区'){
                bsy(res);
            }else if(name=='霞浦北岐风景区'){
                bq(res);
            }else if(name=='古田翠屏湖风景区'){
                cph(res);
            }else if(name=='柘荣东狮山风景区'){
                dss(res);
            }

        });
    }
    showProvince();



    // 使用刚指定的配置项和数据显示图表。
    // myChart.setOption(option);
    window.addEventListener("resize", function () {
        myChart.resize();
    });
}

function tms(res){
    $("#img1").attr("src","./static/images/jingqu/tms/1.jpg");
    $("#img2").attr("src","./static/images/jingqu/tms/2.jpg");
    $("#img3").attr("src","./static/images/jingqu/tms/3.jpg");

    $("#spncon1").text("太姥山位于福建省东北部，在福鼎市正南距市区四十五公里，约在东经120度与北纬27度的附近。挺立于东海之滨，三面临海，一面背山。主峰海拔917.3米");
    $("#spncon2").text("2G用户数："+res.tms2g+"人次；4G用户数："+res.tms4g+"人次。");

}

function lyx(res){
    $("#img1").attr("src","./static/images/jingqu/lyx/1.jpg");
    $("#img2").attr("src","./static/images/jingqu/lyx/2.jpg");
    $("#img3").attr("src","./static/images/jingqu/lyx/3.jpg");

    $("#spncon1").text("鲤鱼溪，位于周宁县城西五公里处的浦源村中。鲤鱼溪源于海拔1448米的紫云山麓，汇数十条山涧清泉奔流而下，峰回水转，至浦源村口水势顿减，五弯六曲穿村缓流而过");
    $("#spncon2").text("2G用户数："+res.lyx2g+"人次；4G用户数："+res.lyx4g+"人次。");

}

function bsy(res){
    $("#img1").attr("src","./static/images/jingqu/bsy/1.jpg");
    $("#img2").attr("src","./static/images/jingqu/bsy/2.jpg");
    $("#img3").attr("src","./static/images/jingqu/bsy/3.jpg");

    $("#spncon1").text("白水洋，位于福建省宁德市屏南，是国家AAAAA级旅游景区。白水洋地质公园园区总面积达77.34平方公里，拥有世界唯一的鸳鸯猕猴自然保护区");
    $("#spncon2").text("2G用户数："+res.bsy2g+"人次；4G用户数："+res.bsy4g+"人次。");

}

function bq(res){
    $("#img1").attr("src","./static/images/jingqu/bq/1.jpg");
    $("#img2").attr("src","./static/images/jingqu/bq/2.jpg");
    $("#img3").attr("src","./static/images/jingqu/bq/3.jpg");

    $("#spncon1").text("北岐位于福建省宁德市霞浦县松港街道，距离霞浦县城东五公里，200多户人家，面临海洋，是有名的紫菜养殖场，村民以从事海产品养殖和远海捕捞为业，收入颇丰");
    $("#spncon2").text("2G用户数："+res.bq2g+"人次；4G用户数："+res.bq4g+"人次。");

}

function cph(res){
    $("#img1").attr("src","./static/images/jingqu/cph/1.jpg");
    $("#img2").attr("src","./static/images/jingqu/cph/2.jpg");
    $("#img3").attr("src","./static/images/jingqu/cph/3.jpg");

    $("#spncon1").text("翠屏湖，又名于桥水库，因南依翠屏山而得名。于桥水库位于天津市蓟县城东，是国家重点大型水库之一，水库坝址建于蓟运河左支流州河出口处");
    $("#spncon2").text("2G用户数："+res.cph2g+"人次；4G用户数："+res.cph4g+"人次。");

}

function dss(res){
    $("#img1").attr("src","./static/images/jingqu/dss/1.jpg");
    $("#img2").attr("src","./static/images/jingqu/dss/2.jpg");
    $("#img3").attr("src","./static/images/jingqu/dss/3.jpg");

    $("#spncon1").text("东狮山，形似狮而得名，位于福建省柘荣县城东3公里处，总面积13.7平方公里，海拔1480米，为太姥山脉的主峰");
    $("#spncon2").text("2G用户数："+res.dss2g+"人次；4G用户数："+res.dss4g+"人次。");

}



//当前时段酒店人流量对比
function  loadoOption4(res){
    var myChart4 = echarts.init(document.getElementById('ec4'));
    myChart4.clear();
    var option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
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
            data: ['宁德华尔道夫世鸿大酒店','宁德市万达嘉华酒店','寿宁廊桥国际大酒店','柘荣东华大酒店','周宁金源大酒店','周宁县宾馆','福安万豪国际大酒店',
                '福鼎海天大酒店','福鼎金九龙酒店'
                ,'福鼎国际大酒店','古田好望角酒店','宁德金海湾大酒店','宁德美仑大酒店'
                ,'闽东宾馆','宁德三都澳迎宾馆','屏南天外天酒店','霞浦晨曦酒店','霞浦帝景大酒店'],
            axisLabel:{
                textStyle:{
                    fontSize: 12,
                    color: '#6cbbe6'
                }
            },
        },
        series: [
            {
                name: '人流量',
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
                data: res
               // data: [92,132,142,181,212,28,382,41,92,132,142,181,212,28,382,41,58,33]
            },
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

function echart_6(res) {
    // 基于准备好的dom，初始化echarts实例
    var myChart6 = echarts.init(document.getElementById('imgTab1'));
    myChart6.clear();
    option = {
        title : {
            text: '当前时段比赛场地人流量统计',

            x:'center',
            textStyle : {
                color: '#B8860B'
            }
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        // legend: {
        //     show: 'false',
        //     x : 'center',
        //     y : 'bottom',
        //     data:['福安奥体中心','福安市体育中心','福安一中溪北洋校区','福鼎羽毛球馆','古田翠屏湖水上运动中心','宁德市体育中心','宁德新五中','屏南县白玉村皮划艇训练基地','屏南县一中新校区体育馆'
        //         ,'寿宁体育馆','霞浦高罗沙滩','霞浦沙滩排球馆','霞浦游泳馆','柘荣县体育中心','周宁县体育馆']
        //
        // },

        calculable : true,
        series : [

            {
                name:'人流量',
                type:'pie',
                radius : [30, 110],
                center : ['50%', 200],
                roseType : 'area',
                x: '100%',               // for funnel
                max: 40,                // for funnel
                sort : 'ascending',     // for funnel
                data: res
                // data:[
                //     {value:10, name:'福安奥体中心'},
                //     {value:5, name:'福安市体育中心'},
                //     {value:15, name:'福安一中溪北洋校区'},
                //     {value:25, name:'福鼎羽毛球馆'},
                //     {value:20, name:'古田翠屏湖水上运动中心'},
                //     {value:35, name:'宁德市体育中心'},
                //     {value:30, name:'宁德新五中'},
                //     {value:40, name:'屏南县白玉村皮划艇训练基地'},
                //     {value:40, name:'屏南县一中新校区体育馆'},
                //     {value:40, name:'寿宁体育馆'},
                //     {value:40, name:'霞浦高罗沙滩'},
                //     {value:40, name:'霞浦沙滩排球馆'},
                //     {value:40, name:'霞浦游泳馆'},
                //     {value:40, name:'柘荣县体育中心'},
                //     {value:40, name:'周宁县体育馆'}
                // ]
            }
        ]
    };
    myChart6.setOption(option);

}


function panduanUrl(){
    var baseUrl = window.location.href;
    if(baseUrl.indexOf("jksdev_190_206_8080")>=0){
        return "/jksdev_190_206_8080/";
    }else {
        return "/";
    }
}