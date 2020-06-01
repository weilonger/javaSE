package main.java.Sort;

/*
    希尔排序
    核心思想：待排序数组按照步长gap进行分组，然后将每组的元素利用直接插入排序的方法进行排序；
    每次将gap折半减小，循环上述操作；当gap=1时，利用直接插入，完成排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 0 ,4 ,1};
        ShellSort s = new ShellSort();
        s.sort1(nums);
        for (int n : nums) {
            System.out.println(n);
        }
    }

    private void sort1(int[] nums) {
        int len = nums.length;
        int gap = len / 2;
        while (gap >= 1) {
            for (int i = 0; i < len - gap; i += gap) {
                for (int j = i; j >= 0; j--) {
                    if (nums[j] > nums[j + gap]) {
                        int temp = nums[j];
                        nums[j] = nums[j + gap];
                        nums[j + gap] = temp;
                    }
                }
            }
            gap /= 2;
        }
    }

    private void sort(int[] nums) {
        int len = nums.length;
        int gap = len / 2;
        while (gap >= 1) {
            for (int i = gap; i < len; i += gap) {
                for (int j = i - gap; j >=0 ; j--) {
                    if (nums[j] > nums[j + gap]) {
                        int temp = nums[j];
                        nums[j] = nums[j + gap];
                        nums[j + gap] = temp;
                    }
                }
            }
            gap /= 2;
        }
    }


}
