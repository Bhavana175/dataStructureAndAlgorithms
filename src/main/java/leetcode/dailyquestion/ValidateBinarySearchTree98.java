package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree98 {

    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;

            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {

        // do inorder traversal if sorted ascending order return true;
        List<Integer> list = new ArrayList<>();
        inOrder(root, list );

        int prev = list.get(0);

        for (int i = 1; i <list.size() ; i++) {

            if(list.get(i)<prev){
                return false;
            }
            prev=list.get(i);
        }

        return true;
    }

    public static void inOrder(TreeNode root, List<Integer> list){

        if(root == null){
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
