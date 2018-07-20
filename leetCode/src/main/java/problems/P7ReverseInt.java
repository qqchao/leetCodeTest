package problems;

/**
 * Class:
 *
 * @author 秦超
 * 2018/7/20
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
