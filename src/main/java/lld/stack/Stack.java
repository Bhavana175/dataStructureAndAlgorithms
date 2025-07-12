package lld.stack;

import java.util.LinkedList;
import java.util.List;

public class Stack<V> {

    private int top = -1;
    private List<V> linkedList;

    public Stack() {
        this.top = -1;
        this.linkedList = new LinkedList<>();
    }

    public void push(V value) {
        try {
            linkedList.add(value);
            top++;
        } catch (Exception e) {
            throw new RuntimeException("Stack over flow");
        }

    }

    public V pop() {
        if (top >= 0) {
            V value = linkedList.remove(top);
            top--;
            return value;
        } else throw new RuntimeException("Stack under flow");
    }

    public boolean isEmpty() {
        //return top <= -1;
        return linkedList.isEmpty();
    }

    public void display() {
        System.out.println();
        System.out.print("bottom :");
        linkedList.forEach((v) -> System.out.print(v + " "));
        System.out.print("top ");
    }
}
