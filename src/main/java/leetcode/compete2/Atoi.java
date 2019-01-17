package main.java.leetcode.compete2;

public class Atoi {
    //小数点
    public int myAtoi(String str) {
        String number = "0";
        int index = 0;
        for (int i = 1; i < str.length(); i++) {
            if (number == "0"){
                String s = str.substring(0, i);
                index = i - 2;
                number = isValid(s) ? str.substring(index, i) : "0";
                continue;
            } else {
                number = str.substring(index, i);
            }
            if (!number.matches("-?\\d*")) {
                number = number.substring(0, i - 1 - index).trim();
                return Integer.valueOf(number);
            }
        }
        return 0;
    }

    private Boolean isValid(String s) {
        if (s.matches(".*\\d")) {
            //"\\s*-?\\d"
            if (s.matches("[\\w\\s]+|-\\s")) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Atoi a = new Atoi();
        String s = "3.14159";
        System.out.println(a.myAtoi(s));
    }
}
