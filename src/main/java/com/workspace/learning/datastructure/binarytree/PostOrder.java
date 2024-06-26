package com.workspace.learning.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {
    //https://leetcode.com/problems/binary-tree-postorder-traversal/
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.right = t2;
        t2.left = t3;
        List<Integer> list = postorderTraversal(t1);
        System.out.println(list);

    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }
    private static void postOrder(TreeNode node, List<Integer> list){

        if(node == null){
            return ;
        }

        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);

    }

}
