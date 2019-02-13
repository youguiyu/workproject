package com.xngls.neiproj.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xngls.neiproj.entity.KpiModel;
import com.xngls.neiproj.entity.NeiKpi;
import com.xngls.neiproj.entity.NeiKpiAndNeiValue;

import com.xngls.neiproj.model.*;
import com.xngls.neiproj.service.NeiService;
import com.xngls.neiproj.util.CSVCrate;
import com.xngls.neiproj.util.PaginationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "neiproj")
public class NeiController {

    @Autowired
    private NeiService neiService;

    /**
     * 功能：进入首页
     */
    @RequestMapping(value = "toHeader", produces = {"application/json;charset=UTF-8"})
    public String toHeader(){

        return "header";
    }
    /**
     * 功能：进入首页
     */
    @RequestMapping(value = "toIndex", produces = {"application/json;charset=UTF-8"})
    public String toIndex(){

        return "index";
    }


    /**
     * 功能：进入首页
     */
    @RequestMapping(value = "toIndex2", produces = {"application/json;charset=UTF-8"})
    public String toIndex2(){

        return "index2";
    }


    /**
     * 功能：进入首页
     */
    @RequestMapping(value = "toInfoDetailData", produces = {"application/json;charset=UTF-8"})
    public String toInfoDetailData(Integer dateId,String fetchPlatform,Model model){
        model.addAttribute("dateId", dateId);
        model.addAttribute("fetchPlatform", fetchPlatform);
        return "kpiInfoDetail";
    }



    /**
     * 功能：进入指标分析
     */
    @RequestMapping(value = "toIndexAnalysis", produces = {"application/json;charset=UTF-8"})
    public String toIndexAnalysis(){

        return "indexAnalysis";
    }

    /**
     * 功能：进入指标数据管理
     */
    @RequestMapping(value = "toIndexDataManage", produces = {"application/json;charset=UTF-8"})
    public String toIndexDataManage(){

        return "indexDataManage";
    }


    /**
     * 功能：进入评估页
     */
    @RequestMapping(value = "toPingGu", produces = {"application/json;charset=UTF-8"})
    public String toPingGu(){

        return "pinggu";
    }



    /**
     * 功能：进入指标页
     */
    @RequestMapping(value = "toZhibiao", produces = {"application/json;charset=UTF-8"})
    public String toZhibiao(){

        return "zhibiao";
    }

    /**
     * 功能：进入短板分析页
     */
    @RequestMapping(value = "todbfx", produces = {"application/json;charset=UTF-8"})
    public String todbfx(){
        return "dbfx";
    }
    /**
     * 功能：进入短板分析页
     */
    @RequestMapping(value = "toDataexport", produces = {"application/json;charset=UTF-8"})
    public String toDataexport(){
        return "dataexport";
    }




    @ResponseBody
    @RequestMapping(value = "/getTableData", produces = {"application/json;charset=UTF-8"})
    public PaginationResult getTableData(ZhibiaoTiaoModel zhibiaoTiaoModel){
        Page<Object> page = PageHelper.offsetPage(zhibiaoTiaoModel.getOffset(), zhibiaoTiaoModel.getLimit());
        List<NeiKpiAndNeiValue> neiKpiAndNeiValues = neiService.findByPage(zhibiaoTiaoModel);
        return new PaginationResult(page.getTotal(), neiKpiAndNeiValues);
    }
    @ResponseBody
    @RequestMapping(value = "/getqushiData", produces = {"application/json;charset=UTF-8"})
    public Map<String,Object> getTableData(QushiModel qushiModel){
        Map<String,Object> qushiData = neiService.findByQushiData(qushiModel);
        return qushiData;
    }

    @ResponseBody
    @RequestMapping(value = "/getqushiData2", produces = {"application/json;charset=UTF-8"})
    public Map<String,Object> getqushiData2(QushiModel qushiModel){
        Map<String,Object> qushiData = neiService.findByQushiData2(qushiModel);
        return qushiData;
    }


    @ResponseBody
    @RequestMapping(value = "/getRadar1Data", produces = {"application/json;charset=UTF-8"})
    public List<Map<String,Object>> getRadar1Data(){
        List<Map<String,Object>> data = neiService.getRadar1Data();
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "/getRadar2Data", produces = {"application/json;charset=UTF-8"})
    public List<Map<String,Object>> getRadar2Data(){
        List<Map<String,Object>> data = neiService.getRadar2Data();
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "/getMapData", produces = {"application/json;charset=UTF-8"})
    public Map<String,Object> getMapData(){

        Map<String,Object> data = neiService.getMapData();
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "/getMapLineData", produces = {"application/json;charset=UTF-8"})
    public Map<String,Object> getMapLineData(String city){

        Map<String,Object> data = neiService.getMapLineData(city);
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "/getPingGuTalbeA", produces = {"application/json;charset=UTF-8"})
    public List<Map<String, Object>> getPingGuTalbeA(String dateId,Integer temp){
        String bussinessType="";
        if(temp==1){
            bussinessType="移动业务NEI";
        }else  if(temp==2){
            bussinessType="家庭业务NEI";
        }else  if(temp==3){
            bussinessType="政企业务NEI";
        }else  if(temp==4){
            bussinessType="新业务NEI";
        }

        List<Map<String, Object>> data = neiService.getPingGuTalbeA(dateId,bussinessType);
        return data;
    }


