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
    $('#timeselect').attr("value",getNowFormatDate());
    laydate.render({
        elem: '#timeselect',
        max:-1,
        format:'yyyyMMdd'

    });
});


// $("#sub").click(function () {
//     $("#frm_reg").ajaxSubmit(function (data) {
//         alert(data.Message);
//     });
// });



$('#timeselect').attr("value",getNowFormatDate());
var $testTable = $('#testTable');
var $kpiInfoTable = $('#kpiInfoTable');
var $kpiInfoTable1 = $('#kpiInfoTable1');




$kpiInfoTable.bootstrapTable({
    url: urlTemp+'nei/neiproj/getKpiAllInfo',
    queryParams: function (params) {
        return {
            offset: params.offset,
            limit: params.limit,
            searchText: $('#searchText').val()
        }
    },
    silent:true,
    columns: [{
        field: 'kpiName',
        title: '英文指标名字',
        align: 'center'
        
    }, {
        field: 'id',
        title: 'ID',
        withd: 100,
        align: 'center'
    }, {
        field: 'kpiInfo',
        title: '指标名字',
        align: 'center'
    }, {
        field: 'kpiDefinition',
        title: '指标描述',
        align: 'center'
    },{
        field: 'businessType',
         title: '业务类型',
        withd: 100,
        align: 'center'
    },{
        field: 'dimension',
        title: '维度',
        withd: 100,
        align: 'center'
    },{
        field: 'subDimension',
        title: '子维度',
        withd: 100,
        align: 'center'
    },{
        field: 'department',
        title: '部门',
        align: 'center'
    },{
        field: 'manager',
        title: '管理人',
        align: 'center'
    },{
        field: 'fetchPlatform',
        title: '数据来源平台',
        align: 'center'
    },{
        field: 'fetchWay',
        title: '获取方式',
        align: 'center'
    },{
        field: 'benchmarkValue',
        title: '基准值',
        align: 'center'
    },{
        field: 'challengeValue',
        title: '挑战值',
        align: 'center'
    },{
        field: 'kpiWeight',
        title: '权重',
        align: 'center'
    }],
    striped: true,
    pagination: true,
    sidePagination: 'server',
    pageSize: 10,
    pageList: [5, 10, 25, 50, 100]
});
$kpiInfoTable1.bootstrapTable({
    url: urlTemp+'nei/neiproj/getKpiAllInfo1',
    queryParams: function (params) {
        return {
            offset: params.offset,
            limit: params.limit,
            searchText: $('#searchText1').val()
        }
    },
    silent:true,
    columns: [{
        field: 'kpiName',
        title: '英文指标名字',
        align: 'center'

    }, {
        field: 'id',
        title: 'ID',
        withd: 100,
        align: 'center'
    }, {
        field: 'kpiInfo',
        title: '指标名字',
        align: 'center'
    }, {
        field: 'kpiDefinition',
        title: '指标描述',
        align: 'center'
    },{
        field: 'businessType',
         title: '业务类型',
        withd: 100,
        align: 'center'
    },{
        field: 'dimension',
        title: '维度',
        withd: 100,
        align: 'center'
    },{
        field: 'subDimension',
        title: '子维度',
        withd: 100,
        align: 'center'
    },{
        field: 'department',
        title: '部门',
        align: 'center'
    },{
        field: 'manager',
        title: '管理人',
        align: 'center'
    },{
        field: 'fetchPlatform',
        title: '数据来源平台',
        align: 'center'
    },{
        field: 'fetchWay',
        title: '获取方式',
        align: 'center'
    },{
        field: 'benchmarkValue',
        title: '基准值',
        align: 'center'
    },{
        field: 'challengeValue',
        title: '挑战值',
        align: 'center'
    },{
        field: 'kpiWeight',
        title: '权重',
        align: 'center'
    },{
        field: 'topLimit',
        title: '上限值',
        align: 'center'
    },{
        field: 'lowerLimit',
        title: '下限值',
        align: 'center'
    }],
    striped: true,
    pagination: true,
    sidePagination: 'server',
    pageSize: 10,
    pageList: [5, 10, 25, 50, 100]
});


