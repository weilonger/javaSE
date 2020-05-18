package main.java.leetcode.compete1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    //224ms
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                i = map.get(s.charAt(i)) + 1;
                map = new HashMap<>();
                max = Math.max(j, max);
                j = 1;
            } else {
                j++;
            }
            if (i == s.length() - 1) {
                max = Math.max(j, max);
            }
            map.put(s.charAt(i), i);
        }
        return max;
    }

    public static void main(String[] args) {

        LongestSubstring l = new LongestSubstring();
        System.out.println(l.lengthOfLongestSubstring5("abcbedfbcbb"));
    }

    /*
        官方解答：
     */

    /*
        方法一：暴力法
        思路
            逐个检查所有的子字符串，看它是否不含有重复的字符。
        复杂度分析
            时间复杂度：O(n^3)。
                要验证索引范围在 [i, j)内的字符是否都是唯一的，我们需要检查该范围中的所有字符。 因此，它将花费 O(j - i)的时间。
                对于给定的 i，对于所有 j∈[i+1,n] 所耗费的时间总和为：
                        i+1
                        ∑   O(j−i)
                        n
                因此，执行所有步骤耗去的时间总和为：O(n^3)
            空间复杂度：O(min(n, m))
                我们需要 O(k)的空间来检查子字符串中是否有重复字符，其中 k 表示 Set 的大小。而 Set 的大小取决于字符串 n 的大小以及字符集/字母 m 的大小。
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /*
        方法二：滑动窗口
        思路
            过使用 HashSet 作为滑动窗口，我们可以用 O(1) 的时间来完成对字符是否在当前的子字符串中的检查。
            滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，
            即 [i, j)（左闭，右开）。而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。
        复杂度分析
            时间复杂度：O(2n) = O(n)，在最糟糕的情况下，每个字符将被 i 和 j 访问两次。
            空间复杂度：O(min(m, n))，与之前的方法相同。滑动窗口法需要 O(k) 的空间，其中 k 表示 Set 的大小。
                       而Set的大小取决于字符串 n 的大小以及字符集/字母 m 的大小。
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /*
        方法三：优化的滑动窗口
        思路
            定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。 当我们找到重复的字符时，我们可以立即跳过该窗口。
        复杂度分析
            时间复杂度：O(n)，索引 j 将会迭代 n 次。
            空间复杂度（HashMap）：O(min(m, n))，与之前的方法相同。
            空间复杂度（Table）：O(m)，m 是字符集的大小。
     */
    //52ms
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /*
        Java（假设字符集为 ASCII 128）
        以前的我们都没有对字符串 s 所使用的字符集进行假设。
        当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。
        常用的表如下所示：
            int [26] 用于字母 ‘a’ - ‘z’或 ‘A’ - ‘Z’
            int [128] 用于ASCII码
            int [256] 用于扩展ASCII码
    */
    public int lengthOfLongestSubstring4(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public int lengthOfLongestSubstring5(String s) {
        int len = s.length();
        Set<Character> set = new HashSet();
        int i = 0;
        int j = 0;
        int max = 0;
        while (i < len && j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}
