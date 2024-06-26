package com.workspace.learning.interviews.wanerbrospractice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CitiesPathExist {

    public static void main(String[] args) {

        String[][] cities = {
                {"BLR", "DEL"},
                {"BLR", "HYD"},
                {"BLR", "GOA"},
                {"GOA", "HYD"},
                {"HYD", "BLR"},
                {"DEL", "HYD"},
                {"DEL", "NYC"},
                {"NYC", "LDN"},
                {"LDN", "PARIS"}
        };

        boolean output = wayExists(cities, "BLR", "PARIS");
        System.out.println(output);
        System.out.println(wayExists(cities, "BLR", "ABC"));
        System.out.println(wayExists(cities, "PARIS", "BLR"));
    }

    private static boolean wayExists(String[][] cities, String source, String destination) {

        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        // create adjacency list
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < cities.length; i++) {
            List<String> destList = new ArrayList<>();
            if (map.containsKey(cities[i][0])) {
                destList = map.get(cities[i][0]);
            }
            destList.add(cities[i][1]);
            map.put(cities[i][0], destList);
        }

        if (map.containsKey(source)) {
            queue.add(source);
        } else {
            return false;
        }
        map.forEach((key, value) -> {
            System.out.println(key+ " "+ value);
        });

        // list created check key for source and list of string array index 1 for destination
        // if not found use index1 as source , put inside queue
        // source found add to queue else return false

        while (!queue.isEmpty()) {

            String currSource = queue.poll();
            if (map.containsKey(currSource)) {

                List<String> nextDesList = map.get(currSource);

                for (int i = 0; i < nextDesList.size(); i++) {

                    if (nextDesList.get(i).equals(destination)) {
                        return true;
                    } else {
                        if (visited.add(nextDesList.get(i))) {
                            queue.add(nextDesList.get(i));
                        }
                    }
                }
            }
        }

        return false;
    }

}
