package cn.xfakir.designPattern.singleton;

public class SingletonInnerClass {
    private static class SingletonHolder {
        private static final SingletonInnerClass singletonInnerClass = new SingletonInnerClass();
    }
    private SingletonInnerClass(){}
    public static SingletonInnerClass getInstance() {
        return SingletonHolder.singletonInnerClass;
    }
}
