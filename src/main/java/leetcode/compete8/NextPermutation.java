package main.java.leetcode.compete8;

/*题目描述
    31. 下一个排列
    实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    必须原地修改，只允许使用额外常数空间。
*/
/*示例:
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1
*/
public class NextPermutation {
    //20ms
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int signal = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                signal = i;
                break;
            }
        }
        if (signal < 0) {
            for (int j = 0; j < len / 2; j++) {
                int temp = nums[j];
                nums[j] = nums[len - j - 1];
                nums[len - j - 1] = temp;
            }
        } else {
            for (int l = signal + 1; l <= len - 2; l++) {
                if (nums[signal] < nums[l] && nums[signal] >= nums[l + 1]) {
                    int temp1 = nums[signal];
                    nums[signal] = nums[l];
                    nums[l] = temp1;
                    break;
                }
            }
            for (int k = signal + 1; k < signal + 1 + (len - 1 - signal + 1) / 2; k++) {
                int temp2 = nums[k];
                nums[k] = nums[len - k + signal];
                nums[len - k + signal] = temp2;
            }
        }
    }

    /*
        方法：一遍扫描
            首先，我们观察到对于任何给定序列的降序，没有可能的下一个更大的排列。
            我们需要从右边找到第一对两个连续的数字 a[i]和a[i−1]，它们满足 a[i]>a[i-1]。
            现在，没有对 a[i−1] 右侧的重新排列可以创建更大的排列，因为该子数组由数字按降序组成。
            因此，我们需要重新排列 a[i-1] 右边的数字，包括它自己。

            现在，什么样的重新排列将产生下一个更大的数字？我们想要创建比当前更大的排列。
            因此，我们需要将数字 a[i−1] 替换为位于其右侧区域的数字中比它更大的数字，例如 a[j]。
        复杂度分析
            时间复杂度：O(n)，在最坏的情况下，只需要对整个数组进行两次扫描。
            空间复杂度：O(1)，没有使用额外的空间，原地替换足以做到。
     */
    public void nextPermutation1(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        int[] nums = new int[]{2, 3, 1};
        n.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
