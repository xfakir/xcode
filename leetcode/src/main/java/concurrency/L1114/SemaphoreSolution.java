package concurrency.L1114;

import java.util.concurrent.Semaphore;

public class SemaphoreSolution {
    Semaphore semaphore12;
    Semaphore semaphore23;

    public SemaphoreSolution() {
        semaphore12 = new Semaphore(0);
        semaphore23 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore12.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        semaphore12.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphore23.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        semaphore23.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
