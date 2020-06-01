package main.java.leetcode.compete133;

/*
公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 */

import java.util.Arrays;

/* 提示：
    1 <= costs.length <= 100
    costs.length 为偶数
    1 <= costs[i][0], costs[i][1] <= 1000
 */
public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        int len = costs.length;
        int sum = 0;
        int[] diff = new int[len];
        for (int i = 0; i< len; i++) {
            sum += costs[i][0];
            diff[i] = costs[i][0] - costs[i][1];
        }
        Arrays.sort(diff);
        for (int i = len - 1; i > len / 2 - 1; i--) {
            sum -= diff[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        TwoCityScheduling twoCityScheduling = new TwoCityScheduling();
        int[][] costs = new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        System.out.println(twoCityScheduling.twoCitySchedCost(costs));
    }
}
