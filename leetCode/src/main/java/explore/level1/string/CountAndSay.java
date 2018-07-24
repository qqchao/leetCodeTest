package explore.level1.string;

/**
 * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n ，输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));
        System.out.println(countAndSay(8));
    }

    public static String countAndSay(int n) {
        if(n < 1) return null;
        StringBuilder result = new StringBuilder("1");
        StringBuilder pre;
        while(n > 1){
            pre = result;
            result = new StringBuilder("");
            int count = 1;
            char c = pre.charAt(0);
            String row = "";
            for(int i = 1; i < pre.length(); i++){
                if(pre.charAt(i) == c){
                    count++;
                }else {
                    result.append(count).append(c);
                    count = 1;
                    c = pre.charAt(i);
                }
            }
            result.append(count).append(c);
            n--;
        }
        return result.toString();
    }
}
