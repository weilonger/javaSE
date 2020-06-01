package main.java.leetcode.compete18;

/*题目描述
    72. 编辑距离
    给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数。
    你可以对一个单词进行如下三种操作：
    插入一个字符
    删除一个字符
    替换一个字符
*/
/*示例1：
    输入: word1 = "horse", word2 = "ros"
    输出: 3
    解释:
    horse -> rorse (将 'h' 替换为 'r')
    rorse -> rose (删除 'r')
    rose -> ros (删除 'e')
*/
/*示例2：
    输入: word1 = "intention", word2 = "execution"
    输出: 5
    解释:
    intention -> inention (删除 't')
    inention -> enention (将 'i' 替换为 'e')
    enention -> exention (将 'n' 替换为 'x')
    exention -> exection (将 'n' 替换为 'c')
    exection -> execution (插入 'u')
 */
public class EditDistance {

    public static void main(String[] args) {
        EditDistance e = new EditDistance();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(e.minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length() + 1;
        int n = word2.length() + 1;
        int[][] count = new int[m][n];
        if (word1.equals(word2)) {
            return count[0][0];
        }
        for (int i = 0; i < m; i++) {
            count[i][0] = i;
        }
        for (int i = 0; i < n; i++) {
            count[0][i] = i;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    count[i][j] = count[i - 1][j - 1];
                } else {
                    count[i][j] =  Math.min(Math.min(count[i - 1][j - 1], count[i - 1][j]), count[i][j - 1]) + 1;
                }
            }
        }
        return count[m - 1][n - 1];
    }
}
