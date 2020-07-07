package main.java.leetcode.compete3;

//同一类型44

/*题目描述
    10. 正则表达式匹配
    给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
    '.' 匹配任意单个字符
    '*' 匹配零个或多个前面的那一个元素
    说明: 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
        s 可能为空，且只包含从 a-z 的小写字母。
        p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 */
/*示例1：
    输入:
    s = "aa"
    p = "a"
    输出: false
    解释: "a" 无法匹配 "aa" 整个字符串。
 */
/*示例2：
    输入:
    s = "mississippi"
    p = "mis*is*p*."
    输出: false
 */
/*示例3：
    输入:
    s = "ab"
    p = ".*"
    输出: true
    解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 */
public class RegularMatch {
    //使用动态规划
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        //多存一层 0, 0
        boolean[][] memory = new boolean[sLen+1][pLen+1];
        memory[0][0] = true;
        for(int i = 0; i <= sLen; i++) {
            for(int j = 1; j <= pLen; j++) {
                if(p.charAt(j-1) == '*') {
                    memory[i][j] = memory[i][j-2] || (i > 0 && (s.charAt(i-1) == p.charAt(j-2) ||
                                                                        p.charAt(j-2) == '.') && memory[i-1][j]);
                }else {
                    memory[i][j] = i > 0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                                           && memory[i-1][j-1];
                }
            }
        }
        return memory[sLen][pLen];
    }
    
    //回溯法
    public boolean isMatch1(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
    
        if (p.length() >= 2 && p.charAt(1) == '*'){
            return (isMatch(s, p.substring(2)) ||
                        (first_match && isMatch(s.substring(1), p)));
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        RegularMatch r = new RegularMatch();
        String s = "a";
        String p = ".*";
        System.out.println(r.isMatch(s, p));
    }
}
