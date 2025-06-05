package lld.gametictactoe;

import java.util.Deque;
import java.util.Scanner;

public class Game {

    Deque<Players> players;
    Board board;

    public Game(Board board, Deque<Players> players) {
        this.board = board;
        this.players = players;
    }

    boolean noWinner = true;

    public String startGame() {

        while (noWinner) {

            //free cells
            if(!freeCells()){
                noWinner = false;
                continue;
            }

            Players p1 = players.removeFirst();
            System.out.println("Please input row,col "+p1.name);
            // read input
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();

            String[] split = s.split(",");
            int row = Integer.parseInt(split[0]);
            int col = Integer.parseInt(split[1]);

            if (board.playerBoard[row][col] != null) {
                //wrong place
                System.out.println("Please select correct row,col " + p1.name);
                players.addFirst(p1);
                continue;
            } else {
                board.playerBoard[row][col] = p1.type;
                players.addLast(p1);
            }
            displayGrid();
            if(checkForWinner(row, col, p1)){
                System.out.println("WINNER "+p1.name);
                return p1.name;
            }
        }
        return "tie";
    }

    private boolean freeCells() {
        for (int i = 0; i < board.size; i++) {
            for (int j = 0; j < board.size; j++) {
                if(board.playerBoard[i][j]== null){
                    return true;
                }
            }
        }
        return false;
    }

    private void displayGrid() {
        for (int i = 0; i < board.size; i++) {
            for (int j = 0; j < board.size; j++) {
                if (board.playerBoard[i][j] != null) {
                    System.out.print(board.playerBoard[i][j]);
                } else {
                    System.out.print(" ");
                }
                if (j != board.size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    private boolean checkForWinner(int row, int col, Players players) {
        boolean rowMatched = true;
        boolean colMatched = true;
        boolean diagonalMatched = true;
        boolean antiDiagonalMatched = true;
        // row
        for (int i = 0; i < board.size; i++) {
            if (board.playerBoard[row][i] == null || board.playerBoard[row][i] != players.type) {
                rowMatched = false;
            }
        }
        //col
        for (int i = 0; i < board.size; i++) {
            if (board.playerBoard[i][col] == null || board.playerBoard[i][col] != players.type) {
                colMatched = false;
            }
        }
        // diagonal
        for (int i = 0, j=0 ; i < board.size && j< board.size; i++ , j++) {
            if (board.playerBoard[i][j] == null || board.playerBoard[i][j] != players.type) {
                diagonalMatched = false;
            }
        }

        for (int i = 0, j= board.size-1 ; i < board.size && 0<= j; i++ , j--) {
            if (board.playerBoard[i][j] == null || board.playerBoard[i][j] != players.type) {
                antiDiagonalMatched = false;
            }
        }

        return rowMatched || colMatched || diagonalMatched || antiDiagonalMatched;
    }

}
