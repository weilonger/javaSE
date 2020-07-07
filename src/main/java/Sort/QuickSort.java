package main.java.Sort;

import java.util.Stack;

/*
    快速排序.
    核心思想：挖坑填数+分治法
    从序列当中选择一个基准数(pivot)
    在这里我们选择序列当中第一个数最为基准数
    将序列当中的所有数依次遍历，比基准数大的位于其右侧，比基准数小的位于其左侧
    重复步骤1.2，直到所有子集当中只有一个元素为止。
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 0 ,4 ,1};
        QuickSort q = new QuickSort();
        int len = nums.length;
        q.quickSort1(nums, 0, len - 1);
        for (int n : nums) {
            System.out.println(n);
        }
    }

    //非递归型
    private void quickSort1(int[] nums, int start, int end) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(start);
        stack.push(end);
        while (!stack.empty()) {
            end = stack.pop();
            start = stack.pop();
            int index = partSort(nums, start, end);
            if (index - 1 > start) {
                stack.push(start);
                stack.push(index - 1);
            }
            if (index + 1 < end) {
                stack.push(index + 1);
                stack.push(end);
            }
        }
    }

    private int partSort(int[] nums, int start, int end) {
        int pivot = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= pivot) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= pivot) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }

    //递归型
    private void quickSort(int[] nums, int start, int end) {
        int l = start;
        int r = end;
        if (start < end) {
            int num = nums[start];
            while (l < r) {
                while (l < r && nums[r] >= num) {
                    r--;
                }
                if (l < r) {
                    nums[l] = nums[r];
                    l++;
                }
                while (l < r && nums[l] < num) {
                    l++;
                }
                if (l < r) {
                    nums[r] = nums[l];
                    r--;
                }
            }
            nums[l] = num;
            quickSort(nums, start, l - 1);
            quickSort(nums, l + 1, end);
        }
    }
}
