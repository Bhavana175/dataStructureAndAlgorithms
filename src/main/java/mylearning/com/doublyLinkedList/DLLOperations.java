package mylearning.com.doublyLinkedList;

public class DLLOperations {

    DLLNode prev = null;

    DLLNode head = createDoublyLinkedList();

    int length = 0;

    public static DLLNode createDoublyLinkedList() {

        DLLNode n1 = new DLLNode(1);
        DLLNode n2 = new DLLNode(2);
        DLLNode n3 = new DLLNode(3);
        DLLNode n4 = new DLLNode(4);

        n1.next = n2;
        n2.next = n3;
        n2.prev = n1;
        n3.next = n4;
        n3.prev = n2;
        n4.prev = n3;

        return n1;
    }

    public static void main(String[] args) {

        DLLOperations obj = new DLLOperations();
        obj.displayDLL();
        obj.insertAtStart(24);
        obj.displayDLL();
        obj.insertAtEnd(25);
        obj.displayDLL();
        obj.insertAtPosition(5, 26);
        obj.displayDLL();
        obj.insertAtPosition(8, 27);
        obj.displayDLL();
        obj.insertAtPosition(10, 26);
        obj.displayDLL();
    }

    private void insertAtPosition(int position, int num) {
        DLLNode aux = head;
        DLLNode prevNode = null;
        int counter = 1;
        DLLNode dllNode = new DLLNode(num);
        if (head != null) {

            if (position > length) {
                System.out.println(position + " : PositionNot found");
                return;
            }
            while (aux != null && counter != position) {
                prevNode = aux;
                aux = aux.next;
                counter++;
            }
            if (aux != null) {
                dllNode.next = aux;
                dllNode.prev = aux.prev;
                aux.prev.next = dllNode;
                aux.prev = dllNode;
                return;
            }
            prevNode.next = dllNode;
            dllNode.prev = prevNode;

            return;
        }
        System.out.println(position + " : PositionNot found");

    }

    private void insertAtEnd(int num) {
//head= new DLLNode(55);
        DLLNode aux = head;
        DLLNode newNode = new DLLNode(num);
        if (head == null) {
            head = newNode;
            return;
        }
        while (aux.next != null) {
            aux = aux.next;
        }
        aux.next = newNode;
        newNode.prev = aux;
    }

    private void insertAtStart(int num) {

        DLLNode aux = head;
        DLLNode newNode = new DLLNode(num);
        if (head != null) {
            aux.prev = newNode;
            newNode.next = aux;
            head = newNode;
            return;
        }
        head = newNode;
    }

    public void displayDLL() {
        length = 0;
        DLLNode aux = head;

        if (aux != null) {
            System.out.print("Null<----");
            while (aux != null) {
                System.out.print(aux.val + "<---->");
                aux = aux.next;
                length++;
            }
        }
        System.out.print("Null \n");
    }

}
