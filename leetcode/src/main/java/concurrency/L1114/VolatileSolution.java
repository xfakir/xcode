package concurrency.L1114;

public class VolatileSolution {
    volatile int i = 1;
    public VolatileSolution() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        while(i != 1){
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        i = i+1;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(i != 2){

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        i = i+1;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(i!=3){}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
