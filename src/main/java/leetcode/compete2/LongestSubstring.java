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
        System.out.println(l.longestPalindrome1(s));
    }

    //中心扩展算法
    public String longestPalindrome1(String s) {
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
