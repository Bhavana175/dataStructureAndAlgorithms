package mylearning.com.question.binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class BinaryTreeInfectedTime {

    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode nine = new TreeNode(9);
        TreeNode ten = new TreeNode(10);

        one.left = five;
        one.right = three;
        three.left = ten;
        three.right = six;
        five.right = four;
        four.left = nine;
        four.right = two;

        BinaryTreeInfectedTime obj = new BinaryTreeInfectedTime();
        System.out.println(" time required : " + obj.amountOfTime(one, 3));

    }

    public int amountOfTime(TreeNode root, int start) {
        int time = 0;

        HashMap<Integer, ArrayList<Integer>> treeMap = new HashMap<>();
        getTreeMap(root, treeMap);
        Deque<ArrayList<Integer>> fifoQueue = new ArrayDeque<>();


        fifoQueue.addFirst(treeMap.get(start));



        return time;
    }

    private void getTreeMap(TreeNode root, HashMap<Integer, ArrayList<Integer>> treeMap) {
        ArrayList<Integer> list = new ArrayList<>();
       int index =0;
        if (root != null) {
            list.add(index, root.val);
            if (root.left != null) {
                index++;
                list.add(index, root.left.val);
                getTreeMap(root.left,treeMap );
            }
            if (root.right != null) {
                index++;
                list.add(index, root.right.val);
                getTreeMap(root.right,treeMap );
            }
            treeMap.put(root.val, list);
        }

}

}
