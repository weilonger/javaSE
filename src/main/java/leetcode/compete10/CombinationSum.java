package main.java.leetcode.compete10;

import java.util.ArrayList;
import java.util.Arrays;
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
    //23ms
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        int num = 0;
        find(lists, list, candidates, target, num);
        return lists;
    }

    private void find(List<List<Integer>> lists, List<Integer> tmp, int[] candidates, int target, int num) {
        int len = candidates.length;
        if (target == 0) {
            lists.add(tmp);
            return;
        }
        if (target < candidates[0]) {
            return;
        }
        for (int i = num; i < len && candidates[i] <= target; i++) {
            List<Integer> list = new ArrayList<>(tmp);
            list.add(candidates[i]);
            find(lists, list, candidates, target - candidates[i], i);
        }
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
