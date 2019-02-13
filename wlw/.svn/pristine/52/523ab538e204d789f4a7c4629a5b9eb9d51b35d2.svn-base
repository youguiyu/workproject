package com.ygy.lteproj.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ygy.lteproj.entity.AppCell;
import com.ygy.lteproj.entity.CellCity;
import com.ygy.lteproj.entity.FWywjQs;
import com.ygy.lteproj.mapper.AppCellMapper;
import com.ygy.lteproj.mapper.CellCityMapper;
import com.ygy.lteproj.mapper.FWywjQsMapper;
import com.ygy.lteproj.model.TableModel;
import com.ygy.lteproj.service.LteDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.awt.FwDispatcher;

import java.math.BigDecimal;
import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.text.SimpleDateFormat;
import java.util.*;

@Service(value = "lteDataService")
public class LteDataServiceImpl implements LteDataService{
    @Autowired
    private CellCityMapper cellCityMapper;
    @Autowired
    private FWywjQsMapper fWywjQsMapper;

    @Autowired
    private AppCellMapper appCellMapper;

     public List<TableModel> getLteTableData(Map<String,String> map){
         Integer dqDate = Integer.valueOf(map.get("dqDate"));//
         Map<String,Object> map1 = new HashMap<String, Object>();
         map1.put("dateId", dqDate);
         map1.put("vendorName","全部厂家");

         List<CellCity> cellCitySt = cellCityMapper.getCellCityByDate(dqDate);
         List<FWywjQs> fWywjQsSt = fWywjQsMapper.getFWywjQsByDateAndVenderName(map1);
         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
         Calendar cal = Calendar.getInstance();
         if(cellCitySt.size()==0 || fWywjQsSt.size()==0){
             cal.add(Calendar.DATE,-2);
             dqDate=Integer.valueOf(sdf.format(cal.getTime()));
         }
         Map<String,Object> map2 = new HashMap<String, Object>();
         map2.put("dateId", dqDate);
         map2.put("vendorName","全部厂家");

          List<CellCity> cellCityS = cellCityMapper.getCellCityByDate(dqDate);
          List<FWywjQs> fWywjQsS = fWywjQsMapper.getFWywjQsByDateAndVenderName(map2);


          List<TableModel> list = new ArrayList<TableModel>();
          CellCity c1 = new CellCity();
          c1.setCityId(590);
          c1.setCityName("全省");
          c1.setKpi001(0);
         c1.setKpi002(0);
         c1.setKpi003(0);
         c1.setKpi004(0);
         c1.setKpi005(0);
         c1.setKpi006(0);
         c1.setKpi007(0);
         c1.setKpi008(0);
         c1.setKpi009(0);
         c1.setKpi010(0);
         c1.setKpi011(0);
         c1.setKpi012(0);
         c1.setKpi013(0);
         for(CellCity c:cellCityS){
              c1.setKpi001(c1.getKpi001()+c.getKpi001());
              c1.setKpi002(c1.getKpi002()+c.getKpi002());
              c1.setKpi003(c1.getKpi003()+c.getKpi003());
              c1.setKpi004(c1.getKpi004()+c.getKpi004());
              c1.setKpi005(c1.getKpi005()+c.getKpi005());
              c1.setKpi006(c1.getKpi006()+c.getKpi006());
              c1.setKpi007(c1.getKpi007()+c.getKpi007());
              c1.setKpi008(c1.getKpi008()+c.getKpi008());
              c1.setKpi009(c1.getKpi009()+c.getKpi009());
              c1.setKpi010(c1.getKpi010()+c.getKpi010());
              c1.setKpi011(c1.getKpi011()+c.getKpi011());
              c1.setKpi012(c1.getKpi012()+c.getKpi012());
              c1.setKpi013(c1.getKpi013()+c.getKpi013());

          }
         cellCityS.add(c1);

          for(CellCity c:cellCityS){
              TableModel t = new TableModel();
              t.setCityName(c.getCityName());
              t.setZcAttachSuc(c.getKpi001());
              t.setZcAttachDelay(c.getKpi002());
              t.setZcEpsSuc(c.getKpi003());
              t.setZcEpsDelay(c.getKpi004());
              t.setZcDnsSuc(c.getKpi005());
              t.setZcDnsDelay(c.getKpi006());
              t.setZcTcpHxSuc(c.getKpi007());
              t.setZcTcpHxDelay(c.getKpi008());
              t.setZcTcpwxSuc(c.getKpi009());
              t.setZcTcpWxDelay(c.getKpi010());
              t.setZcHttpSuc(c.getKpi011());
              t.setZcHttpDelay(c.getKpi012());
              t.setZcHttpLoad(c.getKpi013());

              list.add(t);
          }

         List<TableModel> tableD = new ArrayList<TableModel>();
          for(int i=0; i<fWywjQsS.size();i++){
              for(int j=0; j<list.size(); j++){
                  if(fWywjQsS.get(i).getCITY_NAME().equals(list.get(j).getCityName())){
                      list.get(j).setCityId(fWywjQsS.get(i).getCITY_ID());
                      list.get(j).setZbAttachSuc(fWywjQsS.get(i).getATTACH_SUCCESS_RATE());
                      list.get(j).setZbAttachDelay(fWywjQsS.get(i).getATTACH_DELAY());
                      list.get(j).setZbEpsSuc(fWywjQsS.get(i).getEPS_SUCCESS_RATE());
                      list.get(j).setZbEpsDelay(fWywjQsS.get(i).getEPS_DELAY());
                      list.get(j).setZbDnsSuc(fWywjQsS.get(i).getDNS_SUCCESS_RATE());
                      list.get(j).setZbDnsDelay(fWywjQsS.get(i).getDNS_DELAY());
                      list.get(j).setZbTcpHxSuc(fWywjQsS.get(i).getTCP_HX_SUCCESS());
                      list.get(j).setZbTcpHxDelay(fWywjQsS.get(i).getTCP_HX_DELAY());
                      list.get(j).setZbTcpWxSuc(fWywjQsS.get(i).getTCP_WX_SUCCESS());
                      list.get(j).setZbTcpWxDelay(fWywjQsS.get(i).getTCP_WX_DELAY());
                      list.get(j).setZbHttpSuc(fWywjQsS.get(i).getHTTP_YW_SUCCESS());
                      list.get(j).setZbHttpDelay(fWywjQsS.get(i).getHTTP_DELAY());
                      list.get(j).setZbHttpLoad(fWywjQsS.get(i).getHTTP_DOWN_RATE());
                      tableD.add(list.get(j));
                  }
              }
          }

        // List<TableModel> tableD2 = new ArrayList<TableModel>();
         Collections.sort(tableD);
          //System.out.println(tableD2.size());
         Collections.reverse(tableD);
         return tableD;

     }


