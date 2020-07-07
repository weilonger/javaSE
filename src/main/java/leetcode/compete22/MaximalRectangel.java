package main.java.leetcode.compete22;

import java.util.Arrays;

/*题目描述
    85. 最大矩形
    给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
*/
/*示例：
    输入:
    [
      ["1","0","1","0","0"],
      ["1","0","1","1","1"],
      ["1","1","1","1","1"],
      ["1","0","0","1","0"]
    ]
输出: 6
 */
public class MaximalRectangel {

    public static void main(String[] args) {
        MaximalRectangel m = new MaximalRectangel();
        char[][] matrix = new char[][] {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(m.maximalRectangle(matrix));
    }

    /**
     * 思路一:栈
     * 我们只要遍历每行的高度,用上一题方法(栈)求出最大矩形!
     * 思路二:动态规划
     * 用height_j记录第i行为底,第j列高度是多少.
     * 用left_j记录第i行为底, 第j列左边第一个小于height_j[j]的位置
     * 用right_j记录第i行为底, 第j列右边第一个小于height_j[j]的位置
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        int area = 0;
        for (int i = 0; i < m; i++) {
            int cur_left = -1;
            int cur_right = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    left[j] = -1;
                    cur_left = j;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            for (int j = 0; j < n; j++) {
                area = Math.max(area, (right[j] - left[j] - 1) * height[j]);
            }
        }
        return area;
    }
}
