package leetcode.dailyquestion.dp.ontree;

public class MaxiPathSumFromAnyNode {
    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(-10);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(-10);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(10);
        TreeNode t8 = new TreeNode(-20);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(-1);
        TreeNode t11 = new TreeNode(10);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t7;
        t3.right = t6;
        t7.left = t8;
        t7.right = t11;
        t8.right = t10;
        t8.left = t9;

        /*                                  t1:10
                                      /             \
                                 t2:10                   t3:10
                               /   \                 /    \
                             t4:4     t5:10         t7:10      t6:6
                                                 /    \
                                             t8:-20  t11:10
                                              /    \
                                            t9:9  t10:-1

         */

        System.out.println(findMaxSumFromAnyNode(t1));
    }

    private static int findMaxSumFromAnyNode(TreeNode root) {

        int[] sum = {Integer.MIN_VALUE};
        findMaxPathSum(root, sum);
        return sum[0];
    }

    private static int findMaxPathSum(TreeNode root, int[] sum) {

        if(root== null){
            return 0;
        }

        int left = findMaxPathSum(root.left, sum);
        int right = findMaxPathSum(root.right, sum);

        int maxSumForCurrNodeOneBranch = Math.max(root.val, Math.max(left, right)+root.val);
        int ans = Math.max(maxSumForCurrNodeOneBranch, root.val+left+right);
        sum[0] = Math.max(ans, sum[0]);

        return maxSumForCurrNodeOneBranch;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

    }
}
