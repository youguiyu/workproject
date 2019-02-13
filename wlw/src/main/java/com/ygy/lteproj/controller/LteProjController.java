package com.ygy.lteproj.controller;


import com.github.pagehelper.Page;
import com.ygy.lteproj.entity.AppCell;
import com.ygy.lteproj.entity.PageInfo;
import com.ygy.lteproj.entity.WlwApn;
import com.ygy.lteproj.model.TableModel;
import com.ygy.lteproj.service.LteDataService;
import com.ygy.lteproj.service.WlwApnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/lteproj")
public class LteProjController {

    @Autowired
    private LteDataService lteDataService;


    /**
     * 功能：进入首页
     */
    @RequestMapping(value = "/tolteIndex", produces = {"application/json;charset=UTF-8"})
    public String toIndex(){

        return "lteIndex";
    }

    @ResponseBody
    @RequestMapping(value = "/getAllLtePerformanceIndex", produces = {"application/json;charset=UTF-8"})
   public List<String>  getAllLtePerformanceIndex(String date){
        System.out.println(date);
        String name="data";
        String temp="aaaa";
        List<String> list = new ArrayList<>();
        list.add(name);
        list.add(temp);
        return list;
   }
    @ResponseBody
    @RequestMapping(value = "/getTableData", produces = {"application/json;charset=UTF-8"})
   public List<TableModel> getTableData(String dqDate){
       Map<String ,String> map = new HashMap<String ,String>();
       map.put("dqDate",dqDate);
       List<TableModel> tableData = lteDataService.getLteTableData(map);
       return tableData;
   }

    @ResponseBody
    @RequestMapping(value = "/getWeekData", produces = {"application/json;charset=UTF-8"})
    public List<Map<String,Object>> getWeekData(String dqDate,String zhibiao,String lidu){
        Map<String ,String> map = new HashMap<String ,String>();
        map.put("dqDate",dqDate);
        map.put("zhibiao",zhibiao);
        map.put("lidu",lidu);
        List<Map<String,Object>> tableData = lteDataService.getWeekData(map);
        return tableData;
    }

    /**
     * 功能：下传首页
     */
    @RequestMapping(value = "/tozhihcha", produces = {"application/json;charset=UTF-8"})
    public String tozhihcha(ModelMap model, String dqDate, String kpiName, String cityName){

        model.addAttribute("dqDate",dqDate);
        model.addAttribute("kpiName",kpiName);
        model.addAttribute("cityName",cityName);
        return "zhicha";
    }


    @ResponseBody
    @RequestMapping(value = "/getzhiChaTableData", produces = {"application/json;charset=UTF-8"})
    public PageInfo<AppCell> getzhiChaTableData(String dqDate, String cityName, String kpiName){
        Map<String ,String> map = new HashMap<String ,String>();
        map.put("dqDate",dqDate);
        map.put("cityName",cityName);
        map.put("kpiName",kpiName);
        //List<AppCell> tableData = lteDataService.getzhiChaTableData(map);
        List<AppCell> tableData= new ArrayList<AppCell>();
        Page<AppCell> appCells= lteDataService.findByPage(1,5,map);
        PageInfo<AppCell> pageInfo = new PageInfo<>(appCells);

        return pageInfo;
    }
}
