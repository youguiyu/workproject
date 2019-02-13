package com.xngls.neiproj.pk;

import com.xngls.neiproj.entity.NeiValue;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public  static void main(String[] args){
//       String time ="2018年07月";
//       String timerang1 = time.substring(0,4)+time.substring(5,7)+"00";
//       System.out.println(timerang1);

//        Integer time =20180811;
//        String f= formatTime(time);
//       // System.out.println(f);
//        String s ="2018年08月14日:泉州:LTE总小区数(个)";
//        String [] temp = s.split(":");
//        System.out.println(temp[0].length());
//        String shijian1 = temp[0].substring(0,4)+temp[0].substring(5,7)+"00";
//
//        String shijian = temp[0].substring(0,4)+temp[0].substring(5,7)+temp[0].substring(8,10);
//
//        System.out.println(shijian1);
//        System.out.println(shijian);


//        List<Integer> intList = new ArrayList<Integer>();
//        intList.add(1);
//        intList.add(2);
//        intList.add(3);
//        intList.add(4);
//        intList.add(5);
//        intList.add(6);
//        intList.add(7);
//        intList.add(8);
//        intList.add(9);
//        intList.add(10);
//        intList.add(11);
//        List<Integer> subSets = intList.subList(0,2);
//
//        List<Integer> subSets1 = intList.subList(3,6);
//        int i=1;
//        List< List<Integer>> neiValuesList = new ArrayList< List<Integer>>();
//        while(i<(intList.size()/3)+2){
//            if(i==(intList.size()/3)+1){
//                List<Integer> neiValues1= intList.subList((i-1)*3,intList.size());
//                neiValuesList.add(neiValues1);
//            }else {
//                List<Integer> neiValues1= intList.subList((i-1)*3,i*3);
//                neiValuesList.add(neiValues1);
//            }
//
//            i++;
//        }
//
//        System.out.println(neiValuesList);

        String temp = formatTime(20180700);

        String temp1="福州";
        System.out.println(temp1.indexOf("市"));

    }


    public static String  formatTime(Integer dateId) {
        String time = dateId.toString();
        String time1="";
        if(time.substring(6,time.length()).equals("00")){
            time1 = time.substring(0,4)+"年"+time.substring(4,6)+"月";

        }else {
            time1 = time.substring(0,4)+"年"+time.substring(4,6)+"月"+time.substring(6,time.length())+"日";

        }
        return time1;
    }
}
