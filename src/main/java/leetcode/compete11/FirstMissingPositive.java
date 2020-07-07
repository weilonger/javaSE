package main.java.leetcode.compete11;

/*题目描述
    41. 缺失的第一个正数
    给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
*/
/*示例1:
    输入: [1,2,0]
    输出: 3
*/
/*示例2:
    输入: [3,4,-1,1]
    输出: 2
*/
/*示例3:
    输入: [7,8,9,11,12]
    输出: 1
 */
/*说明:
    你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 */
public class FirstMissingPositive {
    
    /*
        遍历一次数组把大于等于1的和小于数组大小的值放到原数组对应位置，然后再遍历一次数组查当前下标是否和值对应，如果不对应那这个下标就是答案，否则遍历完都没出现那么答案就是数组长度加1。
     */
    //13ms
    public int firstMissingPositive(int[] nums) {
        int min = Integer.MAX_VALUE;
        Boolean[] temp = new Boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i] && nums[i] > 0) {
                min = nums[i];
            }
            temp[i] = false;
        }
        if (min > 1) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                temp[nums[i] - 1 ] = true;
            }
        }
        int j = 0;
        for (;j < nums.length; j++) {
            if (!temp[j]) {
                return j + 1;
            }
        }
        
        return j + 1;
    }
    
    public static void main(String[] args) {
        FirstMissingPositive f = new FirstMissingPositive();
        int[] nums = new int[]{1,2,0};
        System.out.println(f.firstMissingPositive(nums));
    }
}
