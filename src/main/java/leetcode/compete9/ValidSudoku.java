package main.java.leetcode.compete9;

import java.util.HashSet;
import java.util.Set;

/*题目描述
    36. 有效的数独
    判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
    数字 1-9 在每一行只能出现一次。
    数字 1-9 在每一列只能出现一次。
    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
    图片地址：https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png
    数独部分空格内已填入了数字，空白格用 '.' 表示。
*/
/*示例1:
    输入:
        [
          ["5","3",".",".","7",".",".",".","."],
          ["6",".",".","1","9","5",".",".","."],
          [".","9","8",".",".",".",".","6","."],
          ["8",".",".",".","6",".",".",".","3"],
          ["4",".",".","8",".","3",".",".","1"],
          ["7",".",".",".","2",".",".",".","6"],
          [".","6",".",".",".",".","2","8","."],
          [".",".",".","4","1","9",".",".","5"],
          [".",".",".",".","8",".",".","7","9"]
        ]
    输出: true
*/
/*示例2:
    输入:
        [
          ["8","3",".",".","7",".",".",".","."],
          ["6",".",".","1","9","5",".",".","."],
          [".","9","8",".",".",".",".","6","."],
          ["8",".",".",".","6",".",".",".","3"],
          ["4",".",".","8",".","3",".",".","1"],
          ["7",".",".",".","2",".",".",".","6"],
          [".","6",".",".",".",".","2","8","."],
          [".",".",".","4","1","9",".",".","5"],
          [".",".",".",".","8",".",".","7","9"]
        ]
    输出: false
    解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
*/
/*说明：
    一个有效的数独（部分已被填充）不一定是可解的。
    只需要根据以上规则，验证已经填入的数字是否有效即可。
    给定数独序列只包含数字 1-9 和字符 '.' 。
    给定数独永远是 9x9 形式的。
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean status = true;
        boolean[][] table = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet();
            Set<Character> colSet = new HashSet();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (colSet.contains(board[i][j])) {
                        return false;
                    } else {
                        colSet.add(board[i][j]);
                    }
                    if (table[i / 3 * 3 + j / 3][num]) {
                        return false;
                    } else {
                        table[i / 3 * 3 + j / 3][num] = true;
                    }
                }
                if (board[j][i] != '.') {
                    if (rowSet.contains(board[j][i])) {
                        return false;
                    } else {
                        rowSet.add(board[j][i]);
                    }
                }
            }
        }
        return status;
    }

    //评论区大佬作答
    public boolean isValidSudoku1(char[][] board) {
        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][10];
        // 记录某列，某位数字是否已经被摆放
        boolean[][] col = new boolean[9][10];
        // 记录某 3x3 宫格内，某位数字是否已经被摆放
        boolean[][] block = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (row[i][num] || col[j][num] || block[i / 3 * 3 + j / 3][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[i / 3 * 3 + j / 3][num] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku v = new ValidSudoku();
        char[][] board = new char[][]{
          {'8','3','.','.','7','.','.','.','.'},
          {'6','.','.','1','9','5','.','.','.'},
          {'.','9','8','.','.','.','.','6','.'},
          {'8','.','.','.','6','.','.','.','3'},
          {'4','.','.','8','.','3','.','.','1'},
          {'7','.','.','.','2','.','.','.','6'},
          {'.','6','.','.','.','.','2','8','.'},
          {'.','.','.','4','1','9','.','.','5'},
          {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(v.isValidSudoku(board));
    }
}
