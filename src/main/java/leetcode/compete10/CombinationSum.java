package main.java.leetcode.compete10;

import java.util.ArrayList;
import java.util.List;

/*题目描述
    39. 组合总和
    给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    candidates 中的数字可以无限制重复被选取。
    说明：
        所有数字（包括 target）都是正整数。
        解集不能包含重复的组合。
*/
/*示例1:
    输入:
        candidates = [2,3,6,7], target = 7,
    所求解集为:
        [
          [7],
          [2,2,3]
        ]
*/
/*示例2:
    输入:
        candidates = [2,3,5], target = 8,
    所求解集为:
        [
          [2,2,2,2],
          [2,3,3],
          [3,5]
        ]
*/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
//        Arrays.sort(candidates);
        int len = candidates.length;
        int i = 0;
        for (; i < len; i++) {
            if (target >= candidates[i]) {
                if (target % candidates[i] == 0) {
                    int num = target / candidates[i];
                    List<Integer> list = new ArrayList<>();
                    for (int j = 0; j < num; j++) {
                        list.add(candidates[i]);
                    }
                    lists.add(list);
                } else {
                    int num = target / candidates[i];

                }
            }
            break;
        }

        return lists;
    }

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        int[] candidates = new int[]{2, 3, 6 ,7};
        int target = 7;
        List<List<Integer>> lists = c.combinationSum(candidates, target);
        for (List<Integer> list : lists) {
            list.forEach(System.out::println);
            System.out.println("-------------");
        }
    }
}
