package cn.xfakir.designPattern.strategy;

public class ConcreteStrategy2 implements Strategy{

    @Override
    public void strategyMethod() {
        System.out.println("具体策略2的策略方法被访问！");
    }
}