    @RequestMapping("/toZhibiaoInfo")
    public String toForward(String time,String businessType,String demension, Model model) {
        model.addAttribute("time", time);
        model.addAttribute("demension", demension);
        model.addAttribute("businessType", businessType);
        return "zhibiaoInfo";
    }



    @ResponseBody
    @RequestMapping(value = "/getTableData2", produces = {"application/json;charset=UTF-8"})
    public PaginationResult getTableData2(Integer offset,Integer limit,String timeselect,String selectsilun,String selecttenW){
        Page<Object> page = PageHelper.offsetPage(offset, limit);


        String bussinessType="";
        if(selectsilun.equals("1")){
            bussinessType="移动业务NEI";
        }else  if(selectsilun.equals("2")){
            bussinessType="家庭业务NEI";
        }else  if(selectsilun.equals("3")){
            bussinessType="政企业务NEI";
        }else  if(selectsilun.equals("4")){
            bussinessType="新业务NEI";
        }

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("offset",offset);map.put("limit",limit);
        map.put("time",timeselect);map.put("bussinessType",bussinessType);
        if (selecttenW.equals("汇总")){
            map.put("demension","");
        }else{
            map.put("demension",selecttenW);
        }

        List<NeiKpiAndNeiValue> neiKpiAndNeiValues = neiService.findByPage2(map);
        return new PaginationResult(page.getTotal(), neiKpiAndNeiValues);
    }



    @RequestMapping(value = "/uploadExcel", produces = {"application/json;charset=UTF-8"})
    public String uploadExcel(@RequestParam("file") MultipartFile file,Model model){
        Map<String ,Object> map =new HashMap<String,Object>();
        String fileName = file.getOriginalFilename();
        int size=0;
        try {
            map= neiService.batchImport(fileName, file);

            if(map.get("resultmodel")!=null){
                CSVCrate.deleteFile();
                CSVCrate.createCSV((List< ResultModel>)map.get("resultmodel"));
                size = ((List< ResultModel>)map.get("resultmodel")).size();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("result", map.get("result"));
        if(size==0){
            model.addAttribute("status", 0);
        }else {
            model.addAttribute("status", 1);
        }

        return "updateResult";

    }



    @ResponseBody
    @RequestMapping(value = "/getKpiModelData", produces = {"application/json;charset=UTF-8"})
    public PaginationResult getKpiModelData(KpiDataModel kpiModel){
        Page<Object> page = PageHelper.offsetPage(kpiModel.getOffset(), kpiModel.getLimit());
        Map<String ,Integer> map = new HashMap<String, Integer>();
        map.put("time1",kpiModel.getTime1());
        map.put("time2",kpiModel.getTime2());
        List<KpiModel> kpiModels = neiService.findKpiModes(map);
        return new PaginationResult(page.getTotal(), kpiModels);
    }


    @ResponseBody
    @RequestMapping(value = "/getXiangxiData", produces = {"application/json;charset=UTF-8"})
    public PaginationResult getXiangxiData(Integer dateId, Integer offset,Integer limit,String fetchPlatform){
        Page<Object> page = PageHelper.offsetPage(offset,limit);

        List<NeiKpi> neiKpis = neiService.getXiangxiData(dateId,fetchPlatform);
        return new PaginationResult(page.getTotal(), neiKpis);
    }

    @ResponseBody
    @RequestMapping(value = "/getKpiAllInfo", produces = {"application/json;charset=UTF-8"})
    public PaginationResult getKpiAllInfo(NeiKpiSearchModel neiKpiSearchModel){
        Page<Object> page = PageHelper.offsetPage(neiKpiSearchModel.getOffset(),neiKpiSearchModel.getLimit());

        List<NeiKpi> neiKpis = neiService.getKpiAllInfo(neiKpiSearchModel.getSearchText());
        return new PaginationResult(page.getTotal(), neiKpis);
    }

    @ResponseBody
    @RequestMapping(value = "/getKpiAllInfo1", produces = {"application/json;charset=UTF-8"})
    public PaginationResult getKpiAllInfo1(NeiKpiSearchModel neiKpiSearchModel){
        Page<Object> page = PageHelper.offsetPage(neiKpiSearchModel.getOffset(),neiKpiSearchModel.getLimit());

        List<NeiKpi> neiKpis = neiService.getKpiAllInfo1(neiKpiSearchModel.getSearchText());
        return new PaginationResult(page.getTotal(), neiKpis);
    }

}
