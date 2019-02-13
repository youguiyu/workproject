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
    /**
     * 合并单元格
     * @param data  原始数据（在服务端完成排序）
     * @param fieldName 合并属性名称
     * @param colspan   合并列
     * @param target    目标表格对象
     */
    function mergeCells(data, fieldName, colspan, target) {
        //声明一个map计算相同属性值在data对象出现的次数和
        var sortMap = {};
        for (var i = 0; i < data.length; i++) {
            for (var prop in data[i]) {
                if (prop == fieldName) {
                    var key = data[i][prop]
                    if (sortMap.hasOwnProperty(key)) {
                        sortMap[key] = sortMap[key] * 1 + 1;
                    } else {
                        sortMap[key] = 1;
                    }
                    break;
                }
            }
        }
        /*for (var prop in sortMap) {
            console.log(prop, sortMap[prop])
        }*/
        var index = 0;
        for (var prop in sortMap) {
            var count = sortMap[prop] * 1;
            $(target).bootstrapTable('mergeCells', {index: index, field: fieldName, colspan: colspan, rowspan: count});
            index += count;
        }
    }



    function initTable(selector) {
        $(selector).bootstrapTable({
            method: "post",
            //url:"cities", //请求数据的地址，初始化时填写会自动加载数据。
            cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
            striped: true, //是否显示行间隔色
            total: "total", //数据格式中数据总量的KEY，默认为total
            dataField: "rows",//bootstrap table 可以前端分页也可以后端分页，这里
            //我们使用的是后端分页，后端分页时需返回含有total：总记录数,这个键值默认rows
            pageNumber: 1, //初始化加载第一页，默认第一页
            //pagination: true,//是否分页
            queryParamsType: '',//查询参数组织方式
            //queryParams:queryParams,//请求服务器时所传的参数
            sidePagination: 'client',//指定服务器端分页
            pageSize: 2,//单页记录数
            pageList: [2, 5, 10, 20, 30],//分页步进值
            showRefresh: false,//刷新按钮
            showColumns: false,//列选择按钮
            clickToSelect: true,//是否启用点击选中行
            sortName: 'id', // 要排序的字段
            sortOrder: 'asc', // 排序规则
            showExport:true,
            queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
                //alert(params.pageIndex );
                return {
                    month: $("#monthselect").val(), //每页的行数
                }
            },
            responseHandler: function (res) {

                //var a1=handkeData(res,"移动业务NEI");
                //var a2=handkeData(res,"家庭业务NEI");
                //var a3=handkeData(res,"政企业务NEI");
                //var a4=handkeData(res,"新业务NEI");
                //var c=a1.concat(a2).concat(a3).concat(a4);
                //console.log(obj1);
                return  res;
            },
            onLoadSuccess: function (data) {
                var data = $(selector).bootstrapTable('getData', true);
                //合并单元格
                mergeCells(data, "四轮驱动", 1, $(selector));
                mergeCells(data, "短板分析", 12, $(selector));
                //console.log(JSON.stringify(data));
            },
            columns: [
                [
                    {
                        valign:'middle',
                        align:'center',
                        width: 10,
                        rowspan:2,
                        field: '四轮驱动',
                        title: '四轮驱动',
                        cellStyle:function (value,row,index) {
                            if(value=="移动业务NEI"){
                                return {
                                    css:{"background-color":"yellow","writing-mode":"vertical-lr","text-align":"center"}
                                };
                            }else if(value=="家庭业务NEI"){
                                return {
                                    css:{"background-color":"green","writing-mode":"vertical-lr","text-align":"center"}
                                };
                            }else if(value=="政企业务NEI"){
                                return {
                                    css:{"background-color":"#8968CD","writing-mode":"vertical-lr","text-align":"center"}
                                };
                            }else if(value=="新业务NEI"){
                                return {
                                    css:{"background-color":"pink","writing-mode":"vertical-lr","text-align":"center"}
                                };
                            }else {
                                return {
                                    css:{"background-color":"#66ffcc","writing-mode":"vertical-lr","text-align":"center"}
                                };
                            }


                        }
                    },
                    {
                        align:'center',
                        title: '重大事件管控',
                        field: '重大事件管控',
                    },
                    {
                        align:'center',
                        field: '客户反映',
                        title: '客户反映',
                    }
                    ,
                    {
                        align:'center',
                        field: '业务感知',
                        title: '业务感知',
                    }
                    ,
                    {
                        align:'center',
                        field: '服务感知',
                        title: '服务感知',
                    }
                    ,
                    {
                        align:'center',
                        field: '竞对感知',
                        title: '竞对感知',
                    }
                    ,
                    {
                        align:'center',
                        field: '场景感知',
                        title: '场景感知',
                    }
                    ,
                    {
                        align:'center',
                        field: '最差感知',
                        title: '最差感知',
                    }
                    ,
                    {
                        align:'center',
                        field: '覆盖感知',
                        title: '覆盖感知',
                    }
                    ,
                    {
                        align:'center',
                        field: '容量感知',
                        title: '容量感知',
                    }
                    ,
                    {
                        align:'center',
                        field: '结构感知',
                        title: '结构感知',
                    }
                    ,
                    {
                        rowspan:2,
                        valign:'middle',
                        align:'center',
                        field: '短板分析',
                        title: '短板分析',

                    }
                ],
                [

                    {
                        field: '重大事件管控',
                        align:'left',
                        title: '排名 \t地市/区域'
                    }
                    ,
                    {
                        field: '客户反映',
                        align:'left',
                        title: '排名 \t地市/区域'
                    }
                    ,
                    {
                        field: '业务感知',
                        align:'left',
                        title: '排名 \t地市/区域'
                    }
                    ,
                    {
                        field: '服务感知',
                        align:'left',
                        title: '排名 \t地市/区域'
                    }
                    ,
                    {
                        field: '竞对感知',
                        align:'left',
                        title: '排名 \t地市/区域'
                    }
                    ,
                    {

                        field: '场景感知',
                        align:'left',
                        title: '排名 \t地市/区域'
                    }
                    ,
                    {
                        field: '最差感知',
                        align:'left',
                        title: '排名 \t地市/区域'
                    }
                    ,
                    {
                        field: '覆盖感知',
                        align:'left',
                        title: '排名 \t地市/区域'
                    }
                    ,
                    {
                        field: '容量感知',
                        align:'left',
                        title: '排名 \t地市/区域'
                    }
                    ,
                    {
                        field: '结构感知',
                        align:'left',
                        title: '排名 \t地市/区域'
                    }


                ]

            ]
        });
    }
    var header="福建省[year]年[month]月NEI “4轮10维”网络与业务质量短板分析";
    function init() {
        initTable('#table1');
        laydate.render({
            elem: '#monthselect',
            type: 'month',
            format:'M',
            value:new Date().getMonth()+1,
            showBottom:true
        });

        var today=new Date();
        var title=header.replace("[year]",today.getFullYear()).replace("[month]",today.getMonth()+1);
        $("#header").html(title);
        window.setTimeout(function () {
            //页面LOADING完成后的N毫秒时间后再运行，防止页面未生成就请求数据。
            //$('#table1').bootstrapTable('refresh', {url: 'report'});
            $('#table1').bootstrapTable('refresh', {url: urlTemp+'nei/neiexprot/report'});
        }, 200);

    }


    init();
     //initTable('#table1',"移动业务NEI");
    //initTable('#table2',"家庭业务NEI");
    //initTable('#table3',"政企业务NEI");
    //initTable('#table4',"新业务NEI");

    $('#btnFind').click(function () {
        //$('#table1').bootstrapTable('refresh', {url: 'report'});
        $('#table1').bootstrapTable('refresh', {url: urlTemp+'nei/neiexprot/report'});

        var today=new Date();
        var title=header.replace("[year]",today.getFullYear()).replace("[month]",$("#monthselect").val());
        $("#header").html(title);

    })
    $('#btnExport').click(function () {
        var data = $("#monthselect").val();
        var today=new Date();
        var title=header.replace("[year]",today.getFullYear()).replace("[month]",$("#monthselect").val());
        $("#header").html(title);
        if(data!=null && data!="")
            window.open(urlTemp+"nei/neiexprot/reportExcel?month="+$("#monthselect").val());
        //$('#table1').bootstrapTable('refresh', {url: 'report'});
        $('#table1').bootstrapTable('refresh', {url: urlTemp+'nei/neiexprot/report'});
    })
    $('#btnAll').click(function () {
        var data = $("#monthselect").val();
        var today=new Date();
        var title=header.replace("[year]",today.getFullYear()).replace("[month]",$("#monthselect").val());
        $("#header").html(title);
        if(data!=null && data!="")
            window.open(urlTemp+"nei/neiexprot/reportAll?month="+$("#monthselect").val());

    })


});