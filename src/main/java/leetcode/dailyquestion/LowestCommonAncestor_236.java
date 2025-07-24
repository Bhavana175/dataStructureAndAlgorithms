package leetcode.dailyquestion;

import lombok.Data;

public class LowestCommonAncestor_236 {
    public static void main(String[] args) {
        /*
        path : 1->2->3->6
        path : 1->2->8->11
        lowest common ancestor of 6 and 11 are 2
        LCA(2,6) ->2;
        LCA(8,6) ->2;
         */

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;
        System.out.println(lowestCommonAncestor(t1, t1, t2));

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // use recursion
        TreeNode curr = root;
        return lca(curr, p, q);
    }

    private static TreeNode lca(TreeNode curr, TreeNode p, TreeNode q) {

        if (curr == null) {
            return null;
        }
        if (curr.val == p.val) {
            return p;
        }
        if (curr.val == q.val) {
            return q;
        }

        TreeNode left = lca(curr.left, p, q);
        TreeNode right = lca(curr.right, p, q);

        if (left != null && right != null) {
            return curr;
        }
        return left != null ? left : right;

    }

    @Data
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
