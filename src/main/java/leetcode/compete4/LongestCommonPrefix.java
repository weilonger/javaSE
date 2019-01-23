package main.java.leetcode.compete4;

/*题目描述
    14. 最长公共前缀
    编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 */
/*示例1：
    输入: ["flower","flow","flight"]
    输出: "fl"
 */
/*示例2：
    输入: ["dog","racecar","car"]
    输出: ""
    解释: 输入不存在公共前缀。
*/
public class LongestCommonPrefix {
    //11ms
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len < 1) {
            return "";
        } else if (len == 1) {
            return strs[0];
        }
        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        int j = getMinIndex(strs, minLen);

        return strs[0].substring(0, j);
    }

    private int getMinIndex(String[] strs, int minLen) {
        Boolean[] status = new Boolean[minLen];
        for (int j = 0; j < minLen; j++) {
            status[j] = true;
            for (int i = 1; i < strs.length; i++) {
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    status[j] = false;
                }
            }
            if (!status[j]) {
                return j;
            } else if (status[j] && j == minLen - 1) {
                return j + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        String[] strs = new String[]{"c", "c", "a"};
        System.out.println(l.longestCommonPrefix(strs));
    }

    /*
        方法一：水平扫描法
        复杂度分析
            时间复杂度：O(S)，S 是所有字符串中字符数量的总和。
            最坏的情况下， n 个字符串都是相同的。 算法会将 S1 与其他字符串 [S2…Sn] 都做一次比较。
            这样就会进行 S 次字符比较，其中 S 是输入数据中所有字符数量。
            空间复杂度：O(1)， 我们只需要使用常数级别的额外空间。
     */
    //9ms
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    /*
        算法二：水平扫描
        算法
            想象数组的末尾有一个非常短的字符串， 使用上述方法依旧会进行 S 次比较。 优化这类情况的一种方法就是水平扫描。
            我们从前往后枚举字符串的每一列，先比较每个字符串相同列上的字符（即不同字符串相同下标的字符）然后再进行对下一列的比较。
        复杂度分析
            时间复杂度：O(S)，S 是所有字符串中字符数量的总和。
            最坏情况下，输入数据为 n 个长度为 m 的相同字符串，算法会进行 S=m∗n 次比较。可以看到最坏情况下，本算法的效率与算法一相同，
            但是最好的情况下，算法只需要进行 n*minLenn∗minLen 次比较，其中 minLen 是数组中最短字符串的长度。
            空间复杂度：O(1)， 我们只需要使用常数级别的额外空间。
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    /*
        算法三：二分查找法
        思路
            这个想法是应用二分查找法找到所有字符串的公共前缀的最大长度 L。 算法的查找区间是(0…minLen)，其中 minLen 是输入数据中最短的字符串的长度，
            同时也是答案的最长可能长度。 每一次将查找区间一分为二，然后丢弃一定不包含最终答案的那一个。
        图片地址
            https://leetcode-cn.com/media/original_images/14_lcp_binary_search.png
        复杂度分析
            最坏情况下，我们有 n 个长度为 m 的相同字符串。
            时间复杂度：O(S⋅log(n))，其中 S 所有字符串中字符数量的总和。
            算法一共会进行 log(n) 次迭代，每次一都会进行 S = m*nS=m∗n 次比较，所以总时间复杂度为 O(S⋅log(n))。
            空间复杂度：O(1)，我们只需要使用常数级别的额外空间。
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }
}
