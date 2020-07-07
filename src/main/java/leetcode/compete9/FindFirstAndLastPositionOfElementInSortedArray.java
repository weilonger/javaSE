package main.java.leetcode.compete9;

/*题目描述
    34. 在排序数组中查找元素的第一个和最后一个位置
    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    你的算法时间复杂度必须是 O(log n) 级别。
    如果数组中不存在目标值，返回 [-1, -1]。
*/
/*示例1:
    输入: nums = [5,7,7,8,8,10], target = 8
    输出: [3,4]
*/
/*示例2:
    输入: nums = [5,7,7,8,8,10], target = 6
    输出: [-1,-1]
*/
public class FindFirstAndLastPositionOfElementInSortedArray {
    //11ms O(n)
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int len = nums.length;
        int start = -1;
        int end = -1;
        int l = 0;
        int r = len - 1;
        Boolean lState = false;
        Boolean rState = false;
        while (l <= r) {
            if (!lState && nums[l] == target) {
                start = l;
                lState = true;
            } else if (!rState && nums[r] == target) {
                end = r;
                rState = true;
            } else {
                if (nums[l] < target) {
                    l++;
                }
                if (nums[r] > target) {
                    r--;
                }
            }
            if (start != -1 && end != -1) {
                break;
            }
        }
        result[0] = start;
        result[1] = end;
        return result;
    }

    //7ms O(log n)
    public int[] searchRange1(int[] nums, int target) {
        int len = nums.length;
        int[] result = new int[2];
        int start = -1;
        int end = -1;
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target < nums[l] || target > nums[r]) {
                break;
            } else {
                if (nums[mid] == target) {
                    l = r = mid;
                    while (r + 1 < len && nums[r + 1] == target) {
                        r++;
                    }
                    while (l - 1 >= 0 && nums[l - 1] == target) {
                        l--;
                    }
                    start = l;
                    end = r;
                    break;
                } else if (nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        result[0] = start;
        result[1] = end;
        return result;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray f = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = new int[] {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = f.searchRange1(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
