package com.ygy.syh.service.wlw.impl;

import com.ygy.syh.domain.wlw.*;
import com.ygy.syh.dao.wlw.*;
import com.ygy.syh.service.wlw.WlwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service(value = "wlwService")
public class WlwServiceImpl  implements WlwService{
    @Autowired
    private WlwCityMapper wlwCityMapper;

    @Autowired
    private WlwFieldMapper wlwFieldMapper;
    @Autowired
    private WlwKeyApnMapper wlwKeyApnMapper;
    @Autowired
    private WlwKqiFieldMapper wlwKqiFieldMapper;

    @Autowired
    private WlwLinkApnMapper wlwLinkApnMapper;
    @Autowired
    private WlwLinkCmiotMapper wlwLinkCmiotMapper;

    @Autowired
    private WlwLinkMaxMapper wlwLinkMaxMapper;
    @Autowired
    private TableStatusMapper tableStatusMapper;

    @Override
    public Map<String,Object> getZuoDaData(String temp) {
        Map<String,Object> zuoDaData = new HashMap<String,Object>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        //获取有数据的时间
        Integer num=-1;
        cal.add(Calendar.DATE,num);
        Integer yesDate=Integer.valueOf(sdf.format(cal.getTime()));
        for(;; ){
            List<TableStatus> tableStatuses = tableStatusMapper.findTableStatusByDate(yesDate);

          //  System.out.println(tableStatuses);
            if(tableStatuses.size()!=0){
                if(tableStatuses.get(0).getFlag()==0 ){
                    Calendar cal2 = Calendar.getInstance();
                    num--;
                    cal2.add(Calendar.DATE,num);
                    yesDate=Integer.valueOf(sdf.format(cal2.getTime()));
                }else{

                    break;
                }
            }else{
                Calendar cal3 = Calendar.getInstance();
                cal3.add(Calendar.DATE,num--);
                yesDate=Integer.valueOf(sdf.format(cal3.getTime()));
            }

        }
        //获取最近有数据的日期地市级所有指标数据
        List<WlwCity> wlwCities = wlwCityMapper.findWlwCityByDateId(yesDate);
        Map<String,Object> zuodaGuimoData = new HashMap<String,Object>();
        for(WlwCity c :wlwCities){
            zuodaGuimoData.put(c.getCityName(),c);
        }

        Calendar cal1 = Calendar.getInstance();
        //获取有数据时间前7天日期
        cal1.add(Calendar.DATE,num-7);
        Integer yesDate7= Integer.valueOf(sdf.format(cal1.getTime()));
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("yesDate",yesDate);
        map.put("yesDate7",yesDate7);
        //获取所有行业7天数据
        List<WlwField> wlwFields = wlwFieldMapper.findWlwFieldByWeek(map);

        //获取通用特征行业数据
        Map<String,Object> tyHyData = new HashMap<String,Object>();
        List<String> fiels =new ArrayList<String>();
        fiels.add("车联网");fiels.add("充电桩");fiels.add("电力");fiels.add("公安");fiels.add("公共交通");fiels.add("路灯");
        fiels.add("水务");fiels.add("银行");
        for(int i=0;i<fiels.size(); i++){
            for(WlwField w:wlwFields){
                if(w.getDateId().equals(yesDate)){
                    if (w.getField().equals(fiels.get(i))){
                        tyHyData.put(w.getField(),w);
                    }
                }
            }
        }

        //特色行业
        List<WlwKeyApn> wlwKeyApns = wlwKeyApnMapper.findWlwKeyApnsByDate(yesDate);

      //  List<Object> tsHyData =  new ArrayList<Object>();
        Map<String,Object> tsHyData = new HashMap<String,Object>();

        Map<String,String> map1 = new HashMap<String,String>();
        map1.put("FJEP.FJ","福建省电力（FJEP.FJ）");
        map1.put("FJGA.FJ","福建省公安（FJGA.FJ）");
        map1.put("FJMYGJ.FJ","福建省公共交通（FJMYGJ.FJ）");
        map1.put("FJSWGPRS.FJ","福建省水文局（FJSWGPRS.FJ）");
        map1.put("FJYL.FJ","福建省银联（FJYL.FJ）");

        for(WlwKeyApn w:wlwKeyApns){
            if(w.getDateId().equals(yesDate)){
                if (w.getApn().equals("CMIOT")){
                    tyHyData.put("CMIOT",w);
                }
                if(!w.getApn().equals("CMIOT")){
                    w.setApn(map1.get(w.getApn()));
                    tsHyData.put(w.getApn() ,w);
                }

            }

        }
        if(temp.equals("1")){
            zuoDaData=zuodaGuimoData;
        }else if(temp.equals("3")){
            zuoDaData=tyHyData;
        }else if(temp.equals("4")){
            zuoDaData=tsHyData;
        }


        return zuoDaData;
    }

