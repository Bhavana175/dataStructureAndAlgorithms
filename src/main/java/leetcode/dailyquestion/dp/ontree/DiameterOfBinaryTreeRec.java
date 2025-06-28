package leetcode.dailyquestion.dp.ontree;

import lombok.Data;

public class DiameterOfBinaryTreeRec {
    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(4);
        TreeNode t8 = new TreeNode(4);
        TreeNode t9 = new TreeNode(4);
        TreeNode t10 = new TreeNode(4);
        TreeNode t11 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right =t5;
        t3.left = t7;
        t3.right = t6;
        t7.left = t8;
        t8.right = t10;
        t8.left = t9;

        /*                                  t1
                                      /             \
                                 t2                    t3
                               /   \                 /    \
                             t4     t5             t7       t6
                                                 /    \
                                                t8     t11
                                              /    \
                                            t9      t10

         */


        System.out.println(maxDiameterBetweenTwoLeafNodes(t1));

    }

    private static int maxDiameterBetweenTwoLeafNodes(TreeNode root) {
        int [] res = new int[]{Integer.MIN_VALUE};
        findMaxDiameter(root, res);
        return res[0];
    }

    private static int findMaxDiameter(TreeNode root, int[] res) {
        if(root == null){
            return 0;
        }

        int left = findMaxDiameter(root.left, res);
        int right = findMaxDiameter(root.right, res);

        int temp = 1+ Math.max(left, right);
        int ans = Math.max(temp, left+right+1);
        res[0] = Math.max(res[0], ans);

        return temp;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }

    }

}
