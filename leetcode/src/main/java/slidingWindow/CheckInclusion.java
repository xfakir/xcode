package slidingWindow;

import java.util.Arrays;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 * <p>
 * 注意：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
public class CheckInclusion {
    public boolean solution(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int length = s1.length();
        char[] chars1 = s1.toCharArray();
        int[] occurrence = new int[26];
        for (int i = 0; i < length; i++) {
            occurrence[chars1[i] - 'a']++;
        }
        char[] chars = s2.toCharArray();
        int start = 0, end = 0;
        int[] temp = new int[26];
        while (end - start < length) {
            temp[chars[end] - 'a']++;
            end++;
        }
        end--;
        while (end < chars.length) {
            if (Arrays.equals(occurrence, temp)) {
                return true;
            } else {
                temp[chars[start] - 'a']--;
                start++;
                end++;
                if (end < chars.length)
                    temp[chars[end] - 'a']++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion c = new CheckInclusion();
        System.out.println(c.solution("ab", "eiboaoo"));
    }

}
