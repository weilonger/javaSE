package main.java.leetcode.compete2;

/*题目描述
    5.最长回文子串(正着反正一样)
    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
/*示例1：
    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。
 */
/*示例2：
    输入: "cbbd"
    输出: "bb"
 */
public class LongestSubstring {
    //bbbbabbb 卡死
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int end = 1;
        int max = 0;
        Boolean[][] state = new Boolean[n][n];
        if (n <= 1 ) {
            return s;
        }
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j <= Math.min(i, n - i - 1); j++) {
                if (i + j + 2 < n && s.charAt(i - j) == s.charAt(i + 2 + j)) {
                    state[i][j] = (j > 0 && state[i][j - 1]) || j == 0;
                    if (state[i][j] && 2 * j + 3 >= max && 2 * j + 3 < n - 1) {
                        start = i - j;
                        end = i + j + 3;
                        max = 2 * j + 3;
                    }
                } else if (i + j + 1 < n && s.charAt(i - j) == s.charAt(i + 1 + j)) {
                    state[i][j] = (j > 0 && state[i][j - 1]) || j == 0;
                    if (state[i][j] && 2 * j + 2 > max && 2 * j + 2 <= n) {
                        start = i - j;
                        end = i + j + 2;
                        max = 2 * j + 2;
                    }
                }else {
                    state[i][j] = false;
                }
            }
        }
        return s.substring(start, end);
    }

    public static void main(String[] args) {
        LongestSubstring l = new LongestSubstring();
        String s = "bbbbabbb";
        System.out.println(l.longestPalindrome2(s));
    }

    /*方法一：动态规划
        思路
            为了改进暴力法，我们首先观察如何避免在验证回文时进行不必要的重复计算。考虑 “ababa” 这个示例。
            如果我们已经知道 “bab” 是回文，那么很明显，“ababa” 一定是回文，因为它的左首字母和右尾字母是相同的。
     */
    public String longestPalindrome1(String s) {
        int n = s.length();
        int start = 0;
        int end = 1;
        int max = 0;
        Boolean[][] state = new Boolean[n][n];
        if (n <= 1 ) {
            return s;
        }
        for (int i = 0; i < n - 2; i++) {
        }

        return s;
    }
    /*方法二：中心扩展算法
        思路
            事实上，只需使用恒定的空间，我们就可以在O(n 2) 的时间内解决这个问题。
            我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有2n−1 个这样的中心。
            你可能会问，为什么会是2n−1 个，而不是 n 个中心？原因在于所含字母数为偶数的回文的中心可以处于两字母之间
            （例如 “abba” 的中心在两个‘b’之间）。
        复杂度分析
            时间复杂度：O(n^2)， 由于围绕中心来扩展回文会耗去 O(n)的时间，所以总的复杂度为 O(n^2)。
            空间复杂度：O(1)O(1)。
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //按两种情况求取最大长度
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
