var urlTemp = panduanUrl();

var $table;
// $(function () {
//
//     var dateId= $("#dateId").val();
//     var fetchPlatform= $("#fetchPlatform").val();
//
//     var text = dateId + fetchPlatform +"平台未达指标详情";
//     $("#title").html(text);
//     var $table = $('#testTable');
//     $('#btn_exprot').click(function () {
//         $table.bootstrapTable('togglePagination');
//         $table.tableExport({
//             type: 'excel',
//             escape: false,
//             ignoreColumn: [0]
//         });
//         $table.bootstrapTable('togglePagination');
//     });
//
//     initBootstrapTable();
//
//
// });

function initBootstrapTable() {

    var dateId= $("#dateId").val();
    var fetchPlatform= $("#fetchPlatform").val();
    $table = $('#testTable').bootstrapTable({
        // data: jsonArray,
        url: urlTemp+'nei/neiproj/getXiangxiData',
        method:'get',
        queryParams: function (params) {
            return {
                offset: params.offset,
                limit: params.limit,
                dateId: dateId,
                fetchPlatform: fetchPlatform

            }
        },
        toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: true,                     //是否启用排序
        search: true,
        sortOrder: "asc",                   //排序方式
        //sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录行数（*）
        pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        clickToSelect: true,
        showExport: true,                     //是否显示导出
        exportDataType: "all",              //basic', 'all', 'selected'.
        exportTypes: ['excel'],
        exportOptions:{
            ignoreColumn: [0]
        },
        dataType:'json',
        columns: [{
            field: 'kpiName',
            title: '指标英文名'
        }, {
            field: 'kpiInfo',
            title: '指标名称'
        }, {
            field: 'businessType',
            title: '业务类型'
        }, {
            field: 'dimension',
            title: '维度'
        },{
            field: 'subDimension',
            title: '子维度'

        }]
    })
}

$(function(){



    var dateId= $("#dateId").val();
    var fetchPlatform= $("#fetchPlatform").val();
    var $testTable = $('#testTable');
    var text = dateId + fetchPlatform +"平台未达指标详情";
    $("#title").html(text);

    $('#btn_exprot').click(function () {
       // $testTable.bootstrapTable('togglePagination');
        $testTable.tableExport({
            type: 'excel',
            escape: false
        });
       // $testTable.bootstrapTable('togglePagination');
    });

    $testTable.bootstrapTable({
        url: urlTemp+'nei/neiproj/getXiangxiData',
        //url: '/getTableData',
        queryParams: function (params) {
            return {
                offset: params.offset,
                limit: params.limit,

                dateId: dateId,
                fetchPlatform: fetchPlatform

            }
        },
        toolbar: "#toolbar",
      //  icons: {refresh: "glyphicon-repeat", toggle: "glyphicon-list-alt", columns: "glyphicon-list"},
        clickToSelect:true,
        search: true,
        showExport:true,
        exportDataType: "all",
        buttonsAlign:"right",  //按钮位置
        exportTypes:['excel'],  //导出文件类型
        Icons:'glyphicon-export',
        exportOptions:{
            ignoreColumn: [4]
        },
        columns: [{
            field: 'kpiName',
            title: '指标英文名'
        }, {
            field: 'kpiInfo',
            title: '指标名称'
        }, {
            field: 'businessType',
            title: '业务类型'
        }, {
            field: 'dimension',
            title: '维度'
        },{
            field: 'subDimension',
            title: '子维度'

        }],
        striped: true,
        pagination: true,
        sidePagination: 'server',
        pageSize: 10,
        pageList: [3, 5, 10, 20]
    });



});




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




