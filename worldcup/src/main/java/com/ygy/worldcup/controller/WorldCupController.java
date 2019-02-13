package com.ygy.worldcup.controller;

import com.ygy.worldcup.domain.VideoQs;
import com.ygy.worldcup.service.WorldCupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/con")
public class WorldCupController {
    @Autowired
    private WorldCupService worldCupService;
    /**
     * 功能：进入首页
     * @return
     */
    @RequestMapping(value = "/toIndex", produces = {"application/json;charset=UTF-8"})
    public  String toIndex(){
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/getNowData", produces = {"application/json;charset=UTF-8"})
    public  List<Map<String,Object>> getNowData(){
        List<Map<String,Object>> data=worldCupService.getNowData();
        return data;
    }

    @ResponseBody
    @RequestMapping(value = "/getHisData", produces = {"application/json;charset=UTF-8"})
    public  Map<String,Object> getHisData(int temp){
        Map<String,Object> data=worldCupService.getHisData(temp);
        return data;
    }
}
