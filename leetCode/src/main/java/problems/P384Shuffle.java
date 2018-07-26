package problems;

import java.util.Arrays;
import java.util.Random;

/**
 * 打乱一个没有重复元素的数组。
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */
public class P384Shuffle {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};

        P384Shuffle obj = new P384Shuffle(nums);

        int[] param_1 = obj.reset();
        int[] param_2 = obj.shuffle();

        System.out.println(param_1);
        System.out.println(param_2.toString());
    }

    private int[] nums;

    public P384Shuffle(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        int[] shuffles = nums.clone();
        for (int i = 0; i < nums.length; i++){
            int index = random.nextInt(nums.length);
            int temp = shuffles[i];
            shuffles[i] = shuffles[index];
            shuffles[index] = temp;
        }
        return shuffles;
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
}
