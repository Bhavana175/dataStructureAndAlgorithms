package com.workspace.learning.algorithms.dailyquetions;

public class SumOfLeftLeave {

    //https://leetcode.com/problems/sum-of-left-leaves/description/?envType=daily-question&envId=2024-04-14

    public static void main(String[] args) {

        SumOfLeftLeave obj = new SumOfLeftLeave();

        //root = [3,9,20,null,null,15,7]

        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.leftNode = n2;
        n1.rightNode = n3;
        n3.leftNode = n4;
        n3.rightNode = n5;

        int output = obj.sumOfLeftLeaves(n1);
        int output1 = obj.sumOfLeftLeaves(n3);
        System.out.println(output);
        System.out.println(output1);
    }

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {

        int sum=0;
        sum = getSum(root, sum);
        return sum;
    }

    private int getSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.leftNode != null &&
                root.leftNode.leftNode == null &&
                root.leftNode.rightNode == null) {

            sum = root.leftNode.val;
        }else {
            sum=0;
        }
        sum += getSum(root.leftNode, sum)+getSum(root.rightNode, sum);

        return sum;
    }

}

class TreeNode {

    int val;

    TreeNode leftNode;

    TreeNode rightNode;

    public TreeNode(int val, TreeNode leftNode, TreeNode rightNode) {
        this.val = val;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }
}
