package main.java.leetcode.compete5;

import java.util.ArrayList;
import java.util.List;

/*题目描述
    17. 电话号码的字母组合
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
*/
/*示例:
    输入："23"
    输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationOfPhone {
    //959ms
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        int len = digits.length();
        if (len < 1) {
            return list;
        }
        list = getLetter(digits);
        return list;
    }

    //广度优先
    private List<String> getLetter(String digits) {
        List<String> list = new ArrayList<>();
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Integer term = digits.charAt(0) - '0';
        digits = digits.substring(1);
        for (int i = 0; i < letters[term - 2].length(); i++) {
            if (digits.length() > 0) {
                for (int j = 0; j < getLetter(digits).size(); j++) {
                    list.add(letters[term - 2].substring(i, i + 1) + getLetter(digits).get(j));
                }
            } else {
                list.add(letters[term - 2].substring(i, i + 1));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LetterCombinationOfPhone l = new LetterCombinationOfPhone();
        String digits = "234";
        System.out.println(l.letterCombinations(digits));
    }

    //改进方法 3ms
    public List<String> letterCombinations1(String digits) {
        List<String> list = new ArrayList<>();
        int len = digits.length();
        char[] A = new char[len];
        list = getLetter1(list, A, 0, digits);
        return list;
    }

    //回溯
    private List<String> getLetter1(List<String> list, char[] A, int cur, String digits) {
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int n = digits.length();
        if (digits==null || digits.length()==0) return list;
        if(cur == n){
            list.add(String.valueOf(A));
            return list;
        }
        int d = digits.charAt(cur) - '2';
        for(int i = 0; i < letters[d].length(); i++){
            A[cur] = letters[d].charAt(i);
            getLetter1(list , A,cur+1, digits);
        }
        return list;
    }
}
