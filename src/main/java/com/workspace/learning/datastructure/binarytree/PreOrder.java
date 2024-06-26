package com.workspace.learning.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PreOrder {
    //https://leetcode.com/problems/binary-tree-preorder-traversal/description/
    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.right = t2;
        t2.left = t3;
        List<Integer> list = preorderTraversal(t1);
        System.out.println(list);

    }

    public static  List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private static void preOrder(TreeNode node, List<Integer> list){

        if(node == null){
            return;
        }
        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

}
