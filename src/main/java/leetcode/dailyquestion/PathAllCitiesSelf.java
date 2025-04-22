package leetcode.dailyquestion;

import java.util.*;

public class PathAllCitiesSelf {

    public static void main(String[] args) {

        List<String[]> flights = Arrays.asList(
                new String[]{"A", "B"},
                new String[]{"B", "C"},
                new String[]{"C", "D"},
                new String[]{"C", "M"},
                new String[]{"Q", "M"}
        );

        String src = "A";
        System.out.println(isPathAvailableForAllCities(flights,src));
    }

    public static String isPathAvailableForAllCities(List<String[]> flights, String src ){

        //create a graph directed
        // hashset for cities
        //visited to track
        // list<String> for path

        HashMap<String, List<String>> graph = new HashMap<>();
        HashSet<String> cities = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        HashSet<String> vis = new HashSet<>();
        List<String> pathList = new ArrayList<>();

        for(String[] arr : flights){
           graph.computeIfAbsent(arr[0], (k)-> new ArrayList<>()).add(arr[1]);
           cities.add(arr[0]);
           cities.add(arr[1]);
        }

        dfs(graph, src, pathList, vis);

        if(pathList.size()==cities.size()){

            for (String city: pathList){
                sb.append(city+" --> ");
            }

        }else return "NA";

        return sb.toString();
    }

    private static void dfs(HashMap<String, List<String>> graph, String curr, List<String> path, HashSet<String> vis) {

        vis.add(curr);
        path.add(curr);
        if(graph.containsKey(curr)) {
            for (int i = 0; i < graph.get(curr).size(); i++) {
                String neighbour = graph.get(curr).get(i);
                if (!vis.contains(neighbour)) {
                    dfs(graph, neighbour, path, vis);
                }
                vis.remove(curr);
            }
        }
    }
}
