package leetcode.dailyquestion.practice.amazon.codinground;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        HashMap<Integer, List<String>> items = new HashMap<>();
        items.put(1, Arrays.asList("Action", "Comedy", "Romance"));
        items.put(2, Arrays.asList("Action", "Comedy"));
        items.put(3, Arrays.asList("Action"));
        items.put(4, Arrays.asList("Action"));
        items.put(15, Arrays.asList("Action"));
        items.put(16, Arrays.asList("Action"));
        items.put(20, Arrays.asList("Action"));
        items.put(5, Arrays.asList("Comedy"));
        items.put(6, Arrays.asList("Comedy"));
        items.put(7, Arrays.asList("Comedy", "Romance"));
        items.put(8, Arrays.asList("ABC", "XYZ"));
        items.put(9, Arrays.asList("ABC"));

        List<Integer> userHistory = new ArrayList<>();
        userHistory.add(1);
        userHistory.add(2);
        userHistory.add(3);

        System.out.println(recommendation(items, userHistory, 3));
    }

    public static HashSet<Integer> recommendation(HashMap<Integer, List<String>> items, List<Integer> userHistory, int target) {

        HashMap<String, List<Integer>> genreVsItemList = new HashMap<>();
        HashSet<String> watchedGenre = new HashSet<>();
        HashSet<Integer> watchedItemIds = new HashSet<>();
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        HashMap<String, Integer> genreVsFreq = new HashMap<>();

        HashSet<Integer> result = new HashSet<>();

        for (int item : items.keySet()) {
            List<String> genreList = items.get(item);
            for (String genre : genreList) {
                genreVsItemList.computeIfAbsent(genre, (k) -> new ArrayList<>()).add(item);
            }
        }

        for (int id : userHistory) {
            List<String> watchedGenreList = items.getOrDefault(id, new ArrayList<>());
            watchedGenre.addAll(watchedGenreList);
            watchedItemIds.add(id);
            for (String eachGenre : watchedGenreList) {
                genreVsFreq.put(eachGenre, genreVsFreq.getOrDefault(eachGenre, 0) + 1);
            }
        }

        priorityQueue.addAll(genreVsFreq.entrySet());

        while (!priorityQueue.isEmpty()) {
            List<Integer> list = genreVsItemList.getOrDefault(priorityQueue.poll().getKey(), new ArrayList<>());
            for (int id : list) {
                if (!watchedItemIds.contains(id) && result.size()< target) {
                    result.add(id);
                }
            }
        }

       /* for (String eachWatchedGenre: watchedGenre){
            List<Integer> list = genreVsItemList.getOrDefault(eachWatchedGenre, new ArrayList<>());
            for (int id: list){
                if(!watchedItemIds.contains(id)){
                    result.add(id);
                }
            }
        }*/
        return result;
    }

}
