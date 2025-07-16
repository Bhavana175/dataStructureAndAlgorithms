package leetcode.dailyquestion.booking_practice;

import java.util.*;

public class HighestRankedItemsWithinPriceRange_faster_2146 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 0, 1},
                {1, 3, 0, 1},
                {0, 2, 5, 1}
        };
        int[] pricing = {2, 5}, start = {0, 0};
        int k = 3;
        System.out.println(highestRankedKItems(grid, pricing, start, k));
    }

    public static List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {

        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        List<List<Integer>> result = new ArrayList<>();
        Queue<int[]> bfsQueue = new ArrayDeque();
        List<CellInformation> list = new ArrayList<>();
        bfsQueue.offer(start);
        vis[start[0]][start[1]] = true;
        int pathDist = 0;

        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            pathDist++;

            for (int i = 0; i < size; i++) {
                int[] curr = bfsQueue.poll();
                int val = grid[curr[0]][curr[1]];
                if (val > 1 && val >= pricing[0] && val <= pricing[1]) {
                   list.add(new CellInformation(pathDist, val, curr[0], curr[1]));
                }

                int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                for (int[] dir : directions) {
                    int newRow = curr[0] + dir[0];
                    int newCol = curr[1] + dir[1];
                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
                        if (grid[newRow][newCol] != 0 && !vis[newRow][newCol]) {
                            vis[newRow][newCol] = true;
                            bfsQueue.offer(new int[]{newRow, newCol});
                        }
                    }
                }
            }
        }

        list.sort((o1, o2) -> {
            if (o1.getDistance() == o2.getDistance()) {
                if (o1.getPrice() == o2.getPrice()) {
                    if (o1.getRow() == o2.getRow()) {
                        return o1.getCol() - o2.getCol();
                    }
                    return o1.getRow() - o2.getRow();
                }
                return o1.getPrice() - o2.getPrice();
            }
            return o1.getDistance() - o2.getDistance();
        });
        int i=0;
        while (i<list.size() && i < k) {
            CellInformation cellInfo = list.get(i);
            result.add((Arrays.asList(cellInfo.row, cellInfo.col)));
            i++;
        }
        return result;
    }

    static class CellInformation {
        int distance;
        int price;
        int row;
        int col;

        public CellInformation(int distance, int price, int row, int col) {
            this.distance = distance;
            this.price = price;
            this.row = row;
            this.col = col;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }
    }


}
