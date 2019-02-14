package main.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/*题目描述
    420. 强密码检验器
    一个强密码应满足以下所有条件：
    由至少6个，至多20个字符组成。
    至少包含一个小写字母，一个大写字母，和一个数字。
    同一字符不能连续出现三次 (比如 "...aaa..." 是不允许的, 但是 "...aa...a..." 是可以的)。
    编写函数 strongPasswordChecker(s)，s 代表输入字符串，如果 s 已经符合强密码条件，则返回0；
    否则返回要将 s 修改为满足强密码条件的字符串所需要进行修改的最小步数。
    插入、删除、替换任一字符都算作一次修改。
*/
public class StrongPasswordChecker {
    // 大写字母 小写字母 连续字符 密码位数
    //16ms 击败0%
    public int strongPasswordChecker(String s) {
        int i = 0;
        int num = 3;
        List<Integer> rep = new ArrayList<>();
        int del = 0;
        int add = 0;
        int len = s.length();
        if (len <= 3) {
            return 6 - len;
        }
        if (len > 3 && len < 6) {
            add = 6 - len;
        }
        if (len > 20) {
            del = len - 20;
        }
        Boolean state1 = false;
        Boolean state2 = false;
        Boolean state3 = false;
        List<String> list = new ArrayList<>();
        for (int j = 0; j < len; j++) {
            list.add(s.substring(j, j + 1));
        }
        for (int k = 0; k < len; k++) {
            if (state1 == false && list.get(k).matches("[A-Z]")) {
                state1 = true;
                num--;
            } else if (state2 == false && list.get(k).matches("\\d")) {
                state2 = true;
                num--;
            } else if (state3 == false && list.get(k).matches("[a-z]")) {
                state3 = true;
                num--;
            }
        }
        i += add;
        i += del;
        int temp = 2;
        for (int l = 2; l < len; l++) {
            if (list.get(l).equals(list.get(l -1)) && list.get(l).equals(list.get(l - 2))){
                temp++;
            } else if (temp > 2){
                rep.add(temp);
                temp = 2;
            }
            if (l == len - 1 && temp > 2) {
                rep.add(temp);
            }
        }
        int replace = 0;
        rep.sort((r1, r2) -> r1 -r2);
        for (int m = 0; m < rep.size(); m++) {
            if (del >= rep.get(m) - 2) {
                del = del - rep.get(m) + 2;
            } else {
                replace += (rep.get(m) - del) / 3;
            }
        }
        i += (replace - num) >= 0 ? replace : num - add;
        return i;
    }

    public static void main(String[] args) {
        StrongPasswordChecker s = new StrongPasswordChecker();
//        Hwl218298111111112222222333333444445555
        String string = "..................!!!";
//        System.out.println(string.length());
        System.out.println(s.strongPasswordChecker(string));
    }
}
