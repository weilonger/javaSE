package main.java.leetcode.compete10;

import java.util.ArrayList;
import java.util.List;

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
        int min = 17;
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] box = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (row[i][num] || col[j][num] || box[i / 3 * 3 + j / 3][num]) {
                        return;
                    }
                    row[i][num] = true;
                    col[j][num] = true;
                    box[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }
        solve(board, row, col, box);
        solveMulti(board, row, col, box, 0);
    }

    private boolean solveMulti(char[][] board, boolean[][] row, boolean[][] col, boolean[][] box, int index) {
        boolean[][] rowCopy = row;
        boolean[][] colCopy = col;
        boolean[][] boxCopy = box;
//        List<List<Integer>> lists = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        int pois = 0;
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] == '.') {
//                    pois++;
//                    for (int k = 1; k < 10; k++) {
//                        if (!row[i][k] && !col[j][k] && !box[i / 3 * 3 + j / 3][k]) {
//                            list.add(k);
//                        }
//                    }
//                    if (list.size() > 0) {
//                        lists.add(list);
//                    }
//                    list = new ArrayList<>();
//                }
//            }
//        }
//        if (pois == 0) {
//            return true;
//        }
//        if (pois > 0 && lists.size() == 0) {
//            return false;
//        }
//        int min = 17;
//        int num = 0;
//        for (List l : lists) {
//            if (l.size() < min) {
//                min = l.size();
//            }
//        }
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] == '.') {
//                    int len = lists.get(num).size();
//                    if (len == min) {
//                        for (int k = 0; k < len; k++) {
//                            if (!(row[i][lists.get(num).get(k)] && col[j][lists.get(num).get(k)] && box[i / 3 * 3 + j / 3][lists.get(num).get(k)])) {
//                                board[i][j] = (char) ('0' + lists.get(num).get(k));
//                                System.out.println(i + ", " + j + " is " + lists.get(num).get(k));
//                                row[i][lists.get(num).get(k)] = true;
//                                col[j][lists.get(num).get(k)] = true;
//                                box[i / 3 * 3 + j / 3][lists.get(num).get(k)] = true;
//                                if (solveMulti(board, row, col, box, i * 9 + j)) {
//                                    return true;
//                                } else {
//                                    System.out.println(i + ", " + j + " is false " + lists.get(num).get(k));
//                                    row[i][lists.get(num).get(k)] = false;
//                                    col[j][lists.get(num).get(k)] = false;
//                                    box[i / 3 * 3 + j / 3][lists.get(num).get(k)] = false;
//                                    board[i][j] = '.';
//                                }
//                            }
//                        }
//                    }
//                    if (num + 1 < lists.size()) {
//                        num++;
//                    }
//                }
//            }
//        }
        return false;
    }

    private void solve(char[][] board, boolean[][] row, boolean[][] col, boolean[][] box) {
        List<Integer> list = new ArrayList<>();
        // 找出i，j点的剩余数字个数，然后由小到大添加
        int pois = 0;
        int min = 17;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    pois++;
                    for (int k = 1; k < 10; k++) {
                        if (!row[i][k] && !col[j][k] && !box[i / 3 * 3 + j / 3][k]) {
                            list.add(k);
                        }
                    }
                    min = Math.min(min, list.size());
                    if (list.size() == 1) {
                        board[i][j] = (char) (list.get(0) + 48);
                        row[i][list.get(0)] = true;
                        col[j][list.get(0)] = true;
                        box[i / 3 * 3 + j / 3][list.get(0)] = true;
                    }
                    list = new ArrayList<>();
                }
            }
        }
        if (min == 1) {
            solve(board, row, col, box);
        }
    }



    public static void main(String[] args) {
        SudokuSolver s = new SudokuSolver();
        char[][] board = new char[][]{
            {'.','.','9','7','4','8','.','.','.'},
            {'7','.','.','.','.','.','.','.','.'},
            {'.','2','.','1','.','9','.','.','.'},
            {'.','.','7','.','.','.','2','4','.'},
            {'.','6','4','.','1','.','5','9','.'},
            {'.','9','8','.','.','.','3','.','.'},
            {'.','.','.','8','.','3','.','2','.'},
            {'.','.','.','.','.','.','.','.','6'},
            {'.','.','.','2','7','5','9','.','.'}
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
