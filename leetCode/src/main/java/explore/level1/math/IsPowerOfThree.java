package explore.level1.math;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
public class IsPowerOfThree {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree2(45));
        System.out.println(isPowerOfThree2(81));
    }

    public boolean isPowerOfThree(int n) {
        if(n<=0){
            return false;
        }
        while(n>1){
            if(n%3!=0){
                return false;
            }
            n/=3;
        }
        return true;
    }

    /**
     * 对数换底  妙极。。。
     */
    public static boolean isPowerOfThree2(int n) {
        if(n<=0){
            return false;
        }

        //  Math.log10(n)/Math.log10(3) 换底公式 结果就是log3(n)
        return Math.log10(n)/Math.log10(3)%1==0;
    }
}