    @Override
    public List<Map<String,Object>> getZuoDaLineData() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        //获取有数据的时间
        Integer num=-1;
        cal.add(Calendar.DATE,num);
        Integer yesDate=Integer.valueOf(sdf.format(cal.getTime()));
        Calendar cal1 = Calendar.getInstance();

        //获取有数据时间前7天日期
        cal1.add(Calendar.DATE,num-7);
        Integer yesDate7= Integer.valueOf(sdf.format(cal1.getTime()));
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("yesDate",yesDate);
        map.put("yesDate7",yesDate7);
        for(;; ){
            List<TableStatus> tableStatuses = tableStatusMapper.findTableStatusByDate(yesDate);

            //  System.out.println(tableStatuses);
            if(tableStatuses.size()!=0){
                if(tableStatuses.get(0).getFlag()==0 ){
                    Calendar cal2 = Calendar.getInstance();
                    num--;
                    cal2.add(Calendar.DATE,num);
                    yesDate=Integer.valueOf(sdf.format(cal2.getTime()));
                }else{

                    break;
                }
            }else{
                Calendar cal3 = Calendar.getInstance();
                cal3.add(Calendar.DATE,num--);
                yesDate=Integer.valueOf(sdf.format(cal3.getTime()));
            }

        }

        //获取所有行业7天数据
        List<WlwField> wlwFields = wlwFieldMapper.findWlwFieldByWeek(map);
        //创建折线图数据
       List<Map<String,Object>>  lineUserData = new ArrayList<Map<String,Object>>();
        List<Integer> dateData = getWeekDate(yesDate,num);
        Map<String,Object> xAis = new HashMap<String, Object>();
        xAis.put("xAis",dateData);
        lineUserData.add(xAis);
        List<String> legends = new ArrayList<String>();
        Map<String,Object> legend = new HashMap<String, Object>();
        for(WlwField w:wlwFields){
            if(w.getDateId().equals(yesDate)){
                if(!w.getField().equals("待定")){
                    legends.add(w.getField());
                }

            }
        }
        legend.put("legend",legends);

        lineUserData.add(legend);

        List<Object> series = new ArrayList<Object>();
        Map<String,Object> yAis = new HashMap<String, Object>();
        for(int j=0;j<legends.size(); j++){
            map.put("field",legends.get(j));
            List<WlwField> ws = wlwFieldMapper.findWlwFieldByWeekand(map);
            Map<String,Object> perseries = new HashMap<String,Object>();
            perseries.put("name",legends.get(j));
            perseries.put("type","line");
            List<Long> perserie = new ArrayList<Long>();
            for(WlwField w:ws){
                perserie.add(w.getUserCnt());
            }

            perseries.put("data",perserie);
            series.add(perseries);

        }

        yAis.put("yAis",series);

        lineUserData.add(yAis);

