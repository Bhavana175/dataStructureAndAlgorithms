package com.workspace.learning.interviews.goldS.practice.two;

import lombok.Data;

@Data
public class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}
