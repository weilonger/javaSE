package main.java.leetcode.compete10;

import java.util.HashMap;
import java.util.Map;

/*题目描述
    38. 报数
    报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
        1.     1
        2.     11
        3.     21
        4.     1211
        5.     111221
    1 被读作  "one 1"  ("一个一") , 即 11。
    11 被读作 "two 1s" ("两个一"）, 即 21。
    21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
    给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
    注意:整数顺序将表示为一个字符串。
*/
/*示例1:
    输入: 1
    输出: "1"
*/
/*示例2:
    输入: 4
    输出: "1211"
*/
public class CountAndSay {
    //8ms
    public String countAndSay(int n) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        for (int i = 2; i <= n; i++) {
            String temp = map.get(i - 1);
            String result = "";
            int len = temp.length();
            int cur = 0;
            for (int j = 0; j < len; j++) {
                if (temp.charAt(j) != temp.charAt(cur)) {
                    if (j > cur) {
                        result = result.concat(String.valueOf(j - cur).concat(temp.substring(cur, cur + 1)));
                    }
                    cur = j;
                    j--;
                }
                if (j + 1 == len) {
                    result = result.concat(String.valueOf(len - cur)).concat(temp.substring(j, j + 1));
                }
            }
            map.put(i, result);
        }
        return map.get(n);
    }

    public static void main(String[] args) {
        CountAndSay c = new CountAndSay();
        System.out.println(c.countAndSay(6));
//        for (int i = 1; i <= 30; i++) {
//            System.out.println(c.countAndSay(i));
//        }
    }
}
