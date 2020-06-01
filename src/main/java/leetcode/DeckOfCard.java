package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/*题目描述
    914.给定一副牌，每张牌上都写着一个整数。

    此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：

    每组都有 X 张牌。
    组内所有的牌上都写着相同的整数。
    仅当你可选的 X >= 2 时返回 true。
 */

/*  示例 1：
    输入：[1,2,3,4,4,3,2,1]
    输出：true
    解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
*/

/*  示例 2：
    输入：[1,1,1,2,2,2,3,3]
    输出：false
    解释：没有满足要求的分组。
*/

/*  示例 3：
    输入：[1]
    输出：false
    解释：没有满足要求的分组。
*/

/*  示例 4：
    输入：[1,1]
    输出：true
    解释：可行的分组是 [1,1]
*/

/*  示例 5：
    输入：[1,1,2,2,2,2]
    输出：true
    解释：可行的分组是 [1,1]，[2,2]，[2,2]
*/

/*
    提示：

    1 <= deck.length <= 10000
    0 <= deck[i] < 10000
 */
public class DeckOfCard {

    public static void main(String[] args) {
        DeckOfCard deckOfCard = new DeckOfCard();
        int[] deck = new int[]{1,1,1,1,2,2,2,2,2,2};
        System.out.println(deckOfCard.hasGroupsSizeX1(deck));
    }

    public boolean hasGroupsSizeX1(int[] deck) {
        int len = deck.length;
        int[] count = new int[10000];
        for (Integer d : deck) {
            count[d]++;
        }
        int num = 0;
        int min = -1;
        for (int i = 0; i < 10000; i++) {
            if (count[i] > 0) {
                if (min == -1) {
                    min = count[i];
                } else {
                    min = divisor(min, count[i]);
                }
                if (min < 2 && min > 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer d : deck) {
            int value = 0;
            if (map.containsKey(d)) {
                value = map.get(d);
            }
            map.put(d, value + 1);
        }
        int min = Integer.MAX_VALUE;
        for (Integer k : map.keySet()) {
            if (min > map.get(k)) {
                min = map.get(k);
            }
        }
        if (min >= 2) {
            for (Integer k : map.keySet()) {
                int num = divisor(min, map.get(k));
                if (num < 2) {
                    return false;
                }
                if (num < min) {
                    min = num;
                }
            }
        } else {
            return false;
        }
        return true;

    }

    int divisor(int a, int b) {
        int temp = a;
        while (temp > 0) {
            if (a % temp == 0 && b % temp == 0) {
                break;
            }
            else {
                temp--;
            }
        }
        return (temp);
    }
}