$testTable.bootstrapTable({
    url: urlTemp+'nei/neiproj/getKpiModelData',
    //url: '/getTableData',
    queryParams: function (params) {
        return {
            offset: params.offset,
            limit: params.limit,

            time1: mangerTime(3),
            time2: mangerTime(3)
        }
    },
    silent:true,
    columns: [{
        field: 'dateId',
        title: '日期',
        align: 'center',

        formatter: function (value,row,index) {

            var temp1="";
            if(row.dateId==null || row.dateId=='-'|| row.dateId==undefined){
                temp1 =  $('#timeselect').val();
            }else {
                temp1 = value;
            }

            return [
                temp1
            ].join('');
        }

    }, {
        field: 'fetchPlatform',
        title: '数据来源平台',
        align: 'center'
    }, {
        field: 'kpiNameCountOri',
        title: '应送指标数',
        align: 'center'
    }, {
        field: 'kpiNameCountNow',
        title: '送达指标数',
        align: 'center'
    },{
        field: 'kpiCountValue',
         title: '未送达指标数',
        align: 'center',
        formatter: function (value, row, index) {

            var temp =  "";
            if(row.kpiCountValue>0){
                temp= '<a href="javascript:findxiangqing('+encodeURIComponent(JSON.stringify(row.dateId))+','+encodeURIComponent(JSON.stringify(row.fetchPlatform))+')">' +
                    +row.kpiCountValue+'<i class="glyphicon glyphicon-pencil"></i>'+
                    '</a>'
            }else{
                temp=row.kpiCountValue;
            }


            return [
                temp
            ].join('');
        }
    }],
    cache:false,
    striped: true,
    pagination: true,
    sidePagination: 'server',
    pageSize: 25,
    pageList: [25, 50, 100]
});


function mangerTime(temp) {
    var time = $('#timeselect').val();
    if(temp==3){
        return getNowFormatDate();
    }else {
        return time;
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
    var currentdate = year+month+strDate;
    return currentdate;
}


function findModelData(){
    var time = $('#timeselect').val();
    //alert(time);
    if(time==''||time==null ||time==undefined){
        alert("时间未选择，请选择。。。");
    }else{

         var opt ={
             url:urlTemp+'nei/neiproj/getKpiModelData',
             silent:true,
             query:{
                 time1: mangerTime(1),
                 time2: mangerTime(2)
             }
         }

        $testTable.bootstrapTable('refresh', opt);

    }
}


function findInfoData(){

    var opt = {
        //url: "/getTableData",
        url: urlTemp+'nei/neiproj/getKpiAllInfo',
        silent:true,
        query:{
            searchText: $('#searchText').val()

        }
    };
    $kpiInfoTable.bootstrapTable('refresh', opt);
}

function findInfoData1(){

    var opt = {
        //url: "/getTableData",
        url: urlTemp+'nei/neiproj/getKpiAllInfo1',
        silent:true,
        query:{
            searchText: $('#searchText1').val()

        }
    };
    $kpiInfoTable1.bootstrapTable('refresh', opt);
}



function findxiangqing(dateId,fetchPlatform) {

    if(dateId==null){
        window.open(urlTemp+'nei/neiproj/toInfoDetailData?dateId='+getNowFormatDate()+"&&fetchPlatform="+fetchPlatform,'_blank');
    }else {
        window.open(urlTemp+'nei/neiproj/toInfoDetailData?dateId='+dateId+"&&fetchPlatform="+fetchPlatform,'_blank');
    }



}

function closewin(){
   // console.log("aaaaa");
    document.getElementById('light').style.display='none';
    document.getElementById('fade').style.display='none';
}