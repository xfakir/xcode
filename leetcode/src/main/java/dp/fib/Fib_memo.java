package dp.fib;

/**
 * O(n) 自顶向下
 */
public class Fib_memo {
    public int fib(int n) {
        int[] memo = new int[n+1];
        return fib(n,memo);
    }

    private int fib(int n, int[] memo) {
        if (n == 1 || n == 2) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = fib(n-1,memo) + fib(n-2,memo);
        return memo[n];
    }
}
