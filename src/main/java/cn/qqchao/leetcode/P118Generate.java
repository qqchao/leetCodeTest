package cn.qqchao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class P118Generate {
    public static void main(String[] args) {
        
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows < 0) {
            return null;
        }

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(numRows == 0) return list;
        List<Integer> row1 = new ArrayList<Integer>();
        row1.add(1);
        list.add(row1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> data = new ArrayList<Integer>();
            List<Integer> prev = list.get(i - 1);
            data.add(1);
            for (int j = 1; j < i; j++) {
                data.add(prev.get(j - 1) + prev.get(j));
            }
            data.add(1);

            list.add(data);
        }


        return list;
    }
}
