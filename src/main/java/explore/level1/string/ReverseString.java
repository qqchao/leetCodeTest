package explore.level1.string;

/**
 * 请编写一个函数，其功能是将输入的字符串反转过来。
 *
 * 示例：
 *
 * 输入：s = "hello"
 * 返回："olleh"
 */
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString(""));
    }

    public static String reverseString(String s) {
        char[] sr = s.toCharArray();
        char[] ss = new char[sr.length];

        for (int i = 0; i < sr.length; i++){
            ss[i] = sr[sr.length-1-i];
        }

        return String.valueOf(ss);
    }

    /**
     * 单数组
     */
    public static String reverseString2(String s) {
        char[] ss = s.toCharArray();

        char temp;
        for (int i = 0, j = ss.length-1; i < j; i++){
            temp = ss[i];
            ss[i] = ss[j];
            ss[j] = temp;
            j--;
        }

        return new String(ss);
    }
}
