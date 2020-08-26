package cn.qqchao.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P5LongestPalindrome {

    public static void main(String[] args) {
//        System.out.println(longestPalindrome3("lphbehiapswjudnbcossedgioawodnwdruaaxhbkwrxyzaxygmnjgwysafuqbmtzwdkihbwkrjefrsgjbrycembzzlwhxneiijgzidhngbmxwkhphoctpilgooitqbpjxhwrekiqupmlcvawaiposqttsdgzcsjqrmlgyvkkipfigttahljdhtksrozehkzgshekeaxezrswvtinyouomqybqsrtegwwqhqivgnyehpzrhgzckpnnpvajqevbzeksvbezoqygjtdouecnhpjibmsgmcqcgxwzlzztdneahixxhwwuehfsiqghgeunpxgvavqbqrelnvhnnyqnjqfysfltclzeoaletjfzskzvcdwhlbmwbdkxnyqappjzwlowslwcbbmcxoiqkjaqqwvkybimebapkorhfdzntodhpbhgmsspgkbetmgkqlolsltpulgsmyapgjeswazvhxedqsypejwuzlvegtusjcsoenrcmypexkjxyduohlvkhwbrtzjnarusbouwamazzejhnetfqbidalfomecehfmzqkhndpkxinzkpxvhwargbwvaeqbzdhxzmmeeozxxtzpylohvdwoqocvutcelgdsnmubyeeeufdaoznxpvdiwnkjliqtgcmvhilndcdelpnilszzerdcuokyhcxjuedjielvngarsgxkemvhlzuprywlypxeezaxoqfges"));
//        System.out.println(longestPalindrome1("lphbehiapswjudnbcossedgioawodnwdruaaxhbkwrxyzaxygmnjgwysafuqbmtzwdkihbwkrjefrsgjbrycembzzlwhxneiijgzidhngbmxwkhphoctpilgooitqbpjxhwrekiqupmlcvawaiposqttsdgzcsjqrmlgyvkkipfigttahljdhtksrozehkzgshekeaxezrswvtinyouomqybqsrtegwwqhqivgnyehpzrhgzckpnnpvajqevbzeksvbezoqygjtdouecnhpjibmsgmcqcgxwzlzztdneahixxhwwuehfsiqghgeunpxgvavqbqrelnvhnnyqnjqfysfltclzeoaletjfzskzvcdwhlbmwbdkxnyqappjzwlowslwcbbmcxoiqkjaqqwvkybimebapkorhfdzntodhpbhgmsspgkbetmgkqlolsltpulgsmyapgjeswazvhxedqsypejwuzlvegtusjcsoenrcmypexkjxyduohlvkhwbrtzjnarusbouwamazzejhnetfqbidalfomecehfmzqkhndpkxinzkpxvhwargbwvaeqbzdhxzmmeeozxxtzpylohvdwoqocvutcelgdsnmubyeeeufdaoznxpvdiwnkjliqtgcmvhilndcdelpnilszzerdcuokyhcxjuedjielvngarsgxkemvhlzuprywlypxeezaxoqfges"));
//        System.out.println(longestPalindrome("dbbd"));
//        System.out.println(longestPalindrome("dbabd"));
//        System.out.println(longestPalindrome("dbbd1a"));
//        System.out.println(longestPalindrome("sqdbbd"));
//        System.out.println(longestPalindrome("db1bdaas"));
//        System.out.println(longestPalindrome("asddb1bd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome(""));
//        System.out.println(longestPalindrome3("a"));
//        System.out.println(longestPalindrome3("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }

    public static String longestPalindrome(String s) {

        int maxOddRadius = 0;
        int maxOddIndex = 0;
        int maxEvenRadius = -1;
        int maxEvenIndex = 0;

        boolean oddMax = false;
        boolean evenMax = false;

        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j + i < length && i - j > -2; j++) {
                //odd
                if (!oddMax && i>=j) {
                    oddMax = s.charAt(i + j) != s.charAt(i - j);
                    if (oddMax && j > maxOddRadius) {
                        maxOddRadius = j;
                        maxOddIndex = i;
                    }
                    if(!oddMax && (j + i + 1 == length || i == j) && j+1 > maxOddRadius){
                        maxOddRadius = j+1;
                        maxOddIndex = i;
                    }
                }

                //even
                if (!evenMax && i < length-1){
                    evenMax = s.charAt(i + j) != s.charAt(i - j + 1);
                    if (evenMax && j-1 > maxEvenRadius){
                        maxEvenRadius = j-1;
                        maxEvenIndex = i;
                    }
                    if(!evenMax && (j + i + 1 == length || i + 1 == j) && j+1 > maxEvenRadius){
                        maxEvenRadius = j;
                        maxEvenIndex = i;
                    }
                }
                if (oddMax && evenMax){
                    break;
                }
            }

            oddMax = false;
            evenMax = false;
        }

        if(maxOddRadius > maxEvenRadius){
            if (maxOddRadius == 0)
                return s;
            return s.substring(maxOddIndex-maxOddRadius+1, maxOddIndex+maxOddRadius);
        } else {
            return s.substring(maxEvenIndex-maxEvenRadius+1, maxEvenIndex+maxEvenRadius+1);
        }
    }



    public static String longestPalindrome4(String s) {
        int count = 1;

        for (int i = s.length(); i > 1; i--) {
            for (int j = 0; j < s.length() + 1 - i; j++) {
                System.out.println(count++);
                String s1 = s.substring(j, j + i);
                String s2 = new StringBuilder(s1).reverse().toString();
                if (s1.equals(s2)) return s1;
            }
        }

        return null;
    }


    public static String longestPalindrome1(String s) {
        Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
        String result = null;
        List<Integer> list;

        for (int i = 0; i < s.length(); i++){
            String s1 = s.substring(i, i + 1);
            String s2 = new StringBuilder(s1).reverse().toString();
            if (s1.equals(s2)) {
                result = s1;
                list = new ArrayList<Integer>();
                list.add(i);
                list.add(i+1);
                queue.offer(list);
            }
        }
        for (int i = 0; i < s.length()-1; i++){
            String s1 = s.substring(i, i + 2);
            String s2 = new StringBuilder(s1).reverse().toString();
            if (s1.equals(s2)) {
                result = s1;
                list = new ArrayList<Integer>();
                list.add(i);
                list.add(i+2);
                queue.offer(list);
            }
        }

        boolean queueNotEmpty = true;

        while (queueNotEmpty) {
            list = queue.poll();
            int index1 = list.get(0) - 1;
            int index2 = list.get(1) + 1;
            if(index1 < 0 || index2 > s.length()){

            } else {
                String s1 = s.substring(index1, index2);
                String s2 = new StringBuilder(s1).reverse().toString();
                if (s1.equals(s2)) {
                    result = s1;
                    list = new ArrayList<Integer>();
                    list.add(index1);
                    list.add(index2);
                    queue.offer(list);
                }
            }
            if (queue.isEmpty()) {
                queueNotEmpty = false;
            }
        }

        return result;
    }

    public static String longestPalindrome2(String s) {
        int length = s.length();
        int subLength = s.length();
        int k = 0;
        for (int i = subLength; i > 0 ; i--) {
            for (int j = 0; j + i < length + 1 ; j++) {
                String substring = s.substring(j, j + i);
                System.out.println(k++);
                if (isPalindrome(substring)) {
                    return substring;
                }
            }
        }
        return "";
    }

    /**
     * P125 判断回文
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        char[] ss = s.toLowerCase().toCharArray();
//        int count = 0;
//        for(int i = 0; i < ss.length; i++){
//            if(ss[i]>='a' && ss[i]<='z'){
//                ss[count] = ss[i];
//                count++;
//            }
//            if(ss[i]>='0' && ss[i]<='9'){
//                ss[count] = ss[i];
//                count++;
//            }
//        }
        int count = s.length();

        for (int i = 0; i < count/2; i++){
            if(ss[i] != ss[count-1-i]) return false;
        }

        return true;
    }

    public static String longestPalindrome3(String s) {

        int maxOddRadius = 0;
        int maxOddIndex = 0;
        int maxEvenRadius = -1;
        int maxEvenIndex = 0;

        boolean oddMax = false;
        boolean evenMax = false;

        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j + i < length && i - j > -2; j++) {
                //odd
                if (!oddMax && i>=j) {
                    oddMax = s.charAt(i + j) != s.charAt(i - j);
                    if (oddMax && j > maxOddRadius) {
                        maxOddRadius = j;
                        maxOddIndex = i;
                    }
                }

                //even
                if (!evenMax && i < length-1){
                    System.out.println("i="+i+"j="+j);
                    evenMax = s.charAt(i + j) != s.charAt(i - j + 1);
                    if (evenMax && j-1 > maxEvenRadius){
                        maxEvenRadius = j-1;
                        maxEvenIndex = i;
                    }
                }
                if (oddMax && evenMax){
                    break;
                }
            }

            oddMax = false;
            evenMax = false;
        }

        System.out.println(maxOddRadius);
        System.out.println(maxEvenRadius);
        System.out.println(maxOddIndex);
        System.out.println(maxEvenIndex);
//
//        System.out.println(s.substring(maxOddIndex-maxOddRadius+1, maxOddIndex+maxOddRadius));
//        System.out.println(s.substring(maxEvenIndex-maxEvenRadius+1, maxEvenIndex+maxEvenRadius+1));

        if(maxOddRadius > maxEvenRadius){
            if (maxOddRadius == 0)
                return s;
            return s.substring(maxOddIndex-maxOddRadius+1, maxOddIndex+maxOddRadius);
        } else {
            return s.substring(maxEvenIndex-maxEvenRadius+1, maxEvenIndex+maxEvenRadius+1);
        }
    }
}
