package cn.qqchao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P77combine {

    public static void main(String[] args) {
        combine(1,1);
    }

    static List<List<Integer>> result;

    static public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList();

        for (int i = 1; i <= n-k+1; i++) {
            List<Integer> numList = new ArrayList();
            numList.add(i);
            addCombine(numList, n, i+1,k-1);
        }

        System.out.println(result.toString());

        return result;
    }

    static void addCombine(List<Integer> numList, int n, int j, int k){
        if (k == 0) {
            result.add(numList);
        } else {
            for (int i = j; i <= n-k+1; i++) {
                if (i == n-k+1){
                    numList.add(i);
                    addCombine(numList, n, i+1, k-1);
                } else {
                    List<Integer> numList1 = new ArrayList();
                    numList1.addAll(numList);
                    numList1.add(i);
                    addCombine(numList1, n, i+1, k-1);
                }
            }
        }
    }
}
