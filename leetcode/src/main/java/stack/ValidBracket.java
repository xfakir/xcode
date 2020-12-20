package stack;

import java.util.Stack;

public class ValidBracket {
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        char temp;
        for(char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.empty()) {
                if (c == ')') {
                    temp = stack.pop();
                    if (temp != '(') {
                        return false;
                    }
                }
                if (c == ']') {
                    temp = stack.pop();
                    if (temp != '[') {
                        return false;
                    }
                }
                if (c == '}') {
                    temp = stack.pop();
                    if (temp != '{') {
                        return false;
                    }
                }
            } else {
                return false;
            }

        }
        return stack.empty();

    }
}
