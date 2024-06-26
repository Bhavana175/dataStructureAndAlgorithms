package com.workspace.learning.datastructure.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxDepth {

    //https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
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
        System.out.println((maxDepth(t1)));
        System.out.println(maxDepthRec(t1));

    }

    public static int maxDepthRec(TreeNode root) {
        if(root==null) return 0;
        int left = maxDepthRec(root.left);
        int right = maxDepthRec(root.right);
        return Math.max(left, right) + 1;
    }

    public static int maxDepth(TreeNode root) {
        int levelCount = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            levelCount++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }
                }
            }
        }
        return levelCount;
    }
}
