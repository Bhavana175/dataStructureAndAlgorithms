package com.workspace.learning.interviews.goldS.practice.two;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class PathExist {

    public static void main(String[] args) {

        String[][] cities = {
                {"BLR", "DEL" },
                {"BLR", "HYD" },
                {"BLR", "GOA" },
                {"GOA", "HYD" },
                {"HYD", "BLR" },
                {"DEL", "HYD" },
                {"DEL", "NYC" },
                {"NYC", "LDN" },
                {"LDN", "PARIS" }
        };

        boolean output = wayExists(cities, "BLR", "PARIS");
        System.out.println(output);
        System.out.println(wayExists(cities, "BLR", "ABC"));
        System.out.println(wayExists(cities, "PARIS", "BLR"));
    }

    private static boolean wayExists(String[][] cities, String source, String destination) {

        //Adjacency list
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < cities.length; i++) {

            List<String> desList = map.computeIfAbsent(cities[i][0], k -> new ArrayList<>());
            desList.add(cities[i][1]);

        }

        Queue<String> queue = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>();

        queue.add(source);

        while (!queue.isEmpty()) {

            String nextSource = queue.poll();

            if (map.containsKey(nextSource)) {

                for (String des : map.get(nextSource)) {

                    if (des.equals(destination)) {
                        return true;
                    } else {
                        if (set.add(des)) {
                            queue.add(des);
                        }
                    }
                }

            }
        }
        return false;
    }

}
