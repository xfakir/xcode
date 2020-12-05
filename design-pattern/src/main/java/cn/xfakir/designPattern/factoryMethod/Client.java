package cn.xfakir.designPattern.factoryMethod;

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
        Product makeProduct();
    }

    public class ConcreteFactory1 implements AbstractFactory {

        @Override
        public Product makeProduct() {
            System.out.println("具体工厂1 -> 具体产品1");
            return new ConcreteProduct1();
        }
    }
    public class ConcreteFactory2 implements AbstractFactory {

        @Override
        public Product makeProduct() {
            System.out.println("具体工厂2 -> 具体产品2");
            return new ConcreteProduct2();
        }
    }
}
