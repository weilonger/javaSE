package main.java.Sort;

/*
    直接插入排序
    核心思想：将数组中的所有元素依次跟前面已经排好的元素相比较，如果选择的元素比已排序的元素小，则交换，直到全部元素都比较过
 */
public class DirectInsertSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 5, 6, 3, 2};
        DirectInsertSort d = new DirectInsertSort();
        d.sort(nums);
        for (int n : nums) {
            System.out.println(n);
        }
    }

    public void sort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

}
