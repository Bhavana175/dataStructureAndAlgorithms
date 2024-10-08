package com.workspace.learning.systemdesign.lowlevel.cache;

public interface Cache<K,V> {

    void put(K key, V value);
    V get(K key);

    void display();

}
