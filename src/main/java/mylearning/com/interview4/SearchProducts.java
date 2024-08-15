package mylearning.com.interview4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchProducts {

    /**
     * ubs
     * @param args
     */

    public static void main(String[] args) {

        List<String> products = Arrays.asList("carpet", "cart", "car", "camera", "crate", "cocoa");
        List<String> products2 = Arrays.asList("abcd", "adbc", "abaa", "acbd");
        System.out.println(products);
        System.out.println("camera");
        System.out.println();
        List<List<String>> ans = getProductSuggestions(products, "camera");
        List<List<String>> ans2 = getProductSuggestions(products2, "abad");
        List<List<String>> ans3 = getProductSuggestions(products2, "pqrs");
        System.out.println(ans);
        System.out.println(ans2);
        System.out.println(ans3);

    }

    private static List<List<String>> getProductSuggestions(List<String> products, String str) {

        List<List<String>> suggestions = new ArrayList<>();

        for (int i=1; i<=str.length(); i++) {

            int finalI = i;
            List<String> list = products.stream()
                    .sorted()
                    .filter(product -> product.startsWith(str.substring(0,finalI)))
                    .limit(3)
                    .collect(Collectors.toList());

            suggestions.add(list);
        }



        return suggestions;

    }

}
