package com.ygy.wlwbound.service.impl;

import com.ygy.wlwbound.dao.WlwApnDingjieDao;

import com.ygy.wlwbound.dao.WlwEciDingjieDao;
import com.ygy.wlwbound.entity.*;
import com.ygy.wlwbound.model.PageModel;
import com.ygy.wlwbound.model.WlwApnDingjieModel;
import com.ygy.wlwbound.service.WlwBoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service(value = "wlwBoundService")
public class WlwBoundServiceImpl implements WlwBoundService {

    @Autowired
    private WlwApnDingjieDao wlwApnDingjieDao;

    @Autowired
    private WlwEciDingjieDao wlwEciDingjieDao;

    @Override
    public List<WlwApnDingjieModel> findByPage(int time) {
        Integer maxtime = wlwApnDingjieDao.findMaxTime();
        List<WlwApnDingjie> wlwApnDingjies = wlwApnDingjieDao.findWlwApnByTime(maxtime);
        List<WlwApnDingjieModel> wlwApnDingjiesmodels = new ArrayList<WlwApnDingjieModel>();
        for (WlwApnDingjie w :wlwApnDingjies){
            WlwApnDingjieModel wm = new WlwApnDingjieModel();
            wm.setDateId(w.getDateId());
            wm.setApn(w.getApn());
            wm.setName(w.getName());
            wm.setType(w.getType());
            wm.setUserCount(w.getUserCount());

            wm.setUserCountDingjieConclusion(w.getUserCountDingjieConclusion());
            wm.setFlow_dingjie_conclusion(w.getFlowDingjieConclusion());
            wm.setFlowKb(w.getFlowKb());
            Double d=0.0;
            if(w.getAttachCount()!=null){
               d =getTwoDecimal( w.getAttachCount().doubleValue()/10000);

            }

            if(w.getType().equals("2G")){
               // wm.setAttachCountRate(BigDecimal.ZERO);
                wm.setPdpCountRate(w.getAttachCountRate());

                wm.setAttachCountPDP(d);

            }else{
                wm.setAttachCountRate(w.getAttachCountRate());
                //wm.setPdpCountRate(BigDecimal.ZERO);
                wm.setAttachCount(d);
            }

            wm.setAttachSucRateDingjieConclusion(w.getAttachSucRateDingjieConclusion());
            wm.setPdpSucRateDingjieConclusion(w.getPdpSucRateDingjieConclusion());

            wlwApnDingjiesmodels.add(wm);

        }

        return wlwApnDingjiesmodels;
    }
    /**
     * 将数据保留两位小数
     */
    private double getTwoDecimal(double num) {
        DecimalFormat dFormat = new DecimalFormat("#.00");
        String yearString = dFormat.format(num);
        Double temp = Double.valueOf(yearString);
        return temp;
    }

    @Override
    public Integer getTime() {
        return  wlwApnDingjieDao.findMaxTime();
    }

    @Override
    public List<WlwApnDingjieModel> findByPage2(PageModel p) {

        List<WlwApnDingjie> wlwApnDingjies = wlwApnDingjieDao.findWlwApnByTime(p.getTimeselect());
        List<WlwApnDingjieModel> wlwApnDingjiesmodels = new ArrayList<WlwApnDingjieModel>();
        for (WlwApnDingjie w :wlwApnDingjies){
            WlwApnDingjieModel wm = new WlwApnDingjieModel();
            wm.setDateId(w.getDateId());
            wm.setApn(w.getApn());
            wm.setName(w.getName());
            wm.setType(w.getType());
            wm.setUserCount(w.getUserCount());

            wm.setUserCountDingjieConclusion(w.getUserCountDingjieConclusion());
            wm.setFlow_dingjie_conclusion(w.getFlowDingjieConclusion());
            wm.setFlowKb(w.getFlowKb());
            Double d=0.0;
            if(w.getAttachCount()!=null){
                d =getTwoDecimal( w.getAttachCount().doubleValue()/10000);

            }

            if(w.getType().equals("2G")){
                // wm.setAttachCountRate(BigDecimal.ZERO);
                wm.setPdpCountRate(w.getAttachCountRate());

                wm.setAttachCountPDP(d);

            }else{
                wm.setAttachCountRate(w.getAttachCountRate());
                //wm.setPdpCountRate(BigDecimal.ZERO);
                wm.setAttachCount(d);
            }

            wm.setAttachSucRateDingjieConclusion(w.getAttachSucRateDingjieConclusion());
            wm.setPdpSucRateDingjieConclusion(w.getPdpSucRateDingjieConclusion());

            wlwApnDingjiesmodels.add(wm);

        }

        return wlwApnDingjiesmodels;
    }

