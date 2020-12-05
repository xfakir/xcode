package cn.xfakir.designPattern.proxy;

public class Proxy implements Subject{
    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }

        preRequest();
        realSubject.request();
        postRequest();
    }

    private void preRequest() {
        System.out.println("pre");
    }

    private void postRequest() {
        System.out.println("post");
    }
}
