package lld.cache.practice.impl;

import lld.cache.practice.Cache;

import java.util.LinkedHashMap;

public class LRUCache<K,V> implements Cache<K,V> {

    private static final int capacity =5;
    private LinkedHashMap<K, V> lruCacheMap = new LinkedHashMap<>();


    @Override
    public V get(K key) {
        V value = null;
        if(lruCacheMap.containsKey(key)){
            value = lruCacheMap.get(key);
            //re-arrange,
            lruCacheMap.remove(key);
            lruCacheMap.put(key,value);
        }
        return value;
    }

    @Override
    public void put(K key, V value) {
        if(lruCacheMap.containsKey(key)){
           lruCacheMap.remove(key);
        }else {
            if(lruCacheMap.size()==capacity){
               K removeKey =  lruCacheMap.keySet().stream().findFirst().get();
               lruCacheMap.remove(removeKey);
            }
        }
        lruCacheMap.put(key,value);
    }

    @Override
    public void display() {
        System.out.println();
        lruCacheMap.forEach((k,v)-> System.out.print(" ---> "+k+","+v+" ") );
    }
}
