package main.java.leetcode.compete12;

/*题目描述
    47. 全排列II
    给定一个可包含重复数字的序列，返回所有不重复的全排列。
*/

/*示例:
    输入: [1,1,2]
    输出:
    [
        [1,1,2],
        [1,2,1],
        [2,1,1]
    ]
*/

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List lists = new ArrayList();
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        backtrack(lists, list, nums, len);

        return lists;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> list, int[] nums, int len){
        if (list.size() == len) {
            if (!lists.contains(list)) {
                lists.add(new ArrayList<>(list));
            }
        } else {
            int k = 0;
            List<Integer> list1 = new ArrayList<>(list);
            for (int num : nums) {
                list.add(num);
                int[] nums1 = getNewNums(nums, k++);
                backtrack(lists, list, nums1, len);
                list.remove(list.size() - 1);
                list = list1;
            }
        }
    }

    private int[] getNewNums(int[] nums, int k) {
        int len = nums.length;
        int[] nums1 = new int[len - 1];
        int i = 0;
        int j = 0;
        for (int num : nums) {
            if (j != k) {
                nums1[i++] = num;
            }
            j++;
        }
        return nums1;
    }

    public static void main(String[] args) {
        PermutationsII p = new PermutationsII();
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> lists = p.permuteUnique(nums);
        lists.forEach(System.out::println);
    }
}
