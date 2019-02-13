package com.ygy.syh.controller;

import com.ygy.syh.domain.ChinaNd;
import com.ygy.syh.domain.Video;
import com.ygy.syh.service.SyhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能：项目控制器
 */
@Controller
@RequestMapping(value = "/")
public class SyhController {
    @Autowired
    private SyhService syhService;

    /**
     * 功能：进入首页
     */
    @RequestMapping(value = "toIndex", produces = {"application/json;charset=UTF-8"})
    public String toIndex(){
        return "index";
    }

    /**
     * 功能：进入第二屏
     */
    @RequestMapping(value = "toIndex2", produces = {"application/json;charset=UTF-8"})
    public String toIndex2(){
        return "index2";
    }

    /*
     *  功能：获取4G全国漫游到宁德的人流json数据
     */
    @ResponseBody
    @RequestMapping(value = "/getChinaToNdMap", produces = {"application/json;charset=UTF-8"})
    public Map<String,Object> getChinaToNdMap(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("2g",syhService.getChina2GToNdData());
        map.put("4g", syhService.getChina4GToNdData().get("china4gtond"));
        map.put("nowtime", syhService.getChina4GToNdData().get("nowtime"));
        return map;

    }


    /*
     *  功能：获取全省漫游到宁德的人流json数据
     */
    @ResponseBody
    @RequestMapping(value = "/getProvToNdMap", produces = {"application/json;charset=UTF-8"})
    public Map<String,Object> getProvToNdMap(){

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("2g",syhService.getProvince2GToNdData());
        map.put("4g", syhService.getProvince4GToNdData().get("province4gtond"));
        map.put("nowtime", syhService.getProvince4GToNdData().get("nowtime"));

        return map;
    }

    /*
     *  功能：获取风景区人流量数据
     */
    @ResponseBody
    @RequestMapping(value = "/getFengjinquData", produces = {"application/json;charset=UTF-8"})
    public Map<String,Object> getFengjinquData(){

        return syhService.getFengjinquData();
    }

    @ResponseBody
    @RequestMapping(value = "/getJiudianData", produces = {"application/json;charset=UTF-8"})
    public List<Integer> getJiudianData(){

        return syhService.getJiudianData();
    }


    /*
     *  功能：获取风景区人流量数据
     */
    @ResponseBody
    @RequestMapping(value = "/getBisaichangdiData", produces = {"application/json;charset=UTF-8"})
    public List<Map<String,Object>> getBisaichangdiData(){

        return syhService.getBisaichangdiData();
    }

    @ResponseBody
    @RequestMapping(value = "/getZdData", produces = {"application/json;charset=UTF-8"})
    public  List<Map<String,Object>> getZdData(){

        return syhService.getZdData();
    }

    @ResponseBody
    @RequestMapping(value = "/getTopData", produces = {"application/json;charset=UTF-8"})
    public  Map<String,Object> getTopData(){

        return syhService.getTopData();
    }


    @ResponseBody
    @RequestMapping(value = "/getVideoTopData", produces = {"application/json;charset=UTF-8"})
    public  Map<String,Object> getVideoTopData(){

        return syhService.getVideoTopData();
    }

    @ResponseBody
    @RequestMapping(value = "/getVideoCdData", produces = {"application/json;charset=UTF-8"})
    public  Map<String,Object> getVideoCdData(){

        return syhService.getVideoCdData();
    }

    @ResponseBody
    @RequestMapping(value = "/getVideoZdqyData", produces = {"application/json;charset=UTF-8"})
    public  List<Video> getVideoZdqyData(){

        return syhService.getVideoZdqyData();
    }

}
