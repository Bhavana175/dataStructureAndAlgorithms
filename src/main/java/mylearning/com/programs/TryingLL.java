package mylearning.com.programs;

import lombok.AllArgsConstructor;
import lombok.Data;

public class TryingLL {

    public static void main(String[] args) {

        MyLinkedList<Integer> ll = new MyLinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);

        System.out.println(ll);
        int index = 2;

        int n = ll.get(index);
        System.out.println(n);

    }
}

@Data
@AllArgsConstructor
class Node<E> {
    E data;
    Node next;
}

@Data
class MyLinkedList<E> {

    private Node head;

    public void add(E data) {
        Node<E> n = new Node<E>(data, null);
        if (head == null) {
            head = n;
        } else {
            Node<E> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
        }
    }

    public E get(int index) {

        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }
}
