package cn.qqchao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class P204CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(4));
        System.out.println(countPrimes(5));
        System.out.println(countPrimes(97));
        System.out.println(countPrimes(100));
    }

    /**
     * 超时了
     */
    public static int countPrimes(int n) {
        if(n < 3) return 0;
        if(n == 3) return 1;
        int count = 1;
        for(int i = 3;i < n; i+=2){
            boolean su = true;
            for(int j = 2; j <= (int)Math.sqrt(i); j++){
                if(i%j ==0){
                    su = false;
                    break;
                }
            }
            if(su) count++;
        }
        return count;
    }


    /**
     * 用质数除  依然巨慢无比，好在没超时，List的原因 TODO
     */
    public static int countPrimes2(int n) {
        if(n < 3) return 0;
        if(n == 3) return 1;
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for(int i = 3;i < n; i+=2){
            boolean su = true;
            for(int j = 0; j < primes.size() && primes.get(j) <= (int)Math.sqrt(i); j++){
                if(i%primes.get(j) ==0){
                    su = false;
                    break;
                }
            }
            if(su) primes.add(i);
        }
        return primes.size();
    }
}
