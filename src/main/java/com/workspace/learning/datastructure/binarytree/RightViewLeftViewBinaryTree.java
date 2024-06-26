package com.workspace.learning.datastructure.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static com.workspace.learning.datastructure.binarytree.PostOrderWith2Stack.getTreeNode;

public class RightViewLeftViewBinaryTree {

    public static void main(String[] args) {

        //https://leetcode.com/problems/binary-tree-right-side-view/description/
        TreeNode t1 = getTreeNode();
        System.out.println(rightSideView(t1));

    }

    public static List<List<Integer>> rightSideView(TreeNode root) {
        List<Integer> rightViewList = new ArrayList<>();
        List<Integer> leftViewList = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        // level order traversal, add most right node val
        if(root!=null){
          queue.add(root);
        }

        while (!queue.isEmpty()){

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(i==size-1&& node!=null){
                    rightViewList.add(node.val);
                }
                if(i==0&& node!=null){
                    leftViewList.add(node.val);
                }
                if( node!=null && node.left!=null)queue.offer(node.left);
                if( node!=null && node.right!=null)queue.offer(node.right);

            }

        }

        List<List<Integer>> list = new ArrayList<>();
        list.add(leftViewList);
        list.add(rightViewList);

        return list;
    }

}
