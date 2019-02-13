
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
    var apn=$('#apn').val();
    var dateId=$('#dateId').val();
    var type=$('#type').val();
    var name=$('#name').val();

    $('#usercounttitle').text(dateId+name+'('+apn+')'+'ATTACH附着成功率监测详情');
    $.ajax({
        type:'post',
        url:urlTemp+"wlwbound/bound/getApnxiangxqingattachData",
        dataType:"json",
        data:{
            apn:apn,
            dateId:dateId,
            type:type
        },
        success:function(result){
            var tempHTML="";

            for(var i=0; i<result.length;i++){
                var shifouyichagn="";
                if(result[i].attach_suc_rate_dingjie_conclusion=='专网运行正常'){
                    shifouyichagn='正常';
                }else{
                    shifouyichagn='异常';
                }
                var line ="";
                if(result[i].type=='2G'){
                    line = panduanNull(result[i].pdp_line);
                }else{
                    line =  panduanNull(result[i].attach_line);
                }
                tempHTML= tempHTML+'<tr>'+
                    '<td>'+panduanNull(result[i].apn)+'</td>'+
                    '<td>'+panduanNull(result[i].name)+'</td>'+
                    '<td>'+panduanNull(result[i].type)+'</td>'+
                    '<td>'+panduanNull(result[i].attach_suc_rate)+'</td>'+
                    '<td>'+panduanNull(line)+'</td>'+
                    '<td>'+panduanNull(result[i].attach_count)+'</td>'+
                    '<td>'+panduanNull(result[i].attach_count_reference)+'</td>'+
                    '<td>'+panduanNull(result[i].attach_count_rate)+'</td>'+
                    '<td>'+panduanNull(result[i].attach_succ_rate_today)+'</td>'+
                    '<td>'+panduanNull(result[i].attach_succ_rate_yes)+'</td>'+
                    '<td>'+panduanNull(shifouyichagn)+'</td>'+
                    '<td>'+panduanNull(result[i].attach_suc_rate_dingjie_conclusion)+'</td>'+
                    '<td><a  href="javascript:findDingjieLiucheng();">点击查看定界流程</a></td>';

            }

            $("#usercountBody").html(tempHTML);

        }
    });

    $("#closeButtonId").click(function () {
        document.getElementById('light').style.display='none';
    });
});



