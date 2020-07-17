package explore.level1.sortandsearch;

/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 示例:
 *
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 *
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 *
 * 所以，4 是第一个错误的版本。
 */
public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(3));
    }

    public static int firstBadVersion(int n) {
        if(n < 1) return 0;
        int good = 1;
        int bad = n;
        while(good < bad){
            int mid = good + (bad - good)/2;
            if(isBadVersion(mid)) bad = mid;
            else good = mid + 1;
        }
        return bad;
    }

    /**
     * 定义API方法同名方法，暂时别报错
     */
    static boolean isBadVersion(int version){
        return true;
    }
}
