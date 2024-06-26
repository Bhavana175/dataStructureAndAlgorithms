package com.workspace.learning.interviews.jpmorganpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class TableFoodOrder {

    //https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/description/
    public static void main(String[] args) {

        List<List<String>> orders = Arrays.asList(Arrays.asList("Laura", "2", "Bean Burrito"),
                Arrays.asList("Jhon", "2", "Beef Burrito"),
                Arrays.asList("Melissa", "2", "Soda"));
        //  Output: [["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
        System.out.println( displayTable(orders));

        List<List<String>> orders1  =  Arrays.asList(Arrays.asList("David","3","Ceviche"),
                Arrays.asList("Corina","10","Beef Burrito"),Arrays.asList("David","3","Fried Chicken"),
                Arrays.asList("Carla","5","Water"),Arrays.asList("Carla","5","Ceviche"),Arrays.asList("Rous","3","Ceviche"));
        //Output: [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
        System.out.println( displayTable(orders1));

    }

    public static List<List<String>> displayTable(List<List<String>> orders) {

        // list of food items in alphabetical order
        //list of string according to order

        TreeSet<String> mealSet = new TreeSet<>();
        TreeMap<Integer, HashMap<String, Integer>> inputTableMealMap = new TreeMap<>();

        for (int i = 0; i < orders.size(); i++) {
            mealSet.add(orders.get(i).get(2));
            Map<String, Integer> mealCountMap = inputTableMealMap.computeIfAbsent
                    (Integer.valueOf(orders.get(i).get(1)), v -> new HashMap<>());
            mealCountMap.put(orders.get(i).get(2), mealCountMap.getOrDefault(orders.get(i).get(2), 0) + 1);
        }

        List<String> tableAndMealList = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        //add first list
        tableAndMealList.add(0, "Table");
        tableAndMealList.addAll(mealSet);
        result.add(tableAndMealList);

        for (Map.Entry<Integer , HashMap<String, Integer>> tableMapEntry : inputTableMealMap.entrySet()) {
            tableAndMealList = new ArrayList<>();
            tableAndMealList.add(0, String.valueOf(tableMapEntry.getKey()));

                for (int i = 1; i <result.get(0).size() ; i++) {

                    String mealOrdered = result.get(0).get(i);

                    if(tableMapEntry.getValue().containsKey(mealOrdered)){
                        tableAndMealList.add(i, String.valueOf(tableMapEntry.getValue().get(mealOrdered)));
                    }else {
                        tableAndMealList.add(i, "0");
                    }
                }
                result.add(tableAndMealList);
        }
        return result;
    }

}
