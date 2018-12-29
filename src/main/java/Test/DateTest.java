package main.java.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    public static void main(String[] args){
        test1();
    }

    private static void test1(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        String now = format.format(date);
        System.out.println(now);
    }

}
