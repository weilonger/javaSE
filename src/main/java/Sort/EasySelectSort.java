package main.java.Sort;

/*
    简单选择排序.
    核心思想：比较+交换。
    从待排序序列中，找到关键字最小的元素；
    如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
    从余下的 N - 1 个元素中，找出关键字最小的元素，重复(1)、(2)步，直到排序结束。
 */
public class EasySelectSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 5, 6, 3, 2};
        EasySelectSort e = new EasySelectSort();
        e.sort(nums);
        for (int n : nums) {
            System.out.println(n);
        }
    }

    public void sort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public void sort1(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int min = nums[i];
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < min) {
                    int temp = min;
                    min = nums[j];
                    nums[j] = temp;
                }
            }
            nums[i] = min;
        }
    }
}
