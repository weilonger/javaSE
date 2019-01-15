package main.java.leetcode.compete118;

import java.util.ArrayList;
import java.util.List;

/*题目描述
    970. 强整数
    给定两个非负整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
    返回值小于或等于 bound 的所有强整数组成的列表。你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
 */
/*示例 1：
    输入：x = 2, y = 3, bound = 10
    输出：[2,3,4,5,7,9,10]
    解释：
    2 = 2^0 + 3^0
    3 = 2^1 + 3^0
    4 = 2^0 + 3^1
    5 = 2^1 + 3^1
    7 = 2^2 + 3^1
    9 = 2^3 + 3^0
    10 = 2^0 + 3^2
 */
/*示例 2：
    输入：x = 3, y = 5, bound = 15
    输出：[2,4,6,8,10,14]
 */
/*提示：
    1 <= x <= 100
    1 <= y <= 100
    0 <= bound <= 10^6
 */
public class BigInteger {

    public static void main(String[] args) {
        List<Integer> list = powerfulIntegers(4, 100, 100);
        list.forEach(System.out::println);
    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> list = new ArrayList<>();
        //排除不符合的输入
        if (x < 1 || x > 100 || y < 1 || y > 100 || bound < 2 || bound > 1000000 || x > bound || y > bound) {
            return list;
        }
        int xi = getIndex(x, bound);
        int yj = getIndex(y, bound);
        for (int i = 0; i <= xi; i++) {
            for (int j = 0; j <= yj; j++) {
                int big = (int) Math.floor(Math.pow(x, i) + Math.pow(y, j));
                if (big <= bound && !list.contains(big)) {
                    list.add(big);
                }
            }
        }
        return list;
    }

    //返回index值
    private static int getIndex(int x, int bound) {
        if (bound == 2 || x == 1) {
            return 0;
        } else {
            for (int i = 0; i < 1 + bound / x; i++) {
                if ((Math.pow(x, i) <= bound && Math.pow(x, i + 1) > bound)) {
                    return i;
                }
            }
        }
        throw new IllegalArgumentException("not get index");
    }
}
