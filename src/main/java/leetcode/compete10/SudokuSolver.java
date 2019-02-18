package main.java.leetcode.compete10;

import java.util.HashSet;
import java.util.Set;

/*题目描述
    37. 解数独
    编写一个程序，通过已填充的空格来解决数独问题。
    一个数独的解法需遵循如下规则：
        数字 1-9 在每一行只能出现一次。
        数字 1-9 在每一列只能出现一次。
        数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
    空白格用 '.' 表示。
    图片地址：
        http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png
        http://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png
*/
/*说明：
    给定的数独序列只包含数字 1-9 和字符 '.' 。
    你可以假设给定的数独只有唯一解。
    给定数独永远是 9x9 形式的。
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        Set<Integer> sum = new HashSet<>();
        boolean status = true;
        for (int i = 1; i < 10; i++) {
            sum.add(i);
        }
        int j = 0;
        int k = 0;
        for (; j < 9; j++) {
            for (; k < 9; k++) {
                if (board[j][k] == '.') {
                    status = false;
                    break;
                }
            }
        }

        if (!status) {
            solveSudoku(board);
        }
    }

    public static void main(String[] args) {
        SudokuSolver s = new SudokuSolver();
        char[][] board = new char[][]{
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        s.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
