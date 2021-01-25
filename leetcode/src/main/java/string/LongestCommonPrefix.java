package string;

public class LongestCommonPrefix {
    public String solution(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1 )return strs[0];
        String result = strs[0];
        int length = 0;
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < result.length() && j < strs[i].length()) {
                if (result.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                length++;
                j++;
            }
            result = result.substring(0,length);
            length = 0;
        }
        return result;
    }
}
