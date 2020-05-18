package main.java.leetcode.compete11;

/*题目描述
    43. 字符串相乘
    给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
*/
/*示例1:
    输入: num1 = "2", num2 = "3"
    输出: "6"
*/
/*示例2:
    输入: num1 = "123", num2 = "456"
    输出: "56088"
*/
/*示例3:
    输入: [7,8,9,11,12]
    输出: 1
 */
/*说明:
    1.num1 和 num2 的长度小于110。
    2.num1 和 num2 只包含数字 0-9。
    3.num1 和 num2 均不以零开头，除非是数字 0 本身。
    4.不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        String result = "0";
        int len1 = num1.length();
        int len2 = num2.length();
        if (num1.equals("0") || num2.equals("0")) {
            return result;
        }
        int[] mul = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int multi = x * y + mul[i + j +1];
                mul[i + j] += multi / 10;
                mul[i + j + 1] = multi % 10;
            }
        }
        
        StringBuilder buffer = new StringBuilder();
        int k = 0;
        while (mul[k] == 0 && k < mul.length - 1) {
            k++;
        }
        for (; k < mul.length; k++) {
            buffer.append(mul[k]);
        }
        result = buffer.toString();
        return result;
    }
    
    public static void main(String[] args) {
        MultiplyStrings m = new MultiplyStrings();
        String num1 = "123";
        String num2 = "456";
        System.out.println(m.multiply(num1, num2));
    }
}
