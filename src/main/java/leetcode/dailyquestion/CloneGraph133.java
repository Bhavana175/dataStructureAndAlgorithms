package leetcode.dailyquestion;

import java.util.*;

public class CloneGraph133 {

    public static void main(String[] args) {

    }

    public Node cloneGraph(Node node) {

        if(node==null) return null;
        Queue<Node> queue = new ArrayDeque<>();
        HashMap<Node, Node> map = new HashMap<>();

        Node clone = new Node(node.val);
        map.put(node, clone);
        queue.add(node);

        while(! queue.isEmpty()){

            Node curr = queue.poll();

            for(Node n: curr.neighbors){

                if(!map.containsKey(n)){
                    map.put(n, new Node(n.val));
                    queue.offer(n);
                }

                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return clone;
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}
