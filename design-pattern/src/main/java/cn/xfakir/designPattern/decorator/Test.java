package cn.xfakir.designPattern.decorator;

public class Test {
    public static void main(String[] args) {
        Component p = new ConcreteComponent();
        p.operation();

        Component d = new ConcreteDecorator(p);
        d.operation();
    }
}
