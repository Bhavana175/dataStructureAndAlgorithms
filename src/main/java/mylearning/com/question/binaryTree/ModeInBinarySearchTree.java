package mylearning.com.question.binaryTree;

import java.util.HashMap;


/*Given the root of a binary search tree (BST) with duplicates,
 return all the mode(s) (i.e., the most frequently occurred element) in it.
 If the tree has more than one mode, return them in any order.*/

public class ModeInBinarySearchTree {

    public static void main(String[] args) {
        System.out.println("input");
      /*  Scanner sc = new Scanner(System.in);
        sc.next();*/

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(1);
        TreeNode three = new TreeNode(2);
        TreeNode four = new TreeNode(2);
        TreeNode five = new TreeNode(4);
        TreeNode six = new TreeNode(2);
        TreeNode seven = new TreeNode(5);

        one.left = two;
        one.setRight(three);
        three.setLeft(four);
        three.setRight(five);
        five.setLeft(six);
        five.setRight(seven);
        six.setLeft(two);

        int[] arr = ModeInBinarySearchTree.findMode(one);
    }

    public static int[] findMode(TreeNode root) {

        HashMap<Integer, Integer> myMap = new HashMap<>();
        myMap.put(root.val, 1);
        if (root != null) {
            if (root.left != null) {
                System.out.println("root : " + root.val + " left : " + root.left.val);
                findMode(root.left);
                if(myMap.containsKey(root.left.val)){
                    myMap.put(root.left.val, myMap.get(root.left.val)+1);
                }else myMap.put(root.left.val,1);
            }
            if (root.right != null) {
                System.out.println("root : " + root.val + " right : " + root.right.val);
                findMode(root.right);
                if(myMap.containsKey(root.right.val)){
                    myMap.put(root.right.val, myMap.get(root.right.val)+1);
                }else myMap.put(root.right.val,1);
            }

        }
       // System.out.println("myNodeList :" + myNodeList);
        int[] mode = new int[]{1, 2};
        return mode;

    }

}
