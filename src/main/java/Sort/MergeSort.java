package main.java.Sort;

/*
    归并排序
    算法思想：
    归并排序是建立在归并操作上的一种有效的排序算法，该算法是采用分治法的一个典型的应用。它的基本操作是：将已有的子序列合并，达到完全有序的序列；
    即先使每个子序列有序，再使子序列段间有序。
    归并排序其实要做两件事：
        分解----将序列每次折半拆分
        合并----将划分后的序列段两两排序合并
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 0 ,4 ,1};
        MergeSort m = new MergeSort();
        int len = nums.length;
        int[] temp = new int[len];
        m.mergeSort(nums, 0, len - 1, temp);
        for (int n : nums) {
            System.out.println(n);
        }
    }

    private void mergeSort(int[] nums, int first, int last, int[] temp) {
        if (first < last) {
            int mid = (last + first) / 2;
            mergeSort(nums, first, mid, temp);
            mergeSort(nums, mid + 1, last, temp);
            mergeArray(nums, first, mid, last, temp);
        }
    }

    private void mergeArray(int[] nums, int first, int mid, int last, int[] temp) {
        int i = first;
        int j = mid + 1;
        int k = 0;
        while (i <= mid & j <= last) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
                k++;
            } else {
                temp[k] = nums[j];
                j++;
                k++;
            }
        }
        while (i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }
        while (j <= last) {
            temp[k] = nums[j];
            j++;
            k++;
        }
        for (int l = 0; l < k; l++) {
            nums[first + l] = temp[l];
        }
    }
}
