var urlTemp = panduanUrl();
function panduanUrl(){
    var baseUrl = window.location.href;
    if(baseUrl.indexOf("jksdev_190_171_8080")>=0){
        return "/jksdev_190_171_8080/";
    }else {
        return "/";
    }
}
var $testTable = $('#tableData');





$(function() {

    laydate.render({
        elem: '#timeselect',
        format:'yyyyMMdd',
        max:-1

    });


    $.ajax({
        type:'get',
        url:urlTemp+"wlwbound/bound/getZhichaTime",
        dataType:"json",
        success:function(result){
            $('#timeselect').attr("value",result);
            $('#dingxiaoqujietitle').text(result+'物联网小区质差定界');
            init4GTable();
        }
    });

});
function init4GTable() {
    $testTable.bootstrapTable('destroy');

    $testTable.bootstrapTable({
        dataType:'json',
        url: urlTemp+'wlwbound/bound/get4GTableData',
        method: 'get',
        queryParams: function (params) {
            return {
                offset: params.offset,
                limit: params.limit,
                timeselect: $("#timeselect").val()
            }
        },
        striped: true,
        pagination: true,
        sidePagination: 'server',
        smartDisplay:false,
        pageSize: 10,
        pageList: [5, 10, 25, 50, 100],
        columns: [{
            title:'1',
            field: 'date_id',
            visible: false
        },{
            field:'city_name',
            title: '地市',
            align: 'center',
            valign: 'middle',
            width: '5%'

        },{
            field:'county_name',
            title:'区县',
            align: 'center',
            valign: 'middle',
            width: '5%'
        },{
            field: 'cell_name',
            title: '小区名称',
            align: 'center',
            valign: 'middle',
        }, {
            field: 'honeycomb_type',
            title: '室内/室外',
            align: 'center',
            valign: 'middle',
            width: '8%'
        }, {
            field: 'vendor_name',
            title: '厂家',
            align: 'center',
            valign: 'middle',
            width: '5%'
        }, {
            field: 'ws_name',
            title: '覆盖场景',
            align: 'center',
            valign: 'middle',
            width: '5%'
        }, {
            field: 'eci',
            title: 'ECI',
            align: 'center',
            valign: 'middle',
            width: '6%'

        }, {
            field: 'attach_suc_rate',
            title: '附着成功率（%）',
            align: 'center',
            valign: 'middle',
        },{
            field: 'attach_count',
            title: '附着次数',
            align: 'center',
            valign: 'middle'
        },{
            field: 'attach_suc_rate_reference',
            title: '上周历史附着成功率（%）',
            align: 'center',
            valign: 'middle'

        },{
            field: 'attach_count_reference',
            title: '上周历史总附着次数',
            align: 'center',
            valign: 'middle'

        },{
            field: 'attach_succ_rate_4g',
            title: '该小区人网附着成功率（%）'
        },{
            field: 'attach_cnt_4g',
            title: '该小区人网附着次数',
            align: 'center',
            valign: 'middle'

        },{
            field: 'result_flag',
            title: '定界结论',
            align: 'center',
            valign: 'middle'

        },{
            title: '定界过程',
            align: 'center',
            valign: 'middle',
            formatter:function (value,row,index) {
                return  [
                    '<a href="javascript:look4GContent('+encodeURIComponent(JSON.stringify(row.date_id))+','+encodeURIComponent(JSON.stringify(row.city_name))+','+encodeURIComponent(JSON.stringify(row.eci))+')">' +
                    '查看' +
                    '</a>'
                ].join('');

            }

        }]
    });
}
function findTableData() {

    var url=urlTemp;
    var class4G=$("#data4G").attr("class");
    var class2G=$("#data2G").attr("class");
    if(class4G=='btn btn-success'&&class2G=='btn btn-default'){
        url = url+"wlwbound/bound/get4GTableData";
    }else {
        url = url+"wlwbound/bound/get2GTableData";
    }

    var opt = {
        url: url,
        silent: true,
        query:{
            timeselect:  $('#timeselect').val()
        }
    };
    $testTable.bootstrapTable('refresh', opt);

    $('#dingxiaoqujietitle').text($('#timeselect').val()+'物联网小区质差定界');
}

