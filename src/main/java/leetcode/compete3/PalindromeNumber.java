package main.java.leetcode.compete3;

/*题目描述
    9. 回文数
    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
/*示例1：
    输入: 121
    输出: true
 */
/*示例2：
    输入: -121
    输出: false
    解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 */
/*示例3：
    输入: 10
    输出: false
    解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class PalindromeNumber {
    //225ms
    /*
    复杂度分析
        时间复杂度：O(log 10(n))， 对于每次迭代，我们会将输入除以10，因此时间复杂度为O(log10(n))。
        空间复杂度：O(1)。
     */
    public boolean isPalindrome(int x) {
        String y = String.valueOf(x);
        int length = y.length();
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int m = length / 2;
        for (int i = 0; i < m; i ++) {
            if (y.charAt(i) != y.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        int x = 121;
        System.out.println(p.isPalindrome(x));
    }
}
