package main.java.leetcode.compete12;

/*题目描述
    46. 全排列
    给定一个没有重复数字的序列，返回其所有可能的全排列。
*/

/*示例:
   输入: [1,2,3]
    输出:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]
*/


/*思路：
    首先想到的是递归，每层递归遍历一次，将一个值提取出来，剩余的重新全排列，比如[1,2,3],可以拆成1和[2,3]的全排列，2和[1,3]的全排列，3和[1,2]的全排列
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List lists = new ArrayList();
        List<Integer> list = new ArrayList<>();
        backtrack(lists, list, nums);

        return lists;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int num : nums) {
                if (list.contains(num)) {
                    continue;
                }
                list.add(num);
                backtrack(lists, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }

    List<List<Integer>> res;

    //大神 交换法
    public List<List<Integer>> permute1(int[] nums) {
        res = new LinkedList<List<Integer>>();
        helper(nums, 0);
        return res;
    }

    public void helper(int[] nums, int i) {
        // 找到转置完成后的解，将其存入列表中
        if (i == nums.length - 1) {
            List<Integer> list = new LinkedList<Integer>();
            for (int j = 0; j < nums.length; j++) {
                list.add(nums[j]);
            }
            res.add(list);
        }
        // 将当前位置的数跟后面的数交换，并搜索解
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            helper(nums, i + 1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] nums = new int[] {1, 2, 3, 4};
        List<List<Integer>> lists = p.permute1(nums);
        lists.forEach(System.out::println);
    }
}

