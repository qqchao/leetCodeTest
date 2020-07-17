package problems;

/**
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n。
 *
 * 示例:
 * 给定 n = 2，返回 91。（答案应该是除[11,22,33,44,55,66,77,88,99]外，0 ≤ x < 100 间的所有数字）
 */
public class P357countNumbersWithUniqueDigits {
    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(2));
        System.out.println(countNumbersWithUniqueDigits(3));
        System.out.println(countNumbersWithUniqueDigits(10));
        System.out.println(countNumbersWithUniqueDigits(11));
    }

    public static int countNumbersWithUniqueDigits(int n) {
        if(n<=0) return 1;
        else {
            int temp;
            int count = 10;
            for(int i = 1;i < n; i++){
                temp = 9;
                for(int j = 1;j <= i; j++){
                    temp *= (10-j);
                }
                count += temp;
            }

            return count;
        }
    }
}
