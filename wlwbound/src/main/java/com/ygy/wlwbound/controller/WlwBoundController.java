package com.ygy.wlwbound.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ygy.wlwbound.entity.*;
import com.ygy.wlwbound.model.PageModel;
import com.ygy.wlwbound.model.WlwApnDingjieModel;

import com.ygy.wlwbound.service.WlwBoundService;
import com.ygy.wlwbound.util.PaginationResult;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/bound")
public class WlwBoundController {

    @Autowired
    private WlwBoundService wlwBoundService;
    /**
     * 功能：进入首页
     * @return
     */
    @RequestMapping(value = "/toIndex", produces = {"application/json;charset=UTF-8"})
    public  String toIndex(){
        return "index";
    }


    /**
     * 功能：进入物联网小区定界
     * @return
     */
    @RequestMapping(value = "/toIndex2", produces = {"application/json;charset=UTF-8"})
    public  String toIndex2(){
        return "index2";
    }

    /**
     * 功能：进入物联网小区定界
     * @return
     */
    @RequestMapping(value = "/to4Gxiangqing", produces = {"application/json;charset=UTF-8"})
    public  String to4Gxiangqing(ModelMap model,int dateId,String cityName,long eci){

        model.addAttribute("dateId",dateId);
        model.addAttribute("cityName",cityName);
        model.addAttribute("eci",eci);
        return "zhicha4g";
    }

    /**
     * 功能：进入物联网小区定界
     * @return
     */
    @RequestMapping(value = "/to2Gxiangqing", produces = {"application/json;charset=UTF-8"})
    public  String to2Gxiangqing(ModelMap model,int dateId,String cityName,long lac,long cid){

        model.addAttribute("dateId",dateId);
        model.addAttribute("cityName",cityName);
        model.addAttribute("cid",cid);
        model.addAttribute("lac",lac);
        return "zhicha2g";
    }

    @RequestMapping(value = "/toUserCount", produces = {"application/json;charset=UTF-8"})
    public  String toUserCount(ModelMap model,String apn,Integer dateId,String type,String name){

        model.addAttribute("apn",apn);
        model.addAttribute("dateId",dateId);
        model.addAttribute("type",type);
        model.addAttribute("name",name);

        return "usercount";
    }
    @RequestMapping(value = "/toFlow", produces = {"application/json;charset=UTF-8"})
    public  String toFlow(ModelMap model,String apn,Integer dateId,String type,String name){

        model.addAttribute("apn",apn);
        model.addAttribute("dateId",dateId);
        model.addAttribute("type",type);
        model.addAttribute("name",name);

        return "flow";
    }

    @RequestMapping(value = "/toAttach", produces = {"application/json;charset=UTF-8"})
    public  String toAttach(ModelMap model,String apn,Integer dateId,String type,String name){

        model.addAttribute("apn",apn);
        model.addAttribute("dateId",dateId);
        model.addAttribute("type",type);
        model.addAttribute("name",name);

        return "attach";
    }
    @RequestMapping(value = "/toPdp", produces = {"application/json;charset=UTF-8"})
    public  String toPdp(ModelMap model,String apn,Integer dateId,String type,String name){

        model.addAttribute("apn",apn);
        model.addAttribute("dateId",dateId);
        model.addAttribute("type",type);
        model.addAttribute("name",name);

        return "pdp";
    }



    @ResponseBody
    @RequestMapping(value = "/getTableData", produces = {"application/json;charset=UTF-8"})
    public List<WlwApnDingjieModel> getTableData( ){
       // PageHelper.startPage(p.getOffset(), p.getLimit());
       //Page<Object> page = PageHelper.offsetPage(p.getOffset(), p.getLimit());
        List<WlwApnDingjieModel> wlwApnDingjieModels = wlwBoundService.findByPage(1);

       // PageInfo<WlwApnDingjieModel> pageInfo = new PageInfo<WlwApnDingjieModel>(wlwApnDingjieModels);
        //return new PaginationResult(page.getTotal(), wlwApnDingjieModels);
        return wlwApnDingjieModels;
    }

