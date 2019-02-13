var pageTimer=[] ;
// window.onload = function (){
//     var temp=1;
//    (function($){
//      funObj = {
//        timeUserFun:'timeUserFun',
//      }
//      $[funObj.timeUserFun] = function(time){
//        var time = time || 2;
//        var userTime = time*60;
//        var objTime = {
//          init:0,
//          time:function(){
//            objTime.init += 1;
//
//            if(objTime.init == userTime){
// 			//    temp++;
// 			//   setTimeout('setTimer()',5000);
//              // console.log('aaa'); // 用户到达未操作事件 做一些处理
// 			//  //self.setInterval("setTimer()",8000);
// 			// if(temp%3==0){
// 			// 	setInterval('setTimer()',20000);
// 			}else{
// 			   //console.log("bbbb");
//
// 			 // setTimer();
//
// 		   }
//          },
//          eventFun:function(){
//            clearInterval(testUser);
//            objTime.init = 0;
//            testUser = setInterval(objTime.time,1000);
// 		  // console.log('cccc');
// 		   // for(var i=0; i<pageTimer.length; i++){
// 			// 	  clearTimeout(pageTimer[i]);console.log('c1');
// 			//   }
//          }
//        }
//
//        var testUser = setInterval(objTime.time,1000);
//
//        var body = document.querySelector('html');
//        body.addEventListener("click",objTime.eventFun);
//        body.addEventListener("keydown",objTime.eventFun);
//        body.addEventListener("mousemove",objTime.eventFun);
//        body.addEventListener("mousewheel",objTime.eventFun);
//      }
//    })(window)
//
//
// //   直接调用 参数代表分钟数,可以有一位小数;
//    timeUserFun(0.1);
//  }
var urlTemp = panduanUrl();

$(function () {
	// $("#zuoda").css("color","yellow") ;
	// $("#zuodad").css("color","yellow") ;
    panduanUrl2();
     //.log(urlTemp);
	
	
	var date = getYesDate();
	$("#dqDate").html(date);

    zuoda();
    //做大规模数据折线图
    $.ajax({
        type:'post',
        url:urlTemp+'wlw/wlwproj/getZuoDaLineData',
        //url:getRootPath()+'/getZuoDaLineData',
        dataType:"json",
        success: function(result) {

            initEchartTable(result);
        }
    });

	//setTimer();

    var that3 = $("#scrollWarn2");
    scrollTalble(that3);
    var that2 = $("#scrollWarn1");
    scrollTalble(that2);



});


//定时器
function setTimer(){

	var master2= setTimeout('zuoqiang()',3000); 

	var master3= setTimeout('zuoyou()',8000); 
	var master4= setTimeout('zuoda()',13000); 
	
	
    
     
	  pageTimer.push(master2);
	   pageTimer.push(master3);
	    pageTimer.push(master4);
	
}


function panduanUrl(){
    var baseUrl = window.location.href;
    if(baseUrl.indexOf("jksdev_190_171_8080")>=0){
        return "/jksdev_190_171_8080/";
    }else {
        return "/";
    }
}


