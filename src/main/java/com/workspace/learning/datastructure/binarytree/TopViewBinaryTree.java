package com.workspace.learning.datastructure.binarytree;

import lombok.Data;
import org.antlr.v4.runtime.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import static com.workspace.learning.datastructure.binarytree.PostOrderWith2Stack.getTreeNode;

public class TopViewBinaryTree {

    public static void main(String[] args) {
        TreeNode root = getTreeNode();
        System.out.println(topView(root));
    }
    static ArrayList<Integer> topView(TreeNode root) {
        // add your code
        class Pair {
            private TreeNode node;
            private int hd;
            public Pair(TreeNode node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        Queue<Pair> queue = new ArrayDeque<>();
        TreeMap<Integer, Pair> map = new TreeMap<>();

        if (root!= null){
            queue.offer(new Pair(root,0));
        }
        while (!queue.isEmpty()){

            Pair curr = queue.poll();
            if(curr !=null && curr.node!=null){

                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr);
                }

                if(curr.node.left !=null) queue.add(new Pair(curr.node.left, curr.hd-1));
                if(curr.node.right !=null) queue.add(new Pair(curr.node.right, curr.hd+1));

            }

        }
        ArrayList<Integer> list = new ArrayList<>();

        map.forEach((key, value) -> list.add(value.node.val));

        return list;
    }

}
