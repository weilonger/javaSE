package main.java.leetcode.compete8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*题目描述
    30. 串联所有单词的子串
    给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
    注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
*/
/*示例1 :
    输入：
         s = "barfoothefoobarman",
         words = ["foo","bar"]
    输出：[0,9]
    解释：
        从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
        输出的顺序不重要, [9,0] 也是有效答案。
*/
/*示例2 :
    输入：
      s = "wordgoodgoodgoodbestword",
      words = ["word","good","best","word"]
    输出：[]
*/
public class SubstringWithConcatenationOfAllWords {
    //2678 ms
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList();
        int len = words.length;
        int sLen = s.length();
        if (len == 0 || sLen == 0) {
            return list;
        }
        int wLen = words[0].length();
        for (int i = 0; i <= sLen - wLen * len; i++) {
            Boolean[] status = new Boolean[len];
            for (int m = 0; m < len; m++) {
                status[m] = false;
            }
            List<String> wordList = transferArrayToList(words);
            String temp = s.substring(i, i + wLen);
            for (int k = 0; k < len; k++) {
                if (wordList.get(k).equals(temp)) {
                    status[0] = true;
                    wordList.remove(k);
                    break;
                }
            }
            if (!status[0]) {
                continue;
            }
            for (int j = 1; j < len; j++) {
                for (int l = 0; l < len - j; l++) {
                    if (wordList.get(l).equals(s.substring(i + j * wLen, i + wLen * (j + 1)))) {
                        status[j] = status[j - 1];
                        wordList.remove(l);
                        break;
                    }
                }
            }
            if (status[len - 1] == true) {
                list.add(i);
            }
        }

        return list;
    }

    private static <E>  List<E> transferArrayToList(E[] array){
        List<E> transferedList = new ArrayList<>();
        Arrays.stream(array).forEach(arr -> transferedList.add(arr));
        return transferedList;
    }

    //210ms
    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> list = new ArrayList();
        int len = words.length;
        int sLen = s.length();
        if (len == 0 || sLen == 0) {
            return list;
        }
        int wLen = words[0].length();
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            wordList.add(words[i]);
        }
        Collections.sort(wordList);
        for (int i = 0; i <= sLen - len * wLen; i++) {
            String temp = s.substring(i, i + wLen);
            if (wordList.contains(temp)) {
                List<String> sList = new ArrayList<>();
                for (int k = 0; k < len * wLen; k += wLen) {
                    sList.add(s.substring(i + k, i + k + wLen));
                }
                Collections.sort(sList);
                if (isValid(sList, wordList)) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    private boolean isValid(List<String> sList, List<String> wordList) {
        for (int i = 0; i < sList.size(); i++) {
            if (!sList.get(i).equals(wordList.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
        String s1 = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};
        List<Integer> list = s.findSubstring1(s1, words);
        list.forEach(System.out::println);
    }
}
