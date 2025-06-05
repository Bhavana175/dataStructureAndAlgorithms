package lld.gametictactoe;

import java.util.ArrayDeque;
import java.util.Deque;


public class Main {

    public static void main(String[] args) {


        Board board = new Board(3);
        PlayerO p1 = new PlayerO("Sneh");
        PlayerX p2 = new PlayerX("Bhavana");

        Deque<Players> playersList = new ArrayDeque<>();
        playersList.add(p1);
        playersList.add(p2);

        Game game = new Game(board, playersList);

        System.out.println(game.startGame());

    }
}
