package cn.qqchao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 *
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 */
public class P1002commonChars {
    public List<String> commonChars(String[] A) {
        List<Character> commonChars = new ArrayList();
        String s = A[0];
        for (int i = 0; i < s.length(); i++) {
            commonChars.add(s.charAt(i));
        }

        return commonChars(A, commonChars, 1);
    }

    public List<String> commonChars(String[] A, List<Character> commonChars, int index) {
        if (index >= A.length) {
            List<String> result = new ArrayList();
            for (int i = 0; i < commonChars.size(); i++) {
                result.add(String.valueOf(commonChars.get(i)));
            }
            return result;
        }
        String s = A[index];
        List<Character> newCommonChars = new ArrayList();
        List<Character> currentChars = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            currentChars.add(s.charAt(i));
        }
        for (int i = 0; i < commonChars.size(); i++) {
            Character character = commonChars.get(i);
            for (int j = 0; j < currentChars.size(); j++) {
                if (character == currentChars.get(j)){
                    newCommonChars.add(character);
                    currentChars.remove(j);
                    break;
                }
            }
        }
        return commonChars(A, newCommonChars, index+1);
    }
}
