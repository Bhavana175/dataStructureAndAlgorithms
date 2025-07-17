package leetcode.dailyquestion.booking_practice;

import java.util.LinkedHashMap;

public class LruCache_146 {
    private int capacity;
    private LinkedHashMap<Integer, Integer> cacheMap ;

    public LruCache_146(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new LinkedHashMap<>();
    }

    public int get(int key) {
        int val =0;
        if(cacheMap.containsKey(key)){
            val = cacheMap.get(key);
            cacheMap.remove(key);
            cacheMap.put(key,val);
        }
        return val;
    }

    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            cacheMap.remove(key);
        }else {
            if(cacheMap.size() == capacity){
                int keyToRemove = cacheMap.keySet().stream().findFirst().get();
                cacheMap.remove(keyToRemove);
            }
        }
        cacheMap.put(key,value);
    }

}
