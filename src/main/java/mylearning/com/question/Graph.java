package mylearning.com.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    public static int assignVertexValues(int N, int[] A, int[] B) {
        // Initialize a map to store the sum of values at each vertex
        Map<Integer, Integer> vertexValues = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            vertexValues.put(i, 0);
        }

        // Iterate through each edge and update the sum of values at its endpoints
        for (int i = 0; i < A.length; i++) {
            vertexValues.put(A[i], vertexValues.get(A[i]) + 1);
            vertexValues.put(B[i], vertexValues.get(B[i]) + 1);
        }

        // Sort the vertices based on their sum of values in descending order
        List<Map.Entry<Integer, Integer>> sortedVertices = new ArrayList<>(vertexValues.entrySet());
        Collections.sort(sortedVertices, (a, b) -> b.getValue() - a.getValue());

        // Assign values to vertices in descending order of their sum of values
        Map<Integer, Integer> assignedValues = new HashMap<>();
        int value = N;
        for (Map.Entry<Integer, Integer> entry : sortedVertices) {
            assignedValues.put(entry.getKey(), value);
            value--;
        }

        // Calculate the sum of values at all edges
        int totalSum = 0;
        for (int i = 0; i < A.length; i++) {
            totalSum += assignedValues.get(A[i]) + assignedValues.get(B[i]);
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int N = 4;
        int[] A = { 1, 3};
        int[] B = {2, 4};
        System.out.println(assignVertexValues(N, A, B));  // Output: 31
    }

}
