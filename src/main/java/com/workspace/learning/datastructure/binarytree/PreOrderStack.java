package com.workspace.learning.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderStack {

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
        System.out.println(preorderTraversal(t1));

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr!=null){
            stack.push(curr);
            list.add(curr.val);
            curr= curr.left;
        }
        while (!stack.isEmpty()){
            curr = stack.pop();
            if(curr!=null&& curr.right!=null){
                curr = curr.right;
                while (curr!=null){
                    list.add(curr.val);
                    stack.push(curr);
                    curr=curr.left;
                }
            }

        }
            return  list;

    }

    }
