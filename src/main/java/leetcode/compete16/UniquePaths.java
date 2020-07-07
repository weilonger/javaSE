package main.java.leetcode.compete16;


import java.util.Scanner;

/*题目描述
    62. 不同路径
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
    问总共有多少条不同的路径？
    说明：m 和 n 的值均不超过 100。
*/
/*示例1
    输入: m = 3, n = 2
    输出: 3
    解释:
    从左上角开始，总共有 3 条路径可以到达右下角。
    1. 向右 -> 向右 -> 向下
    2. 向右 -> 向下 -> 向右
    3. 向下 -> 向右 -> 向右
 */
/*示例2
    输入: m = 7, n = 3
    输出: 28
 */
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入列数m：");
            int m = scanner.nextInt();
            System.out.print("请输入行数n：");
            int n = scanner.nextInt();
            System.out.println(u.uniquePaths(m, n));
        }
    }

    public int uniquePaths(int m, int n) {
        int[][] count = new int[m][n];
        for (int i = 0; i < n; i++) {
            count[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            count[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                count[i][j] = count[i - 1][j] + count[i][j - 1];
            }
        }

        return count[m - 1][n - 1];
    }
}
