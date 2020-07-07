package main.java.leetcode.compete16;

/*题目描述
    64. 最小路径和
    给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    说明：每次只能向下或者向右移动一步。
*/
/*示例1
    输入:
    [
      [1,3,1],
      [1,5,1],
      [4,2,1]
    ]
    输出: 7
    解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();
        int[][] grid = new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(m.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (sum[i - 1][j] <= sum[i][j - 1]) {
                    sum[i][j] = sum[i - 1][j] + grid[i][j];
                } else {
                    sum[i][j] = sum[i][j - 1] + grid[i][j];
                }
            }
        }
        return sum[m - 1][n - 1];
    }
}
