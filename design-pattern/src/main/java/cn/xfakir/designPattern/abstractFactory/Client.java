package cn.xfakir.designPattern.abstractFactory;

public class Client {
    public static void main(String[] args) {

    }

    interface Product {
        void show();
    }

    public class ConcreteProduct1 implements Product {

        @Override
        public void show() {
            System.out.println("product 1");
        }
    }

    public class ConcreteProduct2 implements Product {

        @Override
        public void show() {
            System.out.println("product 2");
        }
    }

    interface AbstractFactory {
        ConcreteProduct1 makeProduct1();
        ConcreteProduct2 makeProduct2();
    }

    public class ConcreteFactory implements AbstractFactory{

        @Override
        public ConcreteProduct1 makeProduct1() {
            System.out.println("具体工厂 1 生成-->具体产品 11...");
            return new ConcreteProduct1();
        }

        @Override
        public ConcreteProduct2 makeProduct2() {
            System.out.println("具体工厂 1 生成-->具体产品 21...");
            return new ConcreteProduct2();
        }
    }
}
