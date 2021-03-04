package concurrency.L1114;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicSolution {
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public AtomicSolution() {

    }

    public void first(Runnable printFirst) throws Exception {
        printFirst.run();
        atomicInteger.incrementAndGet();
    }

    public void second(Runnable printSecond) throws Exception {
        while (atomicInteger.get() != 1) {

        }
        printSecond.run();
        atomicInteger.incrementAndGet();
    }

    public void third(Runnable printThird) throws Exception {
        while (atomicInteger.get() != 2) {

        }
        printThird.run();
    }
}
