package lld.cache.practice;

import lld.cache.practice.impl.LFUCache;
import lld.cache.practice.impl.LRUCache;

public class Main {
    public static void main(String[] args) {
        Cache<Integer, String> lru = new LRUCache<>();

        lru.put(1,"one");
        lru.put(2,"one");
        lru.put(3,"one");
        lru.put(4,"one");
        lru.put(5,"one");
        lru.display();
        lru.get(5);
        lru.put(1,"two");
        lru.put(6,"one");
        lru.display();
        System.out.println();

        Cache<Integer, String> lfu = new LFUCache<>();

        lfu.put(1,"one");
        lfu.put(2,"one");
        lfu.put(3,"one");
        lfu.put(4,"one");
        lfu.put(5,"one");
        lfu.get(5);
        lfu.get(5);
        lfu.display();
        lfu.put(6,"six");
        System.out.println();
        lfu.display();
        lfu.get(6);
        lfu.get(6);
        System.out.println();
        lfu.display();
        lfu.put(7,"7");
        lfu.put(8,"7");
        lfu.put(9,"7");
        lfu.put(10,"7");
        System.out.println();
        lfu.display();
    }
}