//工具方法
function getNowFormatDate() {
    var date = new Date();
    date.setTime(date.getTime()-24*60*60*1000);
    var seperator1 = "";
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




function  get4GData(){
    var htmlText=' <button type="button" class="btn btn-default" onclick="javascript:export4GTable()">导出表格</button>';
    $("#data4G").attr("class","btn btn-success");
    $("#data2G").attr("class","btn btn-default");
    $("#exportId").html(htmlText);
    init4GTable();
}

function  get2GData(){
    $("#data2G").attr("class","btn btn-success");
    $("#data4G").attr("class","btn btn-default");
    var htmlText=' <button type="button" class="btn btn-default" onclick="javascript:export2GTable()">导出表格</button>';
    $("#exportId").html(htmlText);
    init2GTable();
}
function export2GTable() {
    window.location.href=urlTemp+"wlwbound/bound/createZhichaExcel?timeselect="+ $("#timeselect").val()+"&temp="+1;
    // $.ajax({
    //     type:'post',
    //     url:urlTemp+"wlwbound/bound/createZhichaExcel",
    //     dataType:"json",
    //     data:{
    //         timeselect: $("#timeselect").val(),
    //         temp:1
    //     },
    //     success:function(result){
    //         if(result=='success'){
    //             console.log("导出成功");
    //         }
    //     }
    // });
}
function export4GTable() {
    window.location.href=urlTemp+"wlwbound/bound/createZhichaExcel?timeselect="+ $("#timeselect").val()+"&temp="+0;

    // $.ajax({
    //     type:'post',
    //     url:urlTemp+"wlwbound/bound/createZhichaExcel",
    //     dataType:"json",
    //     data:{
    //         timeselect: $("#timeselect").val(),
    //         temp:0
    //     },
    //     success:function(result){
    //         if(result=='success'){
    //             console.log("导出成功");
    //         }
    //     }
    // });
}
function init2GTable() {
    $testTable.bootstrapTable('destroy');
    $testTable.bootstrapTable({
        dataType:'json',
        url: urlTemp+'wlwbound/bound/get2GTableData',
        method: 'get',
        queryParams: function (params) {
            return {
                offset: params.offset,
                limit: params.limit,
                timeselect: $("#timeselect").val()
            }
        },
        striped: true,
        pagination: true,
        sidePagination: 'server',
        smartDisplay:false,
        pageSize: 10,
        pageList: [5, 10, 25, 50, 100],
        columns: [{
            title:'1',
            field: 'date_id',
            visible: false
        },{
            field:'city_name',
            title: '地市',
            align: 'center',
            valign: 'middle',
            width: '5%'

        },{
            field:'county_name',
            title:'区县',
            align: 'center',
            valign: 'middle',
            width: '5%'
        },{
            field: 'towns_name',
            title: '乡镇',
            align: 'center',
            valign: 'middle',
        }, {
            field: 'cell_name',
            title: '小区名称',
            align: 'center',
            valign: 'middle',
        }, {
            field: 'out_in_door',
            title: '室内/室外',
            align: 'center',
            valign: 'middle',
            width: '8%'
        }, {
            field: 'ws_name',
            title: '覆盖场景',
            align: 'center',
            valign: 'middle',
            width: '5%'
        }, {
            field: 'lac',
            title: 'LAC',
            align: 'center',
            valign: 'middle',
            width: '6%'

        }, {
            field: 'cid',
            title: 'CI',
            align: 'center',
            valign: 'middle',
            width: '6%'

        }, {
            field: 'pdp_suc_rate',
            title: '激活成功率（%）',
            align: 'center',
            valign: 'middle',
        },{
            field: 'pdp_count',
            title: '激活次数',
            align: 'center',
            valign: 'middle'
        },{
            field: 'pdp_suc_rate_reference',
            title: '上周历史激活成功率（%）',
            align: 'center',
            valign: 'middle'

        },{
            field: 'pdp_count_reference',
            title: '上周历史总激活次数',
            align: 'center',
            valign: 'middle'

        },{
            field: 'result_flag',
            title: '定界结论',
            align: 'center',
            valign: 'middle'

        },{
            title: '定界过程',
            align: 'center',
            valign: 'middle',
            formatter:function (value,row,index) {
                return  [
                    '<a href="javascript:look2GContent('+encodeURIComponent(JSON.stringify(row.date_id))+','+encodeURIComponent(JSON.stringify(row.city_name))+','+encodeURIComponent(JSON.stringify(row.lac))+','+encodeURIComponent(JSON.stringify(row.cid))+')">' +
                    '查看' +
                    '</a>'
                ].join('');

            }

        }]
    });
}

function look2GContent(dateId,cityName,lac,cid){
    window.open(urlTemp+"wlwbound/bound/to2Gxiangqing?dateId="+dateId+"&cityName="+cityName+"&lac="+lac+"&cid="+cid , "_blank");

}

function look4GContent(dateId,cityName,eci) {
    window.open(urlTemp+"wlwbound/bound/to4Gxiangqing?dateId="+dateId+"&cityName="+cityName+"&eci="+eci,"_blank");
}
