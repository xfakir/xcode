package cn.xfakir.designPattern.singleton;

public class SingletonDoubleCheck {
    private static SingletonDoubleCheck singletonDoubleCheck = null;
    private SingletonDoubleCheck(){}
    public static SingletonDoubleCheck getInstance(){
        if (singletonDoubleCheck == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (singletonDoubleCheck == null) {
                    singletonDoubleCheck = new SingletonDoubleCheck();
                }
            }
        }
        return singletonDoubleCheck;
    }
}
