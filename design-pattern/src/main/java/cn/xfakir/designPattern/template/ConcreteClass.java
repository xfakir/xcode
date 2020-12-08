package cn.xfakir.designPattern.template;

public class ConcreteClass extends AbstractClass{
    @Override
    protected void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用...");
    }

    @Override
    protected void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用...");
    }
}
