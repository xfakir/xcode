package concurrency.L1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockSolution {
    private int n;

    public ReentrantLockSolution(int n) {
        this.n = n;
    }

    Lock lock = new ReentrantLock(true);
    private final Condition condition = lock.newCondition();
    volatile boolean flag = true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!flag) {
                    condition.await();
                }

                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = false;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (flag) {
                    condition.await();
                }

                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = true;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
}
