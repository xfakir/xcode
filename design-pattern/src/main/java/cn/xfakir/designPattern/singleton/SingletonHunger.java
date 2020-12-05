package cn.xfakir.designPattern.singleton;

public class SingletonHunger {
    private static final SingletonHunger singleton = new SingletonHunger();
    private SingletonHunger(){

    }
    public static SingletonHunger getInstance() {
        return singleton;
    }
}