    @ResponseBody
    @RequestMapping(value = "/getTime", produces = {"application/json;charset=UTF-8"})
    public Integer getTime(){
        Integer maxTime = wlwBoundService.getTime();
        return maxTime;
    }

    @ResponseBody
    @RequestMapping(value = "/updateTable", produces = {"application/json;charset=UTF-8"})
    public  List<WlwApnDingjieModel> updateTable(PageModel p ){
        // PageHelper.startPage(p.getOffset(), p.getLimit());
        //Page<Object> page = PageHelper.offsetPage(p.getOffset(), p.getLimit());
        List<WlwApnDingjieModel> wlwApnDingjieModels = wlwBoundService.findByPage2(p);

        // PageInfo<WlwApnDingjieModel> pageInfo = new PageInfo<WlwApnDingjieModel>(wlwApnDingjieModels);
        return  wlwApnDingjieModels;
    }

    @ResponseBody
    @RequestMapping(value = "/getApnxiangxqingData", produces = {"application/json;charset=UTF-8"})
    public List<WlwApnUsercountDingjie> getApnxiangxqingData(String apn, int dateId , String type){

           List<WlwApnUsercountDingjie> wlwApnUsercountDingjies = wlwBoundService.getApnxiangxqingData(apn,dateId,type);
           return wlwApnUsercountDingjies;
    }
    @ResponseBody
    @RequestMapping(value = "/getApnxiangxqingflowData", produces = {"application/json;charset=UTF-8"})
    public List<WlwApnFlowDingjie> getApnxiangxqingflowData(String apn, int dateId , String type){

        List<WlwApnFlowDingjie> wlwApnFlowDingjies = wlwBoundService.getApnxiangxqingflowData(apn,dateId,type);
        return wlwApnFlowDingjies;
    }
    @ResponseBody
    @RequestMapping(value = "/getApnxiangxqingattachData", produces = {"application/json;charset=UTF-8"})
    public List<WlwApnAttachDingjie> getApnxiangxqingattachData(String apn, int dateId , String type){

        List<WlwApnAttachDingjie> wlwApnAttachDingjies = wlwBoundService.getApnxiangxqingattachData(apn,dateId,type);
        return wlwApnAttachDingjies;
    }
    @ResponseBody
    @RequestMapping(value = "/getApnxiangxqingpdpData", produces = {"application/json;charset=UTF-8"})
    public List<WlwApnPdpDingjie> getApnxiangxqingpdpData(String apn, int dateId , String type){

        List<WlwApnPdpDingjie> wlwApnPdpDingjies = wlwBoundService.getApnxiangxqingpdpData(apn,dateId,type);
        return wlwApnPdpDingjies;
    }


    @ResponseBody
    @RequestMapping(value = "/getWarnApn", produces = {"application/json;charset=UTF-8"})
    public List<Map<String,String>> getWarnApn(int temp){

        List<Map<String,String>> warnApns = wlwBoundService.getWarnApns(temp);
        return warnApns;
    }
    @ResponseBody
    @RequestMapping(value = "/get4GTableData", produces = {"application/json;charset=UTF-8"})
    public PaginationResult get4GTableData(PageModel pageModel){

        Page<Object> page = PageHelper.offsetPage(pageModel.getOffset(), pageModel.getLimit());
        List<WlwEciDingjie> wlwEciDingjies = wlwBoundService.get4GTableData(pageModel);
        return new PaginationResult(page.getTotal(), wlwEciDingjies);
    }

    @ResponseBody
    @RequestMapping(value = "/getZhichaTime", produces = {"application/json;charset=UTF-8"})
    public Integer getZhichaTime(){
        Integer maxTime = wlwBoundService.getZhichaTime();
        return maxTime;
    }

    @ResponseBody
    @RequestMapping(value = "/get2GTableData", produces = {"application/json;charset=UTF-8"})
    public PaginationResult get2GTableData(PageModel pageModel){

        Page<Object> page = PageHelper.offsetPage(pageModel.getOffset(), pageModel.getLimit());
        List<WlwEciPdpDingjie> wlwEciPdpDingjies = wlwBoundService.get2GTableData(pageModel);
        return new PaginationResult(page.getTotal(), wlwEciPdpDingjies);
    }


