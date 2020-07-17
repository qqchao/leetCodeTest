package problems;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class P387FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("helloheod"));
        System.out.println(firstUniqChar2("helloheod"));
        System.out.println(firstUniqChar3("helloheod"));
    }

    public static int firstUniqChar(String s) {
        char[] ss = s.toCharArray();
        for(int i = 0; i < ss.length; i++){
            for(int j = 0;i < ss.length; j++){
                if(i != j && ss[i] == ss[j]) break;
                if(j == ss.length-1) return i;
            }
        }

        return -1;
    }

    /**
     * 找String中字符的首位坐标
     */
    public static int firstUniqChar2(String s) {
        int result = -1;
        for(char c = 'a';c<='z';c++){
            int index = s.indexOf(c);
            if(index != -1 && index == s.lastIndexOf(c)){
                result = result != -1?Math.min(result,index):index;
            }
        }
        return result;
    }

    /**
     * f1 + f2
     */
    public static int firstUniqChar3(String s) {
        char[] ss = s.toCharArray();
        for(int i = 0; i < ss.length; i++){
            char c = ss[i];
            if(s.indexOf(c) == s.lastIndexOf(c)) return i;
        }

        return -1;
    }
}
