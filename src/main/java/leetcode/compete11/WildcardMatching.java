package main.java.leetcode.compete11;

//同一类型10

/*题目描述
    44. 通配符匹配
    给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
    '?' 可以匹配任何单个字符。
    '*' 可以匹配任意字符串（包括空字符串）。
    两个字符串完全匹配才算匹配成功。
*/

import java.util.Scanner;

/*说明：
    s 可能为空，且只包含从 a-z 的小写字母。
    p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 */
/*示例1:
    输入:
    s = "aa"
    p = "a"
    输出: false
    解释: "a" 无法匹配 "aa" 整个字符串。
*/
/*示例2:
    输入:
    s = "aa"
    p = "*"
    输出: true
    解释: '*' 可以匹配任意字符串。
*/
/*示例3:
    输入:
    s = "cb"
    p = "?a"
    输出: false
    解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 */
/*示例4:
    输入:
    s = "adceb"
    p = "*a*b"
    输出: true
    解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 */
public class WildcardMatching {
    
    //超时
    private boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        } else {
            p = p.replaceAll("\\*", "[a-z]*");
            p = p.replaceAll("\\?", "[a-z]");
            return s.matches(p);
        }
    }
    
    //动态规划求解 42ms
    private boolean isMatch1(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] temp = new boolean[sLen + 1][pLen + 1];
        temp[0][0] = true;
        //考虑*为空时的场景
        for (int k = 1; k <= pLen; k++) {
            if (p.charAt(k - 1) == '*') {
                temp[0][k] = temp[0][k - 1];
            }
        }
        for (int j = 1; j <= sLen; j++) {
            for (int k = 1; k <= pLen; k++) {
                if (p.charAt(k - 1) == '*') {
                    temp[j][k] = temp[j - 1][k] || temp[j][k - 1];
                } else if (p.charAt(k - 1) == s.charAt(j - 1) || p.charAt(k - 1) == '?') {
                    temp[j][k] = temp[j - 1][k - 1];
                }
            }
        }
        return temp[sLen][pLen];
    }
    
    //双指针遍历(回溯法)
    private boolean isMatch2(String s, String p) {
        int i = 0;
        int j = 0;
        int start = -1;
        int match = 0;
        int sLen = s.length();
        int pLen = p.length();
        while (i < sLen) {
            //一对一匹配成功
            if (j < pLen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            //记录*所在的位置，还有当前所匹配的位置
            } else if (j < pLen && p.charAt(j) == '*') {
                start = j;
                match = i;
                j++;
            //如果失配了，回溯到 k + 1，即让 * 再多吞噬一个字符
            } else if (start != -1) {
                j = start + 1;
                match++;
                i = match;
            } else {
                return false;
            }
        }
        while (j <= pLen) {
            if (p.charAt(j) != '*') return false;
            j++;
        }
        return true;
    }
    
    public static void main(String[] args) {
        WildcardMatching w = new WildcardMatching();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            String p = sc.nextLine();
            System.out.println(w.isMatch2(s, p));
        }
    }
}
