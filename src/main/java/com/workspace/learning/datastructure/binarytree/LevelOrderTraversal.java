package com.workspace.learning.datastructure.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    //https://leetcode.com/problems/binary-tree-level-order-traversal/
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.right = t2;
        t2.left = t3;
        List<List<Integer>> list = levelOrder(t1);
        System.out.println(list);
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if(root != null) queue.offer(root);

        while(!queue.isEmpty()){

            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();

            for(int i=0; i<size; i++) {

                TreeNode curr = queue.poll();

                levelList.add(curr.val);

                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);

            }

            list.add(levelList);
        }
        return list;
    }

}
