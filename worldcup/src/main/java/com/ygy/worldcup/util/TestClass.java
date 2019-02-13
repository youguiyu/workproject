package com.ygy.worldcup.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestClass {
   public static void main(String []args){
       System.out.println("aaa");
       String minTime=getMinTime(3,"201806222220");
   }

    private static String getMinTime(int temp, String maxTime) {
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
