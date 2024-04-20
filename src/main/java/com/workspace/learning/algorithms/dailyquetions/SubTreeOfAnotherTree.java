package com.workspace.learning.algorithms.dailyquetions;

import org.hibernate.result.Output;

public class SubTreeOfAnotherTree {
    //https://leetcode.com/problems/subtree-of-another-tree/description/

    //Input: root = [3,4,5,1,2], subRoot = [4,1,2]
    //Output: true

    public static void main(String[] args) {

        SubTreeOfAnotherTree obj = new SubTreeOfAnotherTree();

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(2);

        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(2);

        t1.leftNode = t2;
        t1.rightNode = t3;
        t2.leftNode = t4;
        t2.rightNode = t5;

        n1.leftNode = n2;
        n1.rightNode = n3;

        System.out.println( obj.isSubtree(t1, n1) );
        System.out.println(obj.isSubtree(t1, t2));

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }
        if(root.val==subRoot.val){
            if(isSubtreeRec(root,subRoot)){
                return true;
            }
        }
        return isSubtree(root.leftNode, subRoot) ||
                isSubtree(root.rightNode, subRoot);
    }

    private boolean isSubtreeRec(TreeNode root, TreeNode subRoot) {
        //base case
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }

        return isSubtreeRec(root.rightNode, subRoot.rightNode) &&
                isSubtreeRec(root.leftNode, subRoot.leftNode);

    }
}
