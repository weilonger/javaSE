package main.java.Sort;

/*
    堆排序.
    堆的概念
    堆：本质是一种数组对象。特别重要的一点性质：<b>任意的叶子节点小于（或大于）它所有的父节点</b>。
    对此，又分为大顶堆和小顶堆，大顶堆要求节点的元素都要大于其孩子，小顶堆要求节点元素都小于其左右孩子，
    两者对左右孩子的大小关系不做任何要求。

    核心思想：
    1.首先将序列构建称为大顶堆（这样满足了大顶堆那条性质：位于根节点的元素一定是当前序列的最大值）
    2.取出当前大顶堆的根节点，将其与序列末尾元素进行交换
    （序列末尾的元素为已排序的最大值；由于交换了元素，当前位于根节点的堆并不一定满足大顶堆的性质）
    3.对交换后的n-1个序列元素进行调整，使其满足大顶堆的性质
    4.重复2.3步骤，直至堆中只有1个元素为止

 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {16, 7, 3, 20, 17, 8};

        HeapSort h = new HeapSort();
        h.sort(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    public void sort(int[] nums) {
        //构造大顶堆
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(nums, i, nums.length);
        }
        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = nums.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;

            //重新对堆进行调整
            adjustHeap(nums, 0, i);
        }
    }

    private void adjustHeap(int[] nums, int parent, int len) {
        int temp = nums[parent];
        int lChild = getLeft(parent);
        while (lChild < len) {
            int rChild = lChild + 1;
            if (rChild < len && nums[lChild] < nums[rChild]) {
                lChild++;
            }

            if (temp >= nums[lChild]) {
                break;
            }

            nums[parent] = nums[lChild];
            parent = lChild;
            lChild = getLeft(lChild);
        }
        nums[parent] = temp;
    }


    public int getLeft(int i) {
        return i * 2 + 1;
    }

    public int getRight(int i) {
        return i * 2 + 2;
    }

}
