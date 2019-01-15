package main.java.leetcode.compete1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*题目描述
    3. 无重复字符的最长子串
    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
/*示例1：
    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
/*示例2：
    输入: "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 */
/*示例3：
    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int max;
        if (s.length() > 1) {
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    map = new HashMap<>();
                    list.add(j);
                    j = 1;
                } else {
                    j++;
                }
                if ( i == s.length() - 1){
                    list.add(j);
                }
                map.put(s.charAt(i), i);
            }

            if (list.size() > 0) {
                list.sort((l1, l2) -> (l2 - l1));
                max = list.get(0);
            } else {
                max = 0;
            }
        } else {
            if (s.length() == 1) {
                max = 1;
            } else {
                max = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstring l = new LongestSubstring();
        System.out.println(l.lengthOfLongestSubstring("dvdf"));
    }
}
