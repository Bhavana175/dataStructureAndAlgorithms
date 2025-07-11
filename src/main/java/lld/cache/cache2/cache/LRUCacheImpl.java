package lld.cache.cache2.cache;

import lombok.Data;

import java.util.HashMap;

public class LRUCacheImpl<K, V> implements Cache<K, V> {
  /*  Requirements
      get()
      put()
      display()
      eviction based on least recently used
    */

    //Data structure to be used here
    // HashMap and Doubly Linked List

    private static final int CAPACITY = 5;

    private HashMap<K, Node<K, V>> cacheMap = new HashMap<>();

    private Node<K, V> head, tail;

    @Override
    public V get(K key) {
        V value = null;
        if (cacheMap.containsKey(key)) {
            Node<K, V> node = cacheMap.get(key);
            value = node.getValue();

            //remove node from current position and move to head
            updateNodePosition(node);
        }
        return value;
    }

    @Override
    public void put(K key, V value) {
        Node<K, V> node;
        if (cacheMap.containsKey(key)) {
            node = cacheMap.get(key);
            node.setValue(value);
            //remove node from current position and move node to head
            updateNodePosition(node);
        } else {

            //evict Least recently used if cache .size == capacity;
            evictLRUDataFromList();
            node = new Node<K, V>(key, value);
            cacheMap.put(key, node);
            //add node to head
            addNodeToHead(node);
        }
    }

    @Override
    public void display() {
        Node<K, V> aux = head;
        while (aux != null) {
            System.out.print(aux.getValue() + " -> ");
            aux = aux.next;
        }
        System.out.println("null");
    }

    private void updateNodePosition(Node<K, V> node) {
        //1,2,3,4,5   v=4, head = 1, tail= 5 --> 4 1 2 3 5

        if (node != head) {

            node.prev.next = node.next;
            if (node == tail) {
                tail = tail.prev;
                tail.next = null;
                node.prev = null;
            } else {
                node.next.prev = node.prev;
                node.next = null;
                node.prev = null;
            }
            //node removed now add to head
            addNodeToHead(node);
        }

    }

    private void addNodeToHead(Node<K, V> node) {

        if (head == null) {
            head = node;
            tail = head;
        } else {

            node.next = head;
            head.prev = node;
            head = node;

        }

    }

    private void evictLRUDataFromList() {

        if (cacheMap.size() == CAPACITY) {
            K removeKey = tail.getKey();
            tail = tail.prev;
            tail.next = null;
            cacheMap.remove(removeKey);
        }
    }
}

@Data
class Node<K, V> {

    Node<K, V> next;

    Node<K, V> prev;

    private K key;

    private V value;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
