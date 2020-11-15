package twoPointers;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 */
public class IsPalindrome {
    public boolean solution(String s) {
        if (s.length() == 0) return true;
        char[] chars = s.toCharArray();
        int begin = 0;
        int end = chars.length-1;

        while (begin < end) {
            if (!Character.isLetter(chars[begin]) && !Character.isDigit(chars[begin])) {
                begin++;
                continue;
            }
            if (!Character.isLetter(chars[end]) && !Character.isDigit(chars[end])) {
                end--;
                continue;
            }

            if (Character.toLowerCase(chars[begin]) == Character.toLowerCase(chars[end])) {
                begin++;
                end--;
            } else {
                System.out.println(chars[begin]);
                System.out.println(chars[end]);
                return false;
            }
        }
        System.out.println(chars[begin]);
        return Character.toLowerCase(chars[begin]) == Character.toLowerCase(chars[end]);
    }

    public static void main(String[] args) {
        IsPalindrome i = new IsPalindrome();
        System.out.println(i.solution("0P"));
        System.out.println(Character.toLowerCase('0') == Character.toLowerCase('P') );
    }
}
