package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 */
public class GenerateParenthesis {

    public List<String> solution(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        backtrack("", 0, 0, n, res);
        return res;
    }

    private void backtrack(String curStr, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }

        // 剪枝
        if (left < right) {
            return;
        }

        if (left < n) {
            backtrack(curStr + "(", left + 1, right, n, res);
        }
        if (right < n) {
            backtrack(curStr + ")", left, right + 1, n, res);
        }
    }
}
