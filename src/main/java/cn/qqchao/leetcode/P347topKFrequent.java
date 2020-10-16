package cn.qqchao.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 *
 * 提示：
 *
 *     你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 *     你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *     题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 *     你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P347topKFrequent {

    public static void main(String[] args) {

    }

    private static String kNum = "num";
    private static String kCount = "count";

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCountsMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            add(numCountsMap, nums[i]);
        }

        List<Map<String, Integer>> countList = new ArrayList();
        numCountsMap.keySet().forEach(num -> {
            Map<String, Integer> countMap = new HashMap();
            countMap.put(kNum, num);
            countMap.put(kCount, numCountsMap.get(num));
            countList.add(countMap);
        });

        quickSort(countList, 0, countList.size()-1);

        int res[] = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = countList.get(i).get(kNum);
        }

        return res;
    }

    void add(Map<Integer, Integer> map, int num){
        Integer count = map.get(num);
        if (count == null) {
            map.put(num, 1);
        } else {
            map.put(num, count+1);
        }
    }

    private void quickSort(List<Map<String, Integer>> countList, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(countList, left, right);
            quickSort(countList, left, partitionIndex-1);
            quickSort(countList, partitionIndex+1, right);
        }
    }

    private int partition(List<Map<String, Integer>> countList, int left, int right) {
        int midIndex = (left + right)/2;

        Integer midValue = countList.get(midIndex).get(kCount);
        Integer leftValue = countList.get(left).get(kCount);
        Integer rightValue = countList.get(right).get(kCount);
        if ((midValue > leftValue &&
        midValue < rightValue) ||
                (midValue < leftValue &&
                midValue > rightValue)) {
            swap(countList, midIndex, left);
        } else if ((rightValue > leftValue &&
                rightValue < midValue) ||
                (rightValue < leftValue &&
                        rightValue > midValue)){
            swap(countList, right, left);
        }

        int pivot = left,// 基准值
                index = pivot + 1;
        for (int i = left; i <= right; i++) {
            if (i == pivot) continue;
            if (countList.get(i).get(kCount) > countList.get(pivot).get(kCount)) {
                swap(countList, i, index);
                index++;
            }
        }
        swap(countList, pivot, index - 1);
        return index-1;
    }

    private void swap(List<Map<String, Integer>> countList, int i, int j) {
        Map<String, Integer> temp = countList.get(i);
        countList.set(i, countList.get(j));
        countList.set(j, temp);
    }
}
