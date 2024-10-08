package com.workspace.learning.datastructure.binarytree;

public class BalancedBinaryTree {
    //https://leetcode.com/problems/balanced-binary-tree/description/

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(8);
        //[1, null, 2, 3, null, 4,5]

        t1.right = t2;
        t1.left = t6;
        t6.left = t7;
        t6.right = t8;
        t2.left = t3;
       // t2.right = t9;
        t3.left = t4;
        t3.right = t5;

        System.out.println(isBalanced(t1));

    }

    static boolean isBalanced = true;

    public static  boolean isBalanced(TreeNode root) {
        calcDepth(root);
        return isBalanced;
    }

    public  static int calcDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = calcDepth(root.left);
        int right = calcDepth(root.right);
        if(Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(left, right);
    }

}
