package main.java.leetcode.compete5;

import java.util.HashMap;
import java.util.Stack;

/*题目描述
    20. 有效的括号
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    有效字符串需满足：
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        注意空字符串可被认为是有效字符串。
*/
/*示例1:
    输入: "()"
    输出: true
 */
/*示例2:
    输入: "()[]{}"
    输出: true
 */
/*示例3:
    输入: "(]"
    输出: false
 */
public class ValidParentheses {
    //10ms
    public boolean isValid(String s) {
        int len = s.length();
        Stack stack = new Stack();
        for (int i = 0; i < len; i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push("min");
                    break;
                case '[':
                    stack.push("medium");
                    break;
                case '{':
                    stack.push("max");
                    break;
                case ')':
                    if (!stack.empty() && stack.peek() == "min") {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (!stack.empty() && stack.peek() == "medium") {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (!stack.empty() && stack.peek() == "max") {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return  stack.empty();
    }

    /*
        算法
            初始化栈 S。
            一次处理表达式的每个括号。如果遇到开括号，我们只需将其推到栈上即可。这意味着我们将稍后处理它，让我们简单地转到前面的子表达式。
            如果我们遇到一个闭括号，那么我们检查栈顶的元素。如果栈顶的元素是一个 相同类型的 左括号，那么我们将它从栈中弹出并继续处理。
            否则，这意味着表达式无效。如果到最后我们剩下的栈中仍然有元素，那么这意味着表达式无效。
        复杂度分析
            时间复杂度：O(n)，因为我们一次只遍历给定的字符串中的一个字符并在栈上进行 O(1) 的推入和弹出操作。
            空间复杂度：O(n)，当我们将所有的开括号都推到栈上时以及在最糟糕的情况下，我们最终要把所有括号推到栈上。例如 ((((((((((。
    */
    //官方解答
    public boolean isValid1(String s) {
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        String s = "{[(([]()))][]}";
        System.out.println(v.isValid1(s));
    }
}
