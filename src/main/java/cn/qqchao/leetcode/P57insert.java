package cn.qqchao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. 插入区间
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 *
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 *
 *
 * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
 */
public class P57insert {
    public static void main(String[] args) {
        int[][] insert = insert(
                new int[][]{{1, 2}, {6, 9}},
                new int[]{3, 5});
        for (int i = 0; i < insert.length; i++) {
            for (int j = 0; j < insert[0].length; j++) {
                System.out.print(insert[i][j] + " ");
            }

            System.out.println(
            );
        }
        System.out.println("12");
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        boolean added = false;
        int[][] res = new int[intervals.length+1][2];
        if (intervals.length == 0) {
            res[0] = newInterval;
            return res;
        }
        int i = 0,j = 0;
        while (i < intervals.length){
            if (added) {
                res[j++] = intervals[i++];
            } else {
                int[] interval = intervals[i++];
                if (interval[1] < newInterval[0]) {
                    res[j++] = interval;
                } else if (interval[0] > newInterval[1]) {
                    res[j++] = newInterval;
                    res[j++] = interval;
                    added = true;
                } else {
                    if (interval[1] > newInterval[1]) {
                        newInterval[1] = interval[1];
                    }
                    if (interval[0] < newInterval[0]) {
                        newInterval[0] = interval[0];
                    }
                }
            }
        }
        if (!added) {
            res[j++] = newInterval;
        }

        return Arrays.copyOf(res, j);
    }
}
