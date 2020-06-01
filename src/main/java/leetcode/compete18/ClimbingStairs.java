package main.java.leetcode.compete18;

/*题目描述
    70. 爬楼梯
    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    注意：给定 n 是一个正整数。
*/
/*示例1：
    输入： 2
    输出： 2
    解释： 有两种方法可以爬到楼顶。
    1.  1 阶 + 1 阶
    2.  2 阶
 */
/*示例2：
    输入： 3
    输出： 3
    解释： 有三种方法可以爬到楼顶。
    1.  1 阶 + 1 阶 + 1 阶
    2.  1 阶 + 2 阶
    3.  2 阶 + 1 阶
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs c = new ClimbingStairs();
        int n = 8;
        System.out.println(c.climbStairs(n));
    }

    //前两个跨两部 + 前一个跨一步
    public int climbStairs(int n) {
        int[] count = new int[n];
        count[0] = 1;
        if (n <= 1) {
            return count[n - 1];
        }
        count[1] = 2;
        for (int i = 2; i < n; i++) {
            count[i] = count[i - 2] + count[i - 1];
        }
        return count[n - 1];
    }
}