    @Override
    public List<WlwApnUsercountDingjie> getApnxiangxqingData(String apn, Integer dateId, String type) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("apn",apn);
        map.put("dateId",dateId);
        map.put("type",type);
        List<WlwApnUsercountDingjie> wlwApnUsercountDingjies =wlwApnDingjieDao.findApnBytiaojia(map);
        return wlwApnUsercountDingjies;
    }

    @Override
    public List<WlwApnFlowDingjie> getApnxiangxqingflowData(String apn, int dateId, String type) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("apn",apn);
        map.put("dateId",dateId);
        map.put("type",type);
        List<WlwApnFlowDingjie> wlwApnFlowDingjies =wlwApnDingjieDao.findApnBytiaojia2(map);
        return wlwApnFlowDingjies;
    }

    @Override
    public List<WlwApnAttachDingjie> getApnxiangxqingattachData(String apn, int dateId, String type) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("apn",apn);
        map.put("dateId",dateId);
        map.put("type",type);
        List<WlwApnAttachDingjie> wlwApnAttachDingjies =wlwApnDingjieDao.findApnBytiaojia3(map);
        return wlwApnAttachDingjies;
    }

    @Override
    public List<WlwApnPdpDingjie> getApnxiangxqingpdpData(String apn, int dateId, String type) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("apn",apn);
        map.put("dateId",dateId);
        map.put("type",type);
        List<WlwApnPdpDingjie> pdpDingjies =wlwApnDingjieDao.findApnBytiaojia4(map);
        return pdpDingjies;
    }

    @Override
    public List<Map<String, String>> getWarnApns(int temp) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        if(temp==1){
            map = getRangTime(1);
        }else {
            map = getRangTime(2);
        }
        List<WlwApnDingjie> UserCounts = wlwApnDingjieDao.findUserByTimeRange(map);
        List<WlwApnDingjie> flows = wlwApnDingjieDao.findFlowByTimeRange(map);
        List<WlwApnDingjie> attachs = wlwApnDingjieDao.findAttachByTimeRange(map);
        List<WlwApnDingjie> pdps = wlwApnDingjieDao.findPdpByTimeRange(map);
        for(WlwApnDingjie w:UserCounts){
            Map<String,String> map1=new HashMap<String,String>();
            map1.put("time",w.getDateId().toString());
            map1.put("apn",w.getApn());
            map1.put("name",w.getName());
            map1.put("content",w.getDateId().toString()+w.getName()+"("+w.getApn()+")日活用户数异常");
            map1.put("result",w.getUserCountDingjieConclusion());
            data.add(map1);
        }

        for(WlwApnDingjie w:flows){
            Map<String,String> map1=new HashMap<String,String>();
            map1.put("time",w.getDateId().toString());
            map1.put("apn",w.getApn());
            map1.put("name",w.getName());
            map1.put("content",w.getDateId().toString()+w.getName()+"("+w.getApn()+")业务流量异常");
            map1.put("result",w.getFlowDingjieConclusion());
            data.add(map1);
        }


        for(WlwApnDingjie w:attachs){
            Map<String,String> map1=new HashMap<String,String>();
            map1.put("time",w.getDateId().toString());
            map1.put("apn",w.getApn());
            map1.put("name",w.getName());
            map1.put("content",w.getDateId().toString()+w.getName()+"("+w.getApn()+")ATTACH成功率异常");
            map1.put("result",w.getAttachSucRateDingjieConclusion());
            data.add(map1);
        }


        for(WlwApnDingjie w:pdps){
            Map<String,String> map1=new HashMap<String,String>();
            map1.put("time",w.getDateId().toString());
            map1.put("apn",w.getApn());
            map1.put("name",w.getName());
            map1.put("content",w.getDateId().toString()+w.getName()+"("+w.getApn()+")PDP激活成功率异常");
            map1.put("result",w.getPdpSucRateDingjieConclusion());
            data.add(map1);
        }

        return data;
    }

    @Override
    public List<WlwEciDingjie> get4GTableData(PageModel pageModel) {
        Integer timeselect = pageModel.getTimeselect();
        return wlwEciDingjieDao.get4GTableData(timeselect) ;
    }

    @Override
    public Integer getZhichaTime() {
        return  wlwEciDingjieDao.findMaxTime();
    }

    @Override
    public List<WlwEciPdpDingjie> get2GTableData(PageModel pageModel) {
        Integer timeselect = pageModel.getTimeselect();
        return wlwEciDingjieDao.get2GTableData(timeselect) ;
    }

    @Override
    public WlwEci4gDingjie getZhicha4gData(int dateId, String cityName, long eci) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("dateId",dateId);
        map.put("cityName",cityName);
        map.put("eci",eci);

        return wlwEciDingjieDao.getZhicha4gData(map) ;
    }

    @Override
    public WlwEciPdp2gDingjie getZhicha2gData(int dateId, String cityName, int lac, int cid) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("dateId",dateId);
        map.put("cityName",cityName);
        map.put("lac",lac);
        map.put("cid",cid);
        return wlwEciDingjieDao.getZhicha2gData(map) ;
    }

    private Map<String, Integer> getRangTime(int i) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Calendar c = Calendar.getInstance();//日历
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");//格式工具
        Integer leftTime=Integer.parseInt(sdf.format(c.getTime()));
        if(i==1){
            c.add(Calendar.DAY_OF_MONTH, -7);//日期偏移,正数向前,负数向后!
        }else{
            c.add(Calendar.DAY_OF_MONTH, -30);//日期偏移,正数向前,负数向后!
        }


        Integer rightTime=Integer.parseInt(sdf.format(c.getTime()));
        map.put("timeLeft",rightTime);
        map.put("timeRight", leftTime);
        return map;
    }
}
