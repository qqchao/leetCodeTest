package explore.level1.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个数组，写一个方法来计算它们的交集。
 *
 * 例如:
 * 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 *
 * 注意：
 *
 *    输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 *    我们可以不考虑输出结果的顺序。
 * 跟进:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Intersect {
    public static void main(String[] args) {
        int[] nums = intersect(new int[]{4,1,2,1,2},new int[]{2,1,2,3});

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> res = new ArrayList<Integer>();

        for (int i = 0,j = 0,k = 0;i<nums1.length+nums2.length;i++){
            if(j == nums1.length || k == nums2.length){
                break;
            }
            if(nums1[j] == nums2[k]){
                res.add(nums1[j]);
                j++;
                k++;
                i++;
            }else if (nums1[j] < nums2[k]){
                j++;
            }else {
                k++;
            }
        }

        int[] result = new int[res.size()];

        for(int i = 0; i< res.size(); i++){
            result[i] = res.get(i);
        }

        return result;
    }
}
