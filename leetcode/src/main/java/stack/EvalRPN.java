package stack;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;


public class EvalRPN {
    public int solution(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens) {
            int b;
            int a;
            switch (s) {
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        EvalRPN e = new EvalRPN();
        e.solution(tokens);
    }
}
