package com.workspace.learning.interviews.paypalpractice.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheImpl2<K, V> implements Cache<K, V> {

    // using LinkedHash Map
    private static final int CAPACITY = 5;

    LinkedHashMap<K, V> cacheMap = new LinkedHashMap<>();

    @Override
    public V get(K key) {
        V value = null;
        if (cacheMap.containsKey(key)) {
            value = cacheMap.get(key);
            //re arrange
            cacheMap.remove(key);
            cacheMap.put(key, value);
        }
        return value;
    }

    @Override
    public void put(K key, V value) {
        if (cacheMap.containsKey(key)) {
            cacheMap.remove(key);
            cacheMap.put(key, value);
        } else {

            if (cacheMap.size() == CAPACITY) {
                // in linked hashmap LRU data found first, removed first element
                Map.Entry<K, V> entry = cacheMap.entrySet().stream().findFirst().get();
                K removeKey = entry.getKey();
                cacheMap.remove(removeKey);
            }

            cacheMap.put(key, value);

        }

    }

    @Override
    public void display() {

        System.out.print(" null ");
        cacheMap.entrySet().stream().forEach((e)-> System.out.print(" <- "+e.getValue()));
        System.out.println();
    }

}
