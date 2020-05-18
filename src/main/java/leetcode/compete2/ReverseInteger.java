package main.java.leetcode.compete2;

import java.util.ArrayList;
import java.util.List;

/*题目描述
    7.整数反转
    给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
/*示例1：
    输入: 123
    输出: 321
 */
/*示例2：
    输入: -123
    输出: -321
 */
/*示例3：
    输入: 120
    输出: 21
 */
/*注意:
    假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]，如果反转后整数溢出那么就返回 0。
 */

public class ReverseInteger {
    //42ms
    /*
        时间复杂度：O(log(x))，x 中大约有log10(x)位数字。
        空间复杂度：O(1)。
     */
    public int reverse(int x) {
        List<Integer> list = new ArrayList<>();
        long revert = x % 10;
        x = ((x -(int) revert) / 10);
        while (x != 0) {
            int y = x % 10;
            revert = revert * 10 + y;
            x = (x - y) / 10;
        }
        if (revert > Math.pow(2, 31) -1 || revert < -Math.pow(2,31)) {
            revert = 0;
        }
        return (int) revert;
    }
    
    public int reverse1(int x) {
        long y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        if (y < Integer.MIN_VALUE || y > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)y;
        }
    }

    public int reverse2(int x) {
        int y = 0;
        while (x != 0) {
            int tail = x % 10;
            x = x / 10;
            if (y > Integer.MAX_VALUE / 10 || y < Integer.MIN_VALUE / 10 || (y == Integer.MAX_VALUE / 10 && tail > 7 ) || (y == Integer.MIN_VALUE / 10 && tail < -8)) {
                return 0;
            }
            y = y * 10 + tail;
        }
        return y;
    }
    
    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();
        int x = -2147483648;
        System.out.println(r.reverse2(x));
    }
}
