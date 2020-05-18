package main.java.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    public static void main(String[] args){
        test2();
    }

    private static void test1(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String now = format.format(date);
        System.out.println(now);
    }
    
    private static void test2(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String now = format.format(date);
        System.out.println(now);
        System.out.println(date);
    }

}
