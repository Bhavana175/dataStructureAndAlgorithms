package mylearning.com.question.binaryTree;

import java.util.ArrayList;

public class LeafSimilarBinaryTrees {

/*    Consider all the leaves of a binary tree, from left to right order,
      the values of those leaves form a leaf value sequence.
      For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
      Two binary trees are considered leaf-similar if their leaf value sequence is the same.
      Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.*/

    public static void main(String[] args) {
        LeafSimilarBinaryTrees obj = new LeafSimilarBinaryTrees();
        TreeNode root1 = new TreeNode();
        TreeNode root2 = new TreeNode(3);

        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);

        TreeNode five2 = new TreeNode(5);
        TreeNode six2 = new TreeNode(6);
        TreeNode one2 = new TreeNode(1);
        TreeNode two2 = new TreeNode(2);
        TreeNode seven2 = new TreeNode(7);
        TreeNode four2 = new TreeNode(4);
        TreeNode eight2 = new TreeNode(8);
        TreeNode nine2 = new TreeNode(9);

        three.left = five;
        three.right = one;
        five.left = six;
        five.right = two;
        two.left = seven;
        two.right = four;
        one.left = nine;
        one.right = eight;

        root2.left = five2;
        root2.right = one2;
        five2.left = six2;
        five2.right = seven2;
        one2.left = four2;
        one2.right = two2;
        two2.left = nine2;
        two2.right = eight2;

        TreeNode One = new TreeNode(1);
        TreeNode TWO = new TreeNode(2);
        TreeNode TWOtwo = new TreeNode(2);

        One.right = TWO;
        TWOtwo.right = TWO;

        System.out.println(" leaf similar : " + obj.leafSimilar(three, root2));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();// leaf node array 1 and 2
        ArrayList<Integer> arr2 = new ArrayList<>();

        if (root1 != null) {
            //recursion concept to get to left leaf node value, getLeafNode
            getLeafNode(root1, arr1);
        }
        if (root2 != null) {
            getLeafNode(root2, arr2);
        }

        if (arr1.size() != arr2.size()) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2.get(i)) {
                return false;
            }
        }

       /*
       one more solution to compare arraylist
       return  arr1.equals(arr2);*/

        return true;
    }

    public void getLeafNode(TreeNode root, ArrayList<Integer> arr) {

        if (root != null) {
            if (root.left == null && root.right == null) {
                //both left and right should be null to be a leaf node
                arr.add(root.val);
            } else {
                // System.out.println(" leaf node " + root.val);
                getLeafNode(root.left, arr);
                getLeafNode(root.right, arr);
            }
        }
    }

}
