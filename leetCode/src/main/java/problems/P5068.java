package problems;

import java.util.ArrayList;

public class P5068 {

    /**
     * by 李老板
     * @param args
     */
    public static void main(String[] args) {
        String[] results = beforeAndAfterPuzzles1(new String[]{"mission statement",
            "a quick bite to eat",
            "a chip off the old block",
            "chocolate bar",
            "mission impossible",
            "a man on a mission",
            "block party",
            "eat my words",
            "bar of soap"});
        for (String item : results) {
            System.out.println(item);
        }
    }

    public static String[] beforeAndAfterPuzzles(String[] phrases) {
        if (phrases == null || phrases.length <= 0) {
            return null;
        }

        int originLength = phrases.length;
        int pos = 0;
        String[] resultArray = new String[originLength * originLength];
        for (int index = 0; index < originLength; index++) {
            String string1 = phrases[index];
            String[] words1 = string1.split(" ");
            String lastWord = words1[words1.length - 1];
            for (int aIndex = 0; aIndex < originLength; aIndex++) {
                if (aIndex == index) {
                    continue;
                }
                String string2 = phrases[aIndex];
                String[] words2 = string2.split(" ");
                String firstWord = words2[0];

                if (lastWord != null && lastWord.equals(firstWord)) {
                    String resultItem = string1 + string2.substring(firstWord.length());
                    resultArray[pos] = resultItem;
                    pos++;
                }
            }
        }
        return  resultArray;
    }

    public static String[] beforeAndAfterPuzzles1(String[] phrases) {
        if (phrases == null || phrases.length <= 0) {
            return null;
        }

        ArrayList<String> results = new ArrayList<String>();
        int originLength = phrases.length;
        for (int index = 0; index < originLength; index++) {
            String string1 = phrases[index];
            String[] words1 = string1.split(" ");
            String lastWord = words1[words1.length - 1];
            for (int aIndex = 0; aIndex < originLength; aIndex++) {
                if (aIndex == index) {
                    continue;
                }
                String string2 = phrases[aIndex];
                String[] words2 = string2.split(" ");
                String firstWord = words2[0];

                if (lastWord != null && lastWord.equals(firstWord)) {
                    String resultItem = string1 + string2.substring(firstWord.length());
                    results.add(resultItem);
                }
            }
        }
        String[] resultArray = new String[results.size()];
        for (int index = 0; index < resultArray.length; index++) {
            resultArray[index] = results.get(index);
        }
        return resultArray;
    }
}
