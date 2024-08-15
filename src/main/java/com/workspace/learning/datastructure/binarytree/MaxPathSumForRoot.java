package com.workspace.learning.datastructure.binarytree;

public class MaxPathSumForRoot {
    static int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {


        // Example 1
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(-5);
        root1.left.right = new TreeNode(6);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(-7);
        System.out.println(maxPathSum(root1)); // Output: 6

        // Example 2
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
     //   System.out.println(maxPathSum(root2)); // Output: 42
    }



        public static int maxPathSum(TreeNode root) {
            maxSum = Integer.MIN_VALUE;
            if (root!=null && root.right != null && root.left !=null){
             return root.val +maxGain(root.left)+maxGain(root.right);
            }
            return maxSum;
        }

        private static int maxGain(TreeNode node) {
            if (node == null) {
                return 0;
            }
            // Recursively calculate the maximum contribution from left and right subtrees
            int leftGain = Math.max(maxGain(node.left), 0);
            int rightGain = Math.max(maxGain(node.right), 0);

            return node.val + Math.max(leftGain, rightGain);
        }




}
