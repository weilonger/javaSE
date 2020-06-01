package main.java.leetcode.compete12;

//同一类型
/*题目描述
    48. 旋转图像
    给定一个 n × n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。
*/

/*说明：
    你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 */
/*示例1:
   给定 matrix =
        [
          [1,2,3],
          [4,5,6],
          [7,8,9]
        ],

        原地旋转输入矩阵，使其变为:
        [
          [7,4,1],
          [8,5,2],
          [9,6,3]
        ]
*/
// 0ms 击败100%
public class RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int[][] result = new int[len][len];
        int len1 = 0;
        int len2 = len - 1;
        while (len1 <= len2) {
            int p1 = len1;
            int p2 = len2;
            while (p1 != len2) {
                int temp = matrix[len1][p1];
                matrix[len1][p1] = matrix[p2][len1];
                matrix[p2][len1] = matrix[len2][p2];
                matrix[len2][p2] = matrix[p1][len2];
                matrix[p1][len2] = temp;
                p2--;
                p1++;
            }
            len1++;
            len2--;
        }
//        for (int j = 0; j < len; j++) {
//            for (int i = len - 1; i >= 0; i--) {
//                System.out.print(matrix[i][j] + " ");
//            }
//        }
    }

    /**
     * 自外向内一共有不超过 n/2 层（单个中心元素不算一层）矩形框。对于第 times 层矩形框，
     * 其框边长 len=nums-(times*2)，将其顺时针分为 4 份 len-1 的边，对四条边进行元素的循环交换即可。
     */
    public void rotate1(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int nums = matrix.length;
        int times = 0;
        while (times <= (nums >> 1)) {
            int len = nums - (times << 1);
            for (int i = 0; i < len - 1; ++i) {
                int temp = matrix[times][times + i];
                matrix[times][times + i] = matrix[times + len - i - 1][times];
                matrix[times + len - i - 1][times] = matrix[times + len - 1][times + len - i - 1];
                matrix[times + len - 1][times + len - i - 1] = matrix[times + i][times + len - 1];
                matrix[times + i][times + len - 1] = temp;
            }
            ++times;
        }
    }

    public static void main(String[] args) {
        RotateImage r = new RotateImage();
        int[][] matrix;
        matrix = new int[][] {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        r.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
