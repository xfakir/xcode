package design;

import java.util.Deque;
import java.util.LinkedList;

public class CQueue {
    Deque<Integer> deque1;
    Deque<Integer> deque2;

    public CQueue() {
        deque1 = new LinkedList<>();
        deque2  = new LinkedList<>();
    }

    public void appendTail(int value) {
        deque1.push(value);
    }

    public int deleteHead() {
        if (deque2.isEmpty()) {
            while (!deque1.isEmpty()) {
                deque2.push(deque1.pop());
            }
        }
        return deque2.isEmpty()?-1:deque2.pop();
    }
}