        return lineUserData;
    }

    @Override
    public Map<String, Object> getZuoyouData(String temp) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        //获取有数据的时间
        Integer num=-1;
        cal.add(Calendar.DATE,num);
        Integer yesDate=Integer.valueOf(sdf.format(cal.getTime()));
        Calendar cal1 = Calendar.getInstance();

        //获取有数据时间前7天日期
        cal1.add(Calendar.DATE,num-7);
        Integer yesDate7= Integer.valueOf(sdf.format(cal1.getTime()));
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("yesDate",yesDate);
        map.put("yesDate7",yesDate7);
        for(;; ){
            List<TableStatus> tableStatuses = tableStatusMapper.findTableStatusByDate(yesDate);

            //  System.out.println(tableStatuses);
            if(tableStatuses.size()!=0){
                if(tableStatuses.get(0).getFlag()==0 ){
                    Calendar cal2 = Calendar.getInstance();
                    num--;
                    cal2.add(Calendar.DATE,num);
                    yesDate=Integer.valueOf(sdf.format(cal2.getTime()));
                }else{

                    break;
                }
            }else{
                Calendar cal3 = Calendar.getInstance();
                cal3.add(Calendar.DATE,num--);
                yesDate=Integer.valueOf(sdf.format(cal3.getTime()));
            }

        }
        Map<String, Object> tsData = new HashMap<String,Object>();
        if(temp.equals("1")){
           List<WlwLinkApn> wkas= wlwLinkApnMapper.findWlwLinkApnByDate(yesDate);
           tsData.put("guimo",wkas);
           List<WlwLinkMax> ws = wlwLinkMaxMapper.findMaxData(yesDate);
           for(WlwLinkMax w:ws){
               tsData.put(w.getType(),w.getApn());
           }
        }else if(temp.equals("2")){
            List<WlwLinkCmiot> ws= wlwLinkCmiotMapper.findGaueData(yesDate);
            for(WlwLinkCmiot w :ws){
                tsData.put("userRate",w.getUserRate());
                tsData.put("xdrRate",w.getXdrRate());
                tsData.put("flowRate",w.getFlowRate());
            }
        }
        return tsData;
    }

    @Override
    public Map<String, Object> getZuoQiangData(String temp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        //获取有数据的时间
        Integer num=-1;
        cal.add(Calendar.DATE,num);
        Integer yesDate=Integer.valueOf(sdf.format(cal.getTime()));
        Calendar cal1 = Calendar.getInstance();

        //获取有数据时间前7天日期
        cal1.add(Calendar.DATE,num-7);
        Integer yesDate7= Integer.valueOf(sdf.format(cal1.getTime()));
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("yesDate",yesDate);
        map.put("yesDate7",yesDate7);
        for(;; ){
            List<TableStatus> tableStatuses = tableStatusMapper.findTableStatusByDate(yesDate);

            //  System.out.println(tableStatuses);
            if(tableStatuses.size()!=0){
                if(tableStatuses.get(0).getFlag()==0 ){
                    Calendar cal2 = Calendar.getInstance();
                    num--;
                    cal2.add(Calendar.DATE,num);
                    yesDate=Integer.valueOf(sdf.format(cal2.getTime()));
                }else{

                    break;
                }
            }else{
                Calendar cal3 = Calendar.getInstance();
                cal3.add(Calendar.DATE,num--);
                yesDate=Integer.valueOf(sdf.format(cal3.getTime()));
            }

        }

        Map<String, Object> tsData = new HashMap<String,Object>();

        List<WlwKqiField> ws = wlwKqiFieldMapper.findzuoyouData(yesDate);

        List<String> fiels =new ArrayList<String>();
        fiels.add("all");fiels.add("车联网");fiels.add("充电桩");fiels.add("电力");fiels.add("公安");fiels.add("公共交通");fiels.add("路灯");
        fiels.add("水务");fiels.add("银行"); fiels.add("通用");
        for(int i=0; i<fiels.size(); i++){
            for(WlwKqiField w :ws){
                if(fiels.get(i).equals(w.getField())){
                    tsData.put(fiels.get(i),w);
                }
            }
        }
        return tsData;
    }


    private List<Integer> getWeekDate(Integer yesDate, Integer num) {
        List<Integer> weekDate = new ArrayList<Integer>();
        num =num +1;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //获取有数据时间前7天日期
        for(int i=7;i>0;i--){
            Calendar cal1 = Calendar.getInstance();
            cal1.add(Calendar.DATE,num-i);
            Integer day1= Integer.valueOf(sdf.format(cal1.getTime()));
            weekDate.add(day1);
        }
        return weekDate;


    }


}
