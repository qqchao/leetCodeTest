package cn.qqchao.leetcode;

import java.util.PriorityQueue;

/**
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 *     如果 x == y，那么两块石头都会被完全粉碎；
 *     如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 *
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 *
 *
 * 示例：
 *
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 *
 *
 *
 * 提示：
 *
 *     1 <= stones.length <= 30
 *     1 <= stones[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P1046LastStoneWeight {
    public static void main(String[] args) {

        System.out.println(lastStoneWeight2(new int[]{10, 8, 4}));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((a,b) -> b - a);

        for (int a : stones){
            priorityQueue.offer(a);
        }

        while (priorityQueue.size() > 1) {
            Integer num1 = priorityQueue.poll();
            Integer num2 = priorityQueue.poll();

            if (num1>num2) {
                priorityQueue.offer(num1-num2);
            }
        }

        return priorityQueue.isEmpty()?0:priorityQueue.poll();
    }

    public static int lastStoneWeight2(int[] stones) {
        int[] counts = new int[1001];

        for (int a : stones){
            counts[a] = counts[a] + 1;
        }

        int i = 1000;
        int num1 = 0;
        int num2 = 0;
        while (i > 0) {
            while (num1 == 0 && i > 0) {
                if (counts[i] > 0) {
                    num1 = i;
                    counts[i] = counts[i] - 1;
                    if (counts[i] == 0){
                        i--;
                    }
                } else {
                    i--;
                }
            }

            while (num2 == 0 && i > 0) {
                if (counts[i] > 0) {
                    num2 = i;
                    counts[i] = counts[i] - 1;
                    if (counts[i] == 0){
                        i--;
                    }
                } else {
                    i--;
                }
            }

            if (num1 > num2) {
                counts[num1-num2] = counts[num1-num2] + 1;
                if(num2>0 && num1-num2 > i) {
                    i = num1- num2;
                }
            }
            if(num1 > 0){
                counts[0] = num1 - num2;
            }

            num1 = 0;
            num2 = 0;
        }

        return counts[0];
    }

}
