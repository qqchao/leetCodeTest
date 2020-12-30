package cn.qqchao.leetcode;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 *
 *
 * 说明：
 *
 *     输出结果中的每个元素一定是唯一的。
 *     我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P349intersection {

    public static void main(String[] args) {
        Date start = new Date();
        int sum = 0;
        for (int i = 0; i < 4000000000l; i++) {
            sum += i;
//            System.out.println(i);
        }
        Date end = new Date();
        System.out.println("use time:");
        System.out.println(end.getTime()-start.getTime());
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet();
        Set<Integer> intersectionSet = new HashSet();
        for (int i = 0; i < nums1.length; i++) {
            num1Set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (num1Set.contains(nums2[i])) {
                intersectionSet.add(nums2[i]);
            }
        }
        int[] intersectionArray = new int[intersectionSet.size()];
        List<Integer> intersectionList = new ArrayList<>(intersectionSet);

        for (int i = 0; i < intersectionList.size(); i++) {
            intersectionArray[i] = intersectionList.get(i);
        }
        return intersectionArray;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> intersectionList = new ArrayList<>();
        int pre = Integer.MIN_VALUE;
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]){
                if (nums1[i] != pre) {
                    intersectionList.add(nums1[i]);
                    pre = nums1[i];
                }
                i++;j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] intersectionArray = new int[intersectionList.size()];

        for (int k = 0; k < intersectionList.size(); k++) {
            intersectionArray[k] = intersectionList.get(k);
        }
        return intersectionArray;
    }
}
