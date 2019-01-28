package main.java.leetcode.compete4;

import java.util.Arrays;

/*题目描述
    16. 最接近的三数之和
    给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
    返回这三个数的和。假定每组输入只存在唯一答案。
 */
/*示例：
    nums = [-1，2，1，-4], 和 target = 1.
    与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
*/
public class ThreeSumClosest {
    //21ms
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int diff = Integer.MAX_VALUE;
        int closest = 0;
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[k] + nums[j];
                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    closest = sum;
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                }
            }
        }
        return closest;
    }

    //25ms
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[k] + nums[j];
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum == target) {
                    return closest;
                } else if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        ThreeSumClosest t = new ThreeSumClosest();
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(t.threeSumClosest(nums, target));
    }
}
