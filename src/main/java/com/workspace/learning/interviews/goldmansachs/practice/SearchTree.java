package com.workspace.learning.interviews.goldmansachs.practice;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SearchTree {
    static class BST  {

        private Node root;

        public BST() {
            this.root = new Node();
        }

        public void put(int value) {
            // TODO: implement me
        }

        public boolean contains(int value) {
            // TODO: implement me
            return false;
        }

        public List<Integer> inOrderTraversal() {
            final ArrayList<Integer> acc = new ArrayList<>();
            inOrderTraversal(root, acc);
            return acc;
        }

        private void inOrderTraversal(Node node, List<Integer> acc) {
            if (node == null) {
                return;
            }
            inOrderTraversal(node.left, acc);
            inOrderTraversal(node.right, acc);
            acc.add(node.val);
        }

        private static class Node {
            Integer val;
            Node left;
            Node right;
        }
    }


    @Test
    public void testBST() throws Exception {
        final BST searchTree = new BST();

        searchTree.put(3);
        searchTree.put(1);
        searchTree.put(2);
        searchTree.put(5);

        assertFalse(searchTree.contains(0));
        assertTrue(searchTree.contains(1));
        assertTrue(searchTree.contains(2));
        assertTrue(searchTree.contains(3));
        assertFalse(searchTree.contains(4));
        assertTrue(searchTree.contains(5));
        assertFalse(searchTree.contains(6));

        assertEquals(Arrays.asList(1,2,3,5), searchTree.inOrderTraversal());
    }

    // TODO: write some more tests

    public static void main(String[] args) {
        JUnitCore.main("SearchTree");
    }
}
