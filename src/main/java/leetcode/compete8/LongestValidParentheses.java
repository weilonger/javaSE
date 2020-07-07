package main.java.leetcode.compete8;

import java.util.ArrayList;
import java.util.List;

/*题目描述
    32. 最长有效括号
    给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
*/
/*示例1:
    输入: "(()"
    输出: 2
    解释: 最长有效括号子串为 "()"
*/
/*示例2:
    输入: ")()())"
    输出: 4
    解释: 最长有效括号子串为 "()()"
*/
public class LongestValidParentheses {
    //14ms 27.8MB
    public int longestValidParentheses(String s) {
        int sLen = s.length();
        int open = 0;
        int close = 0;
        int max = 0;
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) == '(') {
                open++;
                list.add(i);
            } else if (s.charAt(i) == ')' && open > close) {
                close++;
                list.remove(list.size() - 1);
            } else {
                open = 0;
                close = 0;
                list.add(i);
            }
        }
        list.add(sLen);
        int lLen = list.size();
        for (int j = 0; j < lLen - 1; j++) {
            if (list.get(j + 1) - list.get(j) - 1 > max) {
                max = list.get(j + 1) - list.get(j) - 1;
            }
        }
        return max;
    }

    public int longestValidParentheses1(String s) {
        int maxnum = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxnum = Math.max(maxnum, 2 * left);
            } else if (left < right) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxnum = Math.max(maxnum, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxnum;
    }

    private Integer ValidParentheses(Integer start, Integer end, String s) {
        String s1 = s.substring(start, end + 1);
        int status = 0;
        int len = s1.length();
        if (len % 2 == 1) {
            return 0;
        } else {
            for (int i = 0; i < len; i++) {
                if (s1.charAt(i) == '(') {
                    status++;
                } else {
                    status--;
                }
                if (status < 0) {
                    return 0;
                }
            }
            if (status == 0) {
                return len;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LongestValidParentheses l = new LongestValidParentheses();
        String s = "))))())()()(()";
        System.out.println(l.longestValidParentheses1(s));
    }
}