    @ResponseBody
    @RequestMapping(value = "/getZhicha4gData", produces = {"application/json;charset=UTF-8"})
    public Map<String,Object> getZhicha4gData( String dateId , String cityName,String eci){
        Map<String,Object> map = new HashMap<String,Object>();
        if((!cityName.equals("")&&cityName!=null &&dateId !=null && eci!=null)){
            map.put("res","success");
            WlwEci4gDingjie wlwEci4gDingjie = wlwBoundService.getZhicha4gData(Integer.parseInt(dateId),cityName,Long.parseLong(eci));

            map.put("data",wlwEci4gDingjie);
        }else {
            map.put("result","fail");
        }

        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/getZhicha2gData", produces = {"application/json;charset=UTF-8"})
    public Map<String,Object> getZhicha2gData( String dateId , String cityName,String lac,String cid){
        Map<String,Object> map = new HashMap<String,Object>();
        if((!cityName.equals("")&&!dateId.equals("")&&!lac.equals("")&&!cid.equals("")
                &&cityName!=null &&dateId !=null && lac!=null && cid!=null)){
            map.put("res","success");
            WlwEciPdp2gDingjie wlwEciPdp2gDingjie = wlwBoundService.getZhicha2gData(Integer.parseInt(dateId),cityName,Integer.parseInt(lac),Integer.parseInt(cid));

            map.put("data",wlwEciPdp2gDingjie);
        }else {
            map.put("result","fail");
        }

        return map;
    }

    //创建Excel
    @RequestMapping("/createZhichaExcel")
    public String createZhichaExcel(HttpServletResponse response,PageModel pageModel,int temp) throws IOException {

        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
//        HSSFCellStyle cellStyle = wb.createCellStyle();
//        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        if(temp==0){

            List<WlwEciDingjie> wlwEciDingjies = wlwBoundService.get4GTableData(pageModel);
            //建立新的sheet对象（excel的表单）
            HSSFSheet sheet=wb.createSheet("4G");
            //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
            HSSFRow row1=sheet.createRow(0);
            //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
            HSSFCell cell=row1.createCell(0);
            //设置单元格内容
            cell.setCellValue(pageModel.getTimeselect()+"物联网4G小区质差表");
            //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
            sheet.addMergedRegion(new CellRangeAddress(0,0,0,13));

            HSSFRow row22=sheet.createRow(1);
            //创建单元格并设置单元格内容
            row22.createCell(0).setCellValue("地市");
            row22.createCell(1).setCellValue("区县");
            row22.createCell(2).setCellValue("小区名称");
            row22.createCell(3).setCellValue("室内/室外");
            row22.createCell(4).setCellValue("厂家");
            row22.createCell(5).setCellValue("覆盖场景");
            row22.createCell(6).setCellValue("ECI");
            row22.createCell(7).setCellValue("附着成功率（%）");
            row22.createCell(8).setCellValue("附着次数");
            row22.createCell(9).setCellValue("上周历史附着成功率（%）");
            row22.createCell(10).setCellValue("上周历史总附着次数");
            row22.createCell(11).setCellValue("该小区人网附着成功率（%）");
            row22.createCell(12).setCellValue("该小区人网附着次数");
            row22.createCell(13).setCellValue("定界结论");

            int k=2;
            for(WlwEciDingjie e :wlwEciDingjies){
                HSSFRow row2=sheet.createRow(k);
                //创建单元格并设置单元格内容
                row2.createCell(0).setCellValue(e.getCity_name()==null?"-":e.getCity_name()+"");
                row2.createCell(1).setCellValue(e.getCounty_name()==null?"-":e.getCounty_name()+"");
                row2.createCell(2).setCellValue(e.getCell_name()==null?"-":e.getCell_name()+"");
                row2.createCell(3).setCellValue(e.getHoneycomb_type()==null?"-":e.getHoneycomb_type()+"");
                row2.createCell(4).setCellValue(e.getVendor_name()==null?"-":e.getVendor_name()+"");
                row2.createCell(5).setCellValue(e.getWs_name()==null?"-":e.getWs_name()+"");
                row2.createCell(6).setCellValue(e.getEci()==0?"-":e.getEci()+"");
                row2.createCell(7).setCellValue(e.getAttach_suc_rate()==null?"-":e.getAttach_suc_rate().doubleValue()+"");
                row2.createCell(8).setCellValue(e.getAttach_count()==null?"-":e.getAttach_count()+"");
                row2.createCell(9).setCellValue(e.getAttach_suc_rate_reference()==null?"-":e.getAttach_suc_rate_reference().doubleValue()+"");
                row2.createCell(10).setCellValue(e.getAttach_count_reference()==null?"-":e.getAttach_count_reference()+"");
                row2.createCell(11).setCellValue(e.getAttach_succ_rate_4g()==null?"-":e.getAttach_succ_rate_4g().doubleValue()+"");
                row2.createCell(12).setCellValue(e.getAttach_cnt_4g()==null?"-":e.getAttach_cnt_4g()+"");
                row2.createCell(13).setCellValue(e.getResult_flag()==null?"-":e.getResult_flag()+"");
                k++;
            }


            //输出Excel文件
            OutputStream output=response.getOutputStream();
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename=4GTable.xls");
            response.setContentType("application/msexcel");
            //response.setContentType("application/csv");
            wb.write(output);
            output.close();
        }else{
            List<WlwEciPdpDingjie> wlwEciPdpDingjies = wlwBoundService.get2GTableData(pageModel);
            //建立新的sheet对象（excel的表单）
            HSSFSheet sheet=wb.createSheet("4G");
            //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
            HSSFRow row1=sheet.createRow(0);
            //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
            HSSFCell cell=row1.createCell(0);
            //设置单元格内容
            cell.setCellValue(pageModel.getTimeselect()+"物联网2G小区质差表");
            //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
            sheet.addMergedRegion(new CellRangeAddress(0,0,0,12));

            HSSFRow row22=sheet.createRow(1);
            //创建单元格并设置单元格内容
            row22.createCell(0).setCellValue("地市");
            row22.createCell(1).setCellValue("区县");
            row22.createCell(2).setCellValue("乡镇");
            row22.createCell(3).setCellValue("小区名称");
            row22.createCell(4).setCellValue("室内/室外");
            row22.createCell(5).setCellValue("覆盖场景");
            row22.createCell(6).setCellValue("LAC");
            row22.createCell(7).setCellValue("CI");
            row22.createCell(8).setCellValue("激活成功率（%）");
            row22.createCell(9).setCellValue("激活次数");
            row22.createCell(10).setCellValue("上周历史激活成功率（%）");
            row22.createCell(11).setCellValue("上周历史总激活次数");
            row22.createCell(12).setCellValue("定界结论");

            int k=2;
            for(WlwEciPdpDingjie e :wlwEciPdpDingjies){
                HSSFRow row2=sheet.createRow(k);
                //创建单元格并设置单元格内容
                row2.createCell(0).setCellValue(e.getCity_name()==null?"-":e.getCity_name()+"");
                row2.createCell(1).setCellValue(e.getCounty_name()==null?"-":e.getCounty_name()+"");
                row2.createCell(2).setCellValue(e.getTowns_name()==null?"-":e.getTowns_name()+"");
                row2.createCell(3).setCellValue(e.getCell_name()==null?"-":e.getCell_name()+"");
                row2.createCell(4).setCellValue(e.getOut_in_door()==null?"-":e.getOut_in_door()+"");
                row2.createCell(5).setCellValue(e.getWs_name()==null?"-":e.getWs_name()+"");
                row2.createCell(6).setCellValue(e.getLac()==0?"-":e.getLac()+"");
                row2.createCell(7).setCellValue(e.getCid()==0?"-":e.getCid()+"");
                row2.createCell(8).setCellValue(e.getPdp_suc_rate()==null?"-":e.getPdp_suc_rate().doubleValue()+"");
                row2.createCell(9).setCellValue(e.getPdp_count()==null?"-":e.getPdp_count()+"");
                row2.createCell(10).setCellValue(e.getPdp_suc_rate_reference()==null?"-":e.getPdp_suc_rate_reference().doubleValue()+"");
                row2.createCell(11).setCellValue(e.getPdp_count_reference()==null?"-":e.getPdp_count_reference()+"");
                row2.createCell(12).setCellValue(e.getResult_flag()==null?"-":e.getResult_flag());
                k++;
            }


            //输出Excel文件
            OutputStream output=response.getOutputStream();
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename=2GTable.xls");
            response.setContentType("application/msexcel");
            //response.setContentType("application/csv");
            wb.write(output);
            output.close();
        }

        return null;
    }

