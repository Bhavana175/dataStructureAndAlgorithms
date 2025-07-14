package leetcode.dailyquestion;


import java.util.HashSet;

public class BinaryTreeCamera_968 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t1.left = t2;
        t2.left = t3;
        t2.right = t4;

        System.out.println(minCameraCover(t1));

    }

    public static int minCameraCover(TreeNode root) {
        //leaf node pr nhi chahiye camera , hashset to maintain camera covered node
        HashSet<TreeNode> cameraCoveredSet = new HashSet<>();
        cameraCoveredSet.add(null);
        int [] arr = new int [1];
        rec(cameraCoveredSet, root, null, arr);
        return arr[0];
    }

    private static void rec(HashSet<TreeNode> cameraCoveredSet, TreeNode currNode, TreeNode parent, int[] arr) {

        if(currNode == null){
            return;
        }

        rec(cameraCoveredSet, currNode.left, currNode, arr);
        rec(cameraCoveredSet, currNode.right, currNode, arr);

        if((parent == null && !cameraCoveredSet.contains(currNode)) ||
                !cameraCoveredSet.contains(currNode.left) || !cameraCoveredSet.contains(currNode.right)){

            arr[0]++;
            cameraCoveredSet.add(currNode);
            cameraCoveredSet.add(parent);
            cameraCoveredSet.add(currNode.left);
            cameraCoveredSet.add(currNode.right);

        }

    }

    private static class TreeNode {
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
