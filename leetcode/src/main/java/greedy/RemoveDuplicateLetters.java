package greedy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        boolean[] exist = new boolean[26];
        int[] remain = new int[26];
        for (int i = 0; i < s.length(); i++) {
            remain[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!exist[ch-'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length()-1) > ch) {
                    if (remain[sb.charAt(sb.length()-1)-'a'] > 0) {
                        exist[sb.charAt(sb.length()-1)-'a'] = false;
                        sb.deleteCharAt(sb.length()-1);
                    } else {
                        break;
                    }
                }
                exist[ch-'a'] = true;
                sb.append(ch);
            }
            remain[ch-'a'] --;
        }
        return sb.toString();
    }
}
