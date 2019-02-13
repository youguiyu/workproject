package com.ygy.worldcup.service.impl;

import com.ygy.worldcup.dao.VideoQsDao;
import com.ygy.worldcup.domain.VideoQs;
import com.ygy.worldcup.service.WorldCupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service(value = "worldcupService")
public class WorldCupServiceImpl implements WorldCupService{
    @Autowired
    private VideoQsDao videoQsDao;
    @Override
    public  List<Map<String,Object>> getNowData() {




        List<VideoQs> videoQss= videoQsDao.findlastTimeData();
        Map<String,Object> dataTemp = new HashMap<String,Object>();
        List<BigDecimal> CCTVVideo = new ArrayList<BigDecimal>();
        List<BigDecimal> miguVideo = new ArrayList<BigDecimal>();
        List<BigDecimal> youkuVideo = new ArrayList<BigDecimal>();

        for(int i=599;i>590;i--){
            for (VideoQs s:videoQss){
                if(s.getCity()==i && s.getAppSubClassName().equals("CCTV_Video")){
                    CCTVVideo.add(s.getSmoothPlayback());
                }else if(s.getCity()==i && s.getAppSubClassName().equals("咪咕视频")){
                    miguVideo.add(s.getSmoothPlayback());
                }else if(s.getCity()==i && s.getAppSubClassName().equals("优酷网")){
                    youkuVideo.add(s.getSmoothPlayback());
                }
            }

        }




        Map<String,Object> dataMap1 = new HashMap<String,Object>();
        dataMap1.put("name","CCTV_Video");
        dataMap1.put("type","bar");
        dataMap1.put("data",CCTVVideo);


        Map<String,Object> dataMap2 = new HashMap<String,Object>();
        dataMap2.put("name","咪咕视频");
        dataMap2.put("type","bar");
        dataMap2.put("data",miguVideo);

        Map<String,Object> dataMap3 = new HashMap<String,Object>();
        dataMap3.put("name","优酷网");
        dataMap3.put("type","bar");
        dataMap3.put("data",youkuVideo);

        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
        data.add(dataMap1);data.add(dataMap2);data.add(dataMap3);




        return data;
    }

    @Override
    public Map<String, Object> getHisData(int temp) {

        String maxTime = videoQsDao.getMaxTime();
        String minTime = getMinTime(temp,maxTime);

        Map<String , Object> map = new HashMap<String,Object>();
        map.put("minTime",minTime);
        map.put("maxTime",maxTime);

        Map<String,Object> data = new HashMap<String,Object>();
        List<VideoQs> allTimeObj=videoQsDao.getAllTime(map);
        List<String> allTime = new ArrayList<String>();
        for(VideoQs s: allTimeObj){
            allTime.add(s.getStartTime());
        }
        data.put("alltime",allTime);
        //获取所有的历史数据
        List<VideoQs> allVideoQs = videoQsDao.getAllHisData(map);

        Map<String,Object> CCTVMap = new HashMap<String,Object>();
        Map<String,Object> miguMap = new HashMap<String,Object>();
        Map<String,Object> youkuMap = new HashMap<String,Object>();

        for(int j=0; j<allTime.size(); j++){

            List<BigDecimal> CCTVVideo = new ArrayList<BigDecimal>();
            List<BigDecimal> miguVideo = new ArrayList<BigDecimal>();
            List<BigDecimal> youkuVideo = new ArrayList<BigDecimal>();
            for(int i=599;i>590;i--){
                for (VideoQs s:allVideoQs){
                    if(s.getStartTime().equals(allTime.get(j))){
                        if(s.getCity()==i && s.getAppSubClassName().equals("CCTV_Video")){
                            CCTVVideo.add(s.getSmoothPlayback());
                        }else if(s.getCity()==i && s.getAppSubClassName().equals("咪咕视频")){
                            miguVideo.add(s.getSmoothPlayback());
                        }else if(s.getCity()==i && s.getAppSubClassName().equals("优酷网")){
                            youkuVideo.add(s.getSmoothPlayback());
                        }
                    }

                }

            }

            CCTVMap.put(allTime.get(j),CCTVVideo);
            miguMap.put(allTime.get(j),miguVideo);
            youkuMap.put(allTime.get(j),youkuVideo);
        }

        data.put("CCTV",CCTVMap);
        data.put("migu",miguMap);
        data.put("youku",youkuMap);

        return data;
    }

    private String getMinTime(int temp, String maxTime) {
        String minTime ="";


        if (temp==1){

            Calendar cal = Calendar.getInstance();
            try {
                cal.setTime(new SimpleDateFormat("yyyyMMddHHmm").parse(maxTime));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.add(Calendar.HOUR_OF_DAY, -1);

            Date d = cal.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
            minTime=sdf.format(d);

        }else if(temp==2){

            Calendar cal = Calendar.getInstance();
            try {
                cal.setTime(new SimpleDateFormat("yyyyMMddHHmm").parse(maxTime));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.add(Calendar.DATE, -1);

            Date d = cal.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
            minTime=sdf.format(d);

        }else if(temp == 3){
            Calendar cal = Calendar.getInstance();
            try {
                cal.setTime(new SimpleDateFormat("yyyyMMddHHmm").parse(maxTime));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cal.add(Calendar.DATE, -3);

            Date d = cal.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
            minTime=sdf.format(d);
        }
        return minTime;
    }


}
