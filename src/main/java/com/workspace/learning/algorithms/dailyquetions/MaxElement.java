package com.workspace.learning.algorithms.dailyquetions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxElement {

    //interview question
    // input : k=3, arr= ["apple", "orange", "orange", "orange", "orange", "apple", "apple", "apple", "papaya", "papaya", "mango"]
    //output : apple , orange, papaya (top 3 fruit freq occur desc order)

    public static void main(String[] args) {

        int k = 3;
        String[] fruits = {"apple", "orange", "orange", "orange",
                "orange", "apple", "apple", "apple", "papaya", "papaya", "mango"};

        mostFrequentlyFound(fruits,k);
        System.out.println();
        mostFrequentlyFound(fruits,5);
    }

    private static void mostFrequentlyFound(String[] fruits, int k) {

        HashMap<String, Integer> freqMap = new HashMap<>();

        for (String fruit : fruits) {
            freqMap.put(fruit, freqMap.getOrDefault(fruit, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> priorityQueue =
                new PriorityQueue<>((o1,o2)->{
                    if (o2.getValue() - o1.getValue() == 0) {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                    return o2.getValue() - o1.getValue();
                });

        priorityQueue.addAll(freqMap.entrySet());

        for (int i = 0; i < k && !priorityQueue.isEmpty(); i++) {
            System.out.println(priorityQueue.poll());
        }
    }

}
