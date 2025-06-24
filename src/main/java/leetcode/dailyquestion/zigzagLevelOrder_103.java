package leetcode.dailyquestion;

import java.util.*;

public class zigzagLevelOrder_103 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            level++;
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (currNode != null) {
                    levelList.add(currNode.val);
                    if (currNode.left != null) queue.offer(currNode.left);
                    if (currNode.right != null) queue.offer(currNode.right);
                }
            }
            if (level % 2 == 1) {
                Collections.reverse(levelList);
            }
            result.add(levelList);

        }


        return result;
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
}
