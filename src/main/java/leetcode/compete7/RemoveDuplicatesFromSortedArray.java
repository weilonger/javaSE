package main.java.leetcode.compete7;

/*题目描述
    26. 删除排序数组中的重复项
    给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
*/
/*示例 :
    给定数组 nums = [0,0,1,1,1,2,2,3,3,4],
    函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。 你不需要考虑数组中超出新长度后面的元素。
*/
/*
说明:
    为什么返回数值是整数，但输出的答案是数组呢?
    请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
    你可以想象内部操作如下:
    // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
    int len = removeDuplicates(nums);
    // 在函数里修改输入数组对于调用者是可见的。
    // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
    for (int i = 0; i < len; i++) {
        print(nums[i]);
    }
*/
public class RemoveDuplicatesFromSortedArray {
    /*
        方法：双指针法
            数组完成排序后，我们可以放置两个指针 i 和 j，其中 i 是慢指针，而 j 是快指针。只要 nums[i] = nums[j]，
            我们就增加 j 以跳过重复项。当我们遇到 nums[j]=nums[i] 时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]）的值复制到 nums[i+1]。
            然后递增 i，接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止。
        复杂度分析
            时间复杂度：O(n)， 假设数组的长度是 n，那么 i 和 j 分别最多遍历 n 步。
            空间复杂度：O(1)。
     */
    //14ms
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int i = 0;
        for (int j = 1; j < len; j++) {
            if (nums[i] != nums[j]) {
                i++;
            }
            nums[i] = nums[j];
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
        int[] nums = new int[]{1,1,2,2,5,6,7,8,8,9};
        int len = r.removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
