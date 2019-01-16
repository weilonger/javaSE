package main.java.leetcode.compete2;

import java.util.HashMap;
import java.util.Map;

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
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 0;
        String longest = "";
        Boolean state = false;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                state = true;
                i = Math.max(map.get(s.charAt(j)) - 1, i);
                if (max < j - i + 1) {
                    max = j - i + 1;
                    longest = s.substring(i, j + 1);
                }
            } else {
                if (j == n - 1 && state == false) {
                    longest = s.substring(i, i + 1);
                }
            }
            map.put(s.charAt(j), j + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubstring l = new LongestSubstring();
        String s = "badsca";
        System.out.println(l.longestPalindrome(s));
    }
}
