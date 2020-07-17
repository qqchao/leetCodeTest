package cn.qqchao.leetcode;

/**
 * 假设你正在爬楼梯。需要 n 步你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 步 + 1 步
 * 2.  2 步
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 步 + 1 步 + 1 步
 * 2.  1 步 + 2 步
 * 3.  2 步 + 1 步
 */
public class P70ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs(6));
        System.out.println(climbStairs(54));
    }

    public static int climbStairs(int n) {
        long sum = 0;
        for (int i = 0; i <= n/2; i++){
            sum += combination(n-i, i);
        }
        return (int)sum;
    }

    public static long combination(int m, int n){
        if (m < n) return 0;
        long cnm = 1;
        int k = (n < m-n) ? n : m-n;
        for(int i = 1; i <= k; i++){
            cnm = cnm * m-- / i;
        }

//        System.out.println("C " + n + " " + m + " -> " + cnm);

        return cnm;
    }
}
