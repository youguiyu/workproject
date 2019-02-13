/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.xngls.neiproj.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.xngls.neiproj.entity.NeiKpi;
import com.xngls.neiproj.entity.NeiValue;
import com.xngls.neiproj.service.NeiReportService;

import com.xngls.neiproj.util.ReportUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author liuzh
 * @since 2015-12-19 11:10
 */
@Controller
@RequestMapping(value = "neiexprot")
public class NeiReportController {

    @Autowired
    private NeiReportService neiReportService;


    @RequestMapping(value = "neikpi", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getNeiKpiList() throws Exception {
        // 调用业务逻辑,返回数据


        List<NeiKpi> typeList = neiReportService.getAllKpi();
        //PageInfo<City> pageInfo = new PageInfo<>(typeList);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(typeList);
    }


    @RequestMapping(value = "report", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    String getReportBydDate(@RequestBody Map<String,Object> reqMap) throws Exception {
        Map<String, Object> alldata= new HashMap<String, Object>();
       //String reqMap=request.getParameter("month")==null?null:request.getParameter("month").toString();
        int month=Integer.parseInt(reqMap.get("month").toString());
        //Integer month=Integer.parseInt(reqMap);
        Calendar cal =Calendar.getInstance();
        cal.set(Calendar.MONTH,month-1);
        Integer firstDate=cal.get(Calendar.YEAR)*10000+month*100+1;
        cal.add(Calendar.MONTH,1);
        cal.set(Calendar.DAY_OF_MONTH,0);
        Integer lastDate=cal.get(Calendar.YEAR)*10000+month*100+cal.get(Calendar.DAY_OF_MONTH);

        String[] styles = { "移动业务NEI", "家庭业务NEI", "政企业务NEI", "新业务NEI","全省指标"};
        for(int i=0;i<styles.length-1;i++){
            List<Map<String, Object>> result1=neiReportService.getReportBydDate(firstDate,lastDate,styles[i]);
            alldata.put(styles[i],result1);
        }

        List<Map<String, Object>> result5=neiReportService.getReportAllBydDate(firstDate,lastDate);
        alldata.put("全省指标",result5);

        ObjectMapper mapper = new ObjectMapper();
        JSONObject jsonAll=JSONObject.parseObject(mapper.writeValueAsString(alldata)) ;

        ReportUtil reportUtil=new ReportUtil(jsonAll,styles);

        JSONArray rtn=reportUtil.report();

        return rtn.toString();
    }

    @RequestMapping("/reportExcel")
    public void reportExcel(HttpServletRequest request, HttpServletResponse response, @RequestParam String month)throws IOException
    {
        Map<String, Object> alldata= new HashMap<String, Object>();
        int monthInt=Integer.parseInt(month);
        Calendar cal =Calendar.getInstance();
        cal.set(Calendar.MONTH,monthInt-1);
        Integer firstDate=cal.get(Calendar.YEAR)*10000+monthInt*100+1;
        cal.add(Calendar.MONTH,1);
        cal.set(Calendar.DAY_OF_MONTH,0);
        Integer lastDate=cal.get(Calendar.YEAR)*10000+monthInt*100+cal.get(Calendar.DAY_OF_MONTH);
        String[] styles = { "移动业务NEI", "家庭业务NEI", "政企业务NEI", "新业务NEI","全省指标"};
        for(int i=0;i<styles.length-1;i++){
            List<Map<String, Object>> result1=neiReportService.getReportBydDate(firstDate,lastDate,styles[i]);
            alldata.put(styles[i],result1);
        }
        List<Map<String, Object>> result5=neiReportService.getReportAllBydDate(firstDate,lastDate);
        alldata.put("全省指标",result5);
        ObjectMapper mapper = new ObjectMapper();
        JSONObject jsonAll=JSONObject.parseObject(mapper.writeValueAsString(alldata)) ;


        ReportUtil reportUtil=new ReportUtil(jsonAll,styles);

        JSONArray rtn=reportUtil.report();

        XSSFWorkbook workbook =reportUtil.getNeiReport(rtn.toString());
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=neiReport.xlsx");//默认Excel名称
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }

    @RequestMapping("/reportAll")
    public void reportAll(HttpServletRequest request, HttpServletResponse response, @RequestParam String month)throws IOException
    {

        try {
            List<NeiKpi> headerList=neiReportService.getAllKpi();
           // List<NeiKpi> headerList= new ArrayList<NeiKpi>();
            Map<String, Object> alldata= new HashMap<String, Object>();
            int monthInt=Integer.parseInt(month);
            Calendar cal =Calendar.getInstance();
            cal.set(Calendar.MONTH,monthInt-1);
            Integer firstDate=(cal.get(Calendar.YEAR)-1)*10000+monthInt*100;
            cal.add(Calendar.MONTH,1);
            cal.set(Calendar.DAY_OF_MONTH,0);
            System.out.println((cal.get(Calendar.YEAR)-1));
            Integer lastDate=(cal.get(Calendar.YEAR)-1)*10000+monthInt*100+cal.get(Calendar.DAY_OF_MONTH);

            ReportUtil reportUtil=new ReportUtil(null,null);
            List<Map<String, Object>> result=neiReportService.getAllBydDate(firstDate,lastDate);
            XSSFWorkbook workbook =reportUtil.exportAllData(headerList,result,monthInt);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=neiAll.xlsx");//默认Excel名称
            response.flushBuffer();
            workbook.write(response.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}
