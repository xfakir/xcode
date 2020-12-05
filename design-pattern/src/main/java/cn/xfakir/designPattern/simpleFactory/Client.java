package cn.xfakir.designPattern.simpleFactory;

public class Client {
    public static void main(String[] args) {

    }

    public interface Product {
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

    public class SimpleFactory {
        public Product makeProduct(int num) {
            return num == 1?new ConcreteProduct1():new ConcreteProduct2();
        }
    }
}
