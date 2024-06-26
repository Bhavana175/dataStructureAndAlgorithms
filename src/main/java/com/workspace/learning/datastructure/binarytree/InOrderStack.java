package com.workspace.learning.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderStack {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        //[1, null, 2, 3, null, 4,5]

        t1.right = t2;
        t1.left = t6;
        t6.left = t7;
        t6.right = t8;
        t2.left = t3;
        t3.left = t4;
        t3.right = t5;
        List<Integer> list = inorderTraversal(t1);
        System.out.println(list);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        if(curr!=null) {
            stack.push(curr);
        }
        while (curr!=null && curr.left!= null){
            curr= curr.left;
            stack.push(curr);
        }
        while (!stack.isEmpty()){
            curr = stack.pop();
            list.add(curr.val);
            if(curr.right != null){
                curr = curr.right;
                stack.push(curr);
                while (curr.left!= null){
                    curr= curr.left;
                    stack.push(curr);
                }
            }

        }
        return list;
    }
}
