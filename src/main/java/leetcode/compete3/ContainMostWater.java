package main.java.leetcode.compete3;

/*题目描述
    11. 盛最多水的容器
    给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
/*示例：
    输入: [1,8,6,2,5,4,8,3,7]
    输出: 49
 */
public class ContainMostWater {
    //515ms 暴力破解
    /*
    复杂度分析
        时间复杂度：O(n^2)，计算所有n(n−1)/2种高度组合的面积。
        空间复杂度：O(1)，使用恒定的额外空间。
     */
    public int maxArea(int[] height) {
        int len = height.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                int row = Math.min(height[i], height[j]);
                int col = j - i;
                max = max > row * col ? max : row * col;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainMostWater c = new ContainMostWater();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(c.maxArea(height));
    }

    //10ms  双指针法
    /*
    算法
        这种方法背后的思路在于，两线段之间形成的区域总是会受到其中较短那条长度的限制。此外，两线段距离越远，得到的面积就越大。
        我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。 此外，我们会使用变量 maxareamaxarea 来持续存储到目前为止所获得的最大面积。
        在每一步中，我们会找出指针所指向的两条线段形成的区域，更新 maxareamaxarea，并将指向较短线段的指针向较长线段那端移动一步。
        在同样的条件下，移动指向较短线段的指针尽管造成了矩形宽度的减小，但却可能会有助于面积的增大。
        因为移动较短线段的指针会得到一条相对较长的线段，这可以克服由宽度减小而引起的面积减小。
     复杂度分析
        时间复杂度：O(n)，一次扫描。
        空间复杂度：O(1)，使用恒定的空间。
     */
    public int maxArea1(int[] height) {
        int len = height.length;
        int max = 0;
        int i = 0;
        int j = len - 1;
        while (i < j){
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
