package com.workspace.learning.interviews.paypalpractice.cache;

import lombok.Data;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class LFUCacheImpl<K, V> implements Cache<K, V> {

    // using minheap, hashmap and priority queue
    // custom class to store data like frequency , time , key , value

    private static final int CAPACITY = 5;

    int time;

    HashMap<K, DataElement<K, V>> cacheMap = new HashMap<>();

    //min heap
    Queue<DataElement<K, V>> priorityQueue = new PriorityQueue<>((o1, o2) -> {
        if (o1.freq == o2.freq) {
            return o1.time - o2.time;
        }
        return o1.freq - o2.freq;
    });

    @Override
    public V get(K key) {
        V value = null;
        if (cacheMap.containsKey(key)) {
            DataElement<K, V> data = cacheMap.get(key);
            value = data.value;
            data.freq++;
            data.time = ++time;
            priorityQueue.remove(data);
            priorityQueue.offer(data);
        }

        return value;
    }

    @Override
    public void put(K key, V value) {
        DataElement<K, V> data;
        if (cacheMap.containsKey(key)) {
            data = cacheMap.get(key);
            data.freq++;
            data.time = ++time;
            data.value = value;
            priorityQueue.remove(data);
        } else {
            if (cacheMap.size() == CAPACITY) {
                DataElement<K, V> LFUDataElement = priorityQueue.poll();
                K removeKey = LFUDataElement.getKey();
                cacheMap.remove(removeKey);
            }
            data = new DataElement<>(key, value);
            data.time = ++time;
        }
        cacheMap.put(key, data);
        priorityQueue.offer(data);
    }

    @Override
    public void display() {
        //cacheMap.entrySet().stream().forEach((e) -> System.out.print(e.getValue().value + " -> "));
        priorityQueue.iterator().forEachRemaining(kvDataElement -> System.out.print(kvDataElement.value+"("+kvDataElement.freq+")" + " -> "));
        System.out.println("null");
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
}
