package concurrency.L1114;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockSolution {
    private ReentrantLock fooLock = new ReentrantLock();

    private volatile int flag = 1;

    public ReentrantLockSolution() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        while(true){
            fooLock.lock(); // 首先判断是否获得可运行的锁
            // 获得锁进行判断是否可以运行
            if(flag == 1){
                // 可以运行
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();

                flag = 2; // 修改可运行状态
                fooLock.unlock(); // 运行结束释放锁
                break; // 结束循环

            }else{
                // 不可以运行
                fooLock.unlock();
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {

        while(true){
            fooLock.lock(); // 首先判断是否获得可运行的锁
            // 获得锁进行判断是否可以运行
            if(flag == 2){
                // 可以运行
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();

                flag = 3; // 修改可运行状态
                fooLock.unlock(); // 运行结束释放锁
                break; // 结束循环

            }else{
                // 不可以运行
                fooLock.unlock();
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(true){
            fooLock.lock(); // 首先判断是否获得可运行的锁
            // 获得锁进行判断是否可以运行
            if(flag == 3){
                // 可以运行
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();

                flag = 1; // 修改可运行状态
                fooLock.unlock(); // 运行结束释放锁
                break; // 结束循环

            }else{
                // 不可以运行
                fooLock.unlock();
            }
        }
    }
}
