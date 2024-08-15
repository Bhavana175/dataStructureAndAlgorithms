package com.workspace.learning.systemdesign.lowlevel.cache;

import com.workspace.learning.systemdesign.lowlevel.cache.Cache;
import com.workspace.learning.systemdesign.lowlevel.cache.lru.LRUCacheImpl;

public class Main {

    public static void main(String[] args) {

        Cache<Integer, String> cache = new LRUCacheImpl<>(3);
        cache.display();

        cache.put(1,"Ram");
        cache.display();

        cache.put(2,"Shyam");
        cache.put(3,"Sita");
        cache.display();

        cache.put(4,"Gita");
        cache.display();

        cache.put(1,"Ram");
        cache.display();
    }

}
