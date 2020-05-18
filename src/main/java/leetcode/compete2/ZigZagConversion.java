package main.java.leetcode.compete2;

import java.util.ArrayList;
import java.util.List;

/*题目描述
    6. Z 字形变换
    将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
    之后，你的输出需要从左往右逐行读取，产生出一个新的字符串
 */
/*示例1：
    输入: s = "LEETCODEISHIRING", numRows = 3
    输出: "LCIRETOESIIGEDHN"
 */
/*示例2：
    输入: s = "LEETCODEISHIRING", numRows = 4
    输出: "LDREOEIIECIHNTSG"
 */
public class ZigZagConversion {
    //106ms
    public String convert(String s, int numRows) {
        int length = s.length();
        if (length <= numRows || numRows == 1) {
            return s;
        }
        int x = length / (2 * numRows - 2);
        int y = length % (2 * numRows - 2);
        int numCols = x * (numRows - 1) + (y < numRows ? 1 : y % (numRows - 1));
        Character[][] character = new Character[numRows][numCols];
        StringBuffer newString = new StringBuffer();
        int k = 0;
        for (int j = 0; j < numCols; j++) {
            for (int i = 0; i < numRows; i++) {
                if (j % (numRows - 1) == 0 && k < length) {
                    character[i][j] = s.charAt(k++);
                } else {
                    if (i == numRows - j % (numRows - 1) - 1 && k < length) {
                        character[i][j] = s.charAt(k++);
                    }
                }
            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (character[i][j] != null) {
                    newString = newString.append(character[i][j]);
                }
            }
        }
        return newString.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion z = new ZigZagConversion();
        String s = "ABNJHKDANKUNJKI";
        int numRows = 5;
        System.out.println(z.convert(s, numRows));
    }

    //按行访问
    /*
    思路
        按照与逐行读取 Z 字形图案相同的顺序访问字符串。
    算法
        首先访问 行 0 中的所有字符，接着访问 行 1，然后 行 2，依此类推...
        对于所有整数 kk，
        行 0 中的字符位于索引 k(2⋅numRows−2) 处;
        行 numRows−1 中的字符位于索引 k(2⋅numRows−2)+numRows−1 处;
        内部的 行 i 中的字符位于索引 k(2⋅numRows−2)+i 以及 (k+1)(2⋅numRows−2)−i 处;
    复杂度分析
        时间复杂度：O(n)，其中 n == len(s)。每个索引被访问一次。
        空间复杂度：O(n)。对于 cpp 实现，如果返回字符串不被视为额外空间，则复杂度为 O(1)。
     */
    public String convert1(String s, int numRows) {
        int length = s.length();
        if (length <= numRows || numRows == 1) {
            return s;
        }
        int curr = 2 * numRows - 2;
        StringBuffer newString = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < length; j += curr) {
                newString.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + curr - i < length) {
                    newString.append(s.charAt(j + curr - i));
                }
            }
        }

        return newString.toString();
    }

    //按行排序
    /*
    思路
        通过从左向右迭代字符串，我们可以轻松地确定字符位于 Z 字形图案中的哪一行。
    算法
        我们可以使用min(numRows,len(s)) 个列表来表示 Z 字形图案中的非空行。
        从左到右迭代 s，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
        只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
    复杂度分析
        时间复杂度：O(n)，其中 n==len(s)
        空间复杂度：O(n)
     */
    public String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }
}
