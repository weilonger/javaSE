package main.java.leetcode.compete13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        boolean[] status = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            List<String> list = new ArrayList<>();
            if (!status[i]) {
                String str = strs[i];
                list.add(str);

                for (int j = strs.length - 1; j > i; j--) {
                    if (!status[j]) {
                        String str1 = strs[j];
                        if (compare(str, str1)) {
                            list.add(str1);
                            status[j] = true;
                        }
                    }

                }
            }
            if (list.size() > 0) {
                lists.add(list);
            }
            status[i] = true;
        }

        return lists;
    }

    private boolean compare(String str, String str1) {
        int[] num = new int[26];
        for (int k = 0; k < str.length(); k++) {
            num[str.charAt(k) - 'a']++;
        }
        boolean status = true;
        for (int i = 0; i < str1.length(); i++) {
            num[str1.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (num[i] != 0) {
                status = false;
            }
        }
        return status;
    }


    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = g.groupAnagrams1(strs);
        lists.forEach(System.out::println);
    }
}
