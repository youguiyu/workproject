package com.xngls.neiproj.service.impl;

import com.xngls.neiproj.entity.*;
import com.xngls.neiproj.mapper.*;
import com.xngls.neiproj.model.MyException;
import com.xngls.neiproj.model.QushiModel;
import com.xngls.neiproj.model.ResultModel;
import com.xngls.neiproj.model.ZhibiaoTiaoModel;
import com.xngls.neiproj.service.NeiService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service(value = "neiService")
@Transactional(readOnly = true)
public class NeiServiceImpl implements NeiService {


    @Autowired
    private NeiKpiAndNeiValueMapper neiKpiAndNeiValueMapper;

    @Autowired
    private NeiBullientMapper neiBullientMapper;

    @Autowired
    private NeiKpiViewMapper neiKpiViewMapper;

    @Autowired
    private NeiKpiMapper neiKpiMapper;
    @Autowired
    private NeiValueMapper neiValueMapper;

    @Autowired
    private KpiModeMapper kpiModeMapper;


    @Override
    public List<NeiKpiAndNeiValue> findByPage(ZhibiaoTiaoModel z) {
        Map<String ,Object> map1= new HashMap<>();
        Integer timeRange1 =0;
        Integer timeRange2 = 0;
        if (z.getReportType()==0){
              timeRange1 = z.getTimeselect();
              timeRange2 = getRiqi(z.getTimeselect().toString());
        }else if(z.getReportType()==1){
            Integer time = z.getTimeselect();
            Integer year = Integer.valueOf(time.toString().substring(0,4));
            Integer month = Integer.valueOf(time.toString().substring(4,(time.toString()).length()));
             timeRange1 = getMonthDay(year,month,0);
             timeRange2 = getMonthDay(year,month,1);
        }
        map1.put("timeRange1",timeRange1);
        map1.put("timeRange2",timeRange2);
        map1.put("selectsilun",z.getSelectsilun());
        String [] selecttenW = chuliShuzu(z.getSelecttenW());
        map1.put("selecttenW",selecttenW);
        map1.put("cityNum",z.getCityNum());
        List<NeiKpiAndNeiValue>  neis = neiKpiAndNeiValueMapper.selectDataBytiaojian(map1);
        return neis;
    }

    @Override
    public Map<String,Object> findByQushiData(QushiModel q) {
        Map<String ,Object> map1= new HashMap<>();
        Integer timeRange1 =0;
        Integer timeRange2 = 0;
        if (q.getReportType()==0){
            timeRange1 = q.getTimeselect();
            timeRange2 = getRiqi(q.getTimeselect().toString());

        }else if(q.getReportType()==1){
            Integer time = q.getTimeselect();
            Integer year = Integer.valueOf(time.toString().substring(0,4));
            Integer month = Integer.valueOf(time.toString().substring(4,(time.toString()).length()));
            timeRange1 = getMonthDay(year,month,0);
            timeRange2 = getMonthDay(year,month,1);
           // System.out.println(timeRange1);
        }
        map1.put("timeRange1",timeRange1);
        map1.put("timeRange2",timeRange2);
        map1.put("selectsilun",q.getSelectsilun());
        map1.put("cityNum",q.getCityNum());
        map1.put("kpiName",q.getKpiName());
        map1.put("dimension",q.getDimension());
        List<NeiKpiAndNeiValue>  neis = neiKpiAndNeiValueMapper.findqushiData(map1);

        List<Integer> dateData = new ArrayList<Integer>();
        List<BigDecimal> yyData = new ArrayList<BigDecimal>();
        for(NeiKpiAndNeiValue n :neis){
            dateData.add(n.getDateId());
            yyData.add(n.getCurrentValue());
        }

        Map<String,Object> data = new HashMap<String,Object>();
        data.put("xData",dateData);
        data.put("yData",yyData);

        return data;
    }

    @Override
    public List<Map<String,Object>> getRadar1Data() {
        /**
         *   上期、本期、全国、最优、最差--四轮总评分
         */
        Map<String,Object> silunTotal = getSilunData("");

        /**
         *   上期、本期、全国、最优、最差 --移动业务
         */
        Map<String,Object> ydywData = getSilunData("'移动业务'");

        /**
         *   上期、本期、全国、最优、最差 --家庭业务NEI
         */
        Map<String,Object> jtywData = getSilunData("'家庭业务'");

        /**
         *   上期、本期、全国、最优、最差 --政企业务NEI
         */
        Map<String,Object> zqywData = getSilunData("'政企业务'");
        /**
         *   上期、本期、全国、最优、最差 --新业务
         */
        Map<String,Object> xywData = getSilunData("'新业务'");

        List<Object> sq = new ArrayList<Object>();
        sq.add(silunTotal.get("sqSilunSocre"));sq.add(ydywData.get("sqSilunSocre"));sq.add(jtywData.get("sqSilunSocre"));
        sq.add(zqywData.get("sqSilunSocre"));sq.add(xywData.get("sqSilunSocre"));

        List<Object> bq = new ArrayList<Object>();
        bq.add(silunTotal.get("bqSilunSocre"));bq.add(ydywData.get("bqSilunSocre"));bq.add(jtywData.get("bqSilunSocre"));
        bq.add(zqywData.get("bqSilunSocre"));bq.add(xywData.get("bqSilunSocre"));

        List<Object> qg = new ArrayList<Object>();
        qg.add(silunTotal.get("qgSilunSocre"));qg.add(ydywData.get("qgSilunSocre"));qg.add(jtywData.get("qgSilunSocre"));
        qg.add(zqywData.get("qgSilunSocre"));qg.add(xywData.get("qgSilunSocre"));

        List<Object> zy = new ArrayList<Object>();
        zy.add(silunTotal.get("zySilunSocre"));zy.add(ydywData.get("zySilunSocre"));zy.add(jtywData.get("zySilunSocre"));
        zy.add(zqywData.get("zySilunSocre"));zy.add(xywData.get("zySilunSocre"));

        List<Object> zc = new ArrayList<Object>();
        zc.add(silunTotal.get("zcSilunSocre"));zc.add(ydywData.get("zcSilunSocre"));zc.add(jtywData.get("zcSilunSocre"));
        zc.add(zqywData.get("zcSilunSocre"));zc.add(xywData.get("zcSilunSocre"));

        List<Map<String,Object>> radar1Data = new ArrayList<Map<String,Object>>();

        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
        Map<String,Object> t1 = new HashMap<String,Object>();
        t1.put("name","本期");t1.put("value",bq);
        Map<String,Object> t2 = new HashMap<String,Object>();
        t2.put("name","上期");t2.put("value",sq);
        Map<String,Object> t3 = new HashMap<String,Object>();
        t3.put("name","全国");t3.put("value",qg);
        Map<String,Object> t4 = new HashMap<String,Object>();
        t4.put("name","最优");t4.put("value",zy);
        Map<String,Object> t5 = new HashMap<String,Object>();
        t5.put("name","最差");t5.put("value",zc);
        radar1Data.add(t1); radar1Data.add(t2); radar1Data.add(t3); radar1Data.add(t4); radar1Data.add(t5);

        return radar1Data;
    }

