package main.java.InterviewPrepare.DesignPattern;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexExtra {

    public static void main(String[] args) {
        //()可以捕获匹配到的组，分组根据匹配结果按序号排序
        String s = "helloWorld";
        String regex = "([a-z])([A-Z])";
        System.out.println(s.replaceAll(regex, "$1_$2").toLowerCase());

        RegexExtra regexExtra = new RegexExtra();
        String str = "the-first-name";
        // 转换成小驼峰
        System.out.println(regexExtra.toHump(str, true));
        // 转换成大驼峰
        System.out.println(regexExtra.toHump(str, false));
        // 转换成下划线
        String str1 = "TheFirstName";
        System.out.println(regexExtra.toUnderline(str1));

        /*
          (?s)(.)(?=.*\1) (?s) 开启单行模式 DOTALL 让. 号匹配任意字符 (.) 任意字符, 并捕获在第一组 (?=.*\1) 这是断言, 
      表示后面内容将是 任意个字符加上第一组所捕获的内容 
      这样子,如果这整个式子匹配到,表示,第一个捕获组内容在字符串中,至少出现两次，替换为 "" 空串
         */
        String str2 = "aaaabbbbbccc";
        String regex1 = "(.)(?=.*\\1)";
        String result = regexExtra.getSingleValue(str2);
        System.out.println(result);

        String str3 = "2019-10-22";
        result = regexExtra.getDateExport(str3);
        System.out.println(result);
    }

    private String getSingleValue(String str) {
        String regex1 = "(?<letter>\\w)\\1+";
        Matcher matcher = Pattern.compile(regex1).matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            sb.append(matcher.group("letter"));
        }
        return sb.toString();
//        System.out.println(str2.replaceAll(regex1, ""));
    }

    public String getDateExport(String str) {
        String regex2 = "(?<year>\\d{4})-(?<month>\\d{2})-(?<day>\\d{2})";
        Matcher matcher = Pattern.compile(regex2).matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String year = matcher.group("year");
            String month = matcher.group("month");
            String day = matcher.group("day");
            sb.append(year + "年" + month + "月" + day + "日");
        }
        return sb.toString();
    }

    public String toHump(String str, boolean small) {
        String regex1 = "-(\\w)";
        Matcher matcher = Pattern.compile(regex1).matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String g = matcher.group();
            matcher.appendReplacement(sb, g.toUpperCase());
        }
        matcher.appendTail(sb);
        str = sb.toString().replaceAll("-", "");
        if (small) {
            str = str.substring(0, 1).toLowerCase() + str.substring((1));
        } else {
            str = str.substring(0, 1).toUpperCase() + str.substring((1));
        }
        return str;
    }

    public String toUnderline(String str) {
        String regexStr = "[A-Z]";
        Matcher matcher = Pattern.compile(regexStr).matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String g = matcher.group();
            matcher.appendReplacement(sb, "_" + g.toLowerCase());
        }
        matcher.appendTail(sb);
        if (sb.charAt(0) == '_') {
            sb.delete(0, 1);
        }
        return sb.toString();
    }

}
