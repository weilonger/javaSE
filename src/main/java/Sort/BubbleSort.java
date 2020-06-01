package main.java.Sort;

/*
冒泡排序思路比较简单：
    将序列当中的左右元素，依次比较，保证右边的元素始终大于左边的元素（第一轮结束后，序列最后一个元素一定是当前序列的最大值）
    对序列当中剩下的n-1个元素再次执行步骤1
    对于长度为n的序列，一共需要执行n-1轮比较（利用while循环可以减少执行次数）
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 0 ,4 ,1};
        BubbleSort b = new BubbleSort();
        b.sort(nums);
        for (int n : nums) {
            System.out.println(n);
        }
    }

    private void sort(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i >= 0 ; i--) {
            for (int j = 0; j < i ; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
