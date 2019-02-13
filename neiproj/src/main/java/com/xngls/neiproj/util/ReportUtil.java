package com.xngls.neiproj.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xngls.neiproj.entity.NeiKpi;


import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReportUtil {
    JSONObject res;
    JSONArray alldata;
    String[] styles;
    public ReportUtil(JSONObject res,String[] styles){
        alldata=new JSONArray();
        this.res=res;
        this.styles=styles;
    }
    public JSONArray report(){

        for (short i = 0; i < styles.length; i++) {
            handleData(styles[i]);
        }

        /*handleData("移动业务NEI");
        handleData("家庭业务NEI");
        handleData("政企业务NEI");
        handleData("新业务NEI");
        handleData("全省指标");*/
        return alldata;
    }

    /**
     * 将短板报表数据处理，按排名生成最后数据

     * @param style 四轮的值
     */
     JSONArray handleData( String style) {
        //console.log(res);

        JSONObject res1=transData(style);
        for(int  i=1;i<=10;i++){
            JSONObject obj1=new JSONObject();
            //console.log(res1);
            obj1.put("四轮驱动",style);
            obj1.put("重大事件管控",getMax(res1.getJSONArray("重大事件管控"),i).getString("content"));
            obj1.put("客户反映",getMax(res1.getJSONArray("客户反映"),i).getString("content"));
            obj1.put("业务感知",getMax(res1.getJSONArray("业务感知"),i).getString("content"));
            obj1.put("服务感知",getMax(res1.getJSONArray("服务感知"),i).getString("content"));
            obj1.put("竞对感知",getMax(res1.getJSONArray("竞对感知"),i).getString("content"));
            obj1.put("场景感知",getMax(res1.getJSONArray("场景感知"),i).getString("content"));
            obj1.put("最差感知",getMax(res1.getJSONArray("最差感知"),i).getString("content"));
            obj1.put("覆盖感知",getMax(res1.getJSONArray("覆盖感知"),i).getString("content"));
            obj1.put("容量感知",getMax(res1.getJSONArray("容量感知"),i).getString("content"));
            obj1.put("结构感知",getMax(res1.getJSONArray("结构感知"),i).getString("content"));
            obj1.put("短板分析",style+"质量短板问题");

            alldata.add(obj1);
        }
        return alldata;
    }

    /**
     * 将数据转置处理

     * @param style 四轮的值
     */
     JSONObject transData(String style) {
        JSONObject rtn = new JSONObject();
        JSONArray obj1 = new JSONArray();
        JSONArray obj2 = new JSONArray();
        JSONArray obj3 = new JSONArray();
        JSONArray obj4 = new JSONArray();
        JSONArray obj5 = new JSONArray();
        JSONArray obj6 = new JSONArray();
        JSONArray obj7 = new JSONArray();
        JSONArray obj8 = new JSONArray();
        JSONArray obj9 = new JSONArray();
        JSONArray obj10 = new JSONArray();

        for (int i = 0; i < res.getJSONArray(style).size(); i++) {
            JSONObject temp = res.getJSONArray(style).getJSONObject(i);
            switch (temp.getString("dimension")) {
                case "重大事件管控":
                    obj1.add(temp);
                    break;
                case "客户反映":
                    obj2.add(temp);
                    break;
                case "业务感知":
                    obj3.add(temp);
                    break;
                case "服务感知":
                    obj4.add(temp);
                    break;
                case "竞对感知":
                    obj5.add(temp);
                    break;
                case "场景感知":
                    obj6.add(temp);
                    break;
                case "最差感知":
                    obj7.add(temp);
                case "覆盖感知":
                    obj8.add(temp);
                    break;
                case "容量感知":
                    obj9.add(temp);
                    break;
                case "结构感知":
                    obj10.add(temp);
                    break;
                default:
                    break;
            }
        }
        rtn.put("重大事件管控",obj1);
        rtn.put("客户反映",obj2);
        rtn.put("业务感知",obj3);
        rtn.put("服务感知",obj4);
        rtn.put("竞对感知",obj5);
        rtn.put("场景感知",obj6);
        rtn.put("最差感知",obj7);
        rtn.put("覆盖感知",obj8);
        rtn.put("容量感知",obj9);
        rtn.put("结构感知",obj10);

        return rtn;
    }

    //取出res中的最大值 ，然后把该最大值从res中去除，index表示为第几次调用过该方法
     JSONObject  getMax(JSONArray res,int index) {
        JSONObject rtn = new JSONObject();
        if(res.size()<=0){
            rtn.put("content",index+":");
            return rtn;
        }

        // JSONObject rtn = new JSONObject();
        int maxi=0;
        for(int i=0;i<res.size();i++){
            if(res.getJSONObject(maxi).getFloat("avg_value")<=res.getJSONObject(i).getFloat("avg_value"))
                maxi=i;
        }
        rtn=res.getJSONObject(maxi);
        String  city="";
        switch (rtn.getInteger("city")) {
            case 591:
                city="福州";
                break;
            case 592:
                city="厦门";
                break;
            case 593:
                city="宁德";
                break;
            case 594:
                city="莆田";
                break;
            case 595:
                city="泉州";
                break;
            case 596:
                city="漳州";
                break;
            case 597:
                city="龙岩";
                break;
            case 598:
                city="三明";
                break;
            case 599:
                city="南平";
                break;
            default:
                city="福建";
                break;
        }
        rtn.put("content",index+": "+city +" "+ rtn.getFloat("avg_value"));
        res.remove(maxi);
        //console.log(rtn);
        return rtn;
    }

    //短板分析表格导出
    public XSSFWorkbook getNeiReport(String jsonData){

        JSONArray json=JSONArray.parseArray(jsonData);
        // 声明一个工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();

        CellStyle cellStyleHeader = workbook.createCellStyle();
        cellStyleHeader.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cellStyleHeader.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        cellStyleHeader.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        cellStyleHeader.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        cellStyleHeader.setBorderRight(XSSFCellStyle.BORDER_THIN);
        cellStyleHeader.setBorderTop(XSSFCellStyle.BORDER_THIN);
        cellStyleHeader.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        cellStyleHeader.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        cellStyleHeader.setWrapText(true);

        CellStyle cellStyleAll = workbook.createCellStyle();
        cellStyleAll.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cellStyleAll.setFillForegroundColor(HSSFColor.WHITE.index);
        cellStyleAll.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        cellStyleAll.setBorderLeft(XSSFCellStyle.BORDER_HAIR);
        cellStyleAll.setBorderRight(XSSFCellStyle.THICK_BACKWARD_DIAG);
        cellStyleAll.setBorderTop(XSSFCellStyle.THICK_BACKWARD_DIAG);
        cellStyleAll.setWrapText(true);

        CellStyle cellStyleLeft1 = workbook.createCellStyle();
        cellStyleLeft1.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cellStyleLeft1.setFillForegroundColor(HSSFColor.YELLOW.index);
        cellStyleLeft1.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft1.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft1.setBorderRight(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft1.setBorderTop(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft1.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        cellStyleLeft1.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        cellStyleLeft1.setWrapText(true);

        CellStyle cellStyleLeft2 = workbook.createCellStyle();
        cellStyleLeft2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cellStyleLeft2.setFillForegroundColor(HSSFColor.GREEN.index);
        cellStyleLeft2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft2.setBorderRight(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft2.setBorderTop(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        cellStyleLeft2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        cellStyleLeft2.setWrapText(true);

        CellStyle cellStyleLeft3 = workbook.createCellStyle();
        cellStyleLeft3.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cellStyleLeft3.setFillForegroundColor(HSSFColor.LAVENDER.index);
        cellStyleLeft3.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft3.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft3.setBorderRight(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft3.setBorderTop(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft3.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        cellStyleLeft3.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        cellStyleLeft3.setWrapText(true);

        CellStyle cellStyleLeft4 = workbook.createCellStyle();
        cellStyleLeft4.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cellStyleLeft4.setFillForegroundColor(HSSFColor.ROSE.index);
        cellStyleLeft4.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft4.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft4.setBorderRight(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft4.setBorderTop(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft4.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        cellStyleLeft4.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        cellStyleLeft4.setWrapText(true);

        CellStyle cellStyleLeft5 = workbook.createCellStyle();
        cellStyleLeft5.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cellStyleLeft5.setFillForegroundColor(HSSFColor.LIGHT_GREEN.index);
        cellStyleLeft5.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft5.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft5.setBorderRight(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft5.setBorderTop(XSSFCellStyle.BORDER_THIN);
        cellStyleLeft5.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        cellStyleLeft5.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        cellStyleLeft5.setWrapText(true);


        CellStyle cellStyleRight = workbook.createCellStyle();
        cellStyleRight.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cellStyleRight.setFillForegroundColor(HSSFColor.WHITE.index);
        cellStyleRight.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        cellStyleRight.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        cellStyleRight.setBorderRight(XSSFCellStyle.BORDER_THIN);
        cellStyleRight.setBorderTop(XSSFCellStyle.BORDER_THIN);
        cellStyleRight.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        cellStyleRight.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        cellStyleRight.setWrapText(true);

        String[] headers = { "四轮驱动", "重大事件管控", "客户反映", "业务感知","服务感知","竞对感知","场景感知","最差感知","覆盖感知","容量感知","结构感知","短板分析"};
        String[]  headers2={ "", "排名 地市/区域", "排名 地市/区域", "排名 地市/区域","排名 地市/区域","排名 地市/区域","排名 地市/区域","排名 地市/区域","排名 地市/区域","排名 地市/区域","排名 地市/区域",""};

        //String[] headers1 = { "排名 地市/区域", "排名 地市/区域", "排名 地市/区域", "排名 地市/区域","服务感知","竞对感知","场景感知","最差感知","覆盖感知","容量感知","结构感知","短板分析"};

        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet();

        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 18);
        sheet.setColumnWidth(0,1600);
        XSSFRow row = sheet.createRow(0);
        XSSFRow row1 = sheet.createRow(1);
        for (short i = 0; i < headers.length; i++) {
            XSSFCell cell = row.createCell(i);
            XSSFRichTextString text = new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
            cell.setCellStyle(cellStyleHeader);

            XSSFCell cell1 = row1.createCell(i);
            XSSFRichTextString text1 = new XSSFRichTextString(headers2[i]);
            cell1.setCellValue(text1);
            cell1.setCellStyle(cellStyleHeader);

        }

        for(short n=2;n<12;n++){
            XSSFRow rowLun1 = sheet.createRow(n);

            for(short m=0;m<headers.length;m++){
                XSSFCell cellT = rowLun1.createCell(m);
                XSSFRichTextString textT = new XSSFRichTextString(json.getJSONObject(n-2).getString(headers[m]));
                cellT.setCellValue(textT);

                XSSFCell cell0 = rowLun1.createCell(0);
                XSSFRichTextString text0 = new XSSFRichTextString(json.getJSONObject(n-2).getString(headers[0]));
                cell0.setCellValue(text0);
                XSSFCell cell11= rowLun1.createCell(11);
                XSSFRichTextString text11 = new XSSFRichTextString(json.getJSONObject(n-2).getString(headers[11]));
                cell11.setCellValue(text11);

                cell0.setCellStyle(cellStyleLeft1);
                cell11.setCellStyle(cellStyleRight);
                if(n==11 && m!=headers.length-1 )
                    cellT.setCellStyle(cellStyleAll);
            }

        }
        for(short n=12;n<22;n++){
            XSSFRow rowLun1 = sheet.createRow(n);

            for(short m=0;m<headers.length;m++){
                XSSFCell cellT = rowLun1.createCell(m);
                XSSFRichTextString textT = new XSSFRichTextString(json.getJSONObject(n-2).getString(headers[m]));
                cellT.setCellValue(textT);

                XSSFCell cell0 = rowLun1.createCell(0);
                XSSFRichTextString text0 = new XSSFRichTextString(json.getJSONObject(n-2).getString(headers[0]));
                cell0.setCellValue(text0);
                XSSFCell cell11= rowLun1.createCell(11);
                XSSFRichTextString text11 = new XSSFRichTextString(json.getJSONObject(n-2).getString(headers[11]));
                cell11.setCellValue(text11);

                cell0.setCellStyle(cellStyleLeft2);
                cell11.setCellStyle(cellStyleRight);
                if(n==21&& m!=headers.length-1)
                    cellT.setCellStyle(cellStyleAll);
            }
        }
        for(short n=22;n<32;n++){
            XSSFRow rowLun1 = sheet.createRow(n);

            for(short m=0;m<headers.length;m++){
                XSSFCell cellT = rowLun1.createCell(m);
                XSSFRichTextString textT = new XSSFRichTextString(json.getJSONObject(n-2).getString(headers[m]));
                cellT.setCellValue(textT);

                XSSFCell cell0 = rowLun1.createCell(0);
                XSSFRichTextString text0 = new XSSFRichTextString(json.getJSONObject(n-2).getString(headers[0]));
                cell0.setCellValue(text0);
                XSSFCell cell11= rowLun1.createCell(11);
                XSSFRichTextString text11 = new XSSFRichTextString(json.getJSONObject(n-2).getString(headers[11]));
                cell11.setCellValue(text11);

                cell0.setCellStyle(cellStyleLeft3);
                cell11.setCellStyle(cellStyleRight);
                if(n==31&& m!=headers.length-1)
                    cellT.setCellStyle(cellStyleAll);
            }
        }
        for(short n=32;n<42;n++){
            XSSFRow rowLun1 = sheet.createRow(n);

            for(short m=0;m<headers.length;m++){
                XSSFCell cellT = rowLun1.createCell(m);
                XSSFRichTextString textT = new XSSFRichTextString(json.getJSONObject(n-2).getString(headers[m]));
                cellT.setCellValue(textT);

                XSSFCell cell0 = rowLun1.createCell(0);
                XSSFRichTextString text0 = new XSSFRichTextString(json.getJSONObject(n-2).getString(headers[0]));
                cell0.setCellValue(text0);
                XSSFCell cell11= rowLun1.createCell(11);
                XSSFRichTextString text11 = new XSSFRichTextString(json.getJSONObject(n-2).getString(headers[11]));
                cell11.setCellValue(text11);

                cell0.setCellStyle(cellStyleLeft4);
                cell11.setCellStyle(cellStyleRight);
                if(n==41&& m!=headers.length-1)
                    cellT.setCellStyle(cellStyleAll);
            }
        }
        for(short n=42;n<52;n++){
            XSSFRow rowLun1 = sheet.createRow(n);

            for(short m=0;m<headers.length;m++){
                XSSFCell cellT = rowLun1.createCell(m);
                XSSFRichTextString textT = new XSSFRichTextString(json.getJSONObject(n-2).getString(headers[m]));
                cellT.setCellValue(textT);

                XSSFCell cell0 = rowLun1.createCell(0);
                XSSFRichTextString text0 = new XSSFRichTextString(json.getJSONObject(n-2).getString(headers[0]));
                cell0.setCellValue(text0);
                XSSFCell cell11= rowLun1.createCell(11);
                XSSFRichTextString text11 = new XSSFRichTextString(json.getJSONObject(n-2).getString(headers[11]));
                cell11.setCellValue(text11);

                cell0.setCellStyle(cellStyleLeft5);
                cell11.setCellStyle(cellStyleRight);
                if(n==51&& m!=headers.length-1)
                    cellT.setCellStyle(cellStyleAll);
            }
        }

        /*int rownum=sheet.getLastRowNum();
        int colnum=row.getLastCellNum();
        for(int i=2;i<rownum;i++){
            XSSFRow rowTest=sheet.getRow(i);
            XSSFCell cellLet=rowTest.getCell(0);
            cellLet.setCellStyle(cellStyleAll);
            XSSFCell cellRight=rowTest.getCell(colnum-1);
            cellRight.setCellStyle(cellStyleAll);

        }*/

        sheet.addMergedRegion(new CellRangeAddress(0,1,0,0));
        sheet.addMergedRegion(new CellRangeAddress(0,1,11,11));
        sheet.addMergedRegion(new CellRangeAddress(2,11,0,0));
        sheet.addMergedRegion(new CellRangeAddress(2,11,11,11));
        sheet.addMergedRegion(new CellRangeAddress(12,21,0,0));
        sheet.addMergedRegion(new CellRangeAddress(12,21,11,11));
        sheet.addMergedRegion(new CellRangeAddress(22,31,0,0));
        sheet.addMergedRegion(new CellRangeAddress(22,31,11,11));
        sheet.addMergedRegion(new CellRangeAddress(32,41,0,0));
        sheet.addMergedRegion(new CellRangeAddress(32,41,11,11));
        sheet.addMergedRegion(new CellRangeAddress(42,51,0,0));
        sheet.addMergedRegion(new CellRangeAddress(42,51,11,11));

        sheet.createFreezePane(1,2,1,2); //冻结头两行，第一列
        //sheet.createFreezePane(2,2,0,2); //冻结头两行
        return workbook;
    }

    //全量数据导出
    public  XSSFWorkbook exportAllData(List<NeiKpi> headerList, List<Map<String, Object>> dataList, int Month){
        //JSONArray json=JSONArray.parseArray(jsonData);
        // 声明一个工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        sheet.setColumnWidth(0, 2000);
        for(int i=1;i<headerList.size();i++){
            sheet.setColumnWidth(i, 4000);
        }
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 18);

        //开始生成表头
        XSSFRow row = sheet.createRow(0);
        XSSFRow row1 = sheet.createRow(1);
        XSSFRow row2 = sheet.createRow(2);
        XSSFRow row3 = sheet.createRow(3);
        XSSFRow row4 = sheet.createRow(4);

        XSSFCell cellMonth=row.createCell(0);
        cellMonth.setCellValue(Month);
        XSSFCell cellMonth1=row.createCell(1);
        cellMonth1.setCellValue(Month);

        XSSFCell cellDim=row1.createCell(0);
        cellDim.setCellValue("维度");
        XSSFCell cellDim1=row1.createCell(1);
        cellDim1.setCellValue("维度");

        XSSFCell cellSubDim=row2.createCell(0);
        cellSubDim.setCellValue("子维度");
        XSSFCell cellSubDim1=row2.createCell(1);
        cellSubDim1.setCellValue("子维度");

        XSSFCell cellSource=row3.createCell(0);
        cellSource.setCellValue("数据来源");
        XSSFCell cellSource1=row3.createCell(1);
        cellSource1.setCellValue("数据来源");

        XSSFCell cellName=row4.createCell(0);
        cellName.setCellValue("指标名称");
        XSSFCell cellName1=row4.createCell(1);
        cellName1.setCellValue("指标名称");

        for(int i=0;i<headerList.size();i++){
            XSSFCell cellMonthX=row.createCell(i+2);
            cellMonthX.setCellValue(headerList.get(i).getBusinessType());

            XSSFCell cellDimX=row1.createCell(i+2);
            cellDimX.setCellValue(headerList.get(i).getDimension());


            XSSFCell cellSubDimX=row2.createCell(i+2);
            cellSubDimX.setCellValue(headerList.get(i).getSubDimension());

            XSSFCell cellSourceX=row3.createCell(i+2);
            cellSourceX.setCellValue(headerList.get(i).getFetchPlatform());


            XSSFCell cellNameX=row4.createCell(i+2);
            cellNameX.setCellValue(headerList.get(i).getKpiInfo());

        }
        //生成起始日期
        Calendar cal =Calendar.getInstance();
        cal.set(Calendar.MONTH,Month-1);
        Integer firstDate=(cal.get(Calendar.YEAR)-1)*10000+Month*100;//例如：5月0日的数据，设定为全月的加权得分值
        cal.add(Calendar.MONTH,1);
        cal.set(Calendar.DAY_OF_MONTH,0);
        Integer lastDate=(cal.get(Calendar.YEAR)-1)*10000+Month*100+cal.get(Calendar.DAY_OF_MONTH);

        //初始化最终数据表
        HashMap finalList=new HashMap();
        for(int i=firstDate;i<=lastDate;i++){
            finalList.put(i+"_"+590,new JSONObject());
            finalList.put(i+"_"+591,new JSONObject());
            finalList.put(i+"_"+592,new JSONObject());
            finalList.put(i+"_"+593,new JSONObject());
            finalList.put(i+"_"+594,new JSONObject());
            finalList.put(i+"_"+595,new JSONObject());
            finalList.put(i+"_"+596,new JSONObject());
            finalList.put(i+"_"+597,new JSONObject());
            finalList.put(i+"_"+598,new JSONObject());
            finalList.put(i+"_"+599,new JSONObject());

        }

        //循环读取每一条数据，按CITY和日期字段拼接出HASH表的KEY值，在最终返回表中填入
        for(int i=0;i<dataList.size();i++){
            Map<String, Object> data=dataList.get(i);
            String finalKey=data.get("DATE_ID")+"_"+data.get("CITY");
            JSONObject objJson=(JSONObject)finalList.get(finalKey);
            if(objJson!=null){
                String dataKey=data.get("BUSINESS_TYPE")+"_"+data.get("DIMENSION")+"_"+data.get("KPI_INFO");
                objJson.put(dataKey,data.get("CURRENT_VALUE"));
                finalList.put(finalKey,objJson);
            }

        }

        for(int i=firstDate, l=0;i<=lastDate;i++){

            for(int j=590;j<=599;j++){
                String finalKey=i+"_"+j;
                XSSFRow rowData = sheet.createRow(l+5);
                XSSFCell cellValue1=rowData.createCell(0);
                cellValue1.setCellValue(getCityNameByCode(j));
                XSSFCell cellValue2=rowData.createCell(1);
                cellValue2.setCellValue(dateFormat(i));
                for(int k=0;k<headerList.size();k++){
                    String dataKey=headerList.get(k).getBusinessType()+"_"+headerList.get(k).getDimension()+"_"+headerList.get(k).getKpiInfo();
                    JSONObject objJson=(JSONObject)finalList.get(finalKey);
                    Double  value=objJson.getDoubleValue(dataKey);
                    if(value!=0 && value!=null)
                    {
                        XSSFCell cellValue=rowData.createCell(k+2);
                        cellValue.setCellValue(value);
                    }


                }
                l++;
            }

        }

        CellStyle cellStyleYELLOW = workbook.createCellStyle();
        cellStyleYELLOW.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cellStyleYELLOW.setFillForegroundColor(HSSFColor.YELLOW.index);
        cellStyleYELLOW.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        cellStyleYELLOW.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        cellStyleYELLOW.setBorderRight(XSSFCellStyle.BORDER_THIN);
        cellStyleYELLOW.setBorderTop(XSSFCellStyle.BORDER_THIN);
        cellStyleYELLOW.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        cellStyleYELLOW.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        cellStyleYELLOW.setWrapText(true);

        XSSFFont font =workbook.createFont();
        font.setBold(true);
        CellStyle cellStyleLIME= workbook.createCellStyle();
        cellStyleLIME.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        cellStyleLIME.setFillForegroundColor(HSSFColor.LIME.index);
        cellStyleLIME.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        cellStyleLIME.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        cellStyleLIME.setBorderRight(XSSFCellStyle.BORDER_THIN);
        cellStyleLIME.setBorderTop(XSSFCellStyle.BORDER_THIN);
        cellStyleLIME.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        cellStyleLIME.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        cellStyleLIME.setWrapText(true);
        cellStyleLIME.setFont(font);

        //左侧两列设置成绿色
        int rownum=sheet.getLastRowNum();
        int colnum=row.getLastCellNum();
        for(int i=0;i<rownum+1;i++){
            XSSFRow rowTest=sheet.getRow(i);
            XSSFCell cell1=rowTest.getCell(0);
            cell1.setCellStyle(cellStyleLIME);
            XSSFCell cell2=rowTest.getCell(1);
            cell2.setCellStyle(cellStyleLIME);

        }
        //前5行设置成黄色
        for(int i=2;i<colnum;i++){
            for(int j=0;j<5;j++){
                XSSFRow rowTest=sheet.getRow(j);
                XSSFCell cellTest=rowTest.getCell(i);
                cellTest.setCellStyle(cellStyleYELLOW);
            }

        }
        //冻结行和列的表头
        sheet.createFreezePane(2,5,2,5); //冻结头两行，第一列

        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,1));
        sheet.addMergedRegion(new CellRangeAddress(1,1,0,1));
        sheet.addMergedRegion(new CellRangeAddress(2,2,0,1));
        sheet.addMergedRegion(new CellRangeAddress(3,3,0,1));
        sheet.addMergedRegion(new CellRangeAddress(4,4,0,1));

        return workbook;
    }
    //地市的区号转换
    String getCityNameByCode(int code){
        String city="";
        switch (code) {
            case 591:
                city="福州";
                break;
            case 592:
                city="厦门";
                break;
            case 593:
                city="宁德";
                break;
            case 594:
                city="莆田";
                break;
            case 595:
                city="泉州";
                break;
            case 596:
                city="漳州";
                break;
            case 597:
                city="龙岩";
                break;
            case 598:
                city="三明";
                break;
            case 599:
                city="南平";
                break;
            default:
                city="福建";
                break;
        }
        return city;
    }

    // 将 20180400 这样的时间，格式化成 2018年04月00日的格式
    String dateFormat(int dateFrom){
        String  rtn="";

        SimpleDateFormat dfFrom = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat dfTo = new SimpleDateFormat("yyyy年MM月dd日");
        try {
            if(dateFrom%100==0){
                SimpleDateFormat dfFrom1 = new SimpleDateFormat("yyyyMM");
                SimpleDateFormat dfTo1 = new SimpleDateFormat("yyyy年MM月");
                Date date=dfFrom1.parse(dateFrom/100+"");
                rtn=dfTo1.format(date);
            }else{
                Date date=dfFrom.parse(dateFrom+"");

                rtn=dfTo.format(date);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return rtn;
    }
}
