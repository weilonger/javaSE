package main.java.leetcode.compete4;

import java.util.HashMap;
import java.util.Map;

/*题目描述
    13. 罗马数字转整数
        字符          数值
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
    通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
    数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
    I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
    X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
    C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
    给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
*/
/*示例1：
    输入: "IV"
    输出: 4
 */
/*示例2：
    输入: "LVIII"
    输出: 58
    解释: L = 50, V= 5, III = 3.
 */
/*示例3：
    输入: "MCMXCIV"
    输出: 1994
    解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class RomanToInteger {
    //69ms
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int values[]={1000,500,100,50,10,5,1};
        Character reps[]={'M','D','C','L','X','V','I'};
        for (int i = 0; i < reps.length; i++) {
            map.put(reps[i], values[i]);
        }
        int num = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            num += map.get(s.charAt(i));
            if (i > 0 && i < length && map.get(s.charAt(i - 1)) < map.get(s.charAt(i))) {
                num -= 2 * map.get(s.charAt(i - 1));
            }
        }
        return num;
    }

    public static void main(String[] args) {
        RomanToInteger r = new RomanToInteger();
        String s = "LVIII";
        System.out.println(r.romanToInt(s));
    }


}
