package com.ygy.syh.service.impl;

import com.ygy.syh.dao.cluster.VideoCellDao;
import com.ygy.syh.dao.master.ProvinceNdDao;
import com.ygy.syh.dao.master.ChinaNdDao;
import com.ygy.syh.domain.ChinaNd;
import com.ygy.syh.domain.ProvinceNd;
import com.ygy.syh.domain.TopCell;
import com.ygy.syh.domain.Video;
import com.ygy.syh.service.SyhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SyhServiceImpl implements SyhService {
    @Autowired
    private ChinaNdDao chinaNdDao;
    @Autowired
    private ProvinceNdDao provinceNdDao;

    @Autowired
    private VideoCellDao videoCellDao;


    @Override
    public Map<String,Object> getChina4GToNdData() {
//        String tableName="celluser_verbos_wwx_201809301020";
//
//        return chinaNdDao.queryBy4GTime(tableName);


        String tableName1="celluser_verbos_wwx_";
        String tableName="";
        int i=1;
        while(true){
            String temp = "'"+tableName1+getTenMinBefore(i)+"'";
            if(chinaNdDao.selectTableByName(temp)==null){
                i++;
            }else {
                tableName=tableName1+getTenMinBefore(i);
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("nowtime",getTenMinBefore(i));
                map.put("china4gtond",chinaNdDao.queryBy4GTime(tableName));
                return map;
            }
        }
    }

    @Override
    public List<ChinaNd> getChina2GToNdData() {
//        String tableName="celluser2g_verbos_wwx_201809301030";
//
//        return chinaNdDao.queryBy2GTime(tableName);

        String tableName1="celluser2g_verbos_wwx_";
        String tableName="";
        int i=1;
        while(true){
            String temp = "'"+tableName1+getTenMinBefore(i)+"'";
            if(chinaNdDao.selectTableByName(temp)==null){
                i++;
            }else {
                tableName=tableName1+getTenMinBefore(i);
                return chinaNdDao.queryBy2GTime(tableName);
            }
        }
    }

    @Override
    public List<ProvinceNd> getProvince2GToNdData() {

        String tableName1="celluser2g_verbos_wwx_";
        String tableName="";
        int i=1;
        while(true){
            String temp = "'"+tableName1+getTenMinBefore(i)+"'";
            if(chinaNdDao.selectTableByName(temp)==null){
                i++;
            }else {
                tableName=tableName1+getTenMinBefore(i);
                return provinceNdDao.queryBy2GTime(tableName);
            }
        }


    }

    @Override
    public Map<String,Object> getProvince4GToNdData() {
        String tableName1="celluser_verbos_wwx_";
        String tableName ="";
        int i=1;
        List<ProvinceNd> provinceNdList = new ArrayList<ProvinceNd>();

        while(true){
            String temp = "'"+tableName1+getTenMinBefore(i)+"'";
            if(chinaNdDao.selectTableByName(temp)==null){
                i++;
            }else {
                tableName=tableName1+getTenMinBefore(i);
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("nowtime",getTenMinBefore(i));
                map.put("province4gtond",provinceNdDao.queryBy4GTime(tableName));
                return map;
            }



        }

    }

    public Map<String, Object> getFengjinquData() {
        String tableName4g="celluser_verbos_wwx_";
        String tableName2g="celluser2g_verbos_wwx_";
        int i=1;
        String tableName4gz="";
        String tableName2gz="";
        while(true){
            String temp = "'"+tableName4g+getTenMinBefore(i)+"'";
            String temp1 = "'"+tableName2g+getTenMinBefore(i)+"'";
            if(chinaNdDao.selectTableByName(temp)==null||chinaNdDao.selectTableByName(temp1)==null){
                i++;
            }else {
                tableName4gz=tableName4g+getTenMinBefore(i);
                tableName2gz=tableName2g+getTenMinBefore(i);

                Integer tms2g = panisNull(chinaNdDao.selectTms2GUsercount(tableName2gz));
                Integer tms4g = panisNull(chinaNdDao.selectTms4GUsercount(tableName4gz));

                Integer bq2g= panisNull(chinaNdDao.selectBq2GUsercount(tableName2gz));
                Integer bq4g= panisNull(chinaNdDao.selectBq4GUsercount(tableName4gz));

                Integer bsy2g= panisNull(chinaNdDao.selectBsy2GUsercount(tableName2gz));
                Integer bsy4g= panisNull(chinaNdDao.selectBsy4GUsercount(tableName4gz));

                Integer cph2g= panisNull(chinaNdDao.selectCph2GUsercount(tableName2gz));
                Integer cph4g= panisNull(chinaNdDao.selectCph4GUsercount(tableName4gz));


                Integer dss2g= panisNull(chinaNdDao.selectDss2GUsercount(tableName2gz));
                Integer dss4g= panisNull(chinaNdDao.selectDss4GUsercount(tableName4gz));

                Integer lyx2g= panisNull(chinaNdDao.selectLyx2GUsercount(tableName2gz));
                Integer lyx4g= panisNull(chinaNdDao.selectLyx4GUsercount(tableName4gz));


                Map<String,Object> map = new HashMap<String,Object>();
                map.put("lyx2g",lyx2g);
                map.put("lyx4g",lyx4g);

                map.put("dss2g",dss2g);
                map.put("dss4g",dss4g);

                map.put("cph2g",cph2g);
                map.put("cph4g",cph4g);

                map.put("bsy2g",bsy2g);
                map.put("bsy4g",bsy4g);

                map.put("bq2g",bq2g);
                map.put("bq4g",bq4g);

                map.put("tms2g",tms2g);
                map.put("tms4g",tms4g);
                return map;
            }

        }

    }

    @Override
    public List<Integer> getJiudianData() {
        List<Integer> temp11 = new ArrayList<Integer>();

        String tableName4g="celluser_verbos_wwx_";
        String tableName2g="celluser2g_verbos_wwx_";
        int i=1;
        String tableName4gz="";
        String tableName2gz="";
        while(true){
            String temp = "'"+tableName4g+getTenMinBefore(i)+"'";
            String temp1 = "'"+tableName2g+getTenMinBefore(i)+"'";
            if(chinaNdDao.selectTableByName(temp)==null||chinaNdDao.selectTableByName(temp1)==null){
                i++;
            }else {
                tableName4gz=tableName4g+getTenMinBefore(i);
                tableName2gz=tableName2g+getTenMinBefore(i);
                temp11.add(panisNull(chinaNdDao.selectHedf2GUsercount(tableName2gz))+panisNull(chinaNdDao.selectHedf4GUsercount(tableName4gz)));
                temp11.add(panisNull(chinaNdDao.selectWdjh2GUsercount(tableName2gz))+panisNull(chinaNdDao.selectWdjh4GUsercount(tableName4gz)));
                temp11.add(panisNull(chinaNdDao.selectLqgj2GUsercount(tableName2gz))+panisNull(chinaNdDao.selectLqgj4GUsercount(tableName4gz)));
                temp11.add(panisNull(chinaNdDao.selectDh2GUsercount(tableName2gz))+panisNull(chinaNdDao.selectDh4GUsercount(tableName4gz)));
                temp11.add(panisNull(chinaNdDao.selectJy2GUsercount(tableName2gz))+panisNull(chinaNdDao.selectJy4GUsercount(tableName4gz)));
                temp11.add(panisNull(chinaNdDao.selectXbg2GUsercount(tableName2gz))+panisNull(chinaNdDao.selectXbg4GUsercount(tableName4gz)));
                temp11.add(panisNull(chinaNdDao.selectWh4GUsercount(tableName4gz)));
                temp11.add(panisNull(chinaNdDao.selectHt4GUsercount(tableName4gz)));
                temp11.add(panisNull(chinaNdDao.selectJjl4GUsercount(tableName4gz)));
                temp11.add(panisNull(chinaNdDao.selectGj4GUsercount(tableName4gz)));
                temp11.add(panisNull(chinaNdDao.selectHwj4GUsercount(tableName4gz)));
                temp11.add(panisNull(chinaNdDao.selectJhw4GUsercount(tableName4gz)));
                temp11.add(panisNull(chinaNdDao.selectMl4GUsercount(tableName4gz)));
                temp11.add(panisNull(chinaNdDao.selectMd4GUsercount(tableName4gz)));
                temp11.add(panisNull(chinaNdDao.selectSda4GUsercount(tableName4gz)));
                temp11.add(panisNull(chinaNdDao.selectTwt4GUsercount(tableName4gz)));
                temp11.add(panisNull(chinaNdDao.selectCx4GUsercount(tableName4gz)));
                temp11.add(panisNull(chinaNdDao.selectDj4GUsercount(tableName4gz)));
                return temp11;
            }
        }

    }

    private Integer panisNull(Integer a){
        return a==null ?0:a;
    }
    @Override
    public List<Map<String,Object>> getBisaichangdiData() {
        List<Map<String,Object>> temp11 = new ArrayList<Map<String,Object>>();

        String tableName4g="celluser_verbos_wwx_";
        String tableName2g="celluser2g_verbos_wwx_";
        int i=1;
        String tableName4gz="";
        String tableName2gz="";
        while(true){
            String temp = "'"+tableName4g+getTenMinBefore(i)+"'";
            String temp1 = "'"+tableName2g+getTenMinBefore(i)+"'";
            if(chinaNdDao.selectTableByName(temp)==null||chinaNdDao.selectTableByName(temp1)==null){
                i++;
            }else {
                tableName4gz=tableName4g+getTenMinBefore(i);
                tableName2gz=tableName2g+getTenMinBefore(i);
                Map<String,Object> map1=new HashMap<String,Object>();
                map1.put("name","福安奥体中心");
                map1.put("value",panisNull(chinaNdDao.selectFaat2GUsercount(tableName2gz))+panisNull(chinaNdDao.selectFaat4GUsercount(tableName4gz)));
                temp11.add(map1);

                Map<String,Object> map2=new HashMap<String,Object>();
                map2.put("name","福安市体育中心");
                map2.put("value",panisNull(chinaNdDao.selectFatyc2GUsercount(tableName2gz))+panisNull(chinaNdDao.selectFatyc4GUsercount(tableName4gz)));
                temp11.add(map2);


                Map<String,Object> map3=new HashMap<String,Object>();
                map3.put("name","福安一中溪北洋校区");
                map3.put("value",panisNull(chinaNdDao.selectFayz2GUsercount(tableName2gz))+panisNull(chinaNdDao.selectFayz4GUsercount(tableName4gz)));
                temp11.add(map3);

                Map<String,Object> map4=new HashMap<String,Object>();
                map4.put("name","福鼎羽毛球馆");
                map4.put("value",panisNull(chinaNdDao.selectFdymq2GUsercount(tableName2gz))+panisNull(chinaNdDao.selectFdymq4GUsercount(tableName4gz)));
                temp11.add(map4);

                Map<String,Object> map5=new HashMap<String,Object>();
                map5.put("name","古田翠屏湖水上运动中心");
                map5.put("value",panisNull(chinaNdDao.selectGtcphs2GUsercount(tableName2gz))+panisNull(chinaNdDao.selectGtcphs4GUsercount(tableName4gz)));
                temp11.add(map5);


                Map<String,Object> map6=new HashMap<String,Object>();
                map6.put("name","宁德市体育中心");
                map6.put("value",panisNull(chinaNdDao.selectNdtyzx2GUsercount(tableName2gz))+panisNull(chinaNdDao.selectNdtyzx4GUsercount(tableName4gz)));
                temp11.add(map6);



                Map<String,Object> map7=new HashMap<String,Object>();
                map7.put("name","宁德新师院");
                map7.put("value",panisNull(chinaNdDao.selectNdtyzx2GUsercount(tableName2gz))+panisNull(chinaNdDao.selectNdtyzx4GUsercount(tableName4gz)));
                temp11.add(map7);

                Map<String,Object> map8=new HashMap<String,Object>();
                map8.put("name","宁德新师院");
                map8.put("value",panisNull(chinaNdDao.selectNdxsy2GUsercount(tableName2gz))+panisNull(chinaNdDao.selectNdxsy4GUsercount(tableName4gz)));
                temp11.add(map8);

                Map<String,Object> map9=new HashMap<String,Object>();
                map9.put("name","宁德新五中");
                map9.put("value",panisNull(chinaNdDao.selectNdwz2GUsercount(tableName2gz))+panisNull(chinaNdDao.selectNdwz4GUsercount(tableName4gz)));
                temp11.add(map9);


                Map<String,Object> map10=new HashMap<String,Object>();
                map10.put("name","屏南县白玉村皮划艇训练基地");
                map10.put("value",panisNull(chinaNdDao.selectPnbyc4GUsercount(tableName4gz)));
                temp11.add(map10);


                Map<String,Object> map11=new HashMap<String,Object>();
                map11.put("name","屏南县一中新校区体育馆");
                map11.put("value",panisNull(chinaNdDao.selectPnxyz4GUsercount(tableName4gz)));
                temp11.add(map11);


                Map<String,Object> map12=new HashMap<String,Object>();
                map12.put("name","寿宁体育馆");
                map12.put("value",panisNull(chinaNdDao.selectSntyg2GUsercount(tableName2gz))+panisNull(chinaNdDao.selectSntyg4GUsercount(tableName4gz)));
                temp11.add(map12);

                Map<String,Object> map13=new HashMap<String,Object>();
                map13.put("name","霞浦高罗沙滩");
                map13.put("value",panisNull(chinaNdDao.selectXpglst4GUsercount(tableName4gz)));
                temp11.add(map13);

                Map<String,Object> map14=new HashMap<String,Object>();
                map14.put("name","霞浦沙滩排球馆");
                map14.put("value",panisNull(chinaNdDao.selectXppqg4GUsercount(tableName4gz)));
                temp11.add(map14);

                Map<String,Object> map15=new HashMap<String,Object>();
                map15.put("name","霞浦游泳馆");
                map15.put("value",panisNull(chinaNdDao.selectXpyyg4GUsercount(tableName4gz)));
                temp11.add(map15);


                Map<String,Object> map16=new HashMap<String,Object>();
                map16.put("name","柘荣县体育中心");
                map16.put("value",panisNull(chinaNdDao.selectZrtyg2GUsercount(tableName2gz))+panisNull(chinaNdDao.selectZrtyg4GUsercount(tableName4gz)));
                temp11.add(map16);

                Map<String,Object> map17=new HashMap<String,Object>();
                map17.put("name","周宁县体育馆");
                map17.put("value",panisNull(chinaNdDao.selectZntyg2GUsercount(tableName2gz))+panisNull(chinaNdDao.selectZntyg4GUsercount(tableName4gz)));
                temp11.add(map17);




                return temp11;
            }
        }
    }

    @Override
    public  List<Map<String,Object>> getZdData() {
        List<Map<String,Object>> temp11 = new ArrayList<Map<String,Object>>();

        String tableName4g="celluser_verbos_wwx_";
        String tableName2g="celluser2g_verbos_wwx_";
        int i=1;
        String tableName4gz="";
        String tableName2gz="";
        while(true){
            String temp = "'"+tableName4g+getTenMinBefore(i)+"'";
            String temp1 = "'"+tableName2g+getTenMinBefore(i)+"'";
            if(chinaNdDao.selectTableByName(temp)==null||chinaNdDao.selectTableByName(temp1)==null){
                i++;
            }else {
                tableName4gz=tableName4g+getTenMinBefore(i);
                tableName2gz=tableName2g+getTenMinBefore(i);
                Map<String,Object> map1=new HashMap<String,Object>();
                map1.put("bz2g",panisNull(chinaNdDao.selectNdqcbz2GUsercount(tableName2gz)));
                map1.put("bz4g",panisNull(chinaNdDao.selectNdqcbz4GUsercount(tableName4gz)));
                temp11.add(map1);

                Map<String,Object> map2=new HashMap<String,Object>();
                map2.put("nz2g",panisNull(chinaNdDao.selectNdqcnz2GUsercount(tableName2gz)));
                map2.put("nz4g",panisNull(chinaNdDao.selectNdqcnz4GUsercount(tableName4gz)));
                temp11.add(map2);

                Map<String,Object> map3=new HashMap<String,Object>();
                map3.put("ndz2g",panisNull(chinaNdDao.selectNdz2GUsercount(tableName2gz)));
                map3.put("ndz4g",panisNull(chinaNdDao.selectNdz4GUsercount(tableName4gz)));
                temp11.add(map3);

                Map<String,Object> map4=new HashMap<String,Object>();
                map4.put("bx2g",panisNull(chinaNdDao.selectNdbx2GUsercount(tableName2gz)));
                map4.put("bx4g",panisNull(chinaNdDao.selectNdbx4GUsercount(tableName4gz)));
                temp11.add(map4);

                Map<String,Object> map5=new HashMap<String,Object>();
                map5.put("wd2g",panisNull(chinaNdDao.selectNdwd2GUsercount(tableName2gz)));
                map5.put("wd4g",panisNull(chinaNdDao.selectNdwd4GUsercount(tableName4gz)));
                temp11.add(map5);

                return temp11;
            }
        }
    }

    @Override
    public Map<String, Object> getTopData() {
        Map<String, Object> map = new HashMap<String,Object>();
        String tableName4g="celluser_verbos_wwx_";
        String tableName2g="celluser2g_verbos_wwx_";
        int i=1;
        String tableName4gz="";
        String tableName2gz="";
        while(true){
            String temp = "'"+tableName4g+getTenMinBefore(i)+"'";
            String temp1 = "'"+tableName2g+getTenMinBefore(i)+"'";
            if(chinaNdDao.selectTableByName(temp)==null||chinaNdDao.selectTableByName(temp1)==null){
                i++;
            }else {

                tableName4gz=tableName4g+getTenMinBefore(i);
                tableName2gz=tableName2g+getTenMinBefore(i);
                List<TopCell> top = chinaNdDao.selectTop5xiaoqu4G(tableName4gz);
                List<TopCell> low = chinaNdDao.selectLow5xiaoqu4G(tableName4gz);
                map.put("top",top);
                map.put("low",low);
                return map;

            }
        }

    }

    @Override
    public Map<String, Object> getVideoTopData() {

        Map<String, Object> map = new HashMap<String,Object>();
        String tableNameVideo="video";
        int i=1;
        String tableNameVideoz="";
        while(true){
            String temp = "'"+tableNameVideo+getDayBefore(i)+"'";
            if(videoCellDao.selectTableByName(temp)==null){
                i++;
            }else {

                tableNameVideoz=tableNameVideo+getDayBefore(i);
                map.put("userTop",videoCellDao.queryByVideoUser(tableNameVideoz));
                map.put("flowTop",videoCellDao.queryByVideoFlow(tableNameVideoz));
                map.put("waitTop",videoCellDao.queryByVideoWait(tableNameVideoz).subList(0,5));
                return map;
            }
        }

    }

    @Override
    public Map<String, Object> getVideoCdData() {
        Map<String, Object> map = new HashMap<String,Object>();
        String tableNameVideo="video";
        int i=1;
        String tableNameVideoz="";
        while(true){
            String temp = "'"+tableNameVideo+getDayBefore(i)+"'";
            if(videoCellDao.selectTableByName(temp)==null){
                i++;
            }else {

                tableNameVideoz=tableNameVideo+getDayBefore(i);
                Video faat= videoCellDao.queryByVideoFaat(tableNameVideoz);
                Video fatyg= videoCellDao.queryByVideoFatyg(tableNameVideoz);
                Video fayz= videoCellDao.queryByVideoFayz(tableNameVideoz);
                Video fdymq= videoCellDao.queryByVideoFdymqg(tableNameVideoz);
                Video Gtcphs= videoCellDao.queryByVideoGtcphs(tableNameVideoz);
                Video Ndtyzx= videoCellDao.queryByVideoNdtyzx(tableNameVideoz);
                Video Ndxsy=videoCellDao.queryByVideoNdxsy(tableNameVideoz);
                Video Ndwz=videoCellDao.queryByVideoNdwz(tableNameVideoz);
                Video Pnbyc=videoCellDao.queryByVideoPnbyc(tableNameVideoz);
                Video Pnyz=videoCellDao.queryByVideoPnyz(tableNameVideoz);
                Video Sntyg=videoCellDao.queryByVideoSntyg(tableNameVideoz);
                Video Xpglst=videoCellDao.queryByVideoXpglst(tableNameVideoz);
                Video Xpstpqg=videoCellDao.queryByVideoXpstpqg(tableNameVideoz);
                Video Xpyyg=videoCellDao.queryByVideoXpyyg(tableNameVideoz);
                Video Zrtyg=videoCellDao.queryByVideoZrtyg(tableNameVideoz);
                Video Zntyg=videoCellDao.queryByVideoZntyg(tableNameVideoz);
                List<BigDecimal> v= new ArrayList<BigDecimal>();
                List<BigDecimal> v3= new ArrayList<BigDecimal>();
                List<Long> v2= new ArrayList<Long>();
                v2.add(faat.getImsiCnt());v2.add(fatyg.getImsiCnt());v2.add(fayz.getImsiCnt());
                v2.add(fdymq.getImsiCnt());v2.add(Gtcphs.getImsiCnt());v2.add(Ndtyzx.getImsiCnt());
                v2.add(Ndxsy.getImsiCnt());v2.add(Ndwz.getImsiCnt());v2.add(Pnbyc.getImsiCnt());
                v2.add(Pnyz.getImsiCnt());v2.add(Sntyg.getImsiCnt());v2.add(Xpglst.getImsiCnt());
                v2.add(Xpstpqg.getImsiCnt());v2.add(Xpyyg.getImsiCnt());v2.add(Zrtyg.getImsiCnt());
                v2.add(Zntyg.getImsiCnt());

                v.add(faat.getTotalFlow().setScale(2,BigDecimal.ROUND_HALF_UP));v.add(fatyg.getTotalFlow().setScale(2,BigDecimal.ROUND_HALF_UP));v.add(fayz.getTotalFlow().setScale(2,BigDecimal.ROUND_HALF_UP));
                v.add(fdymq.getTotalFlow().setScale(2,BigDecimal.ROUND_HALF_UP));v.add(Gtcphs.getTotalFlow().setScale(2,BigDecimal.ROUND_HALF_UP));v.add(Ndtyzx.getTotalFlow().setScale(2,BigDecimal.ROUND_HALF_UP));
                v.add(Ndxsy.getTotalFlow().setScale(2,BigDecimal.ROUND_HALF_UP));v.add(Ndwz.getTotalFlow().setScale(2,BigDecimal.ROUND_HALF_UP));v.add(Pnbyc.getTotalFlow().setScale(2,BigDecimal.ROUND_HALF_UP));
                v.add(Pnyz.getTotalFlow().setScale(2,BigDecimal.ROUND_HALF_UP));v.add(Sntyg.getTotalFlow().setScale(2,BigDecimal.ROUND_HALF_UP));v.add(Xpglst.getTotalFlow().setScale(2,BigDecimal.ROUND_HALF_UP));
                v.add(Xpstpqg.getTotalFlow().setScale(2,BigDecimal.ROUND_HALF_UP));v.add(Xpyyg.getTotalFlow().setScale(2,BigDecimal.ROUND_HALF_UP));v.add(Zrtyg.getTotalFlow().setScale(2,BigDecimal.ROUND_HALF_UP));
                v.add(Zntyg.getTotalFlow().setScale(2,BigDecimal.ROUND_HALF_UP));


                v3.add(faat.getAvgthrouputdl().setScale(2,BigDecimal.ROUND_HALF_UP));v3.add(fatyg.getAvgthrouputdl().setScale(2,BigDecimal.ROUND_HALF_UP));v3.add(fayz.getAvgthrouputdl().setScale(2,BigDecimal.ROUND_HALF_UP));
                v3.add(fdymq.getAvgthrouputdl().setScale(2,BigDecimal.ROUND_HALF_UP));v3.add(Gtcphs.getAvgthrouputdl().setScale(2,BigDecimal.ROUND_HALF_UP));v3.add(Ndtyzx.getAvgthrouputdl().setScale(2,BigDecimal.ROUND_HALF_UP));
                v3.add(Ndxsy.getAvgthrouputdl().setScale(2,BigDecimal.ROUND_HALF_UP));v3.add(Ndwz.getAvgthrouputdl().setScale(2,BigDecimal.ROUND_HALF_UP));v3.add(Pnbyc.getAvgthrouputdl().setScale(2,BigDecimal.ROUND_HALF_UP));
                v3.add(Pnyz.getAvgthrouputdl().setScale(2,BigDecimal.ROUND_HALF_UP));v3.add(Sntyg.getAvgthrouputdl().setScale(2,BigDecimal.ROUND_HALF_UP));v3.add(Xpglst.getAvgthrouputdl().setScale(2,BigDecimal.ROUND_HALF_UP));
                v3.add(Xpstpqg.getAvgthrouputdl().setScale(2,BigDecimal.ROUND_HALF_UP));v3.add(Xpyyg.getAvgthrouputdl().setScale(2,BigDecimal.ROUND_HALF_UP));v3.add(Zrtyg.getAvgthrouputdl().setScale(2,BigDecimal.ROUND_HALF_UP));
                v3.add(Zntyg.getAvgthrouputdl().setScale(2,BigDecimal.ROUND_HALF_UP));



                map.put("yhs",v2);
                map.put("zlls",v);
                map.put("xzsl",v3);
                map.put("shijian",getDayBefore(i));
                return map;
            }
        }
    }

    @Override
    public List<Video> getVideoZdqyData() {
        String tableNameVideo="video";
        int i=1;
        String tableNameVideoz="";
        while(true){
            String temp = "'"+tableNameVideo+getDayBefore(i)+"'";
            if(videoCellDao.selectTableByName(temp)==null){
                i++;
            }else {

                tableNameVideoz = tableNameVideo + getDayBefore(i);

                return videoCellDao.queryByVideoZdqy(tableNameVideoz);
            }
        }
    }

    //获取十分钟前的时间串
    private String getTenMinBefore(int i){
        SimpleDateFormat df= new SimpleDateFormat("yyyyMMddHH");
        Calendar nowTime=Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,-10*i);
        int minute=nowTime.get(Calendar.MINUTE);

        String nowStr=df.format(nowTime.getTime())+String.format("%02d",minute/10*10);
        return nowStr;
    }

    //获取十分钟前的时间串
    private String getDayBefore(int i){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1*i);
        date = calendar.getTime();

        return sdf.format(date);
    }
}
