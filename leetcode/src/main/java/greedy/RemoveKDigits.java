package greedy;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 */
public class RemoveKDigits {
    public String removeKDigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        for (int i = 0; i < length; i++) {
            char ch = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > ch) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(ch);
        }
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char character = deque.pollFirst();
            if (leadingZero && character == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(character);
        }
        return sb.length() == 0?"0":sb.toString();
    }

    public String solution(String num, int k) {
        if (num.length() == k){
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
        while (k > 0){
            int i = 0;
            for (; i < sb.length()-1; i++){
                if (sb.charAt(i) > sb.charAt(i+1)){
                    break;
                }
            }
            sb.delete(i,i+1);
            while (sb.length() > 1 && sb.charAt(0) == '0') sb.delete(0, 1);
            k--;
        }
        return sb.toString();
    }

}
