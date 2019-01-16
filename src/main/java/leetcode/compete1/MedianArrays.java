package main.java.leetcode.compete1;

/*题目描述
    4.寻找两个有序数组的中位数
    给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
    请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
    你可以假设 nums1 和 nums2 不会同时为空。
 */
/*示例1：
    nums1 = [1, 3]
    nums2 = [2]
    则中位数是 2.0
 */
/*示例2：
    nums1 = [1, 2]
    nums2 = [3, 4]
    则中位数是 (2 + 3)/2 = 2.5
 */
public class MedianArrays {
    //52ms
    /*
    复杂度分析

    时间复杂度：O(log(min(m,n)))，
        首先，查找的区间是 [0, m]。 而该区间的长度在每次循环之后都会减少为原来的一半。
        所以，我们只需要执行 log(m) 次循环。由于我们在每次循环中进行常量次数的操作，所以时间复杂度为 O(log(m))。
        由于 m≤n，所以时间复杂度是 O(log(min(m,n)))。
    空间复杂度：O(1)，
        我们只需要恒定的内存来存储 9 个局部变量， 所以空间复杂度为 O(1)。
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        int n1 = length / 2;
        int n2 = length % 2;
        double median;
        int[] nums3 = new int[length];
        for (int i = 0, j = 0, k = 0; i < length; i++) {
            if (j < length1 && k < length2) {
                if (nums1[j] < nums2[k]) {
                    nums3[i] = nums1[j++];
                } else {
                    nums3[i] = nums2[k++];
                }
            } else if (j >= length1) {
                nums3[i] = nums2[k++];
            } else if (k >= length2) {
                nums3[i] = nums1[j++];
            }
//            System.out.print(nums3[i] + " ");
        }
        if (n2 == 1) {
            median = nums3[n1];
        } else {
            median = ((double)(nums3[n1 - 1] + nums3[n1]))/2;
        }
        return median;
    }

    public int[] mergeSort(int[] nums1, int[] nums2){
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        int[] nums3 = new int[length];
        for (int i = 0, j = 0, k = 0; i < length; i++) {
            if (j < length1 && k < length2) {
                if (nums1[j] < nums2[k]) {
                    nums3[i] = nums1[j++];
                } else {
                    nums3[i] = nums2[k++];
                }
            } else if (j >= length1) {
                nums3[i] = nums2[k++];
            } else if (k >= length2) {
                nums3[i] = nums1[j++];
            }
        }
        return nums3;
    }

    public static void main(String[] args) {
        MedianArrays m = new MedianArrays();
        int[] nums1 = new int[]{3};
        int[] nums2 = new int[]{-2,-1};
        int[] nums3 = m.mergeSort(nums1, nums2);
        //java9 新增方法
        //List<Integer> list = List.of(nums3);
        System.out.println(m.findMedianSortedArrays(nums1, nums2));
    }
}
