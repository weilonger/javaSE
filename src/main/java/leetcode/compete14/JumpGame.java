package main.java.leetcode.compete14;

//同一类型 45

/*题目描述
    55. 跳跃游戏 II
    给定一个非负整数数组，你最初位于数组的第一个位置。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    判断你是否能够到达最后一个位置。
*/

/*示例1:
    输入: [2,3,1,1,4]
    输出: true
    解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
*/
/*示例2:
    输入: [3,2,1,0,4]
    输出: false
    解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0，所以你永远不可能到达最后一个位置。
 */
public class JumpGame {
    //474ms
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] temp = new boolean[len + 1];
        temp[1] = true;
        for (int i = 1; i <= len; i++) {
            int jump = nums[i - 1];
            if (temp[i]) {
                if (i + jump >= len) {
                    temp[len] = true;
                    return true;
                } else {
                    for (int j = 1; j <= jump; j++) {
                        int jump1 = nums[i + j - 1];
                        if (jump1 != 0) {
                            temp[i + j] = true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public boolean canJump1(int[] nums) {
        int len = nums.length;
        int n = 1;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] >= n) {
                n = 1;
            } else {
                n++;
            }
            if (i == 0 && n > 1) {
                return false;
            }
        }
        return true;
    }
    
    //贪心算法 3ms
    public boolean canJump2(int[] nums) {
        int len = nums.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            //最大到达值小于当前位置时返回false
            if (i > max) {
                return false;
            }
            max = max > i + nums[i] ? max : i + nums[i];
        }
        if (max >= len - 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        JumpGame j = new JumpGame();
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(j.canJump2(nums));
        
    }
    
}
