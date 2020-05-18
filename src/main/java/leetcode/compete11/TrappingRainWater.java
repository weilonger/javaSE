package main.java.leetcode.compete11;

/*题目描述
    42. 接雨水
    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    
    图片地址：https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png
    上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
*/
/*示例:
    输入: [0,1,0,2,1,0,1,3,2,1,2,1]
    输出: 6
*/
public class TrappingRainWater {
    //14ms
    /*
        先找出最大值位置，然后左右分开进行操作,设置左边最大l和右边最大r,
            如果height[l] > height[r] 时,雨水可填入height[l] - height[r]
            如果height[l] <= height[r] && height[r] > 0时, l = r; r++.
     */
    public int trap(int[] height) {
        int len = height.length;
        int sum = 0;
        if (len < 3) {
            return sum;
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                index = i;
            }
        }
        int l = 0;
        int r = 1;
        while (r <= index) {
            if (height[l] <= height[r]) {
                l = r;
                r++;
            } else {
                sum += height[l] - height[r];
                r++;
            }
        }
        r = len - 1;
        l = len - 2;
        while (l >= index) {
            if (height[r] <= height[l]) {
                r = l;
                l--;
            } else {
                sum += height[r] - height[l];
                l--;
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(t.trap(height));
    }
}

