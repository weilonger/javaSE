package main.java.leetcode.compete9;

/*题目描述
    35. 搜索插入位置
    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    你可以假设数组中无重复元素。
*/
/*示例1:
    输入: [1,3,5,6], 5
    输出: 2
*/
/*示例2:
    输入: [1,3,5,6], 0
    输出: 0
*/
/*示例3:
    输入: [1,3,5,6], 7
    输出: 4
*/
public class SearchInsertPosition {
    //5ms
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            if (nums[l] > target) {
                return l;
            } else if (nums[r] < target) {
                return r + 1;
            } else {
                int mid = l + (r - l) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target){
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInsertPosition s = new SearchInsertPosition();
        int[] nums = new int[]{1,3,5,6};
        int target = 0;
        System.out.println(s.searchInsert(nums, target));
    }
}
