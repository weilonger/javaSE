package main.java.Test;

public class RegexTest {
    public static void main(String[] args) {
        String string = "0qilin1562";
        String regex = "^0\\w+\\d+$";
        match(string, regex);
        String string1 = "qilin.567beijing23";
        String regex1 = "[^\\d]\\w+\\W.+\\d+$";
        match(string1, regex1);
        String string2 = "(012)12345676";  //012-12345678  (02155555555
        String regex2 = "\\(?0\\d{2}[)-]?\\d{8}";
        match(string2, regex2);
        String string3 = "复仇者联盟3(无限战争)";
        String regex3 = "[\\(|\\[|<|（]{1}.*?[\\)|\\]|>|）]";
        replace(string3, regex3);
    }

    private static void match(String string,String regex){
        if (string.matches(regex)){
            System.out.println(string + " + " + regex + " success match");
            System.out.println("-------------");
        } else {
            System.out.println(string + " + " + regex + " failed match");
            System.out.println("-------------");
        }
    }

    private static void replace(String string, String regex){
        String target = string.replaceAll(regex, "");
        System.out.println(string + " + " + regex + " success replace" + " is " + target);
    }
}
