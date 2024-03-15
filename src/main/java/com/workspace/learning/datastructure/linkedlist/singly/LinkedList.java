package com.workspace.learning.datastructure.linkedlist.singly;


public class LinkedList {

    private Node head;

    private int length;

    public LinkedList() {
        this.length = 0;
    }

    public synchronized Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    /**
     * Insert Node at the beginning
     */

    public synchronized void insertAtBegin(Node node) {
        // O(1)
        node.next = head;
        head = node;
        length++;
    }

    /**
     * Insert Node at the End
     * @param node
     */

    public synchronized void insertAtEnd(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node aux = head;
            while (aux.getNext() != null) {
                aux = aux.next;
            }
            aux.next = node;
        }
        length++;
    }

    /**
     * Insert value at given position in linked-list
     * @param data
     * @param position
     */
    public void insert(int data, int position) {
        Node dataNode = new Node(data);
        int counter = 1;
        Node aux = head;
        //fix position
        if (position < 0) {
            position = 0;
        }
        if (position > length) {
            position = length;
        }
        //only element
        if (head == null) {
            head = dataNode;
        } else {
            if (position == 0) {
                dataNode.next = head;
                head = dataNode;
            } else {
                while (counter != position) {
                    aux = aux.next;
                    counter++;
                }
                dataNode.next = aux.next;
                aux.next = dataNode;
            }
        }
        length++;
    }

    /**
     * Remove from beginning
     * @return deleted node
     */
    public synchronized Node removeFromBegin(){
        Node node = head;
        if(head!= null){
            head = node.next;
            node.next= null;
            length--;
        }
        return node;
    }

    /**
     * remove from end
     */
    public synchronized Node removeFromEnd(){
        Node node= head;
        Node prevNode= head;
        if(head!=null){

            while (node.next != null){
                prevNode= node;
                node=node.next;
            }
            prevNode.next=null;
            length--;
        }

        return node;
    }

    /**
     * remove matched node
     * @param node
     */
    public synchronized void removeMatchedNode(Node node){
        if(head==null){
            System.out.println("empty");
        }else {
            Node aux= head;
            Node prev= aux;
            // while (aux.equals(node)){
            while (aux.next!=null && aux.data!=node.data){
                prev =aux;
                aux = aux.next;
            }
            if (aux.next==null){
                System.out.println("not found");
            }else {
            prev.next = aux.next;
            aux.next=null;
            length--;}
        }
    }
    public synchronized void removeFromPosition(int position){
        //fix position
        if(position<0){
            position=0;
        }
        if(position>length){
            position=length;
        }

        if(head==null){
            System.out.println("empty");
        }else {

            Node aux = head;
            Node prev = aux;
            int counter=1;
            if(position==0){
                head= aux.next;
                aux.next=null;
            }else {
                while (aux.next != null && counter != position) {
                    prev = aux;
                    aux = aux.next;
                    counter++;
                }
            }
            prev.next=aux.next;
            aux.next=null;
            length--;
        }
    }

    public void clearList(){
        head=null;
        length=0;

    }

    public void display() {
        Node aux = head;
        System.out.println();
        while (aux != null) {
            System.out.print(" " + aux.data + " -->");
            aux = aux.next;
        }
        System.out.print(" " + null);
    }
}
