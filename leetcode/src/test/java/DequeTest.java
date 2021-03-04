import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        System.out.println(deque);
        System.out.println(deque.peekLast());
        System.out.println(deque.poll());
        System.out.println(deque);
    }
}
