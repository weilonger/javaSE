package main.java.leetcode.compete14;

import java.util.ArrayList;
import java.util.List;

/*题目描述
    54. 螺旋矩阵
    给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
*/
/*示例1
    输入:
    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]
    输出: [1,2,3,6,9,8,7,4,5]
 */
/*示例2
    输入:
    [
      [1, 2, 3, 4],
      [5, 6, 7, 8],
      [9,10,11,12]
    ]
    输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SpiralMatrix s = new SpiralMatrix();
        s.spiralOrder(matrix).forEach(System.out::println);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int u = matrix.length - 1;
        int t = 0;
        int l = 0;
        int r = matrix[0].length - 1;
        while (true) {
            for (int i = l; i <= r; i++) {
                result.add(matrix[t][i]);
            }
            if (++t > u) {
                break;
            }
            for (int i = t; i <= u; i++) {
                result.add(matrix[i][r]);
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                result.add(matrix[u][i]);
            }
            if (--u < t) {
                break;
            }
            for (int i = u; i >= t; i--) {
                result.add(matrix[i][l]);
            }
            if (++l > r) {
                break;
            }
        }
        return result;
    }
}
