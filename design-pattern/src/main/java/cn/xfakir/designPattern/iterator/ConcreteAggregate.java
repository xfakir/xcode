package cn.xfakir.designPattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate implements Aggregate{
    private List<Object> list = new ArrayList<Object>();

    @Override
    public void add(Object object) {
        list.add(object);
    }

    @Override
    public void remove(Object object) {
        list.remove(object);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(list);
    }
}
