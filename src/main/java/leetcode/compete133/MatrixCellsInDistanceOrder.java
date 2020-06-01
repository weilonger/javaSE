package main.java.leetcode.compete133;

/*
给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，
|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 */
/* 提示：
    1 <= R <= 100
    1 <= C <= 100
    0 <= r0 < R
    0 <= c0 <
 */
public class MatrixCellsInDistanceOrder {

    public static void main(String[] args) {
        MatrixCellsInDistanceOrder m = new MatrixCellsInDistanceOrder();
        int R =3;
        int C = 3;
        int r0 = 0;
        int c0 = 2;
        int[][] result = m.allCellsDistOrder(R, C, r0, c0);
        for (int i = 0; i < R * C; i++) {
            System.out.println("[" + result[i][0] + "," + result[i][1] + "]");
        }
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        result[0][0] = r0;
        result[0][1] = c0;
        boolean[][] status = new boolean[R][C];
        int index = 0;
        int count = 0;
        int last = index - 1;
        while (index < R * C - 1) {
            for (int i = last + 1; i <= index; i++) {
                r0 = result[i][0];
                c0 = result[i][1];
                if (r0 > 0 && c0 >= 0 && !status[r0 - 1][c0]) {
                    count++;
                    index++;
                    result[index][0] = r0 - 1;
                    result[index][1] = c0;
                    status[r0 - 1][c0] = true;
                }
                if (r0 >= 0 && c0 < C - 1 && !status[r0][c0 + 1]) {
                    count++;
                    index++;
                    result[index][0] = r0;
                    result[index][1] = c0 + 1;
                    status[r0][c0 + 1] = true;
                }
                if (r0 < R - 1 && c0 >= 0 && !status[r0 + 1][c0]) {
                    count++;
                    index++;
                    result[index][0] = r0 + 1;
                    result[index][1] = c0;
                    status[r0 + 1][c0] = true;
                }
                if (r0 >= 0 && c0 > 0 && !status[r0][c0 - 1]) {
                    count++;
                    index++;
                    result[index][0] = r0;
                    result[index][1] = c0 - 1;
                    status[r0][c0 - 1] = true;
                }
                status[r0][c0] = true;
                last = index - count;
            }
        }
        return result;
    }

}
