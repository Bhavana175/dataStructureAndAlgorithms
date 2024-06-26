package com.workspace.learning.interviews.goldS.practice.two;

import java.util.ArrayList;

public class BTS {

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n3.right = n4;

        System.out.println(isBTS(n1));
    }

    private static boolean isBTS(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }

        return true;

    }

    private static void inOrder(TreeNode root, ArrayList<Integer> list) {

        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        System.out.println(root.data);
        list.add(root.data);
        inOrder(root.right, list);
    }

}
