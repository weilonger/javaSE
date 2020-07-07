package main.java.leetcode.compete14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/*
    给出一个区间的集合，请合并所有重叠的区间。
 */
public class MergeIntevals {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {1, 3}};
        MergeIntevals mergeIntevals = new MergeIntevals();
        int[][] result = mergeIntevals.merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.println("[" + result[i][0] + "," + result[i][1] + "]");
        }
    }

    public int[][] merge(int[][] intervals) {
        LinkedList<Interval> merged = new LinkedList<>();
        boolean[] status = new boolean[intervals.length];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (!status[i]) {
                for (int j = i + 1; j < intervals.length; j++) {
                    if ((intervals[j][0] < start && start <= intervals[j][1]) || (start >= intervals[j][0] && end <= intervals[j][1]) || (intervals[j][0] <= end && start < intervals[j][0]) || (intervals[j][0] >= start && intervals[j][1] <= end)) {
                        start = intervals[j][0] < start ? intervals[j][0] : start;
                        end = intervals[j][1] > end ? intervals[j][1] : end;
                        status[j] = true;
                    }
                }
                merged.add(new Interval(new int[]{start, end}));
            }
        }
        int[][] result = new int[merged.size()][2];
        int i = 0;
        for (Interval m : merged) {
            result[i] = m.toArray();
            i++;
        }
        return result;
    }

    private static class Interval {
        int start;
        int end;
        Interval(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        int[] toArray() {
            return new int[]{this.start, this.end};
        }
    }


}
