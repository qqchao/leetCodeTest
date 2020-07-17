package explore.level1.others;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class IsValid {
    public static void main(String[] args) {
        System.out.println(isValid("{[([])]}"));
        System.out.println(isValid(""));
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        if(s == null) return false;

        char[] cs = s.toCharArray();
        Stack<Character> cst = new Stack<Character>();

        for (char c : cs){
            if(c == '(' || c == '[' || c == '{') cst.push(c);
            else if(cst.empty()) return false;
            if(c == ')' && cst.pop() != '(') return false;
            if(c == ']' && cst.pop() != '[') return false;
            if(c == '}' && cst.pop() != '{') return false;
        }
        return cst.empty();
    }
}
