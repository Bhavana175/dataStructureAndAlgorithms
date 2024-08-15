package com.workspace.learning.systemdesign.lowlevel.cache.lfu;

import com.workspace.learning.systemdesign.lowlevel.cache.Cache;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LFUCacheImpl<K, V> implements Cache<K, V> {

    int capacity;

    HashMap<K, DataElement<K, V>> cacheMap = new HashMap<>();

    PriorityQueue<DataElement<K, V>> queue = new PriorityQueue<>((o1, o2) -> {

        if (o1.freq == o2.freq) {
            return o1.time - o2.time;
        }
        return o1.freq - o2.freq;
    });

    public LFUCacheImpl(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void display() {

    }
}
