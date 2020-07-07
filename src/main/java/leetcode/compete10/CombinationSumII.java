package main.java.leetcode.compete10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*题目描述
    40. 组合总和 II
    给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    candidates 中的每个数字在每个组合中只能使用一次。
    说明：
        所有数字（包括 target）都是正整数。
        解集不能包含重复的组合。
*/
/*示例1:
    输入: candidates = [10,1,2,7,6,1,5], target = 8,
    所求解集为:
        [
          [1, 7],
          [1, 2, 5],
          [2, 6],
          [1, 1, 6]
        ]
*/
/*示例2:
    输入: candidates = [2,5,2,1,2], target = 5,
    所求解集为:
        [
          [1,2,2],
          [5]
        ]
*/
public class CombinationSumII {
    //28ms
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        int num = 0;
        find(lists, list, candidates, target, num);
        return lists;
    }

    private void find(List<List<Integer>> lists, List<Integer> tmp, int[] candidates, int target, int num) {
        int len = candidates.length;
        if (target == 0) {
            if (!lists.contains(tmp)) {
                lists.add(tmp);
            }
            return;
        }
        if (target < candidates[num]) {
            return;
        }
        for (int i = num; i < len && candidates[i] <= target; i++) {
            List<Integer> list = new ArrayList<>(tmp);
            list.add(candidates[i]);
            find(lists, list, candidates, target - candidates[i], i + 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumII c = new CombinationSumII();
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> lists = c.combinationSum2(candidates, target);
        for (List<Integer> list : lists) {
            list.forEach(System.out::println);
            System.out.println("-------------");
        }
    }
}
