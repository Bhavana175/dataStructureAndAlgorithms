package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//topological sort
public class FindAllPossibleRecipesFromGivenSupply_2115 {
    public static void main(String[] args) {
        String[] recipes = {"bread", "sandwich"};
        List<List<String>> ingredients = Arrays.asList(Arrays.asList("yeast", "flour"), Arrays.asList("bread", "meat"));
        String[] supplies = {"yeast", "flour", "meat"};

        System.out.println(findAllRecipes(recipes, ingredients, supplies));
    }

    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        List<String> output = new ArrayList<>();
        HashSet<String> supplySet = new HashSet<>(List.of(supplies));

        canMake(recipes, 0, ingredients, supplySet, output);

        return output;

    }

    private static boolean canMake(String[] recipes, int index, List<List<String>> ingredients, HashSet<String> supplySet, List<String> output) {

        if (output.contains(recipes[index])) return true;
        if (supplySet.contains(recipes[index])) return true;
        return true;

    }


}
