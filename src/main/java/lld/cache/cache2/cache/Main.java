package lld.cache.cache2.cache;

public class Main {

    public static void main(String[] args) {

        Cache<Integer, String> myCache = new LRUCacheImpl<>();
        Cache<Integer, String> myCacheImpl2 = new LRUCacheImpl2<>();
        Cache<Integer, String> freqCacheImpl = new LFUCacheImpl<>();

        myCache.put(1, "A");
        myCache.put(2, "B");
        myCache.put(3, "C");
        myCache.put(4, "D");
        myCache.put(5, "E");
        myCache.display();
        myCache.put(5, "E");
        myCache.display();
        myCache.put(6, "f");
        myCache.display();
        myCache.get(1);
        myCache.display();
        myCache.get(3);
        myCache.display();
        myCache.get(3);
        myCache.display();
        myCache.put(90, "Z");
        myCache.display();
        System.out.println("************************");
        myCacheImpl2.put(1, "A");
        myCacheImpl2.put(2, "B");
        myCacheImpl2.put(3, "C");
        myCacheImpl2.put(4, "D");
        myCacheImpl2.put(5, "E");
        myCacheImpl2.display();
        myCacheImpl2.put(5, "E");
        myCacheImpl2.display();
        myCacheImpl2.put(6, "f");
        myCacheImpl2.display();
        myCacheImpl2.get(1);
        myCacheImpl2.display();
        myCacheImpl2.get(3);
        myCacheImpl2.display();
        myCacheImpl2.get(3);
        myCacheImpl2.display();
        myCacheImpl2.put(90, "Z");
        myCacheImpl2.display();

        System.out.println("************************");
        freqCacheImpl.put(1, "1");
        freqCacheImpl.put(2, "2");
        freqCacheImpl.put(3, "3");
        freqCacheImpl.put(4, "4");
        freqCacheImpl.put(5, "5");
        freqCacheImpl.display();
        freqCacheImpl.put(5, "5-5");
        freqCacheImpl.display();
        freqCacheImpl.put(6, "6");
        freqCacheImpl.display();
        freqCacheImpl.get(1);
        freqCacheImpl.display();
        freqCacheImpl.get(3);
        freqCacheImpl.display();
        freqCacheImpl.get(3);
        freqCacheImpl.display();
        freqCacheImpl.put(90, "90");
        freqCacheImpl.display();
        freqCacheImpl.put(90, "90");
        freqCacheImpl.get(90);
        freqCacheImpl.get(90);
        freqCacheImpl.get(90);
        freqCacheImpl.get(90);
        freqCacheImpl.display();
        freqCacheImpl.get(4);
        freqCacheImpl.get(4);
        freqCacheImpl.get(4);
        freqCacheImpl.get(4);
        freqCacheImpl.get(4);
        freqCacheImpl.display();
        freqCacheImpl.get(5);
        freqCacheImpl.get(5);
        freqCacheImpl.display();
        freqCacheImpl.put(77, "77");
        freqCacheImpl.display();
        freqCacheImpl.put(88, "88");
        freqCacheImpl.display();


    }

}
