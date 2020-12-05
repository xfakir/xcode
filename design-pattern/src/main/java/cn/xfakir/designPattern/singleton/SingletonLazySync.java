package cn.xfakir.designPattern.singleton;

public class SingletonLazySync {
    private static volatile SingletonLazySync singletonLazySync = null;
    private SingletonLazySync(){}
    public static synchronized SingletonLazySync getInstance(){
        if (singletonLazySync == null) {
            singletonLazySync = new SingletonLazySync();
        }
        return singletonLazySync;
    }

}
