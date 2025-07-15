package leetcode.dailyquestion.graph;

import java.util.*;

public class FindAllPossibleRecipe_2115 {
    public static void main(String[] args) {
        String[] recipes = {"bread", "sandwich"};
        List<List<String>> ingredients = Arrays.asList(Arrays.asList("yeast", "flour"), Arrays.asList("bread", "meat"));
        String[] supplies = {"yeast", "flour", "meat"};

        System.out.println(findAllRecipes(recipes, ingredients, supplies));
    }

    public static  List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        HashMap<String, Integer> inDegree = new HashMap<>();
        HashMap<String, List<String>> graph = new HashMap<>();
        HashSet<String> supplySet = new HashSet<>(Arrays.asList(supplies));
        Queue<String> queue = new ArrayDeque<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < recipes.length; i++) {
            inDegree.put(recipes[i],0);
            for (int j = 0; j < ingredients.get(i).size(); j++) {
                String ingredient = ingredients.get(i).get(j);
                if(!supplySet.contains(ingredient)){
                    inDegree.put(recipes[i], inDegree.get(recipes[i])+1);
                    graph.computeIfAbsent(ingredient, (k)->new ArrayList<>()).add(recipes[i]);
                }
            }
        }

        for (int i = 0; i < recipes.length; i++) {
            if(inDegree.get(recipes[i])==0){
                queue.offer(recipes[i]);
            }
        }

        while (!queue.isEmpty()){
            String currRecipe = queue.poll();
            result.add(currRecipe);
            for (int i = 0; graph.containsKey(currRecipe) && i < graph.get(currRecipe).size(); i++) {
                String nextRecipe = graph.get(currRecipe).get(i);
                inDegree.put(nextRecipe, inDegree.get(nextRecipe)-1);
                if(inDegree.get(nextRecipe)==0){
                    queue.offer(nextRecipe);
                }
            }
        }
        return  result;
    }
}