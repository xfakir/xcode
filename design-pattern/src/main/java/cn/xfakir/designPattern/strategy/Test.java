package cn.xfakir.designPattern.strategy;

public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        Strategy strategy = new ConcreteStrategy1();
        context.setStrategy(strategy);
        context.strategyMethod();
    }
}
