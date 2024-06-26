package com.workspace.learning.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;

public class InOrder {
    //https://leetcode.com/problems/binary-tree-inorder-traversal/
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.right = t2;
        t2.left = t3;
        List<Integer> list = inorderTraversal(t1);
        System.out.println(list);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }
    private static void inOrder(TreeNode node, List<Integer> list){
        if(node==null){
            return;
        }

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);

    }
}
