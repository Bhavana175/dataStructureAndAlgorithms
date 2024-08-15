package com.workspace.learning.systemdesign.lowlevel.cache.lfu;

public class DataElement <K,V>{

    K key;
    V value;
    int freq;
    int time;

    public DataElement(K key, V value) {
        this.key = key;
        this.value = value;
        this.freq=1;
        this.time =0;
    }
}
