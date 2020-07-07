package main.java.leetcode.compete9;

/*题目描述
    33. 搜索旋转排序数组
    假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]。
    搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
    你可以假设数组中不存在重复的元素。
    你的算法时间复杂度必须是 O(log n) 级别。
*/
/*示例1:
    输入: nums = [4,5,6,7,0,1,2], target = 0
    输出: 4
*/
/*示例2:
    输入: nums = [4,5,6,7,0,1,2], target = 3
    输出: -1
*/
public class SearchInRotatedSortedArray {
    //15ms
    public int search(int[] nums, int target) {
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    //8ms
    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //1. 找到旋转点
        int pivot = findMinIndex(nums);
        if (target == nums[pivot]) {
            return pivot;
        }
        //2. 判断target 是在旋转点左边还是右边。
        int start = (target <= nums[nums.length - 1]) ? pivot : 0;
        int end = (target <= nums[nums.length - 1]) ? nums.length : pivot - 1;
        //因为左右都是已经排序的列表，不管是在左边还是右边，都可以使用二分查找
        while (start <= end) {
            int mid = (end + start) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return - 1;
    }

    private int findMinIndex(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (end + start) >>> 1;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(s.search(nums, target));
    }
}
