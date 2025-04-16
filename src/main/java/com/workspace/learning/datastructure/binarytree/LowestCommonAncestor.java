package com.workspace.learning.datastructure.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
        // leetcode 235, 236
    }

    //Binary Search tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        if (root == null) return null;
        if (p.val > curr.val && q.val > curr.val) {
            return lowestCommonAncestor(curr.right, p,q);
        } else if ( p.val < curr.val && q.val < curr.val) {
            return  lowestCommonAncestor(curr.left, p,q);
        }
        return curr;
    }

    public TreeNode lowestCommonAncestorBinaryTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        // If either key matches with root data, return root
        if (root.val == p.val || root.val == q.val)
            return root;

        // Look for datas in left and right subtrees
        TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLca = lowestCommonAncestor(root.right, p, q);

        // If both of the above calls return Non-NULL, then one
        // data is present in one subtree and the other is present
        // in the other, so this node is the LCA
        if (leftLca != null && rightLca != null)
            return root;

        // Otherwise check if left subtree or right subtree is
        // LCA
        return (leftLca != null) ? leftLca : rightLca;

    }
}
