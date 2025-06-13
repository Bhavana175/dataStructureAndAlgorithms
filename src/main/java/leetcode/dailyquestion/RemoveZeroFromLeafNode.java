package leetcode.dailyquestion;

public class RemoveZeroFromLeafNode {


    public static void main(String[] args) {

        Node n1 = new Node(8);
        Node n2 = new Node(1);
        Node n3 = new Node(2);

        Node n4 = new Node(0);
        Node n5 = new Node(0);

        Node n6 = new Node(6);
        Node n7 = new Node(0);
        Node n8 = new Node(1);

        Node n9 = new Node(0);
        Node n10 = new Node(0);

/*                    8
            1.              2
        0       0       6       0
      0.  0                         1.  */



        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n4.left = n9;
        n4.right = n10;

        n3.left = n6;
        n3.right = n7;

        n7.right = n8;

        System.out.println(removeZeroFromLeaf(n1));
    }


    public static Node removeZeroFromLeaf(Node root){

        Node currNode = root;
        traverseTree( currNode);
        return root;
    }

    private static Node traverseTree(Node currNode) {

        if(currNode == null){
            return null;
        }
        if(currNode.left != null )
            currNode.left = traverseTree(currNode.left);
        if(currNode.right != null )
            currNode.right = traverseTree(currNode.right);

        if(currNode.val == 0 && currNode.left == null && currNode.right == null){
            currNode = null;
        }

        return currNode;
    }


    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }



}
