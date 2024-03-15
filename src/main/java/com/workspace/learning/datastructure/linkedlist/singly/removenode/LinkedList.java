package com.workspace.learning.datastructure.linkedlist.singly.removenode;

import com.workspace.learning.datastructure.linkedlist.singly.Node;

public class LinkedList {

    Node head;
    int length;
    public LinkedList() {
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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
            while (aux.data!=node.data){
                prev =aux;
                aux = aux.next;
            }
            prev.next = aux.next;
            aux.next=null;
        }

        


    }


}