    @Override
    public List<Map<String, Object>> getRadar2Data() {
        /**
         *   上期、本期、全国、最优、最差--客户反映
         */
        Map<String,Object> khfy = getSilunData2("'客户反映'");

        /**
         *   上期、本期、全国、最优、最差 --业务感知
         */
        Map<String,Object> ywgz = getSilunData2("'业务感知'");

        /**
         *   上期、本期、全国、最优、最差 --服务感知
         */
        Map<String,Object> fwgz = getSilunData2("'服务感知'");

        /**
         *   上期、本期、全国、最优、最差 --竞对感知
         */
        Map<String,Object> jdgz = getSilunData2("'竞对感知'");
        /**
         *   上期、本期、全国、最优、最差 --场景感知
         */
        Map<String,Object> cjgz = getSilunData2("'场景感知'");
        /**
         *   上期、本期、全国、最优、最差 --最差感知
         */
        Map<String,Object> zcgz = getSilunData2("'最差感知'");
        /**
         *   上期、本期、全国、最优、最差 --覆盖感知
         */
        Map<String,Object> fggz = getSilunData2("'覆盖感知'");
        /**
         *   上期、本期、全国、最优、最差 --容量感知
         */
        Map<String,Object> rlgz = getSilunData2("'容量感知'");
        /**
         *   上期、本期、全国、最优、最差 --结构感知
         */
        Map<String,Object> jggz = getSilunData2("'结构感知'");

        List<Object> sq = new ArrayList<Object>();
        sq.add(khfy.get("sqSilunSocre"));sq.add(ywgz.get("sqSilunSocre"));sq.add(fwgz.get("sqSilunSocre"));
        sq.add(jdgz.get("sqSilunSocre"));sq.add(cjgz.get("sqSilunSocre"));sq.add(zcgz.get("sqSilunSocre"));
        sq.add(fggz.get("sqSilunSocre"));sq.add(rlgz.get("sqSilunSocre"));sq.add(jggz.get("sqSilunSocre"));

        List<Object> bq = new ArrayList<Object>();
        bq.add(khfy.get("bqSilunSocre"));bq.add(ywgz.get("bqSilunSocre"));bq.add(fwgz.get("bqSilunSocre"));
        bq.add(jdgz.get("bqSilunSocre"));bq.add(cjgz.get("bqSilunSocre"));bq.add(zcgz.get("bqSilunSocre"));
        bq.add(fggz.get("bqSilunSocre"));bq.add(rlgz.get("bqSilunSocre"));bq.add(jggz.get("bqSilunSocre"));

        List<Object> qg = new ArrayList<Object>();
        qg.add(khfy.get("qgSilunSocre"));qg.add(ywgz.get("qgSilunSocre"));qg.add(fwgz.get("qgSilunSocre"));
        qg.add(jdgz.get("qgSilunSocre"));qg.add(cjgz.get("qgSilunSocre"));qg.add(zcgz.get("qgSilunSocre"));
        qg.add(fggz.get("qgSilunSocre"));qg.add(rlgz.get("qgSilunSocre"));qg.add(jggz.get("qgSilunSocre"));

        List<Object> zy = new ArrayList<Object>();
        zy.add(khfy.get("zySilunSocre"));zy.add(ywgz.get("zySilunSocre"));zy.add(fwgz.get("zySilunSocre"));
        zy.add(jdgz.get("zySilunSocre"));zy.add(cjgz.get("zySilunSocre"));zy.add(zcgz.get("zySilunSocre"));
        zy.add(fggz.get("zySilunSocre"));zy.add(rlgz.get("zySilunSocre"));zy.add(jggz.get("zySilunSocre"));

        List<Object> zc = new ArrayList<Object>();
        zc.add(khfy.get("zcSilunSocre"));zc.add(ywgz.get("zcSilunSocre"));zc.add(fwgz.get("zcSilunSocre"));
        zc.add(jdgz.get("zcSilunSocre"));zc.add(cjgz.get("zcSilunSocre"));zc.add(zcgz.get("zcSilunSocre"));
        zc.add(fggz.get("zcSilunSocre"));zc.add(rlgz.get("zcSilunSocre"));zc.add(jggz.get("zcSilunSocre"));

        List<Map<String,Object>> radar1Data = new ArrayList<Map<String,Object>>();

        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
        Map<String,Object> t1 = new HashMap<String,Object>();
        t1.put("name","本期");t1.put("value",bq);
        Map<String,Object> t2 = new HashMap<String,Object>();
        t2.put("name","上期");t2.put("value",sq);
        Map<String,Object> t3 = new HashMap<String,Object>();
        t3.put("name","全国");t3.put("value",qg);
        Map<String,Object> t4 = new HashMap<String,Object>();
        t4.put("name","最优");t4.put("value",zy);
        Map<String,Object> t5 = new HashMap<String,Object>();
        t5.put("name","最差");t5.put("value",zc);
        radar1Data.add(t1); radar1Data.add(t2); radar1Data.add(t3); radar1Data.add(t4); radar1Data.add(t5);

        return radar1Data;
    }

