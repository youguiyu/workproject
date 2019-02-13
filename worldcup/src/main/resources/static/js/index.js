var urlTemp = panduanUrl();
function panduanUrl(){
    var baseUrl = window.location.href;
    if(baseUrl.indexOf("jksdev_190_171_8080")>=0){
        return "/jksdev_190_171_8080/";
    }else {
        return "/";
    }
}


$(function(){
    //5分钟刷新一次
    init();
    setInterval('init()',30000);
    var temp =$("#cityOption option:selected").val();

    init2(temp);

    setInterval('init2()',30000);
});
function updateData(){
    var temp =$("#cityOption option:selected").val();

    init2(temp);
}
function init(){
    $.ajax({
        type:'post',
        //url:'/jksdev_190_171_8080/wlw/wlwproj/getZuoDaLineData',
        url:urlTemp+'worldcup/con/getNowData',
        dataType:"json",
        success: function(result) {

            initEchartTable(result);
        }
    });
}

function init2(temp){
    $.ajax({
        type:'post',
        //url:'/jksdev_190_171_8080/wlw/wlwproj/getZuoDaLineData',
        url:urlTemp+'worldcup/con/getHisData',
        dataType:"json",
        data:{temp:temp},
        success: function(result) {

            initEchart2(result);
        }
    });
}
function initEchartTable(result) {
    var dom = document.getElementById("chart1");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;

    option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            data: ['CCTV_Video', '咪咕视频','优酷网']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'value',
            boundaryGap: [0, 0.01]
        },
        yAxis: {
            type: 'category',
            data: ['南平','三明','龙岩','漳州','泉州','莆田','宁德','厦门','福州']
        },
        series: result
    };
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

function initEchart2(r){
    var result =eval(r);
    var dom = document.getElementById("chart2");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    var dataMap = {};
    var time = result.alltime;
    console.log(time.length);

    var CCTV = result.CCTV;

    var migu =result.migu;
    var youku = result.youku;
    function dataFormatter(obj) {
        var pList = ['南平','三明','龙岩','漳州','泉州','莆田','宁德','厦门','福州'];
        var temp;
        for (var year = 0; year <time.length; year++) {
            var max = 0;
            var sum = 0;
            var timeNow = time[year];

            temp = obj[timeNow];

            for (var i = 0, l = temp.length; i < l; i++) {
                max = Math.max(max, temp[i]);
                sum += temp[i];
                obj[time[year]][i] = {
                    name : pList[i],
                    value : temp[i]
                }
            }
            obj[time[year] + 'max'] = Math.floor(max / 100) * 100;
            obj[time[year] + 'sum'] = sum;
        }
        return obj;
    }



    dataMap.dataCCTV = dataFormatter(CCTV);

    dataMap.dataMigu= dataFormatter(migu);

    dataMap.dataYouku= dataFormatter(youku);

    var seriesData =[];


    for(var j=0; j<time.length;j++){
        var seriesCell={};
        var s1=[];
        var SC1={};
        var SC2={};
        var SC3={};
        SC1.data = dataMap.dataCCTV[time[j]];
        SC2.data = dataMap.dataMigu[time[j]];
        SC3.data = dataMap.dataYouku[time[j]];
        s1.push(SC1);s1.push(SC2);s1.push(SC3);
        seriesCell.series =s1;
        seriesData.push(seriesCell);
    }


    option = {
        baseOption: {
            timeline: {
                // y: 0,
                axisType: 'category',
                // realtime: false,
                // loop: false,
                autoPlay: true,
                // currentIndex: 2,
                playInterval: 500,
                // controlStyle: {
                //     position: 'left'
                // },
                data: time

            },
            tooltip: {
            },
            legend: {
                x: 'center',
                data: ['CCTV_Video', '咪咕视频','优酷网']
            },
            calculable : true,

            yAxis: [
                {
                    'type':'category',
                    'axisLabel':{'interval':0},
                    'data':['南平','三明','龙岩','漳州','泉州','莆田','宁德','厦门','福州'],
                    splitLine: {show: false}
                }
            ],
            xAxis: [
                {
                    type: 'value'
                }
            ],
            series: [
                {name: 'CCTV_Video', type: 'bar'},
                {name: '咪咕视频', type: 'bar'},
                {name: '优酷网', type: 'bar'}

            ]
        },
        options: seriesData
    };
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
}

function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}