package mylearning.com.singlyLinkedList;

public class LinkedListOperation {

    Node head = createSinglyLinkedList();

    public static void main(String[] args) {
        LinkedListOperation linkedListOp = new LinkedListOperation();
        System.out.println("Start len:" + linkedListOp.getLength());
        linkedListOp.displayList();
        linkedListOp.addNodeAtBeginning(14);
        linkedListOp.displayList();
        System.out.println("Node added AtBeginning");
        linkedListOp.addNodeAtEnd(15);
        System.out.println("Node added AtEnd");
        linkedListOp.displayList();
        linkedListOp.addNodeInBetween(8, 16);
        System.out.println("Node added InBetween");
        linkedListOp.displayList();
        System.out.println(" len:" + linkedListOp.getLength());
        linkedListOp.deleteAtBeginning();
        System.out.println("Deleted AtBeginning");
        linkedListOp.displayList();
        System.out.println(" len:" + linkedListOp.getLength());
        linkedListOp.deleteAtEnd();
        System.out.println("Deleted AtEnd");
        linkedListOp.displayList();
        System.out.println(" len:" + linkedListOp.getLength());
        linkedListOp.deleteNodeInBetween(15);
        System.out.println("Deleted NodeInBetween");
        //todo(bhavana): print if it was successfully deleted.
        linkedListOp.displayList();
        System.out.println("len:" + linkedListOp.getLength());
        linkedListOp.deleteNodeInBetween(8);
        System.out.println("Deleted NodeInBetween");
        linkedListOp.displayList();
        System.out.println("len:" + linkedListOp.getLength());
        System.out.println("Add node after 4th position");
        linkedListOp.addNodeAfterPosition(4,30);
        linkedListOp.displayList();

    }

    public void addNodeAtBeginning(int num) {

        Node n0 = new Node(num, head);
        head = n0;
    }

    public void addNodeAtEnd(int num) {
        Node aux = head;

        if (head == null) {
            head = new Node(num);
        } else {

            while (aux.next != null) {
                aux = aux.next;
            }

            aux.next = new Node(num);
        }

    }

    public void addNodeInBetween(int afterVal, int num) {

        Node aux = head;
        if (head != null) {
            while (aux != null) {

                if (aux.val == afterVal) {
                    Node nx = new Node(num);
                    nx.next = aux.next;
                    aux.next = nx;
                    break;
                }
                aux = aux.next;
            }
        }

    }

    public void addNodeAfterPosition(int position, int num) {

        Node aux = head;
        int counter = 1;
        Node newNode = new Node(num);
        if (head != null) {
            while (aux != null) {
                if (counter == position) {
                    newNode.next = aux.next;
                    aux.next = newNode;
                    return;
                }
                counter++;
                aux = aux.next;
            }

            return;
        }
        head = newNode;
    }

    public void deleteAtBeginning() {
        if (head == null) {
            return;
        }

        Node aux = head;
        head = aux.next;
        aux.next = null;

    }

    public void deleteAtEnd() {

        Node aux = head;
        if (head != null) {
            //single node
            if (head.next == null) {
                head = null;
                return;
            }
            while (aux.next.next != null) {
                aux = aux.next;
            }
            aux.next = null;
        }
    }

    public void deleteNodeInBetween(int num) {

        Node aux = head;
        Node prev = head;

        if (head != null) {

            while (aux != null) {

                if (aux.val == num) {
                    // if we're deleting the first node
                    if (aux == head) {
                        head = aux.next;
                        aux.next = null;
                        System.out.println("Node deleted successfully " + aux.val);
                        break;
                    }
                    prev.next = aux.next;
                    aux.next = null;
                    System.out.println("Node deleted successfully " + aux.val);
                    break;
                }
                prev = aux;
                aux = aux.next;
            }

        }

    }

    public int getLength() {
        int length = 0;
        Node aux = head;
        if (head != null) {

            while (aux != null) {
                length++;
                aux = aux.next;
            }

        }

        return length;
    }

    public void displayList() {
        Node aux = head;
        if (head == null) {
            System.out.println("null");
            return;
        }
        while (aux != null) {
            System.out.print(aux.val + " -> ");
            aux = aux.next;
        }
        System.out.println("null");
    }

    private static Node createSinglyLinkedList() {

        Node n1 = new Node(2);
        Node n2 = new Node(5);
        Node n3 = new Node(8);
        Node n4 = new Node(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        return n1;


    }

}
