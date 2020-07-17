package cn.qqchao.leetcode;

public class P5067CountLetters {
    public static void main(String[] args) {
        System.out.println(countLetters("aaaaaaaaaa"));
    }

    public static int countLetters(String s) {

        if(s == null || s.length() == 0){
            return  0;
        }

        char[] chars = s.toCharArray();

        int result = 0;
        char a = chars[0];
        int count = 1;

        for (int i = 1; i < chars.length; i++){
            if (chars[i] == a){
                count++;
            } else {
                result = result + sum(count);
                a = chars[i];
                count = 1;
            }
        }

        result = result + sum(count);

        return result;
    }

    private static int sum(int count) {
        return count*(count+1)/2;
    }
}