function panduanUrl2(){
    var baseUrl = window.location.href;
    var temp1 = "../../../sodev/html/";
    var temp2 ="http://10.48.190.35/html/";
    //console.log(baseUrl);
    if(baseUrl.indexOf("jksdev_190_171_8080")>=0){
         $("#gongan1").attr("href",temp1+"579");
        $("#dianli1").attr("href",temp1+"575");
        $("#gonglu1").attr("href",temp1+"559");
        $("#ludeng1").attr("href",temp1+"552");
        $("#yinghang1").attr("href",temp1+"567");
        $("#shuili1").attr("href",temp1+"571");
        $("#xhc1").attr("href",temp1+"556");
        $("#chogndianzhuang1").attr("href",temp1+"583");
        $("#chelianwang1").attr("href",temp1+"587");
        $("#tongyong1").attr("href",temp1+"563");
        $("#zonglan1").attr("href",temp1+"591");

    }else {
        $("#gongan1").attr("href",temp2+"579");
        $("#dianli1").attr("href",temp2+"575");
        $("#gonglu1").attr("href",temp2+"559");
        $("#ludeng1").attr("href",temp2+"552");
        $("#yinghang1").attr("href",temp2+"567");
        $("#shuili1").attr("href",temp2+"571");
        $("#xhc1").attr("href",temp2+"556");
        $("#chogndianzhuang1").attr("href",temp2+"583");
        $("#chelianwang1").attr("href",temp2+"587");
        $("#tongyong1").attr("href",temp2+"563");
        $("#zonglan1").attr("href",temp2+"591");
    }

    //console.log($(".gongan").html());
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

function initEchartTable(result){
	var myChart = echarts.init(document.getElementById('main'));

	
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

function zuoda(){


	 $("#zuoyou").css("color","white") ;
	 $("#zuoda").css("color","yellow") ;
	 
	 $("#zuoqiang").css("color","white") ;
	   $("#zuoyouy").css("color","white") ;
	 $("#zuodad").css("color","yellow") ;
	 $("#zuoqiangq").css("color","white") ;


    //做大规模数据折线图
    $.ajax({
        type:'post',
        url:urlTemp+'wlw/wlwproj/getZuoDaLineData',
        //url:getRootPath()+'/getZuoDaLineData',
        dataType:"json",
        success: function(result) {

            initEchartTable(result);
        }
    });


    //做大规模数据
    $.ajax({
        type:'post',
       url:urlTemp+'wlw/wlwproj/getZuoDaData',
        //url:getRootPath()+'/getZuoDaData',
        dataType:"json",
        data:{temp:"1"},
        success: function(result) {
            initzuodaguimo(result);
        }
    });

    //做大规模数据
    $.ajax({
        type:'post',
        url:urlTemp+'wlw/wlwproj/getZuoDaData',
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
        url:urlTemp+'wlw/wlwproj/getZuoDaData',
        // url:getRootPath()+'/getZuoDaData',
        dataType:"json",
        data:{temp:"4"},
        success: function(result) {

            //initzuodaguimo(result);

            initzuoDats(result);
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


    // var that3 = $("#scrollWarn2");
    // scrollTalble(that3);
	
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

    // var that2 = $("#scrollWarn1");
    // scrollTalble(that2);

}

function xdrtoFix2(num){
    return (Number(num)/Number(100000000)).toFixed(2);
}

function liuliangtoFix2(num){
    return (Number(num)/Number(1024)).toFixed(2);
}
function initzuodaguimo(result){


    var htmlText1=  '<div class="tab-title">总体规模</div>'+

        '<div  class="page-box" id="page-box11">'+
        ' <div class="page-box2">'+
        '<h3>物联网:'+result['全省'].apnCnt+'个</h3>'+
        '</div>'+
        '<div class="page-box3">'+
        '	<h3>用户数:'+(Number(result['全省'].userCnt)/Number(10000)).toFixed(2) +'万</h3>'+
        '</div>'+
        '<div class="page-box4">'+
        '	<h3>流量:'+(Number(result.全省.flowGb)/Number(1024)).toFixed(2)+'TB</h3>'+
        '</div>'+
        '<div class="page-box5">'+
        '	<h3>XDR数:'+(Number(result.全省.xdrCnt)/Number(100000000)).toFixed(2)+'亿</h3>'+
        '</div>'+
        ' <div class="page-box-n" id="scrollWarn">'+
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

        '</div>'+


        '</div>'+
        '<div class="page-box1">全省行业指标呈现（用户数）</div>  '+
        '<div  class="page-box" >'+
        ' <div id="main" ></div>'+

        '</div>';
    $("#pageLeft").html(htmlText1);
    var that1 = $("#scrollWarn");
    scrollTalble(that1);

}

function zuoyou(){
	//$("#scrollWarn").html()
	 $("#zuoyou").css("color","yellow") ;
	 $("#zuoda").css("color","white") ;
	 $("#zuoqiang").css("color","white") ;
	 
	   $("#zuoyouy").css("color","yellow") ;
	 $("#zuodad").css("color","white") ;
	 $("#zuoqiangq").css("color","white") ;

    //做强规模数据
    $.ajax({
        type:'post',
        url:urlTemp+'wlw/wlwproj/getZuoQiangData',
        //url:getRootPath()+'/getZuoQiangData',
        dataType:"json",
        data:{temp:"1"},
        success: function(result) {


            var htmlText = '<div class="tab-title">总体规模</div>'+
                ' <div class="page-box1">全省规模</div>  '+
                '<div  class="page-box-zy" >'+
                '  <div class="page-box-nn">'+
                '	<h3>全省物联网附着次数 :'+toDecimal2((result["all"].attachCount)/10000)+' 万次</h3>'+
                '</div>'+

                ' <div id="gauge4"></div>'+
                ' <div id="gauge5"></div>'+
                '  <div id="gauge6"></div>'+
                '  <div id="gauge7"></div>'+


                '</div>'+
                ' <div class="page-box1">全网指标结论</div>  '+
                ' <div class="page-box-n" > '+
                '<div class="row" > '+
                '	<div class="col-md-1"></div> '+
                '	<div class="col-md-11"><h2>规模无异常</h2></div> '+
                '</div> '+
                '<div class="row" > '+
                '	<div class="col-md-3"></div> '+
                '	<div class="col-md-9"><h2>指标无异常</h2></div> '+
                '</div> '+
                '<div class="row" > '+
                '	<div class="col-md-4"></div> '+
                '	<div class="col-md-8"><h2>应用无异常</h2></div> '+
                '</div> '+

                '</div> ';
            $("#pageLeft").html(htmlText);






            var htmlText2= '<ul >'+
                '<li class="jiacu">CMIOT:</li>'+
                '<li>附着成功率'+toDecimal2(result["通用"].attachRate)+'%；TCP（核心）建立成功率'+toDecimal2(result["通用"].tcpCoreRate)+'%；TCP(无线)建立成功率'+toDecimal2(result["通用"].tcpWxRate)+'%；HTTP成功率'+toDecimal2(result["通用"].httpRate)+'%</li>'+

                '<li ></li>'+
                '<li class="jiacu">车联网：</li>'+
                '<li>附着成功率'+toDecimal2(result["车联网"].attachRate)+'%；TCP（核心）建立成功率'+toDecimal2(result["车联网"].tcpCoreRate)+'%；TCP(无线)建立成功率'+toDecimal2(result["车联网"].tcpWxRate)+'%；HTTP成功率'+toDecimal2(result["车联网"].httpRate)+'%</li>'+


                '<li ></li>'+
                '<li  class="jiacu">国家充电桩</li>'+
                '<li>附着成功率'+toDecimal2(result["充电桩"].attachRate)+'%；TCP（核心）建立成功率'+toDecimal2(result["充电桩"].tcpCoreRate)+'%；TCP(无线)建立成功率'+toDecimal2(result["充电桩"].tcpWxRate)+'%；HTTP成功率'+toDecimal2(result["充电桩"].httpRate)+'%</li>'+

                '<li ></li>'+
                '<li  class="jiacu">共享单车：</li>'+
                '<li>附着成功率99.81%；TCP（核心）建立成功率100.00%；TCP(无线)建立成功率99.81%；HTTP成功率96.19%。</li>'+

                '<li ></li>'+
                '</ul>';


            var htmlText3=
                '<ul >'+
                '<li ></li>'+
                '<li  class="jiacu">电力</li>'+
                '<li>附着成功率'+toDecimal2(result["电力"].attachRate)+'%；TCP（核心）建立成功率'+toDecimal2(result["电力"].tcpCoreRate)+'%；TCP(无线)建立成功率'+toDecimal2(result["电力"].tcpWxRate)+'%；HTTP成功率'+toDecimal2(result["电力"].httpRate)+'%</li>'+


                '<li ></li>'+
                '<li  class="jiacu">水务</li>'+
                '<li>附着成功率'+toDecimal2(result["水务"].attachRate)+'%；TCP（核心）建立成功率'+toDecimal2(result["水务"].tcpCoreRate)+'%；TCP(无线)建立成功率'+toDecimal2(result["水务"].tcpWxRate)+'%；HTTP成功率'+toDecimal2(result["水务"].httpRate)+'%</li>'+

                '<li ></li>'+
                '<li  class="jiacu">银行</li>'+
                '<li>附着成功率'+toDecimal2(result["银行"].attachRate)+'%；TCP（核心）建立成功率'+toDecimal2(result["银行"].tcpCoreRate)+'%；TCP(无线)建立成功率'+toDecimal2(result["银行"].tcpWxRate)+'%；HTTP成功率'+toDecimal2(result["银行"].httpRate)+'%</li>'+


                '<li ></li>'+
                '<li  class="jiacu">路灯</li>'+
                '<li>附着成功率'+toDecimal2(result["路灯"].attachRate)+'%；TCP（核心）建立成功率'+toDecimal2(result["路灯"].tcpCoreRate)+'%；TCP(无线)建立成功率'+toDecimal2(result["路灯"].tcpWxRate)+'%；HTTP成功率'+toDecimal2(result["路灯"].httpRate)+'%</li>'+

                '<li ></li>'+
                '<li  class="jiacu">公安</li>'+
                '<li>附着成功率'+toDecimal2(result["公安"].attachRate)+'%；TCP（核心）建立成功率'+toDecimal2(result["公安"].tcpCoreRate)+'%；TCP(无线)建立成功率'+toDecimal2(result["公安"].tcpWxRate)+'%；HTTP成功率'+toDecimal2(result["公安"].httpRate)+'%</li>'+


                '<li ></li>'+
                '<li  class="jiacu">公共交通</li>'+
                '<li>附着成功率'+toDecimal2(result["公共交通"].attachRate)+'%；TCP（核心）建立成功率'+toDecimal2(result["公共交通"].tcpCoreRate)+'%；TCP(无线)建立成功率'+toDecimal2(result["公共交通"].tcpWxRate)+'%；HTTP成功率'+toDecimal2(result["公共交通"].httpRate)+'%</li>'+

                '<li ></li>'+
                '</ul>';







            $("#scrollWarn1").html(htmlText2);
            $("#scrollWarn2").html(htmlText3);
            var that5 = $(".page-box144");
            scrollTalble(that5);
            var attach_rate=toDecimal2((result["all"].attachRate));
            var tcp_core_rate=toDecimal2((result["all"].tcpCoreRate));
            var tcp_wx_rate=toDecimal2((result["all"].tcpWxRate));
            var http_rate=toDecimal2((result["all"].httpRate));
            initGauge2(attach_rate,tcp_core_rate,tcp_wx_rate,http_rate);
        }
    });


	 
}

function zuoyouData(result){

}



function zuoqiang(){
	//$("#scrollWarn").html()
	 $("#zuoyou").css("color","white") ;
	 $("#zuoda").css("color","white") ;
	 $("#zuoqiang").css("color","yellow") ;
	 
	  $("#zuoyouy").css("color","white") ;
	 $("#zuodad").css("color","white") ;
	 $("#zuoqiangq").css("color","yellow") ;


    //做强规模数据
    $.ajax({
        type:'post',
       url:urlTemp+'wlw/wlwproj/getZuoYouData',
        //url:getRootPath()+'/getZuoYouData',
        dataType:"json",
        data:{temp:"1"},
        success: function(result) {

            zuoqaingguimo(result);
        }
    });




	  
	 var htmlText1 = '<ul >'+
	                        '<li class="jiacu">CMIOT的业务特点:</li>'+
							'<li>1、通用APN专网用户流量流向主要集中在腾讯、阿里、网宿、爱奇艺、百度、蓝汛，占比分别为：22.43%、15.25%、5.33%、5.23%、2.45%、1.11%；</li>'+
							'<li>2、主要协议类型为TCP,XDR占比92.25%；</li>'+
							'<li>3、目的IP总地址1008473，私网地址33593，公网IP占比96.67%。</li>'+
							'<li ></li>'+
							'<li class="jiacu">车联网的业务特点：</li>'+
							'<li>1、移动性高，低速率，小于100kbps的XDR数占到94%以上；</li>'+
							'<li>2、交互类型为交互型或上报型，业务时段集中在7点到24点。</li>'+
							'<li ></li>'+
							'<li  class="jiacu">国家充电桩的业务特点：</li>'+
							'<li>1、位置固定，交互类型为交互型；</li>'+
							'<li>2、低速率，速率基本小于100kbps；</li>'+
							'<li>3、用户小时分布大部分大于9小时以上，目的IP集中在10.111.186.1上。</li>'+
							'<li ></li>'+
							'<li  class="jiacu">共享单车的业务特点：</li>'+
							'<li>1、单车日均活跃应用人数21w+；</li>'+
							'<li>2、摩拜单车日均骑行车次12w+，解锁成功率99.81%，闭锁成功率100%。</li>'+
							'<li ></li>'+
						'</ul>';
	var htmlText2 = '<ul >'+
	                        '<li class="jiacu">电力行业的业务特点：</li>'+
							'<li>1、主要专网业务集中在2/3G，主要协议类型为TCP；</li>'+
							'<li>2、XDR数占专网总量的16%，用户数占专网总量的13%，流量占专网总量的1.4%。</li>'+
					
							'<li ></li>'+
							'<li class="jiacu">金融行业的业务特点：</li>'+
							'<li>1、银联终端数最多，浦发银行业务量最大，业务时段主要分布在上午9点以后，9点后时段分布较为均匀。</li>'+
							'<li>2、省农信社以下行流量为主，泉州农信社、省农行、手机支付以上行流量为主，其余企业上下行流量较为平均。</li>'+
							'<li>3、手机支付（CMPAY）、建设银行、泉州农信社终端移动性较强，银联、浦发终端移动性不强，且区域分布较为集中。</li>'+
							'<li ></li>'+
							'<li  class="jiacu">水利行业的业务特点：</li>'+
							'<li>1、主要专网业务集中在2/3G，业务以小包为主；</li>'+
							'<li>2、终端移动性较低，活跃用户在线率基本都高于30%。</li>'+
							
							'<li ></li>'+
							'<li  class="jiacu">照明行业的业务特点：</li>'+
							'<li>1、业务包以中低速率、小包为主，大部分终端位置固定，存在傍晚和陵城两个业务高峰特性。</li>'+
							
							'<li ></li>'+
						    '<li  class="jiacu">公安警务行业的业务特点：</li>'+
							'<li>1、以4G专网业务为主，用户活跃时段集中在常规上班时间，多数APN以小包业务为主。</li>'+
							
							'<li ></li>'+
						    '<li  class="jiacu">交通运输行业的业务特点：</li>'+
							'<li>1、主要使用4G通道，占流量98%以上，多数是高移动上报型业务；</li>'+
							'<li>2、业务时段主要分布在7-19点的工作时段，活跃用户在线率基本都高于30%。</li>'+
							
							'<li ></li>'+
						'</ul>';
						
	

	

	 
	$("#scrollWarn1").html(htmlText1);
	$("#scrollWarn2").html(htmlText2);
	
	
	
	


	
	
}

function  zuoqaingguimo(result) {

    var htmlText = '<div class="tab-title">总体规模</div>'+
        '<div class="page-box1">全省规模</div> '+
        '<div  class="page-box12" id="page-box11">'+
        '<div class="page-box22">'+
        '<h3>信息交互:'+result["guimo"][0].apnCnt+'个</h3>'+
        '</div>'+
        '<div class="page-box33">'+
        '	<h3>固定上报:'+result["guimo"][1].apnCnt+'个</h3>'+
        '</div>'+
        '<div class="page-box44">'+
        '	<h3>下载型:'+result["guimo"][2].apnCnt+'个</h3>'+
        '</div>'+
        '<div class="page-box55">'+
        '<h3>GRE隧道:'+result["guimo"][3].apnCnt+'个</h3>'+
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
        '</div>'+
        '<div class="page-box1">集团数据特性</div> '+
        ' <div  class="page-box14" id="crollWarn5" >'+
        '<ul >'+
        '<li>'+
        '<div class="page-box222" >'+
        '<h5>'+result["max_xdr"]+'&nbsp;:&nbsp;XDR数量最多</h5>'+
        '</div>'+
        '</li>'+
        '<li>'+
        '	<div class="page-box222">'+
        '		<h5>'+result["max_user"]+'&nbsp;:&nbsp;用户数最多</h5>'+
        '	</div>'+
        '</li>'+
        '<li>'+
        '	<div class="page-box222">'+
        '		<h5>'+result["max_flow"]+'&nbsp;:&nbsp;流量最多</h5>'+
        '</div>'+
        '</li>'+

        '<li>'+
        '<div class="page-box222">'+
        '	<h5>'+result["max_eci"]+'&nbsp;:&nbsp;频度最高</h5>'+
        '</div>'+
        '</li>'+
        '<li>'+
        '<div class="page-box222">'+
        '	<h5>'+result["max_per_user"]+'&nbsp;:&nbsp;每用户包大小最大</h5>'+
        '</div>'+
        '</li>'+
        '</ul>'+


        '</div>';

    $("#pageLeft").html(htmlText);

    //做强规模数据
    $.ajax({
        type:'post',
        url:urlTemp+'wlw/wlwproj/getZuoYouData',
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

function getYesDate(){
    var yesDay = new Date();
    //yesDay.setDate(yesDay.getDate()-1);
    //var yesDayformat= yesDay.format("yyyy-MM-dd");
    yesDay.setTime(yesDay.getTime());
    var m=yesDay.getMonth()+1;
    var mf="";
	 
    if(m>10 || m==10){
        mf=m;
    }else{
        mf="0"+m;
    }
    var d=yesDay.getDate();
    var df="";
    if(d>10 || d==10){
        df=d;
    }else{
        df="0"+d;
    }
	 return yesDay.getFullYear()+"-"+mf+"-"+df;
   

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

function accDiv(arg1,arg2) {
	var t1=0,t2=0,r1,r2;
	try {t1=arg1.toString().split(".")[1].length}catch (e){}
    try {t2=arg2.toString().split(".")[1].length}catch (e){}
    with (Math){
    	r1=Number(arg1.toString().replace(".",""));

        r2=Number(arg2.toString().replace(".",""));
        return (r1/r2)*pow(10,t2-t1);
	}
}