package string;

public class CompressString {
    public String compressString(String S) {
        if (S.equals("")) return S;
        char[] chars = S.toCharArray();
        int left = 0;
        int right = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (right < S.length()) {
            if (chars[left] != chars[right]) {
                stringBuilder.append(chars[left]);
                stringBuilder.append(right-left);
                left = right;
            } else if (chars[left] == chars[right]) {
                right++;
            }
        }
        stringBuilder.append(chars[left]);
        stringBuilder.append(right-left);
        return stringBuilder.length() < S.length()?stringBuilder.toString():S;
    }
}
