package problems;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class P125IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        char[] ss = s.toLowerCase().toCharArray();
        int count = 0;
        for(int i = 0; i < ss.length; i++){
            if(ss[i]>='a' && ss[i]<='z'){
                ss[count] = ss[i];
                count++;
            }
            if(ss[i]>='0' && ss[i]<='9'){
                ss[count] = ss[i];
                count++;
            }
        }

        for (int i = 0; i < count/2; i++){
            if(ss[i] != ss[count-1-i]) return false;
        }

        return true;
    }
}
