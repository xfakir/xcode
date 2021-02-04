package string;

import java.util.Stack;

public class Calculate {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length) {
            char temp = chars[i];
            System.out.println(temp);
            if (temp == ' ') {
                i++;
                continue;
            }
            if (temp == '+' || temp == '-' || temp == '*' || temp == '/') {
                i++;
                while(i < chars.length && chars[i] == ' ') i++;
            }
            int num = 0;
            while (i < chars.length && Character.isDigit(chars[i])) {
                num = num*10 + chars[i]-'0';
                i++;
            }

            switch (temp) {
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = stack.pop() * num;
                    break;
                case '/':
                    num = stack.pop() / num;
                    break;
                default:
                    break;
            }
            System.out.println(stack.toString());
            System.out.println(num);
            stack.push(num);
        }
        while (!stack.empty()) result += stack.pop();


        return result;
    }

    private Stack<Character> transfer(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();
        char tempChar = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                continue;
            } else if (getPriority(chars[i]) == 0) {
                stack.push(chars[i]);
                if (getPriority(tempChar) == 2) {
                    stack.push(tempChar);
                    tempChar = 0;
                }
            } else if (getPriority(chars[i]) == 1) {
                if (!temp.empty()) {
                    stack.push(temp.pop());
                }
                temp.push(chars[i]);
            } else {
                tempChar = chars[i];
            }
            if (i == chars.length - 1 && !temp.empty()) {
                stack.push(temp.pop());
            }
        }
        return stack;
    }

    private int getPriority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:  return 0;
        }
    }

    public static void main(String[] args) {
        Calculate c = new Calculate();
        System.out.println(c.calculate("3-2"));
    }
}