    @Override
    public Map<String, Object> getMapData() {
        Map<String,Object> map = new HashMap<String ,Object>();
        map.put("city","591");
        Map<String,Object> dateId =getYesDay();
        map.put("dateId",dateId.get("yesday"));

        Map<String, Object> map1 = new HashMap<String,Object>();
        List<Integer>  cityNum = new ArrayList<Integer>();
        cityNum.add(591);cityNum.add(592);cityNum.add(593);cityNum.add(594);
        cityNum.add(595);cityNum.add(596);cityNum.add(597);cityNum.add(598);
        cityNum.add(599);

        map1.put("riqi",dateId.get("yesday"));
         //总性能评估
        List<Map<String, Object>> zxnpg = getXNPG(1,cityNum,map);
        map1.put("zxnpg",zxnpg);


        //移动业务NEI-性能评估
        List<Map<String, Object>> ydywxnpg = getXNPG(2,cityNum,map);
        map1.put("ydywxnpg",ydywxnpg);

        //家庭业务NEI-性能评估
        List<Map<String, Object>> jtywxnpg = getXNPG(3,cityNum,map);
        map1.put("jtywxnpg",jtywxnpg);

        //政企业务NEI-性能评估
        List<Map<String, Object>> zqywxnpg = getXNPG(4,cityNum,map);
        map1.put("zqywxnpg",zqywxnpg);

        //新业务NEI-性能评估
        List<Map<String, Object>> xywxnpg = getXNPG(5,cityNum,map);
        map1.put("xywxnpg",xywxnpg);



        return map1;
    }

    @Override
    public Map<String, Object> getMapLineData(String city2) {
        Integer city = chuliCity2(city2);
        //获取最近的昨天的时间
        Map<String,Object> dayMap =getYesDay();
//        //30天前的日期
//        String monthDay=getMonthDay((Integer) dayMap.get("num"));
        List<String> dateAll = getMonthAllDay((Integer) dayMap.get("num")) ;
        Map<String,Object> data = new HashMap<String,Object>();
        //总体性能评估值
        Map<String,Object> ztxnpg = getLineData(city,1);

        //移动业务NEI
        Map<String,Object> ydyw = getLineData(city,2);

        //家庭业务NEI
        Map<String,Object> jtyw = getLineData(city,3);

        //政企业务NEI
        Map<String,Object> zqyw = getLineData(city,4);

        //新业务NEI
        Map<String,Object> xyw = getLineData(city,5);

        List<Map<String,Object>> ydata = new ArrayList<Map<String,Object>>();
        ydata.add(ztxnpg); ydata.add(ydyw);ydata.add(jtyw);ydata.add(zqyw);ydata.add(xyw);

        data.put("xdata",dateAll);

        data.put("series",ydata);

        return data;
    }

    @Override
    public List<Map<String, Object>> getPingGuTalbeA(String dateId, String bussinessType) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("dateId",dateId);
        map.put("businessType",bussinessType);
        List<NeiKpiView> neiKpiViews = neiKpiViewMapper.findNeiKpiViewByTiao4(map);
        List<NeiKpiView> neiKpiViews2 = neiKpiViewMapper.findNeiKpiViewByTiao3(map);
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        if(neiKpiViews.size()!=0){
            double weigthtotals =0.0;
            for(NeiKpiView n1:neiKpiViews2){
                weigthtotals = weigthtotals+n1.getKpiWeight().doubleValue();
            }
            double scoreTotal =0.0;
            int temp1=0;
            for (NeiKpiView n2:neiKpiViews2){
                scoreTotal = scoreTotal+ (n2.getKpiWeight().doubleValue()/weigthtotals)*n2.getScore().doubleValue();
                if(n2.getOther().equals("x") &&n2.getCurrentValue().doubleValue()<n2.getBenchmarkValue().doubleValue()){
                    temp1++;
                }else if(n2.getOther().equals("y") &&n2.getCurrentValue().doubleValue()>n2.getBenchmarkValue().doubleValue()){
                    temp1++;
                }
            }
            Map<String, Object> perData1 = new HashMap<String, Object>();
            perData1.put("ziweidu","汇总");
            perData1.put("score",(double)Math.round(scoreTotal*100)/100);
            perData1.put("temp",temp1);

            data.add(perData1);

            for(NeiKpiView n:neiKpiViews){
                Map<String, Object> perData = new HashMap<String, Object>();
                perData.put("ziweidu",n.getDimension());
                double score=0.0;
                int temp=0;
                for(NeiKpiView k :neiKpiViews2){
                    if(n.getDimension().equals(k.getDimension())){
                        score=score+(k.getKpiWeight().doubleValue()/n.getWeightTotal().doubleValue())*k.getScore().doubleValue();

                        if(k.getOther().equals("x") &&k.getCurrentValue().doubleValue()<k.getBenchmarkValue().doubleValue()){
                            temp++;
                        }else if(k.getOther().equals("y") &&k.getCurrentValue().doubleValue()>k.getBenchmarkValue().doubleValue()){
                            temp++;
                        }
                    }
                }

                perData.put("score",(double)Math.round(score*100)/100);
                perData.put("temp",temp);
                data.add(perData);
            }
        }else{
            Map<String, Object> perData1 = new HashMap<String, Object>();
            perData1.put("ziweidu","汇总");
            perData1.put("score","-");
            perData1.put("temp","-");

            data.add(perData1);
        }




