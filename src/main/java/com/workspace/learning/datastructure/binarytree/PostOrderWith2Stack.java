package com.workspace.learning.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderWith2Stack {

    public static void main(String[] args) {
        TreeNode t1 = getTreeNode();
        System.out.println(postorderTraversal(t1));

    }

    public static TreeNode getTreeNode() {
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
        return t1;
    }

    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode curr = root;
        if (curr!=null){
            stack1.push(curr);
        }
        while (!stack1.isEmpty()){
            curr = stack1.pop();
            stack2.push(curr);
            if(curr.left!=null){stack1.push(curr.left);}
            if(curr.right!=null){stack1.push(curr.right);}
        }
        while (!stack2.isEmpty()){
        list.add(stack2.pop().val);
        }

        return  list;
    }

}
