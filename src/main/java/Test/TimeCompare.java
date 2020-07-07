package main.java.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeCompare {
    
    public static void main(String[] args) {
        String time1 = "2019-07-05 11:09:47";
        String time2 = "2019-07-05 11:09:46";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            System.out.println(sdf.parse(time1).compareTo(sdf.parse(time2)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
       
    }
    
    
}
