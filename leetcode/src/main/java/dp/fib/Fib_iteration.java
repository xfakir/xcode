package dp.fib;

/**
 *  O(2^n)
 */
public class Fib_iteration {
    public int fib(int n) {
        if (n == 1 || n == 2) return 1;
        return fib(n-1) + fib(n-2);
    }
}
