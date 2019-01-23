package main.java.leetcode.compete5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*题目描述
    18. 四数之和
    给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
    使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
    注意：答案中不可以包含重复的四元组。
*/
/*示例:
    nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
    满足要求的四元组集合为：
    [
      [-1,  0, 0, 1],
      [-2, -1, 1, 2],
      [-2,  0, 0, 2]
    ]
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i == 0 || (nums[i] != nums[i - 1] && i > 0)) {
                for (int j = len - 1; j > i + 2; j--) {
                    if (j == len - 1 || (nums[j + 1] != nums[j] && j < len - 1)) {
                        int k = i + 1;
                        int l = j - 1;
                        while (k < l) {
                            int sum = nums[i] + nums[k] + nums[l] + nums[j];
                            if (sum == target) {
                                lists.add(Arrays.asList(nums[i], nums[k], nums[l], nums[j]));
                                System.out.println(i+","+j+","+k+","+l);
                                while (nums[k] == nums[k + 1] && k < l) {
                                    k++;
                                }
                                while (nums[l - 1] == nums[l] && k < l) {
                                    l--;
                                }
                                k++;
                                l--;
                            } else if (sum > target) {
                                while (nums[l - 1] == nums[l] && k < l) {
                                    l--;
                                }
                                l--;
                            } else {
                                while (nums[k + 1] == nums[k] && k < l) {
                                    k++;
                                }
                                k++;
                            }
                        }
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        FourSum f = new FourSum();
        int[] nums = new int[]{5,5,3,5,1,-5,1,-2};
        int target = 4;
        System.out.println(f.fourSum(nums,target));
    }
}
