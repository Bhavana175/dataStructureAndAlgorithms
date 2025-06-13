package lld.hasmap;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;


public class HashMapLLD<K, V> {

    private final int INITIAL_SIZE = 1 << 4;
    private final int MAX_CAPACITY = 1 << 30;
    private final float LOAD_FACTOR = 0.75f;

    private Node[] bucket;

    @Override
    public String toString() {
        return "HashMapLLD{" +
                "bucket=" + Arrays.toString(bucket) +
                '}';
    }

    public HashMapLLD() {
        this.bucket = new Node[INITIAL_SIZE];
    }

    @Getter
    @Setter
    class Node<K, V> {
        private K key;
        private V val;
        private Node next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public void put(K key, V val) {
        int hashcode = key.hashCode() % bucket.length;
        Node currNode = bucket[hashcode];
        Node prevNode = currNode;
        if (currNode == null) {
            currNode = new Node<>(key, val);
            bucket[hashcode] = currNode;
        } else {
            while (currNode != null) {

                if (currNode.key == key) {
                    currNode.val = val;
                    return;
                }
                prevNode = currNode;
                currNode = currNode.next;
            }
            prevNode.next = new Node(key, val);
        }

    }


    public V get(K key) {
        int hashcode = key.hashCode() % bucket.length;
        Node currNode = bucket[hashcode];

        while (currNode != null) {
            if (currNode.key == key) {
                return (V) currNode.val;
            }
            currNode = currNode.next;
        }
        return null;
    }

}

