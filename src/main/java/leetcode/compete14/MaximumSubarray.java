package main.java.leetcode.compete14;

import java.util.Arrays;

/*题目描述
    53. 最大子序和
    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
*/
/*示例
    输入: [-2,1,-3,4,-1,2,1,-5,4],
    输出: 6
    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray m = new MaximumSubarray();
        int[] nums = new int[] {1, 2, 3, -1};
        System.out.println(m.maxSubArray1(nums));
    }

    // Kadane 算法
    private int maxSubArray0(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    // 动态规划
    private int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    // 分治法
    private int maxSubArray1(int[] nums) {
        return mergeCount(nums, 0, nums.length)[2];
    }

    private int[] mergeCount(int[] nums, int fromIndex, int toIndex) {
        int[] result = new int[4];
        if (toIndex - fromIndex != 1) {
            int midIndex = (toIndex + fromIndex) / 2;
            int[] resL = mergeCount(nums, fromIndex, midIndex);
            int[] resR = mergeCount(nums, midIndex, toIndex);
            result[0] = Math.max(resL[0], resL[3] + resR[0]);
            result[1] = Math.max(resR[1], resL[1] + resR[3]);
            result[2] = Math.max(Math.max(resL[2], resR[2]), resL[1] + resR[0]);
            result[3] = resL[3] + resR[3];
            return result;
        }
        Arrays.fill(result, nums[fromIndex]);
        return result;
    }
}
