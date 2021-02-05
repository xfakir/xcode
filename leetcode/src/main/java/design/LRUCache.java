package design;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache {
    private int capacity;

    private Map<Integer, Integer> map = new ConcurrentHashMap<>();
    private Deque<Integer> deque = new LinkedList<>();


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        int result = map.getOrDefault(key, -1);
        if (result != -1) {
            deque.remove(key);
            deque.addLast(key);
        }
        return result;
    }

    public void put(int key, int value) {
        if (map.get(key) != null) {
            deque.remove(key);
            deque.addLast(key);
            map.put(key,value);
            return;
        }
        if (map.size() >= capacity) {
            Integer out = deque.pollFirst();
            map.remove(out);
        }
        map.put(key, value);
        deque.addLast(key);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
    }
}
