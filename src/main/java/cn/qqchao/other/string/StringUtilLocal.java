package cn.qqchao.other.string;

public class StringUtilLocal {
    public static void main(String[] args) {
        System.out.println(LCS("1AB2345CD", "12345EF"));
    }

        /**
         * longest common substring
         * @param str1 string字符串 the string
         * @param str2 string字符串 the string
         * @return string字符串
         */
        public static String LCS (String str1, String str2) {
            // write code here
            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();

            int endIndex = 0;
            int commonLength = 1;

            int length1 = chars1.length;
            int length2 = chars2.length;
            int[][] lengthIndex = new int[length1][length2];
            for (int i = 0; i < length1; i++) {
                lengthIndex[i][0] = chars1[i] == chars2[0]?1:0;
            }
            for (int i = 1; i < length2; i++) {
                lengthIndex[0][i] = chars1[0] == chars2[i]?1:0;
            }
            for (int i = 1; i < length1; i++) {
                for (int j = 1; j < length2; j++) {
                    lengthIndex[i][j] = chars1[i] == chars2[j]? lengthIndex[i-1][j-1]+1:0;
                    if (lengthIndex[i][j] > commonLength) {
                        endIndex = i;
                        commonLength = lengthIndex[i][j];
                    }
                }
            }
            return str1.substring(endIndex+1-commonLength, endIndex+1);
        }
}
