package cn.qqchao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 *     所有数字（包括目标数）都是正整数。
 *     解集不能包含重复的组合。
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P40combinationSum2 {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3, 3, 6, 7},8));
    }

    static List<List<Integer>> result;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        quickSort(candidates, 0, candidates.length-1);
        result = new ArrayList();
        addCandidate(new ArrayList(), 0, 0, target, candidates);
        return result;
    }

    public static void addCandidate(List<Integer> preNums, int index, int preSum, int target, int[] candidates){
        for (int i = index; i < candidates.length; i++) {
                if(i > index && candidates[i] == candidates[i-1]){
                    continue;
                }
            int sum = preSum + candidates[i];
            List nums = new ArrayList(preNums);
            if (sum < target) {
                nums.add(candidates[i]);
                addCandidate(nums, i+1, sum, target, candidates);
            } else if (sum == target) {
                nums.add(candidates[i]);
                result.add(nums);
                break;
            } else {
                break;
            }
        }
    }




    /**
     * 递归
     */
    static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex-1);
            quickSort(arr, partitionIndex+1, right);
        }
    }

    /**
     * 分区
     */
    static int partition(int[] arr, int left ,int right) {
        int pivot = left,// 基准值
                index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index-1;
    }

    /**
     * 互换数值
     */
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