    //创建Excel
    @RequestMapping("/createzhongduanExcel")
    public String createzhongduanExcel(HttpServletResponse response,PageModel pageModel) throws IOException {

        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        List<WlwApnDingjieModel> wlwApnDingjieModels = wlwBoundService.findByPage(1);
       //建立新的sheet对象（excel的表单）
        HSSFSheet sheet=wb.createSheet("表一");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1=sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell=row1.createCell(0);
        //设置单元格内容
        cell.setCellValue(pageModel.getTimeselect()+"物联网重点行业APN表");
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,12));

        HSSFRow row22=sheet.createRow(1);
        //创建单元格并设置单元格内容
        row22.createCell(0).setCellValue("重点APN");
        row22.createCell(1).setCellValue("专网名称");
        row22.createCell(2).setCellValue("主要业务承载制式");
        row22.createCell(3).setCellValue("日活用户数");
        row22.createCell(4).setCellValue("日活用户数是否异常");
        row22.createCell(5).setCellValue("业务流量（GB）");
        row22.createCell(6).setCellValue("业务流量是否异常");
        row22.createCell(7).setCellValue("ATTACH成功率（%）");
        row22.createCell(8).setCellValue("附着次数(万)");
        row22.createCell(9).setCellValue("ATTACH成功率是否异常");
        row22.createCell(10).setCellValue("PDP激活成功率（%）");
        row22.createCell(11).setCellValue("激活次数(万)");
        row22.createCell(12).setCellValue("PDP激活成功率是否异常");

        int k=2;
        for(WlwApnDingjieModel e :wlwApnDingjieModels){
            HSSFRow row2=sheet.createRow(k);
            //创建单元格并设置单元格内容
            row2.createCell(0).setCellValue(e.getApn()==null?"-":e.getApn()+"");
            row2.createCell(1).setCellValue(e.getName()==null?"-":e.getName()+"");
            row2.createCell(2).setCellValue(e.getType()==null?"-":e.getType()+"");
            row2.createCell(3).setCellValue(e.getUserCount()==null?"-":e.getUserCount()+"");
            row2.createCell(4).setCellValue(e.getUserCountDingjieConclusion()=="专网运行正常"?"正常":"异常");
            row2.createCell(5).setCellValue(e.getFlowKb()==null?"-":e.getFlowKb()+"");
            row2.createCell(6).setCellValue(e.getFlow_dingjie_conclusion()=="专网运行正常"?"正常":"异常");
            row2.createCell(7).setCellValue(e.getType()=="2G"||e.getAttachCountRate()==null?"-":e.getAttachCountRate()+"");
            row2.createCell(8).setCellValue(e.getAttachCount()==null?"-":e.getAttachCount()+"");
            row2.createCell(9).setCellValue(e.getType()=="2G"||e.getAttachSucRateDingjieConclusion()==null?"-":e.getAttachSucRateDingjieConclusion());
            row2.createCell(10).setCellValue(e.getType()=="4G"||e.getPdpCountRate()==null?"-":e.getPdpCountRate()+"");
            row2.createCell(11).setCellValue(e.getAttachCountPDP()==null?"-":e.getAttachCountPDP()+"");
            row2.createCell(12).setCellValue(e.getType()=="4G"||e.getPdpSucRateDingjieConclusion()==null?"-":e.getPdpSucRateDingjieConclusion());
            k++;
        }


        //输出Excel文件
        OutputStream output=response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=apnTable.xls");
        response.setContentType("application/msexcel");
        //response.setContentType("application/csv");
        wb.write(output);
        output.close();

        return null;
    }

}
