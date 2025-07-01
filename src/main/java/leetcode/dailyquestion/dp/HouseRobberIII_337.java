package leetcode.dailyquestion.dp;

public class HouseRobberIII_337 {

    public static void main(String[] args) {

    }

    public int rob(TreeNode root) {

        if(root == null ) return 0;

        int ans = 0;

        if(root.left != null){
            ans += rob(root.left.left)+ rob(root.left.right);
        }
        if(root.right != null){
            ans += rob(root.right.left)+ rob(root.right.right);
        }

        return Math.max(ans+ root.val, rob(root.left)+ rob(root.right));

    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