        return data;
    }

    @Override
    public List<NeiKpiAndNeiValue> findByPage2(Map<String, Object> map) {
        Map<String ,Object> map1= new HashMap<>();
        map1.put("time",map.get("time"));
        map1.put("bussinessType",map.get("bussinessType"));
        map1.put("demension",map.get("demension"));
        List<NeiKpiAndNeiValue>  neis = neiKpiAndNeiValueMapper.selectDataBytiaojian2(map1);

        return neis;
    }

    @Override
    public Map<String, Object> findByQushiData2(QushiModel q) {
        Map<String ,Object> map1= new HashMap<>();
        Integer timeRange1 =0;
        Integer timeRange2 = 0;
        timeRange1 = q.getTimeselect();
        timeRange2 = getRiqi(q.getTimeselect().toString());

        map1.put("timeRange1",timeRange1);
        map1.put("timeRange2",timeRange2);

        String bussinessType="";

        if(q.getSelectsilun().equals("1")){
            bussinessType="移动业务NEI";
        }else  if(q.getSelectsilun().equals("2")){
            bussinessType="家庭业务NEI";
        }else  if(q.getSelectsilun().equals("3")){
            bussinessType="政企业务NEI";
        }else  if(q.getSelectsilun().equals("4")){
            bussinessType="新业务NEI";
        }
        map1.put("selectsilun",bussinessType);
        map1.put("cityNum",q.getCityNum());
        map1.put("kpiName",q.getKpiName());
        map1.put("dimension",q.getDimension());
        List<NeiKpiAndNeiValue>  neis = neiKpiAndNeiValueMapper.findqushiData(map1);

        List<Integer> dateData = new ArrayList<Integer>();
        List<BigDecimal> yyData = new ArrayList<BigDecimal>();
        for(NeiKpiAndNeiValue n :neis){
            dateData.add(n.getDateId());
            yyData.add(n.getCurrentValue());
        }
//        List<NeiKpiViewTotal>  neiKpiViewTotals = neiKpiAndNeiValueMapper.findqushiData2Time(map1);
//
//        List<NeiKpiAndNeiValue>  neis = neiKpiAndNeiValueMapper.findqushiData2(map1);
//
//        List<Integer> dateData = new ArrayList<Integer>();
//        List<Double> yyData = new ArrayList<Double>();
//        for(NeiKpiViewTotal n :neiKpiViewTotals){
//            dateData.add(n.getDateId());
//            double score=0.0;
//            for(NeiKpiAndNeiValue n2:neis){
//                if(n2.getDateId().equals(n.getDateId())){
//                    score = score+ (n2.getKpiWight().doubleValue()/n.getTotalKpiWeight().doubleValue())*n2.getCurrentValue().doubleValue();
//                }
//            }
//            yyData.add((double)Math.round(score*100)/100);
//        }

        Map<String,Object> data = new HashMap<String,Object>();
        data.put("xData",dateData);
        data.put("yData",yyData);

        return data;
    }

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public Map<String ,Object> batchImport(String fileName, MultipartFile file) throws Exception {
        Map<String ,Object> resultM = new HashMap<String ,Object>();
        String result="";
        boolean notNull = false;
       List<ResultModel> resultModels = new ArrayList<ResultModel>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            result="上传文件格式不正确";
            throw new MyException("上传文件格式不正确");

        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if(sheet!=null){
            notNull = true;
        }
        Row row4 = sheet.getRow(0);
        if(!row4.getCell(0).getStringCellValue().equals("指标名称")){
            resultM.put("result","表格模板有错误（第一行应为指标名称，从第二行开始为对应指标值），请检查！");
            resultM.put("resultmodel",null);
            return resultM;
        }
        //List<Map<String,Double>> excelDataList = new ArrayList<Map<String,Double>>();
        Map<String,Double> excelDataMap = new HashMap<String,Double>();
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {

            Row row1 = sheet.getRow(r);

            if (row1 == null){
                continue;
            }

            String cityName= "";
            if(row1.getCell(0).getStringCellValue().indexOf("市")>0||row1.getCell(0).getStringCellValue().indexOf("市")==0){
                String temp = row1.getCell(0).getStringCellValue();
                cityName=temp.substring(0,temp.indexOf("市"));
            }else {
                cityName=row1.getCell(0).getStringCellValue();
            }
            String timeNow= row1.getCell(1).getStringCellValue();
            //System.out.println(row4.getLastCellNum());
            for(int k=2; k<=row4.getLastCellNum();k++){
                if (row4.getCell(k) != null
                        && row4.getCell(k).getCellType() != 3
                        && row4.getCell(k).getCellType() != 5) {
                    List<NeiKpi> n = neiKpiMapper.findNeiKpiByKpiInfo2(row4.getCell(k).getStringCellValue());
                    // System.out.println(row4.getCell(k)+":"+row1.getCell(k).getCellType());
                    if (n.size() > 0) {
                        String key = timeNow + ":" + cityName + ":" + n.get(0).getKpiName();
                        if (row1.getCell(k) != null
                                && row1.getCell(k).getCellType() != HSSFCell.CELL_TYPE_STRING
                                && row1.getCell(k).getCellType() != 3
                                && row1.getCell(k).getCellType() != 5
                                && row1.getCell(k).getCellType() != 4) {

                            Double value = row1.getCell(k).getNumericCellValue();
                            excelDataMap.put(key, value);


                        }else {
                            ResultModel rm = new ResultModel();
                            rm.setKpiInfo(row4.getCell(k).getStringCellValue());
                            rm.setCity(cityName);
                            rm.setDateId(timeNow);
                            rm.setResultContent("第"+r+1+"行"+k+1+"列"+row4.getCell(k).getStringCellValue()+
                                    "：指标数值是空值或者是字符串类型或者是值类型错误！");
                            resultModels.add(rm);
                        }
                    } else {
                        //没有这个指标的话，存在这里

                        ResultModel rm = new ResultModel();
                        rm.setKpiInfo(row4.getCell(k).getStringCellValue());
                        rm.setCity(cityName);
                        rm.setDateId(timeNow);
                        rm.setResultContent("第"+r+1+"行"+k+1+"列"+row4.getCell(k).getStringCellValue()+
                                "：该指标不存在，请及时入库！");
                        resultModels.add(rm);
                    }
                }
            }
        }
        Map<String,Integer> timeRange = new HashMap<String,Integer>();
        List<NeiKpiAndNeiValue> neiKpiAndNeiValues= new ArrayList<NeiKpiAndNeiValue>();
        if(sheet.getRow(1)!=null
                && sheet.getRow(1).getCell(1).getCellType()!=3
                &&sheet.getRow(1).getCell(1).getCellType()!=5){
            timeRange= getTimeRange(sheet.getRow(1).getCell(1).getStringCellValue());
            neiKpiAndNeiValues=neiKpiAndNeiValueMapper.selectNeiValuesByTimeRange(timeRange);

        }

        //List<Map<String,Double>> serverDataList = new ArrayList<Map<String,Double>>();
        Map<String,Double> serverDataMap = new HashMap<String,Double>();

        if (neiKpiAndNeiValues.size()>0){
            for(NeiKpiAndNeiValue n:neiKpiAndNeiValues){
                String key= formatTime(n.getDateId())+":"+getCity2(n.getCity())+":"+n.getKpiName();
                Double value = n.getCurrentValue().doubleValue();
                serverDataMap.put(key,value);
            }
        }

        Map<String,Double> resultDataMap = new HashMap<String,Double>();
       // Map<String,Double> resultDataMap2 = new HashMap<String,Double>();
        /**
         * 用map的entrySet()的增强型for循环(性能效率较高)
         */
        for(Map.Entry<String, Double> entry1:excelDataMap.entrySet()){

            Map<String,String> map = getCanShu(entry1.getKey());
            String dateId= map.get("shijian");
            String city= map.get("city");
            String kpiName= map.get("kpiName");
            Double m1value = entry1.getValue();
            if(serverDataMap.get(entry1.getKey())!=m1value){
                Double m2value =serverDataMap.get(entry1.getKey());
                List<NeiKpi> neiKpis = neiKpiMapper.findNeiKpiByKpiName(kpiName);
                if(m2value==null) {
                    if(neiKpis.size()>0){
                        if(neiKpis.get(0).getAudit()!=null&&neiKpis.get(0).getAudit().equals("y")){
                            double topLimit= neiKpis.get(0).getTopLimit().doubleValue();
                            double lowerLimit= neiKpis.get(0).getLowerLimit().doubleValue();
                            if(m1value>topLimit){
                                ResultModel rm = new ResultModel();
                                rm.setKpiName(kpiName);
                                rm.setKpiInfo(neiKpis.get(0).getKpiInfo());
                                rm.setCity(city);
                                rm.setDateId(dateId);
                                rm.setResultContent(neiKpis.get(0).getKpiInfo()+
                                        "：该指标的上限值为："+topLimit+",下限值为："+lowerLimit+
                                        ";指标当前值为："+m1value+"超过上限值，无法入库，请核对！");
                                resultModels.add(rm);
                            }else if (m1value<lowerLimit){
                                ResultModel rm = new ResultModel();
                                rm.setKpiName(kpiName);
                                rm.setKpiInfo(neiKpis.get(0).getKpiInfo());
                                rm.setCity(city);
                                rm.setDateId(dateId);
                                rm.setResultContent(neiKpis.get(0).getKpiInfo()+
                                        "：该指标的上限值为："+topLimit+",下限值为："+lowerLimit+
                                        ";指标当前值为："+m1value+"低于下限值，无法入库，请核对！");
                                resultModels.add(rm);

                            }else {
                                resultDataMap.put(entry1.getKey(), m1value);
                            }
                        }else {
                            resultDataMap.put(entry1.getKey(), m1value);
                        }


                    }

                }else {
                    ResultModel rm = new ResultModel();
                    rm.setKpiName(kpiName);
                    rm.setKpiInfo(neiKpis.get(0).getKpiInfo());
                    rm.setCity(chuliCity(Integer.valueOf(city)));
                    rm.setDateId(dateId);
                    rm.setResultContent(neiKpis.get(0).getKpiInfo()+
                            "该指标值数据库中已有，无法入库，请核对！");
                    resultModels.add(rm);
                }
            }



        }

        List<NeiValue> neiValues = new ArrayList<NeiValue>();
        if(resultDataMap.size()<=0){
            result= "成功更新0条；更新失败了"+resultModels.size()+"条指标!";

        }else{
            for(Map.Entry<String, Double> entry1:resultDataMap.entrySet()){
                Map<String,String> map = getCanShu( entry1.getKey());
                String kpiName= map.get("kpiName");
                if(kpiName!=null&&!kpiName.equals("")){

                    try{
                            Integer dateId = Integer.valueOf(map.get("shijian"));
                            Integer city = Integer.valueOf(map.get("city"));
                            Double value = entry1.getValue();
                            NeiValue n1 = new NeiValue();
                            n1.setCity(city);
                            n1.setDateId(dateId);
                            n1.setKpiName(kpiName);
                            n1.setCurrentValue(BigDecimal.valueOf(value));
                            neiValues.add(n1);

                    }catch (Exception e){
                        System.out.println("cccccccccccccccccc"+kpiName);
                        e.printStackTrace();
                    }


                }



            }

            List< List<NeiValue>> neiValuesList = new ArrayList< List<NeiValue>>();
            int insertNum =0;
            if (neiValues.size()>0){
                if (neiValues.size()<500){
                    insertNum =neiValueMapper.insertData(neiValues);
                }else {
                    int i=1;
                    while(i<(neiValues.size()/500)+2){
                        if(i==(neiValues.size()/500)+1){
                            List<NeiValue> neiValues1= neiValues.subList((i-1)*500,neiValues.size());
                            neiValuesList.add(neiValues1);
                        }else {
                            List<NeiValue> neiValues1= neiValues.subList((i-1)*500,i*500);
                            neiValuesList.add(neiValues1);
                        }

                        i++;
                    }
                    for(List<NeiValue> n:neiValuesList){
                        int r =neiValueMapper.insertData(n);
                        insertNum=insertNum+r;
                    }
            }





            }

            result="成功更新"+insertNum+"条指标，更新失败了"+resultModels.size()+"条指标!";
           // System.out.println(result);
        }

        resultM.put("result",result);
        resultM.put("resultmodel",resultModels);
        return resultM;
    }

    private Map<String,String> getCanShu(String key) {
        String [] temp = key.split(":");
        String shijian="";
        if(temp[0].length()>8){
            shijian = temp[0].substring(0,4)+temp[0].substring(5,7)+temp[0].substring(8,10);
        }else {
            shijian = temp[0].substring(0,4)+temp[0].substring(5,7)+"00";
        }

        Integer city = getCityNum(temp[1]);

        String kpiName= temp[2];
        Map<String,String> values = new HashMap<String,String>();
        values.put("shijian",shijian);
        values.put("city",city.toString());
        values.put("kpiName",kpiName);

           return values;
    }

    private Integer getCityNum(String s) {
        Map<String,Integer> cityName = new HashMap<String,Integer>();
        cityName.put("福建",590);
        cityName.put("福州",591);
        cityName.put("厦门",592);
        cityName.put("宁德",593);
        cityName.put("莆田",594);
        cityName.put("泉州",595);
        cityName.put("漳州",596);
        cityName.put("龙岩",597);
        cityName.put("三明",598);
        cityName.put("南平",599);
        return cityName.get(s);
    }

    public String formatTime(Integer dateId) {
        String time = dateId.toString();
        String time1="";
        if(time.substring(6,time.length()).equals("00")){
            time1 = time.substring(0,4)+"年"+time.substring(4,6)+"月";

        }else {
            time1 = time.substring(0,4)+"年"+time.substring(4,6)+"月"+time.substring(6,time.length())+"日";

        }
        return time1;
    }

    protected Map<String,Integer> getTimeRange(String stringCellValue) {
        Map<String,Integer> timeRange = new HashMap<String,Integer>();
        //String
        Integer timeRange1 =Integer.valueOf(stringCellValue.substring(0,4)+stringCellValue.substring(5,7)+"00");
        Integer timeRange2 =Integer.valueOf(stringCellValue.substring(0,4)+stringCellValue.substring(5,7)+"31");
        timeRange.put("timeleft",timeRange1);
        timeRange.put("timeright",timeRange2);

        return timeRange;
    }
    public String getCity2(Integer city) {
        Map<Integer,String> cityName = new HashMap<Integer,String>();
        cityName.put(590,"福建");
        cityName.put(591,"福州");
        cityName.put(592,"厦门");
        cityName.put(593,"宁德");
        cityName.put(594,"莆田");
        cityName.put(595,"泉州");
        cityName.put(596,"漳州");
        cityName.put(597,"龙岩");
        cityName.put(598,"三明");
        cityName.put(599,"南平");


        return cityName.get(city);
    }
    @Override
    public List<KpiModel> findKpiModes(Map<String, Integer> map) {

        List<KpiModel> models =  kpiModeMapper.findeKpiByTimeRange(map);
        return models;
    }

    @Override
    public List<NeiKpi> getXiangxiData(Integer dateId, String fetchPlatform) {
        Map<String,Object> map = new HashMap<String ,Object>();
        map.put("dateId",dateId);
        map.put("fetchPlatform",fetchPlatform);
        List<NeiKpi> models =  neiKpiMapper.findXiangqingData(map);
        return models;
    }

    @Override
    public List<NeiKpi> getKpiAllInfo(String serarchText) {
        if(serarchText !=null && !serarchText.equals("")){
            return neiKpiMapper.getKpiAllInfo(serarchText);
        }else{
            return neiKpiMapper.getKpiAllInfotemp();
        }


    }

    @Override
    public List<NeiKpi> getKpiAllInfo1(String serarchText) {
        if(serarchText !=null && !serarchText.equals("")){
            return neiKpiMapper.getKpiAllInfo1(serarchText);
        }else{
            return neiKpiMapper.getKpiAllInfotemp1();
        }


    }


    public String chuliRiqi(String time){
        if(time.length()<9){
            String year = time.substring(0, 4);
            String month = time.substring(5, 7)+"00";
            return year+month;
        }else {
            String year = time.substring(0, 4);
            String month = time.substring(5, 7);
            String day = time.substring(8, 10);
            return year+month+day;
        }
   }

    public Map<String,Object> getLineData(Integer city, int temp){
        String businessType ="";
        String name="";
        if(temp==1){
            businessType="";
            name="总体性能评估值";
        }else  if(temp==2){
            businessType="移动业务NEI";
            name="移动业务NEI";
        }else  if(temp==3){
            businessType="家庭业务NEI";
            name="家庭业务NEI";
        }else  if(temp==4){
            businessType="政企业务NEI";
            name="政企业务NEI";
        }else  if(temp==5){
            businessType="新业务NEI";
            name="新业务NEI";
        }
        //获取最近的昨天的时间
        Map<String,Object> dayMap =getYesDay();
        List<String> dateAll = getMonthAllDay((Integer) dayMap.get("num")) ;
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("name",name);
        data.put("type","line");
        List<Double> ydata = new ArrayList<Double>();
        for(int i=0; i<dateAll.size(); i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("city",city);
            map.put("dateId",dateAll.get(i));
            map.put("businessType",businessType);
            List<NeiKpiView> neiKpiViews = neiKpiViewMapper.findNeiKpiViewByTiao(map);
            if(neiKpiViews.size()!=0){
                double totalNum =0.00;
                double score =0.00;
                for(NeiKpiView n :neiKpiViews){
                    totalNum = totalNum+n.getKpiWeight().doubleValue();
                }
                for(NeiKpiView n :neiKpiViews){
                    if(neiKpiViews.size()==1){
                        score= score+n.getScore().doubleValue()*n.getKpiWeight().doubleValue();

                    }else {
                        score= score+n.getScore().doubleValue()*(n.getKpiWeight().doubleValue()/totalNum);

                    }

                }

                ydata.add((double)Math.round(score*100)/100);
            }else{
                ydata.add(0.0);
            }
        }

        data.put("data",ydata);
        return data;
    }


    public List<String> getMonthAllDay(int num){
        List<String> allday = new ArrayList<String>();
        int num1 =-num;

        for (int i=num1+29;i>num1-2; i--){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Calendar cal = Calendar.getInstance();
            //获取有数据的时间
            Integer num2=-i;
            cal.add(Calendar.DATE,num2);
            String date=sdf.format(cal.getTime());
            allday.add(date);
        }
        return allday;
    }

    private String getMonthDay(int num){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        //获取有数据的时间
        Integer num2=num-30;
        cal.add(Calendar.DATE,num2);
        String yesDate=sdf.format(cal.getTime());
        return yesDate;


    }

    private Map<String,Object> getYesDay(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        //获取有数据的时间
        Integer num=-1;
        cal.add(Calendar.DATE,num);
        String yesDate=sdf.format(cal.getTime());

        for(;; ){
            Map<String, Object> mapdata = new HashMap<String,Object>();

            mapdata.put("dateId",yesDate);
            List<NeiKpiView> neiKpiViews = neiKpiViewMapper.findNeiKpiViewByTiao(mapdata);

            //  System.out.println(tableStatuses);
            if(neiKpiViews.size()==0){
                Calendar cal3 = Calendar.getInstance();
                cal3.add(Calendar.DATE,num--);
                yesDate=sdf.format(cal3.getTime());
            }else{
                break;
            }

        }

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("yesday",yesDate);
        map.put("num",num);
        return map;
    }


    public List<Map<String,Object>> getXNPG(Integer temp,List<Integer>  cityNum,Map<String,Object>map){
        List<Map<String, Object>> zxnpg = new ArrayList<Map<String,Object>>();
        for(int i=0; i<cityNum.size();i++){
            Map<String, Object> mapdata = new HashMap<String,Object>();
            mapdata.put("city",cityNum.get(i));
            mapdata.put("dateId",map.get("dateId"));
            if(temp==1){
                mapdata.put("businessType","");
            }else  if(temp==2){
                mapdata.put("businessType","移动业务NEI");
            }else  if(temp==3){
                mapdata.put("businessType","家庭业务NEI");
            }else  if(temp==4){
                mapdata.put("businessType","政企业务NEI");
            }else  if(temp==5){
                mapdata.put("businessType","新业务NEI");
            }

            List<NeiKpiView> neiKpiViews = neiKpiViewMapper.findNeiKpiViewByTiao(mapdata);
            if(neiKpiViews.size()>0){
                Map<String, Object>  permap = new HashMap<String,Object>();
                permap.put("name",chuliCity(cityNum.get(i)));
                double totalNum =0.00;
                double score =0.00;
                for(NeiKpiView n :neiKpiViews){
                    totalNum = totalNum+n.getKpiWeight().doubleValue();
                }
                for(NeiKpiView n :neiKpiViews){
                    if(neiKpiViews.size()==1){
                        score= score+n.getScore().doubleValue()*n.getKpiWeight().doubleValue();

                    }else {
                        score= score+n.getScore().doubleValue()*(n.getKpiWeight().doubleValue()/totalNum);
                    }

                }

                permap.put("value",(double)Math.round(score*100)/100);
                zxnpg.add(permap);
            }else{
                Map<String, Object>  permap = new HashMap<String,Object>();
                permap.put("name",chuliCity(cityNum.get(i)));
                permap.put("value","-");
                zxnpg.add(permap);
            }


        }
        return zxnpg;

    }

    private String chuliCity(Integer city) {
        Map<Integer, String> cityTable = new HashMap<Integer, String>();
        cityTable.put(591,"福州市");cityTable.put(592,"厦门市");cityTable.put(593,"宁德市");
        cityTable.put(594,"莆田市");cityTable.put(595,"泉州市");cityTable.put(596,"漳州市");
        cityTable.put(597,"龙岩市");cityTable.put(598,"三明市");cityTable.put(599,"南平市");
        cityTable.put(590,"福建");

        return cityTable.get(city);
    }

    private Integer chuliCity2(String city) {
        Map<String,Integer > cityTable = new HashMap<String,Integer >();
        cityTable.put("福州市",591);cityTable.put("厦门市",592);cityTable.put("宁德市",593);
        cityTable.put("莆田市",594);cityTable.put("泉州市",595);cityTable.put("漳州市",596);
        cityTable.put("龙岩市",597);cityTable.put("三明市",598);cityTable.put("南平市",599);



        return cityTable.get(city);
    }


    private Integer chuliCity3(String city) {
        Map<String,Integer > cityTable = new HashMap<String,Integer >();
        cityTable.put("福州",591);cityTable.put("厦门",592);cityTable.put("宁德",593);
        cityTable.put("莆田",594);cityTable.put("泉州",595);cityTable.put("漳州",596);
        cityTable.put("龙岩",597);cityTable.put("三明",598);cityTable.put("南平",599);

        cityTable.put("福建",590);

        return cityTable.get(city);
    }


    public Map<String,Object> getSilunData(String temp1){
        Map<String ,Object> map = new HashMap<String,Object>();
        map.put("selectsilun",temp1);
        map.put("tablename",getTableName());
        List<NeiBullient> neiBullents = neiBullientMapper.selectBullientBytiaojian(map);
        double weightTotal =0.00;
        double sqSilunSocre=0.00;
        double bqSilunSocre=0.00;
        double qgSilunSocre=0.00;
        double zySilunSocre=0.00;
        double zcSilunSocre=0.00;
        for(NeiBullient n :neiBullents){
            weightTotal = weightTotal+n.getKpiWeight().doubleValue();
        }

        for(NeiBullient n :neiBullents){
            sqSilunSocre = sqSilunSocre+getSilunSocre(n,n.getLastPeriod().doubleValue(),weightTotal);
            bqSilunSocre = bqSilunSocre+getSilunSocre(n,n.getCurrentPeriod().doubleValue(),weightTotal);
            qgSilunSocre =qgSilunSocre+ getSilunSocre(n,n.getCountryWide().doubleValue(),weightTotal);
            zySilunSocre =zySilunSocre+getSilunSocre(n,n.getBestValue().doubleValue(),weightTotal);
            zcSilunSocre=zcSilunSocre+getSilunSocre(n,n.getWorstValue().doubleValue(),weightTotal);

        }
        sqSilunSocre = (double)Math.round(sqSilunSocre*100)/100;
        bqSilunSocre = (double)Math.round(bqSilunSocre*100)/100;
        qgSilunSocre = (double)Math.round(qgSilunSocre*100)/100;
        zySilunSocre = (double)Math.round(zySilunSocre*100)/100;
        zcSilunSocre = (double)Math.round(zcSilunSocre*100)/100;
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("sqSilunSocre",sqSilunSocre);
        map1.put("bqSilunSocre",bqSilunSocre);
        map1.put("qgSilunSocre",qgSilunSocre);
        map1.put("zySilunSocre",zySilunSocre);
        map1.put("zcSilunSocre",zcSilunSocre);
        return  map1;
    }


    public Map<String,Object> getSilunData2(String temp1){
        Map<String ,Object> map = new HashMap<String,Object>();
        map.put("demension",temp1);
        map.put("tablename",getTableName());
        List<NeiBullient> neiBullents = neiBullientMapper.selectBullientBytiaojianTemp(map);
        double weightTotal =0.00;
        double sqSilunSocre=0.00;
        double bqSilunSocre=0.00;
        double qgSilunSocre=0.00;
        double zySilunSocre=0.00;
        double zcSilunSocre=0.00;
        for(NeiBullient n :neiBullents){
            weightTotal = weightTotal+n.getKpiWeight().doubleValue();
        }

        for(NeiBullient n :neiBullents){

//            sqSilunSocre =sqSilunSocre+n.getLastPeriod().doubleValue()*(n.getKpiWeight().doubleValue()/weightTotal);
//            bqSilunSocre = bqSilunSocre+n.getCurrentPeriod().doubleValue()*(n.getKpiWeight().doubleValue()/weightTotal);
//            qgSilunSocre = qgSilunSocre+n.getCountryWide().doubleValue()*(n.getKpiWeight().doubleValue()/weightTotal);
//            zySilunSocre =zySilunSocre+n.getBestValue().doubleValue()*(n.getKpiWeight().doubleValue()/weightTotal);
//            zcSilunSocre = zcSilunSocre+n.getWorstValue().doubleValue()*(n.getKpiWeight().doubleValue()/weightTotal);
            sqSilunSocre = sqSilunSocre+getSilunSocre(n,n.getLastPeriod().doubleValue(),weightTotal);
            bqSilunSocre = bqSilunSocre+getSilunSocre(n,n.getCurrentPeriod().doubleValue(),weightTotal);
            qgSilunSocre =qgSilunSocre+ getSilunSocre(n,n.getCountryWide().doubleValue(),weightTotal);
            zySilunSocre =zySilunSocre+getSilunSocre(n,n.getBestValue().doubleValue(),weightTotal);
            zcSilunSocre=zcSilunSocre+getSilunSocre(n,n.getWorstValue().doubleValue(),weightTotal);

        }
        sqSilunSocre = (double)Math.round(sqSilunSocre*100)/100;
        bqSilunSocre = (double)Math.round(bqSilunSocre*100)/100;
        qgSilunSocre = (double)Math.round(qgSilunSocre*100)/100;
        zySilunSocre = (double)Math.round(zySilunSocre*100)/100;
        zcSilunSocre = (double)Math.round(zcSilunSocre*100)/100;
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("sqSilunSocre",sqSilunSocre);
        map1.put("bqSilunSocre",bqSilunSocre);
        map1.put("qgSilunSocre",qgSilunSocre);
        map1.put("zySilunSocre",zySilunSocre);
        map1.put("zcSilunSocre",zcSilunSocre);
        return  map1;
    }


    public double getSilunSocre(NeiBullient n,double score,double weightTotal){
        double sqSilunSocre=0.0;
        if(n.getOther().equals("x")&&score>=n.getChallengeValue().doubleValue()){
            sqSilunSocre =100*(n.getKpiWeight().doubleValue()/weightTotal);

        }else if (n.getOther().equals("x")&&score<n.getBenchmarkValue().doubleValue()){
            sqSilunSocre =0*(n.getKpiWeight().doubleValue()/weightTotal);

        }else if (n.getOther().equals("x")&&score>=n.getBenchmarkValue().doubleValue()&&score<n.getChallengeValue().doubleValue()){
            sqSilunSocre =(60+((score-n.getBenchmarkValue().doubleValue())/(n.getChallengeValue().doubleValue()-n.getBenchmarkValue().doubleValue()))*40)*(n.getKpiWeight().doubleValue()/weightTotal);

        }else if(n.getOther().equals("y")&&score<=n.getChallengeValue().doubleValue()){
            sqSilunSocre =100*(n.getKpiWeight().doubleValue()/weightTotal);

        }else if (n.getOther().equals("y")&&score>n.getBenchmarkValue().doubleValue()){
            sqSilunSocre =0*(n.getKpiWeight().doubleValue()/weightTotal);

        }else if (n.getOther().equals("y")&&score<=n.getBenchmarkValue().doubleValue()&&score>n.getChallengeValue().doubleValue()){
            sqSilunSocre =(60+((n.getBenchmarkValue().doubleValue()-score)/(n.getBenchmarkValue().doubleValue()-n.getChallengeValue().doubleValue()))*40)*(n.getKpiWeight().doubleValue()/weightTotal);

        }
        return sqSilunSocre;
    }

    public String getTableName(){
        Calendar now = Calendar.getInstance();
        String year = now.get(Calendar.YEAR)+"";
        int month = now.get(Calendar.MONTH)+1;

        String tablename ="BULLETIN_DATA_";
        if(month>=1&& month<4){
                tablename=tablename+year+"1";
        }else if (month>=4&& month<7){
            tablename=tablename+year+"2";
        }else if (month>=7&& month<10){
            tablename=tablename+year+"3";
        }else if (month>=10&& month<=12){
            tablename=tablename+year+"4";
        }

        return tablename;
    }






    public String[] chuliShuzu(List<String> selectenw1){
        List<String > selectenw2 = new ArrayList<String>();
        for (int i=0; i<selectenw1.size(); i++){
            if(i==0){
                int length = selectenw1.get(i).length();
                String newString = selectenw1.get(i).substring(2,length);
                selectenw2.add(newString);
            }else if (i==(selectenw1.size()-1)){
                int length = selectenw1.get(i).length()-1;
                String newString = selectenw1.get(i).substring(0,length-1);
                selectenw2.add(newString);
            }else {
                selectenw2.add(selectenw1.get(i));
            }

        }
        String [] selecttenW = new String[selectenw2.size()];
        selectenw2.toArray(selecttenW);
        return selecttenW;
    }

    public   Integer getRiqi(String dqriqi){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Integer weekDay =0;
        try {
            Date riqi=sdf.parse(dqriqi);
            Calendar cal = Calendar.getInstance();
            cal.setTime(riqi);
            cal.add(Calendar.DATE,-6);
             weekDay = Integer.valueOf(sdf.format(cal.getTime()));


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return weekDay;
    }

    public Integer getMonthDay(int year,int month,int temp){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH,month-1);
        int lastDay=0;
        if(temp==0){
            lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        }else if(temp==1){
            lastDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        }

        cal.set(Calendar.DAY_OF_MONTH,lastDay);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Integer lasDayOfMonth = Integer.valueOf(sdf.format(cal.getTime()));
        return lasDayOfMonth;
    }
}

