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
    var dateId=$('#dateId').val();
    var cityName=$('#cityName').val();
    var eci=$('#eci').val();

    $.ajax({
        type:'post',
        url:urlTemp+"wlwbound/bound/getZhicha4gData",
        dataType:"json",
        data:{
            dateId:dateId,
            cityName:cityName,
            eci:eci
        },
        success:function(result){
            var tempHTML="";
            if(result.res=='success'){
                var data4g = result.data;
                $('#zhichatitle').text(data4g.date_id+data4g.name+'('+data4g.cell_name+')'+'物联网小区质差定界');
                $('#riqi').text(panduanNull(data4g.date_id));
                $('#cell_name').text(panduanNull(data4g.cell_name));
                $('#ecidata').text(panduanNull(data4g.eci));
                $('#city_name').text(panduanNull(data4g.city_name));
                $('#county_name').text(panduanNull(data4g.county_name));
                $('#honeycomb_type').text(panduanNull(data4g.honeycomb_type));
                $('#vendor_name').text(panduanNull(data4g.vendor_name));
                $('#ws_name').text(panduanNull(data4g.ws_name));
                $('#attach_suc_rate').text(panduanNull(data4g.attach_suc_rate));
                $('#attachmaxvalue').text(90);
                $('#attach_suc_rate_reference').text(panduanNull(data4g.attach_suc_rate_reference));
                $('#attach_succ_rate_4g').text(panduanNull(data4g.attach_succ_rate_4g));
                $('#personwangvalue').text(95);
                $('#model_name').text(panduanNull(data4g.model_name));
                $('#model_desc').text(panduanNull(data4g.model_desc));
                $('#user_count_s1mme_model').text(panduanNull(data4g.user_count_s1mme_model));
                $('#attach_count_model').text(panduanNull(data4g.attach_count_model));
                $('#attach_suc_rate_model').text(panduanNull(data4g.attach_suc_rate_model));
                $('#apn').text(panduanNull(data4g.apn));
                $('#name').text(panduanNull(data4g.name));
                $('#user_count_s1mme_apn').text(panduanNull(data4g.user_count_s1mme_apn));
                $('#attach_count_apn').text(panduanNull(data4g.attach_count_apn));
                $('#attach_suc_rate_apn').text(panduanNull(data4g.attach_suc_rate_apn));

                initLiuCheng(data4g);

            }


        }
    });


});

function  initLiuCheng(data) {
   var attach_suc_rate = data.attach_suc_rate;
   var attach_suc_rate_reference_flag = data.attach_suc_rate_reference_flag;
   //var

    var  zwhyhs= '<div class="row view-right-block-div-span">'+
        ' <div class="col-md-5">'+panduanNull(data.attach_suc_rate)+'%</div>'+
        '<div class="col-md-7">'+90+'%</div>'+
        ' </div>';
    if(data.attach_suc_rate<=90){
        $("#zwhyyhsdiv").css("background-color","#BB4E29");
    }
    $("#zwhyyhs").html(zwhyhs);


    var  fzcgll= '<div class="row view-right-block-div-span">'+
        ' <div class="col-md-5">'+panduanNull(data.attach_suc_rate_reference)+'%</div>'+
        '<div class="col-md-7">'+ panduanNull((data.attach_suc_rate-data.attach_suc_rate_reference).toFixed(2))+'%'+
        '</div>'+
        ' </div>';

    if(data.attach_suc_rate_reference_flag==1){
        $("#fzcglldiv").css("background-color","#BB4E29");
    }

    $("#fzcgll").html(fzcgll);

    var   myhslll= '<div class="row view-right-block-div-span">'+
        ' <div class="col-md-5">'+data.attach_succ_rate_4g+'%</div>'+
        '<div class="col-md-7">'+95+'%'+
        '</div>'+

        ' </div>';
    if(data.attach_suc_rate_4g_flag==1){
        $("#myhsllldiv").css("background-color","#BB4E29");
    }

    $("#myhslll").html(myhslll);


    var qitaTemp='';
    if(data.terminal_s1mme_flag==1){
        $("#qitazhogndianapndiv").css("background-color","#BB4E29");
        qitaTemp='是';
    }else {
        qitaTemp='否';
    }
    var qitazhogndianapn= '<div class="row view-right-block-div-spann">'+
        ' <div class="col-md-7">('+data.model_name+'|'+data.model_desc+')'+data.user_count_s1mme_model+'|'+data.attach_suc_rate_model+'%</div>'+
        '<div class="col-md-5">'+90+'%</div>'+

        ' </div>'+
        '<div class="row view-right-block-div-spann" id="spannId">'+
        ' <div class="col-md-12">该专网是否为物联网质差专网：'+qitaTemp+'</div>'+
        ' </div>';

    $("#qitazhogndianapn").html(qitazhogndianapn);


    var qitaTemp1='';
    if(data.apn_s1mme_flag==1){
        $("#zlzdcgldiv").css("background-color","#BB4E29");
        qitaTemp1='是';
    }else {
        qitaTemp1='否';
    }
   var zczdcgl= '<div class="row view-right-block-div-spann">'+
       ' <div class="col-md-7">('+data.apn+'|'+data.name+')'+data.user_count_s1mme_apn+'|'+data.attach_suc_rate_apn+'%</div>'+
       '<div class="col-md-5">'+90+'%</div>'+

       ' </div>'+
       '<div class="row view-right-block-div-spann" id="spannId">'+
       ' <div class="col-md-12">该专网是否为物联网质差专网：'+qitaTemp1+'</div>'+
       ' </div>';

    $("#zczdcgldiv").html(zczdcgl);


    $("#id-view").html( '<span class="view-conclusion-span">定界结论：'+data.result_flag+'</span>');









}


function panduanNull(temp){
    if(temp==null || temp==undefined){
        return '-';
    }else {
        return temp;
    }
}