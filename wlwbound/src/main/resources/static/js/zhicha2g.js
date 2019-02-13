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
    var cid=$('#cid').val();
    var lac=$('#lac').val();

    $.ajax({
        type:'post',
        url:urlTemp+"wlwbound/bound/getZhicha2gData",
        dataType:"json",
        data:{
            dateId:dateId,
            cityName:cityName,
            cid:cid,
            lac:lac
        },
        success:function(result){
            var tempHTML="";
            if(result.res=='success'){
                var data4g = result.data;
                $('#zhichatitle').text(data4g.date_id+data4g.name+'('+data4g.cell_name+')'+'物联网小区质差定界');
                $('#riqi').text(panduanNull(data4g.date_id));
                $('#cell_name').text(panduanNull(data4g.cell_name));
                $('#lacdata').text(panduanNull(data4g.lac));
                $('#cidata').text(panduanNull(data4g.cid));
                $('#city_name').text(panduanNull(data4g.city_name));
                $('#county_name').text(panduanNull(data4g.county_name));
                $('#towns_name').text(panduanNull(data4g.towns_name));
                $('#out_in_door').text(panduanNull(data4g.out_in_door));
                $('#ws_name').text(panduanNull(data4g.ws_name));
                $('#pdp_suc_rate').text(panduanNull(data4g.pdp_suc_rate));
                $('#pdpmaxvalue').text(80);
                $('#pdp_suc_rate_reference').text(panduanNull(data4g.pdp_suc_rate_reference));
                $('#attach_succ_rate_4g').text(panduanNull(data4g.attach_succ_rate_4g));
                $('#model_name').text(panduanNull(data4g.model_name));
                $('#model_desc').text(panduanNull(data4g.model_desc));
                $('#user_count_pdp_model').text(panduanNull(data4g.user_count_pdp_model));
                $('#pdp_count_model').text(panduanNull(data4g.pdp_count_model));
                $('#pdp_suc_rate_model').text(panduanNull(data4g.pdp_suc_rate_model));
                $('#apn').text(panduanNull(data4g.apn));
                $('#name').text(panduanNull(data4g.name));
                $('#user_count_pdp_apn').text(panduanNull(data4g.user_count_pdp_apn));
                $('#pdp_count_apn').text(panduanNull(data4g.pdp_count_apn));
                $('#pdp_suc_rate_apn').text(panduanNull(data4g.pdp_suc_rate_apn));

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
        ' <div class="col-md-5">'+panduanNull(data.pdp_suc_rate)+'%</div>'+
        '<div class="col-md-7">'+80+'%</div>'+
        ' </div>';
    if(data.pdp_suc_rate<=80){
        $("#zwhyyhsdiv").css("background-color","#BB4E29");
    }
    $("#zwhyyhs").html(zwhyhs);


    var  fzcgll= '<div class="row view-right-block-div-span">'+
        ' <div class="col-md-5">'+panduanNull(data.pdp_suc_rate_reference)+'%</div>'+
        '<div class="col-md-7">'+ panduanNull((data.pdp_suc_rate-data.pdp_suc_rate_reference).toFixed(2))+'%'+
        '</div>'+
        ' </div>';

    if(data.pdp_suc_rate_reference_flag==1){
        $("#fzcglldiv").css("background-color","#BB4E29");
    }

    $("#fzcgll").html(fzcgll);


    var qitaTemp='';
    if(data.terminal_pdp_flag==1){
        $("#qitazhogndianapndiv").css("background-color","#BB4E29");
        qitaTemp='是';
    }else {
        qitaTemp='否';
    }
    var qitazhogndianapn= '<div class="row view-right-block-div-spann">'+
        ' <div class="col-md-7">('+data.model_name+'|'+data.model_desc+')'+data.user_count_pdp_model+'|'+data.pdp_suc_rate_model+'%</div>'+
        '<div class="col-md-5">'+90+'%</div>'+

        ' </div>'+
        '<div class="row view-right-block-div-spann" id="spannId">'+
        ' <div class="col-md-12">该专网是否为物联网质差专网：'+qitaTemp+'</div>'+
        ' </div>';

    $("#qitazhogndianapn").html(qitazhogndianapn);


    var qitaTemp1='';
    if(data.apn_pdp_flag==1){
        $("#zlzdcgldiv").css("background-color","#BB4E29");
        qitaTemp1='是';
    }else {
        qitaTemp1='否';
    }
   var zczdcgl= '<div class="row view-right-block-div-spann">'+
       ' <div class="col-md-7">('+data.apn+'|'+data.name+')'+data.user_count_pdp_apn+'|'+data.pdp_suc_rate_apn+'%</div>'+
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