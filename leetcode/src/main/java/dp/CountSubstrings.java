package dp;

public class CountSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int result = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                    result++;
                } else if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    result++;
                } else if (j-i > 1 && s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]){
                    dp[i][j] = true;
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * aba 有5个中心点，分别是 a、b、c、ab、ba
     * abba 有7个中心点，分别是 a、b、b、a、ab、bb、ba
     * @param s
     * @return
     */
    public int countSubstrings_center(String s) {
        int n = s.length();
        int result = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                result++;
                left--;
                right++;
            }
        }
        return result;
    }
}
