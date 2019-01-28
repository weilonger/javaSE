package main.java.leetcode.compete6;

import java.util.ArrayList;
import java.util.List;

/*题目描述
    22. 括号生成
    给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
*/
/*示例:
    输入： n = 3，
    输出：
        [
          "((()))",
          "(()())",
          "(())()",
          "()(())",
          "()()()"
        ]
 */
public class GenerateParentheses {

    List<String> list = new ArrayList<>();
    //3ms
    public List<String> generateParenthesis(int n) {
        int j = n;
        int i = n;
        char[] A = new char[2 * n];
        list = getAll(i, j, n * 2 - 1, A);
        return list;
    }

    private List<String> getAll(int i, int j, int n, char[] A) {
        Character[] c = {'(', ')'};
        if (i == 0 && j == 0) {
            list.add(String.valueOf(A));
            return list;
        } else if (i > 0 && j > 0 && i > j) {
            for (int l = 0; l < 2; l++) {
                A[n] = c[l];
                if (l == 0) {
                    getAll(i - 1, j, n - 1, A);
                } else {
                    getAll(i, j - 1, n - 1, A);
                }
            }
        } else if (i == 0 || j == 0 || i == j){
            if (i == 0 || i == j) {
                A[n] = c[1];
                getAll(i, j - 1, n - 1, A);
            } else if (j == 0){
                A[n] = c[0];
                getAll(i - 1, j, n - 1, A);
            }
        }
        return list;
    }

    /*
        方法二：回溯法
        思路和算法
            只有在我们知道序列仍然保持有效时才添加 '(' or ')'，而不是像方法一那样每次添加。
            我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，如果我们还剩一个位置，我们可以开始放一个左括号。
            如果它不超过左括号的数量，我们可以放一个右括号。
        复杂度分析
            我们的复杂度分析依赖于理解 generateParenthesis(n) 中有多少个元素。这个分析超出了本文的范畴，但事实证明这是第 n 个卡塔兰数
            1/(n+1)(n ~ 2n)，这是由 n^4 / sqrt(n)渐近界定的。
            时间复杂度：O( n^4 / sqrt(n))，在回溯过程中，每个有效序列最多需要 n 步。
            空间复杂度：O( n^4 / sqrt(n))，如上所述，并使用 O(n) 的空间来存储序列。
     */
    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }

    /*
        方法三：闭合数
        思路
            为了枚举某些内容，我们通常希望将其表示为更容易计算的不相交子集的总和。
            考虑有效括号序列 S 的闭包数：至少存在index> = 0，使得 S[0], S[1], ..., S[2*index+1]是有效的。
            显然，每个括号序列都有一个唯一的闭包号。 我们可以尝试单独列举它们。
        算法
            对于每个闭合数 c，我们知道起始和结束括号必定位于索引 0 和 2*c + 1。然后两者间的 2*c 个元素一定是有效序列，其余元素一定是有效序列。
        复杂度分析
        时间和空间复杂度：O( n ^ 4 / sqrt(n))，该分析与方法二类似。
     */
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis2(c))
                    for (String right: generateParenthesis2(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }


    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        int n = 3;
        g.generateParenthesis1(n).forEach(System.out::println);
    }
}
