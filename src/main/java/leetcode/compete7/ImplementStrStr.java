package main.java.leetcode.compete7;

/*题目描述
    28. 实现strStr()
    实现 strStr() 函数。
    给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
*/
/*示例1 :
    输入: haystack = "hello", needle = "ll"
    输出: 2
*/
/*示例2 :
    输入: haystack = "aaaaa", needle = "bba"
    输出: -1
*/
/*
说明:
    当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
    对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
*/
public class ImplementStrStr {
    //7 ms kmp算法
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len1 == 0 || len2 == 0) {
            return -1;
        }
        int j = 1;
        for (int i = 0; i < len1; i++) {
            if (haystack.charAt(i) == needle.charAt(0) && i + len2 <= len1) {
                for (j = 1; j < len2; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == len2) {
                    return i;
                }
            }
        }
        return -1;
    }

    //4ms
    public int strStr1(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len2 == 0) {
            return 0;
        }
        int i = 0;
        int k = len2;
        while (i + k <= len1) {
            if (haystack.substring(i, i + k).equals(needle)) {
                return i;
            } else {
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr i = new ImplementStrStr();
        String haysyack = "a";
        String needle = "a";
        System.out.println(i.strStr1(haysyack, needle));
    }
}