     public List<Map<String,Object>> getWeekData(Map<String, String> map){
         List<Map<String,Object>> tableData = new ArrayList<Map<String,Object>>();
         String daDate= map.get("dqDate");
         Integer dqDate = Integer.valueOf(daDate);
         Integer rangeDate=0;
         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
         Calendar cal = Calendar.getInstance();
         Map<String,Object> map2 = new HashMap<String, Object>();
         map2.put("dateId", dqDate);
         map2.put("vendorName","全部厂家");
         List<CellCity> cellCitySt = cellCityMapper.getCellCityByDate(dqDate);
         List<FWywjQs> fWywjQsSt = fWywjQsMapper.getFWywjQsByDateAndVenderName(map2);

         if(cellCitySt.size()==0 || fWywjQsSt.size()==0){
             cal.add(Calendar.DATE,-2);
             dqDate=Integer.valueOf(sdf.format(cal.getTime()));
             Map<String,Object> m = new HashMap<String,Object>();
             m.put("datats",1);
             tableData.add(m);
         }else{
             Map<String,Object> m = new HashMap<String,Object>();
             m.put("datats",0);
             tableData.add(m);
         }

         List<Integer> dateData = new ArrayList<Integer>();

         //判断粒度
         if(map.get("lidu").equals("周")){

             try {
                 Date date=sdf.parse(daDate);
                 cal.setTime(date);
             } catch (ParseException e) {
                 e.printStackTrace();
             }

             cal.add(Calendar.DATE,-7);
             rangeDate=Integer.valueOf(sdf.format(cal.getTime()));

             String cityName ="全省";
             Map<String,Object> map1 = new HashMap<String, Object>();
             map1.put("dqDate",dqDate);
             map1.put("rangeDate",rangeDate);
             map1.put("cityName",cityName);
             List<FWywjQs> fs = fWywjQsMapper.getFWywjQsByliduaAndzhibiao(map1);


             List<BigDecimal> zhibiaoValue = new ArrayList<BigDecimal>();
             for(FWywjQs f :fs){
                 dateData.add(f.getDATE_ID());
             }


         }else if(map.get("lidu").equals("双周")){

             try {
                 Date date=sdf.parse(daDate);
                 cal.setTime(date);
             } catch (ParseException e) {
                 e.printStackTrace();
             }

             cal.add(Calendar.DATE,-14);
             rangeDate=Integer.valueOf(sdf.format(cal.getTime()));

             String cityName ="全省";
             Map<String,Object> map1 = new HashMap<String, Object>();
             map1.put("dqDate",dqDate);
             map1.put("rangeDate",rangeDate);
             map1.put("cityName",cityName);
             List<FWywjQs> fs = fWywjQsMapper.getFWywjQsByliduaAndzhibiao(map1);


             List<BigDecimal> zhibiaoValue = new ArrayList<BigDecimal>();
             for(FWywjQs f :fs){
                 dateData.add(f.getDATE_ID());
             }

         }else if(map.get("lidu").equals("月")){

             try {
                 Date date=sdf.parse(daDate);
                 cal.setTime(date);
             } catch (ParseException e) {
                 e.printStackTrace();
             }

             cal.add(Calendar.MONTH,-1);
             rangeDate=Integer.valueOf(sdf.format(cal.getTime()));

             String cityName ="全省";
             Map<String,Object> map1 = new HashMap<String, Object>();
             map1.put("dqDate",dqDate);
             map1.put("rangeDate",rangeDate);
             map1.put("cityName",cityName);
             List<FWywjQs> fs = fWywjQsMapper.getFWywjQsByliduaAndzhibiao(map1);


             List<BigDecimal> zhibiaoValue = new ArrayList<BigDecimal>();
             for(FWywjQs f :fs){
                 dateData.add(f.getDATE_ID());
             }

         }
         //判断指标
         String zhibiao = map.get("zhibiao");
         List<String> citys = new ArrayList<String>();
         citys.add("全省");citys.add("福州");citys.add("厦门");citys.add("宁德");citys.add("莆田");citys.add("泉州");citys.add("漳州");citys.add("龙岩");
         citys.add("三明");citys.add("南平");

         Map<String,Object> legend = new HashMap<String,Object>();
         legend.put("legendx",citys);


         tableData.add(legend);

         Map<String,Object> xdata = new HashMap<String,Object>();
         xdata.put("xData",dateData);

         tableData.add(xdata);


         if(zhibiao.equals("Attach成功率")){
             for(int i=0; i<citys.size(); i++){
                 String cityName = citys.get(i);
                 Map<String,Object> map1 = new HashMap<String, Object>();
                 map1.put("dqDate",dqDate);
                 map1.put("rangeDate",rangeDate);
                 map1.put("cityName",cityName);
                 List<FWywjQs> fs = fWywjQsMapper.getFWywjQsByliduaAndzhibiao(map1);

                 Map<String,Object> permap = new HashMap<String,Object>();
                 permap.put("name",cityName);
                 permap.put("type","line");
                 List<BigDecimal> zhibiaoValue = new ArrayList<BigDecimal>();
                 for(FWywjQs f :fs){
                     zhibiaoValue.add(f.getATTACH_SUCCESS_RATE());
                 }
                 permap.put("data",zhibiaoValue);

                 tableData.add(permap);

             }

         }else if (zhibiao.equals("Attach时延(ms)")){
             for(int i=0; i<citys.size(); i++){
                 String cityName = citys.get(i);
                 Map<String,Object> map1 = new HashMap<String, Object>();
                 map1.put("dqDate",dqDate);
                 map1.put("rangeDate",rangeDate);
                 map1.put("cityName",cityName);
                 List<FWywjQs> fs = fWywjQsMapper.getFWywjQsByliduaAndzhibiao(map1);

                 Map<String,Object> permap = new HashMap<String,Object>();
                 permap.put("name",cityName);
                 permap.put("type","line");

                 List<BigDecimal> zhibiaoValue = new ArrayList<BigDecimal>();
                 for(FWywjQs f :fs){
                     zhibiaoValue.add(f.getATTACH_DELAY());
                 }
                 permap.put("data",zhibiaoValue);

                 tableData.add(permap);

             }

         }else if(zhibiao.equals("EPS缺省承载建立成功率")){
             for(int i=0; i<citys.size(); i++){
                 String cityName = citys.get(i);
                 Map<String,Object> map1 = new HashMap<String, Object>();
                 map1.put("dqDate",dqDate);
                 map1.put("rangeDate",rangeDate);
                 map1.put("cityName",cityName);
                 List<FWywjQs> fs = fWywjQsMapper.getFWywjQsByliduaAndzhibiao(map1);

                 Map<String,Object> permap = new HashMap<String,Object>();
                 permap.put("name",cityName);
                 permap.put("type","line");

                 List<BigDecimal> zhibiaoValue = new ArrayList<BigDecimal>();
                 for(FWywjQs f :fs){
                     zhibiaoValue.add(f.getEPS_SUCCESS_RATE());
                 }
                 permap.put("data",zhibiaoValue);

                 tableData.add(permap);

             }
         }
         else if(zhibiao.equals("EPS缺省承载建立时延(ms)")){
             for(int i=0; i<citys.size(); i++){
                 String cityName = citys.get(i);
                 Map<String,Object> map1 = new HashMap<String, Object>();
                 map1.put("dqDate",dqDate);
                 map1.put("rangeDate",rangeDate);
                 map1.put("cityName",cityName);
                 List<FWywjQs> fs = fWywjQsMapper.getFWywjQsByliduaAndzhibiao(map1);

                 Map<String,Object> permap = new HashMap<String,Object>();
                 permap.put("name",cityName);
                 permap.put("type","line");

                 List<BigDecimal> zhibiaoValue = new ArrayList<BigDecimal>();
                 for(FWywjQs f :fs){
                     zhibiaoValue.add(f.getEPS_DELAY());
                 }
                 permap.put("data",zhibiaoValue);

                 tableData.add(permap);

             }
         }
         else if(zhibiao.equals("DNS查询成功率")){
             for(int i=0; i<citys.size(); i++){
                 String cityName = citys.get(i);
                 Map<String,Object> map1 = new HashMap<String, Object>();
                 map1.put("dqDate",dqDate);
                 map1.put("rangeDate",rangeDate);
                 map1.put("cityName",cityName);
                 List<FWywjQs> fs = fWywjQsMapper.getFWywjQsByliduaAndzhibiao(map1);

                 Map<String,Object> permap = new HashMap<String,Object>();
                 permap.put("name",cityName);
                 permap.put("type","line");

                 List<BigDecimal> zhibiaoValue = new ArrayList<BigDecimal>();
                 for(FWywjQs f :fs){
                     zhibiaoValue.add(f.getDNS_SUCCESS_RATE());
                 }
                 permap.put("data",zhibiaoValue);

                 tableData.add(permap);

             }
         }
         else if(zhibiao.equals("DNS查询时延(ms)")){
             for(int i=0; i<citys.size(); i++){
                 String cityName = citys.get(i);
                 Map<String,Object> map1 = new HashMap<String, Object>();
                 map1.put("dqDate",dqDate);
                 map1.put("rangeDate",rangeDate);
                 map1.put("cityName",cityName);
                 List<FWywjQs> fs = fWywjQsMapper.getFWywjQsByliduaAndzhibiao(map1);

                 Map<String,Object> permap = new HashMap<String,Object>();
                 permap.put("name",cityName);
                 permap.put("type","line");

                 List<BigDecimal> zhibiaoValue = new ArrayList<BigDecimal>();
                 for(FWywjQs f :fs){
                     zhibiaoValue.add(f.getDNS_DELAY());
                 }
                 permap.put("data",zhibiaoValue);

                 tableData.add(permap);

             }
         }
         else if(zhibiao.equals("TCP（核心）成功率")){
             for(int i=0; i<citys.size(); i++){
                 String cityName = citys.get(i);
                 Map<String,Object> map1 = new HashMap<String, Object>();
                 map1.put("dqDate",dqDate);
                 map1.put("rangeDate",rangeDate);
                 map1.put("cityName",cityName);
                 List<FWywjQs> fs = fWywjQsMapper.getFWywjQsByliduaAndzhibiao(map1);

                 Map<String,Object> permap = new HashMap<String,Object>();
                 permap.put("name",cityName);
                 permap.put("type","line");

                 List<BigDecimal> zhibiaoValue = new ArrayList<BigDecimal>();
                 for(FWywjQs f :fs){
                     zhibiaoValue.add(f.getTCP_HX_SUCCESS());
                 }
                 permap.put("data",zhibiaoValue);

                 tableData.add(permap);

             }
         }
         else if(zhibiao.equals("HTTP业务成功率")){
             for(int i=0; i<citys.size(); i++){
                 String cityName = citys.get(i);
                 Map<String,Object> map1 = new HashMap<String, Object>();
                 map1.put("dqDate",dqDate);
                 map1.put("rangeDate",rangeDate);
                 map1.put("cityName",cityName);
                 List<FWywjQs> fs = fWywjQsMapper.getFWywjQsByliduaAndzhibiao(map1);

                 Map<String,Object> permap = new HashMap<String,Object>();
                 permap.put("name",cityName);
                 permap.put("type","line");

                 List<BigDecimal> zhibiaoValue = new ArrayList<BigDecimal>();
                 for(FWywjQs f :fs){
                     zhibiaoValue.add(f.getHTTP_YW_SUCCESS());
                 }
                 permap.put("data",zhibiaoValue);

                 tableData.add(permap);

             }
         }
         else if(zhibiao.equals("TCP（核心）时延(ms)")){
             for(int i=0; i<citys.size(); i++){
                 String cityName = citys.get(i);
                 Map<String,Object> map1 = new HashMap<String, Object>();
                 map1.put("dqDate",dqDate);
                 map1.put("rangeDate",rangeDate);
                 map1.put("cityName",cityName);
                 List<FWywjQs> fs = fWywjQsMapper.getFWywjQsByliduaAndzhibiao(map1);

                 Map<String,Object> permap = new HashMap<String,Object>();
                 permap.put("name",cityName);
                 permap.put("type","line");

                 List<BigDecimal> zhibiaoValue = new ArrayList<BigDecimal>();
                 for(FWywjQs f :fs){
                     zhibiaoValue.add(f.getTCP_HX_DELAY());
                 }
                 permap.put("data",zhibiaoValue);

                 tableData.add(permap);

             }
         }
         else if(zhibiao.equals("TCP（无线）成功率")){
             for(int i=0; i<citys.size(); i++){
                 String cityName = citys.get(i);
                 Map<String,Object> map1 = new HashMap<String, Object>();
                 map1.put("dqDate",dqDate);
                 map1.put("rangeDate",rangeDate);
                 map1.put("cityName",cityName);
                 List<FWywjQs> fs = fWywjQsMapper.getFWywjQsByliduaAndzhibiao(map1);

                 Map<String,Object> permap = new HashMap<String,Object>();
                 permap.put("name",cityName);
                 permap.put("type","line");

                 List<BigDecimal> zhibiaoValue = new ArrayList<BigDecimal>();
                 for(FWywjQs f :fs){
                     zhibiaoValue.add(f.getTCP_WX_SUCCESS());
                 }
                 permap.put("data",zhibiaoValue);

                 tableData.add(permap);

             }
         }
         else if(zhibiao.equals("TCP（无线）时延(ms)")){
             for(int i=0; i<citys.size(); i++){
                 String cityName = citys.get(i);
                 Map<String,Object> map1 = new HashMap<String, Object>();
                 map1.put("dqDate",dqDate);
                 map1.put("rangeDate",rangeDate);
                 map1.put("cityName",cityName);
                 List<FWywjQs> fs = fWywjQsMapper.getFWywjQsByliduaAndzhibiao(map1);

                 Map<String,Object> permap = new HashMap<String,Object>();
                 permap.put("name",cityName);
                 permap.put("type","line");

                 List<BigDecimal> zhibiaoValue = new ArrayList<BigDecimal>();
                 for(FWywjQs f :fs){
                     zhibiaoValue.add(f.getTCP_WX_DELAY());
                 }
                 permap.put("data",zhibiaoValue);

                 tableData.add(permap);

             }
         }
         else if(zhibiao.equals("HTTP下载速率kbps")){
             for(int i=0; i<citys.size(); i++){
                 String cityName = citys.get(i);
                 Map<String,Object> map1 = new HashMap<String, Object>();
                 map1.put("dqDate",dqDate);
                 map1.put("rangeDate",rangeDate);
                 map1.put("cityName",cityName);
                 List<FWywjQs> fs = fWywjQsMapper.getFWywjQsByliduaAndzhibiao(map1);

                 Map<String,Object> permap = new HashMap<String,Object>();
                 permap.put("name",cityName);
                 permap.put("type","line");

                 List<BigDecimal> zhibiaoValue = new ArrayList<BigDecimal>();
                 for(FWywjQs f :fs){
                     zhibiaoValue.add(f.getHTTP_DOWN_RATE());
                 }
                 permap.put("data",zhibiaoValue);

                 tableData.add(permap);

             }
         }
         else if(zhibiao.equals("HTTP业务响应时延(ms)")){
             for(int i=0; i<citys.size(); i++){
                 String cityName = citys.get(i);
                 Map<String,Object> map1 = new HashMap<String, Object>();
                 map1.put("dqDate",dqDate);
                 map1.put("rangeDate",rangeDate);
                 map1.put("cityName",cityName);
                 List<FWywjQs> fs = fWywjQsMapper.getFWywjQsByliduaAndzhibiao(map1);

                 Map<String,Object> permap = new HashMap<String,Object>();
                 permap.put("name",cityName);
                 permap.put("type","line");

                 List<BigDecimal> zhibiaoValue = new ArrayList<BigDecimal>();
                 for(FWywjQs f :fs){
                     zhibiaoValue.add(f.getHTTP_DELAY());
                 }
                 permap.put("data",zhibiaoValue);

                 tableData.add(permap);

             }
         }











         return tableData;
     }


    @Override
    public Page<AppCell> findByPage(int pageNo, int pageSize,Map<String ,String> map) {
        PageHelper.startPage(pageNo, pageSize);
        List<AppCell> list = appCellMapper.findByPage2(map);
        return appCellMapper.findByPage(map);
    }



}
