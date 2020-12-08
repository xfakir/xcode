package cn.xfakir.designPattern.strategy;

public class ConcreteStrategy1 implements Strategy{
    @Override
    public void strategyMethod() {
        System.out.println("具体策略1的策略方法被访问！");
    }
}
