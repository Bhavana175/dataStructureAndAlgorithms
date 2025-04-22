package leetcode.dailyquestion;



import java.util.ArrayList;
import java.util.List;

public class CompleteComponent2685 {

    public static void main(String[] args) {
       int  n = 6;
       int [][] edges = {{0,1},{0,2},{1,2},{3,4}};
       // Output: 3

        System.out.println(countCompleteComponents(n,edges));
    }


    public  static int countCompleteComponents(int n, int[][] edges) {

        //create graph

        List<Integer> [] graph= new ArrayList[n];
        int countComp =0;
        boolean [] vis = new boolean[n];
        // complete component condition.  edges = v(v-1)/2.

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        for (int i = 0; i < n ; i++) {
            Component comp = new Component(0,0);
            if(!vis[i]){
                dfs(graph, i, vis, comp);
                if(comp.edges == (comp.vertex*(comp.vertex-1))){
                    countComp++;
                }
            }

        }
        return countComp;
    }

    private static void dfs(List<Integer>[] graph, int curr, boolean[] vis, Component comp) {
        vis[curr]= true;
        comp.vertex++;
        for(int i=0; i<graph[curr].size(); i++){
            comp.edges++;
            if(!vis[graph[curr].get(i)]){
                dfs(graph, graph[curr].get(i), vis, comp);
            }
        }
    }


    private static class Component{
        int vertex;
        int edges;

        public Component(int vertex, int edges) {
            this.vertex = vertex;
            this.edges = edges;
        }

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public int getEdges() {
            return edges;
        }

        public void setEdges(int edges) {
            this.edges = edges;
        }
    }
}
