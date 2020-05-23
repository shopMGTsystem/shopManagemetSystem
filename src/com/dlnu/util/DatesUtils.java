package com.dlnu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatesUtils {
    private static String pat1 = "yyyy-MM-dd HH:mm:ss";
    private static String pat2 = "yyyy年MM月dd日 HH:mm:ss";
    //实例化
    private static SimpleDateFormat sdf1 = new SimpleDateFormat(pat1);
    private static SimpleDateFormat sdf2 = new SimpleDateFormat(pat2);

    public static void main(String[] args) {
        Date dates = Dates();
        String string = sdf1.format(dates);
        System.out.println(string);
        System.out.println(getTime(string));
    }

    public static Long formatTime(String string){
        Date date = null;
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = Date(sf.parse(string));
        }catch (ParseException e){
            e.printStackTrace();
        }
        return date.getTime();
    }

    public static Date Date(Date date){
        Date datetimeDate;
        datetimeDate = new Date(date.getTime());
        return datetimeDate;
    }

    public static Date Dates(){
        Date datetimeDate;
        datetimeDate = new Date();
        return datetimeDate;
    }

    public static String getTime(String commitDate){
        Date nowTime = new Date();
        String curDate = sdf1.format(nowTime);
        Date date = null;
        try {
            //取出字符串中的日期
            date = sdf1.parse(commitDate);
        }catch (ParseException e){
            e.printStackTrace();
        }
        int nowDate = Integer.parseInt(curDate.substring(8,10));
        int commit = Integer.parseInt(commitDate.substring(8,10));
        String monthDay = sdf2.format(date).substring(5,12);
        String yearMonthDay = sdf2.format(date).substring(0,12);
        int month = Integer.parseInt(monthDay.substring(0,2));
        int day = Integer.parseInt(monthDay.substring(3,5));
        if (month < 10 && day < 10){
            monthDay = monthDay.substring(1,3) + monthDay.substring(4);
        }else if (month < 10){
            monthDay = monthDay.substring(1);
        }else if (day < 10){
            monthDay = monthDay.substring(0,3) + monthDay.substring(4);
        }
        int yearMonth = Integer.parseInt(yearMonthDay.substring(5,7));
        int yearDay = Integer.parseInt(yearMonthDay.substring(8,10));
        if (yearMonth < 10 && yearDay < 10){
            yearMonthDay = yearMonthDay.substring(0,5) + yearMonthDay.substring(6,8) + yearMonthDay.substring(9);
        }else if (yearMonth < 10){
            yearMonthDay = yearMonthDay.substring(0,5) + yearMonthDay.substring(6);
        }else if (yearDay < 10){
            yearMonthDay = yearMonthDay.substring(0,8) + yearMonthDay.substring(9);
        }
        String str = " 00:00:00";
        float curDay = formatTime(curDate.substring(0,10) + str);
        float commitDay = formatTime(commitDate.substring(0,10) + str);
        int curYear = Integer.parseInt(curDate.substring(0,4));
        int commitYear = Integer.parseInt(commitDate.substring(0,4));
        int flag = (int) (formatTime(curDate)/1000 - formatTime(commitDate)/1000);
        String des = null;
        String hourMin = commitDate.substring(11,16);
        int temp = flag;
        if (temp < 60){
            System.out.println("A");
            if (commitDay < curDay){
                des = "昨天" + hourMin;
            }else {
                des = "刚刚";
            }
        }else if (temp < 60 * 60){
            System.out.println("B");
            if (commitDay < curDay){
                des = "昨天" + hourMin;
            }else {
                des = temp / 60 + "分钟前";
            }
        }else if (temp < 60 * 60 * 24){
            System.out.println("C");
            int hour = temp / (60 * 60);
            if (commitDay < curDay){
                des = "昨天" + hourMin;
            }else {
                if (hour < 6){
                    des = hour + "小时前";
                }else {
                    des = hourMin;
                }
            }
        }else if (temp < (60 * 60 * 24 * 2)){
            System.out.println("D");
            if (nowDate - commit == 1){
                des = "昨天" + hourMin;
            }else {
                des = "前天" + hourMin;
            }
        }else if (temp < (60 * 60 * 24 * 3)){
            System.out.println("E");
            if (nowDate - commit == 2){
                des = "前天" + hourMin;
            }else {
                if (commitYear < curYear){
                    des = yearMonthDay + hourMin;
                }else {
                    des = monthDay + hourMin;
                }
            }
        }else {
            System.out.println("F");
            if (commitYear < curYear){
                des = yearMonthDay + hourMin;
            }else {
                des = monthDay + hourMin;
            }
        }
        if (des == null){
            des = commitDate;
        }
        return des;
    }

    public static Date Date(){
        Date datetimeDate;
        datetimeDate = new Date();
        return datetimeDate;
    }

    public static String getCommentTime(Date date){
        String commitDate = sdf1.format(date);
        String commentTime = getTime(commitDate);
        return commentTime;
    }

}
