package main.java.leetcode.compete12;

//同一类型 55

/*题目描述
    45. 跳跃游戏 II
    给定一个非负整数数组，你最初位于数组的第一个位置。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    你的目标是使用最少的跳跃次数到达数组的最后一个位置。
*/

/*说明：
    假设你总是可以到达数组的最后一个位置。
 */
/*示例:
   输入: [2,3,1,1,4]
    输出: 2
    解释: 跳到最后一个位置的最小跳跃数是 2。
         从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
*/
public class JumpGameII {
    //超出时间限制
    public int jump(int[] nums) {
        int len = nums.length;
        int[] minJump = new int[len];
        for (int i = 1; i < len; i++) {
            int jump = nums[i - 1];
            for (int j = 1; j <= jump && i + j <= len; j++) {
                if (minJump[i + j - 1] > minJump[i - 1] + 1 || minJump[i + j - 1] == 0) {
                    minJump[i + j - 1] = minJump[i - 1] + 1;
                }
            }
            if (minJump[len - 1] != 0) {
                return minJump[len - 1];
            }
        }
        return minJump[len - 1];
    }
    
    //贪心算法
    public int jump2(int[] nums) {
        int len = nums.length;
        int minJump = 0;
        int curMax = 0;
        int curBound = 0;
        for (int i = 0; i < len; i++) {
            int jump = nums[i];
            if (curBound < i) {
                minJump++;
                curBound = curMax;
            }
            curMax = curMax > i + jump ? curMax : i + jump;
        }
        return minJump;
    }
    
    public static void main(String[] args) {
        JumpGameII j = new JumpGameII();
        int[] nums = new int[]{2,3,0,1,4};
        System.out.println(j.jump2(nums));
    }
}
