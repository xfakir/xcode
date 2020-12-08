package cn.xfakir.designPattern.iterator;

public interface Aggregate {
    void add(Object object);
    void remove(Object object);
    Iterator getIterator();
}
