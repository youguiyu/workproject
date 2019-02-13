package com.ygy.syh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Test {

    public static List<String> txt2String(File file){
        StringBuilder result = new StringBuilder();
        List<String> aaa= new ArrayList<String>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行

                String[]t =s.split("-");
                Integer temp = Integer.valueOf(t[2])*256 + Integer.valueOf(t[3]);
                aaa.add("'"+temp.toString()+"'");
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return aaa;
    }


    public static List<String> txt2String2(File file){
        StringBuilder result = new StringBuilder();
        List<String> aaa= new ArrayList<String>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行


               // Integer temp = Integer.valueOf(t[2])*256 + Integer.valueOf(t[3]);
                aaa.add("'"+s+"'");
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return aaa;
    }
    public static void main(String[] args){
        File file = new File("D:/a.txt");
      // System.out.println(txt2String(file));
        System.out.println(txt2String2(file));

        //System.out.println(getDayBefore(2));
    }
    public  static  String getDayBefore(int i){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1*i);
        date = calendar.getTime();

        return sdf.format(date);
    }
}

//    public static void main(String []args){
//        SimpleDateFormat df= new SimpleDateFormat("yyyyMMddHH");
//        Calendar nowTime=Calendar.getInstance();
//        nowTime.add(Calendar.MINUTE,-10*2);
//        int minute=nowTime.get(Calendar.MINUTE);
//
//        String nowStr=df.format(nowTime.getTime())+String.format("%02d",minute/10*10);
//
//        System.out.println(nowStr);
//    }

