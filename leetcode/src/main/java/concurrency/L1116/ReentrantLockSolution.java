package concurrency.L1116;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ReentrantLockSolution {
    private int n;
    private boolean allowZero = true;
    private boolean allowOdd = false;
    private boolean allowEven = false;
    private final ReentrantLock locker = new ReentrantLock();
    private final Condition condition = locker.newCondition();

    public ReentrantLockSolution(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i ++) {
            locker.lock();
            try {
                while (!allowZero) {
                    condition.await();
                }
                printNumber.accept(0);
                allowZero = false;
                if (i % 2 == 0)
                    allowOdd = true;
                else allowEven = true;
                condition.signalAll();
            } finally {
                locker.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            locker.lock();
            try {
                while (!allowEven) {
                    condition.await();
                }
                printNumber.accept(i);
                allowEven = false;
                allowZero = true;
                condition.signalAll();
            } finally {
                locker.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            locker.lock();
            try {
                while (!allowOdd) {
                    condition.await();
                }
                printNumber.accept(i);
                allowOdd = false;
                allowZero = true;
                condition.signalAll();
            } finally {
                locker.unlock();
            }
        }
    }
}