function findDingjieLiucheng(){
    document.getElementById('light').style.display='block';
    var apn=$('#apn').val();
    var dateId=$('#dateId').val();
    var type=$('#type').val();
    var name=$('#name').val();

    $('#djlcmc').html(name+'('+apn+')'+')附着成功率');


    $.ajax({
        type:'post',
        url:urlTemp+"wlwbound/bound/getApnxiangxqingattachData",
        dataType:"json",
        data:{
            apn:apn,
            dateId:dateId,
            type:type
        },
        success:function(result) {
            var objcell = result[0];
            var line_value="";
            if(objcell.type=='2G'){
                line_value=objcell.pdp_line;
            }else{
                line_value=objcell.attach_line;
            }
            $('#riqi').text(panduanNull(objcell.date_id));
            $('#apnn').text(panduanNull(objcell.apn));
            $('#apnmc').text(panduanNull(objcell.name));
            $('#ywczs').text(panduanNull(objcell.type));
            $('#fzcgl').text(panduanNull(objcell.attach_suc_rate));
            $('#cglfz').text(panduanNull(line_value));
            $('#myhsll').text(panduanNull(objcell.attach_count));
            $('#myhllsyjz').text(panduanNull(objcell.attach_count_reference));
            $('#myhllhb').text(panduanNull(objcell.attach_count_rate));
            $('#dwhyhs').text(panduanNull(objcell.attach_succ_rate_today));
            $('#qrdwhyyhs').text(panduanNull(objcell.attach_succ_rate_yes));
            $('#qtzdapnzhyhs').text(panduanNull(objcell.attach_count_others_rate));
            $('#qtzdapnzhyhsjz').text("90");



            //流程上的数值填写
            //专网活跃用户数
            var zwhyhs="";
            if(objcell.attach_suc_rate_flag==0){
                $("#zwhyyhsdiv").css("background-color","#3064BB");
                if(objcell.attach_suc_ratio<0){
                    zwhyhs= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5">'+panduanNull(objcell.attach_suc_rate)+'%</div>'+
                        '<div class="col-md-7">'+
                        '<img src="../static/img/upWx.png" />'+ panduanNull(objcell.attach_suc_ratio)+'%'+
                        '</div>'+

                        ' </div>';
                }else{
                    zwhyhs= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5">'+panduanNull(objcell.attach_suc_rate)+'%</div>'+
                        '<div class="col-md-7">'+
                        '<img src="../static/img/upW.png" />'+ panduanNull(objcell.attach_suc_ratio)+'%'+
                        '</div>'+

                        ' </div>';
                }
            }else {
                $("#zwhyyhsdiv").css("background-color","#BB4E29");
                if(objcell.attach_suc_ratio<0){
                    zwhyhs= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5">'+panduanNull(objcell.attach_suc_rate)+'%</div>'+
                        '<div class="col-md-7">'+
                        '<img src="../static/img/downW.png" />'+ panduanNull(objcell.flow_kb_rate)+'%'+
                        '</div>'+

                        ' </div>';
                }else{
                    zwhyhs= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5">'+panduanNull(objcell.attach_suc_rate)+'%</div>'+
                        '<div class="col-md-7">'+
                        '<img src="../static/img/downWz.png" />'+ panduanNull(objcell.flow_kb_rate)+'%'+
                        '</div>'+

                        ' </div>';
                }
            }
            $("#zwhyyhs").html(zwhyhs);


            //附着成功率/激活成功率
            var fzcgll="";
            if(objcell.attach_count_flag==0){
                $("#fzcglldiv").css("background-color","#3064BB");
                if(objcell.attach_count_rate<0){
                    fzcgll= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5">'+panduanNull(objcell.attach_count)+'次</div>'+
                        '<div class="col-md-7">'+
                        '<img src="../static/img/upWx.png" />'+ panduanNull(objcell.attach_count_rate)+'%'+
                        '</div>'+

                        ' </div>';
                }else{
                    fzcgll= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5">'+panduanNull(objcell.attach_count)+'次</div>'+
                        '<div class="col-md-7">'+
                        '<img src="../static/img/upW.png" />'+ panduanNull(objcell.attach_count_rate)+'%'+
                        '</div>'+

                        ' </div>';
                }
            }else {
                $("#fzcglldiv").css("background-color","#BB4E29");
                if(objcell.attach_count_rate<0){
                    fzcgll= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5">'+panduanNull(objcell.attach_count)+'次</div>'+
                        '<div class="col-md-7">'+
                        '<img src="../static/img/downW.png" />'+ panduanNull(objcell.attach_count_rate)+'%'+
                        '</div>'+

                        ' </div>';
                }else{
                    fzcgll= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5">'+panduanNull(objcell.attach_count)+'次</div>'+
                        '<div class="col-md-7">'+
                        '<img src="../static/img/downWz.png" />'+ panduanNull(objcell.attach_count_rate)+'%'+
                        '</div>'+

                        ' </div>';
                }
            }
            $("#fzcgll").html(fzcgll);





            //每用户流量数
            var dwhyyhss="";
            var tempA = panduanNull(objcell.attach_count_others_rate);

            var tempB = panduanNull((objcell.attach_count_others_rate-90).toFixed(3));

            if(objcell.attach_suc_others_rate_flag==0){
                $("#dwhyyhssdiv").css("background-color","#3064BB");
                if(tempB<0){
                    dwhyyhss= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5">'+tempA+'%</div>'+
                        '<div class="col-md-7">'+
                        '<img src="../static/img/upWx.png" />'+tempB+'%'+
                        '</div>'+

                        ' </div>';
                }else{
                    dwhyyhss= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5">'+tempA+'%</div>'+
                        '<div class="col-md-7">'+
                        '<img src="../static/img/upW.png" />'+ tempB+'%'+
                        '</div>'+

                        ' </div>';
                }
            }else {
                $("#dwhyyhssdiv").css("background-color","#BB4E29");
                if(tempB<0){
                    myhslll= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5">'+tempA+'%</div>'+
                        '<div class="col-md-7">'+
                        '<img src="../static/img/downW.png" />'+ tempB+'%'+
                        '</div>'+

                        ' </div>';
                }else{
                    dwhyyhss= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5">'+tempA+'%</div>'+
                        '<div class="col-md-7">'+
                        '<img src="../static/img/downWz.png" />'+ tempB+'%'+
                        '</div>'+

                        ' </div>';
                }
            }
            $("#dwhyyhss").html(dwhyyhss);

            //其他重点APN
            var myhslll="";
            var tempA =  panduanNull(objcell.attach_succ_rate_today);
            var tempB =  panduanNull(objcell.attach_succ_rate_yes);

            myhslll= '<div class="row view-right-block-div-span">'+
                ' <div class="col-md-5">'+tempA+'%</div>'+
                '<div class="col-md-7">'+
                '(前日)'+tempB+'%'+
                '</div>'+

                ' </div>';
            $("#myhslll").html(myhslll);


            //其他重点APN
            var qitazhogndianapn="";
            var tempA = panduanNull(objcell.mme_attach_succ_rate_bad);
            var tempB = panduanNull(objcell.mme_attach_succ_rate_bad_ratio);

            if(objcell.mme_attach_succ_rate_flag==0){
                $("#qitazhogndianapndiv").css("background-color","#3064BB");
                if(objcell.mme_attach_succ_rate_bad_ratio<0){
                    qitazhogndianapn= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5">'+tempA+'%</div>'+
                        '<div class="col-md-7">'+
                        '<img src="../static/img/upWx.png" />'+tempB+'%'+
                        '</div>'+

                        ' </div>';
                }else{
                    qitazhogndianapn= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5">'+tempA+'%</div>'+
                        '<div class="col-md-7">'+
                        '<img src="../static/img/upW.png" />'+ tempB+'%'+
                        '</div>'+

                        ' </div>';
                }
            }else {
                $("#qitazhogndianapndiv").css("background-color","#BB4E29");
                if(objcell.mme_attach_succ_rate_bad_ratio<0){
                    qitazhogndianapn= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5">'+tempA+'%</div>'+
                        '<div class="col-md-7">'+
                        '<img src="../static/img/downW.png" />'+ tempB+'%'+
                        '</div>'+

                        ' </div>';
                }else{
                    qitazhogndianapn= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5">'+tempA+'%</div>'+
                        '<div class="col-md-7">'+
                        '<img src="../static/img/downWz.png" />'+ tempB+'%'+
                        '</div>'+

                        ' </div>';
                }
            }
            $("#qitazhogndianapn").html(qitazhogndianapn);





            //质量终端成功率
            var zczdcgl="";
            var zhzdcgl="";

            if(objcell.model_flag==0){
                $("#zlzdcgldiv").css("background-color","#3064BB");
                if(objcell.model_attach_suc_rate_bad_ratio<0){
                    zczdcgl= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-8 ziticlass">'+panduanNull(objcell.model_name_bad)+'|'+panduanNull(objcell.model_desc_bad)+'<br>'+panduanNull(objcell.user_count_model_bad)+'台|'+panduanNull(objcell.model_attach_suc_rate_bad)+'%</div>'+
                        '<div class="col-md-4">'+
                        '<img src="../static/img/upWx.png" />'+panduanNull(objcell.model_attach_suc_rate_bad_ratio)+'%'+
                        '</div>'+

                        ' </div>';
                }else{
                    zczdcgl= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-8 ziticlass">'+panduanNull(objcell.model_name_bad)+'|'+panduanNull(objcell.model_desc_bad)+'<br>'+panduanNull(objcell.user_count_model_bad)+'台|'+panduanNull(objcell.model_attach_suc_rate_bad)+'%</div>'+
                        '<div class="col-md-4">'+
                        '<img src="../static/img/upW.png" />'+panduanNull(objcell.model_attach_suc_rate_bad_ratio)+'%'+
                        '</div>'+

                        ' </div>';
                }

                if(objcell.model_attach_suc_rate_good_ratio<0){
                    zhzdcgl= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-8 ziticlass">'+panduanNull(objcell.model_name_good)+'|'+panduanNull(objcell.model_desc_good)+'<br>'+panduanNull(objcell.user_count_model_good)+'台|'+panduanNull(objcell.model_attach_suc_rate_good)+'%</div>'+
                        '<div class="col-md-4">'+
                        '<img src="../static/img/upWx.png" />'+panduanNull(objcell.model_attach_suc_rate_good_ratio)+'%'+
                        '</div>'+

                        ' </div>';
                }else{
                    zhzdcgl= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-8 ziticlass">'+panduanNull(objcell.model_name_good)+'|'+panduanNull(objcell.model_desc_good)+'<br>'+panduanNull(objcell.user_count_model_good)+'台|'+panduanNull(objcell.model_attach_suc_rate_good)+'%</div>'+
                        '<div class="col-md-4">'+
                        '<img src="../static/img/upW.png" />'+panduanNull(objcell.model_attach_suc_rate_good_ratio)+'%'+
                        '</div>'+

                        ' </div>';
                }
            }else if (objcell.model_flag==1){
                $("#zczdcgldiv").css("background-color","#BB4E29");
               //  $(".view-right-span").css("background-color","#BB4E29");
               //  $(".view-right-block-div").css("background-color","#BB4E29");
                if(objcell.model_attach_suc_rate_bad_ratio<0){
                    console.log("---------------------:"+objcell.model_attach_suc_rate_bad_ratio);
                    zczdcgl= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5 ziticlass">'+panduanNull(objcell.model_name_bad)+'|'+panduanNull(objcell.model_desc_bad)+'<br>'+panduanNull(objcell.user_count_model_bad)+'台|'+panduanNull(objcell.model_attach_suc_rate_bad)+'%</div>'+
                        '<div class="col-md-5">'+
                        '<img src="../static/img/downW.png" />'+panduanNull(objcell.model_attach_suc_rate_bad_ratio)+'%'+
                        '</div>'+

                        ' </div>';
                }else{
                    zczdcgl= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5 ziticlass">'+panduanNull(objcell.model_name_bad)+'|'+panduanNull(objcell.model_desc_bad)+'<br>'+panduanNull(objcell.user_count_model_bad)+'台|'+panduanNull(objcell.model_attach_suc_rate_bad)+'%</div>'+
                        '<div class="col-md-5">'+
                        '<img src="../static/img/downWz.png" />'+panduanNull(objcell.model_attach_suc_rate_bad_ratio)+'%'+
                        '</div>'+

                        ' </div>';
                }

                if(objcell.model_attach_suc_rate_good_ratio<0){
                    zhzdcgl= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5 ziticlass">'+panduanNull(objcell.model_name_good)+'|'+panduanNull(objcell.model_desc_good)+'<br>'+panduanNull(objcell.user_count_model_good)+'台|'+panduanNull(objcell.model_attach_suc_rate_good)+'%</div>'+
                        '<div class="col-md-5">'+
                        '<img src="../static/img/upWx.png" />'+panduanNull(objcell.model_attach_suc_rate_good_ratio)+'%'+
                        '</div>'+

                        ' </div>';
                }else{
                    zhzdcgl= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5 ziticlass">'+panduanNull(objcell.model_name_good)+'|'+panduanNull(objcell.model_desc_good)+'<br>'+panduanNull(objcell.user_count_model_good)+'台|'+panduanNull(objcell.model_attach_suc_rate_good)+'%</div>'+
                        '<div class="col-md-5">'+
                        '<img src="../static/img/upW.png" />'+panduanNull(objcell.model_attach_suc_rate_good_ratio)+'%'+
                        '</div>'+

                        ' </div>';
                }
            }else {
                $("#zlzdcgldiv").css("background-color","#BB4E29");
                if(objcell.model_attach_suc_rate_bad_ratio<0){
                    zczdcgl= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5 ziticlass">'+panduanNull(objcell.model_name_bad)+'|'+panduanNull(objcell.model_desc_bad)+'<br>'+panduanNull(objcell.user_count_model_bad)+'台|'+panduanNull(objcell.model_attach_suc_rate_bad)+'%</div>'+
                        '<div class="col-md-5">'+
                        '<img src="../static/img/downW.png" />'+panduanNull(objcell.model_attach_suc_rate_bad_ratio)+'%'+
                        '</div>'+

                        ' </div>';
                }else{
                    zczdcgl= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5 ziticlass">'+panduanNull(objcell.model_name_bad)+'|'+panduanNull(objcell.model_desc_bad)+'<br>'+panduanNull(objcell.user_count_model_bad)+'台|'+panduanNull(objcell.model_attach_suc_rate_bad)+'%</div>'+
                        '<div class="col-md-5">'+
                        '<img src="../static/img/downWz.png" />'+panduanNull(objcell.model_attach_suc_rate_bad_ratio)+'%'+
                        '</div>'+

                        ' </div>';
                }

                if(objcell.model_attach_suc_rate_good_ratio<0){
                    zhzdcgl= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5 ziticlass">'+panduanNull(objcell.model_name_good)+'|'+panduanNull(objcell.model_desc_good)+'<br>'+panduanNull(objcell.user_count_model_good)+'台|'+panduanNull(objcell.model_attach_suc_rate_good)+'%</div>'+
                        '<div class="col-md-5">'+
                        '<img src="../static/img/downW.png" />'+panduanNull(objcell.model_attach_suc_rate_good_ratio)+'%'+
                        '</div>'+

                        ' </div>';
                }else{
                    zhzdcgl= '<div class="row view-right-block-div-span">'+
                        ' <div class="col-md-5 ziticlass">'+panduanNull(objcell.model_name_good)+'|'+panduanNull(objcell.model_desc_good)+'<br>'+panduanNull(objcell.user_count_model_good)+'台|'+panduanNull(objcell.model_attach_suc_rate_good)+'%</div>'+
                        '<div class="col-md-5">'+
                        '<img src="../static/img/downWz.png" />'+panduanNull(objcell.model_attach_suc_rate_good_ratio)+'%'+
                        '</div>'+

                        ' </div>';
                }
            }
            $("#zczdcgl").html(zczdcgl);
            $("#zhzdcgl").html(zhzdcgl);

            if(objcell.attach_suc_rate_dingjie_conclusion=='专网运行正常'){

                $("#id-view").css("background-color","#51BB23");

            }else{
                $("#id-view").css("background-color","#BB4E29");
            }
            $("#id-view").html( '<span class="view-conclusion-span">定界结论：'+objcell.attach_suc_rate_dingjie_conclusion+'</span>');






        }
    });

}

function panduanNull(temp){
    if(temp==null || temp==undefined){
        return '-';
    }else {
        return temp;
    }
}