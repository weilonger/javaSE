package main.java.leetcode.compete2;

/*题目描述
    8. 字符串转换整数 (atoi)
        请你来实现一个 atoi 函数，使其能将字符串转换成整数。
        首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
        当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
        假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
        该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
        注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
        在任何情况下，若函数不能进行有效的转换时，请返回 0。
    说明：
        假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，
        请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 */
/*示例1：
    输入: "   -42"
    输出: -42
    解释: 第一个非空白字符为 '-', 它是一个负号。我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 */
/*示例2：
    输入: "-91283472332"
    输出: -2147483648
    解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 因此返回 INT_MIN (−2^31) 。
 */
public class Atoi {
    //96ms
    public int myAtoi(String str) {
        String number = "0";
        int index = 0;
        for (int i = 1; i <= str.length(); i++) {
            if (number == "0"){
                String s = str.substring(0, i);
                index = i - 2 >= 0 ? i - 2 : 0;
                number = isValid(s) ? str.substring(index, i) : "0";
                if (i == str.length()) {
                    return getValidInt(number);
                }
                continue;
            } else {
                number = str.substring(index, i);
            }
            if (!number.matches("\\s?[+-]?\\d*")) {
                number = number.substring(0, i - 1 - index).trim();
                return getValidInt(number);
            } else if (i == str.length() && number.matches("\\s?[+-]?\\d*")) {
                number = str.trim();
                return getValidInt(number);
            }
        }
        return 0;
    }

    private Boolean isValid(String s) {
        if (s.matches(".*\\d")) {
            if (s.matches("\\s*[+-]?\\d")) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private int getValidInt(String number) {
        int num;
        try {
            num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            if (number.contains("-")) {
                num = (int)-Math.pow(2, 31);
            } else {
                num = (int)(Math.pow(2, 31) - 1);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Atoi a = new Atoi();
        String s = "  -1";
        System.out.println(a.myAtoi1(s));
    }

    //90ms
    public int myAtoi1(String str) {
        int length = str.length();
        int i = 0;
        int end = 0;
        int start = 0;
        Boolean status = false;
        while (i < length) {
            String match = str.substring(0, i + 1);
            if (match.matches("\\s*[+-]?\\d")){
                start = i - 1 >= 0 ? i - 1 : 0;
                status = true;
            }
            if (i == length - 1 && match.matches("\\s*[+-]?\\d*") && status) {
                end = length;
            }
            if (!match.matches("\\s*[+-]?\\d*")  && status) {
                end = i;
                break;
            }
            i++;
        }
        if (!status) {
            return 0;
        }
        String number = str.substring(start, end).trim();
        return getValidInt(number);
    }
}
