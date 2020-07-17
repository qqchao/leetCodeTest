package cn.qqchao.leetcode;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class P7ReverseInt {

    public static void main(String[] args) {
        System.out.println(reverse2(-111311234));
    }

    public static int reverse(int x) {
        int res = 0;
        int a = x>0?1:-1;
        x *= a;
        while (x > 0){
            int temp = res;
            res = res * 10 + x % 10;
            if (res/10 != temp) return 0;
            x /= 10;
        }

        return res * a;
    }

    public static int reverse2(int x) {
        int res = 0;

        while (x != 0){
            int temp = res;
            res = res * 10 + x % 10;
            if (res/10 != temp) return 0;//校验溢出
            x /= 10;
        }

        return res;
    }
}
