package cn.qqchao.leetcode;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 *
 * 示例:
 *
 * 输入: 43261596
 * 输出: 964176192
 * 解释: 43261596 的二进制表示形式为 00000010100101000001111010011100 ，
 *      返回 964176192，其二进制表示形式为 00111001011110000010100101000000 。
 * 进阶:
 * 如果多次调用这个函数，你将如何优化你的算法？
 */
public class P190ReverseBits {

    public static void main(String[] args) {
        System.out.println(reverseBits(3324));
    }

    public static int reverseBits(int n) {
        char[] cs = Integer.toBinaryString(n).toCharArray();
        int reverse = 0;
        for (int i = cs.length-1; i >= 0; i--){
            if(cs[i] == '1') reverse = reverse * 2 + 1;
            else reverse = reverse * 2;
        }
        return reverse << (32 - cs.length);
    }
}
