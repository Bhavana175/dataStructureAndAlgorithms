package com.workspace.learning.systemdesign.lowlevel.cache.lru;

import com.workspace.learning.systemdesign.lowlevel.cache.Cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheImpl<K, V> implements Cache<K, V> {

    /*
    LRU cache eviction strategy
    [ Note : use Linked hashmap as it maintain insertion order(remove and add)
    the least used value be at the head ]
     */

    LinkedHashMap<K, V> linkedHashMap;

    int capacity;

    public LRUCacheImpl(int capacity) {
        this.linkedHashMap = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void put(K key, V value) {

        //new entry : first check the capacity, if full remove first and thn add new
        // key already present : remove and add again

        if (!linkedHashMap.containsKey(key)) {  //new entry
            if (linkedHashMap.size() == capacity) {
                Map.Entry<K, V> firstEntry = linkedHashMap.entrySet().stream()
                        .findFirst().get();
                linkedHashMap.remove(firstEntry.getKey());
            }
        } else {
            linkedHashMap.remove(key);
        }
        linkedHashMap.put(key, value);
    }

    @Override
    public V get(K key) {
        V value = null;
        if(linkedHashMap.containsKey(key)){
            value= linkedHashMap.get(key);
            linkedHashMap.remove(key);
            linkedHashMap.put(key,value);
        }
        return value;
    }

    @Override
    public void display() {
        linkedHashMap.forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.println();
    }
}
