package main.java.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        String time = "1984年01月01日";
        String date = "19840101";
        String s = "1992(首映)/暂无(中国大陆)";
        String a = format(time);
        String b = format(date);
        String c = format(s);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        String d = "1992-11-02";
        String e =c.compareToIgnoreCase(d) > 0 ? c : d;
        System.out.println(e);
    }
    
    private static String format(String date) {
        SimpleDateFormat result_format = new SimpleDateFormat("yyyy年MM月dd日");
        SimpleDateFormat source_format = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = "1970-01-01";
        try {
            Date d;
            if (date.matches("\\d{4}年\\d{2}月\\d{2}日")) {
                d = result_format.parse(date);
                result = format.format(d);
            } else if (date.matches("\\d{8}")){
                d = source_format.parse(date);
                result = format.format(d);
            } else {
                result = date.substring(0, 4).concat("-01-01");
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    private static void test() {
        System.out.println('I' + 'T');
    }
}
