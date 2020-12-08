package cn.xfakir.designPattern.template;

abstract class AbstractClass {
    public void templateMethod() {
        specificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    public void specificMethod(){
        System.out.println("抽象类中的具体方法被调用...");
    }

    protected abstract void abstractMethod1();

    protected abstract void abstractMethod2();
}
