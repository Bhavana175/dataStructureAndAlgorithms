package mylearning.com.interviewMicrosoft;

import java.util.Stack;

public class ABC {

    public static void main(String[] args) {

    }

    public int solution(int[][] Board) {
        // Implement your solution here

        int n = Board.length, m = Board[0].length;
        int maxInteger = Integer.MIN_VALUE, count = 0;

        Stack<Integer> stack = new Stack<>();
        boolean[][] visited = new boolean[n][m];

        StringBuilder digitString;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (Board[i][j] > 0 && !visited[i][j]) {

                    stack.push(Board[i][j]);
                    digitString = new StringBuilder(Board[i][j]);
                    while (!stack.isEmpty()) {

                        //digit logic to find max number

                        if (!visited[i + 1][j] && i + 1 < n) {
                            digitString = digitString.append(Board[i + 1][j]);
                            stack.push(Board[i + 1][j]);
                        }
                        if (!visited[i - 1][j] && i - 1 >= 0) {
                            digitString = digitString.append(Board[i - 1][j]);
                            stack.push(Board[i - 1][j]);
                        }
                        if (!visited[i][j] && i + 1 < n && j < m) {
                            digitString = digitString.append(Board[i + 1][j]);
                            stack.push(Board[i + 1][j]);
                        }
                        if (!visited[i + 1][j] && i + 1 < n && j < m) {
                            digitString = digitString.append(Board[i + 1][j]);
                            stack.push(Board[i + 1][j]);
                        }

                    }
                }
            }

        }

        return 0;

    }
}
