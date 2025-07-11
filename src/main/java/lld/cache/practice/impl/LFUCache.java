package lld.cache.practice.impl;

import lld.cache.practice.Cache;
import lombok.Data;

import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

public class LFUCache<K, V> implements Cache<K, V> {

    private static final int capacity = 5;
    private PriorityQueue<DataElement<K, V>> priorityQueue = new PriorityQueue<>(
            (o1, o2) -> {
                if (o1.freq == o2.freq) {
                    return o1.time - o2.time;
                } else return o1.freq - o2.freq;
            });
    private HashMap<K, DataElement<K, V>> lfuCacheMap = new HashMap<>();
    int time;

    @Override
    public V get(K key) {
        V value = null;
        if (lfuCacheMap.containsKey(key)) {
            DataElement<K, V> data = lfuCacheMap.get(key);
            data.freq++;
            data.time = ++time;
            value = data.value;
            //re-arrange
            priorityQueue.remove(data);
            priorityQueue.offer(data);
        }
        return value;
    }

    @Override
    public void put(K key, V value) {
        DataElement<K, V> data = null;
        if (lfuCacheMap.containsKey(key)) {
            data = lfuCacheMap.get(key);
            data.freq++;
            data.time = ++time;
            data.value = value;
            priorityQueue.remove(data);
        } else {
            if (lfuCacheMap.size() == capacity) {
                DataElement<K, V> dataElement = priorityQueue.poll();
                lfuCacheMap.remove(dataElement.getKey());
            }
            data = new DataElement<>(key, value);
            data.time = ++time;
        }
        priorityQueue.offer(data);
        lfuCacheMap.put(key, data);
    }

    @Override
    public void display() {
        PriorityQueue<DataElement<K,V>> displayQueue = new PriorityQueue<>(priorityQueue);
        while (!displayQueue.isEmpty()){
            System.out.println(displayQueue.poll());
        }
    }
}

@Data
class DataElement<K, V> {
    K key;
    V value;
    int freq;
    int time;

    public DataElement(K key, V value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
        this.time = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DataElement<?, ?> that = (DataElement<?, ?>) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }
}